package org.jalasoft;

import java.util.Scanner;

/**
 * BankClient
 */
public class BankClient {
    
    private Scanner scanner;
    private boolean done;
    private BankService bankServices;

    private int currentAccount;

    public BankClient() {
        done = false;
        currentAccount = 0;
    }

    /**
     * Ask the users the command they want to execute and execute that command 
     */
    public void run() {
        bankServices = new BankService();
        scanner = new Scanner(System.in);
        
        while (!done) {
            String menu = createMenu();
            System.out.print(menu);
            int commandNumber = scanner.nextInt();
            
            try {
                processCommand(commandNumber);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        scanner.close();
    }
    
    private String createMenu() {
        if (!bankServices.existsAccounts()) {
            return "Enter command (0=quit, 1=new): ";
        }
        
        return "Enter command (0=quit, 1=new, 2=select, 3=deposit, 4=loan, 5=show, 6=interest): ";
    }

    /**
     * Decides what command will be executed based on the command number
     * @param commandNumber the command that will be executed
     */
    private void processCommand(int commandNumber) {
        
        if (commandNumber > 1 && !bankServices.existsAccounts()) {
            System.out.println("Esta operacion requiere de una cuenta bancaria.");
            return;
        }
        
        if (commandNumber == 0)
            quit();
        else if (commandNumber == 1)
            newAccount();
        else if (commandNumber == 2)
            select();
        else if (commandNumber == 3)
            deposit();
        else if (commandNumber == 4)
            authorizeLoan();
        else if (commandNumber == 5)
            showAll();
        else if (commandNumber == 6)
            payInterest();
        else
            System.out.println("Illegal command");
    }

    private void quit() {
        done = true;
        System.out.println("Goodbye!");
    }

    private void newAccount() {
        System.out.println("Specify the origin of the account (Local, Foreign): ");
        String accountOriginAsString = scanner.next();        
        currentAccount = bankServices.newAccount(accountOriginAsString);
        System.out.println("Especifique el interes de la cuenta: ");
        Double interest = scanner.nextDouble();  
        bankServices.addInterestToAccount(currentAccount, interest);
        
        System.out.println("Your new account number is: " + currentAccount);
    }

    private void select() {
        
        System.out.print("Enter account#: ");
        currentAccount = scanner.nextInt();
        int balance = bankServices.getBalance(currentAccount); //delegates the work to the appropriate class
        System.out.println("The balance of account " + currentAccount + " is " + balance);
    }

    private void deposit() {
                
        System.out.print("Enter deposit amount: ");
        int amount = scanner.nextInt();
        bankServices.deposit(currentAccount, amount); //delegates the work to the appropriate class
    }

    private void authorizeLoan() {
        System.out.print("Enter loan amount: ");

        int loanAmount = scanner.nextInt();

        if (bankServices.authorizeLoan(currentAccount, loanAmount))
            System.out.println("Your loan is approved");
        else
            System.out.println("Your loan is denied");
    }

    private void showAll() {
        System.out.println(bankServices.getBankInformation());
    }

    private void payInterest() {       
        bankServices.payInterest();
    }
}