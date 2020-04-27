package dashboard.main.Model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_inventory")
public class TabEntity8 {

	@Id
	private String upsSerialNumber;
	@Column
	private String upsBarCode;
	@Column
	private Date upsDeliveryDate;
	@Column
	private String upsPONumber; 
	@Column
	private Date upsInstallationDate;
	@Column
	private Date upsWarrantyStart;
	@Column
	private Date upsWarrantyEnd;
	@Column
	private String upsVendor;
	@Column
	private String upsBrand;
	@Column
	private String upsModel;
	@Column
	private String upsCapacity;
	

	public String getUpsSerialNumber() {
		return upsSerialNumber;
	}

	public void setUpsSerialNumber(String upsSerialNumber) {
		this.upsSerialNumber = upsSerialNumber;
	}

	public String getUpsBarCode() {
		return upsBarCode;
	}

	public void setUpsBarCode(String upsBarCode) {
		this.upsBarCode = upsBarCode;
	}

	public Date getUpsDeliveryDate() {
		return upsDeliveryDate;
	}

	public void setUpsDeliveryDate(Date upsDeliveryDate) {
		this.upsDeliveryDate = upsDeliveryDate;
	}

	public String getUpsPONumber() {
		return upsPONumber;
	}

	public void setUpsPONumber(String upsPONumber) {
		this.upsPONumber = upsPONumber;
	}

	public Date getUpsInstallationDate() {
		return upsInstallationDate;
	}

	public void setUpsInstallationDate(Date upsInstallationDate) {
		this.upsInstallationDate = upsInstallationDate;
	}

	public Date getUpsWarrantyStart() {
		return upsWarrantyStart;
	}

	public void setUpsWarrantyStart(Date upsWarrantyStart) {
		this.upsWarrantyStart = upsWarrantyStart;
	}

	public Date getUpsWarrantyEnd() {
		return upsWarrantyEnd;
	}

	public void setUpsWarrantyEnd(Date upsWarrantyEnd) {
		this.upsWarrantyEnd = upsWarrantyEnd;
	}

	public String getUpsVendor() {
		return upsVendor;
	}

	public void setUpsVendor(String upsVendor) {
		this.upsVendor = upsVendor;
	}

	public String getUpsBrand() {
		return upsBrand;
	}

	public void setUpsBrand(String upsBrand) {
		this.upsBrand = upsBrand;
	}

	public String getUpsModel() {
		return upsModel;
	}

	public void setUpsModel(String upsModel) {
		this.upsModel = upsModel;
	}

	public String getUpsCapacity() {
		return upsCapacity;
	}

	public void setUpsCapacity(String upsCapacity) {
		this.upsCapacity = upsCapacity;
	}

	public TabEntity8(String upsSerial, String upsBar, Date upsDeliver, String upsPONum, Date upsInstall, Date upsWarrantStart,
			Date upsWarrantEnd, String upsVend, String upsbrand, String upsMode, String upsCap) {
		super();
		this.upsSerialNumber = upsSerial;
		this.upsBarCode = upsBar;
		this.upsDeliveryDate = upsDeliver;
		this.upsPONumber = upsPONum;
		this.upsInstallationDate = upsInstall;
		this.upsWarrantyStart = upsWarrantStart;
		this.upsWarrantyEnd = upsWarrantEnd;
		this.upsVendor = upsVend;
		this.upsBrand = upsbrand;
		this.upsModel = upsMode;
		this.upsCapacity = upsCap;
		
	}

	public TabEntity8() {
	}

}