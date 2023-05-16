package dev.rafaelpena.eisen.modules.tasks.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.rafaelpena.eisen.R
import dev.rafaelpena.eisen.modules.tasks.models.TaskModel
import dev.rafaelpena.eisen.modules.tasks.models.TaskPriorityModel

class TaskRecyclerViewAdapter(private val taskPrioritySectionList: List<TaskPriorityModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val ITEM_VIEW_TYPE_TASK = 0
        const val ITEM_VIEW_TYPE_SECTION = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_TASK -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_recycler_view_task_item, parent, false)
                TaskViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_recycler_view_task_priority_section_item, parent, false)
                SectionViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is TaskModel -> {
                val taskViewHolder = holder as TaskViewHolder
                taskViewHolder.bind(item)
            }
            is TaskPriorityModel -> {
                val sectionViewHolder = holder as SectionViewHolder
                sectionViewHolder.bind(item)
            }
        }
    }

    override fun getItemCount(): Int = taskPrioritySectionList.sumBy { it.taskList.size + 1 }

    override fun getItemViewType(position: Int): Int {
        return if (isSectionHeaderPosition(position)) {
            ITEM_VIEW_TYPE_SECTION
        } else {
            ITEM_VIEW_TYPE_TASK
        }
    }

    private fun isSectionHeaderPosition(position: Int): Boolean {
        var sum = 0
        for (section in taskPrioritySectionList) {
            if (position == sum) return true
            sum += section.taskList.size + 1
        }
        return false
    }

    private fun getItem(position: Int): Any {
        var index = 0
        for (section in taskPrioritySectionList) {
            if (position == index) {
                return section
            } else if (position < index + section.taskList.size + 1) {
                return section.taskList[position - index - 1]
            }
            index += section.taskList.size + 1
        }
        throw IndexOutOfBoundsException("Invalid index $position")
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleCheckbox: CheckBox = itemView.findViewById(R.id.checkBoxTask)

        fun bind(task: TaskModel) {
            titleCheckbox.text = task.TaskTitle
        }
    }

    inner class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.txtViewTaskPrioritySectionTitle)

        fun bind(section: TaskPriorityModel) {
            titleTextView.text = section.priorityCategory
        }
    }
}
