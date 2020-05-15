package dashboard.atmandcam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.atmandcam.model.AvailabilityPerMonth;

public interface AvailabilityPerMonthRepo extends JpaRepository<AvailabilityPerMonth, Long> {

	@Query(nativeQuery = true, name = "GetPerMonthAvailability.getData")
	List<AvailabilityPerMonth> getAvailPerMonth(
			@Param("lastMonStartDate") java.sql.Date lastMonStartDate, 
			@Param("lastMonEndDate") java.sql.Date lastMonEndDate, 
			@Param("currMonStartDate") java.sql.Date currMonStartDate, 
			@Param("currMonEndDate") java.sql.Date currMonEndDate, 
			@Param("nextMonStartDate") java.sql.Date nextMonStartDate, 
			@Param("nextMonEndDate") java.sql.Date nextMonEndDate
			);
}
