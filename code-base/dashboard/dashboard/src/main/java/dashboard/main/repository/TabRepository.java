package dashboard.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dashboard.main.Model.TabEntity;

@Repository
public interface TabRepository extends JpaRepository<TabEntity, String> {

	// TAB1
	@Query(value = "SELECT terminal_id, machine_name, machine_type, rc_code, handled_by, model, os, vendor, serial_number, status, area, onsite, memory, rfid FROM tbl_inventory WHERE machine_type='CAM  '", nativeQuery = true) // 14
	List<TabEntity> findAll();

	@Query("SELECT t from TabEntity t WHERE t.terminalId = :term_id ")
	TabEntity findByTerminalId(@Param("term_id") String terminalId);

//	@Query(value = "SELECT  esdms_installed, esdms_date, cpp_installed, cpp_date, tmd_installed, tmd_date FROM tbl_inventory WHERE machine_type='CAM'", nativeQuery = true) //6 ALL VALUES NULL
//	List<TabEntity> findAll7();

//	@Query(value = "SELECT ups_serial_number, ups_barcode, ups_delivery_date, ups_po_number, ups_installation_date, ups_warranty_start, ups_warranty_end, ups_vendor, ups_brand, ups_model, ups_capacity FROM tbl_inventory WHERE machine_type='CAM'", nativeQuery = true) //11 ALL VALUES NULL
//	List<TabEntity> findAll8();

//	@Query(value = "SELECT c_software_build, c_encrypting_pin_pad_firmware, c_encrypting_pin_pad_firmware_type, c_encrypting_pin_pad_firmware_serial_number, c_encrypting_pin_pad, c_remote_status_monitor, c_cctv, c_standard_metal_pin_shield, c_tmd_security_device, c_solidcore, c_bolting, c_topper_vestibule_key FROM tbl_inventory WHERE machine_type = 'CAM'", nativeQuery = true) //12 ALL VALUES NULL
//	List<TabEntity> findAll9();

//	@Query(value = "SELECT c_topper_vestibule_signage, c_topper_vestibule_timer, c_standard_atm_stickers, c_topper_vestibule_padlock, c_tophatch_padlock FROM tbl_inventory WHERE machine_type = 'CAM'", nativeQuery = true) //5 ALL VALUES NULL
//	List<TabEntity> findAll10();	

//	@Query(value = "SELECT c_power_box_concealing_padlock, c_cassettes, c_sample_mbtc_atm_card, hdd_capacity FROM tbl_inventory WHERE machine_type = 'CAM'", nativeQuery = true) //4 ALL VALUES NULL
//	List<TabEntity> findAll11();	

}
