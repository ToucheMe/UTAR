
public class Facility implements DisplayInfo {
	
	// Data Fields
	private String facility;
	private static int facilityCount = 0;
	
	// Default & Parameterized Constructors
	public Facility() { facilityCount++; }
	
	public Facility(String facility) {
		this.facility = facility;
		facilityCount++;
	}

	// Accessors & Mutators
	public String getFacility() { return facility; }
	public void setFacility(String facility) { this.facility = facility; }

	public static int getFacilityCount() { return facilityCount; }

	// Methods (Features)
	/* Add New Entry */
	public static void newFacility(Facility[] facility) {
		
		String facilityName;
		
		// New Facility Menu
		System.out.println("--------------------");
		System.out.println(" New Facility Entry");
		System.out.println("--------------------");
		
		// Input New Entry
		HospitalManagement.input.nextLine(); // Remove remaining whiteline character (cin.ignore())
		System.out.print("Enter Facility: ");
		facilityName = HospitalManagement.input.nextLine();
		
		// Insert
		facility[getFacilityCount()] = new Facility(facilityName);
		
		// Notification
		System.out.println();
		System.out.println("Successfully Added!");
	}
	
	/* Show Facility Info */
	public void showInfo() { System.out.printf("%-8s\n", getFacility()); }
	
	/* Facility Section */
	public static void facilitySection(Facility[] facility) {
		
		final String[] OPTIONS = {"0", "1", "2"};
		final String[] SUB_OPTIONS = {"0", "1"};
		String option;
		
		// Facility Menu
		do
		{
			System.out.println("====================");
			System.out.println("| FACILITY SECTION |");
			System.out.println("====================");
			System.out.println("[1] |- Add New Facility");
			System.out.println("[2] |- Show Facility");
			System.out.println("[0] |- To Exit to Main Menu");
			System.out.println();
			System.out.print("Option >> ");
			option = HospitalManagement.input.nextLine();
			option = HospitalManagement.validOption(option, OPTIONS); // Input Validation
			
			// Selection
			switch (option)
			{
			case "0": // Exit
				break;
				
			case "1": // New Facility
				newFacility(facility);
				
				// Navigate
				System.out.println("Return to Facility Section - 1 | Return to Main Menu - 0");
				System.out.println();
				System.out.print("Option >> ");
				option = HospitalManagement.input.nextLine();
				option = HospitalManagement.validOption(option, SUB_OPTIONS); // Input Validation
				break;
			
			case "2": // Show Facility
				System.out.println("*---------------*");
				System.out.println("| Facility List |");
				System.out.println("*---------------*");
				System.out.println("-----------------");
				System.out.printf("%-20s\n", "Hospital Facility");
				System.out.println("-----------------");
				for (int i = 0; i < getFacilityCount(); i++)
					facility[i].showInfo();
				System.out.println("-----------------");
				System.out.println();
				System.out.println();
				
				// Navigate
				System.out.println("Return to Facility Section - 1 | Return to Main Menu - 0");
				System.out.println();
				System.out.print("Option >> ");
				option = HospitalManagement.input.nextLine();
				option = HospitalManagement.validOption(option, SUB_OPTIONS); // Input Validation
				break;
			}
			
		} while (option != "0");
	}
	
}
