package dashboard.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.main.model.TabEntity6;

public interface TabRepository6 extends JpaRepository<TabEntity6, String>{

	@Query(value = "SELECT terminal_id, original_location, warranty_begin, warranty_end, service_provider, battery_serial_number, battery_delivery_date, battery_installation_date, battery_capacity, bu_ups_connected_to_branch, bu_ups_stand_alone, bu_ups_brand, bu_ups_serial_number, bu_ups_barcode FROM tbl_inventory WHERE machine_type='CAM'", nativeQuery = true) //13 null value.. ALL EXCEPT SERVICE PROVIDER JUSKO PO!
	List<TabEntity6> findAll6();
	@Query("SELECT t from TabEntity6 t WHERE t.terminalId = :term_id ")
	TabEntity6 findByTerminalId(@Param("term_id") String terminalId);

}
