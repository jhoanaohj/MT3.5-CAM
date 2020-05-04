package dashboard.atmandcam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.atmandcam.model.MostUpTerminals;

public interface MostUpTerminalsRepo extends JpaRepository<MostUpTerminals, Long>{

	@Query(nativeQuery = true, name = "GetDefaultMostUpTerminal.getData")
	List<MostUpTerminals> getDefaultUpTerminals(@Param("defaultDate") java.sql.Date defaultDate);
	
	@Query(nativeQuery = true, name = "GetRangedMostUpTerminal.getData")
	List<MostUpTerminals> getRangedUpTerminals(@Param("startDate") java.sql.Date startDate, @Param("endDate") java.sql.Date endDate);
	
}
