import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private Timer alertTimer;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        alertTimer = new Timer();
        startAlertSystem(); // Start the alert system
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        if (isValidTask(task)) {
            tasks.add(task);
            System.out.println("Task added successfully. No conflicts.");
        } else {
            System.out.println("Error: Task conflicts with an existing task.");
        }
    }

    public List<Task> getTasks() {
        tasks.sort((t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()));
        return tasks;
    }

    public boolean isValidTask(Task newTask) {
        for (Task task : tasks) {
            if (newTask.getStartTime().isBefore(task.getEndTime()) && newTask.getEndTime().isAfter(task.getStartTime())) {
                return false;
            }
        }
        return true;
    }

    public void removeTask(String description) {
        Optional<Task> taskToRemove = tasks.stream().filter(t -> t.getDescription().equals(description)).findFirst();
        if (taskToRemove.isPresent()) {
            tasks.remove(taskToRemove.get());
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    // New method to mark a task as completed
    public void markTaskAsCompleted(String description) {
        Optional<Task> taskToMark = tasks.stream().filter(t -> t.getDescription().equals(description)).findFirst();
        if (taskToMark.isPresent()) {
            taskToMark.get().markAsCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void visualizeSchedule() {
        System.out.println("Timeline of Today's Schedule:");
        System.out.println("----------------------------------");
        for (Task task : getTasks()) {
            String completionStatus = task.isCompleted() ? "Completed" : "Not Completed";
            System.out.printf("%s - %s: [%s] (Priority: %s) (%s)%n", 
                task.getStartTime(), 
                task.getEndTime(), 
                task.getDescription(), 
                task.getPriority(),
                completionStatus);
            System.out.println("----------------------------------");
        }
    }

    private void startAlertSystem() {
        alertTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                checkForUpcomingTasks();
            }
        }, 0, 60000); // Check every minute
    }

    private void checkForUpcomingTasks() {
        LocalTime now = LocalTime.now();
        for (Task task : tasks) {
            if (!task.isCompleted() && task.getStartTime().isAfter(now) && task.getStartTime().isBefore(now.plusMinutes(5))) {
                System.out.printf("ALERT: The task '%s' is starting soon at %s! [Priority: %s]%n", 
                    task.getDescription(), 
                    task.getStartTime(), 
                    task.getPriority());
            }
        }
    }

    public void shutdown() {
        alertTimer.cancel();
    }
}
