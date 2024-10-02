import java.time.LocalTime;

public class Task {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private String priority;
    private boolean completed; // Field to track completion status

    public Task(String description, LocalTime startTime, LocalTime endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.completed = false; // Initialize as not completed
    }

    // Method to mark the task as completed
    public void markAsCompleted() {
        this.completed = true;
    }

    // Method to check if the task is completed
    public boolean isCompleted() {
        return completed;
    }

    // Getters for task attributes
    public String getDescription() {
        return description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getPriority() {
        return priority;
    }

    // toString method to display task information
    @Override
    public String toString() {
        return String.format("[%s] %s (Priority: %s)", completed ? "Completed" : "Not Completed", description, priority);
    }
}
