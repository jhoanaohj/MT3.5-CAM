package dashboard.main.Model;


import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import com.fasterxml.jackson.annotation.JsonProperty;

@SqlResultSetMapping(name = "queryResult", classes = {
		@ConstructorResult(targetClass = dashboard.main.Model.EntityInventory.class, columns = {
				@ColumnResult(name = "terminal_id", type = String.class),
				@ColumnResult(name = "machine_name", type = String.class),
				@ColumnResult(name = "machine_type", type = String.class),
				@ColumnResult(name = "rc_code", type = String.class)
				
		})
})
@NamedNativeQueries({
	@NamedNativeQuery(
			name = "QueryAllData.getData", 
			query = "SELECT terminal_id, machine_name, machine_type, rc_code FROM tbl_inventory  WHERE machine_type = 'CAM'", 
			resultSetMapping = "queryResult"),
	@NamedNativeQuery(
			name = "QuerySpecificData.getData",
			query = "SELECT terminal_id, machine_name, machine_type, rc_code FROM tbl_inventory  WHERE terminal_id = ?1",
			resultSetMapping = "queryResult"
			)
	
})
@Entity
public class EntityInventory {	
	@Id
	@JsonProperty("TerminalId")
	private String terminalId;
	@JsonProperty("MachineName")
	private String machineName;
	@JsonProperty("MachineType")
	private String machineType;
	@JsonProperty("RCCode")
	private String rcCode;
	
	
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getMachineType() {
		return machineType;
	}
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	public String getRcCode() {
		return rcCode;
	}
	public void setRcCode(String rcCode) {
		this.rcCode = rcCode;
	}
	
	public EntityInventory(String termId, String machiName, String machiType, String rCode) {
		super();
		this.terminalId = termId;
		this.machineName = machiName;
		this.machineType = machiType;
		this.rcCode = rCode;
	}	
	public EntityInventory() {		
	}	
}