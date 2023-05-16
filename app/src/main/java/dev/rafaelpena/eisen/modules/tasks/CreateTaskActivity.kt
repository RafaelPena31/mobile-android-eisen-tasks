package dev.rafaelpena.eisen.modules.tasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import dev.rafaelpena.eisen.R
import dev.rafaelpena.eisen.databinding.ActivityCreateTaskBinding

class CreateTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityCreateTaskBinding.inflate(layoutInflater)

        val priorityCategoryOptions = resources.getStringArray(R.array.eisen_priority_category)
        val priorityCategoryArrayAdapter = ArrayAdapter(this, R.layout.cell_auto_complete_priority_category, priorityCategoryOptions)
        binding.spinnerPriorityCategory.adapter = priorityCategoryArrayAdapter

        binding.includeCreateTask.imgViewLeftBtn.setOnClickListener {
            finish()
        }

        binding.btnCreateTask.setOnClickListener {
            finish()
        }

        setContentView(binding.root)
    }
}