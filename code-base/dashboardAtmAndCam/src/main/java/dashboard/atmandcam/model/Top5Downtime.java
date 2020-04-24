package dashboard.atmandcam.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

@SqlResultSetMapping(name = "topDownResult", classes = {
		@ConstructorResult(targetClass = dashboard.atmandcam.model.Top5Downtime.class, columns= {
				@ColumnResult(name = "event_description", type = String.class),
				@ColumnResult(name = "error_count", type = Integer.class)
		})
})

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "GetTopDowntime.getData",
			query = "SELECT event_description, COUNT(*) AS error_count "
					+ "FROM dashboard.down_event "
					+ "WHERE down_date = ?1 "
					+ "AND terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')"
					+ "GROUP BY event_description ORDER BY error_count DESC",
			resultSetMapping = "topDownResult"
			),
	@NamedNativeQuery(
			name = "GetTopRangeDowntime.getData",
			query = "SELECT event_description, COUNT(*) AS error_count "
					+ "FROM dashboard.down_event "
					+ "WHERE down_date BETWEEN ?1 AND ?2 "
					+ "AND terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')"
					+ "GROUP BY event_description ORDER BY error_count DESC",
			resultSetMapping = "topDownResult"
			)
})


@Entity
public class Top5Downtime {
	
	@Id
	public int id;
	
	@JsonProperty("event_description")
	private String eventDescription;
	
	@JsonProperty("error_count")
	private int errorCount;
	
	public Top5Downtime(String eventDesc, int errorCtr) {
		super();
		this.eventDescription = eventDesc;
		this.errorCount = errorCtr;
	}
	
	public Top5Downtime() {
		
	}
}
