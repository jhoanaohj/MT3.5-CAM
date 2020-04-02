package dashboard.atmandcam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dashboard.atmandcam.model.MyModel;

public interface MyRepo extends JpaRepository<MyModel, Long> {

	@Query(nativeQuery = true, name = "QueryAllData.getData")
	List<MyModel> getQueryResult();
	
	@Query(nativeQuery = true, name = "QuerySpecificData.getData")
	List<MyModel> getSpecificResult(@Param("terminalId") String terminalId);
}
