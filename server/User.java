import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class User implements Comparable<User> {
    protected boolean[] foodType;
    protected double latitude;
    protected double longitude;
    protected int size;

    public User () {
        foodType = new boolean[4];
        latitude = 0.0;
        longitude = 0.0;
        size = 0;
    }

    public User(boolean[] foodType, double latitude, double longitude, int size) {
        this.foodType = foodType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.size = size;
    }

    public boolean[] getFoodType()
    {
        return foodType;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getSize() {
        return size;
    }

    public int compareTo(User other) {
    	int rank = 0;
    	for (int i = 0; i < foodType.length; i++) {
    		if (this.getFoodType()[i] != other.getFoodType()[i]) {
    			rank = -1;
    			return rank;
    		}
    	}
    	
    	if (this.getSize() - other.getSize() > 0) {
    		rank = -1;
    		return rank;
    	} else {
    		rank = Math.abs(this.getSize() - other.getSize());
    	}
    	
    	rank = rank + (int) distance(this.getLatitude(), other.getLatitude(), this.getLongitude(), other.getLongitude());
    	return rank;
    }
    
    private static double distance(double lat1, double lat2, double lon1, double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        distance = Math.pow(distance, 2);

        return Math.round(Math.sqrt(distance) * 100);
    }
    
	public static void printMenu() {
		System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "A\t\tAdd Project\n"
				+ "C\t\tCreate ProjectManagement\n" + "D\t\tSearch by Project Number\n" + "E\t\tSearch by Departure\n"
				+ "L\t\tList Projects\n" + "O\t\tSort by Project Number\n" + "P\t\tSort by Departure\n" + "Q\t\tQuit\n"
				+ "R\t\tRemove by Project Number\n" + "T\t\tClose ProjectManagement\n" + "U\t\tWrite Text to File\n"
				+ "V\t\tRead Text from File\n" + "W\t\tSerialize ProjectManagement to File\n"
				+ "X\t\tDeserialize ProjectManagement from File\n" + "?\t\tDisplay Help\n\n");
	}
}

