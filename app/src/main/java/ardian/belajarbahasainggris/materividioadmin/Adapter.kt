package ardian.belajarbahasainggris.materividioadmin

import ardian.belajarbahasainggris.AddMateri
import ardian.belajarbahasainggris.DetailVidioMateri
import ardian.belajarbahasainggris.HomeAdmin
import ardian.belajarbahasainggris.R
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class Adapter (private val context: Context, private val list:List<Model>)
    : RecyclerView.Adapter<Adapter.HomePemesanHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.HomePemesanHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.list_materi_bahasa_inggris_admin, parent, false
        )
        return HomePemesanHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.HomePemesanHolder, position: Int) {
        val list = list[position]
        holder.tv_nama_materi.text = list.nama

        holder.lihat.setOnClickListener {
            val bundel = Bundle()
            bundel.putString("id", list.id)
            bundel.putString("nama", list.nama)
            bundel.putString("link", list.link)
            bundel.putString("materi", list.materi)
            val intent = Intent(context, DetailVidioMateri::class.java)
            intent.putExtras(bundel)
            context.startActivity(intent)
        }
        holder.btnHapus.setOnClickListener(){
            hapus(list.id)
        }
        holder.btnEdit.setOnClickListener(){
            val bundel = Bundle()
            bundel.putString("id", list.id)
            bundel.putString("nama", list.nama)
            bundel.putString("link", list.link)
            bundel.putString("materi", list.materi)
            val intent = Intent(context, AddMateri::class.java)
            intent.putExtras(bundel)
            context.startActivity(intent)
        }

    }
    private fun hapus(id:String) {
        val ref = FirebaseDatabase.getInstance().getReference("MateriBing").child(id)
        val Query: Query = ref
        Query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (appleSnapshot in dataSnapshot.children) {
                    appleSnapshot.ref.removeValue()
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e(ContentValues.TAG, "onCancelled", databaseError.toException())
            }
        })
        val intent = Intent(context, HomeAdmin::class.java)
        context.startActivity(intent)
    }

    override fun getItemCount(): Int = list.size

    inner class HomePemesanHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_nama_materi: TextView = view.findViewById(R.id.tv_nama_materi)
        val btnHapus: Button = view.findViewById(R.id.btn_hapus)
        val btnEdit: Button = view.findViewById(R.id.btn_edit)
        val lihat: Button = view.findViewById(R.id.btn_lihat)

    }
}