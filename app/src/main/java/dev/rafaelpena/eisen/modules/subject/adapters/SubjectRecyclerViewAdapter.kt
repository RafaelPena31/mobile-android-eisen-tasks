package dev.rafaelpena.eisen.modules.subject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.rafaelpena.eisen.R
import dev.rafaelpena.eisen.modules.subject.models.SubjectModel

class SubjectRecyclerViewAdapter(private val context: Context, private val list: ArrayList<SubjectModel>, var itemClickLister: (subject: SubjectModel) -> Unit): RecyclerView.Adapter<SubjectRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_recycler_view_subject, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentSubject = list[position]
        holder.subjectNameTxtView.text = currentSubject.Name
        holder.subjectDescriptionTxtView.text = currentSubject.Description

        holder.itemView.setOnClickListener {
            itemClickLister(currentSubject)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val subjectNameTxtView = view.findViewById<TextView>(R.id.txtSubjectName)
        val subjectDescriptionTxtView = view.findViewById<TextView>(R.id.txtSubjectDescription)
    }
}