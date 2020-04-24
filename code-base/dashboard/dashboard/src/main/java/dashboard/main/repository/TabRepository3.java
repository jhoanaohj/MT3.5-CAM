package dashboard.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dashboard.main.model.TabEntity3;

@Repository
public interface TabRepository3 extends JpaRepository<TabEntity3, String> {

	//TAB 3
	@Query(value = "SELECT terminal_id, acquisition_date, operational_date, delivery_date, installation_date, date_pulled_out, reason_for_pull_out, location_after_pull_out FROM tbl_inventory WHERE machine_type='CAM  '", nativeQuery = true) //7 (null values.. date_pulled_out, reason_pull_out, location_after_pull_out FOR DECOMMISION! NOT ALL COLUMNS HAVE VALUES)
	List<TabEntity3> findAll3();
	@Query("SELECT t from TabEntity3 t WHERE t.terminalId = :term_id ")
	TabEntity3 findByTerminalId(@Param("term_id") String terminalId);
	
}
