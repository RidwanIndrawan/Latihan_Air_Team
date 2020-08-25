package id.ridwan.latihanairteam.configuration

import id.ridwan.latihanairteam.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigAPI {
    private fun doRequest():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun instance():QueryBackend {
        return doRequest().create(QueryBackend::class.java)
    }
}