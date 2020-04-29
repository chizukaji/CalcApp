package jp.techacademy.chizu.calcapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import jp.techacademy.chizu.calcapp.intent.SecondActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View){

        if(editText1.text.toString() == "" || editText2.text.toString() == ""){
            val mySnackbar = Snackbar.make(v , "数字を2つ入力してください。", Snackbar.LENGTH_LONG)
            mySnackbar.show()} else {

            val intent = Intent(this, SecondActivity::class.java)

            val button = when (v.id) {
                R.id.button1 -> 1
                R.id.button2 -> 2
                R.id.button3 -> 3
                else -> 4
            }

            if (button == 4.toInt()) {

                if (editText2.text.toString() == 0.toString()) {
                    val mySnackbar = Snackbar.make(v, "0で割ることはできません。", Snackbar.LENGTH_LONG)
                    mySnackbar.show()
                } else {

                    intent.putExtra("BUTTON", button.toString())
                    intent.putExtra("VALUE1", editText1.text.toString())
                    intent.putExtra("VALUE2", editText2.text.toString())

                    startActivity(intent)
                }

            } else {

                intent.putExtra("BUTTON", button.toString())
                intent.putExtra("VALUE1", editText1.text.toString())
                intent.putExtra("VALUE2", editText2.text.toString())

                startActivity(intent)

            }
        }
    }
}
