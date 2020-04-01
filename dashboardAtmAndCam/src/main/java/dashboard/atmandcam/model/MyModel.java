package dashboard.atmandcam.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;


@SqlResultSetMapping(name = "queryResult", classes = {
		@ConstructorResult(targetClass = dashboard.atmandcam.model.MyModel.class, columns = {
				@ColumnResult(name = "terminal_id", type = String.class),
				@ColumnResult(name = "machine_name", type = String.class),
				@ColumnResult(name = "machine_type", type = String.class),
				@ColumnResult(name = "operation_start", type = String.class),
				@ColumnResult(name = "operation_end", type = String.class)
		})
})

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "QueryAllData.getData", 
			query = "SELECT terminal_id, machine_name, machine_type, operation_start, operation_end FROM dashboard.inventory  WHERE machine_type = 'CAM'", 
			resultSetMapping = "queryResult"),
	@NamedNativeQuery(
			name = "QuerySpecificData.getData",
			query = "SELECT terminal_id, machine_name, machine_type, operation_start, operation_end FROM dashboard.inventory  WHERE terminal_id = ?1",
			resultSetMapping = "queryResult"
			)
})
@Entity
public class MyModel {
	
	@Id
	private Long id;
	
	@JsonProperty("id: ")
	private String terminalId;
	@JsonProperty("machine_name")
	private String machineName;
	@JsonProperty("machine_type")
	private String machineType;
	@JsonProperty("operation_start")
	private String operationStart;
	@JsonProperty("operation_end")
	private String operationEnd;
	
	
	public MyModel(String termId, String machiName, String machiType, String opStart, String opEnd) {
		super();
		this.terminalId = termId;
		this.machineName = machiName;
		this.machineType = machiType;
		this.operationStart = opStart;
		this.operationEnd = opEnd;
	}
	
	public MyModel() {
		
	}
	
	
}
