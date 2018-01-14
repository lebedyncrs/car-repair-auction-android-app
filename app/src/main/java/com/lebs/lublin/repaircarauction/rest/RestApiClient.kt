package com.lebs.lublin.repaircarauction.rest

import com.turbomanage.httpclient.BasicHttpClient
import com.turbomanage.httpclient.HttpResponse
import com.turbomanage.httpclient.ParameterMap

class RestApiClient {

    val http = BasicHttpClient("http://ec2-54-91-2-36.compute-1.amazonaws.com/api/")

    fun get(path: String, params: ParameterMap?): HttpResponse? {
        return http.get(path, params)
    }

    fun post(path: String, params: ParameterMap?): HttpResponse? {
        return http.post(path, params)
    }
}