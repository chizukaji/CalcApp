package jp.techacademy.chizu.calcapp.intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import jp.techacademy.chizu.calcapp.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val button = intent.getStringExtra("BUTTON")

        val atai1 = intent.getStringExtra("VALUE1").toDouble()
        val atai2 = intent.getStringExtra("VALUE2").toDouble()

        val kotae = when(button) {
            1.toString() -> atai1 + atai2
            2.toString() -> atai1 - atai2
            3.toString() -> atai1 * atai2
            else -> atai1 / atai2
        }

        textView.text = kotae.toString()
    }
}
