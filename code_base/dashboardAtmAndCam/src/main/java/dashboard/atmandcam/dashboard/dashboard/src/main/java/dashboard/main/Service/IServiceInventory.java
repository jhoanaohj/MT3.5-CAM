package dashboard.main.Service;

import java.util.List;

import dashboard.main.Model.EntityInventory;

public interface IServiceInventory {


    List<EntityInventory> findAll();

	static List<EntityInventory> listAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
