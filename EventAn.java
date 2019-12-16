package assigment;

import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;
import org.matsim.core.events.MatsimEventsReader;

public class EventAn {

	public static void  main (String[] args) {
		// TODO Auto-generated method stub
EventsManager events = EventsUtils.createEventsManager();
Eventanalysis eventHandler = new Eventanalysis();
events.addHandler(eventHandler);
MatsimEventsReader reader = new MatsimEventsReader(events);
reader.readFile("C:\\Users\\ashutosh\\Desktop\\new output\\output1\\output_events.xml");
eventHandler.writeResults("C:\\Users\\ashutosh\\Desktop\\new output\\output1\\events.txt");
	}

}
