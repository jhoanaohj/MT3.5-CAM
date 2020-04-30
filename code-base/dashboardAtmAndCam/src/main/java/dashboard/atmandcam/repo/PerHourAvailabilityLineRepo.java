package dashboard.atmandcam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.atmandcam.model.AvailabilityPerHourLineChart;

public interface PerHourAvailabilityLineRepo extends JpaRepository<AvailabilityPerHourLineChart, Long>{

	@Query(nativeQuery = true, name = "GetRangeHourResultLine.getData")
	List<AvailabilityPerHourLineChart> getRangePerHourResult(@Param("startDate") java.sql.Date startDate, @Param("endDate") java.sql.Date endDate);
	
	@Query(nativeQuery = true, name = "GetDefaultHourResultLine.getData")
	List<AvailabilityPerHourLineChart> getDefaultPerHourResult(@Param("defaultDate") java.sql.Date defaultDate);
	
}
