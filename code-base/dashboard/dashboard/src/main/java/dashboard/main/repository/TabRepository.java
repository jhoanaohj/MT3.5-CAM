package dashboard.main.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import dashboard.main.model.TabEntity;
import dashboard.main.model.TabEntity2;

@Repository
public interface TabRepository extends JpaRepository<TabEntity, String> {

	//TAB 1
	@Query(value = "SELECT terminal_id, machine_name, machine_type, rc_code, handled_by, model, os, vendor, serial_number, status, area, onsite, memory, rfid FROM tbl_inventory WHERE machine_type='CAM'", nativeQuery = true) //14
	List<TabEntity> findAll();
	@Query("SELECT t from TabEntity t WHERE t.terminalId = :term_id ")
	TabEntity findByTerminalId(@Param("term_id") String terminalId);
	
	//TAB 2
	@Query(value = "SELECT operation_start, operation_end, create_date, update_date, address, region_iso_code, province_iso_code, rating, stand_alone_branch, po_number FROM tbl_inventory WHERE machine_type='CAM'", nativeQuery = true) //10 (null values.. region_iso_code, province_iso_code, rating, stand_alone_branch, po_number)
	List<TabEntity2> findAll2();
	@Query("SELECT t from TabEntity2 t WHERE t.operationStart = :operate_str ")
	TabEntity2 findByOperationStart(@Param("operate_start") Date operationStart);
	
	//TAB 3
	@Query(value = "SELECT acquisition_date, operational_date, delivery_date, installation_date, date_pulled_out, reason_for_pull_out, location_after_pull_out FROM tbl_inventory WHERE machine_type='CAM'", nativeQuery = true) //7 (null values.. date_pulled_out, reason_pull_out, location_after_pull_out FOR DECOMMISION! NOT ALL COLUMNS HAVE VALUES)
	List<TabEntity> findAll3();
	
	@Query(value = "SELECT ma_effective_date, ma_service_provider, asset_code, software_build_version, uepp_loader_version, uepp_firmware_version, uepp_sn, tmd_security_device  FROM tbl_inventory WHERE machine_type='CAM'", nativeQuery = true) //8 (null values.. ma_effective_date, asset_code, software_build_version, uepp_loader_version, uepp_firmware_version, uepp_sn, tmd_security_device) 
	List<TabEntity> findAll4();
	
	@Query(value = "SELECT encrypting_pin_pad, epp_model, epp_hardware_version_number, encrypting_pin_pad_firmware, loader_version_of_epp_firmware, pci_pts_standard, pci_pts_approval_number, pci_certificate_expiry_date, pci_pts_product_type FROM tbl_inventory WHERE machine_type='CAM'", nativeQuery = true) //9 (null values.. ALL COLUMNS HELLO EARTH! If encrypting pin pad is false, other values for EPP are null)
	List<TabEntity> findAll5();
	
	@Query(value = "SELECT original_location, warranty_begin, warranty_end, service_provider, battery_serial_number, battery_delivery_date, battery_installation_date, battery_capacity, bu_ups_connected_to_branch, bu_ups_stand_alone, bu_ups_brand, bu_ups_serial_number, bu_ups_barcode FROM tbl_inventory WHERE machine_type='CAM'", nativeQuery = true) //13 null value.. ALL EXCEPT SERVICE PROVIDER JUSKO PO!
	List<TabEntity> findAll6();
	
	@Query(value = "SELECT  esdms_installed, esdms_date, cpp_installed, cpp_date, tmd_installed, tmd_date FROM tbl_inventory WHERE machine_type='CAM'", nativeQuery = true) //6 ALL VALUES NULL
	List<TabEntity> findAll7();
	
	@Query(value = "SELECT ups_serial_number, ups_barcode, ups_delivery_date, ups_po_number, ups_installation_date, ups_warranty_start, ups_warranty_end, ups_vendor, ups_brand, ups_model, ups_capacity FROM tbl_inventory WHERE machine_type='CAM'", nativeQuery = true) //11 ALL VALUES NULL
	List<TabEntity> findAll8();
	
	@Query(value = "SELECT c_software_build, c_encrypting_pin_pad_firmware, c_encrypting_pin_pad_firmware_type, c_encrypting_pin_pad_firmware_serial_number, c_encrypting_pin_pad, c_remote_status_monitor, c_cctv, c_standard_metal_pin_shield, c_tmd_security_device, c_solidcore, c_bolting, c_topper_vestibule_key FROM tbl_inventory WHERE machine_type = 'CAM'", nativeQuery = true) //12 ALL VALUES NULL
	List<TabEntity> findAll9();
	
	@Query(value = "SELECT c_topper_vestibule_signage, c_topper_vestibule_timer, c_standard_atm_stickers, c_topper_vestibule_padlock, c_tophatch_padlock FROM tbl_inventory WHERE machine_type = 'CAM'", nativeQuery = true) //5 ALL VALUES NULL
	List<TabEntity> findAll10();	
	
	@Query(value = "SELECT c_power_box_concealing_padlock, c_cassettes, c_sample_mbtc_atm_card, hdd_capacity FROM tbl_inventory WHERE machine_type = 'CAM'", nativeQuery = true) //4 ALL VALUES NULL
	List<TabEntity> findAll11();	

}
