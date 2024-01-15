
package ardian.belajarbahasainggris

import ardian.belajarbahasainggris.detailmateri.BelajarDenganSuaraAngka
import ardian.belajarbahasainggris.materividioadmin.MateriBahasaInggris
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home_admin.*

class HomeAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_admin)
        btn_angka.setOnClickListener(){
            val bundel = Bundle()
            bundel.putString("nama", "Angka")
            val intent = Intent(this, BelajarDenganSuaraAngka::class.java)
            intent.putExtras(bundel)
            startActivity(intent)
        }
        btn_benda.setOnClickListener(){
//            Toast.makeText(applicationContext,"angka", Toast.LENGTH_LONG)
            val bundel = Bundle()
            bundel.putString("nama", "Benda")
            val intent = Intent(this, BelajarDenganSuaraAngka::class.java)
            intent.putExtras(bundel)
            startActivity(intent)
        }
        btn_buah.setOnClickListener(){
//            Toast.makeText(applicationContext,"angka", Toast.LENGTH_LONG)
            val bundel = Bundle()
            bundel.putString("nama", "Buah")
            val intent = Intent(this, BelajarDenganSuaraAngka::class.java)
            intent.putExtras(bundel)
            startActivity(intent)
        }
        btn_hari.setOnClickListener(){
            val bundel = Bundle()
            bundel.putString("nama", "Hari")
            val intent = Intent(this, BelajarDenganSuaraAngka::class.java)
            intent.putExtras(bundel)
            startActivity(intent)
        }
        btn_hewan.setOnClickListener(){
            val bundel = Bundle()
            bundel.putString("nama", "Hewan")
            val intent = Intent(this, BelajarDenganSuaraAngka::class.java)
            intent.putExtras(bundel)
            startActivity(intent)
        }
        btn_transportasi.setOnClickListener(){
            val bundel = Bundle()
            bundel.putString("nama", "Transportasi")
            val intent = Intent(this, BelajarDenganSuaraAngka::class.java)
            intent.putExtras(bundel)
            startActivity(intent)

        }
        btn_anggota_tubuh.setOnClickListener(){
            val bundel = Bundle()
            bundel.putString("nama", "AnggotaTubuh")
            val intent = Intent(this, BelajarDenganSuaraAngka::class.java)
            intent.putExtras(bundel)
            startActivity(intent)
        }
        btn_sayuran.setOnClickListener(){
            val bundel = Bundle()
            bundel.putString("nama", "Sayuran")
            val intent = Intent(this, BelajarDenganSuaraAngka::class.java)
            intent.putExtras(bundel)
            startActivity(intent)
        }
        btn_bulan.setOnClickListener(){
            val bundel = Bundle()
            bundel.putString("nama", "Bulan")
            val intent = Intent(this, BelajarDenganSuaraAngka::class.java)
            intent.putExtras(bundel)
            startActivity(intent)

        }
        btn_learnwithvidio1.setOnClickListener(){
            val intent = Intent (this, MateriBahasaInggris::class.java)
            startActivity(intent)
        }
        btn_tambah_data.setOnClickListener(){
            val intent = Intent(this, AddMateri::class.java)
            startActivity(intent)
        }

    }
}