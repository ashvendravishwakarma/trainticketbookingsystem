public class Passenger {
    String passengerName;
    int age;
    int pnrNumber;
    int trainNumber;
    boolean isBooked = true;

    Passenger(String passengerName, int age, int pnrNumber, int trainNumber) {
          this.passengerName=passengerName;
          this.age=age;
          this.pnrNumber=pnrNumber;
          this.trainNumber=trainNumber;
    }

    public void displayPassengerDetails(){
        System.out.println("passenger name : "+passengerName);
        System.out.println("passanger age :"+ age);
        System.out.println("PNR Number : "+pnrNumber);
        System.out.println("Train Number : "+trainNumber);

    }

 
}
    

