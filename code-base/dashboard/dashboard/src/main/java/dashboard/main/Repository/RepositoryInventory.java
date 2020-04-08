package dashboard.main.Repository;

import dashboard.main.Model.EntityInventory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RepositoryInventory extends JpaRepository<EntityInventory, Long> {

	@Query(nativeQuery = true, name = "QueryAllData.getData")
	List<EntityInventory> getQueryResult();
	
	@Query(nativeQuery = true, name = "QuerySpecificData.getData")
	List<EntityInventory> getSpecificResult(@Param("terminalId") String terminalId);

	
}

