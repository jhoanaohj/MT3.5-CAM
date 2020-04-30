package dashboard.main.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tbl_inventory", schema = "public", catalog = "postgres")
public class InventoryEntity {
    private String machineName;
    private String terminalId;
    private String rcCode;
    private String handledBy;
    private String model;
    private String os;
    private String vendor;
    private String serialNumber;
    private String area;
    private String onsite;
    private Date acquisitionDate;
    private Date operationalDate;
    private Date deliveryDate;
    private Date installationDate;
    private String address;
    private String status;
    private Date datePulledOut;
    private String reasonForPullOut;
    private String locationAfterPullOut;
    private Date maEffectiveDate;
    private String maServiceProvider;
    private Integer assetCode;
    private String originalLocation;
    private String softwareBuildVersion;
    private String ueppLoaderVersion;
    private String ueppFirmwareVersion;
    private String ueppSn;
    private Boolean tmdSecurityDevice;
    private Boolean encryptingPinPad;
    private String eppModel;
    private String memory;
    private String hddCapacity;
    private String eppHardwareVersionNumber;
    private String encryptingPinPadFirmware;
    private String loaderVersionOfEppFirmware;
    private String pciPtsStandard;
    private String pciPtsApprovalNumber;
    private Date pciCertificateExpiryDate;
    private String pciPtsProductType;
    private Date warrantyBegin;
    private Date warrantyEnd;
    private String serviceProvider;
    private String poNumber;
    private Boolean esdmsInstalled;
    private Date esdmsDate;
    private Boolean cppInstalled;
    private Date cppDate;
    private Boolean tmdInstalled;
    private Date tmdDate;
    private Boolean rfid;
    private String upsSerialNumber;
    private String upsBarcode;
    private Date upsDeliveryDate;
    private String upsPoNumber;
    private Date upsInstallationDate;
    private Date upsWarrantyStart;
    private Date upsWarrantyEnd;
    private String upsVendor;
    private String upsBrand;
    private String upsModel;
    private String upsCapacity;
    private String batterySerialNumber;
    private Date batteryDeliveryDate;
    private Date batteryInstallationDate;
    private String batteryCapacity;
    private String buUpsConnectedToBranch;
    private String buUpsStandAlone;
    private String buUpsBrand;
    private String buUpsSerialNumber;
    private String buUpsBarcode;
    private String cSoftwareBuild;
    private String cEncryptingPinPadFirmware;
    private String cEncryptingPinPadFirmwareType;
    private String cEncryptingPinPadFirmwareSerialNumber;
    private Boolean cEncryptingPinPad;
    private Boolean cRemoteStatusMonitor;
    private Boolean cCctv;
    private Boolean cStandardMetalPinShield;
    private Boolean cTmdSecurityDevice;
    private Boolean cSolidcore;
    private Boolean cBolting;
    private Boolean cTopperVestibuleKey;
    private Boolean cTopperVestibuleSignage;
    private Boolean cTopperVestibuleTimer;
    private Boolean cStandardAtmStickers;
    private Boolean cTopperVestibulePadlock;
    private Boolean cTophatchPadlock;
    private Boolean cPowerBoxConcealingPadlock;
    private Boolean cCassettes;
    private Boolean cSampleMbtcAtmCard;
    private Time operationStart;
    private Time operationEnd;
    private String machineType;
    private Timestamp createDate;
    private Timestamp updateDate;
    private String regionIsoCode;
    private String provinceIsoCode;
    private String rating;
    private Boolean standAloneBranch;

    @Basic
    @Column(name = "machine_name", nullable = true, length = 256)
    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    @Id
    @Column(name = "terminal_id", nullable = false, length = 8)
    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    @Basic
    @Column(name = "rc_code", nullable = true, length = 3)
    public String getRcCode() {
        return rcCode;
    }

    public void setRcCode(String rcCode) {
        this.rcCode = rcCode;
    }

    @Basic
    @Column(name = "handled_by", nullable = true, length = 10)
    public String getHandledBy() {
        return handledBy;
    }

    public void setHandledBy(String handledBy) {
        this.handledBy = handledBy;
    }

