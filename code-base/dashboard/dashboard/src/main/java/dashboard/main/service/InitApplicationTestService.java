package dashboard.main.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class InitApplicationTestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitApplicationTestService.class);

    @Autowired
    InventoryService inventoryService;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeTestData() {
        LOGGER.info("Initialize test data");


        LOGGER.info("Initialization completed");
    }
}
