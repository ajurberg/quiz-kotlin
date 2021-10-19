package br.com.letscode.quizkotlin.exception

class LoginException(message: String): RuntimeException(message)
class AuthorizarionException(message: String): RuntimeException(message)
class AuthenticationException(message: String): RuntimeException(message)