package br.com.letscode.quizkotlin.handle

import br.com.letscode.quizkotlin.exception.LoginException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class HandleException : ResponseEntityExceptionHandler() {

    data class Error(
        val message: String?,
        val code: Int
    )

    @ExceptionHandler(value = [LoginException::class])
    protected fun handleAuthentication(
        ex: RuntimeException, request: WebRequest
    ): ResponseEntity<Error> = ResponseEntity.status(422).body(
        Error(
            ex.message,
            401
        )
    )
}
