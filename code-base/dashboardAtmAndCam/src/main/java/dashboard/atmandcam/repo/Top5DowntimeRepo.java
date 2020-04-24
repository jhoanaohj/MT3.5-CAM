package dashboard.atmandcam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.atmandcam.model.Top5Downtime;

public interface Top5DowntimeRepo extends JpaRepository<Top5Downtime, Long> {

	@Query(nativeQuery = true, name = "GetTopDowntime.getData")
	List<Top5Downtime> getTop5Downtime(@Param("downDate") java.sql.Date downDate);
	
	@Query(nativeQuery = true, name = "GetTopRangeDowntime.getData")
	List<Top5Downtime> getTopRangeDowntime(@Param("downStartDate") java.sql.Date downStartDate, @Param("downEndDate") java.sql.Date downEndDate);
}
