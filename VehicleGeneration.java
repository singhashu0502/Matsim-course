package assigment;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.TransportMode;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.vehicles.VehicleWriterV1;
import org.matsim.vehicles.VehicleType;

import org.matsim.vehicles.Vehicles;

public class VehicleGeneration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scenario scenario = ScenarioUtils.loadScenario(ConfigUtils.createConfig());
		Vehicles vehs=scenario.getVehicles();

		VehicleType car= vehs.getFactory().createVehicleType(Id.create(TransportMode.car, VehicleType.class));
		car.setMaximumVelocity(80/3.6);
		car.setPcuEquivalents(1.0);
		vehs.addVehicleType(car);


		VehicleType bicycle= vehs.getFactory().createVehicleType(Id.create("bicycle", VehicleType.class));
		bicycle.setMaximumVelocity(15/3.6);
		bicycle.setPcuEquivalents(.15);
		vehs.addVehicleType(bicycle);

		VehicleType motorcycle= vehs.getFactory().createVehicleType(Id.create(TransportMode.motorcycle, VehicleType.class));
		motorcycle.setMaximumVelocity(45/3.6);
		motorcycle.setPcuEquivalents(.5);
		vehs.addVehicleType(motorcycle);

		new VehicleWriterV1(vehs).writeFile("C:\\Users\\ashutosh\\Desktop\\new output\\vehicles.xml");

	}

}
