package dev.rafaelpena.eisen.modules.tasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import dev.rafaelpena.eisen.modules.tasks.adapters.TaskRecyclerViewAdapter
import dev.rafaelpena.eisen.databinding.ActivityTaskBinding
import dev.rafaelpena.eisen.modules.tasks.models.TaskModel
import dev.rafaelpena.eisen.modules.tasks.models.TaskPriorityModel

class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val taskData = loadMockTaskList()

        val binding = ActivityTaskBinding.inflate(layoutInflater)

        binding.txtViewNameSubjectTask.text = intent.extras?.getString("Name")
        binding.txtViewDescriptionSubjectTask.text = intent.extras?.getString("Description")

        val taskAdapter = TaskRecyclerViewAdapter(taskData)
        binding.recycleViewTask.adapter = taskAdapter
        binding.recycleViewTask.layoutManager = LinearLayoutManager(this)
        binding.recycleViewTask.itemAnimator = DefaultItemAnimator()

        binding.imgViewTaskLeftBtn.setOnClickListener {
            finish()
        }

        binding.imgViewSubjectTaskDeleteBtn.setOnClickListener {
            finish()
        }

        binding.btnDashCreateTask.setOnClickListener {
            val intent = Intent(this, CreateTaskActivity::class.java)
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}

fun loadMockTaskList(): ArrayList<TaskPriorityModel> {
    val taskPriorityList = ArrayList<TaskModel>()
    val taskScheduleList = ArrayList<TaskModel>()
    val taskDelegateList = ArrayList<TaskModel>()

    taskPriorityList.add(TaskModel("1", "Tarefa 1", "Priorizado"))
    taskPriorityList.add(TaskModel("2", "Tarefa 2", "Priorizado"))
    taskPriorityList.add(TaskModel("3", "Tarefa 3", "Priorizado"))

    taskScheduleList.add(TaskModel("4", "Tarefa 4", "Agendado"))
    taskScheduleList.add(TaskModel("5", "Tarefa 5", "Agendado"))
    taskScheduleList.add(TaskModel("6", "Tarefa 6", "Agendado"))

    taskDelegateList.add(TaskModel("7", "Tarefa 7", "Delegado"))
    taskDelegateList.add(TaskModel("8", "Tarefa 8", "Delegado"))
    taskDelegateList.add(TaskModel("9", "Tarefa 9", "Delegado"))

    val taskPrioritySectionList = ArrayList<TaskPriorityModel>()
    taskPrioritySectionList.add(TaskPriorityModel("Priorizado", taskPriorityList))
    taskPrioritySectionList.add(TaskPriorityModel("Agendado", taskScheduleList))
    taskPrioritySectionList.add(TaskPriorityModel("Delegado", taskDelegateList))

    return taskPrioritySectionList
}