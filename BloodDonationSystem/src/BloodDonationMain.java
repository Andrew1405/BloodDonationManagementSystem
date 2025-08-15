import java.util.Scanner;

public class BloodDonationMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();
        DonationHistoryManager historyManager = new DonationHistoryManager();

        int choice;
        System.out.println("-----Blood Donation Management System-----");

        do {
            System.out.println("\n1. Add Donor");
            System.out.println("2. Update Donor Details");
            System.out.println("3. View Donors");
            System.out.println("4. Search Donors by Blood Group & Location");
            System.out.println("5. Log a Donation");
            System.out.println("6. View Donation History");
            System.out.println("7. View Last Donation for Each Donor");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    admin.addDonor();
                    break;
                case 2:
                    admin.updateDonorDetails();
                    break;
                
                case 3:
                    admin.viewDonors();
                    break;
                case 4:
                    admin.searchByBloodGroupAndLocation();
                    break;
                case 5:
                    admin.logDonation();
                    break;
                case 6:
                    historyManager.viewDonationHistory();
                    break;
                case 7:
                    historyManager.viewLastDonationForEachDonor();
                    break;
                case 0:
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
