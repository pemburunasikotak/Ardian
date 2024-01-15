package ardian.belajarbahasainggris.materividio

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ardian.belajarbahasainggris.DetailVidioMateri
import ardian.belajarbahasainggris.R
import com.squareup.picasso.Picasso

class Adapter (private val context: Context, private val list:List<Model>)
    : RecyclerView.Adapter<Adapter.HomePemesanHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.HomePemesanHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.list_materi_bahasa_inggris, parent, false
        )
        return HomePemesanHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.HomePemesanHolder, position: Int) {
        val list = list[position]


        holder.itemView.setOnClickListener {
            val bundel = Bundle()
            bundel.putString("id", list.id)
            bundel.putString("nama", list.nama)
            bundel.putString("link", list.link)
            bundel.putString("gambar", list.gambar)
            bundel.putString("materi", list.materi)
            val intent = Intent(context, DetailVidioMateri::class.java)
            intent.putExtras(bundel)
            context.startActivity(intent)
        }
//        if (list.id == "1"){
//            val red: Int = Color.parseColor("#FF0000")
//            holder.linerGambar.setBackgroundColor(red)
//        }
        Picasso.get()
            .load(list.gambar)
            .centerCrop()
            .fit()
            .into(holder.imageRest);
        holder.tv_name.text = list.nama
//        Picasso.get()
//            .load(list.gambar)
//            .centerCrop()
//            .into(holder.linerGambar);
    }

    override fun getItemCount(): Int = list.size

    inner class HomePemesanHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_name: TextView = view.findViewById(R.id.tv_nyanyian)
        val linerGambar : LinearLayout = view.findViewById(R.id.linerGambar);
        val imageRest: ImageView = view.findViewById(R.id.imageRest)
    }
}