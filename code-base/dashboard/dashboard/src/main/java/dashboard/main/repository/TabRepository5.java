package dashboard.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.main.Model.TabEntity5;

public interface TabRepository5 extends JpaRepository<TabEntity5, String>{

	@Query(value = "SELECT terminal_id, encrypting_pin_pad, epp_model, epp_hardware_version_number, encrypting_pin_pad_firmware, loader_version_of_epp_firmware, pci_pts_standard, pci_pts_approval_number, pci_certificate_expiry_date, pci_pts_product_type FROM tbl_inventory WHERE machine_type='CAM  '", nativeQuery = true) //9 (null values.. ALL COLUMNS HELLO EARTH! If encrypting pin pad is false, other values for EPP are null)
	List<TabEntity5> findAll5();
	@Query("SELECT t from TabEntity5 t WHERE t.terminalId = :term_id ")
	TabEntity5 findByTerminalId(@Param("term_id") String terminalId);

}
