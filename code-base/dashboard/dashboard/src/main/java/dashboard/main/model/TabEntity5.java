package dashboard.main.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_inventory")
public class TabEntity5 {

	@Id
	private Boolean encryptingPad;
	@Column
	private String eppModel;
	@Column
	private String eppHardwareNumber;
	@Column
	private String eppFirmware; 
	@Column
	private String loaderVersionEPPFirmware;
	@Column
	private String pciptsStandard;
	@Column
	private String pciptsApprovalNumber;
	@Column
	private Date pciCertificateExpiryDate;
	@Column
	private String pciptsProductType;
	

	public Boolean getEncryptingPad() {
		return encryptingPad;
	}

	public void setEncryptingPad(Boolean encryptingPad) {
		this.encryptingPad = encryptingPad;
	}

	public String getEppModel() {
		return eppModel;
	}

	public void setEppModel(String eppModel) {
		this.eppModel = eppModel;
	}

	public String getEppHardwareNumber() {
		return eppHardwareNumber;
	}

	public void setEppHardwareNumber(String eppHardwareNumber) {
		this.eppHardwareNumber = eppHardwareNumber;
	}

	public String getEppFirmware() {
		return eppFirmware;
	}

	public void setEppFirmware(String eppFirmware) {
		this.eppFirmware = eppFirmware;
	}

	public String getLoaderVersionEPPFirmware() {
		return loaderVersionEPPFirmware;
	}

	public void setLoaderVersionEPPFirmware(String loaderVersionEPPFirmware) {
		this.loaderVersionEPPFirmware = loaderVersionEPPFirmware;
	}

	public String getPciptsStandard() {
		return pciptsStandard;
	}

	public void setPciptsStandard(String pciptsStandard) {
		this.pciptsStandard = pciptsStandard;
	}

	public String getPciptsApprovalNumber() {
		return pciptsApprovalNumber;
	}

	public void setPciptsApprovalNumber(String pciptsApprovalNumber) {
		this.pciptsApprovalNumber = pciptsApprovalNumber;
	}

	public Date getPciCertificateExpiryDate() {
		return pciCertificateExpiryDate;
	}

	public void setPciCertificateExpiryDate(Date pciCertificateExpiryDate) {
		this.pciCertificateExpiryDate = pciCertificateExpiryDate;
	}

	public String getPciptsProductType() {
		return pciptsProductType;
	}

	public void setPciptsProductType(String pciptsProductType) {
		this.pciptsProductType = pciptsProductType;
	}

	public TabEntity5(Boolean encryptPad, String eppMode, String eppHardware, String eppFirm, String loader, String loaderVerEPP,
			String pciStandard, String pciApproval, Date pciCertificate, String pciProduct) {
		super();
		this.encryptingPad = encryptPad;
		this.eppModel = eppMode;
		this.eppHardwareNumber = eppHardware;
		this.eppFirmware = eppFirm;
		this.loaderVersionEPPFirmware = loaderVerEPP;
		this.pciptsStandard = pciStandard;
		this.pciptsApprovalNumber = pciApproval;
		this.pciCertificateExpiryDate = pciCertificate;
		this.pciptsProductType = pciProduct;

		
	}

	public TabEntity5() {
	}
}