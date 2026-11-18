
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int bookingCount = 0;
        int nextPNR = 1001;

        Passenger[] passengers = new Passenger[100];

        Train t1 = new Train(12155, "Bhopal Express", "Bhopal", "Delhi", 100);
        Train t2 = new Train(12919, "Malwa Express", "Bhopal", "Mumbai", 120);
        Train t3 = new Train(19303, "Indore Express", "Bhopal", "Indore", 80);

        while (true) {

            System.out.println("""
                    ========================================
                         RAILWAY TICKET BOOKING SYSTEM
                    ========================================
                    1. Display Available Trains
                    2. Search Train
                    3. Book Ticket
                    4. Cancel Ticket
                    5. View Booked Tickets
                    6. Search Ticket by PNR
                    7. Exit
                    """);

            System.out.print("Enter your choice: ");
            char choice = sc.next().charAt(0);

            switch (choice) {

                // FEATURE 1: DISPLAY AVAILABLE TRAINS
                case '1':

                    t1.displayTrainDetails();
                    t2.displayTrainDetails();
                    t3.displayTrainDetails();

                    break;

                // FEATURE 2: SEARCH TRAIN
                case '2':

                    System.out.print("Enter Train Number: ");
                    int t_number = sc.nextInt();

                    if (t_number == t1.trainNumber) {
                        t1.displayTrainDetails();

                    } else if (t_number == t2.trainNumber) {
                        t2.displayTrainDetails();

                    } else if (t_number == t3.trainNumber) {
                        t3.displayTrainDetails();

                    } else {
                        System.out.println("Train not found!");
                    }

                    break;

                // FEATURE 3: BOOK TICKET
                case '3':

                    System.out.print("Enter Passenger Name: ");
                    String pr = sc.next();

                    System.out.print("Enter Age: ");
                    int age_ = sc.nextInt();

                    System.out.print("Enter Train Number: ");
                    int tr_n = sc.nextInt();

                    if (bookingCount >= passengers.length) {

                        System.out.println("Booking limit reached!");

                    } else if (tr_n == t1.trainNumber) {

                        if (t1.availableSeats > 0) {

                            Passenger p1 = new Passenger(
                                    pr, age_, nextPNR, tr_n);

                            passengers[bookingCount] = p1;
                            bookingCount++;
                            nextPNR++;

                            t1.availableSeats--;

                            System.out.println("Ticket booked successfully!");
                            System.out.println("PNR: " + p1.pnrNumber);
                            System.out.println("Available Seats: " + t1.availableSeats);

                        } else {
                            System.out.println("No seats available!");
                        }

                    } else if (tr_n == t2.trainNumber) {

                        if (t2.availableSeats > 0) {

                            Passenger p1 = new Passenger(
                                    pr, age_, nextPNR, tr_n);

                            passengers[bookingCount] = p1;
                            bookingCount++;
                            nextPNR++;

                            t2.availableSeats--;

                            System.out.println("Ticket booked successfully!");
                            System.out.println("PNR: " + p1.pnrNumber);
                            System.out.println("Available Seats: " + t2.availableSeats);

                        } else {
                            System.out.println("No seats available!");
                        }

                    } else if (tr_n == t3.trainNumber) {

                        if (t3.availableSeats > 0) {

                            Passenger p1 = new Passenger(
                                    pr, age_, nextPNR, tr_n);

                            passengers[bookingCount] = p1;
                            bookingCount++;
                            nextPNR++;

                            t3.availableSeats--;

                            System.out.println("Ticket booked successfully!");
                            System.out.println("PNR: " + p1.pnrNumber);
                            System.out.println("Available Seats: " + t3.availableSeats);

                        } else {
                            System.out.println("No seats available!");
                        }

                    } else {
                        System.out.println("Train not found!");
                    }

                    break;

                // FEATURE 4: CANCEL TICKET
                case '4':

                    System.out.print("Enter PNR Number: ");
                    int PNR = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < bookingCount; i++) {

                        if (passengers[i] != null &&
                                passengers[i].pnrNumber == PNR) {

                            if (passengers[i].trainNumber == t1.trainNumber) {
                                t1.availableSeats++;

                            } else if (passengers[i].trainNumber == t2.trainNumber) {
                                t2.availableSeats++;

                            } else if (passengers[i].trainNumber == t3.trainNumber) {
                                t3.availableSeats++;
                            }

                            passengers[i] = null;

                            found = true;

                            System.out.println("Ticket cancelled successfully!");

                            break;
                        }
                    }

                    if (found == false) {
                        System.out.println("Invalid PNR Number!");
                    }

                    break;

                // FEATURE 5: VIEW BOOKED TICKETS
                case '5':

                    boolean ticketFound = false;

                    System.out.println("========== BOOKED TICKETS ==========");

                    for (int i = 0; i < bookingCount; i++) {

                        if (passengers[i] != null) {

                            passengers[i].displayPassengerDetails();

                            System.out.println("--------------------------------");

                            ticketFound = true;
                        }
                    }

                    if (ticketFound == false) {
                        System.out.println("No booked tickets available!");
                    }

                    break;

                // FEATURE 6: SEARCH TICKET BY PNR
                case '6':

                    System.out.print("Enter PNR Number: ");
                    int searchPNR = sc.nextInt();

                    boolean searchFound = false;

                    for (int i = 0; i < bookingCount; i++) {

                        if (passengers[i] != null &&
                                passengers[i].pnrNumber == searchPNR) {

                            System.out.println("========== TICKET DETAILS ==========");

                            passengers[i].displayPassengerDetails();

                            System.out.println("Ticket found successfully!");

                            searchFound = true;

                            break;
                        }
                    }

                    if (searchFound == false) {
                        System.out.println("Ticket not found!");
                    }

                    break;

                // FEATURE 7: EXIT
                case '7':

                    System.out.println("==============================");
                    System.out.println("Thank you for using");
                    System.out.println("Railway Reservation System!");
                    System.out.println("Have a safe journey!");
                    System.out.println("==============================");

                    sc.close();

                    return;

                default:

                    System.out.println("Invalid choice!");

                    break;
            }
        }
    }
}
