package assigment;
import java.util.Random;

import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.TransportMode;
import org.matsim.api.core.v01.population.Activity;
import org.matsim.api.core.v01.population.Leg;
import org.matsim.api.core.v01.population.Person;
import org.matsim.api.core.v01.population.Plan;
import org.matsim.api.core.v01.population.Population;
import org.matsim.api.core.v01.population.PopulationFactory;
import org.matsim.api.core.v01.population.PopulationWriter;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.scenario.ScenarioUtils;
public class GeneratedPopulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Config config=ConfigUtils.createConfig();
		Scenario scenario=ScenarioUtils.loadScenario(config);
		Population pop=scenario.getPopulation();
		PopulationFactory popFact=pop.getFactory();
		Integer arr[]=new Integer[1000];
		Random random = new Random();
		int num;
		
		for(int i=0;i<=999;i++) {
		num = random.nextInt(1000); 
		if (num <= 499) {
			arr[i]=1;
		}
		 if(num<=749) {
		arr[i]=2;
		}
		else if(num<=899) {
		arr[i]=3;
		}
		else if(num<=999) {
		arr[i]=4;
		}
		}
		Integer modes[]=new Integer[1000];
		for(int i=0;i<=999;i++) {
			num = random.nextInt(1000);
		if(num <= 199) {
		modes[i]=1;
		}
		else if(num <= 549) { 
		modes[i]=2;
		}
		else if(num <= 699) { 
		modes[i]=3;
		}
		else if(num <= 799) { 
		modes[i]=4;
		}
		else if(num <= 999) { {
		modes[i]=5;
		}}
		}
		int k=0;
		for(int i1=0;i1<=999;i1++) {
		//System.out.println(arr[i]);

		if(arr[i1]==1) {
		Person person=popFact.createPerson(Id.createPersonId(""+k));
		double x1=10000*Math.random();
		double y1=5000*Math.random();
		Plan plan=popFact.createPlan();
		Activity home=popFact.createActivityFromCoord("home", new Coord(x1,y1));
		double time=8+2*Math.random();
		home.setEndTime(3600*time);
		plan.addActivity(home);


		if( modes[i1]==1 ) {
		Leg leg1=popFact.createLeg(TransportMode.car);
		plan.addLeg(leg1);
		}
		else if(modes[i1]==2) {
		Leg leg1=popFact.createLeg(TransportMode.motorcycle);
		plan.addLeg(leg1);
		}
		else if(modes[i1]==3) {
		Leg leg1=popFact.createLeg("bicycle");
		plan.addLeg(leg1);
		}
		else if(modes[i1]==4) {
		Leg leg1=popFact.createLeg(TransportMode.walk);
		plan.addLeg(leg1);
		}
		else if(modes[i1]==5) {
		Leg leg1=popFact.createLeg(TransportMode.pt);
		plan.addLeg(leg1);
		}

		double x2=5000*Math.random()+5000,y2=5000*Math.random()+5000;
		Activity work=popFact.createActivityFromCoord("work",new Coord(x2,y2));
		work.setEndTime((8+.4+time)*3600);
		plan.addActivity(work);
		if( modes[i1]==1 ) {
		Leg leg2=popFact.createLeg(TransportMode.car);
		plan.addLeg(leg2);
		}
		else if(modes[i1]==2) {
		Leg leg2=popFact.createLeg(TransportMode.motorcycle);
		plan.addLeg(leg2);
		}
		else if(modes[i1]==3) {
		Leg leg2=popFact.createLeg("bicycle");
		plan.addLeg(leg2);
		}
		else if(modes[i1]==4) {
		Leg leg2=popFact.createLeg(TransportMode.walk);
		plan.addLeg(leg2);
		}
		else if(modes[i1]==5) {
		Leg leg2=popFact.createLeg(TransportMode.pt);
		plan.addLeg(leg2);
		}
		Activity home1=popFact.createActivityFromCoord("home", new Coord(x1,y1));
		plan.addActivity(home1);
		person.addPlan(plan);
		pop.addPerson(person);
		k++;
		}

		if(arr[i1]==2) {
		Person person=popFact.createPerson(Id.createPersonId(""+k));
		double x1=10000*Math.random();
		double y1=5000*Math.random();
		Plan plan=popFact.createPlan();
		Activity home=popFact.createActivityFromCoord("home", new Coord(x1,y1));
		double time=8+2*Math.random();
		home.setEndTime(3600*time);
		plan.addActivity(home);


		if( modes[i1]==1 ) {
		Leg leg1=popFact.createLeg(TransportMode.car);
		plan.addLeg(leg1);
		}
		else if(modes[i1]==2) {
		Leg leg1=popFact.createLeg(TransportMode.motorcycle);
		plan.addLeg(leg1);
		}
		else if(modes[i1]==3) {
		Leg leg1=popFact.createLeg("bicycle");
		plan.addLeg(leg1);
		}
		else if(modes[i1]==4) {
		Leg leg1=popFact.createLeg(TransportMode.walk);
		plan.addLeg(leg1);
		}
		else if(modes[i1]==5) {
		Leg leg1=popFact.createLeg(TransportMode.pt);
		plan.addLeg(leg1);
		}

		double x2=5000*Math.random(),y2=5000*Math.random()+5000;
		Activity education=popFact.createActivityFromCoord("education",new Coord(x2,y2));
		education.setEndTime((time+6+.7)*3600);
		plan.addActivity(education);
		if( modes[i1]==1 ) {
		Leg leg2=popFact.createLeg(TransportMode.car);
		plan.addLeg(leg2);
		}
		else if(modes[i1]==2) {
		Leg leg2=popFact.createLeg(TransportMode.motorcycle);
		plan.addLeg(leg2);
		}
		else if(modes[i1]==3) {
		Leg leg2=popFact.createLeg("bicycle");
		plan.addLeg(leg2);
		}
		else if(modes[i1]==4) {
		Leg leg2=popFact.createLeg(TransportMode.walk);
		plan.addLeg(leg2);
		}
		else if(modes[i1]==5) {
		Leg leg2=popFact.createLeg(TransportMode.pt);
		plan.addLeg(leg2);
		}
		Activity home1=popFact.createActivityFromCoord("home", new Coord(x1,y1));
		plan.addActivity(home1);
		person.addPlan(plan);
		pop.addPerson(person);
		k++;
		}
		if(arr[i1]==3) {
		Person person=popFact.createPerson(Id.createPersonId(""+k));
		double x1=10000*Math.random();
		double y1=5000*Math.random();
		Plan plan=popFact.createPlan();
		Activity home=popFact.createActivityFromCoord("home", new Coord(x1,y1));
		double time=8+2*Math.random();
		home.setEndTime(3600*time);
		plan.addActivity(home);


		if( modes[i1]==1 ) {
		Leg leg1=popFact.createLeg(TransportMode.car);
		plan.addLeg(leg1);
		}
		else if(modes[i1]==2) {
		Leg leg1=popFact.createLeg(TransportMode.motorcycle);
		plan.addLeg(leg1);
		}
		else if(modes[i1]==3) {
		Leg leg1=popFact.createLeg("bicycle");
		plan.addLeg(leg1);
		}
		else if(modes[i1]==4) {
		Leg leg1=popFact.createLeg(TransportMode.walk);
		plan.addLeg(leg1);
		}
		else if(modes[i1]==5) {
		Leg leg1=popFact.createLeg(TransportMode.pt);
		plan.addLeg(leg1);
		}

		double x2=2500*Math.random()+2500,y2=2500*Math.random()+2500;
		Activity leisure=popFact.createActivityFromCoord("leisure",new Coord(x2,y2));
		leisure.setEndTime((4+.46+time)*3600);
		plan.addActivity(leisure);
		if( modes[i1]==1 ) {
		Leg leg2=popFact.createLeg(TransportMode.car);
		plan.addLeg(leg2);
		}
		else if(modes[i1]==2) {
		Leg leg2=popFact.createLeg(TransportMode.motorcycle);
		plan.addLeg(leg2);
		}
		else if(modes[i1]==3) {
		Leg leg2=popFact.createLeg("bicycle");
		plan.addLeg(leg2);
		}
		else if(modes[i1]==4) {
		Leg leg2=popFact.createLeg(TransportMode.walk);
		plan.addLeg(leg2);
		}
		else if(modes[i1]==5) {
		Leg leg2=popFact.createLeg(TransportMode.pt);
		plan.addLeg(leg2);
		}
		Activity home1=popFact.createActivityFromCoord("home", new Coord(x1,y1));
		plan.addActivity(home1);
		person.addPlan(plan);
		pop.addPerson(person);
		k++;
		}
		if(arr[i1]==4) {
		Person person=popFact.createPerson(Id.createPersonId(""+k));
		double x1=10000*Math.random();
		double y1=5000*Math.random();
		Plan plan=popFact.createPlan();
		Activity home=popFact.createActivityFromCoord("home", new Coord(x1,y1));
		double time=8+2*Math.random();
		home.setEndTime(3600*time);
		plan.addActivity(home);


		if( modes[i1]==1 ) {
		Leg leg1=popFact.createLeg(TransportMode.car);
		plan.addLeg(leg1);
		}
		else if(modes[i1]==2) {
		Leg leg1=popFact.createLeg(TransportMode.motorcycle);
		plan.addLeg(leg1);
		}
		else if(modes[i1]==3) {
		Leg leg1=popFact.createLeg("bicycle");
		plan.addLeg(leg1);
		}
		else if(modes[i1]==4) {
		Leg leg1=popFact.createLeg(TransportMode.walk);
		plan.addLeg(leg1);
		}
		else if(modes[i1]==5) {
		Leg leg1=popFact.createLeg(TransportMode.pt);
		plan.addLeg(leg1);
		}

		double x2=7500,y2=2500*Math.random()+5000;
		Activity other=popFact.createActivityFromCoord("other",new Coord(x2,y2));
		other.setEndTime((time+.5+6)*3600);
		plan.addActivity(other);
		if( modes[i1]==1 ) {
		Leg leg2=popFact.createLeg(TransportMode.car);
		plan.addLeg(leg2);
		}
		else if(modes[i1]==2) {
		Leg leg2=popFact.createLeg(TransportMode.motorcycle);
		plan.addLeg(leg2);
		}
		else if(modes[i1]==3) {
		Leg leg2=popFact.createLeg("bicycle");
		plan.addLeg(leg2);
		}
		else if(modes[i1]==4) {
		Leg leg2=popFact.createLeg(TransportMode.walk);
		plan.addLeg(leg2);
		}
		else if(modes[i1]==5) {
		Leg leg2=popFact.createLeg(TransportMode.pt);
		plan.addLeg(leg2);
		}
		Activity home1=popFact.createActivityFromCoord("home", new Coord(x1,y1));
		plan.addActivity(home1);
		person.addPlan(plan);
		pop.addPerson(person);
		k++;
		}
		}

		new PopulationWriter(pop).write("C:\\Users\\ashutosh\\Desktop\\new output\\plan.xml");
	}

	private static Random nextInt(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
