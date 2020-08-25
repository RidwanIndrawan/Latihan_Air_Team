package id.ridwan.latihanairteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ridwan.latihanairteam.viewModel.MessageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var messageViewModel : MessageViewModel
    private lateinit var messageAdapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messageAdapter = MessageAdapter()
        messageAdapter.notifyDataSetChanged()

        rv_messages.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_messages.setHasFixedSize(true)
        rv_messages.adapter = messageAdapter

        messageViewModel = ViewModelProvider(
            this, ViewModelProvider.NewInstanceFactory()
        ).get(MessageViewModel::class.java)

        messageViewModel.setMessage()

        messageViewModel.getMessage().observe(this, Observer { message ->
                messageAdapter.setMessage(message)
        })

        add_btn.setOnClickListener{
            val intent = Intent(this@MainActivity, AddMessage::class.java)
            startActivity(intent)
        }
    }
}
