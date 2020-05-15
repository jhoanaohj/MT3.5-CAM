package dashboard.atmandcam.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

@SqlResultSetMapping(name = "perHourResultLine", classes = {
		@ConstructorResult(targetClass = dashboard.atmandcam.model.AvailabilityPerHourLineChart.class, columns = {
				@ColumnResult(name = "availability_time", type = String.class),
				@ColumnResult(name = "total_hour_percentage", type = Double.class) }) })

@NamedNativeQueries({
		@NamedNativeQuery(name = "GetRangeHourResultLine.getData", 
				query = "SELECT da.availability_time, (ROUND(AVG(da.availability_percentage),2)) AS total_hour_percentage\r\n"
				+ "	FROM dashboard.availability da\r\n"
				+ "	INNER JOIN dashboard.inventory di ON da.terminal_id = di.terminal_id\r\n"
				+ "	WHERE di.machine_type = 'CAM'\r\n" + "	AND da.availability_date BETWEEN ?1 AND ?2\r\n"
				+ "	GROUP BY da.availability_time \r\n"
				+ "ORDER BY da.availability_time ASC", 
				resultSetMapping = "perHourResultLine"),
		
		@NamedNativeQuery(name = "GetDefaultHourResultLine.getData", 
		query = "SELECT da.availability_time, (ROUND(AVG(da.availability_percentage),2)) AS total_hour_percentage\r\n"
				+ "	FROM dashboard.availability da\r\n"
				+ "	INNER JOIN dashboard.inventory di ON da.terminal_id = di.terminal_id\r\n"
				+ "	WHERE di.machine_type = 'CAM'\r\n" + "	AND da.availability_date =?1 \r\n"
				+ "	GROUP BY da.availability_time\r\n"
				+ " ORDER BY da.availability_time ASC", 
				resultSetMapping = "perHourResultLine") })

@Entity
public class AvailabilityPerHourLineChart {

	@Id
	public int id;

	@JsonProperty("availability_time")
	private String availabilityTime;

	@JsonProperty("total_hour_percentage")
	private double totalHourPercentage;

	public AvailabilityPerHourLineChart(String availTime, double totalHourPercent) {
		super();
		this.availabilityTime = availTime;
		this.totalHourPercentage = totalHourPercent;
	}

	public AvailabilityPerHourLineChart() {
	}

}
