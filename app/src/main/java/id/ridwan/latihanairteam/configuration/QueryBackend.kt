package id.ridwan.latihanairteam.configuration

import id.ridwan.latihanairteam.model.ModelListMessage
import id.ridwan.latihanairteam.model.ModelMessage
import retrofit2.Call
import retrofit2.http.*

interface QueryBackend {

    @GET("/api/message")
    fun getMessage(
        @Query("token") token : String
    ) : Call<ModelListMessage>

    @POST("/api/message")
    fun postMessage(
        @Query("token") token: String,
        @Query("message") message: String
    ) : Call<ModelMessage>

    @PUT("/api/message")
    fun putMessage(
        @Query("token") token: String,
        @Query("message") message :String
    ) : Call<ModelMessage>

    @DELETE("/api/message")
    fun delMessage(
        @Query("token") token:String,
        @Query("message") message:String
    ) : Call<ModelMessage>
}