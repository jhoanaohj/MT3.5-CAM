package dashboard.atmandcam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.atmandcam.model.DownUptimeComparison;

public interface DownUptimeComparisonRepo extends JpaRepository<DownUptimeComparison, Long> {

	@Query(nativeQuery = true, name = "GetUpVersusDownSinglePercentage.getData")
	List<DownUptimeComparison> getDownVsUpSinglePercentage(@Param("startDate") java.sql.Date startDate);
	
	@Query(nativeQuery = true, name = "GetUpVersusDownRangedPercentage.getData")
	List<DownUptimeComparison> getDownVsUpRangedPercentage(@Param("startDate") java.sql.Date startDate, @Param("endDate") java.sql.Date endDate);
	
}
