package com.example.kitsuapp.base

import com.example.kitsuapp.common.Resource
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {

    protected fun <T> doRequest(result: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(result()))
        } catch (exception: Exception) {
            emit(Resource.Error(message = exception.localizedMessage ?: "Error"))
        }
    }
}