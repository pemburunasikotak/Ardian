package ardian.belajarbahasainggris

import ardian.belajarbahasainggris.materividioadmin.Model
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_materi.*


class AddMateri : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var ref : DatabaseReference
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_materi)
        ref = FirebaseDatabase.getInstance().getReference("MateriBing")

        val bundle = intent.extras
        et_nama.setText((bundle?.getString("nama")))
        et_id.setText((bundle?.getString("id")))
        et_addlink.setText((bundle?.getString("link")))
        et_addpenjelasan.setText((bundle?.getString("materi")))
        et_link_gambar.setText((bundle?.getString("gambar")))
        btn_batal.setOnClickListener(){

        }
        btn_simpan.setOnClickListener(){
            var id = ""
            if (et_nama.text.toString().isEmpty()) {
                et_nama.error = "Masukkan Nama"
                et_nama.requestFocus()
            }
            if (et_addlink.text.toString().isEmpty()) {
                et_addlink.error = "Masukkan Nama"
                et_addlink.requestFocus()
            }
            if (et_link_gambar.text.toString().isEmpty()) {
                et_link_gambar.error = "Masukan Nama"
                et_link_gambar.requestFocus()
            }
            if (et_addpenjelasan.text.toString().isEmpty()) {
                et_addpenjelasan.error = "Masukkan Nama"
                et_addpenjelasan.requestFocus()
            }
            if(et_nama.text.toString().isNotEmpty() && et_addlink.text.toString().isNotEmpty() && et_addpenjelasan.text.toString().isNotEmpty() && et_link_gambar.text.toString().isEmpty()){
                if (et_id.text.toString().isNotEmpty()) {
                    id =et_id.text.toString().trim();
                } else {
                    id = ref.push().key.toString()
                }
                val nama = et_nama.text.toString().trim();
                val link = et_addlink.text.toString().trim()
                val penjelasan = et_addpenjelasan.text.toString().trim();
                val gambar = et_link_gambar.text.toString().trim();

                val event = Model(id,nama,link, penjelasan, gambar)
                ref.child(id).setValue(event).addOnCompleteListener {
                    Toast.makeText(this, "Sukses", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, HomeAdmin::class.java)
                    startActivity(intent)
                }

            }
        }
    }
}