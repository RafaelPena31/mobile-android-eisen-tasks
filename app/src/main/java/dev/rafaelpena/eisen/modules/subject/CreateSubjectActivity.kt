package dev.rafaelpena.eisen.modules.subject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.rafaelpena.eisen.databinding.ActivityCreateSubjectBinding

class CreateSubjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityCreateSubjectBinding.inflate(layoutInflater)

        binding.include.imgViewLeftBtn.setOnClickListener {
            finish()
        }

        binding.btnCreateSubject.setOnClickListener {
            finish()
        }

        setContentView(binding.root)
    }
}