import java.util.*;

// Expense class
class Expense {

    int id;
    String name;
    String category;
    double amount;

    // Constructor
    Expense(int id, String name, String category, double amount) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.amount = amount;
    }

    // Display expense details
    void showExpense() {

        System.out.println(id + " | " + name + " | " + category + " | ₹" + amount);
    }
}

// Main class
public class ExpenseTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Expense> list = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Edit Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Total Expense");
            System.out.println("6. Category Summary");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // Add Expense
                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Expense Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    Expense e = new Expense(id, name, category, amount);

                    list.add(e);

                    System.out.println("Expense Added Successfully!");

                    break;

                // View Expenses
                case 2:

                    if (list.isEmpty()) {

                        System.out.println("No Expenses Found!");
                    }

                    else {

                        System.out.println("\nID | Name | Category | Amount");
                        System.out.println("--------------------------------");

                        for (Expense ex : list) {

                            ex.showExpense();
                        }
                    }

                    break;

                // Edit Expense
                case 3:

                    System.out.print("Enter Expense ID to Edit: ");
                    int editId = sc.nextInt();
                    sc.nextLine();

                    boolean updated = false;

                    for (Expense ex : list) {

                        if (ex.id == editId) {

                            System.out.print("Enter New Name: ");
                            ex.name = sc.nextLine();

                            System.out.print("Enter New Category: ");
                            ex.category = sc.nextLine();

                            System.out.print("Enter New Amount: ");
                            ex.amount = sc.nextDouble();

                            updated = true;

                            System.out.println("Expense Updated Successfully!");

                            break;
                        }
                    }

                    if (!updated) {

                        System.out.println("Expense ID Not Found!");
                    }

                    break;

                // Delete Expense
                case 4:

                    System.out.print("Enter Expense ID to Delete: ");
                    int deleteId = sc.nextInt();

                    boolean removed = false;

                    for (int i = 0; i < list.size(); i++) {

                        if (list.get(i).id == deleteId) {

                            list.remove(i);

                            removed = true;

                            System.out.println("Expense Deleted Successfully!");

                            break;
                        }
                    }

                    if (!removed) {

                        System.out.println("Expense ID Not Found!");
                    }

                    break;

                // Total Expense
                case 5:

                    double total = 0;

                    for (Expense ex : list) {

                        total = total + ex.amount;
                    }

                    System.out.println("Total Expense = ₹" + total);

                    break;

                // Category Summary
                case 6:

                    sc.nextLine();

                    System.out.print("Enter Category Name: ");
                    String cat = sc.nextLine();

                    double catTotal = 0;

                    for (Expense ex : list) {

                        if (ex.category.equalsIgnoreCase(cat)) {

                            catTotal = catTotal + ex.amount;
                        }
                    }

                    System.out.println(cat + " Expense = ₹" + catTotal);

                    break;

                // Exit
                case 7:

                    System.out.println("Thank You!");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

    
    }
}
