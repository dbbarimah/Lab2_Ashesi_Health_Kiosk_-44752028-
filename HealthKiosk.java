import java.util.Scanner;
import java.util.Random;

public class HealthKiosk {
    public static void main (String[] args) {

        System.out.println("Welcome to the Ashesi Health Kiosk!");
        Scanner userInput = new Scanner(System.in);


        //Task 1 - Service Router
        System.out.println();
        System.out.println("Our Services:\nPharmacy Desk\nLab Desk\nTriage Desk\nCounselling Desk");
        System.out.println();
        System.out.println("Enter the first letter of the service you want to access (P/L/T/C):");
        char service = userInput.next().charAt (0);


        switch (service) {
            case 'P':
            case 'p':
                System.out.println("Go to: Pharmacy Desk.");
                break;
            case 'L':
            case 'l':
                System.out.println("Go to: Lab Desk.");
                break;
            case 'T':
            case 't':
                System.out.println("Go to: Triage Desk.");
                break;
            case 'C':
            case 'c':
                System.out.println("Go to: Counselling Desk.");
                break;
            default:
                System.out.println("Invalid Service Code.");
                break;
        }


        //Task 2 - Mini Health Metric
        long roundedBMI = 0;
        if (service == 'T' || service == 't'){
            System.out.println();
            System.out.println("Triage Desk");
            System.out.println("1. BMI\n2. Dosage round up\n3. Simple trig helper");
            System.out.println("Enter the health metric (1-3): ");
            int metric = userInput.nextInt();

            System.out.println();
            if (metric == 1){
                System.out.println("Enter your weight in kilograms(kg): ");
                double weight = userInput.nextDouble();
                System.out.println("Enter your height in meters(m): ");
                double height = userInput.nextDouble();

                double bmi = weight / Math.pow(height,2);
                bmi = Math.round(bmi  * 10) / 10.0;
                roundedBMI = Math.round(bmi);

                String category;
                if (bmi < 18.5){
                    category = "Underweight";
                } else if (bmi > 18.5 && bmi < 24.9){
                    category = "Normal";
                } else if (bmi > 25.0 && bmi < 29.9){
                    category = "Overweight";
                } else {
                    category = "Obese";
                }
                System.out.println("BMI: " + bmi + "   Category: " + category);

            } else if (metric == 2){
                System.out.println("Enter the required dosage(in mg): ");
                double dosage = userInput.nextDouble();
                double dispense = dosage / 250;
                int tablets = (int) Math.ceil(dispense);
                System.out.println("You will receive " + tablets + " tablets.");

            } else if (metric == 3){
                System.out.println("Enter an angle in degrees: ");
                double degrees = userInput.nextDouble();
                double radians = Math.toRadians(degrees);

                double sine = Math.sin(radians);
                sine = Math.round(sine * 1000.0) / 1000.0;
                double cosine = Math.cos(radians);
                cosine = Math.round(cosine * 1000.0) / 1000.0;

                System.out.println("The value of sine(" + degrees + ") is " + sine + " and the value of cosine(" + degrees + ") is " + cosine + ".");
            
            } else {
                System.out.println("Invalid Input");
            }
        }


        //Task 3 - ID Sanity Check
        System.out.println();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int index1 = (int)(Math.random() * alphabet.length());
        char letter = alphabet.charAt(index1);

        Random digits = new Random();
        int num1 = digits.nextInt(3,10);
        int num2 = digits.nextInt(3,10);
        int num3 = digits.nextInt(3,10);
        int num4 = digits.nextInt(3,10);
        String number = ("" + num1 + num2 + num3 + num4);

        String userID = letter + number;
        System.out.println("Your ID is: " + userID);

        if (userID.length() == 5){
            if (Character.isLetter(userID.charAt(0))){
                if (Character.isDigit(userID.charAt(1)) &&
                    Character.isDigit(userID.charAt(2)) &&
                    Character.isDigit(userID.charAt(3)) &&
                    Character.isDigit(userID.charAt(4))){
                        System.out.println("ID is okay.");
                } else {
                    System.out.println("Invalid: Last 4 characters must be digits.");
                }                   
            } else {
                System.out.println("Invalid: First character must be a letter.");
            }
        } else {
            System.out.println("Invalid length");
        }


        //Task 4 - "Secure" Display Code
        System.out.println();
        System.out.println("Enter your first name: ");
        String name = userInput.next();

        char firstLetter = Character.toUpperCase(name.charAt(0));
        char newLetter = (char)('A' + (firstLetter - 'A' + 2) % 26);
        System.out.println("Shifted letter of base code = " + newLetter);

        char lastButOneID = userID.charAt(userID.length() - 2);
        char lastID = userID.charAt(userID.length() - 1);
        System.out.println("Last two characters for ID: " + lastButOneID + lastID);
        String displayCode = ("" + newLetter + lastButOneID + lastID + '-' + roundedBMI);
        System.out.println("Display Code: " + displayCode);


        //Task 5 - Service Summary
        System.out.println();
        switch (service) {
            case 'P':
                System.out.println("Summary: PHARMACY | ID=" + userID + " | Code=" + displayCode);
                break;
            case 'L':
                System.out.println("Summary: TRIAGE | ID=" + userID + " | Code=" + displayCode);
                break;
            case 'T':
                System.out.println("Summary: LAB | ID=" + userID + " | Code=" + displayCode);
                break;
            case 'C':
                System.out.println("Summary: COUNSELLING | ID=" + userID + " | Code=" + displayCode);
                break;
        }    
            
        userInput.close();
    }
}
