package assigment;

import java.awt.Event;
import java.io.BufferedWriter;

import org.matsim.api.core.v01.events.LinkEnterEvent;
import org.matsim.api.core.v01.events.handler.LinkEnterEventHandler;
import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;
import org.matsim.core.events.MatsimEventsReader;
import org.matsim.core.utils.io.IOUtils;

public class Eventanalysis implements LinkEnterEventHandler {

	public void handleEvent(LinkEnterEvent event) {
		if (event.getTime() >= 15 * 3600) {
			System.out.println(event.toString());
		}

		System.out.println(event.toString());
//		// TODO Auto-generated method stub
	}

	public void reset(int iteration) {
	}

	public void writeResults(String out) {
		// TODO Auto-generated method stub
		BufferedWriter writer =IOUtils.getBufferedWriter(out);
		try {
			for(Event event:events) {
				writer.write(event.toString());
				writer.newLine();
			}
		}
	}
	

	// TODO Auto-generated method stu
