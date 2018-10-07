import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		ArrayList<User> consumers = new ArrayList<User>();

		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				int decision;
				
				System.out.println("Input the correlating number:");
				System.out.println("To create a new consumer type 1");
				System.out.println("To create a new distributor type 2");
				System.out.println("Your input: ");
				decision = scan.nextInt();
				scan.nextLine();
				if (decision == 1) {
					printMenu1(scan, consumers);
				} else if (decision == 2) {
					printMenu2(scan, consumers);
				} else {
					System.out.println("Unidentified input");
				}
			} catch (Exception e) {

			}
		}

	}

	public static Map<Integer, User> sortConsumers(User dist, ArrayList<User> consumers) {
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

	public static void requestConsumers(Distributor dist, ArrayList<User> consumers) throws InterruptedException {
		TreeMap<Integer, User> rankedConsumers = new TreeMap(sortConsumers((User) dist, consumers));
		
		boolean confirmed = false;
		int count = 0;
		
		for (int k : rankedConsumers.keySet()) {
			count++;
			if (count > 1) {
				System.out.print("Expanding search area.");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.println();
			}
			if (count == 3) {
				confirmed = true;
			}
			
			long startTime = System.currentTimeMillis(); // fetch starting time
			while (confirmed || (System.currentTimeMillis() - startTime) < 10000) {
				System.out.print("Sending request to " + rankedConsumers.get(k).getName() + ".");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.println();
				if (confirmed) {
					System.out.println(rankedConsumers.get(k).getName() + " has confirmed the pickup\n");
					return;
				}
			}
			
		}
	}

	public static void printMenu1(Scanner scan, ArrayList<User> consumers) {
		try {
			String name = "";
			int size = 0;
			double lon = 0.0, lat = 0.0;
			boolean[] foodType = new boolean[4];

			System.out.println("Name: ");
			name = scan.nextLine();
			System.out.println("Latitude: ");
			lat = scan.nextDouble();
			scan.nextLine();
			System.out.println("Longitude: ");
			lon = scan.nextDouble();
			scan.nextLine();
			System.out.println("Size: ");
			size = scan.nextInt();
			scan.nextLine();
			System.out.println("Food Type: (V for Vegan; Veg for Vegetarian; NonVeg for Non-Vegetarian; etc for Others)");
			System.out.println("If more than one input seprate by space");
			String temp[] = scan.nextLine().toLowerCase().split(" ");
			for (String i : temp) {
				if (i.equals("v")) {
					foodType[0] = true;
				} else if (i.equals("veg")) {
					foodType[1] = true;
				} else if (i.equals("nonveg")) {
					foodType[2] = true;
				} else if (i.equals("etc")) {
					foodType[3] = true;
				}
			}

			consumers.add(new Consumer(name, foodType, lat, lon, size));
			System.out.println("Consumer succesfully created\n");
		} catch (Exception e) {
			System.out.println("Encountered input error, try again");
		}
	}

	public static void printMenu2(Scanner scan, ArrayList<User> consumers) {
		try {
			String name = "";
			int size = 0, time = 0;
			double lon = 0.0, lat = 0.0;
			boolean[] foodType = new boolean[4];
			;

			System.out.println("Name: ");
			name = scan.nextLine();
			System.out.println("Latitude: ");
			lat = scan.nextDouble();
			scan.nextLine();
			System.out.println("Longitude: ");
			lon = scan.nextDouble();
			scan.nextLine();
			System.out.println("Time (hh:mm): ");
			String[] stringTime = scan.nextLine().split(":");
			time = Integer.parseInt(stringTime[0]) * 3600 + Integer.parseInt(stringTime[1]) * 60;
			System.out.println("Size: ");
			size = scan.nextInt();
			scan.nextLine();
			System.out.println("Food Type: (V for Vegan; Veg for Vegetarian; NonVeg for Non-Vegetarian; etc for Others)");
			System.out.println("If more than one input seprate by space");
			String temp[] = scan.nextLine().toLowerCase().split(" ");
			for (String i : temp) {
				if (i.equals("v")) {
					foodType[0] = true;
				} else if (i.equals("veg")) {
					foodType[1] = true;
				} else if (i.equals("nonveg")) {
					foodType[2] = true;
				} else if (i.equals("etc")) {
					foodType[3] = true;
				}
			}
			Distributor dist = new Distributor(name, foodType, lat, lon, size, time);
			requestConsumers(dist, consumers);
		} catch (Exception e) {
			System.out.println("Encountered input error, try again");
		}
	}
}