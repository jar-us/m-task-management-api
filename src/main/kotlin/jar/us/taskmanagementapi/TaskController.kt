package jar.us.taskmanagementapi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class TaskController {

    @GetMapping("/public/welcome")
    fun publicEndpoint(): String = "Welcome to Task Manager API!"

    @GetMapping("/tasks")
    fun getTasks(): List<String> {
        return listOf("Task 1", "Task 2", "Task 3")
    }
}
