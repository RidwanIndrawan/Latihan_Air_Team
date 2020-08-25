package id.ridwan.latihanairteam

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ridwan.latihanairteam.model.ModelMessage
import kotlinx.android.synthetic.main.item_message.view.*

class MessageAdapter : RecyclerView.Adapter<MessageAdapter.ListViewHolder>() {

    private val listMessage = ArrayList<ModelMessage>()

    fun setMessage(messages : ArrayList<ModelMessage>){
        listMessage.clear()
        listMessage.addAll(messages)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMessage.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMessage[position])
    }

    inner class ListViewHolder (itemView:View) : RecyclerView.ViewHolder(itemView){
        fun bind(dataMessage:ModelMessage){
            itemView.text_message.text = dataMessage.message
            itemView.text_priority.text = dataMessage.priority.toString()

            itemView.setOnClickListener(
                CustomOnItemClickListener( adapterPosition, object : CustomOnItemClickListener.OnItemClickCallback{
                    override fun onItemClicked(view: View, position: Int) {
                        val intent = Intent (itemView.context, EditMassage::class.java)

                        intent.putExtra(EditMassage.KEY,dataMessage)
                        itemView.context.startActivity(intent)
                    }
                }
            )
            )
        }
    }
}