package jar.us.taskmanagementapi

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class DataLoader(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @Bean
    fun init(): CommandLineRunner = CommandLineRunner {
        userRepository.save(User(username = "john", password = passwordEncoder.encode("password123")))
    }
}
