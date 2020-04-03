package dashboard.atmandcam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dashboard.atmandcam.model.MyModel;
import dashboard.atmandcam.repo.MyRepo;

@RestController
public class MyController {
	
	@Autowired
	private MyRepo myRepo;
	
	@GetMapping("/test")
	public String sayHi() {
		return "hi";
	}
	
	@GetMapping("/queries")
	public List<MyModel> getResult(){
		return myRepo.getQueryResult();
	}
	
	@GetMapping(value = {"/queries/{id}"})
	public List<MyModel> getSpecific(@PathVariable String id){
		return myRepo.getSpecificResult(id);
	}
	
//	@GetMapping("/index")
//	public String indexHtml() {
//		return "index.html";
//	}
	
}
