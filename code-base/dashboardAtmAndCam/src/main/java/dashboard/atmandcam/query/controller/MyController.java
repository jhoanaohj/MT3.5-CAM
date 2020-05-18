package dashboard.atmandcam.query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dashboard.atmandcam.model.AvailabilityPerHourLineChart;
import dashboard.atmandcam.model.AvailabilityPerMonth;
import dashboard.atmandcam.model.AvailabilityPerRegion;
import dashboard.atmandcam.model.AvailabilityPlannedUnplanned;
import dashboard.atmandcam.model.DownUptimeComparison;
import dashboard.atmandcam.model.MostDownTerminals;
import dashboard.atmandcam.model.MostUpTerminals;
import dashboard.atmandcam.model.MyModel;
import dashboard.atmandcam.model.PlannedUnplannedEventCount;
import dashboard.atmandcam.model.TestModel;
import dashboard.atmandcam.model.Top5Downtime;
import dashboard.atmandcam.repo.AvailabilityPerMonthRepo;
import dashboard.atmandcam.repo.AvailabilityPerRegionRepo;
import dashboard.atmandcam.repo.AvailabilityPlannedUnplannedRepo;
import dashboard.atmandcam.repo.DownUptimeComparisonRepo;
import dashboard.atmandcam.repo.MostDownTerminalsRepo;
import dashboard.atmandcam.repo.MostUpTerminalsRepo;
import dashboard.atmandcam.repo.MyRepo;
import dashboard.atmandcam.repo.PerHourAvailabilityLineRepo;
import dashboard.atmandcam.repo.PlannedUnplannedEventCountRepo;
import dashboard.atmandcam.repo.TestModelRepo;
import dashboard.atmandcam.repo.Top5DowntimeRepo;

@RestController
public class MyController {
	
	@Autowired
	private MyRepo myRepo;
	
	@Autowired
	private Top5DowntimeRepo top5down;
	
	@Autowired
	private AvailabilityPerRegionRepo highAvailRepo;
	
	@Autowired
	private PerHourAvailabilityLineRepo perHourAvailabilityLineRepo;
	
	@Autowired
	private MostDownTerminalsRepo mostDownTerminalRepo;
	
	@Autowired
	private MostUpTerminalsRepo mostUpTerminalsRepo;
	
	@Autowired
	private AvailabilityPerMonthRepo availabilityPerMonthRepo;
	
	@Autowired
	private AvailabilityPlannedUnplannedRepo availabilityPlannedUnplannedRepo;
	
	@Autowired
	private PlannedUnplannedEventCountRepo plannedUnplannedEventCountRepo;
	
	@Autowired
	private DownUptimeComparisonRepo downUptimeComparisonRepo;
	
	@Autowired
	private TestModelRepo testModelRepo;
	
	
	@GetMapping("/testresult/{startDate}")
	public List<TestModel> getTestSingleResult(@PathVariable java.sql.Date startDate){
		return testModelRepo.getTestSingleResult(startDate);
	}
	
	@GetMapping("/testresult/{startDate}/{endDate}")
	public List<TestModel> getTestSingleResult(@PathVariable java.sql.Date startDate, @PathVariable java.sql.Date endDate){
		return testModelRepo.getTestRangedResult(startDate, endDate);
	}
	
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
	public List<AvailabilityPerRegion> getHighAvail(@PathVariable java.sql.Date defaultDate){
		return highAvailRepo.getHighAvailability(defaultDate);
	}
	
	@GetMapping("/highAvailabilities/{startDate}/{endDate}")
	public List<AvailabilityPerRegion> getHighAvails(@PathVariable java.sql.Date startDate, @PathVariable java.sql.Date endDate){
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
	
	@GetMapping("/availabilityPerMonth/{lastMonStartDate}/{lastMonEndDate}/{currMonStartDate}/{currMonEndDate}/{nextMonStartDate}/{nextMonEndDate}")
	public List<AvailabilityPerMonth> getAvailabilityPerMonth(@PathVariable java.sql.Date lastMonStartDate, @PathVariable java.sql.Date lastMonEndDate, @PathVariable java.sql.Date currMonStartDate, @PathVariable java.sql.Date currMonEndDate, @PathVariable java.sql.Date nextMonStartDate, @PathVariable java.sql.Date nextMonEndDate){
		return availabilityPerMonthRepo.getAvailPerMonth(lastMonStartDate, lastMonEndDate, currMonStartDate, currMonEndDate, nextMonStartDate, nextMonEndDate);
	}
	
	@GetMapping("/plannedvsunplanned/{startDate}")
	public List<AvailabilityPlannedUnplanned> getPlannedUnplannedResult(@PathVariable java.sql.Date startDate){
		return availabilityPlannedUnplannedRepo.getPlannedUnplannedSingleResult(startDate);
	}
	
	@GetMapping("/plannedvsunplanned/{startDate}/{endDate}")
	public List<AvailabilityPlannedUnplanned> getPlannedUnplannedResults(@PathVariable java.sql.Date startDate, @PathVariable java.sql.Date endDate){
		return availabilityPlannedUnplannedRepo.getPlannedUnplannedRangedResult(startDate, endDate);
	}
	
	@GetMapping("/plannedResult/{startDate}")
	public List<PlannedUnplannedEventCount> getPlannedSingleResults(@PathVariable java.sql.Date startDate){
		return plannedUnplannedEventCountRepo.getPlannedSingleResult(startDate);
	}
	
	@GetMapping("/plannedResult/{startDate}/{endDate}")
	public List<PlannedUnplannedEventCount> getPlannedRangedResults(@PathVariable java.sql.Date startDate, @PathVariable java.sql.Date endDate){
		return plannedUnplannedEventCountRepo.getPlannedRangedResult(startDate, endDate);
	}
	
	@GetMapping("/unplannedResult/{startDate}")
	public List<PlannedUnplannedEventCount> getUnplannedSingleResults(@PathVariable java.sql.Date startDate){
		return plannedUnplannedEventCountRepo.getUnplannedSingleResult(startDate);
	}
	
	@GetMapping("/unplannedResult/{startDate}/{endDate}")
	public List<PlannedUnplannedEventCount> getUnplannedRangedResults(@PathVariable java.sql.Date startDate, @PathVariable java.sql.Date endDate){
		return plannedUnplannedEventCountRepo.getUnplannedRangedResult(startDate, endDate);
	}
	
	@GetMapping("/upvsdowntimepercent/{startDate}")
	public List<DownUptimeComparison> getTotalUpDownSinglePercentage(@PathVariable java.sql.Date startDate){
		return downUptimeComparisonRepo.getDownVsUpSinglePercentage(startDate);
	}
	
	@GetMapping("/upvsdowntimepercent/{startDate}/{endDate}")
	public List<DownUptimeComparison> getTotalUpDownRangedPercentage(@PathVariable java.sql.Date startDate, @PathVariable java.sql.Date endDate){
		return downUptimeComparisonRepo.getDownVsUpRangedPercentage(startDate, endDate);
	}
	
	
	
}
