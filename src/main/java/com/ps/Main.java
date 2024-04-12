package com.ps;

import java.util.*;

public class Main {

    public static void main(String[] args) { // main method

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Calculator:"); // allows user to choose a calculator

        System.out.println("1. Mortgage Calculator");
        System.out.println("2. Future Value Calculator");
        System.out.println("3. Present Value of Order Annuity");

        System.out.print("Enter choice: ");
        short choice = scanner.nextShort();


        switch (choice) { //utilizing switch statements for the three different cases/calculators

            case 1:
                mortgageCalculator(scanner);
                break; // mortgage calculator

            case 2:
                futureValueCalculator(scanner);
                break;

            case 3:
                presentValueCalculator(scanner);
                break;
                
            default:
                System.out.println("Invalid Calculator");
                  break;
        }
        scanner.close(); // close the scanner
        
    }

    public static void mortgageCalculator(Scanner scanner) { //static method

        System.out.println("Enter principal amount: "); // asks user for principal amount
        double loanAmount = scanner.nextDouble();

        System.out.println("Enter interest rate: "); //asks user for interest rate
        double interestRate = scanner.nextDouble();

        System.out.println("Enter loan length in years: "); // asks user for loan time in years.
        int loanLength = scanner.nextInt();

        int numPayments = loanLength * 12; //calculate number of payments to use in compounded interest formula as well as total interest.
        double monthlyInterestRate = (interestRate / 100) / 12; // calculate monthly interests (also for compounded interest formula

        double monthlyPayment = (loanAmount * (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numPayments))) / (Math.pow((1 + monthlyInterestRate), numPayments) - 1); // compounded interest formula to calculate monthly payments.

        double totalInterest = (monthlyPayment * numPayments) - loanAmount;

        System.out.printf("Monthly payment: $%.2f%n", monthlyPayment); // print results
        System.out.printf("Total interest: $%.2f%n", totalInterest);


    }

    public static void futureValueCalculator(Scanner scanner) { // static method

        System.out.println("Enter initial deposit amount: "); // asks user for deposit amount
        double initialDeposit = scanner.nextDouble();

        System.out.println("Enter your interest rate: "); // asks user for interest rate
        double InterestRate = scanner.nextDouble();

        System.out.println("Enter number of years: "); //asks user for number of years.
        int numYears = scanner.nextInt();

        double dailyInterestGained = (InterestRate / 100) / 365; // calculate daily interest rate gained
        double futureValue = (initialDeposit * (Math.pow((1 + dailyInterestGained), 365 * numYears))); // calculate  future value with daily compounding formula.
        double totalInterestEarned = futureValue - initialDeposit;

        System.out.printf("Future Value: $%.2f%n", futureValue); // output results.
        System.out.printf("Total Interest Earned: $%.2f%n", totalInterestEarned);



    }

    public static void presentValueCalculator(Scanner scanner) { // static method

        System.out.println("Enter expected monthly payout: "); // asks user for expected monthly payout
        double expectedMonthlyPayout = scanner.nextDouble();

        System.out.println("Enter interest rate: "); // asks user for interest rate.
        double expectedInterestRate = scanner.nextDouble();

        System.out.println("Payment Length in Years: "); // asks user for payment length in years.
        int paymentLength = scanner.nextInt();

        double Interest = (expectedInterestRate / 100) / 12; // monthly interest
        double presentValue = (expectedMonthlyPayout * ((1 - (Math.pow((1 + Interest), (-12 * paymentLength)))) / Interest)); // annuity formula to calculate the present value.

        System.out.printf("Present value of annuity: $%.2f", presentValue);

    } }






