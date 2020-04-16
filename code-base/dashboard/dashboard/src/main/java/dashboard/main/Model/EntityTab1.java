package dashboard.main.Model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import com.fasterxml.jackson.annotation.JsonProperty;

@SqlResultSetMapping(name = "queryTab1", classes = {
		@ConstructorResult(targetClass = dashboard.main.Model.EntityTab1.class, columns = {
				@ColumnResult(name = "terminal_id", type = String.class),
				@ColumnResult(name = "machine_name", type = String.class),
				@ColumnResult(name = "rc_code", type = String.class),
				@ColumnResult(name = "handled_by", type = String.class),
				@ColumnResult(name = "model", type = String.class), 
				@ColumnResult(name = "os", type = String.class),
				@ColumnResult(name = "vendor", type = String.class),
				@ColumnResult(name = "serial_number", type = String.class),
				@ColumnResult(name = "area", type = String.class),
				@ColumnResult(name = "onsite", type = String.class)

		}) })
@NamedNativeQueries({
		@NamedNativeQuery(name = "GetQueryTab1.getData", 
				  query = "SELECT terminal_id, machine_name, rc_code, handled_by, model, os, vendor, serial_number, area, onsite FROM tbl_inventory  WHERE machine_type = 'CAM'", 
				  resultSetMapping = "queryTab1"),
})
@Entity
public class EntityTab1 {
	@Id
	@JsonProperty("TerminalId")
	private String terminalId;
	
	@JsonProperty("MachineName")
	private String machineName;
	
	@JsonProperty("RCCode")
	private String rcCode;
	
	@JsonProperty("HandledBy")
	private String handledBy;
	
	@JsonProperty("Model")
	private String model;
	
	@JsonProperty("OS")
	private String os;
	
	@JsonProperty("Vendor")
	private String vendor;
	
	@JsonProperty("SerialNumber")
	private String serialNum;
	
	@JsonProperty("Area")
	private String area;
	
	@JsonProperty("OnSite")
	private String onsite;


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

	public String getRcCode() {
		return rcCode;
	}

	public void setRcCode(String rcCode) {
		this.rcCode = rcCode;
	}

	public String getHandledBy() {
		return handledBy;
	}

	public void setHandledBy(String handledBy) {
		this.handledBy = handledBy;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
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


	public EntityTab1(String termId, String machiName, String rcCode,  String handBy, String mode, String oS, String vend, String serial, String are, String Site) {
		super();
		this.terminalId = termId;
		this.machineName = machiName;
		this.rcCode = rcCode;
		this.handledBy = handBy;
		this.model = mode;
		this.os = oS;
		this.vendor = vend;
		this.serialNum = serial;
		this.area = are;
		this.onsite = Site;
		
	}

	public EntityTab1() {
	}
}
