package dashboard.main.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dashboard.main.model.TabEntity;
import dashboard.main.model.TabEntity2;
import dashboard.main.repository.*;

@Service
public class TabServiceImpl implements TabService {

	@Autowired
	private TabRepository tabRepository;

	@Override
	public List<TabEntity> findAll() {
		return tabRepository.findAll();
	}

	@Override
	public TabEntity findOne(String terminalId) {
		return tabRepository.findByTerminalId(terminalId);
	}

	@Override
	public TabEntity saveTab(TabEntity entity) {
		return tabRepository.save(entity);
	}

	@Override
	public void deleteTabs(String terminalId) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void deleteTabs(String terminalId) {
//		tabRepository.deleteById(terminalId);
//	}
	
	////////////////////////////////////////////////////////
	@Override
	public List<TabEntity2> findAll2() {
		return tabRepository.findAll2();
	}

	@Override
	public TabEntity2 findTwo(Date operationStart) {
		return tabRepository.findByOperationStart(operationStart);
	}

	@Override
	public TabEntity2 saveTab(TabEntity2 entity) {
		return tabRepository.save(entity);
	}

	@Override
	public void deleteTabs(Date terminalId) {
		// TODO Auto-generated method stub
		
	}
}
