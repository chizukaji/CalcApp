package jp.techacademy.chizu.calcapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
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


        val intent = Intent(this, SecondActivity::class.java)

        val button = when(v.id){
            R.id.button1 -> 1
            R.id.button2 -> 2
            R.id.button3 -> 3
            else -> 4
        }

        if (button == 4){
            val mySnackbar = Snackbar.make(view , "Message", Snackbar.LENGTH_LONG)
            mySnackbar.show()
        }

        val Value1 = editText1
        val Value2 = editText2

        intent.putExtra("BUTTON", button.toString())
        intent.putExtra("VALUE1", Value1.text.toString())
        intent.putExtra("VALUE2", Value2.text.toString())

        startActivity(intent)
    }
}
