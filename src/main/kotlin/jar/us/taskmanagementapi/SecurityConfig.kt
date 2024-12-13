package jar.us.taskmanagementapi

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

@Configuration
class SecurityConfig(private val userRepository: UserRepository) {

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf().disable()
            .authorizeHttpRequests {
                it.requestMatchers("/api/public/**").permitAll() // Public endpoints
                    .anyRequest().authenticated() // Secure all other endpoints
            }
            .httpBasic() // Use Basic Authentication
        return http.build()
    }

    @Bean
    fun userDetailsService(): UserDetailsService = UserDetailsService { username ->
        val user = userRepository.findByUsername(username)
            ?: throw RuntimeException("User not found")
        org.springframework.security.core.userdetails.User
            .withUsername(user.username)
            .password(user.password)
            .roles("USER")
            .build()
    }
}
