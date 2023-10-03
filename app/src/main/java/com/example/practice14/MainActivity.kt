package com.example.practice14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nameText: EditText = findViewById(R.id.editTextText)
        val ageText: EditText = findViewById(R.id.editTextNumber)
        val emailText: EditText = findViewById(R.id.editTextTextEmailAddress)

        val tv1:TextView = findViewById(R.id.textView5)
        val tv2:TextView = findViewById(R.id.textView6)
        val tv3:TextView = findViewById(R.id.textView7)

        val arguments: Bundle? = intent.extras

        if (arguments != null){
            val name: String = arguments.getString("name").toString()
            val email: String? = arguments.getString("email").toString()
            val age: Int = arguments.getInt("age")
            nameText.setText("$name")
            ageText.setText("$age")
            emailText.setText("$email")
            tv1.text = "*"
            tv2.text = "*"
            tv3.text = "*"

        }

    }

    fun btnSendClick(view: View){
        val nameText: EditText = findViewById(R.id.editTextText)
        val ageText: EditText = findViewById(R.id.editTextNumber)
        val emailText: EditText = findViewById(R.id.editTextTextEmailAddress)

        if(emailText!!.text.toString() == "" && ageText!!.text.toString() == "" && nameText!!.text.toString() == ""){
            Toast.makeText(this, "Введите данные!", Toast.LENGTH_SHORT).show()
            ageText.requestFocus()
        }
        else if(emailText!!.text.toString() == ""){
            Toast.makeText(this, "Введите email!", Toast.LENGTH_SHORT).show()
            emailText.requestFocus()
        }
        else if (ageText!!.text.toString() == ""){
            Toast.makeText(this, "Введите возраст!", Toast.LENGTH_SHORT).show()
            ageText.requestFocus()
        }

        else if (nameText!!.text.toString() == "") {
            Toast.makeText(this, "Введите имя!", Toast.LENGTH_SHORT).show()
            nameText.requestFocus()
        }

        else {
            val name = nameText.text.toString()
            val age = ageText.text.toString().toInt()
            val email = emailText.text.toString()

            val intent: Intent = Intent(this@MainActivity, MainActivity2::class.java)

            intent.putExtra("name", name)
            intent.putExtra("age", age)
            intent.putExtra("email", email)

            startActivity(intent)
        }
    }

}