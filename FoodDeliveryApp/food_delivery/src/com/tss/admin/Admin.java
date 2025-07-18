package com.tss.admin;

import java.util.List;
import java.util.Scanner;

import com.tss.model.FoodItem;
import com.tss.utils.DataWriter;

public class Admin {
	
	 private final MenuManager menuManager;
	    private final DiscountManager discountManager;
	    private final DeliveryAgentManager agentManager;
	    private final Scanner scanner;

	    private final List<FoodItem> sharedMenu;

	    public Admin(List<FoodItem> sharedMenu) {
	        this.sharedMenu = sharedMenu;
	        this.menuManager = new MenuManager();
	        this.discountManager = new DiscountManager();
	        this.agentManager = new DeliveryAgentManager();
	        this.scanner = new Scanner(System.in);

	        for (FoodItem item : sharedMenu) {
	            menuManager.addFoodItem(item);
	        }
	    }

	    public void launchAdminPanel() {
	        System.out.println("Welcome Admin!");

	        while (true) {
	            System.out.println("\n--- Admin Menu ---");
	            System.out.println("1. Manage Menu");
	            System.out.println("2. Manage Discounts");
	            System.out.println("3. Manage Delivery Agents");
	            System.out.println("4. Exit Admin Panel");
	            System.out.print("Enter option: ");
	            int choice = getIntInput();

	            switch (choice) {
	                case 1:
	                    manageMenu();
	                    break;
	                case 2:
	                    manageDiscounts();
	                    break;
	                case 3:
	                    manageAgents();
	                    break;
	                case 4:
	                    System.out.println("Exiting Admin Panel...");
	                    return;
	                default:
	                    System.out.println("Invalid choice.");
	            }
	        }
	    }

	    private void manageMenu() {
	        while (true) {
	            System.out.println("\n--- Menu Management ---");
	            System.out.println("1. Add Food Item");
	            System.out.println("2. Remove Food Item by Number");
	            System.out.println("3. View Menu");
	            System.out.println("4. Back");
	            System.out.print("Enter choice: ");
	            int opt = getIntInput();
	            scanner.nextLine();

	            switch (opt) {
	                case 1:
	                    System.out.print("Enter item name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter price: ");
	                    double price = getDoubleInput();
	                    scanner.nextLine(); 
	                    menuManager.addFoodItem(new FoodItem(name, price));
	                    
	                    sharedMenu.clear();
	                    sharedMenu.addAll(menuManager.getMenuItems());
	                    DataWriter.writeToFile("menu.dat", sharedMenu);
	                    
	                    System.out.println("Item added successfully.");
	                    break;

	                case 2:
	                    if (menuManager.getMenuItems().isEmpty()) {
	                        System.out.println("Menu is empty.");
	                        break;
	                    }
	                    menuManager.displayMenu();
	                    System.out.print("Enter item number to remove: ");
	                    int index = getIntInput();
	                    menuManager.removeFoodItemByIndex(index);
	                    
	                    sharedMenu.clear();
	                    sharedMenu.addAll(menuManager.getMenuItems());
	                    DataWriter.writeToFile("menu.dat", sharedMenu);
	                    
	                    break;

	                case 3:
	                    menuManager.displayMenu();
	                    break;

	                case 4:
	                    return;

	                default:
	                    System.out.println("Invalid option.");
	            }
	        }
	    }

	    private void manageDiscounts() {
	        while (true) {
	            System.out.println("\n--- Discount Management ---");
	            System.out.println("1. View Discount");
	            System.out.println("2. Edit Discount Percentage");
	            System.out.println("3. Back");
	            System.out.print("Enter choice: ");
	            int opt = getIntInput();

	            switch (opt) {
	                case 1:
	                    discountManager.viewDiscount();
	                    break;
	                case 2:
	                    System.out.print("Enter new discount percentage: ");
	                    double percent = getDoubleInput();
	                    discountManager.editDiscountPercentage(percent);
	                    break;
	                case 3:
	                	return;
	                         
	                default:
	                    System.out.println("Invalid option.");
	            }
	        }
	    }

	    private void manageAgents() {
	        while (true) {
	            System.out.println("\n--- Delivery Agent Management ---");
	            System.out.println("1. Add Agent");
	            System.out.println("2. Remove Agent");
	            System.out.println("3. View Agents");
	            System.out.println("4. Back");
	            System.out.print("Enter choice: ");
	            int opt = getIntInput();
	            switch (opt) {
	                case 1:
	                    System.out.print("Enter agent name: ");
	                    String name = scanner.next();
	                    agentManager.addAgent(name);
	                    System.out.println("Agent Added :" + name);
	                    
	                    break;
	                case 2:
	                    System.out.print("Enter agent name to remove: ");
	                    String rmName = scanner.next();
	                    agentManager.removeAgent(rmName);
	                    break;
	                case 3:
	                    agentManager.viewAgents();
	                    break;
	                case 4:
	                    return;
	                default:
	                    System.out.println("Invalid option.");
	            }
	        }
	    }

	    private int getIntInput() {
	        while (!scanner.hasNextInt()) {
	            System.out.println("Please enter a valid number.");
	            scanner.next();
	        }
	        return scanner.nextInt();
	    }

	    private double getDoubleInput() {
	        while (!scanner.hasNextDouble()) {
	            System.out.println("Please enter a valid amount.");
	            scanner.next();
	        }
	        return scanner.nextDouble();
	    }


}
