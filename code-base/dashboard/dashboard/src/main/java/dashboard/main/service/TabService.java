package dashboard.main.service;

import java.util.Date;
import java.util.List;

import dashboard.main.model.*;

public interface TabService {
	List<TabEntity> findAll();

	TabEntity findOne(String terminalId);

	TabEntity saveTab(TabEntity entity);

	void deleteTabs(String terminalId);
	
	//////////////////////////////////////
	List<TabEntity2> findAll2();

	TabEntity2 findTwo(Date operationStart);

	TabEntity2 saveTab(TabEntity2 entity);

	void deleteTabs(Date terminalId);
}
