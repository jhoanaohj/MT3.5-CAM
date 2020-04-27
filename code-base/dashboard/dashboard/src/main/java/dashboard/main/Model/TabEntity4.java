package dashboard.main.Model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_inventory")
public class TabEntity4 {

	@Id
	private String terminalId;
	@Column
	private String maServiceProvider;
	@Column
	private Date ma_effective_date;
	@Column
	private Integer asset_code;
	@Column
	private String software_build_version; 
	@Column
	private String uepp_loader_version;
	@Column
	private String uepp_firmware_version;
	@Column
	private String uepp_sn;
	@Column
	private Boolean tmd_security_device;	


	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getMaServiceProvider() {
		return maServiceProvider;
	}

	public void setMaServiceProvider(String maServiceProvider) {
		this.maServiceProvider = maServiceProvider;
	}

	public Date getMa_effective_date() {
		return ma_effective_date;
	}

	public void setMa_effective_date(Date ma_effective_date) {
		this.ma_effective_date = ma_effective_date;
	}

	public Integer getAsset_code() {
		return asset_code;
	}

	public void setAsset_code(Integer asset_code) {
		this.asset_code = asset_code;
	}

	public String getSoftware_build_version() {
		return software_build_version;
	}

	public void setSoftware_build_version(String software_build_version) {
		this.software_build_version = software_build_version;
	}

	public String getUepp_loader_version() {
		return uepp_loader_version;
	}

	public void setUepp_loader_version(String uepp_loader_version) {
		this.uepp_loader_version = uepp_loader_version;
	}

	public String getUepp_firmware_version() {
		return uepp_firmware_version;
	}

	public void setUepp_firmware_version(String uepp_firmware_version) {
		this.uepp_firmware_version = uepp_firmware_version;
	}

	public String getUepp_sn() {
		return uepp_sn;
	}

	public void setUepp_sn(String uepp_sn) {
		this.uepp_sn = uepp_sn;
	}

	public Boolean getTmd_security_device() {
		return tmd_security_device;
	}

	public void setTmd_security_device(Boolean tmd_security_device) {
		this.tmd_security_device = tmd_security_device;
	}

	public TabEntity4(String termId, String maServe, Date maEff, Integer assetCode, String softwareVer, String loader, String firmware,
			String sn, Boolean tmdSecu) {
		super();
		this.terminalId = termId;
		this.maServiceProvider = maServe;
		this.ma_effective_date = maEff;
		this.asset_code = assetCode;
		this.software_build_version = softwareVer;
		this.uepp_loader_version = loader;
		this.uepp_firmware_version = firmware;
		this.uepp_sn = sn;
		this.tmd_security_device = tmdSecu;
		
	}

	public TabEntity4() {
	}
}