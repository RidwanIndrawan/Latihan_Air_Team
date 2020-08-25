package id.ridwan.latihanairteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class EditMassage : AppCompatActivity() {

    companion object{
        const val KEY = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_massage)
    }
}
