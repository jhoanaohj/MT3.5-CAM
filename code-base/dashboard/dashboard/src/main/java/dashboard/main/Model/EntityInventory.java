package dashboard.main.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import com.fasterxml.jackson.annotation.JsonProperty;

@SqlResultSetMapping(name = "queryResult", classes = {
		@ConstructorResult(targetClass = dashboard.main.model.EntityInventory.class, columns = {
				@ColumnResult(name = "terminal_id", type = String.class),
				@ColumnResult(name = "machine_name", type = String.class),
				@ColumnResult(name = "machine_type", type = String.class),
				@ColumnResult(name = "handled_by", type = String.class),
				@ColumnResult(name = "vendor", type = String.class), 
				@ColumnResult(name = "area", type = String.class),
				@ColumnResult(name = "onsite", type = String.class),
				@ColumnResult(name = "address", type = String.class),
				@ColumnResult(name = "status", type = String.class)

		}) })
@NamedNativeQueries({
		@NamedNativeQuery(name = "QueryAllData.getData", query = "SELECT terminal_id, machine_name, machine_type, handled_by, vendor, area, onsite, address, status FROM tbl_inventory WHERE machine_type = 'CAM  '", resultSetMapping = "queryResult"),
//		@NamedNativeQuery(name = "QuerySpecificData.getData", query = "SELECT terminal_id, machine_name, machine_type, handled_by, vendor, area, onsite, address, status FROM tbl_inventory  WHERE terminal_id = ?1", resultSetMapping = "queryResult")

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
	@JsonProperty("HandledBy")
	private String handledBy;
	@JsonProperty("Vendor")
	private String vendor;
	@JsonProperty("Area")
	private String area;
	@JsonProperty("OnSite")
	private String onsite;
	@JsonProperty("Address")
	private String address;
	@JsonProperty("Status")
	private String status;
	
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
	
	public String getHandledBy() {
		return handledBy;
	}

	public void setHandledBy(String handledBy) {
		this.handledBy = handledBy;
	}
	
	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getOnsite() {
		return onsite;
	}

	public void setOnsite(String onsite) {
		this.onsite = onsite;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public EntityInventory(String termId, String machiName, String machiType,  String handBy, String vend, String are, String Site, String Add, String Stat) {
		super();
		this.terminalId = termId;
		this.machineName = machiName;
		this.machineType = machiType;
		this.handledBy = handBy;
		this.vendor = vend;
		this.area = are;
		this.onsite = Site;
		this.address = Add;
		this.status = Stat;
		
	}

	public EntityInventory() {
	}
}