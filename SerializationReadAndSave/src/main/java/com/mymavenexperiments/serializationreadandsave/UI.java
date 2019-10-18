package com.mymavenexperiments.serializationreadandsave;

import java.util.Scanner;

public class UI {

    private DefinitionContainer container;
    private Scanner scanner;

    public UI() {
        this.container = new DefinitionContainer();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        printMenu();
    }

    public void printMenu() {
        OUTER:
        while (true) {
            System.out.println("choose one of the following options:");
            System.out.println(
                    "1. insert a definition\n2. look for a definition\n3. print all definitions\n4. remove a definition\n5. save and close");
            System.out.print("Your choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addDef();
                        break;
                    case 2:
                        getDef();
                        break;
                    case 3:
                        printAll();
                        break;
                    case 4:
                        removeDef();
                        break;
                    case 5:
                        saveAtClose();
                        break OUTER;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("You didn't type a valid number. Please retry");
                printMenu();
            }
        }
    }

    public void addDef() {
        System.out.print("Insert title:");
        String title = scanner.nextLine();
        System.out.print("Insert definition:");
        String definition = scanner.nextLine();
        this.container.addToList(new Definition(title, definition));
    }

    public Definition getDef() {
        System.out.print("Titolo da cercare:");
        String titolo = scanner.nextLine();
        return this.container.getDefinizione(titolo);
    }

    public void printAll() {
        for (Definition d : this.container.getList()) {
            System.out.println(d);
        }
    }

    public void removeDef() {
        System.out.print("What def do you wish to remove:");
        String titolo = scanner.nextLine();
        this.container.removeFromList(titolo);
    }

    public void saveAtClose() {
        this.container.stopAndSave();
    }
}
