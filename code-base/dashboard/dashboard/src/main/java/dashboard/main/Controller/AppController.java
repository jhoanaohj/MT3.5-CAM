package dashboard.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dashboard.main.Model.EntityInventory;
import dashboard.main.Repository.RepositoryInventory;

@Controller

public class AppController {

	@Autowired
	private RepositoryInventory repositoryInventory;

	@GetMapping("/inventory")
	public List<EntityInventory> listInventory() {
		System.out.println("In GetAll");
		return repositoryInventory.getQueryResult();
	}

	@RequestMapping("/datatable")
	public String show() {

		return "datatable";
	}

	@RequestMapping("/test")
	public String test() {
		return "test";
	}

	@GetMapping(value="/queries")
	@ResponseBody
	public List<EntityInventory> getResult() {
		return repositoryInventory.getQueryResult();
	}

	@GetMapping("/queries/{id}")
	public List<EntityInventory> getSpecific(@PathVariable String id) {
		return repositoryInventory.getSpecificResult(id);
	}

}
