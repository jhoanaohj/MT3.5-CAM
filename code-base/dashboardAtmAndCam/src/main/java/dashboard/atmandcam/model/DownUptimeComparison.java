package dashboard.atmandcam.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

@SqlResultSetMapping(name = "upDownPercentValues", classes = {
		@ConstructorResult(targetClass = dashboard.atmandcam.model.DownUptimeComparison.class, columns = {
				@ColumnResult(name = "columns_percent", type = String.class),
				@ColumnResult(name = "percentage_result", type = Double.class) 
				}) 
		})

@NamedNativeQueries({
		@NamedNativeQuery(name = "GetUpVersusDownSinglePercentage.getData", 
				query = "SELECT\r\n" + 
						"   unnest(array['Down Time','Up time']) AS columns_percent,\r\n" + 
						"   unnest(array[downtime_percent, uptime_percent]) AS percentage_result \r\n" + 
						"FROM(\r\n" + 
						"	SELECT\r\n" + 
						"		ROUND(AVG(da.availability_percentage)\r\n" + 
						"		  	FILTER (WHERE da.availability_date = ?1 AND duration_sec < 3600 AND availability_percentage < 95) , 2) AS downtime_percent,\r\n" + 
						"		ROUND(AVG(da.availability_percentage)\r\n" + 
						"		  	FILTER (WHERE da.availability_date = ?1 AND duration_sec < 3600 AND availability_percentage >= 95), 2) AS uptime_percent\r\n" + 
						"	FROM dashboard.availability da\r\n" + 
						"	)t", 
				resultSetMapping = "upDownPercentValues"),

		@NamedNativeQuery(name = "GetUpVersusDownRangedPercentage.getData", 
		query = "SELECT\r\n" + 
				"   unnest(array['Down Time','Up time']) AS columns_percent,\r\n" + 
				"   unnest(array[downtime_percent, uptime_percent]) AS percentage_result\r\n" + 
				"FROM(\r\n" + 
				"	SELECT\r\n" + 
				"		ROUND(AVG(da.availability_percentage)\r\n" + 
				"		  	FILTER (WHERE da.availability_date BETWEEN ?1 AND ?2 AND duration_sec < 3600 AND availability_percentage < 95) , 2) AS downtime_percent,\r\n" + 
				"		ROUND(AVG(da.availability_percentage)\r\n" + 
				"		  	FILTER (WHERE da.availability_date BETWEEN ?1 AND ?2 AND duration_sec < 3600 AND availability_percentage >= 95), 2) AS uptime_percent\r\n" + 
				"	FROM dashboard.availability da\r\n" + 
				"	)t", 
				resultSetMapping = "upDownPercentValues") 
		})

@Entity
public class DownUptimeComparison {

	@Id
	private int id;
	
	@JsonProperty("columns_percent")
	private String columnsPercent;
	
	@JsonProperty("percentage_result")
	private double percentageResult;
	
	public DownUptimeComparison(String colPercent, double percentRes) {
		super();
		this.columnsPercent = colPercent;
		this.percentageResult = percentRes;
	}
	
	public DownUptimeComparison() {}
	
}
