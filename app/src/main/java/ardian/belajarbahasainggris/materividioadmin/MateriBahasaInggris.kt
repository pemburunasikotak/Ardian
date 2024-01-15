package ardian.belajarbahasainggris.materividioadmin

import ardian.belajarbahasainggris.R
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.gson.Gson


class MateriBahasaInggris : AppCompatActivity() {
    private var list : MutableList<Model> = ArrayList()
    private lateinit var rvData: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi_bahasa_inggris)

        rvData = findViewById(R.id.rv_materi_bing)
        rvData.setHasFixedSize(true)
//        Log.e("Halo Test Materi",rvData.toString())
        fungsiRecyleView()

    }
    private fun fungsiRecyleView() {
        val listadapter = Adapter(this,list)
        rvData.adapter = listadapter
        rvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //deklarasi untuk Database
        var myRef = FirebaseDatabase.getInstance().getReference("MateriBing")
        //isi data di RV
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (snap in snapshot.children) {
                    val x = snap.getValue(Model::class.java)
                    Log.e("TEST", Gson().toJson(x))
                    list.add(x!!)
                    listadapter.notifyDataSetChanged()
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MateriBahasaInggris, "Terjai kesalahan ketika inisialisasi database", Toast.LENGTH_SHORT).show()
            }
        })

    }

}