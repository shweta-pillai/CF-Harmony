package com.example.cf_harmony

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    private lateinit var edtPateintid: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        edtPateintid = findViewById(R.id.edt_patientid)
        edtPassword = findViewById(R.id.edt_password)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener(){
            val patientid = edtPateintid.text.toString()
            val password = edtPassword.text.toString()

            login(patientid, password);
        }
    }


    private fun login(patientid: String, password: String) {
        mAuth.signInWithEmailAndPassword(patientid, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful){
                    val intent = Intent(this@Login, MainActivity::class.java)
                    finish()
                    startActivity(intent)

                }else{
                    Toast.makeText(this@Login, "User not found", Toast.LENGTH_SHORT).show()
                }
            }
    }

}





