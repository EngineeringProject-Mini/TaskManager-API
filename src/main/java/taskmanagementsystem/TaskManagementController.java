package taskmanagementsystem;

import org.springframework.web.bind.annotation.*;
import taskmanagementsystem.enums.TaskPriority;
import taskmanagementsystem.enums.TaskStatus;
import taskmanagementsystem.models.Task;
import taskmanagementsystem.models.TaskList;
import taskmanagementsystem.models.User;
import taskmanagementsystem.strategy.SortByDueDate;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tasksystem")
public class TaskManagementController {

    private final TaskManagementSystem service = TaskManagementSystem.getInstance();

    // 1. Create User
    @PostMapping("/users")
    public User createUser(@RequestParam String name, @RequestParam String email) {
        return service.createUser(name, email);
    }

    // 2. Create Task List
    @PostMapping("/lists")
    public TaskList createTaskList(@RequestParam String name) {
        return service.createTaskList(name);
    }

    // 3. Create Task
    @PostMapping("/tasks")
    public Task createTask(@RequestParam String title,
                           @RequestParam String description,
                           @RequestParam String dueDate, // yyyy-MM-dd
                           @RequestParam TaskPriority priority,
                           @RequestParam String createdByUserId) {
        return service.createTask(title, description, LocalDate.parse(dueDate), priority, createdByUserId);
    }

    // 4. Add Subtask
    @PostMapping("/tasks/{parentId}/subtask")
    public String addSubtask(@PathVariable String parentId,
                             @RequestParam String title,
                             @RequestParam String description,
                             @RequestParam String dueDate,
                             @RequestParam TaskPriority priority,
                             @RequestParam String createdByUserId) {
        Task parent = service.createTask("temp", "", LocalDate.now(), TaskPriority.LOW, createdByUserId);
        Task subtask = service.createTask(title, description, LocalDate.parse(dueDate), priority, createdByUserId);
        parent.addSubtask(subtask);
        return "Subtask added under task: " + parentId;
    }

    // 5. Assign Task
    @PostMapping("/tasks/{taskId}/assign")
    public String assignTask(@PathVariable String taskId, @RequestParam String userId) {
        Task task = service.searchTasks(taskId, new SortByDueDate()).stream().findFirst().orElse(null);
        if (task != null) {
            task.setAssignee(service.createUser("temp", "temp@mail.com")); // should fetch from users map
            return "Task assigned!";
        }
        return "Task not found!";
    }

    // 6. Update Task Status
    @PostMapping("/tasks/{taskId}/status")
    public String updateStatus(@PathVariable String taskId, @RequestParam TaskStatus status) {
        Task task = service.searchTasks(taskId, new SortByDueDate()).stream().findFirst().orElse(null);
        if (task == null) return "Task not found!";
        switch (status) {
            case IN_PROGRESS -> task.startProgress();
            case DONE -> task.completeTask();
            default -> {}
        }
        return "Task " + taskId + " status updated to " + status;
    }

    // 7. Search Tasks
    @GetMapping("/tasks/search")
    public List<Task> searchTasks(@RequestParam String keyword) {
        return service.searchTasks(keyword, new SortByDueDate());
    }

    // 8. Filter Tasks by Status
    @GetMapping("/tasks/filter")
    public List<Task> filterByStatus(@RequestParam TaskStatus status) {
        return service.listTasksByStatus(status);
    }

    // 9. Get tasks assigned to a User
    @GetMapping("/users/{userId}/tasks")
    public List<Task> getUserTasks(@PathVariable String userId) {
        return service.listTasksByUser(userId);
    }

    // 10. Delete Task
    @DeleteMapping("/tasks/{taskId}")
    public String deleteTask(@PathVariable String taskId) {
        service.deleteTask(taskId);
        return "Task deleted: " + taskId;
    }
}
