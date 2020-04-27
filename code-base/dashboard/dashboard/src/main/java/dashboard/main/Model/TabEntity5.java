package dashboard.main.Model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_inventory")
public class TabEntity5 {

	@Id
	private String terminalId;
	@Column
	private Boolean encryptingPinPad;
	@Column
	private String eppModel;
	@Column
	private String eppHardwareVersionNumber;
	@Column
	private String encryptingPinPadFirmware; 
	@Column
	private String loader_version_of_epp_firmware;
	@Column
	private String pci_pts_standard;
	@Column
	private String pci_pts_approval_number;
	@Column
	private Date pci_certificate_expiry_date;
	@Column
	private String pci_pts_product_type; 


	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public Boolean getEncryptingPinPad() {
		return encryptingPinPad;
	}

	public void setEncryptingPinPad(Boolean encryptingPinPad) {
		this.encryptingPinPad = encryptingPinPad;
	}

	public String getEppModel() {
		return eppModel;
	}

	public void setEppModel(String eppModel) {
		this.eppModel = eppModel;
	}

	public String getEppHardwareVersionNumber() {
		return eppHardwareVersionNumber;
	}

	public void setEppHardwareVersionNumber(String eppHardwareVersionNumber) {
		this.eppHardwareVersionNumber = eppHardwareVersionNumber;
	}

	public String getEncryptingPinPadFirmware() {
		return encryptingPinPadFirmware;
	}

	public void setEncryptingPinPadFirmware(String encryptingPinPadFirmware) {
		this.encryptingPinPadFirmware = encryptingPinPadFirmware;
	}

	public String getLoader_version_of_epp_firmware() {
		return loader_version_of_epp_firmware;
	}

	public void setLoader_version_of_epp_firmware(String loader_version_of_epp_firmware) {
		this.loader_version_of_epp_firmware = loader_version_of_epp_firmware;
	}

	public String getPci_pts_standard() {
		return pci_pts_standard;
	}

	public void setPci_pts_standard(String pci_pts_standard) {
		this.pci_pts_standard = pci_pts_standard;
	}

	public String getPci_pts_approval_number() {
		return pci_pts_approval_number;
	}

	public void setPci_pts_approval_number(String pci_pts_approval_number) {
		this.pci_pts_approval_number = pci_pts_approval_number;
	}

	public Date getPci_certificate_expiry_date() {
		return pci_certificate_expiry_date;
	}

	public void setPci_certificate_expiry_date(Date pci_certificate_expiry_date) {
		this.pci_certificate_expiry_date = pci_certificate_expiry_date;
	}

	public String getPci_pts_product_type() {
		return pci_pts_product_type;
	}

	public void setPci_pts_product_type(String pci_pts_product_type) {
		this.pci_pts_product_type = pci_pts_product_type;
	}

	public TabEntity5(String termId, Boolean encryptPad, String eppMode, String eppHardware, String eppFirm, String loader, String loaderVerEPP,
			String pciStandard, String pciApproval, Date pciCertificate, String pciProduct) {
		super();
		this.terminalId = termId;
		this.encryptingPinPad = encryptPad;
		this.eppModel = eppMode;
		this.eppHardwareVersionNumber = eppHardware;
		this.encryptingPinPadFirmware = eppFirm;
		this.loader_version_of_epp_firmware = loaderVerEPP;
		this.pci_pts_standard = pciStandard;
		this.pci_pts_approval_number = pciApproval;
		this.pci_certificate_expiry_date = pciCertificate;
		this.pci_pts_product_type = pciProduct;

		
	}

	public TabEntity5() {
	}
}