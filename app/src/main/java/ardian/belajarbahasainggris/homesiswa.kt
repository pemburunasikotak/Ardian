package ardian.belajarbahasainggris

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ardian.belajarbahasainggris.detailmateri.BelajarDenganSuaraAngka
import kotlinx.android.synthetic.main.activity_homesiswa.btn_alfabet
import kotlinx.android.synthetic.main.activity_homesiswa.btn_animal
import kotlinx.android.synthetic.main.activity_homesiswa.btn_color
import kotlinx.android.synthetic.main.activity_homesiswa.btn_fruits
import kotlinx.android.synthetic.main.activity_homesiswa.btn_kuis
import kotlinx.android.synthetic.main.activity_homesiswa.tv_nama_siswa

class homesiswa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homesiswa)
        val bundle = intent.extras
        tv_nama_siswa.setText("Halo "+bundle!!.getString("nama"))

        btn_alfabet.setOnClickListener(){
            val bundel = Bundle()
            bundel.putString("nama", "Alfabet")
            val intent = Intent(this, BelajarDenganSuaraAngka::class.java)
            intent.putExtras(bundel)
            startActivity(intent)
        }
        btn_fruits.setOnClickListener(){
            val bundel = Bundle()
            bundel.putString("nama", "Fruits")
            val intent = Intent(this, BelajarDenganSuaraAngka::class.java)
            intent.putExtras(bundel)
            startActivity(intent)
        }
        btn_animal.setOnClickListener(){
            val bundel = Bundle()
            bundel.putString("nama", "Animal")
            val intent = Intent(this, BelajarDenganSuaraAngka::class.java)
            intent.putExtras(bundel)
            startActivity(intent)

        }
        btn_color.setOnClickListener(){
            val bundel = Bundle()
            bundel.putString("nama", "Color")
            val intent = Intent(this, BelajarDenganSuaraAngka::class.java)
            intent.putExtras(bundel)
            startActivity(intent)
        }
//        btn_angka.setOnClickListener(){
//            val bundel = Bundle()
//            bundel.putString("nama", "Angka")
//            val intent = Intent(this, BelajarDenganSuaraAngka::class.java)
//            intent.putExtras(bundel)
//            startActivity(intent)
//        }
        btn_kuis.setOnClickListener(){
            val bundel = Bundle()
            bundel.putString("nama", "Quiz")
            val intent = Intent(this, Quiz::class.java)
            intent.putExtras(bundel)
            startActivity(intent)
        }

    }
}