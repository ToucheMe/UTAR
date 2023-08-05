
public class Doctor extends Staff implements DisplayInfo {
	
	// Data Fields
	private String specialist;
	private String workTime;
	private String qualification;
	private int room;
	private static int doctorCount = 0;
	
	// Default & Parameterized Constructors
	public Doctor() { super(); doctorCount++;};
	
	public Doctor(int id, String name, String sex, String designation, int salary, String specialist, String workTime, String qualification, int room) {
		super(id, name, sex, designation, salary);
		this.specialist = specialist;
		this.workTime = workTime;
		this.qualification = qualification;
		this.room = room;
		doctorCount++;
	}

	// Accessors & Mutators
	public String getSpecialist() { return specialist; }
	public void setSpecialist(String specialist) { this.specialist = specialist; }

	public String getWorkTime() { return workTime; }
	public void setWorkTime(String workTime) { this.workTime = workTime; }

	public String getQualification() { return qualification; }
	public void setQualification(String qualification) { this.qualification = qualification; }

	public int getRoom() { return room; }
	public void setRoom(int room) { this.room = room; }
	
	public static int getDoctorCount() { return doctorCount; }
	
	// Methods (Features)
	/* Add New Entry */
	public static void newDoctor(Doctor[] doctor, Staff[] staff) {
		
		String name, staff_name, designation, sex, specialist, workTime, qualification;
		int id, salary, room;
		
		// New Doctor Menu
		System.out.println("------------------");
		System.out.println(" New Doctor Entry");
		System.out.println("------------------");
		
		// Input New Entry
		HospitalManagement.input.nextLine(); // Remove remaining whiteline character (cin.ignore())
		System.out.print("Enter ID: ");
		id = HospitalManagement.input.nextInt();
		HospitalManagement.input.nextLine(); // Remove remaining whiteline character (cin.ignore())
		System.out.print("Enter Name (without Dr.): ");
		name = HospitalManagement.input.nextLine();
		System.out.print("Enter Sex: ");
		sex = HospitalManagement.input.nextLine();
		System.out.print("Enter Designation: ");
		designation = HospitalManagement.input.nextLine();
		System.out.print("Enter Salary: ");
		salary = HospitalManagement.input.nextInt();
		HospitalManagement.input.nextLine();
		System.out.print("Enter Specialist: ");
		specialist = HospitalManagement.input.nextLine();
		System.out.print("Enter Work Time: ");
		workTime = HospitalManagement.input.nextLine();
		System.out.print("Enter Qualification: ");
		qualification = HospitalManagement.input.nextLine();
		System.out.print("Enter Room: ");
		room = HospitalManagement.input.nextInt();
		
		// Generate Staff Name
		String check = name.substring(0, 3).toUpperCase();
		if (check.charAt(0) == 'D' && check.charAt(1) == 'R' && (check.charAt(2) == '.' || check.charAt(2) == ' '))
				staff_name = name.substring(3, name.length());
		else
			staff_name = name;
		
		// Insert
		doctor[getDoctorCount()] = new Doctor(id, name, sex, designation, salary, specialist, workTime, qualification, room);
		Staff.minusStaffCount_PersonCount(); // Bug Fix
		staff[getStaffCount()] = new Staff(id, staff_name, sex, designation, salary);
		
		// Notification
		System.out.println();
		System.out.println("Successfully Added!");
	}

	/* Show Doctor Info */
	public void showInfo() { System.out.printf("%-8sDr. %-26s%-17s%-12s%-15s%-11s\n", getId(), getName(), getSpecialist(), getWorkTime(), getQualification(), getRoom()); }
	
	/* Doctor Section */
	public static void doctorSection(Doctor[] doctor, Staff[] staff) {
		
		final String[] OPTIONS = {"0", "1", "2"};
		final String[] SUB_OPTIONS = {"0", "1"};
		String option;
		
		// Doctor Menu
		do
		{
			System.out.println("====================");
			System.out.println("|  DOCTOR SECTION  |");
			System.out.println("====================");
			System.out.println("[1] |- Add New Entry");
			System.out.println("[2] |- Existing Doctors List");
			System.out.println("[0] |- To Exit to Main Menu");
			System.out.println();
			System.out.print("Option >> ");
			option = HospitalManagement.input.nextLine();
			option = HospitalManagement.validOption(option, OPTIONS); //Input Validation
			
			// Selection
			switch (option)
			{
			case "0": // Exit
				break;
				
			case "1": // New Staff
				newDoctor(doctor, staff);
				
				// Navigate
				System.out.println("Return to Doctor Section - 1 | Return to Main Menu - 0");
				System.out.println();
				System.out.print("Option >> ");
				option = HospitalManagement.input.nextLine();
				option = HospitalManagement.validOption(option, SUB_OPTIONS); // Input Validation
				break;
			
			case "2": // Show Staff
				System.out.println("\t\t\t\t\t*--------------*");
				System.out.println("\t\t\t\t\t| Doctors List |");
				System.out.println("\t\t\t\t\t*--------------*");
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.printf("%-8s%-30s%-17s%-12s%-15s%-11s\n", "ID", "Name", "Specialist", "Timing", "Qualification", "Room No.");
				System.out.println("------------------------------------------------------------------------------------------");
				for (int i = 0; i < getDoctorCount(); i++)
					doctor[i].showInfo();
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.println();
				System.out.println();
				
				// Navigate
				System.out.println("Return to Doctor Section - 1 | Return to Main Menu - 0");
				System.out.println();
				System.out.print("Option >> ");
				option = HospitalManagement.input.nextLine();
				option = HospitalManagement.validOption(option, SUB_OPTIONS); // Input Validation
				break;
			}
			
		} while (option != "0");
	}

}
