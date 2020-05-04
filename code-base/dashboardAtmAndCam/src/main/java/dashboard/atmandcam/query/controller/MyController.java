package dashboard.atmandcam.query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dashboard.atmandcam.model.AvailabilityPerHourLineChart;
import dashboard.atmandcam.model.HighAvailabilityCam;
import dashboard.atmandcam.model.MostDownTerminals;
import dashboard.atmandcam.model.MostUpTerminals;
import dashboard.atmandcam.model.MyModel;
import dashboard.atmandcam.model.Top5Downtime;
import dashboard.atmandcam.repo.HighAvailabilitiesRepo;
import dashboard.atmandcam.repo.MostDownTerminalsRepo;
import dashboard.atmandcam.repo.MostUpTerminalsRepo;
import dashboard.atmandcam.repo.MyRepo;
import dashboard.atmandcam.repo.PerHourAvailabilityLineRepo;
import dashboard.atmandcam.repo.Top5DowntimeRepo;

@RestController
public class MyController {
	
	@Autowired
	private MyRepo myRepo;
	
	@Autowired
	private Top5DowntimeRepo top5down;
	
	@Autowired
	private HighAvailabilitiesRepo highAvailRepo;
	
	@Autowired
	private PerHourAvailabilityLineRepo perHourAvailabilityLineRepo;
	
	@Autowired
	private MostDownTerminalsRepo mostDownTerminalRepo;
	
	@Autowired
	private MostUpTerminalsRepo mostUpTerminalsRepo;
	
	
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
	
	@GetMapping("/topdowntime/{downDate}")
	public List<Top5Downtime> getTop5Downtime(@PathVariable java.sql.Date downDate){
		return top5down.getTop5Downtime(downDate);
	}
	
	@GetMapping("/topdowntime/{downStartDate}/{downEndDate}")
	public List<Top5Downtime> getTopRangeDowntime(@PathVariable java.sql.Date downStartDate, @PathVariable java.sql.Date downEndDate){
		return top5down.getTopRangeDowntime(downStartDate, downEndDate);
	}
	
	@GetMapping("/highAvailabilities/{defaultDate}")
	public List<HighAvailabilityCam> getHighAvail(@PathVariable java.sql.Date defaultDate){
		return highAvailRepo.getHighAvailability(defaultDate);
	}
	
	@GetMapping("/highAvailabilities/{startDate}/{endDate}")
	public List<HighAvailabilityCam> getHighAvails(@PathVariable java.sql.Date startDate, @PathVariable java.sql.Date endDate){
		return highAvailRepo.getHighAvailabilities(startDate, endDate);
	}
	
	@GetMapping("/perHourAvailabilities/{startDate}/{endDate}")
	public List<AvailabilityPerHourLineChart> getRangePerHourLine(@PathVariable java.sql.Date startDate, @PathVariable java.sql.Date endDate){
		return perHourAvailabilityLineRepo.getRangePerHourResult(startDate, endDate);
	}
	
	@GetMapping("/perHourAvailabilities/{defaultDate}")
	public List<AvailabilityPerHourLineChart> getDefaultPerHourLine(@PathVariable java.sql.Date defaultDate){
		return perHourAvailabilityLineRepo.getDefaultPerHourResult(defaultDate);
	}
	
	@GetMapping("/mostDownTerminals/{defaultDate}")
	public List<MostDownTerminals> getDefaultMostDownTerminals(@PathVariable java.sql.Date defaultDate){
		return mostDownTerminalRepo.getDefaultDownTerminals(defaultDate);
	}
	
	@GetMapping("/mostDownTerminals/{startDate}/{endDate}")
	public List<MostDownTerminals> getRangedtMostDownTerminals(@PathVariable java.sql.Date startDate, @PathVariable java.sql.Date endDate){
		return mostDownTerminalRepo.getRangedDownTerminals(startDate,endDate);
	}
	
	@GetMapping("/mostUpTerminals/{defaultDate}")
	public List<MostUpTerminals> getDefaultMostUpTerminals(@PathVariable java.sql.Date defaultDate){
		return mostUpTerminalsRepo.getDefaultUpTerminals(defaultDate);
	}
	
	@GetMapping("/mostUpTerminals/{startDate}/{endDate}")
	public List<MostUpTerminals> getRangedtMostUpTerminals(@PathVariable java.sql.Date startDate, @PathVariable java.sql.Date endDate){
		return mostUpTerminalsRepo.getRangedUpTerminals(startDate,endDate);
	}
}
