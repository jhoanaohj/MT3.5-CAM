package dashboard.main.service;

import java.util.List;

import dashboard.main.Model.TabEntity;
import dashboard.main.Model.TabEntity2;
import dashboard.main.Model.TabEntity3;
import dashboard.main.Model.TabEntity4;
import dashboard.main.Model.TabEntity5;
import dashboard.main.Model.TabEntity6;
import dashboard.main.Model.TabEntity7;


public interface TabService {
	List<TabEntity> findAll();

	TabEntity findOne(String terminalId);

	TabEntity saveTab(TabEntity entity);

//////////////////////////////////////

	List<TabEntity2> findAll2();

	TabEntity2 findTwo(String terminalId);

	TabEntity2 saveTab(TabEntity2 entity);

//////////////////////////////////////

	List<TabEntity3> findAll3();

	TabEntity3 findThree(String terminalId);

	TabEntity3 saveTab(TabEntity3 entity);

//////////////////////////////////////

	List<TabEntity4> findAll4();

	TabEntity4 findFour(String terminalId);

	TabEntity4 saveTab(TabEntity4 entity);

//////////////////////////////////////

	List<TabEntity5> findAll5();

	TabEntity5 findFive(String terminalId);

	TabEntity5 saveTab(TabEntity5 entity);

//////////////////////////////////////

	List<TabEntity6> findAll6();

	TabEntity6 findSix(String terminalId);

	TabEntity6 saveTab(TabEntity6 entity);

//////////////////////////////////////

	List<TabEntity7> findAll7();

	TabEntity7 findSeven(String terminalId);

	TabEntity7 saveTab(TabEntity7 entity);

}
