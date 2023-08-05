
public class Staff extends Person implements DisplayInfo {
	
	// Data Fields
	private String designation;
	private int salary;
	private static int staffCount = 0;
	
	// Default & Parameterized Constructors
	public Staff() { super(); staffCount++; }
	
	public Staff(int id, String name, String sex, String designation, int salary) {
		super(id, name, sex);
		this.designation = designation;
		this.salary = salary;
		staffCount++;
	}

	// Accessors & Mutators
	public String getDesignation() { return designation; }
	public void setDesignation(String designation) { this.designation = designation; }

	public int getSalary() { return salary; }
	public void setSalary(int salary) { this.salary = salary; }
	
	public static int getStaffCount() { return staffCount; }
	public static void minusStaffCount_PersonCount() { staffCount--; minusPersonCount(); }
	
	// Methods (Features)
	/* Add New Entry */
	public static void newStaff(Staff[] staff) {
		
		String name, designation, sex;
		int id, salary;
		
		// New Staff Menu
		System.out.println("------------------");
		System.out.println(" New Staff Entry");
		System.out.println("------------------");
		
		// Input New Entry
		HospitalManagement.input.nextLine(); // Remove remaining whiteline character (cin.ignore())
		System.out.print("Enter ID: ");
		id = HospitalManagement.input.nextInt();
		HospitalManagement.input.nextLine(); // Remove remaining whiteline character (cin.ignore())
		System.out.print("Enter Name: ");
		name = HospitalManagement.input.nextLine();
		System.out.print("Enter Sex: ");
		sex = HospitalManagement.input.nextLine();
		System.out.print("Enter Designation: ");
		designation = HospitalManagement.input.nextLine();
		System.out.print("Enter Salary: ");
		salary = HospitalManagement.input.nextInt();
		
		// Insert
		staff[getStaffCount()] = new Staff(id, name, sex, designation, salary);
		
		// Notification
		System.out.println();
		System.out.println("Successfully Added!");
		
	}
	
	/* Show Staff Info */
	public void showInfo() { System.out.printf("%-6s%-24s%-25s%-6s%10s\n", getId(), getName(), getDesignation(), getSex(), getSalary()); }
	
	/* Staff Section */
	public static void staffSection(Staff[] staff) {
		
		final String[] OPTIONS = {"0", "1", "2"};
		final String[] SUB_OPTIONS = {"0", "1"};
		String option;
		
		// Staff Menu
		do
		{
			System.out.println("===================");
			System.out.println("|  STAFF SECTION  |");
			System.out.println("===================");
			System.out.println("[1] |- Add New Entry");
			System.out.println("[2] |- Existing Staff List");
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
				
			case "1": // New Staff
				newStaff(staff);
				
				// Navigate
				System.out.println("Return to Staff Section - 1 | Return to Main Menu - 0");
				System.out.println();
				System.out.print("Option >> ");
				option = HospitalManagement.input.nextLine();
				option = HospitalManagement.validOption(option, SUB_OPTIONS); // Input Validation
				break;
		
			case "2": // Show Staff
				System.out.println("\t\t\t*------------*");
				System.out.println("\t\t\t| Staff List |");
				System.out.println("\t\t\t*------------*");
				System.out.println("-----------------------------------------------------------------------");
				System.out.printf("%-6s%-24s%-25s%-6s%10s\n", "ID", "Name", "Designation", "Sex", "Salary");
				System.out.println("-----------------------------------------------------------------------");
				for (int i = 0; i < getStaffCount(); i++)
					staff[i].showInfo();
				System.out.println("-----------------------------------------------------------------------");
				System.out.println();
				System.out.println();
				
				// Navigate
				System.out.println("Return to Staff Section - 1 | Return to Main Menu - 0");
				System.out.println();
				System.out.print("Option >> ");
				option = HospitalManagement.input.nextLine();
				option = HospitalManagement.validOption(option, SUB_OPTIONS); // Input Validation
				break;
			}
			
		} while (option != "0");
	}
	
}
