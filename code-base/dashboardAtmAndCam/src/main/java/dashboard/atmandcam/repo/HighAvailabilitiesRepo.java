package dashboard.atmandcam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.atmandcam.model.HighAvailabilityCam;

public interface HighAvailabilitiesRepo extends JpaRepository<HighAvailabilityCam, Long> {
	
	@Query(nativeQuery = true, name = "GetRangeHighAvail.getData")
	List<HighAvailabilityCam>getHighAvailabilities(@Param("startDate") java.sql.Date startDate, @Param("endDate") java.sql.Date endDate);
	
	@Query(nativeQuery = true, name = "GetHighAvail.getData")
	List<HighAvailabilityCam>getHighAvailability(@Param("defaultDate") java.sql.Date defaultDate);
}
