import java.io.*;
import java.util.*;

public class DailyPlanner{
    static Scanner sc=new Scanner(System.in);

    static double sugidamaWage=1200;
    static double shabuYouWage=1172;
    public static void main(String[] args) {

        showTodayShift();

        while (true) { 
            System.out.println("\n===Daily Planner===");
            System.out.println("1. Add Job");
            System.out.println("2. Add Expense");
            System.out.println("3. Add Workout");
            System.out.println("4. View All Data");
            System.out.println("5. Add Shift");
            System.out.println("6. Show Today's Shift");
            System.out.println("7. Exit");

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
                addShift();
            }
            else if(choice==6){
                showTodayShift();
            }
            else if(choice==7){
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
        static void addShift() {
            try {
                System.out.print("Workplace (Sugidama/ShabuYou: ");
                String workplace = sc.nextLine();

                System.out.print("Date (YYYY-MM-DD): ");
                String date=sc.nextLine();

                System.out.print("Planned End (HH:MM): ");
                String pStart=sc.nextLine();

                System.out.print("Planned End(HH:MM): ");
                String pEnd=sc.nextLine();

                System.out.print("Actual Start(HH:MM): ");
                String aStart= sc.nextLine();

                System.out.print("Actual End (HH:MM): ");
                String aEnd=sc.nextLine();

                FileWriter fw = new FileWriter("shifts.txt",true);
                fw.write(workplace + "," + date + "," + pStart + "," + pEnd + "," + aStart + "," + aEnd + "\n");
                fw.close();

                System.out.println("Shift Saved!");
            } catch (Exception e){
                System.out.println("Error saving shift.");
            }
        }

        static void showTodayShift(){
            try {
                File file= new File("shifts.txt");
                if(!file.exists()) return;

                Scanner reader = new Scanner(file);
                String today = java.time.LocalDate.now().toString();

                boolean found = false;

                while(reader.hasNextLine()){
                    String line = reader.nextLine();
                    String[] data= line.split(",");
                    
                    if (data[1].equals(today)){
                        if(!found){
                            System.out.println("\n ⚠️ Today's Shift");
                            found = true;
                        }
                        System.out.println(data[0] + " | " + data[2] + " - " + data[3]);

                    }
                }

                reader.close();
            } catch (Exception e) {
                System.out.println("Error reading shifts.");
            }
        }
    
    }

