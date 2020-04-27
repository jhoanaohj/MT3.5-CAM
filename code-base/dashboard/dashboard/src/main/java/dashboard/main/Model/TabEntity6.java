package dashboard.main.Model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_inventory")
public class TabEntity6 {

	@Id
	private String terminalId;
	@Column
	private Boolean originalLocation;
	@Column
	private Date warrantyBegin;
	@Column
	private Date warrantyEnd;
	@Column
	private String serviceProvider; 
	@Column
	private String batterySerialNumber;
	@Column
	private Date batteryDeliveryDate;
	@Column
	private Date batteryInstallationDate;
	@Column
	private String batteryCapacity;
	@Column
	private String bu_ups_connected_to_branch;
	@Column
	private String bu_ups_stand_alone;
	@Column
	private String bu_ups_brand;
	@Column
	private String bu_ups_serial_number;
	@Column
	private String bu_ups_barcode; 


	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public Boolean getOriginalLocation() {
		return originalLocation;
	}

	public void setOriginalLocation(Boolean originalLocation) {
		this.originalLocation = originalLocation;
	}

	public Date getWarrantyBegin() {
		return warrantyBegin;
	}

	public void setWarrantyBegin(Date warrantyBegin) {
		this.warrantyBegin = warrantyBegin;
	}

	public Date getWarrantyEnd() {
		return warrantyEnd;
	}

	public void setWarrantyEnd(Date warrantyEnd) {
		this.warrantyEnd = warrantyEnd;
	}

	public String getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public String getBatterySerialNumber() {
		return batterySerialNumber;
	}

	public void setBatterySerialNumber(String batterySerialNumber) {
		this.batterySerialNumber = batterySerialNumber;
	}

	public Date getBatteryDeliveryDate() {
		return batteryDeliveryDate;
	}

	public void setBatteryDeliveryDate(Date batteryDeliveryDate) {
		this.batteryDeliveryDate = batteryDeliveryDate;
	}

	public Date getBatteryInstallationDate() {
		return batteryInstallationDate;
	}

	public void setBatteryInstallationDate(Date batteryInstallationDate) {
		this.batteryInstallationDate = batteryInstallationDate;
	}

	public String getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getBu_ups_connected_to_branch() {
		return bu_ups_connected_to_branch;
	}

	public void setBu_ups_connected_to_branch(String bu_ups_connected_to_branch) {
		this.bu_ups_connected_to_branch = bu_ups_connected_to_branch;
	}

	public String getBu_ups_stand_alone() {
		return bu_ups_stand_alone;
	}

	public void setBu_ups_stand_alone(String bu_ups_stand_alone) {
		this.bu_ups_stand_alone = bu_ups_stand_alone;
	}

	public String getBu_ups_brand() {
		return bu_ups_brand;
	}

	public void setBu_ups_brand(String bu_ups_brand) {
		this.bu_ups_brand = bu_ups_brand;
	}

	public String getBu_ups_serial_number() {
		return bu_ups_serial_number;
	}

	public void setBu_ups_serial_number(String bu_ups_serial_number) {
		this.bu_ups_serial_number = bu_ups_serial_number;
	}

	public String getBu_ups_barcode() {
		return bu_ups_barcode;
	}

	public void setBu_ups_barcode(String bu_ups_barcode) {
		this.bu_ups_barcode = bu_ups_barcode;
	}

	public TabEntity6(Boolean origLocation, Date warrantyStart, Date warrantyend, String servProvider, String battSerial, Date battDeliver,
			Date battInstall, String battCapacity, String buConnect, String buStand, String bubrand, String buSerial, String buBar) {
		super();
		this.originalLocation = origLocation;
		this.warrantyBegin = warrantyStart;
		this.warrantyEnd = warrantyend;
		this.serviceProvider = servProvider;
		this.batterySerialNumber = battSerial;
		this.batteryDeliveryDate = battDeliver;
		this.batteryInstallationDate = battInstall;
		this.batteryCapacity = battCapacity;
		this.bu_ups_connected_to_branch = buConnect;
		this.bu_ups_stand_alone = buStand;
		this.bu_ups_brand = bubrand;
		this.bu_ups_serial_number = buSerial;
		this.bu_ups_barcode = buBar;
		
	}

	public TabEntity6() {
	}
}
