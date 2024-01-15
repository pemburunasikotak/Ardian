package ardian.belajarbahasainggris

import ardian.belajarbahasainggris.materividio.MateriBahasaInggris
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_materi_dan_suara.*

class MateriDanSuara : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi_dan_suara)
        val bundle = intent.extras
        tv_nama_siswa2.setText(bundle!!.getString("nama"))

        btn_Vidio.setOnClickListener(){
            val intent = Intent(this, MateriBahasaInggris::class.java)
            startActivity(intent)
        }
        btn_Suara.setOnClickListener(){
            val bundle = Bundle()
            bundle.putString("nama",tv_nama_siswa2.text.toString());
            val intent = Intent(this, homesiswa::class.java )
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}