package trial;

import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.config.groups.ControlerConfigGroup;
import org.matsim.core.config.groups.NetworkConfigGroup;
import org.matsim.core.config.groups.QSimConfigGroup;
import org.matsim.core.controler.Controler;
import org.matsim.core.scenario.ScenarioUtils;

public class NEWCONFIG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Config config = ConfigUtils.loadConfig("C:\\Users\\ashutosh\\git\\matsim-code-examples\\scenarios\\equil\\config.xml");
ControlerConfigGroup ccg= config.controler();
ccg.setFirstIteration(0);
ccg.setLastIteration(15);
ccg.setOutputDirectory("C:\\Users\\ashutosh\\Desktop\\output");
QSimConfigGroup qcg=config.qsim();
qcg.setFlowCapFactor(.2);
qcg.setStorageCapFactor(.4);
//NetworkConfigGroup ncg=config.network();
//ncg.

	Scenario scenario=ScenarioUtils.loadScenario(config);
//Network network=scenario.addScenarioElement(   , o);	

	Controler controler = new Controler(scenario);
	
	controler.run();
	}
	

}
