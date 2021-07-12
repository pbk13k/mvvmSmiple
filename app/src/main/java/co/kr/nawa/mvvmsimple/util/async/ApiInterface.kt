package co.kr.nawa.mvvmsimple.util.async

import com.google.gson.JsonElement
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface ApiInterface {
    @GET
    fun getToJosn(
        @Url url: String,
        @QueryMap body: MutableMap<String, Any>
    ): Single<JsonElement>

}