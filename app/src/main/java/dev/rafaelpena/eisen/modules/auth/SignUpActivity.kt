package dev.rafaelpena.eisen.modules.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.rafaelpena.eisen.databinding.ActivitySignUpBinding
import dev.rafaelpena.eisen.modules.subject.DashboardActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivitySignUpBinding.inflate(layoutInflater)

        binding.include.imgViewLeftBtn.setOnClickListener {
            finish()
        }

        binding.txtSignUpCta.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("userName", "Rafael")
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}