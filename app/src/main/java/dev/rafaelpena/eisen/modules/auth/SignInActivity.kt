package dev.rafaelpena.eisen.modules.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.rafaelpena.eisen.databinding.ActivitySignInBinding
import dev.rafaelpena.eisen.modules.subject.DashboardActivity

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivitySignInBinding.inflate(layoutInflater)

        binding.include.imgViewLeftBtn.setOnClickListener {
            finish()
        }

        binding.txtSignInCta.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignIn.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("userName", "Rafael")
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}