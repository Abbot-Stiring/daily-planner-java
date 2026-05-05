import java.io.*;
import java.util.*;

public class DailyPlanner{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        while (true) { 
            System.out.println("\n===Daily Planner===");
            System.out.println("1. Add Job");
            System.out.println("2. Add Expense");
            System.out.println("3. Add Workout");
            System.out.println("4. View All Data");
            System.out.println("5. Exit");

            System.out.println("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice==1){
                addJob();             
            }
            else if(choice==2){
                addExpense();
            }
            else if(choice==3){
                addWorkout();
            }
            else if(choice==4){
                viewData();
            }
            else if(choice==5){
                System.out.println("GoodBye!");
                break;
            }
            else{
                System.out.println("Invalid choice");
            }
            }
        
        }

        static void addJob(){
            try {
                System.out.print("Enter Date (YYYY-MM-DD): ");
                String date=sc.nextLine();

                System.out.print("Income: ");
                int income=sc.nextInt();
                sc.nextLine();

                FileWriter fw =new FileWriter("jobs.txt",true);
                fw.write(date + " |  Income: "+ income + "\n");
                fw.close();

                System.out.println("Job Saved");
            } catch (Exception e) {
                System.out.println("Error saving Job.");
            }
        }

        static void addExpense() {
            try{
                System.out.print("Enter Date (YYYY-MM-DD): ");
                String date = sc.nextLine();
                System.out.print("Expense: ");
                int expense= sc.nextInt();
                sc.nextLine();

                FileWriter fw = new FileWriter("expenses.txt",true);
                fw.write(date + " | Expense: "+ expense + "\n");
                fw.close();

                System.out.println("Expense Saved");

            }
            catch (Exception e){
                System.out.println("Error saving expense.");
            }
        }
        
        static void addWorkout() {
            try{
                System.out.print("Enter Date (YYYY-MM-DD): ");
                String date = sc.nextLine();
                System.out.print("Expense: ");
                int workout= sc.nextInt();
                sc.nextLine();

                FileWriter fw = new FileWriter("workouts.txt",true);
                fw.write(date + " | Workout: "+  workout + "\n");
                fw.close();

                System.out.println("Workout Saved");

            }
            catch (Exception e){
                System.out.println("Error saving workout.");
            }
        }

        static void viewData(){
            readFile("jobs.txt");
            readFile("expenses.txt");
            readFile("workouts.txt");
        }

        static void readFile(String filename) {
            try {
                File file =new File(filename);
                Scanner reader = new Scanner(file);
                System.out.println("\n---" + filename + "---");

                while (reader.hasNextLine()){
                    System.out.println(reader.nextLine());
                }
                reader.close();
            } catch (Exception e) {
                System.out.println(filename+ "not found.");
            }
            
        }

    }

