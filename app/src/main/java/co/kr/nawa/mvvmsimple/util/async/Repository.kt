package co.kr.nawa.mvvmsimple.util.async

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import io.reactivex.Single
import co.kr.nawa.mvvmsimple.util.common.logD

class Repository(private val retrofit: RetrofitHelper) {

    val api: ApiData = retrofit.getRetrofit().create(ApiData::class.java)


    fun <T>  getTojson(url:String,params: HashMap<String,Any>,classOfT:Class<T>): Single<ArrayList<T>> {
        return api.getToJosn(url,params).map { res:JsonElement ->  T

            var body=res.toString()

            var typeToken=TypeToken.getParameterized(ArrayList::class.java, classOfT).type

            var any:ArrayList<T> = Gson().fromJson(body,typeToken)

            return@map any
        }
    }



}