public class Assignment8 {
	public static void main(String[] args) {
		char input1;
		String food, projNumStr, projLocation, firstName, lastName, deptNumStr;
		int projNumber, deptNumber;

		// create a ProjectManagement object. This is used throughout this
		// class.
		ProjectManagement manage1 = null;

		try {
			// print out the menu
			printMenu();

			// create a BufferedReader object to read input from a keyboard
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader stdin = new BufferedReader(isr);

			System.out.print("Please enter a maximum number of projects\n");
			String maxStr = stdin.readLine().trim(); // read in the max number
														// as a string
			int max = Integer.parseInt(maxStr);
			manage1 = new ProjectManagement(max);

			do {
				System.out.print("What action would you like to perform?\n");
				line = stdin.readLine().trim(); // read a line
				input1 = line.charAt(0);
				input1 = Character.toUpperCase(input1);

				if (line.length() == 1) // check if a user entered only one
										// character
				{
					switch (input1) {
					case 'A': // Add Project
						System.out.print("Please enter a project to add:\n");
						System.out.print("Please enter its title to add:\n");
						projTitle = stdin.readLine().trim();
						System.out.print("Please enter its project number to add:\n");
						projNumStr = stdin.readLine().trim();
						projNumber = Integer.parseInt(projNumStr);
						System.out.print("Please enter its project location to add:\n");
						projLocation = stdin.readLine().trim();

						System.out.print("Please enter its manager's first name to add:\n");
						firstName = stdin.readLine().trim();
						System.out.print("Please enter its manager's last name to add:\n");
						lastName = stdin.readLine().trim();
						System.out.print("Please enter its manager's department number to add:\n");
						deptNumStr = stdin.readLine().trim();
						deptNumber = Integer.parseInt(deptNumStr);

						operation = manage1.addProject(projTitle, projNumber, projLocation, firstName, lastName,
								deptNumber);
						if (operation == true)
							System.out.print("project added\n");
						else
							System.out.print("project not added\n");
						break;
					case 'C': // Create a new project management
						System.out.print("Please enter a new maximum number of projects:\n");
						maxStr = stdin.readLine().trim(); // read in the max
															// number as a
															// string
						max = Integer.parseInt(maxStr);
						manage1 = new ProjectManagement(max);
						break;
					case 'D': // Search by project number
						System.out.print("Please enter project number to search:\n");
						projNumStr = stdin.readLine().trim();
						projNumber = Integer.parseInt(projNumStr);
						operation2 = manage1.projectNumberExists(projNumber);

						if (operation2 > -1)
							System.out.print("project number " + projNumber + " found\n");
						else
							System.out.print("project number " + projNumber + " not found\n");
						break;
					case 'E': // Search by manager
						System.out.print("Please enter the first name of a manager to search:\n");
						firstName = stdin.readLine().trim();
						System.out.print("Please enter the last name of a manager to search:\n");
						lastName = stdin.readLine().trim();
						System.out.print("Please enter the department number of a manager to search:\n");
						deptNumStr = stdin.readLine().trim();
						deptNumber = Integer.parseInt(deptNumStr);

						operation2 = manage1.managerExists(firstName, lastName, deptNumber);

						if (operation2 > -1) {
							System.out.print("project manager " + lastName + "," + firstName + " of the department "
									+ deptNumber + " found\n");
						} else {
							System.out.print("project manager " + lastName + "," + firstName + " of the department "
									+ deptNumber + " not found\n");
						}
						break;
					case 'L': // List projects
						System.out.println(manage1.listProjects());
						break;
					case 'O': // Sort by project numbers
						manage1.sortByProjectNumber();
						System.out.print("sorted by project numbers\n");
						break;
					case 'P': // Sort by manager information
						manage1.sortByManager();
						System.out.print("sorted by managers\n");
						break;
					case 'Q': // Quit
						break;
					case 'R': // Remove by project number
						System.out.print("Please enter project number to remove:\n");
						projNumStr = stdin.readLine().trim();
						projNumber = Integer.parseInt(projNumStr);
						operation = manage1.removeProjectNumber(projNumber);
						if (operation == true)
							System.out.print("project number " + projNumber + " removed\n");
						else
							System.out.print("project number " + projNumber + " not found\n");

						break;
					case 'T': // Close ProjectManagement
						manage1.closeProjectManagement();
						System.out.print("project management system closed\n");
						break;
					case 'U': // Write Text to a File
						System.out.print("Please enter a file name to write:\n");
						filename = stdin.readLine().trim();
						/************************************************************************************
						 *** ADD your code to write a text (string) to the
						 * specified file. Catch exceptions.
						 ************************************************************************************/
						// create a text file which you will write data to
						File outputFile = new File(filename);

						// Prompt the user to enter the string to write
						System.out.print("Please enter a string to write in the file:\n");
						String text = stdin.readLine() + "\n";

						BufferedWriter bw = null;
						try {
							// create a buffered writer
							bw = new BufferedWriter(new FileWriter(outputFile));
							// write the given text
							bw.write(text);
							// print out the success message
							System.out.println(filename + " was written");
						} catch (IOException e) {
							// catches any io exceptions
							System.out.println(e);
						} finally {
							// closes the writer if its not null
							if (bw != null)
								bw.close();
						}
						break;
					case 'V': // Read Text from a File
						System.out.print("Please enter a file name to read:\n");
						filename = stdin.readLine().trim();
						/************************************************************************************
						 *** ADD your code to read a text (string) from the
						 * specified file. Catch exceptions.
						 ************************************************************************************/
						File inputFile = new File(filename);

						try {
							// create a buffered reader
							BufferedReader br = new BufferedReader(new FileReader(inputFile));
							// if successful, print out that the file was read
							System.out.println(filename + " was read");
							// read-in the first line
							String firstLine = br.readLine();
							// print the first line
							System.out.println("The first line of the file is:");
							System.out.println(firstLine);
							// Close the file
							br.close();
						} catch (FileNotFoundException e) {
							// if the file was not found, print out an appropriate error message
							System.out.println(filename + " was not found");
						} catch (IOException e) {
							// catches any other io exceptions 
							System.out.println(e);
						}

						break;
					case 'W': // Serialize ProjectManagement to a File
						System.out.print("Please enter a file name to write:\n");
						filename = stdin.readLine().trim();
						/************************************************************************************
						 *** ADD your code to write the project management oject
						 * to the specified file. Catch exceptions.
						 ************************************************************************************/
						try {
							// create an output stream
							FileOutputStream f = new FileOutputStream(new File(filename));
							ObjectOutputStream o = new ObjectOutputStream(f);
							// Write objects to file
							o.writeObject(manage1);
							// if successful print out that the file was written
							System.out.println(filename + " was written");
							// close the streams
							o.close();
							f.close();
						} catch (NotSerializableException e) {
							// if the file is not serializable, print out an appropriate error message
							System.out.println(filename + " is not serializable");
						} catch (IOException e) {
							// catches any other io exceptions 
							System.out.println("Error initializing stream");
						}

						break;
					case 'X': // Deserialize ProjectManagement from a File
						System.out.print("Please enter a file name to read:\n");
						filename = stdin.readLine().trim();
						/************************************************************************************
						 *** ADD your code to read a project management object
						 * from the specified file. Catch exception.
						 ***********************************************************************************/
						try {
							// create input streams
							FileInputStream fi = new FileInputStream(new File(filename));
							ObjectInputStream oi = new ObjectInputStream(fi);
							// Read objects
							manage1 = (ProjectManagement) oi.readObject();
							// if successful print out that the file was read
							System.out.println(filename + " was read");
							// close the input streams
							oi.close();
							fi.close();
						} catch (FileNotFoundException e) {
							// if file was not found, print out an appropriate error message
							System.out.println(filename + " was not found");
						} catch (ClassNotFoundException e) {
							// if the given class does not exist, print out an appropriate error message
							System.out.println("Class not found");
						} catch (IOException e) {
							// catches any other io exceptions 
							System.out.println("Error initializing stream");
						}

						break;
					case '?': // Display Menu
						printMenu();
						break;
					default:
						System.out.print("Unknown action\n");
						break;
					}
				} else {
					System.out.print("Unknown action\n");
				}
			} while (input1 != 'Q' || line.length() != 1);
		} catch (

		IOException exception) {
			System.out.print("IO Exception\n");
		}
	}

	/** The method printMenu displays the menu to a user **/

}
