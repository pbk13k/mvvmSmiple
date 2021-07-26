package co.kr.nawa.mvvmsimple.util.async


import com.google.gson.JsonElement
import io.reactivex.Single
import retrofit2.http.*

interface ApiData {

    //json
    @GET
    fun getToJosn(
            @Url url: String,
            @QueryMap body: HashMap<String, Any>
    ): Single<JsonElement>

}