package dashboard.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.main.Model.TabEntity7;;

public interface TabRepository7 extends JpaRepository<TabEntity7, String>{

	@Query(value = "SELECT esdms_installed, esdms_date, cpp_installed, cpp_date, tmd_installed, tmd_date FROM tbl_inventory WHERE machine_type='CAM'", nativeQuery = true) //7 ALL VALUES NULL
	List<TabEntity7> findAll7();
	@Query("SELECT t from TabEntity7 t WHERE t.terminalId = :term_id ")
	TabEntity7 findByTerminalId(@Param("term_id") String terminalId);

}