package ardian.belajarbahasainggris

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_inputnamasiswa.btn_enter
import kotlinx.android.synthetic.main.activity_inputnamasiswa.editTextTextPersonName

//import kotlinx.android.synthetic.main.activity_inputnamasiswa.*

class inputnamasiswa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inputnamasiswa)

//        editTextTextPersonName

        btn_enter.setOnClickListener {
            if(editTextTextPersonName.text.toString().isEmpty()){
                Toast.makeText(applicationContext, "Please input your name",Toast.LENGTH_LONG).show()
            }else {
                val bundle = Bundle()
                bundle.putString("nama",editTextTextPersonName.text.toString());
                val intent = Intent(this,homesiswa::class.java )
                intent.putExtras(bundle)
                startActivity(intent)
//                val bundle = Bundle()
//                bundle.putString("nama",tv_nama_siswa2.text.toString());
//                val intent = Intent(this, homesiswa::class.java )
//                intent.putExtras(bundle)
//                startActivity(intent)
            }
        }

    }
}