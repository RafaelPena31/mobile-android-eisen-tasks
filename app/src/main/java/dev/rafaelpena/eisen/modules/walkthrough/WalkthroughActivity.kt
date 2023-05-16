package dev.rafaelpena.eisen.modules.walkthrough

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.rafaelpena.eisen.databinding.ActivityWalkthroughBinding
import dev.rafaelpena.eisen.modules.auth.SignInActivity
import dev.rafaelpena.eisen.modules.auth.SignUpActivity

class WalkthroughActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityWalkthroughBinding.inflate(layoutInflater)

        binding.btnInitEnter.setOnClickListener {
            val intentSignIn = Intent(this, SignInActivity::class.java)
            startActivity(intentSignIn)
        }

        binding.btnInitCreate.setOnClickListener {
            val intentSignUp = Intent(this, SignUpActivity::class.java)
            startActivity(intentSignUp)
        }

        setContentView(binding.root)
    }
}