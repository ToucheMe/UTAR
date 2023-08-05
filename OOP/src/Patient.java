
public class Patient extends Person implements DisplayInfo {
	
	// Data Fields
	private String disease;
	private String admitStatus;
	private int age;
	private static int patientCount = 0;
	
	// Default & Parameterized Constructors
	public Patient() { super(); patientCount++; }
	
	public Patient(int id, String name, String sex, String disease, String admitStatus, int age) {
		super(id, name, sex);
		this.disease = disease;
		this.admitStatus = admitStatus;
		this.age = age;
		patientCount++;
	}
	
	// Accessors & Mutators
	public String getDisease() { return disease; }
	public void setDisease(String disease) { this.disease = disease; }

	public String getAdmitStatus() { return admitStatus; }
	public void setAdmitStatus(String admitStatus) { this.admitStatus = admitStatus; }

	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }

	public static int getPatientCount() { return patientCount; }

	// Methods (Features)
	/* Add New Entry */
	public static void newPatient(Patient[] patient) {
		
        String name, sex, disease, admitStatus;
        int id, age;
        
        // New Patient Menu
		System.out.println("-------------------");
		System.out.println(" New Patient Entry");
		System.out.println("-------------------");
        
		// Input New Entry
		HospitalManagement.input.nextLine(); // Remove remaining whiteline character (cin.ignore())
        System.out.print("Enter Patient's ID: ");
        id = HospitalManagement.input.nextInt();
        HospitalManagement.input.nextLine(); // Remove remaining whiteline character (cin.ignore())
        System.out.print("Enter Patient's Name: ");
        name = HospitalManagement.input.nextLine();
        System.out.print("Enter Patient's Sex: ");
        sex = HospitalManagement.input.nextLine();
        System.out.print("Enter Patient's Disease: ");
        disease = HospitalManagement.input.nextLine();
        System.out.print("Enter Patient's Admit Status: ");
        admitStatus = HospitalManagement.input.nextLine();
        System.out.print("Enter Patient's Age: ");
        age = HospitalManagement.input.nextInt();

        // Insert
        patient[getPatientCount()] = new Patient(id, name, sex, disease, admitStatus, age);
        
        // Notification
		System.out.println();
		System.out.println("Successfully Added!");
	}
	
	/* Show Doctor Info */
	public void showInfo() { System.out.printf("%-8s%-24s%-20s%-18s%-10s%-3s\n", getId(), getName(), getDisease(), getSex(), getAdmitStatus(), getAge()); }
	
	/* Doctor Section */
	public static void patientSection(Patient[] patient) {
		
        final String[] OPTIONS = {"0", "1", "2"};
		final String[] SUB_OPTIONS = {"0", "1"};
		String option;
		
		// Patient Menu
		do
		{
            System.out.println("===================");
			System.out.println("| PATIENT SECTION |");
			System.out.println("===================");
			System.out.println("[1] |- Add New Entry");
			System.out.println("[2] |- Existing Patients List");
			System.out.println("[0] |- To Exit to Main Menu");
			System.out.println();
			System.out.print("Option >> ");
			option = HospitalManagement.input.nextLine();
			option = HospitalManagement.validOption(option, OPTIONS); //Input Validation

            //Selection
			switch (option)
			{
			case "0": // Exit
				break;
				
			case "1": // New Staff
				newPatient(patient);
				
				// Navigate
				System.out.println("Return to Patient Section - 1 | Return to Main Menu - 0");
				System.out.println();
				System.out.print("Option >> ");
				option = HospitalManagement.input.nextLine();
				option = HospitalManagement.validOption(option, SUB_OPTIONS); // Input Validation
				break;
            
            case "2": // Show Staff
				System.out.println("\t\t\t\t*---------------*");
				System.out.println("\t\t\t\t| Patients List |");
				System.out.println("\t\t\t\t*---------------*");
				System.out.println("-----------------------------------------------------------------------------------");
				System.out.printf("%-8s%-24s%-20s%-13s%-15s%-3s\n", "ID", "Name", "Disease", "Sex", "Admit Status", "Age");
				System.out.println("-----------------------------------------------------------------------------------");
				for (int i = 0; i < getPatientCount(); i++)
					patient[i].showInfo();
				System.out.println("-----------------------------------------------------------------------------------");
				System.out.println();
				System.out.println();
				
				// Navigate
				System.out.println("Return to Patient Section - 1 | Return to Main Menu - 0");
				System.out.println();
				System.out.print("Option >> ");
				option = HospitalManagement.input.nextLine();
				option = HospitalManagement.validOption(option, SUB_OPTIONS); // Input Validation
				break;
            }

        } while (option != "0");
	}
	
}
