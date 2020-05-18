package dashboard.atmandcam.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

@SqlResultSetMapping(name = "testResult", classes = {
		@ConstructorResult(targetClass = dashboard.atmandcam.model.TestModel.class, columns = {
				@ColumnResult(name = "planned_eventDesc", type = String.class),
				@ColumnResult(name = "singlePlannedCtr", type = Integer.class),
				@ColumnResult(name = "unPlanned_eventDesc", type = String.class),
				@ColumnResult(name = "singleUnplannedCtr", type = Integer.class)
				}) 
		})

@NamedNativeQueries({
		@NamedNativeQuery(name = "TestSingleResult.getData", 
				query = "SELECT\r\n" + 
						"		event_description AS planned_eventDesc, COUNT(*)\r\n" + 
						"			FILTER(WHERE planned = 'PLANNED' AND cast(event_start_adj AS DATE) = ?1) AS singlePlannedCtr,\r\n" + 
						"		event_description AS unPlanned_eventDesc, COUNT(*)\r\n" + 
						"			FILTER(WHERE planned = 'UNPLANNED' AND cast(event_start_adj AS DATE) = ?1) AS singleUnplannedCtr\r\n" + 
						"	FROM dashboard.event\r\n" + 
						"	GROUP BY event_description", 
				resultSetMapping = "testResult"),

		@NamedNativeQuery(name = "TestRangedResult.getData", 
		query = "SELECT\r\n" + 
				"		event_description AS planned_eventDesc, COUNT(*)\r\n" + 
				"			FILTER(WHERE planned = 'PLANNED' AND cast(event_start_adj AS DATE) BETWEEN ?1 AND ?2) AS singlePlannedCtr,\r\n" + 
				"		event_description AS unPlanned_eventDesc, COUNT(*)\r\n" + 
				"			FILTER(WHERE planned = 'UNPLANNED' AND cast(event_start_adj AS DATE) BETWEEN ?1 AND ?2) AS singleUnplannedCtr\r\n" + 
				"	FROM dashboard.event\r\n" + 
				"	GROUP BY event_description", 
				resultSetMapping = "testResult") 
		})

@Entity
public class TestModel {

	@Id
	public int id;
	
	@JsonProperty("plannedEventDesc")
	private String plannedEventDesc;
	
	@JsonProperty("plannedEventCtr")
	private int plannedEventCtr;
	
	@JsonProperty("unplannedEventDesc")
	private String unplannedEventDesc;
	
	@JsonProperty("unplannedEventCtr")
	private int unplannedEventCtr;
	
	public TestModel(String plannedDesc, int plannedCtr, String unplannedDesc, int unplannedCtr) {
		super();
		this.plannedEventDesc = plannedDesc;
		this.plannedEventCtr = plannedCtr;
		this.unplannedEventDesc = unplannedDesc;
		this.unplannedEventCtr = unplannedCtr;
	}
	
	public TestModel() {}
}
