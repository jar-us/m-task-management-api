package jar.us.taskmanagementapi

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val jwtUtil: JwtUtil,
) {

    @PostMapping("/login")
    fun login(@RequestBody authRequest: AuthRequest): Map<String, String> {

        val authentication: Authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(authRequest.username, authRequest.password)
        )
        SecurityContextHolder.getContext().authentication = authentication
        val token = jwtUtil.generateToken(authRequest.username)
        return mapOf("token" to token)
    }
}

data class AuthRequest(
    val username: String,
    val password: String,
)

