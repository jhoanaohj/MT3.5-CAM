package dashboard.atmandcam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.atmandcam.model.TestModel;

public interface TestModelRepo extends JpaRepository<TestModel, Long>{

	@Query(nativeQuery = true, name = "TestSingleResult.getData")
	List<TestModel> getTestSingleResult(@Param("startDate") java.sql.Date startDate);
	
	@Query(nativeQuery = true, name = "TestRangedResult.getData")
	List<TestModel> getTestRangedResult(@Param("startDate") java.sql.Date startDate, @Param("endDate") java.sql.Date endDate);
}
