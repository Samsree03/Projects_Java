import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed"); // New option
            System.out.println("4. Visualize Schedule");
            System.out.println("5. Remove Task");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter start time (HH:mm): ");
                    LocalTime startTime = LocalTime.parse(scanner.nextLine());
                    System.out.print("Enter end time (HH:mm): ");
                    LocalTime endTime = LocalTime.parse(scanner.nextLine());
                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = scanner.nextLine();

                    Task task = new Task(description, startTime, endTime, priority);
                    manager.addTask(task);
                    break;

                case 2:
                    System.out.println("Scheduled Tasks:");
                    manager.getTasks().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter task description to mark as completed: ");
                    String taskDesc = scanner.nextLine();
                    manager.markTaskAsCompleted(taskDesc); // New method to mark as completed
                    break;

                case 4:
                    manager.visualizeSchedule(); // New option to visualize schedule
                    break;

                case 5:
                    System.out.print("Enter task description to remove: ");
                    String taskToRemove = scanner.nextLine();
                    manager.removeTask(taskToRemove);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    manager.shutdown(); // Shutdown timer
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
