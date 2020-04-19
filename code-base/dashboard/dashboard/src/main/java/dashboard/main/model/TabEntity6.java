package dashboard.main.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_inventory")
public class TabEntity6 {

	@Id
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
	private String buConnectedBranch;
	@Column
	private String buStandAlone;
	@Column
	private String buBrand;
	@Column
	private String buSerialNumber;
	@Column
	private String buBarCode;


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

	public String getBuConnectedBranch() {
		return buConnectedBranch;
	}

	public void setBuConnectedBranch(String buConnectedBranch) {
		this.buConnectedBranch = buConnectedBranch;
	}

	public String getBuStandAlone() {
		return buStandAlone;
	}

	public void setBuStandAlone(String buStandAlone) {
		this.buStandAlone = buStandAlone;
	}

	public String getBuBrand() {
		return buBrand;
	}

	public void setBuBrand(String buBrand) {
		this.buBrand = buBrand;
	}

	public String getBuSerialNumber() {
		return buSerialNumber;
	}

	public void setBuSerialNumber(String buSerialNumber) {
		this.buSerialNumber = buSerialNumber;
	}

	public String getBuBarCode() {
		return buBarCode;
	}

	public void setBuBarCode(String buBarCode) {
		this.buBarCode = buBarCode;
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
		this.buConnectedBranch = buConnect;
		this.buStandAlone = buStand;
		this.buBrand = bubrand;
		this.buSerialNumber = buSerial;
		this.buBarCode = buBar;
		
	}

	public TabEntity6() {
	}
}
