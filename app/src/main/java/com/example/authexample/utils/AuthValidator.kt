package com.example.authexample.utils

object AuthValidator {
    fun validateEmail(email: String): String? {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return when {
            email.isBlank() -> "Email tidak boleh kosong"
            !email.matches(emailPattern.toRegex()) -> "Format email salah"
            else -> null
        }
    }

    fun validatePassword(password: String): String? {
        return when {
            password.isBlank() -> "Password tidak boleh kosong"
            password.length < 6 -> "Minimal 6 karakter"
            else -> null
        }
    }

    fun validateConfirmPassword(password: String, confirm: String): String? {
        return if (password != confirm) "Password tidak cocok" else null
    }
}