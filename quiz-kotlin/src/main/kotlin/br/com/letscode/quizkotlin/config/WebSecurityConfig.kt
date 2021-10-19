package br.com.letscode.quizkotlin.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig(val authorizationFilter: AuthorizationFilter): WebSecurityConfigurerAdapter() {
    override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity.csrf().disable()
            .authorizeRequests()
            .antMatchers("/authorization")
            .permitAll()
            .anyRequest()
            .authenticated().and().exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        httpSecurity.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter::class.java)
    }
}