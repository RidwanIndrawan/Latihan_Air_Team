package id.ridwan.latihanairteam.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ridwan.latihanairteam.BuildConfig
import id.ridwan.latihanairteam.configuration.ConfigAPI
import id.ridwan.latihanairteam.model.ModelListMessage
import id.ridwan.latihanairteam.model.ModelMessage
import retrofit2.Call
import retrofit2.Response

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MessageViewModel : ViewModel(){

    private val messages = MutableLiveData<ArrayList<ModelMessage>>()

    fun setMessage(){
        ConfigAPI().instance().getMessage(BuildConfig.token)
            .enqueue(object : retrofit2.Callback<ModelListMessage>{
                override fun onFailure(call: Call<ModelListMessage>, t: Throwable) {
                    Log.d("Failed",t.message)
                    messages.postValue(null)
                }

                override fun onResponse(
                    call: Call<ModelListMessage>,
                    response: Response<ModelListMessage>
                ) {
                    val listMessage = response.body()?.dataMessage
                    messages.postValue(listMessage)
                }
            })
    }

    fun getMessage(): LiveData<ArrayList<ModelMessage>>{
        return messages
    }

    fun messageSize(): Int?{
        return this.messages.value?.size
    }
}