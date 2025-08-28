package taskmanagementsystem.state;

import taskmanagementsystem.enums.TaskStatus;
import taskmanagementsystem.models.Task;

public interface TaskState {
    void startProgress(Task task);
    void completeTask(Task task);
    void reopenTask(Task task);
    TaskStatus getStatus();
}
