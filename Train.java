public class Train {
    int trainNumber;
    String trainName;
    String source;
    String destination;
    int totalSeats;
    int availableSeats;

    Train(int Train_Number, String Train_Name, String Source, String Destination, int Total_seats) {
        trainNumber = Train_Number;
        trainName = Train_Name;
        source = Source;
        destination = Destination;
        totalSeats = Total_seats;
        availableSeats = Total_seats;

    }

    public void displayTrainDetails() {
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Train Name: " + trainName);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Total Seats: " + totalSeats);

    }

}
