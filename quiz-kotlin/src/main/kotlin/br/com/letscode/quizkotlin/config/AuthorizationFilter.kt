package br.com.letscode.quizkotlin.config

import br.com.letscode.quizkotlin.exception.AuthorizarionException
import br.com.letscode.quizkotlin.service.UsuarioService
import br.com.letscode.quizkotlin.utils.JwtTokenUtil
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class AuthorizationFilter(val service: UsuarioService) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) = run {

        if(request.requestURI == "/authentication")
            return filterChain.doFilter(request, response)

        val requestTokenHeader: String? = request.getHeader("Authorization");
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            val jwtToken = requestTokenHeader.substring(7)
            val userlogin = JwtTokenUtil.getUserLoginFromToken(jwtToken)
            val usuario = service.getUsuarioByLogin(userlogin)
            JwtTokenUtil.validateToken(jwtToken, usuario)

            val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
                usuario, listOf<String>(), listOf())
            SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
            filterChain.doFilter(request, response)
        } else {
            throw AuthorizarionException("Usuario não autorizado.")
        }
    }

}