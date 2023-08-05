
public class Medical implements DisplayInfo {
	
	// Data Fields
	private String name;
	private String manufacturer;
	private String expiryDate;
	private int cost;
	private int count;
	private static int medicalCount = 0;
	
	// Default & Parameterized Constructors
	public Medical() { medicalCount++; }
	
	public Medical(String name, String manufacturer, String expiryDate, int cost, int count) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.expiryDate = expiryDate;
		this.cost = cost;
		this.count = count;
		medicalCount++;
	}
	
	// Accessors & Mutators
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getManufacturer() { return manufacturer; }
	public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

	public String getExpiryDate() {	return expiryDate; }
	public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

	public int getCost() { return cost; }
	public void setCost(int cost) {	this.cost = cost; }

	public int getCount() {	return count; }
	public void setCount(int count) { this.count = count; }

	public static int getMedicalCount() { return medicalCount; }

	// Methods (Features)
	/* Add New Entry */
	public static void newMedical(Medical[] medical) {
        
        String name, manufacturer, expiryDate;
        int cost, count;
        
        // New Lab Menu
		System.out.println("-------------");
		System.out.println(" New Medical");
		System.out.println("-------------");
        
		// Input New Entry
		HospitalManagement.input.nextLine(); // Remove remaining whiteline character (cin.ignore())
        System.out.print("Enter Medical's Name: ");
        name = HospitalManagement.input.nextLine();
        System.out.print("Enter Medical's Manufacturer: ");
        manufacturer = HospitalManagement.input.nextLine();
        System.out.print("Enter Medical's Expiry Date: ");
        expiryDate = HospitalManagement.input.nextLine();
        System.out.print("Enter Medical's Cost: ");
        cost = HospitalManagement.input.nextInt();
        System.out.print("Enter Medical's Count: ");
        count = HospitalManagement.input.nextInt();

        //Insert
        medical[getMedicalCount()] = new Medical(name, manufacturer, expiryDate, cost, count);
        
		// Notification
		System.out.println();
		System.out.println("Successfully Added!");
    }
	
	/* Show Medical Info */
	public void showInfo() { System.out.printf("%-24s%-24s%-13s%-10s\n", getName(), getManufacturer(), getExpiryDate(), getCost()); }
	
	/* Medical Section */
	public static void medicalSection(Medical[] medical) {
		
        final String[] OPTIONS = {"0", "1", "2"};
		final String[] SUB_OPTIONS = {"0", "1"};
		String option;
		
		// Medical Menu
		do
		{
            System.out.println("====================");
			System.out.println("|  MEDICAL SECTION |");
			System.out.println("====================");
			System.out.println("[1] |- Add New Entry");
			System.out.println("[2] |- Existing Medical List");
			System.out.println("[0] |- To Exit to Main Menu");
			System.out.println();
			System.out.print("Option >> ");
			option = HospitalManagement.input.nextLine();
			option = HospitalManagement.validOption(option, OPTIONS); // Input Validation

            //Selection
			switch (option)
			{
			case "0": // Exit
				break;
				
			case "1": // New Medical
				newMedical(medical);

				// Navigate
				System.out.println("Return to Medical Section - 1 | Return to Main Menu - 0");
				System.out.println();
				System.out.print("Option >> ");
				option = HospitalManagement.input.nextLine();
				option = HospitalManagement.validOption(option, SUB_OPTIONS); // Input Validation
				break;
            
            case "2": // Show Medical
				System.out.println("\t\t\t*--------------*");
				System.out.println("\t\t\t| Medical List |");
				System.out.println("\t\t\t*--------------*");
				System.out.println("--------------------------------------------------------------------");
				System.out.printf("%-24s%-24s%-13s%-10s\n", "Name", "Manufacturer", "Expiry Date", "Cost");
				System.out.println("--------------------------------------------------------------------");
				for (int i = 0; i < getMedicalCount(); i++)
					medical[i].showInfo();
				System.out.println("--------------------------------------------------------------------");
				System.out.println();
				System.out.println();
				
				// Navigate
				System.out.println("Return to Medical Section - 1 | Return to Main Menu - 0");
				System.out.println();
				System.out.print("Option >> ");
				option = HospitalManagement.input.nextLine();
				option = HospitalManagement.validOption(option, SUB_OPTIONS); // Input Validation
				break;
            }

        } while (option != "0");
	}
	
}
