package com.examples.dtpckase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dtpckase.databinding.ActivityLoginBinding
import com.examples.dtpckase.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class LoginActivity : AppCompatActivity() {
    private var userName:String?= null
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
//private lateinit var GoogleSingInClient : GoogleSignInClient

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Initialization of Firebase auth
        auth = Firebase.auth
        //Initialization of Firebase Database
        database = Firebase.database.reference

         //login with email and password
        binding.loginButton.setOnClickListener {

            //get data from text field

            email = binding.emailAddress.text.toString().trim()
            password = binding.password.text.toString().trim()

            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Por favor completa todos los detalles 👆", Toast.LENGTH_SHORT).show()
            }else{
                createUser()
                Toast.makeText(this, "Login Exitoso", Toast.LENGTH_SHORT).show()
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.notienescuentatxt.setOnClickListener {
            val intent = Intent(this, SignActivity::class.java)
            startActivity(intent)
        }



    }
//

    private fun createUser() {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task->
            if(task.isSuccessful){
                val user = auth.currentUser
                updateUi(user)
            }else {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task->
                    if(task.isSuccessful){
                        saveUserdata()
                        val user = auth.currentUser
                        updateUi(user)
                    }else{
                        Toast.makeText(this, "Sign-in field", Toast.LENGTH_SHORT).show()

                    }
                }

            }
        }

        }

    private fun saveUserdata() {
        //get data from text field

        email = binding.emailAddress.text.toString().trim()
        password = binding.password.text.toString().trim()

        val user = UserModel(userName,email, password)
        val userId = FirebaseAuth.getInstance().currentUser!!.uid


        //save data in to database
        database.child("user").child(userId).child(userId).setValue(user)




    }
    override fun onStart(){
    super.onStart()
    val currentUser = auth.currentUser
    if(currentUser != null) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
          }
    }

    private fun updateUi(user: FirebaseUser?) {
       val intent = Intent (this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}


