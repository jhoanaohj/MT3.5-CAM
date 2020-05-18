package dashboard.atmandcam.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

@SqlResultSetMapping(name = "plannedUnplannedResult", classes = {
		@ConstructorResult(targetClass = dashboard.atmandcam.model.AvailabilityPlannedUnplanned.class, columns = {
				@ColumnResult(name = "planned", type = String.class),
				@ColumnResult(name = "results", type = Double.class) 
				}) 
		})

@NamedNativeQueries({
		@NamedNativeQuery(name = "GetPlannedUnplannedSingle.getData", 
				query = "SELECT\r\n" + 
						"unnest(array['Planned', 'Unplanned']) AS planned,\r\n" + 
						"unnest(array[planned, unplanned]) AS results\r\n" + 
						"FROM(\r\n" + 
						"SELECT\r\n" + 
						"ROUND((count(*) filter (where planned = 'PLANNED') / cast(count(*) as decimal) * 100),2) as planned,\r\n" + 
						"ROUND((count(*) filter (where planned = 'UNPLANNED') / cast(count(*) as decimal) * 100),2) as unplanned\r\n" + 
						"FROM dashboard.event\r\n" + 
						"WHERE cast(event_start_adj AS DATE) = ?1\r\n" + 
						")t", 
				resultSetMapping = "plannedUnplannedResult"),

		@NamedNativeQuery(name = "GetPlannedUnplannedRanged.getData", 
		query = "SELECT\r\n" + 
				"unnest(array['Planned', 'Unplanned']) AS planned,\r\n" + 
				"unnest(array[planned, unplanned]) AS results\r\n" + 
				"FROM(\r\n" + 
				"SELECT\r\n" + 
				"ROUND((count(*) filter (where planned = 'PLANNED') / cast(count(*) as decimal) * 100),2) as planned,\r\n" + 
				"ROUND((count(*) filter (where planned = 'UNPLANNED') / cast(count(*) as decimal) * 100),2) as unplanned\r\n" + 
				"FROM dashboard.event\r\n" + 
				"WHERE cast(event_start_adj AS DATE) BETWEEN ?1 AND ?2 \r\n" + 
				")t", 
				resultSetMapping = "plannedUnplannedResult") 
		})

@Entity
public class AvailabilityPlannedUnplanned {

	@Id
	public Long id;

	@JsonProperty("planned")
	private String plans;

	@JsonProperty("result")
	private double results;

	public AvailabilityPlannedUnplanned(String planned, double results) {
		super();
		this.plans = planned;
		this.results = results;
	}

	public AvailabilityPlannedUnplanned() {
	}

}
