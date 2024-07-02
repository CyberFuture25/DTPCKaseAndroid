package com.examples.dtpckase

//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.dtpckase.databinding.ActivitySignBinding
import com.examples.dtpckase.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignActivity : AppCompatActivity() {

    private lateinit var email:String
    private lateinit var password:String
    private lateinit var username:String
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    //val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//    .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()
//    private lateinit var googleSignInClient: GoogleSignInCliente

    private val binding : ActivitySignBinding by lazy {
        ActivitySignBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        //Initialize Firebase auth
        auth = Firebase.auth
        //Initialize Firebase Database
        database = Firebase.database.reference

        //Initialize Firebase auth
//        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)


        binding.createAccountButton.setOnClickListener {
            username = binding.userName.text.toString()
            email = binding.emailAddress.text.toString().trim()
            password = binding.password.text.toString().trim()
            
            if(email.isEmpty() || password.isEmpty()||username.isBlank()){
                Toast.makeText(this,"Complete todos los detalles", Toast.LENGTH_SHORT).show()
                
            }else{
                createAccount(email,password)
            }
            
        }
        binding.registrotxt.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
//        binding.googleButton.setOnClickListener {
//            val sigIntent = googleSignInClient.signInIntent
//             launcher.launch(signIntent)
//        }

        }
    //launcher gor google sign in
//    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->
//        if(result.resultCode == Activity.RESULT_OK){
//            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//            if(task.isSuccessful){
//                val account:GoogleSignInAccount? = task.result
//                val credential = GoogleAuthProvider.getCredential(account?.idtoken,null)
//                auth.signInWithCredential(credential).addOnCompleteListener { task->
//                    if(task.isSuccessful){
//                        startActivity(Intent(this, MainActivity::class.java))
//                        finish()
//                    }else{
//                        Toast.makeText(this,"Logeo Fallido", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//        }
//    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            task ->
            if(task.isSuccessful) {
                Toast.makeText(this, "Cuenta creada satisfactoriamente", Toast.LENGTH_SHORT).show()
                saveUserData()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }else{
                Toast.makeText(this,"Creacion de cuenta fallida", Toast.LENGTH_SHORT).show()
                Log.d("Cuenta", "createUserWithEmail:failure", task.exception)

            }
        }

    }
    private fun saveUserData(){
        //retrieve data from input field
        username = binding.userName.text.toString()
        password = binding.password.text.toString().trim()
        email = binding.emailAddress.text.toString().trim()

        val user = UserModel(username,email,password)
        val userId = FirebaseAuth.getInstance().currentUser!!.uid
        //save data to Firebase database
        database.child("user").child(userId).setValue(user)


    }
}
