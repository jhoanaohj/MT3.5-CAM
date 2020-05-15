package dashboard.atmandcam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.atmandcam.model.AvailabilityPlannedUnplanned;

public interface AvailabilityPlannedUnplannedRepo extends JpaRepository<AvailabilityPlannedUnplanned, Long> {

	@Query(nativeQuery = true, name = "GetPlannedUnplannedSingle.getData")
	List<AvailabilityPlannedUnplanned> getPlannedUnplannedSingleResult(@Param("startDate") java.sql.Date startDate);

	@Query(nativeQuery = true, name = "GetPlannedUnplannedRanged.getData")
	List<AvailabilityPlannedUnplanned> getPlannedUnplannedRangedResult(@Param("startDate") java.sql.Date startDate, @Param("endDate") java.sql.Date endDate);
}
