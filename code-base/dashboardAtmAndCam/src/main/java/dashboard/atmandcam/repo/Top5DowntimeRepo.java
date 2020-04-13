package dashboard.atmandcam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dashboard.atmandcam.model.Top5Downtime;

public interface Top5DowntimeRepo extends JpaRepository<Top5Downtime, Long> {

	@Query(nativeQuery = true, name = "GetTop5Downtime.getData")
	List<Top5Downtime> getTop5Downtime();
}
