import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HospitalManagement {
	
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		/*
			Class-Object Declaration & Initialisation
		*/
		
		// Basic Classes
		Doctor	[] 	doctor	 = new Doctor	[25];
		Patient	[] 	patient  = new Patient	[100];
		Lab		[] 	lab 	 = new Lab		[20];
		Facility[]	facility = new Facility	[20];
		Medical	[] 	medical	 = new Medical	[100];
		Staff	[] 	staff	 = new Staff	[100];
		
		// Doctor Extends Staff
		// String id, String name, String sex, String designation, int salary, String specialist, String workTime, String qualification, int room
		doctor[0] = new Doctor(751, "Brandon Ting En Junn", "Male", "Head Surgeon", 7500, "Surgeon", "9-3PM", "BDM", 22);
		doctor[1] = new Doctor(530, "Desmond Ong Kar Meng", "Male", "Head Physician", 9000, "Physician", "8-11AM", "MBBS,MD", 17);
		doctor[2] = new Doctor(564, "Soon Chun Hong", "Male", "Head Artho", 10000, "Artho", "3-6PM", "MBBS,MD", 13);
		doctor[3] = new Doctor(223, "Evelynn Keng", "Female", "Assistant Surgeon", 3000, "Surgeon", "3-9PM", "BDM", 44);
		doctor[4] = new Doctor(370, "Amanda Adrian", "Female", "Head Gynecologist", 5000, "Gynecologist", "11-4PM", "MBBS,MD", 27);
		
		// Patient Extends Person
		// String id, String name, String sex, String disease, String admitStatus, int age
		patient[0] = new Patient(751, "Brandon Ting En Junn", "Male", "Covid-19", "Y", 20);
		patient[1] = new Patient(530, "Desmond Ong Kar Meng", "Male", "Cold", "Y", 20);
		patient[2] = new Patient(564, "Soon Chun Hong", "Male", "Malaria", "Y", 20);
		patient[3] = new Patient(222, "Amber Key", "Female", "Food Poisoning", "Y", 31);
		patient[4] = new Patient(107, "Samantha Julian", "Female", "Conjunctivitis", "N", 25);
		
		// Lab
		// String lab, int cost
		lab[0] = new Lab("X-Ray", 800);
		lab[1] = new Lab("CT Scan", 1200);
		lab[2] = new Lab("DR Scan", 500);
		lab[3] = new Lab("MRI Scan", 300);
		lab[4] = new Lab("PET Scan", 350);
		
		// Facility
		// String facility
		facility[0] = new Facility("Ambulance");
		facility[1] = new Facility("Emergency");
		facility[2] = new Facility("Canteen");
		facility[3] = new Facility("Admit Facility");
		facility[4] = new Facility("Blood Bank");
		
		// Medical
		// String name, String manufacturer, String expiryDate, int cost, int count
		medical[0] = new Medical("Brufa", "Reckitt", "12-7-17", 50, 209);
		medical[1] = new Medical("Nytra", "Ace pvt", "4-4-15", 500, 28);
		medical[2] = new Medical("Corex", "Cino pvt", "9-8-16", 55, 100);
		medical[3] = new Medical("Pride", "DDF pvt", "12-4-12", 1100, 16);
		medical[4] = new Medical("Epogen", "Amgen Inc", "7-12-24", 250, 114);
		
		// Staff Extends Person
		// String id, String name, String sex, String designation, int salary
		staff[0] = new Staff(751, "Brandon Ting En Junn", "Male", "Head Surgeon", 7500);
		staff[1] = new Staff(530, "Desmond Ong Kar Meng", "Male", "Head Physician", 9000);
		staff[2] = new Staff(564, "Soon Chun Hong", "Male", "Head Artho", 10000);
		staff[3] = new Staff(213, "Evelynn Keng", "Female", "Assistant Surgeon", 3000);
		staff[4] = new Staff(837, "Amanda Adrian", "Female", "Head Gynecologist", 5000);
		for (int i = 0; i < 5; i++) Staff.minusStaffCount_PersonCount(); // Bug Fix (Repeated Entries From Initialisation due to Inheritance)

		/*
			Hospital Management Main Menu
		*/
		
		// Options
		final String[] OPTIONS = {"0", "1", "2", "3", "4", "5", "6"};
		String option;
		
		// Main Loop
		do 
		{
			// Main Menu
			displayMainMenu();
			option = input.nextLine();
			option = validOption(option, OPTIONS); // Input Validation
			
			// Selection
			switch (option)
			{
			case "0": // Exit Program
				input.close();
				break;
				
			case "1":
				Doctor.doctorSection(doctor, staff);
				break;
			
			case "2":
				Patient.patientSection(patient);
				break;
			
			case "3":
				Medical.medicalSection(medical);
				break;
				
			case "4":
				Lab.labSection(lab);
				break;
				
			case "5":
				Facility.facilitySection(facility);
				break;
				
			case "6":
				Staff.staffSection(staff);
				break;
			}
			
		} while (option != "0");
		
	}
	
	// Sub-Functions
	public static void displayMainMenu() {
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("| Welcome to the Hospital Management System Project in Java |");
		System.out.println("-------------------------------------------------------------");
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm:ss a");
		String formatTime = time.format(format);
		System.out.println("Date: " + date);
		System.out.println("Time: " + formatTime);
		System.out.println();
		
		System.out.println("===============");
		System.out.println("|  MAIN MENU  |");
		System.out.println("===============");
		System.out.println("[1] |- Doctors");
		System.out.println("[2] |- Patients");
		System.out.println("[3] |- Medicines");
		System.out.println("[4] |- Laboratories");
		System.out.println("[5] |- Facilities");
		System.out.println("[6] |- Staff");
		System.out.println("[0] |- To Exit Program");
		System.out.println();
		
		System.out.println("Please Select a Number and Press Enter: ");
		System.out.println();
		
		System.out.print("Option >> ");
		
	}
	
	public static String validOption(String option, String[] refArr) {
		
		while (!isValidOption(option, refArr))
		{
			System.out.println();
			System.out.println("Error: Invalid Option\nPlease Enter Again\n");
			System.out.print("Option >> ");
			option = HospitalManagement.input.nextLine();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		return option;
	}
	
	public static boolean isValidOption(String option, String[] refArr) {
		
		int length = refArr.length;
		
		if (option.length() > 1) return false;
		
		for (int i = 0; i < length; i++)
		{
			if (option.equals(refArr[i]))
				return true;
		}
		
		return false;
	}
}
