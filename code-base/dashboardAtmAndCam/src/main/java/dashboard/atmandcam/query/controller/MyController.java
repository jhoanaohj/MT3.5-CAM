package dashboard.atmandcam.query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dashboard.atmandcam.model.MyModel;
import dashboard.atmandcam.model.Top5Downtime;
import dashboard.atmandcam.repo.MyRepo;
import dashboard.atmandcam.repo.Top5DowntimeRepo;

@RestController
public class MyController {
	
	@Autowired
	private MyRepo myRepo;
	
	@Autowired
	private Top5DowntimeRepo top5down;
	
	@GetMapping("/queries/")
	public List<MyModel> getResult(){
		return myRepo.getQueryResult();
	}
	
	@GetMapping(value = {"/queries/{id}"})
	public List<MyModel> getSpecific(@PathVariable String id){
		return myRepo.getSpecificResult(id);
	}
	
	@GetMapping("/test")
	public String indexHtml() {
		return "hi";
	}
	
	@GetMapping("/top5downtime/")
	public List<Top5Downtime> getTop5Downtime(){
		return top5down.getTop5Downtime();
	}
	
}
