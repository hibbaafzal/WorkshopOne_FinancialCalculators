package com.ps;

import java.util.*;

public class Main {

    public static void main(String[] args) { // main method

        Scanner scanner = new Scanner(System.in); 


        System.out.println("Enter principal: "); //asks user for principal.
        double loanPrincipal = scanner.nextDouble(); 

        System.out.println("Enter interest rate: "); // asks user for interest rate.
        double interestRate = scanner.nextDouble(); 

        System.out.println("Enter loan length: "); // asks user for length of loan.
        int loanLength = scanner.nextInt();


        // monthly interest rate and the total number of payments
        double monthlyInterestRate = interestRate / 100 / 12; // calculate monthly interest rate.

        int numPayments = loanLength * 12; 

        // expected monthly payment
        double monthlyPayment = (loanPrincipal * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, - numPayments)); // formula for compounded interest

        double totalPayment = monthlyPayment * numPayments;
        double totalInterestPaid = totalPayment - loanPrincipal;

        // Output the results rounded to 2 decimal places. 
        System.out.printf("Monthly Payment: $%.2f%n", monthlyPayment);
        System.out.printf("Total Interest Paid: $%.2f%n", totalInterestPaid);
    }
}


