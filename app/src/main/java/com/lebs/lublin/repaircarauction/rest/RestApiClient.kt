package com.lebs.lublin.repaircarauction.rest

import com.turbomanage.httpclient.BasicHttpClient
import com.turbomanage.httpclient.HttpResponse
import com.turbomanage.httpclient.ParameterMap

class RestApiClient {

    val http = BasicHttpClient("http://10.0.2.2/android-app/public/api/")

    fun get(path: String, params: ParameterMap?): HttpResponse? {
        return http.get(path, params)
    }

    fun post(path: String, params: ParameterMap?): HttpResponse? {
        return http.post(path, params)
    }
}