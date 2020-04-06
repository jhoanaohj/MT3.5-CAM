package dashboard.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import dashboard.main.Model.EntityInventory;
import dashboard.main.Repository.RepositoryInventory;
import dashboard.main.Service.ServiceInventory;

@Controller
public class AppController {
	
	@Autowired
	private RepositoryInventory repositoryInventory;
	

	@GetMapping("/inventory")
	public List<EntityInventory> listInventory () {
		System.out.println("In GetAll");
		return repositoryInventory.getQueryResult();
	}
	
	
	@RequestMapping("/test")
	public String test() {
	    return "test";
	}
	
	@GetMapping("/queries")
	public List<EntityInventory> getResult(){
		return repositoryInventory.getQueryResult();
	}
	
	@GetMapping("/queries/{id}")
	public List<EntityInventory> getSpecific(@PathVariable String id){
		return repositoryInventory.getSpecificResult(id);
	}
	
}




