package com.example.quizgame

import android.content.Intent
import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.quizgame.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var questions = listOf("За сутки синий кит поглощает 4 тонны корма"
        ,"Бриллианты и изумруды — это кристаллы"
        ,"Леопард и пантера — разные виды крупных кошек"
        ,"Роскошный хвост носят самцы и самки павлина"
        ,"Пингвины — перелетные птицы ",
    "Енисей — южноамериканская река",
    "Солнце — самая близкая к Земле звезда",
    "Вараны с острова Комодо — самые крупные ящерицы на планете",
    "Кабачок — это корнеплод" ,
    "Мать жены — это свекровь",
    "Бамбук — самая высокая и быстрорастущая трава",
    "Родина панды — Австралия",
    "Голландия и Нидерланды — одно и то же государство",
    "Робин Гуд раздавал деньги богатым",
    "Во Франции едят лягушачьи лапки",
    "Кровью питаются только самки комаров",
    "На поверхности Солнца температура достигает 6000°C",
    "Чтобы спастись от хищника, каракатица выбрасывает струю чернил",
    "Порох изобрели китайцы",
    "Юрта — жилище североамериканского индейца",
    "Белые медведи зимой укладываются в спячку",
    "Карп — искусственный вид, выведенный от сазана"
)
    var answers = listOf(1,1,0,0,0,0,1,1,0,0,1,0,1,0,1,1,1,1,1,0,0,1)
    var countQ = 0
    var countY=0
    var countN=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btAgain.setOnClickListener {
            var i2 = Intent(this,StartActivity::class.java)
            startActivity(i2)
        }
        binding.bYes.setOnClickListener {
            result(1)
            countQ++
            if (countQ < questions.size){
                game()
            } else {
                Toast.makeText(this,"Конец игры",Toast.LENGTH_SHORT).show()
            }
            game()
        }
        binding.bNo.setOnClickListener {
            result(0)
        countQ++
        if (countQ < questions.size){
            game()
        } else {
            Toast.makeText(this,"Конец игры",Toast.LENGTH_SHORT).show()
        }
            game()
        }

        game()
    }


    fun result(r:Int) {
        if (answers[countQ] == r) {
            countY++
            binding.tvOkNo.setTextColor(Color.parseColor("#FF1FF407"))
            binding.tvOkNo.text = "Правильно"
        } else {
            countN++
            binding.tvOkNo.setTextColor(Color.parseColor("#FFEC0505"))
            binding.tvOkNo.text = "Ошибка"
        }
        binding.tvRes.text = "Правильных ответов: $countY \n Ошибок: $countN"
    }

    fun game(){
            if (countQ<questions.size){
                binding.textView.text = questions[countQ]
            }
        }

}