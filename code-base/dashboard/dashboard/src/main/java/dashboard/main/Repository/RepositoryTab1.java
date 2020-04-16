package dashboard.main.Repository;

import dashboard.main.Model.EntityTab1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;


public interface RepositoryTab1 extends JpaRepository<EntityTab1, Long> {

	@Query(nativeQuery = true, name = "GetQueryTab1.getData")
	List<EntityTab1> getQueryTab1();

	
}