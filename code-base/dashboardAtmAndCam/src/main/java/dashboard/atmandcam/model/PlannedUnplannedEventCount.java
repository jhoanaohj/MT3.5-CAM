package dashboard.atmandcam.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

@SqlResultSetMapping(name = "plannedUnplannedEventResult", classes = {
		@ConstructorResult(targetClass = dashboard.atmandcam.model.PlannedUnplannedEventCount.class, columns= {
				@ColumnResult(name = "event_description", type = String.class),
				@ColumnResult(name = "event_count", type = Integer.class)
		})
})

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "GetPlannedSingleResult.getData",
			query = "SELECT event_description, COUNT(*) as event_count\r\n" + 
					"FROM dashboard.event\r\n" + 
					"WHERE planned = 'PLANNED'\r\n" + 
					"AND cast(event_start_adj AS DATE) = ?1\r\n" + 
					"AND terminal_id IN(SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')\r\n" + 
					"GROUP BY event_description\r\n" + 
					"ORDER BY event_count DESC",
			resultSetMapping = "plannedUnplannedEventResult"
			),
	@NamedNativeQuery(
			name = "GetPlannedRangeResult.getData",
			query = "SELECT event_description, COUNT(*) as event_count\r\n" + 
					"FROM dashboard.event\r\n" + 
					"WHERE planned = 'PLANNED'\r\n" + 
					"AND cast(event_start_adj AS DATE) BETWEEN ?1 AND ?2\r\n" + 
					"AND terminal_id IN(SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')\r\n" + 
					"GROUP BY event_description\r\n" + 
					"ORDER BY event_count DESC",
			resultSetMapping = "plannedUnplannedEventResult"
			),
	@NamedNativeQuery(
			name = "GetUnplannedSingleResult.getData",
			query = "SELECT event_description, COUNT(*) as event_count\r\n" + 
					"FROM dashboard.event\r\n" + 
					"WHERE planned = 'UNPLANNED'\r\n" + 
					"AND cast(event_start_adj AS DATE) = ?1\r\n" + 
					"AND terminal_id IN(SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')\r\n" + 
					"GROUP BY event_description\r\n" + 
					"ORDER BY event_count DESC",
			resultSetMapping = "plannedUnplannedEventResult"
			),
	@NamedNativeQuery(
			name = "GetUnplannedRangedResult.getData",
			query = "SELECT event_description, COUNT(*) as event_count\r\n" + 
					"FROM dashboard.event\r\n" + 
					"WHERE planned = 'UNPLANNED'\r\n" + 
					"AND cast(event_start_adj AS DATE) BETWEEN ?1 AND ?2\r\n" + 
					"AND terminal_id IN(SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')\r\n" + 
					"GROUP BY event_description\r\n" + 
					"ORDER BY event_count DESC",
			resultSetMapping = "plannedUnplannedEventResult"
			)
})


@Entity
public class PlannedUnplannedEventCount {

	@Id
	public int id;
	
	@JsonProperty("event_description")
	private String eventDescription;
	
	@JsonProperty("event_count")
	private int eventCount;
	
	public PlannedUnplannedEventCount(String eventDescr, int eventCtr) {
		super();
		this.eventDescription = eventDescr;
		this.eventCount = eventCtr;
	}
	
	public PlannedUnplannedEventCount() {}
	
}
