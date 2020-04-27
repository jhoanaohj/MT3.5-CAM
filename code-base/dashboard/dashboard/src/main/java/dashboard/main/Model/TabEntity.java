package dashboard.main.Model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_inventory")
public class TabEntity {
	
	@Id
	private String terminalId;
	@Column
	private String machineName;
	@Column
	private String machineType;
	@Column
	private String rcCode;
	@Column
	private String handledBy;
	@Column
	private String model;
	@Column
	private String os;
	@Column
	private String vendor;
	@Column
	private String serialNumber;
	@Column
	private String status;
	@Column
	private String area;
	@Column
	private String onsite;
	@Column
	private String memory;
	@Column
	private Boolean rfid;

	
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

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public Boolean getRfid() {
		return rfid;
	}

	public void setRfid(Boolean rfid) {
		this.rfid = rfid;
	}

	public TabEntity(String termId, String machiName, String machiType, String rcCode, String handBy, String mode, String oS, String vend,
			String serial, String stat, String are, String site, String mem, Boolean rfiD) {
		super();
		this.terminalId = termId;
		this.machineName = machiName;
		this.machineType = machiType;
		this.rcCode = rcCode;
		this.handledBy = handBy;
		this.model = mode;
		this.os = oS;
		this.vendor = vend;
		this.serialNumber = serial;
		this.status = stat;
		this.area = are;
		this.onsite = site;
		this.memory = mem;
		this.rfid = rfiD;
	}

	public TabEntity() {
	}
}
