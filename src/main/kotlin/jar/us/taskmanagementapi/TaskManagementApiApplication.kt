package jar.us.taskmanagementapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaskManagementApiApplication

fun main(args: Array<String>) {
    runApplication<TaskManagementApiApplication>(*args)
}
