package dashboard.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import dashboard.main.Model.TabEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class InitApplicationTestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(InitApplicationTestService.class);

	@Autowired
	TabService tabService;

	@EventListener(ApplicationReadyEvent.class)
	public void initializeTestData() {
		LOGGER.info("Initialize test data");

		// this inserts a dummy record
		tabService.saveTab(new TabEntity("5", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", true));
		
		// this modifies the dummy record
		tabService.saveTab(new TabEntity("1", "2", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", true));
		
		LOGGER.info("Initialization completed");
	}
}
