package dev.rafaelpena.eisen.modules.subject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import dev.rafaelpena.eisen.modules.subject.adapters.SubjectRecyclerViewAdapter
import dev.rafaelpena.eisen.databinding.ActivityDashboardBinding
import dev.rafaelpena.eisen.modules.subject.models.SubjectModel
import dev.rafaelpena.eisen.modules.auth.ProfileActivity
import dev.rafaelpena.eisen.modules.tasks.TaskActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val subjectData = loadMockSubjectList()

        val binding = ActivityDashboardBinding.inflate(layoutInflater)

        binding.userName = intent.extras?.getString("userName")

        binding.btnDashCreateSubject.setOnClickListener {
            val intent = Intent(this, CreateSubjectActivity::class.java)
            startActivity(intent)
        }

        binding.txtViewProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        val subjectAdapter = SubjectRecyclerViewAdapter(this, subjectData, fun (subject: SubjectModel) {
            val intent = Intent(this, TaskActivity::class.java)

            intent.putExtra("Id", subject.Id)
            intent.putExtra("Name", subject.Name)
            intent.putExtra("Description", subject.Description)

            startActivity(intent)
        })
        binding.recycleViewSubject.adapter = subjectAdapter
        binding.recycleViewSubject.layoutManager = LinearLayoutManager(this)
        binding.recycleViewSubject.itemAnimator = DefaultItemAnimator()

        setContentView(binding.root)
    }
}

fun loadMockSubjectList(): ArrayList<SubjectModel> {
    val subjectList = ArrayList<SubjectModel>()

    subjectList.add(SubjectModel("1", "Matemática", "Cálculo 1 do curso de Análise e Desenvolvimento de Sistemas do Cotemig"))
    subjectList.add(SubjectModel("2", "Dev Android", "Desenvolvimento de aplicações mobile com tecnologias Android"))
    subjectList.add(SubjectModel("3", "Sistemas Operacionais", "Estudo das arquiteturas e paradigmas dos SOs"))
    subjectList.add(SubjectModel("4", "Banco de Dados", "Estudo aprofundado do SGBD Oracle com Procedures, Triggers, Cursores"))
    subjectList.add(SubjectModel("5", "Redes", "Arquitetura e criação de redes físicas e suas infraestruturas"))

    return subjectList
}