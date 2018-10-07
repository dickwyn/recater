import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
    	ArrayList<User> consumers = new ArrayList<User>();
    	
    	while (true) {
    		Scanner scan = new Scanner(System.in);

    		String decision;
        	String yes = "Y";
        	String no = "N";

    		System.out.println("Do you want to create, type Y or N?");
    		decision = scan.nextLine();

        	if (decision.equals(yes)) {
        		printMenu(scan);
    		}
    	}
	}

	System.out.println("Okay, Thank you for using our service");

	public Map<Integer, User> sortConsumers(User dist, ArrayList<User> consumers) {
		Map<Integer, User> rankedConsumers = new HashMap<Integer, User>(consumers.size());

		for (User c : consumers) {
			int rank = dist.compareTo(c);
			if (rank >= 0) {
				while (rankedConsumers.containsKey(rank)) {
					rank++;
				}

				rankedConsumers.put(rank, c);
			}
		}

		return rankedConsumers;
	}

	public void requestCosumers(Distributor dist, ArrayList<User> consumers) {
		TreeMap<Integer, User> rankedConsumers = new TreeMap(sortConsumers((User) dist, consumers));

		boolean confirmed = false;
		for (int k : rankedConsumers.keySet()) {
			long startTime = System.currentTimeMillis(); // fetch starting time
			while (!confirmed || (System.currentTimeMillis() - startTime) < 10000) {
				System.out.println("Sending request to " + rankedConsumers.get(k).getName() + "...");
				Thread.sleep(5000);
			}
			if (confirmed) {
				System.out.println(rankedConsumers.get(k).getName() + " has confirmed the pickup");
				return;
			}
		}
	}
	
	public static void printMenu(Scanner scan) {
		int time;
		double lon,lat;
		String size, foodType;
		System.out.println("Location ");
		System.out.println("");
		System.out.println("Longitude: ");
		lon = scan.nextDouble();
		System.out.println("Latitude: ");
		lat = scan.nextDouble();
		System.out.println("");
		System.out.println("Size (<50, <100, <200, <300");
		size = scan.nextLine();
		System.out.println("");
		System.out.println("Time (2 / 4 / 12 / 24 / 48 ; in hrs)" );
		time = scan.nextInt();
		System.out.println("");
		System.out.println("Food Type (Vegan / Vegetarian / Non - Vegetarian / Others");
		foodType = scan.nextLine();
		System.out.println();
		
	}
}