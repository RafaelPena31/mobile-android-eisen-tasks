package dev.rafaelpena.eisen.modules.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.rafaelpena.eisen.databinding.ActivityProfileBinding
import dev.rafaelpena.eisen.modules.walkthrough.WalkthroughActivity


class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityProfileBinding.inflate(layoutInflater)

        binding.imgViewHeaderDetailsLeftBtn.setOnClickListener {
            finish()
        }

        binding.txtViewSignOut.setOnClickListener {
            val intent = Intent(this, WalkthroughActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        binding.btnDeleteAccount.setOnClickListener {
            val intent = Intent(this, WalkthroughActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}