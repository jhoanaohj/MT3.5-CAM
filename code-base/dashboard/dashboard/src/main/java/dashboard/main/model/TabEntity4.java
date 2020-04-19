package dashboard.main.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_inventory")
public class TabEntity4 {

	@Id
	private Date maEffect;
	@Column
	private Date maService;
	@Column
	private Integer asset;
	@Column
	private String softwareVersion; 
	@Column
	private String ueppLoader;
	@Column
	private String ueppFirmware;
	@Column
	private String ueppSN;
	@Column
	private Boolean tmdSecurity;

	public Date getMaEffect() {
		return maEffect;
	}

	public void setMaEffect(Date maEffect) {
		this.maEffect = maEffect;
	}

	public Date getMaService() {
		return maService;
	}

	public void setMaService(Date maService) {
		this.maService = maService;
	}

	public Integer getAsset() {
		return asset;
	}

	public void setAsset(Integer asset) {
		this.asset = asset;
	}

	public String getSoftwareVersion() {
		return softwareVersion;
	}

	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}

	public String getUeppLoader() {
		return ueppLoader;
	}

	public void setUeppLoader(String ueppLoader) {
		this.ueppLoader = ueppLoader;
	}

	public String getUeppFirmware() {
		return ueppFirmware;
	}

	public void setUeppFirmware(String ueppFirmware) {
		this.ueppFirmware = ueppFirmware;
	}

	public String getUeppSN() {
		return ueppSN;
	}

	public void setUeppSN(String ueppSN) {
		this.ueppSN = ueppSN;
	}

	public Boolean getTmdSecurity() {
		return tmdSecurity;
	}

	public void setTmdSecurity(Boolean tmdSecurity) {
		this.tmdSecurity = tmdSecurity;
	}

	public TabEntity4(Date maServe, Date maEff, Integer assetCode, String softwareVer, String loader, String firmware,
			String sn, Boolean tmdSecu) {
		super();
		this.maService = maServe;
		this.maEffect = maEff;
		this.asset = assetCode;
		this.softwareVersion = softwareVer;
		this.ueppLoader = loader;
		this.ueppFirmware = firmware;
		this.ueppSN = sn;
		this.tmdSecurity = tmdSecu;
		
	}

	public TabEntity4() {
	}
}