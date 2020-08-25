package id.ridwan.latihanairteam.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ridwan.latihanairteam.BuildConfig
import id.ridwan.latihanairteam.configuration.ConfigAPI
import id.ridwan.latihanairteam.model.ModelMessage
import retrofit2.Call
import retrofit2.Response

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class EditMassageViewModel : ViewModel() {

    private val messages = MutableLiveData<ArrayList<ModelMessage>>()

    fun updateMessage(message: String){
        ConfigAPI().instance().putMessage(BuildConfig.token, message)
            .enqueue(object :retrofit2.Callback<ModelMessage>{
                override fun onFailure(call: Call<ModelMessage>, t: Throwable) {
                    Log.d("Failed",t.message)
                    messages.postValue(null)
                }

                override fun onResponse(
                    call: Call<ModelMessage>,
                    response: Response<ModelMessage>
                ) {
//                    val message = response.body()?.message
//                    messages.postValue(message)
                }

            })
    }
}


