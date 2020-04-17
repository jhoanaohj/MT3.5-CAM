package dashboard.atmandcam.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

@SqlResultSetMapping(name = "top5Result", classes = {
		@ConstructorResult(targetClass = dashboard.atmandcam.model.Top5Downtime.class, columns= {
				@ColumnResult(name = "event_description", type = String.class),
				@ColumnResult(name = "error_count", type = Integer.class)
		})
})

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "GetTop5Downtime.getData",
			query = "SELECT event_description, COUNT(*) AS error_count FROM dashboard.event WHERE terminal_id IN(\r\n" + 
					"	SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM'\r\n" + 
					") GROUP by event_description ORDER by error_count DESC LIMIT 5",
			resultSetMapping = "top5Result"
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
