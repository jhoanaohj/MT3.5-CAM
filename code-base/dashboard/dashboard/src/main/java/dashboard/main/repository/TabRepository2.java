package dashboard.main.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dashboard.main.model.TabEntity2;

@Repository
public interface TabRepository2 extends JpaRepository<TabEntity2, String> {

	//TAB 2
	@Query(value = "SELECT terminal_id, operation_start, operation_end, create_date, update_date, address, region_iso_code, province_iso_code, rating, stand_alone_branch, po_number FROM tbl_inventory WHERE machine_type='CAM  '", nativeQuery = true) //10 (null values.. region_iso_code, province_iso_code, rating, stand_alone_branch, po_number)
	List<TabEntity2> findAll2();
	@Query("SELECT t from TabEntity2 t WHERE t.terminalId = :term_id ")
	TabEntity2 findByTerminalId(@Param("term_id") String terminalId);
	
}