    @Basic
    @Column(name = "model", nullable = true, length = 50)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "os", nullable = true, length = 50)
    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Basic
    @Column(name = "vendor", nullable = true, length = 50)
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Basic
    @Column(name = "serial_number", nullable = true, length = 30)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Basic
    @Column(name = "area", nullable = true, length = 20)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Basic
    @Column(name = "onsite", nullable = true, length = 25)
    public String getOnsite() {
        return onsite;
    }

    public void setOnsite(String onsite) {
        this.onsite = onsite;
    }

    @Basic
    @Column(name = "acquisition_date", nullable = true)
    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    @Basic
    @Column(name = "operational_date", nullable = true)
    public Date getOperationalDate() {
        return operationalDate;
    }

    public void setOperationalDate(Date operationalDate) {
        this.operationalDate = operationalDate;
    }

    @Basic
    @Column(name = "delivery_date", nullable = true)
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Basic
    @Column(name = "installation_date", nullable = true)
    public Date getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {
        this.installationDate = installationDate;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 300)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 50)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "date_pulled_out", nullable = true)
    public Date getDatePulledOut() {
        return datePulledOut;
    }

    public void setDatePulledOut(Date datePulledOut) {
        this.datePulledOut = datePulledOut;
    }

    @Basic
    @Column(name = "reason_for_pull_out", nullable = true, length = 250)
    public String getReasonForPullOut() {
        return reasonForPullOut;
    }

    public void setReasonForPullOut(String reasonForPullOut) {
        this.reasonForPullOut = reasonForPullOut;
    }

    @Basic
    @Column(name = "location_after_pull_out", nullable = true, length = 300)
    public String getLocationAfterPullOut() {
        return locationAfterPullOut;
    }

    public void setLocationAfterPullOut(String locationAfterPullOut) {
        this.locationAfterPullOut = locationAfterPullOut;
    }

    @Basic
    @Column(name = "ma_effective_date", nullable = true)
    public Date getMaEffectiveDate() {
        return maEffectiveDate;
    }

    public void setMaEffectiveDate(Date maEffectiveDate) {
        this.maEffectiveDate = maEffectiveDate;
    }

    @Basic
    @Column(name = "ma_service_provider", nullable = true, length = 50)
    public String getMaServiceProvider() {
        return maServiceProvider;
    }

    public void setMaServiceProvider(String maServiceProvider) {
        this.maServiceProvider = maServiceProvider;
    }

    @Basic
    @Column(name = "asset_code", nullable = true)
    public Integer getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(Integer assetCode) {
        this.assetCode = assetCode;
    }

    @Basic
    @Column(name = "original_location", nullable = true, length = 10)
    public String getOriginalLocation() {
        return originalLocation;
    }

    public void setOriginalLocation(String originalLocation) {
        this.originalLocation = originalLocation;
    }

    @Basic
    @Column(name = "software_build_version", nullable = true, length = 30)
    public String getSoftwareBuildVersion() {
        return softwareBuildVersion;
    }

    public void setSoftwareBuildVersion(String softwareBuildVersion) {
        this.softwareBuildVersion = softwareBuildVersion;
    }

    @Basic
    @Column(name = "uepp_loader_version", nullable = true, length = 30)
    public String getUeppLoaderVersion() {
        return ueppLoaderVersion;
    }

    public void setUeppLoaderVersion(String ueppLoaderVersion) {
        this.ueppLoaderVersion = ueppLoaderVersion;
    }

    @Basic
    @Column(name = "uepp_firmware_version", nullable = true, length = 30)
    public String getUeppFirmwareVersion() {
        return ueppFirmwareVersion;
    }

    public void setUeppFirmwareVersion(String ueppFirmwareVersion) {
        this.ueppFirmwareVersion = ueppFirmwareVersion;
    }

    @Basic
    @Column(name = "uepp_sn", nullable = true, length = 20)
    public String getUeppSn() {
        return ueppSn;
    }

    public void setUeppSn(String ueppSn) {
        this.ueppSn = ueppSn;
    }

    @Basic
    @Column(name = "tmd_security_device", nullable = true)
    public Boolean getTmdSecurityDevice() {
        return tmdSecurityDevice;
    }

    public void setTmdSecurityDevice(Boolean tmdSecurityDevice) {
        this.tmdSecurityDevice = tmdSecurityDevice;
    }

    @Basic
    @Column(name = "encrypting_pin_pad", nullable = true)
    public Boolean getEncryptingPinPad() {
        return encryptingPinPad;
    }

    public void setEncryptingPinPad(Boolean encryptingPinPad) {
        this.encryptingPinPad = encryptingPinPad;
    }

    @Basic
    @Column(name = "epp_model", nullable = true, length = 30)
    public String getEppModel() {
        return eppModel;
    }

    public void setEppModel(String eppModel) {
        this.eppModel = eppModel;
    }

    @Basic
    @Column(name = "memory", nullable = true, length = 30)
    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    @Basic
    @Column(name = "hdd_capacity", nullable = true, length = 30)
    public String getHddCapacity() {
        return hddCapacity;
    }

    public void setHddCapacity(String hddCapacity) {
        this.hddCapacity = hddCapacity;
    }

    @Basic
    @Column(name = "epp_hardware_version_number", nullable = true, length = 30)
    public String getEppHardwareVersionNumber() {
        return eppHardwareVersionNumber;
    }

    public void setEppHardwareVersionNumber(String eppHardwareVersionNumber) {
        this.eppHardwareVersionNumber = eppHardwareVersionNumber;
    }

    @Basic
    @Column(name = "encrypting_pin_pad_firmware", nullable = true, length = 30)
    public String getEncryptingPinPadFirmware() {
        return encryptingPinPadFirmware;
    }

    public void setEncryptingPinPadFirmware(String encryptingPinPadFirmware) {
        this.encryptingPinPadFirmware = encryptingPinPadFirmware;
    }

    @Basic
    @Column(name = "loader_version_of_epp_firmware", nullable = true, length = 30)
    public String getLoaderVersionOfEppFirmware() {
        return loaderVersionOfEppFirmware;
    }

    public void setLoaderVersionOfEppFirmware(String loaderVersionOfEppFirmware) {
        this.loaderVersionOfEppFirmware = loaderVersionOfEppFirmware;
    }

    @Basic
    @Column(name = "pci_pts_standard", nullable = true, length = 30)
    public String getPciPtsStandard() {
        return pciPtsStandard;
    }

    public void setPciPtsStandard(String pciPtsStandard) {
        this.pciPtsStandard = pciPtsStandard;
    }

    @Basic
    @Column(name = "pci_pts_approval_number", nullable = true, length = 30)
    public String getPciPtsApprovalNumber() {
        return pciPtsApprovalNumber;
    }

    public void setPciPtsApprovalNumber(String pciPtsApprovalNumber) {
        this.pciPtsApprovalNumber = pciPtsApprovalNumber;
    }

    @Basic
    @Column(name = "pci_certificate_expiry_date", nullable = true)
    public Date getPciCertificateExpiryDate() {
        return pciCertificateExpiryDate;
    }

    public void setPciCertificateExpiryDate(Date pciCertificateExpiryDate) {
        this.pciCertificateExpiryDate = pciCertificateExpiryDate;
    }

    @Basic
    @Column(name = "pci_pts_product_type", nullable = true, length = 10)
    public String getPciPtsProductType() {
        return pciPtsProductType;
    }

    public void setPciPtsProductType(String pciPtsProductType) {
        this.pciPtsProductType = pciPtsProductType;
    }

    @Basic
    @Column(name = "warranty_begin", nullable = true)
    public Date getWarrantyBegin() {
        return warrantyBegin;
    }

    public void setWarrantyBegin(Date warrantyBegin) {
        this.warrantyBegin = warrantyBegin;
    }

    @Basic
    @Column(name = "warranty_end", nullable = true)
    public Date getWarrantyEnd() {
        return warrantyEnd;
    }

    public void setWarrantyEnd(Date warrantyEnd) {
        this.warrantyEnd = warrantyEnd;
    }

    @Basic
    @Column(name = "service_provider", nullable = true, length = 10)
    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Basic
    @Column(name = "po_number", nullable = true, length = 20)
    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    @Basic
    @Column(name = "esdms_installed", nullable = true)
    public Boolean getEsdmsInstalled() {
        return esdmsInstalled;
    }

    public void setEsdmsInstalled(Boolean esdmsInstalled) {
        this.esdmsInstalled = esdmsInstalled;
    }

    @Basic
    @Column(name = "esdms_date", nullable = true)
    public Date getEsdmsDate() {
        return esdmsDate;
    }

    public void setEsdmsDate(Date esdmsDate) {
        this.esdmsDate = esdmsDate;
    }

    @Basic
    @Column(name = "cpp_installed", nullable = true)
    public Boolean getCppInstalled() {
        return cppInstalled;
    }

    public void setCppInstalled(Boolean cppInstalled) {
        this.cppInstalled = cppInstalled;
    }

    @Basic
    @Column(name = "cpp_date", nullable = true)
    public Date getCppDate() {
        return cppDate;
    }

    public void setCppDate(Date cppDate) {
        this.cppDate = cppDate;
    }

    @Basic
    @Column(name = "tmd_installed", nullable = true)
    public Boolean getTmdInstalled() {
        return tmdInstalled;
    }

    public void setTmdInstalled(Boolean tmdInstalled) {
        this.tmdInstalled = tmdInstalled;
    }

    @Basic
    @Column(name = "tmd_date", nullable = true)
    public Date getTmdDate() {
        return tmdDate;
    }

    public void setTmdDate(Date tmdDate) {
        this.tmdDate = tmdDate;
    }

    @Basic
    @Column(name = "rfid", nullable = true)
    public Boolean getRfid() {
        return rfid;
    }

    public void setRfid(Boolean rfid) {
        this.rfid = rfid;
    }

    @Basic
    @Column(name = "ups_serial_number", nullable = true, length = 70)
    public String getUpsSerialNumber() {
        return upsSerialNumber;
    }

    public void setUpsSerialNumber(String upsSerialNumber) {
        this.upsSerialNumber = upsSerialNumber;
    }

    @Basic
    @Column(name = "ups_barcode", nullable = true, length = 50)
    public String getUpsBarcode() {
        return upsBarcode;
    }

    public void setUpsBarcode(String upsBarcode) {
        this.upsBarcode = upsBarcode;
    }

    @Basic
    @Column(name = "ups_delivery_date", nullable = true)
    public Date getUpsDeliveryDate() {
        return upsDeliveryDate;
    }

    public void setUpsDeliveryDate(Date upsDeliveryDate) {
        this.upsDeliveryDate = upsDeliveryDate;
    }

    @Basic
    @Column(name = "ups_po_number", nullable = true, length = 20)
    public String getUpsPoNumber() {
        return upsPoNumber;
    }

    public void setUpsPoNumber(String upsPoNumber) {
        this.upsPoNumber = upsPoNumber;
    }

    @Basic
    @Column(name = "ups_installation_date", nullable = true)
    public Date getUpsInstallationDate() {
        return upsInstallationDate;
    }

    public void setUpsInstallationDate(Date upsInstallationDate) {
        this.upsInstallationDate = upsInstallationDate;
    }

    @Basic
    @Column(name = "ups_warranty_start", nullable = true)
    public Date getUpsWarrantyStart() {
        return upsWarrantyStart;
    }

    public void setUpsWarrantyStart(Date upsWarrantyStart) {
        this.upsWarrantyStart = upsWarrantyStart;
    }

    @Basic
    @Column(name = "ups_warranty_end", nullable = true)
    public Date getUpsWarrantyEnd() {
        return upsWarrantyEnd;
    }

    public void setUpsWarrantyEnd(Date upsWarrantyEnd) {
        this.upsWarrantyEnd = upsWarrantyEnd;
    }

    @Basic
    @Column(name = "ups_vendor", nullable = true, length = 50)
    public String getUpsVendor() {
        return upsVendor;
    }

    public void setUpsVendor(String upsVendor) {
        this.upsVendor = upsVendor;
    }

    @Basic
    @Column(name = "ups_brand", nullable = true, length = 50)
    public String getUpsBrand() {
        return upsBrand;
    }

    public void setUpsBrand(String upsBrand) {
        this.upsBrand = upsBrand;
    }

    @Basic
    @Column(name = "ups_model", nullable = true, length = 30)
    public String getUpsModel() {
        return upsModel;
    }

    public void setUpsModel(String upsModel) {
        this.upsModel = upsModel;
    }

    @Basic
    @Column(name = "ups_capacity", nullable = true, length = 10)
    public String getUpsCapacity() {
        return upsCapacity;
    }

    public void setUpsCapacity(String upsCapacity) {
        this.upsCapacity = upsCapacity;
    }

    @Basic
    @Column(name = "battery_serial_number", nullable = true, length = 30)
    public String getBatterySerialNumber() {
        return batterySerialNumber;
    }

    public void setBatterySerialNumber(String batterySerialNumber) {
        this.batterySerialNumber = batterySerialNumber;
    }

    @Basic
    @Column(name = "battery_delivery_date", nullable = true)
    public Date getBatteryDeliveryDate() {
        return batteryDeliveryDate;
    }

    public void setBatteryDeliveryDate(Date batteryDeliveryDate) {
        this.batteryDeliveryDate = batteryDeliveryDate;
    }

    @Basic
    @Column(name = "battery_installation_date", nullable = true)
    public Date getBatteryInstallationDate() {
        return batteryInstallationDate;
    }

    public void setBatteryInstallationDate(Date batteryInstallationDate) {
        this.batteryInstallationDate = batteryInstallationDate;
    }

    @Basic
    @Column(name = "battery_capacity", nullable = true, length = 10)
    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Basic
    @Column(name = "bu_ups_connected_to_branch", nullable = true, length = 25)
    public String getBuUpsConnectedToBranch() {
        return buUpsConnectedToBranch;
    }

    public void setBuUpsConnectedToBranch(String buUpsConnectedToBranch) {
        this.buUpsConnectedToBranch = buUpsConnectedToBranch;
    }

    @Basic
    @Column(name = "bu_ups_stand_alone", nullable = true, length = 25)
    public String getBuUpsStandAlone() {
        return buUpsStandAlone;
    }

    public void setBuUpsStandAlone(String buUpsStandAlone) {
        this.buUpsStandAlone = buUpsStandAlone;
    }

    @Basic
    @Column(name = "bu_ups_brand", nullable = true, length = 50)
    public String getBuUpsBrand() {
        return buUpsBrand;
    }

    public void setBuUpsBrand(String buUpsBrand) {
        this.buUpsBrand = buUpsBrand;
    }

    @Basic
    @Column(name = "bu_ups_serial_number", nullable = true, length = 50)
    public String getBuUpsSerialNumber() {
        return buUpsSerialNumber;
    }

    public void setBuUpsSerialNumber(String buUpsSerialNumber) {
        this.buUpsSerialNumber = buUpsSerialNumber;
    }

    @Basic
    @Column(name = "bu_ups_barcode", nullable = true, length = 30)
    public String getBuUpsBarcode() {
        return buUpsBarcode;
    }

    public void setBuUpsBarcode(String buUpsBarcode) {
        this.buUpsBarcode = buUpsBarcode;
    }

    @Basic
    @Column(name = "c_software_build", nullable = true, length = 50)
    public String getcSoftwareBuild() {
        return cSoftwareBuild;
    }

    public void setcSoftwareBuild(String cSoftwareBuild) {
        this.cSoftwareBuild = cSoftwareBuild;
    }

    @Basic
    @Column(name = "c_encrypting_pin_pad_firmware", nullable = true, length = 60)
    public String getcEncryptingPinPadFirmware() {
        return cEncryptingPinPadFirmware;
    }

    public void setcEncryptingPinPadFirmware(String cEncryptingPinPadFirmware) {
        this.cEncryptingPinPadFirmware = cEncryptingPinPadFirmware;
    }

    @Basic
    @Column(name = "c_encrypting_pin_pad_firmware_type", nullable = true, length = 30)
    public String getcEncryptingPinPadFirmwareType() {
        return cEncryptingPinPadFirmwareType;
    }

    public void setcEncryptingPinPadFirmwareType(String cEncryptingPinPadFirmwareType) {
        this.cEncryptingPinPadFirmwareType = cEncryptingPinPadFirmwareType;
    }

    @Basic
    @Column(name = "c_encrypting_pin_pad_firmware_serial_number", nullable = true, length = 30)
    public String getcEncryptingPinPadFirmwareSerialNumber() {
        return cEncryptingPinPadFirmwareSerialNumber;
    }

    public void setcEncryptingPinPadFirmwareSerialNumber(String cEncryptingPinPadFirmwareSerialNumber) {
        this.cEncryptingPinPadFirmwareSerialNumber = cEncryptingPinPadFirmwareSerialNumber;
    }

    @Basic
    @Column(name = "c_encrypting_pin_pad", nullable = true)
    public Boolean getcEncryptingPinPad() {
        return cEncryptingPinPad;
    }

    public void setcEncryptingPinPad(Boolean cEncryptingPinPad) {
        this.cEncryptingPinPad = cEncryptingPinPad;
    }

    @Basic
    @Column(name = "c_remote_status_monitor", nullable = true)
    public Boolean getcRemoteStatusMonitor() {
        return cRemoteStatusMonitor;
    }

    public void setcRemoteStatusMonitor(Boolean cRemoteStatusMonitor) {
        this.cRemoteStatusMonitor = cRemoteStatusMonitor;
    }

    @Basic
    @Column(name = "c_cctv", nullable = true)
    public Boolean getcCctv() {
        return cCctv;
    }

    public void setcCctv(Boolean cCctv) {
        this.cCctv = cCctv;
    }

    @Basic
    @Column(name = "c_standard_metal_pin_shield", nullable = true)
    public Boolean getcStandardMetalPinShield() {
        return cStandardMetalPinShield;
    }

    public void setcStandardMetalPinShield(Boolean cStandardMetalPinShield) {
        this.cStandardMetalPinShield = cStandardMetalPinShield;
    }

    @Basic
    @Column(name = "c_tmd_security_device", nullable = true)
    public Boolean getcTmdSecurityDevice() {
        return cTmdSecurityDevice;
    }

    public void setcTmdSecurityDevice(Boolean cTmdSecurityDevice) {
        this.cTmdSecurityDevice = cTmdSecurityDevice;
    }

    @Basic
    @Column(name = "c_solidcore", nullable = true)
    public Boolean getcSolidcore() {
        return cSolidcore;
    }

    public void setcSolidcore(Boolean cSolidcore) {
        this.cSolidcore = cSolidcore;
    }

    @Basic
    @Column(name = "c_bolting", nullable = true)
    public Boolean getcBolting() {
        return cBolting;
    }

    public void setcBolting(Boolean cBolting) {
        this.cBolting = cBolting;
    }

    @Basic
    @Column(name = "c_topper_vestibule_key", nullable = true)
    public Boolean getcTopperVestibuleKey() {
        return cTopperVestibuleKey;
    }

    public void setcTopperVestibuleKey(Boolean cTopperVestibuleKey) {
        this.cTopperVestibuleKey = cTopperVestibuleKey;
    }

    @Basic
    @Column(name = "c_topper_vestibule_signage", nullable = true)
    public Boolean getcTopperVestibuleSignage() {
        return cTopperVestibuleSignage;
    }

    public void setcTopperVestibuleSignage(Boolean cTopperVestibuleSignage) {
        this.cTopperVestibuleSignage = cTopperVestibuleSignage;
    }

    @Basic
    @Column(name = "c_topper_vestibule_timer", nullable = true)
    public Boolean getcTopperVestibuleTimer() {
        return cTopperVestibuleTimer;
    }

    public void setcTopperVestibuleTimer(Boolean cTopperVestibuleTimer) {
        this.cTopperVestibuleTimer = cTopperVestibuleTimer;
    }

    @Basic
    @Column(name = "c_standard_atm_stickers", nullable = true)
    public Boolean getcStandardAtmStickers() {
        return cStandardAtmStickers;
    }

    public void setcStandardAtmStickers(Boolean cStandardAtmStickers) {
        this.cStandardAtmStickers = cStandardAtmStickers;
    }

    @Basic
    @Column(name = "c_topper_vestibule_padlock", nullable = true)
    public Boolean getcTopperVestibulePadlock() {
        return cTopperVestibulePadlock;
    }

    public void setcTopperVestibulePadlock(Boolean cTopperVestibulePadlock) {
        this.cTopperVestibulePadlock = cTopperVestibulePadlock;
    }

    @Basic
    @Column(name = "c_tophatch_padlock", nullable = true)
    public Boolean getcTophatchPadlock() {
        return cTophatchPadlock;
    }

    public void setcTophatchPadlock(Boolean cTophatchPadlock) {
        this.cTophatchPadlock = cTophatchPadlock;
    }

    @Basic
    @Column(name = "c_power_box_concealing_padlock", nullable = true)
    public Boolean getcPowerBoxConcealingPadlock() {
        return cPowerBoxConcealingPadlock;
    }

    public void setcPowerBoxConcealingPadlock(Boolean cPowerBoxConcealingPadlock) {
        this.cPowerBoxConcealingPadlock = cPowerBoxConcealingPadlock;
    }

    @Basic
    @Column(name = "c_cassettes", nullable = true)
    public Boolean getcCassettes() {
        return cCassettes;
    }

    public void setcCassettes(Boolean cCassettes) {
        this.cCassettes = cCassettes;
    }

    @Basic
    @Column(name = "c_sample_mbtc_atm_card", nullable = true)
    public Boolean getcSampleMbtcAtmCard() {
        return cSampleMbtcAtmCard;
    }

    public void setcSampleMbtcAtmCard(Boolean cSampleMbtcAtmCard) {
        this.cSampleMbtcAtmCard = cSampleMbtcAtmCard;
    }

    @Basic
    @Column(name = "operation_start", nullable = true)
    public Time getOperationStart() {
        return operationStart;
    }

    public void setOperationStart(Time operationStart) {
        this.operationStart = operationStart;
    }

    @Basic
    @Column(name = "operation_end", nullable = true)
    public Time getOperationEnd() {
        return operationEnd;
    }

    public void setOperationEnd(Time operationEnd) {
        this.operationEnd = operationEnd;
    }

    @Basic
    @Column(name = "machine_type", nullable = true, length = 5)
    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "update_date", nullable = true)
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "region_iso_code", nullable = true, length = 6)
    public String getRegionIsoCode() {
        return regionIsoCode;
    }

    public void setRegionIsoCode(String regionIsoCode) {
        this.regionIsoCode = regionIsoCode;
    }

    @Basic
    @Column(name = "province_iso_code", nullable = true, length = 6)
    public String getProvinceIsoCode() {
        return provinceIsoCode;
    }

    public void setProvinceIsoCode(String provinceIsoCode) {
        this.provinceIsoCode = provinceIsoCode;
    }

    @Basic
    @Column(name = "rating", nullable = true, length = 3)
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "stand_alone_branch", nullable = true)
    public Boolean getStandAloneBranch() {
        return standAloneBranch;
    }

    public void setStandAloneBranch(Boolean standAloneBranch) {
        this.standAloneBranch = standAloneBranch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryEntity that = (InventoryEntity) o;
        return Objects.equals(machineName, that.machineName) &&
                Objects.equals(terminalId, that.terminalId) &&
                Objects.equals(rcCode, that.rcCode) &&
                Objects.equals(handledBy, that.handledBy) &&
                Objects.equals(model, that.model) &&
                Objects.equals(os, that.os) &&
                Objects.equals(vendor, that.vendor) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(area, that.area) &&
                Objects.equals(onsite, that.onsite) &&
                Objects.equals(acquisitionDate, that.acquisitionDate) &&
                Objects.equals(operationalDate, that.operationalDate) &&
                Objects.equals(deliveryDate, that.deliveryDate) &&
                Objects.equals(installationDate, that.installationDate) &&
                Objects.equals(address, that.address) &&
                Objects.equals(status, that.status) &&
                Objects.equals(datePulledOut, that.datePulledOut) &&
                Objects.equals(reasonForPullOut, that.reasonForPullOut) &&
                Objects.equals(locationAfterPullOut, that.locationAfterPullOut) &&
                Objects.equals(maEffectiveDate, that.maEffectiveDate) &&
                Objects.equals(maServiceProvider, that.maServiceProvider) &&
                Objects.equals(assetCode, that.assetCode) &&
                Objects.equals(originalLocation, that.originalLocation) &&
                Objects.equals(softwareBuildVersion, that.softwareBuildVersion) &&
                Objects.equals(ueppLoaderVersion, that.ueppLoaderVersion) &&
                Objects.equals(ueppFirmwareVersion, that.ueppFirmwareVersion) &&
                Objects.equals(ueppSn, that.ueppSn) &&
                Objects.equals(tmdSecurityDevice, that.tmdSecurityDevice) &&
                Objects.equals(encryptingPinPad, that.encryptingPinPad) &&
                Objects.equals(eppModel, that.eppModel) &&
                Objects.equals(memory, that.memory) &&
                Objects.equals(hddCapacity, that.hddCapacity) &&
                Objects.equals(eppHardwareVersionNumber, that.eppHardwareVersionNumber) &&
                Objects.equals(encryptingPinPadFirmware, that.encryptingPinPadFirmware) &&
                Objects.equals(loaderVersionOfEppFirmware, that.loaderVersionOfEppFirmware) &&
                Objects.equals(pciPtsStandard, that.pciPtsStandard) &&
                Objects.equals(pciPtsApprovalNumber, that.pciPtsApprovalNumber) &&
                Objects.equals(pciCertificateExpiryDate, that.pciCertificateExpiryDate) &&
                Objects.equals(pciPtsProductType, that.pciPtsProductType) &&
                Objects.equals(warrantyBegin, that.warrantyBegin) &&
                Objects.equals(warrantyEnd, that.warrantyEnd) &&
                Objects.equals(serviceProvider, that.serviceProvider) &&
                Objects.equals(poNumber, that.poNumber) &&
                Objects.equals(esdmsInstalled, that.esdmsInstalled) &&
                Objects.equals(esdmsDate, that.esdmsDate) &&
                Objects.equals(cppInstalled, that.cppInstalled) &&
                Objects.equals(cppDate, that.cppDate) &&
                Objects.equals(tmdInstalled, that.tmdInstalled) &&
                Objects.equals(tmdDate, that.tmdDate) &&
                Objects.equals(rfid, that.rfid) &&
                Objects.equals(upsSerialNumber, that.upsSerialNumber) &&
                Objects.equals(upsBarcode, that.upsBarcode) &&
                Objects.equals(upsDeliveryDate, that.upsDeliveryDate) &&
                Objects.equals(upsPoNumber, that.upsPoNumber) &&
                Objects.equals(upsInstallationDate, that.upsInstallationDate) &&
                Objects.equals(upsWarrantyStart, that.upsWarrantyStart) &&
                Objects.equals(upsWarrantyEnd, that.upsWarrantyEnd) &&
                Objects.equals(upsVendor, that.upsVendor) &&
                Objects.equals(upsBrand, that.upsBrand) &&
                Objects.equals(upsModel, that.upsModel) &&
                Objects.equals(upsCapacity, that.upsCapacity) &&
                Objects.equals(batterySerialNumber, that.batterySerialNumber) &&
                Objects.equals(batteryDeliveryDate, that.batteryDeliveryDate) &&
                Objects.equals(batteryInstallationDate, that.batteryInstallationDate) &&
                Objects.equals(batteryCapacity, that.batteryCapacity) &&
                Objects.equals(buUpsConnectedToBranch, that.buUpsConnectedToBranch) &&
                Objects.equals(buUpsStandAlone, that.buUpsStandAlone) &&
                Objects.equals(buUpsBrand, that.buUpsBrand) &&
                Objects.equals(buUpsSerialNumber, that.buUpsSerialNumber) &&
                Objects.equals(buUpsBarcode, that.buUpsBarcode) &&
                Objects.equals(cSoftwareBuild, that.cSoftwareBuild) &&
                Objects.equals(cEncryptingPinPadFirmware, that.cEncryptingPinPadFirmware) &&
                Objects.equals(cEncryptingPinPadFirmwareType, that.cEncryptingPinPadFirmwareType) &&
                Objects.equals(cEncryptingPinPadFirmwareSerialNumber, that.cEncryptingPinPadFirmwareSerialNumber) &&
                Objects.equals(cEncryptingPinPad, that.cEncryptingPinPad) &&
                Objects.equals(cRemoteStatusMonitor, that.cRemoteStatusMonitor) &&
                Objects.equals(cCctv, that.cCctv) &&
                Objects.equals(cStandardMetalPinShield, that.cStandardMetalPinShield) &&
                Objects.equals(cTmdSecurityDevice, that.cTmdSecurityDevice) &&
                Objects.equals(cSolidcore, that.cSolidcore) &&
                Objects.equals(cBolting, that.cBolting) &&
                Objects.equals(cTopperVestibuleKey, that.cTopperVestibuleKey) &&
                Objects.equals(cTopperVestibuleSignage, that.cTopperVestibuleSignage) &&
                Objects.equals(cTopperVestibuleTimer, that.cTopperVestibuleTimer) &&
                Objects.equals(cStandardAtmStickers, that.cStandardAtmStickers) &&
                Objects.equals(cTopperVestibulePadlock, that.cTopperVestibulePadlock) &&
                Objects.equals(cTophatchPadlock, that.cTophatchPadlock) &&
                Objects.equals(cPowerBoxConcealingPadlock, that.cPowerBoxConcealingPadlock) &&
                Objects.equals(cCassettes, that.cCassettes) &&
                Objects.equals(cSampleMbtcAtmCard, that.cSampleMbtcAtmCard) &&
                Objects.equals(operationStart, that.operationStart) &&
                Objects.equals(operationEnd, that.operationEnd) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(regionIsoCode, that.regionIsoCode) &&
                Objects.equals(provinceIsoCode, that.provinceIsoCode) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(standAloneBranch, that.standAloneBranch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(machineName, terminalId, rcCode, handledBy, model, os, vendor, serialNumber, area, onsite, acquisitionDate, operationalDate, deliveryDate, installationDate, address, status, datePulledOut, reasonForPullOut, locationAfterPullOut, maEffectiveDate, maServiceProvider, assetCode, originalLocation, softwareBuildVersion, ueppLoaderVersion, ueppFirmwareVersion, ueppSn, tmdSecurityDevice, encryptingPinPad, eppModel, memory, hddCapacity, eppHardwareVersionNumber, encryptingPinPadFirmware, loaderVersionOfEppFirmware, pciPtsStandard, pciPtsApprovalNumber, pciCertificateExpiryDate, pciPtsProductType, warrantyBegin, warrantyEnd, serviceProvider, poNumber, esdmsInstalled, esdmsDate, cppInstalled, cppDate, tmdInstalled, tmdDate, rfid, upsSerialNumber, upsBarcode, upsDeliveryDate, upsPoNumber, upsInstallationDate, upsWarrantyStart, upsWarrantyEnd, upsVendor, upsBrand, upsModel, upsCapacity, batterySerialNumber, batteryDeliveryDate, batteryInstallationDate, batteryCapacity, buUpsConnectedToBranch, buUpsStandAlone, buUpsBrand, buUpsSerialNumber, buUpsBarcode, cSoftwareBuild, cEncryptingPinPadFirmware, cEncryptingPinPadFirmwareType, cEncryptingPinPadFirmwareSerialNumber, cEncryptingPinPad, cRemoteStatusMonitor, cCctv, cStandardMetalPinShield, cTmdSecurityDevice, cSolidcore, cBolting, cTopperVestibuleKey, cTopperVestibuleSignage, cTopperVestibuleTimer, cStandardAtmStickers, cTopperVestibulePadlock, cTophatchPadlock, cPowerBoxConcealingPadlock, cCassettes, cSampleMbtcAtmCard, operationStart, operationEnd, machineType, createDate, updateDate, regionIsoCode, provinceIsoCode, rating, standAloneBranch);
    }
}
