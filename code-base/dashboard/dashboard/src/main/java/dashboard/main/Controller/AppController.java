package dashboard.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;

import dashboard.main.model.EntityInventory;
//import dashboard.main.model.EntityTab1;
import dashboard.main.repository.RepositoryInventory;


@Controller
public class AppController {

	@Autowired
	private RepositoryInventory repositoryInventory;
	
//	@Autowired
//	private RepositoryTab1 repositoryTab1;
	
	@GetMapping("/inventory")
	public List<EntityInventory> listInventory() {
		System.out.println("In GetAll");
		return repositoryInventory.getQueryResult();
	}

	@GetMapping(value = "/queries")
	@ResponseBody
	public List<EntityInventory> getResult() {
		return repositoryInventory.getQueryResult();
	}

	/////////////////////////////////////////////////////////////////////
//	@ModelAttribute(value = "/tab1")
//    public List<EntityTab1> tab_1() {
//        return repositoryTab1.getQueryTab1();
//    }
//	
//	@GetMapping(value = "/entitytab1")
//	public ModelAndView tab1() {
//		ModelAndView mav = new ModelAndView("/entitytab1");
//		mav.addObject("tab1", repositoryTab1.getQueryTab1());
//		return mav;
//	}
	
	/////////////////////////////////////////////////////////////////////
//	@GetMapping(value = "/queries/{id}")
//	public List<EntityInventory> getSpecific(@PathVariable String id) {
//		return repositoryInventory.getSpecificResult(id);
//	}

//	@GetMapping(value = "/entitytab1")
//	@ResponseBody
//	public List<EntityTab1> getQueryTab1() {
//		return repositoryTab1.getQueryTab1();
//	}

}
