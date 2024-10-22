// J.U 10/3/24
// zooVersion01.java
//
package Jonathon.zoo.com;

import java.util.Date;
import java.text.SimpleDateFormat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class App {

    private static String calcAnimalBirthDate(int age, String theSeason) {
        // This is all of the date stuff we did last week:
        // Create a Date object to represent the current date
        Date today = new Date();

        // Define the desired date format
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");

        // Format the date and store it in a string
        String strTodaysDate = formatter.format(today);
        String strTodaysYear = formatterYear.format(today);

        // Output the result
        System.out.println("Today's date in the format yyyy-MM-dd: " + strTodaysDate);

        String animalBirthdate = "";
        int todaysYear = Integer.parseInt(strTodaysYear);
        int animalBirthYear = todaysYear - Integer.parseInt(String.valueOf(age));


        // Normalize the input season to lower case for case-insensitive comparison
        String season = theSeason.toLowerCase();

        switch (season) {
            case "spring":
                animalBirthdate = Integer.toString(animalBirthYear) + "-03-21";
                break;
            case "fall":
                animalBirthdate = Integer.toString(animalBirthYear) + "-09-21";
                break;
            case "winter":
                animalBirthdate = Integer.toString(animalBirthYear) + "-12-21";
                break;
            case "summer":
                animalBirthdate = Integer.toString(animalBirthYear) + "-06-21";
                break;
            default:
                animalBirthdate = Integer.toString(animalBirthYear) + "-01-01"; // Default case for anything else
                break;
        }

        return animalBirthdate;

    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Welcome to my Zoo Program!");

        // This is all of the date stuff we did last week:
        // Create a Date object to represent the current date
        Date today = new Date();

        // Define the desired date format
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");

        // Format the date and store it in a string
        String strTodaysDate = formatter.format(today);
        String strTodaysYear = formatterYear.format(today);

        // Output the result
        System.out.println("Today's date in the format yyyy-MM-dd: " + strTodaysDate);

        // Calculate birthdates for the following two hyenas
        // 1) 4 year old female hyena, born in spring, tan color, 70 pounds, from Friguia Park, Tunisia
        // 2) 12 year old male hyena, born in fall, brown color, 150 pounds, from Friguia Park, Tunisia

        // Write Java code to calculate birthdates for the animals and then create a method that returns a string
        // for the animal's birthdate.

        // input: "4 year old female hyena, born in spring"
        // processing: find the age and birth season
        //             and then use decision control structures to
        //             calculate the date.

        // parse the string
        //Open arrivingAnimals with BufferedFileReader
        BufferedReader reader = null;

        try {
            // Create a FileReader to read the file
            FileReader fileReader = new FileReader("arrivingAnimals.txt");

            // Create a BufferedReader to buffer the input from the FileReader
            reader = new BufferedReader(fileReader);

            String line;
            // Read lines from the file until the end is reached
            while ((line = reader.readLine()) != null) {
                // Print each line to the console
                System.out.println(line);
                // Parse this line with text.
                String[] arrayOfStrPartsOnComma = line.split(", ");
                // output the array elements
                // this is a for : each loop - very handy when examining array elements.
                int elementNum = 0;
                for (String thePart : arrayOfStrPartsOnComma) {
                    System.out.println("Element " + elementNum + " of arrayOfStrPartsOnComma is: " + thePart);
                    elementNum++;
                }
                System.out.println();
                String[] arrayOfStrPartsOnSpace = arrayOfStrPartsOnComma[0].split(" ");
                elementNum = 0;
                for (String thePart : arrayOfStrPartsOnSpace) {
                    System.out.println("Element " + elementNum + " of arrayOfStrPartsOnSpace is: " + thePart);
                    elementNum++;
                }
                System.out.println();

                String[] arrayOfStrPartsOnSpace02 = arrayOfStrPartsOnComma[1].split(" ");
                elementNum = 0;
                for (String thePart : arrayOfStrPartsOnSpace02) {
                    System.out.println("Element " + elementNum + " of arrayOfStrPartsOnSpace02 is: " + thePart);
                    elementNum++;
                }
                System.out.println();

                String ageInYears = arrayOfStrPartsOnSpace[0];
                String animalBirthSeason = arrayOfStrPartsOnSpace02[2];
                System.out.println("The age in years of the animal is: " + ageInYears);
                System.out.println("The season of birth of the animal is: " + animalBirthSeason);

                // this is a unit test - we are testing the Animal constructor we just created
                Jonathon.zoo.com.Animal myNewAnimal = new Jonathon.zoo.com.Animal("male", 4, 70, "Zig", "Hy01", "2020-3-21", "brown spots", "from San Diego Zoo");

                // Prove it!
                System.out.println("\n this is the new animal!\n");
                System.out.println("\n ID is: " + myNewAnimal.getAnimalID() + " and... name is: " + myNewAnimal.getAnimalName() + "\n");

                System.out.println("animal birthdate is: " + calcAnimalBirthDate(Integer.parseInt(ageInYears), animalBirthSeason));

            }
        } catch (IOException e) {
            // Handle any I/O exceptions that occur
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            // Close the reader to free up resources
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing the reader: " + e.getMessage());
            }
        }


    }
}