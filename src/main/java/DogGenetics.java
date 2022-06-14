import java.util.Random;
import java.util.Scanner;

public class DogGenetics {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Random rng = new Random();

        System.out.println("What is your dog's  name?");

        String dogName = scanner.next();

        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here.");
        System.out.println(dogName + " is:\n");

        int remainingRange = 100;

        int[] percentages = new int[5];

        for (int i = 0; i < 4; i++) {

            int currentPercentage = rng.nextInt(remainingRange);

            remainingRange = remainingRange - currentPercentage;

            percentages[i] = currentPercentage;

        }
        //allocate remaining percentage to last;
        percentages[4] = remainingRange;

        //display results
        System.out.println(percentages[0] + "% St. Bernard");
        System.out.println(percentages[1] + "% Chihuahua");
        System.out.println(percentages[2] + "% Dramatic RedNosed Asian Pug");
        System.out.println(percentages[3] + "% Common Cur");
        System.out.println(percentages[4] + "% King Doberman");

    }

}
