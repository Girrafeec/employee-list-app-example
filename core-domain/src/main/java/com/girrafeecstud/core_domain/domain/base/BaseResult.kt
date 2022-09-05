package com.girrafeecstud.core_domain.domain.base

sealed class BaseResult<out T> (
    val data: T?,
    val message: String?
        ) {
    data class Success <out R> (val _data: R?): BaseResult<R> (
        data = _data,
        message = null
            )
    data class Error <out R> (val _data: R?): BaseResult<R> (
        data = _data,
        message = null
            )
}