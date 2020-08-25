package id.ridwan.latihanairteam.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelListMessage (
    @SerializedName ("results")
    var dataMessage : ArrayList<ModelMessage>?
) :Parcelable