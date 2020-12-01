package com.platzi.conf

interface Callback<T> {
    fun onSuccess( result: T?)

    fun onFailed(exception: Exception)


}