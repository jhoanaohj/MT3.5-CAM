package dashboard.atmandcam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.atmandcam.model.MostDownTerminals;

public interface MostDownTerminalsRepo extends JpaRepository<MostDownTerminals, Long>{

	@Query(nativeQuery = true, name = "GetDefaultMostDownTerminal.getData")
	List<MostDownTerminals> getDefaultDownTerminals(@Param("defaultDate") java.sql.Date defaultDate);
	
	@Query(nativeQuery = true, name = "GetRangedMostDownTerminal.getData")
	List<MostDownTerminals> getRangedDownTerminals(@Param("startDate") java.sql.Date startDate, @Param("endDate") java.sql.Date endDate);
	
}
