package dashboard.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.main.Model.TabEntity4;

public interface TabRepository4 extends JpaRepository<TabEntity4, String>{

	@Query(value = "SELECT terminal_id, ma_service_provider, ma_effective_date, asset_code, software_build_version, uepp_loader_version, uepp_firmware_version, uepp_sn, tmd_security_device  FROM tbl_inventory WHERE machine_type='CAM'", nativeQuery = true) //8 (null values.. ma_effective_date, asset_code, software_build_version, uepp_loader_version, uepp_firmware_version, uepp_sn, tmd_security_device) 
	List<TabEntity4> findAll4();
	@Query("SELECT t from TabEntity4 t WHERE t.terminalId = :term_id ")
	TabEntity4 findByTerminalId(@Param("term_id") String terminalId);
}
