package ardian.belajarbahasainggris.detailmateri

import android.content.Context
import android.media.MediaPlayer
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ardian.belajarbahasainggris.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_belajar_suara.view.gambar
import kotlinx.android.synthetic.main.list_belajar_suara.view.text_name_list

class adapter (private val context: Context, val items: List<model>
               , val clickListener: (model) -> Unit)
    : RecyclerView.Adapter<adapter.holder>(){

    private  var mp:MediaPlayer?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapter.holder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.list_belajar_suara, parent, false
        )
        return holder(view)
    }

    override fun onBindViewHolder(holder: adapter.holder, position: Int) {
        holder.bind(items[position],clickListener)

    }

    override fun getItemCount():Int {
        return  items.size
    }


    inner class holder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: model, clickListener: (model) -> Unit){
            Picasso.get()
                .load(model.gambar)
               // .resize(200,200)
              //  .centerCrop()
                .centerInside()
                .fit()
                .into(itemView.gambar);
            itemView.gambar.setOnClickListener() {
                reset()
                controlsuara(id = model.suara)
//                Log.e("TestModel",model.nama+ model.suara)
                Toast.makeText(context,model.nama,Toast.LENGTH_LONG).show()
            }
            itemView.text_name_list.setText(model.nama)
        }
        private fun controlsuara(id : Int) {
            if (mp==null){
                mp = MediaPlayer.create(context, id)
                initialiseSeekBar()
            }
            mp?.start()

        }
        private fun reset(){
            mp?.stop()
            mp?.reset()
            mp?.release()
            mp = null
        }
        private fun initialiseSeekBar(){
//            seekbar.max = mp!!.duration
            val handler = Handler()
            handler.postDelayed(object : Runnable{
                override fun run(){
                    try {
//                        seekbar.progress = mp!!.currentPosition
                        handler.postDelayed(this, 1000)
                    }catch (e: Exception){
//                        seekbar.progress = 0
                    }

                }
            },0)
        }

    }
}