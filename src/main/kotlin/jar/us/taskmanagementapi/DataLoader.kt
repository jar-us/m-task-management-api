package jar.us.taskmanagementapi

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class DataLoader(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {
    @Bean
    fun init(): CommandLineRunner = CommandLineRunner {
        val user1 = User(
            username = "john",
            password = passwordEncoder.encode("password123"),
            roles = setOf("USER")
        )
        val user2 = User(
            username = "admin",
            password = passwordEncoder.encode("admin123"),
            roles = setOf("ADMIN", "USER")
        )
        userRepository.saveAll(listOf(user1, user2))
    }
}
