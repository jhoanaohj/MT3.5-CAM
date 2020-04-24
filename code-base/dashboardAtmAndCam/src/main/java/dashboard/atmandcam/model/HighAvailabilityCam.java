package dashboard.atmandcam.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

@SqlResultSetMapping(name = "highAvailResult", classes = {
		@ConstructorResult(targetClass = dashboard.atmandcam.model.HighAvailabilityCam.class, columns = {
				@ColumnResult(name = "region_iso_code", type = String.class),
				@ColumnResult(name = "total_up_percentage", type = Double.class)
		})
})

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "GetRangeHighAvail.getData",
			query = "SELECT t.region_iso_code, t.total_up_percentage\r\n" + 
					"FROM(\r\n" + 
					"	SELECT di.region_iso_code,(ROUND(AVG(da.availability_percentage),2)) AS total_up_percentage\r\n" + 
					"	FROM dashboard.availability da\r\n" + 
					"	INNER JOIN dashboard.inventory di ON da.terminal_id = di.terminal_id\r\n" + 
					"	WHERE di.machine_type = 'CAM'\r\n" + 
					"	AND da.availability_date BETWEEN ?1 AND ?2 \r\n" + 
					"	GROUP BY di.region_iso_code\r\n" + 
					")t\r\n" + 
					"WHERE t.total_up_percentage >= 95",
			resultSetMapping = "highAvailResult"
			),
	@NamedNativeQuery(
			name = "GetHighAvail.getData",
			query = "SELECT t.region_iso_code, t.total_up_percentage\r\n" + 
					"FROM(\r\n" + 
					"	SELECT di.region_iso_code,(ROUND(AVG(da.availability_percentage),2)) AS total_up_percentage\r\n" + 
					"	FROM dashboard.availability da\r\n" + 
					"	INNER JOIN dashboard.inventory di ON da.terminal_id = di.terminal_id\r\n" + 
					"	WHERE di.machine_type = 'CAM'\r\n" + 
					"	AND da.availability_date = ?1 \r\n" + 
					"	GROUP BY di.region_iso_code\r\n" + 
					")t\r\n" + 
					"WHERE t.total_up_percentage >= 95",
			resultSetMapping = "highAvailResult"
			)
})
@Entity
public class HighAvailabilityCam {

	@Id
	private Long id;
	
	@JsonProperty("region_iso_code")
	private String regionIsoCode;
	
	@JsonProperty("total_up_percentage")
	private double totalUpPercentage;
	
	public HighAvailabilityCam(String regionIsocode, double totalUpPercentage) {
		super();
		this.regionIsoCode = regionIsocode;
		this.totalUpPercentage = totalUpPercentage;
	}
	
	public HighAvailabilityCam() { }
}
