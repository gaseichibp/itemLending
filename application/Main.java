package application;

import entities.LendingSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LendingSystem system = new LendingSystem(10);

        while (true) {
            System.out.println("<======>");
            System.out.println("  Menu ");
            System.out.println("<======>");
            System.out.println("1. Register Client");
            System.out.println("2. Register Item");
            System.out.println("3. Perform Loan");
            System.out.println("4. Perform Return");
            System.out.println("5. List Loaned Items");
            System.out.println("6. List Available Items");
            System.out.println("0. Exit");
            System.out.println();
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Client Name: ");
                    String clientName = scanner.nextLine();
                    System.out.print("Client CPF: ");
                    String clientCpf = scanner.nextLine();
                    system.registerClient(clientName, clientCpf);
                    break;
                case 2:
                    System.out.print("Item Name: ");
                    String itemName = scanner.nextLine();
                    system.registerItem(itemName);
                    break;
                case 3:
                    System.out.print("Item Name for Loan: ");
                    String loanItem = scanner.nextLine();
                    System.out.print("Client CPF: ");
                    String loanCpf = scanner.nextLine();
                    system.performLoan(loanItem, loanCpf);
                    break;
                case 4:
                    System.out.print("Item Name for Return: ");
                    String returnItem = scanner.nextLine();
                    system.performReturn(returnItem);
                    break;
                case 5:
                    system.listLoanedItems();
                    break;
                case 6:
                    system.listAvailableItems();
                    break;
                case 0:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return; // End the program
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
