import java.util.Random;
import java.util.Scanner;

public class loops {
    public static void main(String[] args)
    {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(101);
        System.out.println("Random numbers:");
        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Try to guess number between 0 and 100:");
            try
            {
                int guess = scanner.nextInt();
                if (checkGuess(guess, numberToGuess)) break;
            }
            catch (Exception e)
            {
                System.out.println("Please enter a number");
            }
        }
    }

    private static boolean checkGuess(int guess, int numberToGuess)
    {
        if (guess == numberToGuess)
        {
            System.out.println("Congratulations! You guessed the number!");
            return true;
        }
        else if (guess < numberToGuess)
        {
            System.out.println("Try higher number");
        }
        else
        {
            System.out.println("Try lower number");
        }
        return false;
    }
    
}
