package auca.ac.rw.question5_task_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.question5_task_api.model.Task;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    
    public TaskController() {
        tasks.add(new Task(1L, "Study Spring Boot", "Learn REST controllers", false, "HIGH", "2026-02-15"));
        tasks.add(new Task(2L, "Finish Assignment", "Complete Question 5", false, "HIGH", "2026-02-10"));
        tasks.add(new Task(3L, "Buy Groceries", "Milk, Bread, Eggs", true, "LOW", "2026-02-08"));
        tasks.add(new Task(4L, "Workout", "Evening gym session", false, "MEDIUM", "2026-02-09"));
        tasks.add(new Task(5L, "Read Book", "Read Clean Code", true, "LOW", "2026-02-20"));
    }

    
    @GetMapping
    public List<Task> getAllTasks() {
        return tasks;
    }

    
    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                return ResponseEntity.ok(task);
            }
        }
        return ResponseEntity.notFound().build();
    }

    
    @GetMapping("/status")
    public List<Task> getTasksByStatus(@RequestParam boolean completed) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted() == completed) {
                result.add(task);
            }
        }
        return result;
    }

    
    @GetMapping("/priority/{priority}")
    public List<Task> getTasksByPriority(@PathVariable String priority) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority().equalsIgnoreCase(priority)) {
                result.add(task);
            }
        }
        return result;
    }

    
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        tasks.add(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long taskId,
            @RequestBody Task updatedTask) {

        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                task.setPriority(updatedTask.getPriority());
                task.setDueDate(updatedTask.getDueDate());
                task.setCompleted(updatedTask.isCompleted());
                return ResponseEntity.ok(task);
            }
        }
        return ResponseEntity.notFound().build();
    }

    
    @PatchMapping("/{taskId}/complete")
    public ResponseEntity<Task> markTaskAsCompleted(@PathVariable Long taskId) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                task.setCompleted(true);
                return ResponseEntity.ok(task);
            }
        }
        return ResponseEntity.notFound().build();
    }

    
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                tasks.remove(task);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}

