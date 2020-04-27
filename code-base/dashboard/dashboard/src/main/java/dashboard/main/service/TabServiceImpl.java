package dashboard.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dashboard.main.Model.TabEntity;
import dashboard.main.Model.TabEntity2;
import dashboard.main.Model.TabEntity3;
import dashboard.main.Model.TabEntity4;
import dashboard.main.Model.TabEntity5;
import dashboard.main.Model.TabEntity6;
import dashboard.main.Model.TabEntity7;
import dashboard.main.repository.*;

@Service
public class TabServiceImpl implements TabService {

	@Autowired
	private TabRepository tabRepository;
	@Autowired
	private TabRepository2 tabRepository2;
	@Autowired
	private TabRepository3 tabRepository3;
	@Autowired
	private TabRepository4 tabRepository4;
	@Autowired
	private TabRepository5 tabRepository5;
	@Autowired
	private TabRepository6 tabRepository6;
	@Autowired
	private TabRepository7 tabRepository7;

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

////////////////////////////////////////////////////////

	@Override
	public List<TabEntity2> findAll2() {
		return tabRepository2.findAll();
	}

	@Override
	public TabEntity2 findTwo(String terminalId) {
		return tabRepository2.findByTerminalId(terminalId);
	}

	@Override
	public TabEntity2 saveTab(TabEntity2 entity) {
		return tabRepository2.save(entity);
	}

/////////////////////////////////////////////////////////

	@Override
	public List<TabEntity3> findAll3() {
		return tabRepository3.findAll();
	}

	@Override
	public TabEntity3 findThree(String terminalId) {
		return tabRepository3.findByTerminalId(terminalId);
	}

	@Override
	public TabEntity3 saveTab(TabEntity3 entity) {
		return tabRepository3.save(entity);
	}

/////////////////////////////////////////////////////////

	@Override
	public List<TabEntity4> findAll4() {
		return tabRepository4.findAll4();
	}

	@Override
	public TabEntity4 findFour(String terminalId) {
		return tabRepository4.findByTerminalId(terminalId);
	}

	@Override
	public TabEntity4 saveTab(TabEntity4 entity) {
		return tabRepository4.save(entity);
	}

/////////////////////////////////////////////////////////

	@Override
	public List<TabEntity5> findAll5() {
		return tabRepository5.findAll5();
	}

	@Override
	public TabEntity5 findFive(String terminalId) {
		return tabRepository5.findByTerminalId(terminalId);
	}

	@Override
	public TabEntity5 saveTab(TabEntity5 entity) {
		return tabRepository5.save(entity);
	}

/////////////////////////////////////////////////////////

	@Override
	public List<TabEntity6> findAll6() {
		return tabRepository6.findAll6();
	}

	@Override
	public TabEntity6 findSix(String terminalId) {
		return tabRepository6.findByTerminalId(terminalId);
	}

	@Override
	public TabEntity6 saveTab(TabEntity6 entity) {
		return tabRepository6.save(entity);
	}

/////////////////////////////////////////////////////////

	@Override
	public List<TabEntity7> findAll7() {
		return tabRepository7.findAll7();
	}

	@Override
	public TabEntity7 findSeven(String terminalId) {
		return tabRepository7.findByTerminalId(terminalId);
	}

	@Override
	public TabEntity7 saveTab(TabEntity7 entity) {
		return tabRepository7.save(entity);
	}

}
