package dashboard.atmandcam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.atmandcam.model.PlannedUnplannedEventCount;

public interface PlannedUnplannedEventCountRepo extends JpaRepository<PlannedUnplannedEventCount, Long>{

	@Query(nativeQuery = true, name = "GetPlannedSingleResult.getData")
	List<PlannedUnplannedEventCount> getPlannedSingleResult(@Param("startDate") java.sql.Date startDate);
	
	@Query(nativeQuery = true, name = "GetPlannedRangeResult.getData")
	List<PlannedUnplannedEventCount> getPlannedRangedResult(@Param("startDate") java.sql.Date startDate, @Param("endDate") java.sql.Date endDate);
	
	@Query(nativeQuery = true, name = "GetUnplannedSingleResult.getData")
	List<PlannedUnplannedEventCount> getUnplannedSingleResult(@Param("startDate") java.sql.Date startDate);
	
	@Query(nativeQuery = true, name = "GetUnplannedRangedResult.getData")
	List<PlannedUnplannedEventCount> getUnplannedRangedResult(@Param("startDate") java.sql.Date startDate, @Param("endDate") java.sql.Date endDate);
	
}
