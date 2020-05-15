package dashboard.atmandcam.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

@SqlResultSetMapping(name = "perMonthResult", classes = {
		@ConstructorResult(targetClass = dashboard.atmandcam.model.AvailabilityPerMonth.class, columns = {
				@ColumnResult(name = "months", type = String.class),
				@ColumnResult(name = "availability_percent", type = Double.class)
		})
})

@NamedNativeQueries({
	@NamedNativeQuery(name = "GetPerMonthAvailability.getData",
			query = "SELECT\r\n" + 
					"   unnest(array['last Month', 'current Month', 'next Month']) AS months,\r\n" + 
					"   unnest(array[lastMonth, currMonth, nextMonth]) AS availability_Percent\r\n" + 
					"FROM(\r\n" + 
					"	SELECT\r\n" + 
					"		ROUND(AVG(availability_percentage)\r\n" + 
					"		   FILTER (WHERE availability_date BETWEEN ?1 AND ?2) , 2) AS lastMonth,\r\n" + 
					"		ROUND(AVG(availability_percentage)\r\n" + 
					"		   FILTER (WHERE availability_date BETWEEN ?3 AND ?4), 2) AS currMonth,\r\n" + 
					"		ROUND(AVG(availability_percentage)\r\n" + 
					"			 FILTER(WHERE availability_date BETWEEN ?5 AND ?6),2) AS nextMonth\r\n" + 
					"	FROM dashboard.availability\r\n" + 
					"	)t",
					resultSetMapping = "perMonthResult"
			)
})

@Entity
public class AvailabilityPerMonth {

	@Id
	private int id;
	
	@JsonProperty("months")
	private String months;
	
	@JsonProperty("availability_percent")
	private double availabilityPercent;
	
	public AvailabilityPerMonth(String mon, double availPercent) {
		super();
		this.months = mon;
		this.availabilityPercent = availPercent;
	}
	
	public AvailabilityPerMonth() {}
}
