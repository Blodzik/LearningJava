import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        boolean running = true;

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> tasks = new ArrayList<>();

        try {
            File file = new File("tasks.txt");
            Scanner fileReader = new Scanner(file);

            while(fileReader.hasNextLine()) {
                String task = fileReader.nextLine();
                tasks.add(task);
            }
            fileReader.close();
            System.out.println("Tasks loaded from file.");

        } catch(FileNotFoundException e) {
            System.out.println("No saved tasks found. Starting fresh.");
        }

        while(running) {
            System.out.println("\n1. Add Task. \n2. View Task. \n3. Delete Task. \n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("Enter Task: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    saveTasks(tasks);
                    break;
                case 2:
                    for(int i = 0; i < tasks.size(); i++) {
                        System.out.println(i + 1 + ".) " + tasks.get(i));
                    }
                    break;
                case 3:
                    for(int i = 0; i < tasks.size(); i++) {
                        System.out.println(i + 1 + ".) " + tasks.get(i));
                    }
                    System.out.println("Enter a number of a task you want to delete: ");
                    int num = scanner.nextInt() - 1;
                    if(num >= 0 && num < tasks.size()) {
                        tasks.remove(num);
                        saveTasks(tasks);
                        System.out.println("Task removed.");
                    } else {
                        System.out.println("Invalid input.");
                    }
                    break;
                case 4:
                    running = false;
                    break;
            }
        }
    }

    public static void saveTasks(ArrayList<String> tasks) {
        try {
            FileWriter writer = new FileWriter("tasks.txt");
            for (String task : tasks) {
                writer.write(task + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}