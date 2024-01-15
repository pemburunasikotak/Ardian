package ardian.belajarbahasainggris.detailmateri

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import ardian.belajarbahasainggris.R
import kotlinx.android.synthetic.main.activity_belajar_dengan_suara.belajardengansuara
import kotlinx.android.synthetic.main.activity_belajar_dengan_suara.rv_materi_suara

class BelajarDenganSuaraAngka : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_belajar_dengan_suara)

        val bundle = intent.extras
        val data = bundle?.getString("nama")
        belajardengansuara.setText("Learn"+data)
        Log.e("TestData",data.toString().trim())

        if(data.equals("Angka")){
            val model = ArrayList<model>()
            model.add(model("1","one", R.drawable.angka1,R.raw.one))
            model.add(model("2","two", R.drawable.angka2,R.raw.two))
            model.add(model("3","three", R.drawable.angka3,R.raw.three))
            model.add(model("4","four", R.drawable.angka4,R.raw.four))
            model.add(model("5","five", R.drawable.angka5,R.raw.five))
            model.add(model("6","six", R.drawable.angka6,R.raw.six))
            model.add(model("7","seven", R.drawable.angka7,R.raw.seven))
            model.add(model("8","eight", R.drawable.angka8,R.raw.eight))
            model.add(model("9","nine", R.drawable.angka9,R.raw.nine))
            rv_materi_suara.layoutManager= GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false)
            rv_materi_suara.adapter= adapter(this, model, { model -> personItemClicked(model as model)  })
        }else if (data == "Alfabet"){
            val model = ArrayList<model>()
            model.add(model("1","A", R.drawable.alfabet_a, R.raw.alfabet_a ))
            model.add(model("2","B", R.drawable.alfabet_b, R.raw.alfabet_b ))
            model.add(model("3","C", R.drawable.alfabet_c, R.raw.alfabet_c ))
            model.add(model("4","D", R.drawable.alfabet_d, R.raw.alfabet_d ))
            model.add(model("5","E", R.drawable.alfabet_e, R.raw.alfabet_e ))
            model.add(model("6","F", R.drawable.alfabet_f, R.raw.alfabet_f ))
            model.add(model("7","G", R.drawable.alfabet_g, R.raw.alfabet_g ))
            model.add(model("8","H", R.drawable.alfabet_h, R.raw.alfabet_h ))
            model.add(model("9","I", R.drawable.alfabet_i, R.raw.alfabet_i ))
            model.add(model("10","J", R.drawable.alfabet_j, R.raw.alfabet_j ))
            model.add(model("11","K", R.drawable.alfabet_k, R.raw.alfabet_k ))
            model.add(model("12","L", R.drawable.alfabet_l, R.raw.alfabet_l ))
            model.add(model("13","M", R.drawable.alfabet_m, R.raw.alfabet_m ))
            model.add(model("14","N", R.drawable.alfabet_n, R.raw.alfabet_n ))
            model.add(model("15","O", R.drawable.alfabet_o, R.raw.alfabet_o ))
            model.add(model("16","P", R.drawable.alfabet_p, R.raw.alfabet_p ))
            model.add(model("17","Q", R.drawable.alfabet_q, R.raw.alfabet_q ))
            model.add(model("18","R", R.drawable.alfabet_r, R.raw.alfabet_e ))
            model.add(model("19","S", R.drawable.alfabet_s, R.raw.alfabet_s ))
            model.add(model("20","T", R.drawable.alfabet_t, R.raw.alfabet_t ))
            model.add(model("21","U", R.drawable.alfabet_u, R.raw.alfabet_u ))
            model.add(model("22","V", R.drawable.alfabet_v, R.raw.alfabet_v ))
            model.add(model("23","W", R.drawable.alfabet_w, R.raw.alfabet_w ))
            model.add(model("24","X", R.drawable.alfabet_x, R.raw.alfabet_x ))
            model.add(model("25","Y", R.drawable.alfabet_y, R.raw.alfabet_y ))
            model.add(model("26","Z", R.drawable.alfabet_z, R.raw.alfabet_z ))
            rv_materi_suara.layoutManager= GridLayoutManager(this,3,GridLayoutManager.VERTICAL, false)
            rv_materi_suara.adapter= adapter(this, model, { model -> personItemClicked(model as model)  })
        }else if (data == "Animal"){
            val model = ArrayList<model>()
            model.add(model("1","Ant", R.drawable.animal_ant, R.raw.animal_ant ))
            model.add(model("2","Bear", R.drawable.animal_bear, R.raw.animal_bear ))
            model.add(model("3","Cat", R.drawable.animal_cat, R.raw.animal_cat ))
            model.add(model("4","Duck", R.drawable.animal_duck, R.raw.animal_duck ))
            model.add(model("5","Eagle", R.drawable.animal_eagle, R.raw.animal_eagle ))
            model.add(model("6","Fish", R.drawable.animal_fish, R.raw.animal_fish ))
            model.add(model("7","Goat", R.drawable.animal_goat, R.raw.animal_goat ))
            model.add(model("8","Horse", R.drawable.animal_horse, R.raw.horse ))
            model.add(model("9","Iguana", R.drawable.animal_iguana, R.raw.animal_iguana ))
            model.add(model("10","Jaguar", R.drawable.animal_jaguar, R.raw.animal_jaguar ))
            model.add(model("11","Kangoroo", R.drawable.animal_kangoroo, R.raw.animal_kangoroo ))
            model.add(model("12","Lion", R.drawable.animal_lion, R.raw.animal_lion ))
            model.add(model("13","Mouse", R.drawable.animal_mouse, R.raw.animal_mouse ))
            model.add(model("14","Newt", R.drawable.animal_newt, R.raw.animal_newt ))
            model.add(model("15","OrangUtan", R.drawable.animal_orangutan, R.raw.animal_orangutan ))
            model.add(model("16","Parrot", R.drawable.animal_parrot, R.raw.animal_parrot ))
            model.add(model("17","Rabbit", R.drawable.animal_rabbit, R.raw.animal_rabbit ))
            model.add(model("18","Snake", R.drawable.animal_snake, R.raw.animal_snake ))
            model.add(model("19","Tiger", R.drawable.animal_tiger, R.raw.animal_tiger ))
            model.add(model("20","Whale", R.drawable.animal_whale, R.raw.animal_whale ))
            model.add(model("21","Yak", R.drawable.animal_yak, R.raw.animal_yak ))
            model.add(model("22","Zebra", R.drawable.animal_zebra, R.raw.animal_zebra ))
            rv_materi_suara.layoutManager= GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false)
            rv_materi_suara.adapter= adapter(this, model, { model -> personItemClicked(model as model)  })
        }else if(data == "Fruits"){
            val model = ArrayList<model>()
            model.add(model("1","Banana", R.drawable.fruit_banana, R.raw.fruits_banana))
            model.add(model("2","Coconut", R.drawable.fruit_coconut, R.raw.fruits_coconut))
            model.add(model("3","Durian", R.drawable.fruit_durian, R.raw.fruits_durian))
            model.add(model("4","Apple", R.drawable.fruit_fruit_apple, R.raw.fruits_apple))
            model.add(model("5","Grape", R.drawable.fruit_grape, R.raw.fruits_grape))
            model.add(model("6","JackFruit", R.drawable.fruit_jackfruit, R.raw.fruits_jackfruit))
            model.add(model("7","Kiwi", R.drawable.fruit_kiwi, R.raw.fruits_kiwi))
            model.add(model("8","Lemon", R.drawable.fruit_lemon, R.raw.fruits_lemon))
            model.add(model("9","Manggo", R.drawable.fruit_mango, R.raw.fruits_mango))
            model.add(model("10","Orange", R.drawable.fruit_orange, R.raw.fruits_orange))
            model.add(model("11","Papaya", R.drawable.fruit_papaya, R.raw.fruits_papaya))
            model.add(model("12","Rambutan", R.drawable.fruit_rambutan, R.raw.fruits_rambutan))
            model.add(model("13","StartFruit", R.drawable.fruit_starfruit, R.raw.fruits_starfruit))
            model.add(model("13","WaterMelon", R.drawable.fruit_watermelon, R.raw.fruits_watermelon))
            rv_materi_suara.layoutManager= GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false)
            rv_materi_suara.adapter= adapter(this, model, { model -> personItemClicked(model as model)  })
        }else if (data == "Color"){
            val model = ArrayList<model>()
            model.add(model("1", "Yellow", R.drawable.yellow, R.raw.fruits_watermelon))
            model.add(model("2", "Black", R.drawable.black, R.raw.fruits_watermelon ))
            model.add(model("3", "Blue", R.drawable.blue, R.raw.fruits_watermelon ))
            model.add(model("4", "Green", R.drawable.green, R.raw.fruits_watermelon ))
            model.add(model("5", "White", R.drawable.white, R.raw.fruits_watermelon))
            model.add(model("6", "Purple", R.drawable.purple, R.raw.fruits_watermelon))
            model.add(model("7", "Pink", R.drawable.pink, R.raw.fruits_watermelon))
            model.add(model("8", "Orange", R.drawable.orange, R.raw.fruits_watermelon ))
            model.add(model("9", "Red", R.drawable.red, R.raw.fruits_watermelon))
            model.add(model("10", "Brown", R.drawable.brown, R.raw.fruits_watermelon))
            model.add(model("11", "Gray", R.drawable.gray, R.raw.fruits_watermelon ))
            rv_materi_suara.layoutManager= GridLayoutManager(this,3,GridLayoutManager.VERTICAL, false)
            rv_materi_suara.adapter= adapter(this, model, { model -> personItemClicked(model as model)  })
        }else if (data =="Quiz") {
            val model = ArrayList<model>()
            model.add(model("1", "Alphabet", R.drawable.logoalphabet, R.raw.fruits_watermelon))
            model.add(model("2", "Animal", R.drawable.logoanimals, R.raw.fruits_watermelon))
            model.add(model("3", "Color", R.drawable.logocolors, R.raw.fruits_watermelon))
            model.add(model("4", "Fruits", R.drawable.logofruits, R.raw.fruits_watermelon))
            rv_materi_suara.layoutManager= GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false)
            rv_materi_suara.adapter= adapter(this, model,{})
        }
    }
    private fun personItemClicked(person: model) {
        Toast.makeText(applicationContext,person.nama, Toast.LENGTH_SHORT)
    }
}