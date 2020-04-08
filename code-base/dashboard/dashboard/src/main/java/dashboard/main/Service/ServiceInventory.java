package dashboard.main.Service;

import dashboard.main.Model.EntityInventory;
import dashboard.main.Repository.RepositoryInventory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceInventory implements IServiceInventory{

	@Autowired
	private static RepositoryInventory repository;
	
	@Autowired
	private static EntityInventory invent;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EntityInventory> findAll() {

		return (List<EntityInventory>) repository;
	}

	@SuppressWarnings("unchecked")
	public List<EntityInventory> listAll() {

		return (List<EntityInventory>) invent;
	}
	
}

	
