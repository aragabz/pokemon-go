package com.ragabz.pokemongo.core

sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data: $data]"
            is Error -> "Error[error: $error]"
        }
    }
}

inline infix fun <reified X> Result<X>.onSuccess(action: (X) -> Unit): Result<X> {
    if (this is Result.Success) {
        action.invoke(this.data)
    }
    return this
}

inline infix fun <reified X> Result<X>.onError(action: (Exception) -> Unit): Result<X> {
    if (this is Result.Error) {
        action.invoke(this.error)
    }
    return this
}
