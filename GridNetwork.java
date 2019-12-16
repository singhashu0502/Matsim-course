package trial;


	

	import org.matsim.api.core.v01.Coord;
	import org.matsim.api.core.v01.Id;
	import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.TransportMode;
import org.matsim.api.core.v01.network.*;
	import org.matsim.core.config.ConfigUtils;
	import org.matsim.core.network.NetworkUtils;
	import org.matsim.core.scenario.ScenarioUtils;

	import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

	public class Gridnetwork {

	    Gridnetwork () {
	        Scenario scenario = ScenarioUtils.loadScenario(ConfigUtils.createConfig());
	        network = scenario.getNetwork();
	        networkFactory = network.getFactory();
	    }

	    private Network network;
	    private Map<Coord, Id<Node>> coordToNodeId = new HashMap<>();
	    private NetworkFactory networkFactory;

	    public static void main(String[] args) {
	        new Gridnetwork().run();
	    }

	    public void run() {
	    	Set<String> majorArterialModes = new HashSet<String>();
	        majorArterialModes.add(TransportMode.car);
	       
	        majorArterialModes.add(TransportMode.motorcycle);
	        // major artrials at every 500m [nodes also at 250 to connect arterials with them
	        createLinks(new Coord(0.,0.), new Coord[] {new Coord(2500,0), new Coord(0,2500)},
	                10000.0, 3,22.2222,majorArterialModes);
	        createLinks(new Coord(10000,10000), new Coord[] {new Coord(-2500,0), new Coord(0,-2500)},
	                10000.0, 3,22.2222,majorArterialModes);
	        createLinks(new Coord(5000.,5000.), new Coord[] {new Coord(2500.0, 0.)},
	                5000.0, 3,22.2222,majorArterialModes);
	        createLinks(new Coord(5000.,5000.), new Coord[] { new Coord(0,2500)},
	                5000.0, 3,22.2222,majorArterialModes);
	        createLinks(new Coord(5000.,5000.), new Coord[] {new Coord(-2500,0)},
	                5000.0, 3,22.2222,majorArterialModes);
	        createLinks(new Coord(5000.,5000.), new Coord[] { new Coord(0,-2500)},
	                5000.0, 3,22.2222,majorArterialModes);

	        //arterials at every 2500m [nodes also at 1000m to connect with sub-arterials]
	        Set<String> arterialModes = new HashSet<String>();
	        arterialModes.add(TransportMode.car);
	        
	        arterialModes.add(TransportMode.motorcycle);
	        arterialModes.add("bicycle");
	        createLinks(new Coord(0.,2500.), new Coord[] {new Coord(1000,0)},
	                10000.0, 2,16.6667,arterialModes);
	        createLinks(new Coord(0.,7500.), new Coord[] {new Coord(1000,0)},
	                10000.0, 2,16.6667,arterialModes);
	        createLinks(new Coord(2500.,0.), new Coord[] {new Coord(0,1000)},
	                10000.0, 2,16.6667,arterialModes);
	        createLinks(new Coord(7500.,0.), new Coord[] {new Coord(0,1000)},
	                10000.0, 2,16.6667,arterialModes);

	        //sub-arterials at every 1000m
	        for (int i=1; i<=9; i++){
	            if (i==5) continue;
	            createLinks(new Coord(0.,1000.*i), new Coord[] {new Coord(1000,0)},
	                    2000.0, 1,16.6667,arterialModes);
	            createLinks(new Coord(2000.,1000.*i), new Coord[] {new Coord(500,0)},
	                    1000.0, 1,16.6667,arterialModes);
	            createLinks(new Coord(3000.,1000.*i), new Coord[] {new Coord(1000,0)},
	                    4000.0, 1,16.6667,arterialModes);
	            createLinks(new Coord(7000.,1000.*i), new Coord[] {new Coord(500,0)},
	                    1000.0, 1,16.6667,arterialModes);
	            createLinks(new Coord(8000.,1000.*i), new Coord[] {new Coord(1000,0)},
	                    2000.0, 1,16.6667,arterialModes);

	            createLinks(new Coord(1000.*i,0), new Coord[] {new Coord(0,1000)},
	                    2000.0, 1,16.6667,arterialModes);
	            createLinks(new Coord(1000.*i,2000), new Coord[] {new Coord(0,500)},
	                    1000.0, 1,16.6667,arterialModes);
	            createLinks(new Coord(1000.*i,3000), new Coord[] {new Coord(0,1000)},
	                    4000.0, 1,16.6667,arterialModes);
	            createLinks(new Coord(1000.*i,7000), new Coord[] {new Coord(0,500)},
	                    1000.0, 1,16.6667,arterialModes);
	            createLinks(new Coord(1000.*i,8000), new Coord[] {new Coord(0,1000)},
	                    2000.0, 1,16.6667,arterialModes);
	        }
	        new NetworkWriter(network).write("C:\\Users\\ashutosh\\Desktop\\output\\ashu.xml");
	    }

	    private void createLinks(Coord initialCoord, Coord[] increaments, double lengthToMove, double numberOfLanes,double permissibleSpeed, Set<String> hash_Set){
	        for (Coord increm : increaments) {
	            double length =0.;
	            while(length < lengthToMove){
	                Node fromNode = getOrCreateNode(initialCoord);

	                Coord nextCoord = new Coord(initialCoord.getX()+increm.getX(), initialCoord.getY() +increm.getY() );
	                Node toNode = getOrCreateNode(nextCoord);

	                Link link = networkFactory.createLink(Id.createLinkId(network.getLinks().size()+1),fromNode, toNode);
	                link.setNumberOfLanes(numberOfLanes);
	                double linkLength = NetworkUtils.getEuclideanDistance(initialCoord, nextCoord);
	                network.addLink(link);

	                Link revLink = networkFactory.createLink(Id.createLinkId(network.getLinks().size()+1),toNode, fromNode);
	                revLink.setNumberOfLanes(numberOfLanes);
	                revLink.setFreespeed(permissibleSpeed);
	                revLink.setAllowedModes(hash_Set);
	               
	                network.addLink(revLink);
	                //set link attributes

	                length += linkLength;
	                initialCoord = nextCoord;
	            }
	        }
	    }

	    public  Node getOrCreateNode(Coord cord) {
	        Id<Node> nodeId = coordToNodeId.get(cord);
	        if (nodeId == null){
	            nodeId = Id.createNodeId(network.getNodes().size()+1);
	            Node node = networkFactory.createNode(nodeId, cord);
	            network.addNode(node);
	            coordToNodeId.put(cord, nodeId);
	            return node;
	        } else {
	            return network.getNodes().get(nodeId);
	        }
	    }
	

		

	}


