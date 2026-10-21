
package com.devops.task_manager.service;

import com.devops.task_manager.entity.Task;
import com.devops.task_manager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Récupérer toutes les tâches
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Récupérer une tâche par ID
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->
                    new IllegalArgumentException("Tâche introuvable : " + id));
    }

    // Créer une tâche
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Modifier une tâche
    public Task updateTask(Long id, Task updatedTask) {
        Task task = getTaskById(id);

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());

        return taskRepository.save(task);
    }

    // Supprimer une tâche
    public void deleteTask(Long id) {
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }
}