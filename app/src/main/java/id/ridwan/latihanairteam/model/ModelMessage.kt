package id.ridwan.latihanairteam.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelMessage (
    @SerializedName("message")
    var message:String?=null,
    @SerializedName("priority")
    var priority:Int?=null
) :Parcelable