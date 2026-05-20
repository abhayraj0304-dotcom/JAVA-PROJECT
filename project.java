import java.util.ArrayList;
import java.util.Scanner;

// Expense Class
class Expense {

    private int expenseId;
    private String expenseName;
    private String category;
    private double amount;

    // Constructor
    public Expense(int expenseId, String expenseName, String category, double amount) {

        this.expenseId = expenseId;
        this.expenseName = expenseName;
        this.category = category;
        this.amount = amount;
    }

    // Getters
    public int getExpenseId() {
        return expenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    // Setters
    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Display Expense
    public void displayExpense() {

        System.out.println(
                expenseId + " | " +
                expenseName + " | " +
                category + " | ₹" +
                amount
        );
    }
}

// Expense Manager Class
class ExpenseManager {

    ArrayList<Expense> expenses = new ArrayList<>();

    // Add Expense
    public void addExpense(Expense expense) {

        expenses.add(expense);

        System.out.println("Expense Added Successfully!");
    }

    // View Expenses
    public void viewExpenses() {

        if (expenses.isEmpty()) {

            System.out.println("No Expenses Found!");
            return;
        }

        System.out.println("\nID | Name | Category | Amount");
        System.out.println("--------------------------------");

        for (Expense e : expenses) {

            e.displayExpense();
        }
    }

    // Edit Expense
    public void editExpense(int id, String name, String category, double amount) {

        boolean found = false;

        for (Expense e : expenses) {

            if (e.getExpenseId() == id) {

                e.setExpenseName(name);
                e.setCategory(category);
                e.setAmount(amount);

                found = true;

                System.out.println("Expense Updated Successfully!");
                break;
            }
        }

        if (!found) {

            System.out.println("Expense ID Not Found!");
        }
    }

    // Delete Expense
    public void deleteExpense(int id) {

        boolean found = false;

        for (Expense e : expenses) {

            if (e.getExpenseId() == id) {

                expenses.remove(e);

                found = true;

                System.out.println("Expense Deleted Successfully!");
                break;
            }
        }

        if (!found) {

            System.out.println("Expense ID Not Found!");
        }
    }

    // Calculate Total Expense
    public void calculateTotal() {

        double total = 0;

        for (Expense e : expenses) {

            total += e.getAmount();
        }

        System.out.println("Total Expense = ₹" + total);
    }

    // Category Summary
    public void categorySummary(String category) {

        double total = 0;

        for (Expense e : expenses) {

            if (e.getCategory().equalsIgnoreCase(category)) {

                total += e.getAmount();
            }
        }

        System.out.println(category + " Expense = ₹" + total);
    }
}

// Main Class
public class project {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ExpenseManager manager = new ExpenseManager();

        int choice;

        do {

            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Edit Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Calculate Total Expense");
            System.out.println("6. Category Summary");
            System.out.println("7. Exit");

            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Expense ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Expense Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    Expense expense = new Expense(id, name, category, amount);

                    manager.addExpense(expense);

                    break;

                case 2:

                    manager.viewExpenses();

                    break;

                case 3:

                    System.out.print("Enter Expense ID to Edit: ");
                    int editId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Expense Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Category: ");
                    String newCategory = sc.nextLine();

                    System.out.print("Enter New Amount: ");
                    double newAmount = sc.nextDouble();

                    manager.editExpense(editId, newName, newCategory, newAmount);

                    break;

                case 4:

                    System.out.print("Enter Expense ID to Delete: ");
                    int deleteId = sc.nextInt();

                    manager.deleteExpense(deleteId);

                    break;

                case 5:

                    manager.calculateTotal();

                    break;

                case 6:

                    sc.nextLine();

                    System.out.print("Enter Category Name: ");
                    String cat = sc.nextLine();

                    manager.categorySummary(cat);

                    break;

                case 7:

                    System.out.println("Thank You!");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}