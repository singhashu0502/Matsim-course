package assigment;
import java.util.Arrays;

import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.TransportMode;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.config.ConfigWriter;
import org.matsim.core.config.groups.ControlerConfigGroup;
//import org.matsim.core.config.ConfigWriter;
import org.matsim.core.config.groups.PlanCalcScoreConfigGroup;
import org.matsim.core.config.groups.PlanCalcScoreConfigGroup.ActivityParams;
import org.matsim.core.config.groups.PlanCalcScoreConfigGroup.ModeParams;
import org.matsim.core.config.groups.PlansCalcRouteConfigGroup;
import org.matsim.core.config.groups.PlansCalcRouteConfigGroup.ModeRoutingParams;
import org.matsim.core.config.groups.QSimConfigGroup;
import org.matsim.core.config.groups.QSimConfigGroup.LinkDynamics;
import org.matsim.core.config.groups.QSimConfigGroup.VehiclesSource;
import org.matsim.core.controler.Controler;
import org.matsim.core.network.NetworkChangeEvent;
import org.matsim.core.network.NetworkChangeEvent.ChangeType;
import org.matsim.core.network.NetworkChangeEvent.ChangeValue;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.replanning.strategies.DefaultPlanStrategiesModule.DefaultStrategy;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.core.config.groups.StrategyConfigGroup;
import org.matsim.core.config.groups.StrategyConfigGroup.StrategySettings;
//import org.matsim.core.config.groups.StrategyConfigGroup.StrategySettings;
import org.matsim.core.config.groups.TravelTimeCalculatorConfigGroup;

public class NewConfig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Config config=ConfigUtils.createConfig();

		ControlerConfigGroup ccg=config.controler();
		ccg.setFirstIteration(0);
		ccg.setLastIteration(20);
		ccg.setOutputDirectory("C:\\Users\\ashutosh\\Desktop\\new output\\output1");

		QSimConfigGroup qsim =config.qsim();
		qsim.setFlowCapFactor(.01);
		qsim.setStorageCapFactor(.03);
		qsim.setLinkDynamics(LinkDynamics.PassingQ);
		qsim.setMainModes(Arrays.asList(TransportMode.car,TransportMode.motorcycle,"bicycle"));
		qsim.setVehiclesSource(VehiclesSource.modeVehicleTypesFromVehiclesData);

		StrategyConfigGroup strategy=config.strategy();
		StrategySettings reroute=new StrategySettings();
		reroute.setStrategyName(DefaultStrategy.ReRoute.toString());
		reroute.setWeight(.4);
		strategy.addStrategySettings(reroute);
		// strategy.setFractionOfIterationsToDisableInnovation(0.8);
		
		// mode change strategy
		StrategySettings modechange =new StrategySettings();
		modechange.setStrategyName(DefaultStrategy.ChangeTripMode);
		modechange.setWeight(.15);
		strategy.addStrategySettings(modechange);
		
		
		
		PlanCalcScoreConfigGroup scoreConfigGroup=config.planCalcScore();
		ActivityParams home=new ActivityParams("home");
		home.setTypicalDuration(12*3600);
		scoreConfigGroup.addActivityParams(home);

		ActivityParams work=new ActivityParams("work");
		work.setTypicalDuration(9*3600);
		scoreConfigGroup.addActivityParams(work);

		ActivityParams education=new ActivityParams("education");
		education.setTypicalDuration(6*3600);
		scoreConfigGroup.addActivityParams(education);

		ActivityParams leisure=new ActivityParams("leisure");
		leisure.setTypicalDuration(4*3600);
		scoreConfigGroup.addActivityParams(leisure);

		ActivityParams other=new ActivityParams("other");
		other.setTypicalDuration(6*3600);
		scoreConfigGroup.addActivityParams(other);

		ModeParams car=new ModeParams(TransportMode.car);
		car.setConstant(0);
		car.setMarginalUtilityOfTraveling(-6);
		scoreConfigGroup.addModeParams(car);

		ModeParams motorcycle=new ModeParams(TransportMode.motorcycle);
		motorcycle.setConstant(0);
		motorcycle.setMarginalUtilityOfTraveling(-2);
		scoreConfigGroup.addModeParams(motorcycle);

		ModeParams bicycle=new ModeParams("bicycle");
		bicycle.setConstant(0);
		bicycle.setMarginalUtilityOfTraveling(-6);
		scoreConfigGroup.addModeParams(bicycle);

		PlansCalcRouteConfigGroup routeConfigGroup= config.plansCalcRoute();

		//routeConfigGroup.setClearingDefaultModeRoutingParams(true);
		routeConfigGroup.setNetworkModes(Arrays.asList(TransportMode.car,TransportMode.motorcycle,"bicycle"));

		ModeRoutingParams pt=new ModeRoutingParams(TransportMode.pt);
		pt.setBeelineDistanceFactor(1.3);
		pt.setTeleportedModeFreespeedFactor(1.5);
		routeConfigGroup.addModeRoutingParams(pt);


		ModeRoutingParams walk=new ModeRoutingParams(TransportMode.walk);
		walk.setBeelineDistanceFactor(1.0);
		walk.setTeleportedModeFreespeedFactor(2.0);
		routeConfigGroup.addModeRoutingParams(walk);

		TravelTimeCalculatorConfigGroup ttccg=config.travelTimeCalculator();
		ttccg.setSeparateModes(true);
		ttccg.setAnalyzedModesAsString(TransportMode.car+TransportMode.motorcycle+"bicycle");
		
		
		//config.network().setTimeVariantNetwork(true);




		config.network().setInputFile("C:\\Users\\ashutosh\\Desktop\\new output\\GridsNews1.xml");
		config.plans().setInputFile("C:\\Users\\ashutosh\\Desktop\\new output\\plan.xml");
		config.vehicles().setVehiclesFile("C:\\Users\\ashutosh\\Desktop\\new output\\vehicles.xml");

		
		Scenario scenario=ScenarioUtils.loadScenario(config);
		
		//NetworkChangeEvent e1 = new NetworkChangeEvent(17*3600);
		//e1.addLinks(scenario.getNetwork().getLinks().values());
		//ChangeValue cv =new ChangeValue(ChangeType.FACTOR, 0.5);
		//e1.setFlowCapacityChange(cv);
		//NetworkUtils.addNetworkChangeEvent(scenario.getNetwork(), e1);
		Controler controler= new Controler(scenario);
		controler.run();
	}

}
