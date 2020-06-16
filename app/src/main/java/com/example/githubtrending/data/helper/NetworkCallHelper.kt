package com.example.githubtrending.data.helper

import java.io.IOException
import java.text.ParseException

/**
 * Helper methods for network calls
 */
object NetworkCallHelper {

    /**
     * Calls the passed function and returns [ResultStatus]
     * Returns [ResultStatus.Success] if the call is succeeded
     * Returns [ResultStatus.Error] if an expected exception occurred.
     *
     */
    suspend fun <T : Any?> safeApiCall(
        call: suspend () -> T
    ): ResultStatus<T> {
        return try {
            ResultStatus.Success(call())
        } catch (e: IOException) {
            ResultStatus.Error(e)
        } catch (e: ParseException) {
            ResultStatus.Error(e)
        } catch (e: SecurityException) {
            ResultStatus.Error(e)
        }
    }

}