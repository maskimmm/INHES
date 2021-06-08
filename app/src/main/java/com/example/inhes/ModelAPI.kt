package com.example.inhes

import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header

class ModelAPI {
    val client = AsyncHttpClient()
    val params = RequestParams()
    val url = "https://us-east1-project-bangkit-health.cloudfunctions.net/api_predict_covid"

    fun getMethod(){
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray
            ) {
                // called when response HTTP status is "200 OK"
            }
            override fun onFailure(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        })
    }
    fun postMethod(){

        params.put("name", "arif faizin")
        params.put("job", "academy content writer")

        client.post(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                // called when response HTTP status is "200 OK"
            }
            override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        })
    }

}