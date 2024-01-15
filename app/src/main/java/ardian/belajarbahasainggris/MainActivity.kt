package ardian.belajarbahasainggris

//import com.squareup.picasso.Picasso
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.btn_login_siswa

//import java.net.URL


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login_siswa.setOnClickListener {
            val intent = Intent(this, inputnamasiswa::class.java)
            startActivity(intent)
        }
//        btn_login_admin.setOnClickListener {
//            val intent = Intent(this, LoginAdmin::class.java)
//            startActivity(intent)
//        }

    }
}