package dashboard.atmandcam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.atmandcam.model.AvailabilityPerRegion;

public interface AvailabilityPerRegionRepo extends JpaRepository<AvailabilityPerRegion, Long> {
	
	@Query(nativeQuery = true, name = "GetRangeHighAvail.getData")
	List<AvailabilityPerRegion>getHighAvailabilities(@Param("startDate") java.sql.Date startDate, @Param("endDate") java.sql.Date endDate);
	
	@Query(nativeQuery = true, name = "GetHighAvail.getData")
	List<AvailabilityPerRegion>getHighAvailability(@Param("defaultDate") java.sql.Date defaultDate);
}
