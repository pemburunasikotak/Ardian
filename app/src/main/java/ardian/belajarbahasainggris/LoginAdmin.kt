package ardian.belajarbahasainggris

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_login_admin.btn_masuk_layout_login
import kotlinx.android.synthetic.main.activity_login_admin.input_text_email_login
import kotlinx.android.synthetic.main.activity_login_admin.input_text_password_login

class LoginAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_admin)
        btn_masuk_layout_login.setOnClickListener(){
            login()
        }
    }

    private fun login() {
        if (input_text_email_login.text.toString().isEmpty()) {
            input_text_email_login.error = "Masukkan Email"
            input_text_email_login.requestFocus()
            return
        }
        if(input_text_password_login.text.toString().isEmpty()){
            input_text_password_login.error = "Masukkan password"
            input_text_password_login.requestFocus()
            return
        }
        if(input_text_password_login.text.toString().isNotEmpty()&& input_text_email_login.text.toString().isNotEmpty()){

            var query = FirebaseDatabase.getInstance().getReference("Admin").orderByChild("email").equalTo(input_text_email_login.text.toString())
            query.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (snap in snapshot.children) {
                            val x = snap.getValue(User::class.java)
//                            Log.e("test", Gson().toJson(x))
                            //Cek pAssword login
                            if (x!!.password.equals(input_text_password_login.text.toString().trim())) {
                                val intent = Intent(this@LoginAdmin, HomeAdmin::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this@LoginAdmin, "Password Salah, tidak sesuai dengan email/ user", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@LoginAdmin, "Email atau user tidak ditemukan", Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}