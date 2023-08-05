
public class Lab implements DisplayInfo {
	
	// Data Fields
	private String lab;
	private int cost;
	private static int labCount = 0;
	
	// Default & Parameterized Constructors
	public Lab() { labCount++; }
	
	public Lab(String lab, int cost) {
		this.lab = lab;
		this.cost = cost;
		labCount++;
	}

	// Accessors & Mutators
	public String getLab() { return lab; }
	public void setLab(String lab) { this.lab = lab; }

	public int getCost() { return cost; }
	public void setCost(int cost) {	this.cost = cost; }

	public static int getLabCount() { return labCount; }
	
	// Methods (Features)
	/* Add New Entry */
	public static void newLab(Lab[] lab) {
		
		String labName;
		int cost;
		
		// New Lab Menu
		System.out.println("---------");
		System.out.println(" New Lab");
		System.out.println("---------");
		
		// Input New Entry
		HospitalManagement.input.nextLine(); // Remove remaining whiteline character (cin.ignore())
		System.out.print("Enter Facility: ");
		labName = HospitalManagement.input.nextLine();
		System.out.print("Enter Cost: ");
		cost = HospitalManagement.input.nextInt();
		
		// Insert
		lab[getLabCount()]= new Lab(labName, cost);
		
		// Notification
		System.out.println();
		System.out.println("Successfully Added!");
	}
	
	/* Show Lab Info */
	public void showInfo() { System.out.printf("%-14s%-24s\n",getLab(), getCost()); }
	
	/* Lab Section */
	public static void labSection(Lab[] lab) {

		final String[] OPTIONS = {"0", "1", "2"};
		final String[] SUB_OPTIONS = {"0", "1"};
		String option;
		
		// Lab Menu
		do
		{
			System.out.println("=================");
			System.out.println("|  LAB SECTION  |");
			System.out.println("=================");
			System.out.println("[1] |- Add Lab and Cost");
			System.out.println("[2] |- Lab List");
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
				
			case "1": // New Lab
				newLab(lab);
				
				// Navigate
				System.out.println("Return to Lab Section - 1 | Return to Main Menu - 0");
				System.out.println();
				System.out.print("Option >> ");
				option = HospitalManagement.input.nextLine();
				option = HospitalManagement.validOption(option, SUB_OPTIONS); // Input Validation
				break;
			
			case "2": // Show Lab
				System.out.println("\t*----------*");
				System.out.println("\t| Lab List |");
				System.out.println("\t*----------*");
				System.out.println("-----------------------");
				System.out.printf("%-14s%-24s\n", "Lab", "Cost");
				System.out.println("-----------------------");
				for (int i = 0; i < getLabCount(); i++)
					lab[i].showInfo();
				System.out.println("-----------------------");
				System.out.println();
				System.out.println();
				
				// Navigate
				System.out.println("Return to Lab Section - 1 | Return to Main Menu - 0");
				System.out.println();
				System.out.print("Option >> ");
				option = HospitalManagement.input.nextLine();
				option = HospitalManagement.validOption(option, SUB_OPTIONS); // Input Validation
				break;
			}
			
		} while (option != "0");
	}
	
}
