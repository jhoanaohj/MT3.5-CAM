package dashboard.main.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_inventory")
public class TabEntity9 {

	@Id
	private String cSoftwareBuild;
	@Column
	private String cEncryptingPinPadFirmware;
	@Column
	private String cEncryptingPinPadFirmwareType;
	@Column
	private String cEncryptingPinPadFirmwareSerialNumber; 
	@Column
	private Boolean cEncryptingPinPad;
	@Column
	private Boolean cRemoteStatusMonitor;
	@Column
	private Boolean cCCTV;
	@Column
	private Boolean cStandardMetalPinShield;
	@Column
	private Boolean cTMDSecurityDevice;
	@Column
	private Boolean cSolidcore;
	@Column
	private Boolean cBolting;
	@Column 
	private Boolean cTopperVestibuleKey;
	

	public String getcSoftwareBuild() {
		return cSoftwareBuild;
	}

	public void setcSoftwareBuild(String cSoftwareBuild) {
		this.cSoftwareBuild = cSoftwareBuild;
	}

	public String getcEncryptingPinPadFirmware() {
		return cEncryptingPinPadFirmware;
	}

	public void setcEncryptingPinPadFirmware(String cEncryptingPinPadFirmware) {
		this.cEncryptingPinPadFirmware = cEncryptingPinPadFirmware;
	}

	public String getcEncryptingPinPadFirmwareType() {
		return cEncryptingPinPadFirmwareType;
	}

	public void setcEncryptingPinPadFirmwareType(String cEncryptingPinPadFirmwareType) {
		this.cEncryptingPinPadFirmwareType = cEncryptingPinPadFirmwareType;
	}

	public String getcEncryptingPinPadFirmwareSerialNumber() {
		return cEncryptingPinPadFirmwareSerialNumber;
	}

	public void setcEncryptingPinPadFirmwareSerialNumber(String cEncryptingPinPadFirmwareSerialNumber) {
		this.cEncryptingPinPadFirmwareSerialNumber = cEncryptingPinPadFirmwareSerialNumber;
	}

	public Boolean getcEncryptingPinPad() {
		return cEncryptingPinPad;
	}

	public void setcEncryptingPinPad(Boolean cEncryptingPinPad) {
		this.cEncryptingPinPad = cEncryptingPinPad;
	}

	public Boolean getcRemoteStatusMonitor() {
		return cRemoteStatusMonitor;
	}

	public void setcRemoteStatusMonitor(Boolean cRemoteStatusMonitor) {
		this.cRemoteStatusMonitor = cRemoteStatusMonitor;
	}

	public Boolean getcCCTV() {
		return cCCTV;
	}

	public void setcCCTV(Boolean cCCTV) {
		this.cCCTV = cCCTV;
	}

	public Boolean getcStandardMetalPinShield() {
		return cStandardMetalPinShield;
	}

	public void setcStandardMetalPinShield(Boolean cStandardMetalPinShield) {
		this.cStandardMetalPinShield = cStandardMetalPinShield;
	}

	public Boolean getcTMDSecurityDevice() {
		return cTMDSecurityDevice;
	}

	public void setcTMDSecurityDevice(Boolean cTMDSecurityDevice) {
		this.cTMDSecurityDevice = cTMDSecurityDevice;
	}

	public Boolean getcSolidcore() {
		return cSolidcore;
	}

	public void setcSolidcore(Boolean cSolidcore) {
		this.cSolidcore = cSolidcore;
	}

	public Boolean getcBolting() {
		return cBolting;
	}

	public void setcBolting(Boolean cBolting) {
		this.cBolting = cBolting;
	}

	public Boolean getcTopperVestibuleKey() {
		return cTopperVestibuleKey;
	}

	public void setcTopperVestibuleKey(Boolean cTopperVestibuleKey) {
		this.cTopperVestibuleKey = cTopperVestibuleKey;
	}

	public TabEntity9(String cSoftware, String pinFirmware, String pinFirmwareType, String pinFirmwareSerial, Boolean pinPad, Boolean remoteStat,
			Boolean cctv, Boolean standardMetal, Boolean tmdSecurityDev, Boolean cSolid, Boolean cBolt, Boolean cTopperKey) {
		super();
		this.cSoftwareBuild = cSoftware;
		this.cEncryptingPinPadFirmware = pinFirmware;
		this.cEncryptingPinPadFirmwareType = pinFirmwareType;
		this.cEncryptingPinPadFirmwareSerialNumber = pinFirmwareSerial;
		this.cEncryptingPinPad = pinPad;
		this.cRemoteStatusMonitor = remoteStat;
		this.cCCTV = cctv;
		this.cStandardMetalPinShield = standardMetal;
		this.cTMDSecurityDevice = tmdSecurityDev;
		this.cSolidcore = cSolid;
		this.cBolting = cBolt;
		this.cTopperVestibuleKey = cTopperKey;
		
	}

	public TabEntity9() {
	}

}