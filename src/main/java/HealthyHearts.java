import java.util.Scanner;

public class HealthyHearts {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //ask for input with validation
        int age;
        do {
            System.out.println("What is your age?");
            age = scanner.nextInt();
            if (age < 0) {
                System.out.println("Error, age cannot be negative");
            } else {
                break;
            }
        } while (true);

        //display maximum heartrate
        System.out.println("Your maximum heart rate should be " + getMaxHeartRate(age) + " beats per minute");

        //display target HR zone
        getHeartTarget(age);
    }

    public static int getMaxHeartRate(int age) {
        return (220 - age);
    }

    public static void getHeartTarget(int age) {
        int maximum = getMaxHeartRate(age);

        double low = maximum * 0.5;
        double high = maximum * 0.85;

        //example in sheet shows the numbers should be whole numbers
        //rounding was used to convert the doubles to ints
        System.out.println("Your target HR Zone is " + Math.round(low) + " - " + Math.round(high) + " beats per minute");

    }
}
