package vrsalex.matule.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/collections/users/records", "/collections/users/auth-with-password").permitAll()
                    .requestMatchers("/collections/products/**", "/collections/news/**").permitAll()
                    .requestMatchers("/collections/project/**").permitAll()

                    .requestMatchers("/h2-console/**").permitAll()
                    .anyRequest().permitAll()
            }

            .sessionManagement { session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }

        // 4. Добавляем фильтр для обработки JWT-токенов (нужно будет реализовать)
        // .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter::class.java)

        // Разрешаем H2 Console работать во фреймах
        http.headers { headers -> headers.frameOptions { it.sameOrigin() } }

        return http.build()
    }
}