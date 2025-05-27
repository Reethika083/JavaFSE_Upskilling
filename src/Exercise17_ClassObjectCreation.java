public class Exercise17_ClassObjectCreation {

    // Car class definition
    static class Car {
        String make;
        String model;
        int year;

        // Constructor to initialize attributes
        Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        // Method to display car details
        void displayDetails() {
            System.out.println("Car Details:");
            System.out.println("Make: " + make);
            System.out.println("Model: " + model);
            System.out.println("Year: " + year);
            System.out.println("-------------------");
        }
    }

    public static void main(String[] args) {
        // Create car objects
        Car car1 = new Car("Tesla", "Model S", 2022);
        Car car2 = new Car("Toyota", "Corolla", 2019);

        // Call method to display details
        car1.displayDetails();
        car2.displayDetails();
    }
}
