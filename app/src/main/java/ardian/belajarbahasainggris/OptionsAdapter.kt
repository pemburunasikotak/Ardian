
package ardian.belajarbahasainggris

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OptionsAdapter(
    private var options: List<String>,
    private val onOptionClickListener: (Int) -> Unit
) : RecyclerView.Adapter<OptionsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val optionTextView: TextView = itemView.findViewById(R.id.optionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_option, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val option = options[position]
        holder.optionTextView.text = option

        holder.itemView.setOnClickListener {
            onOptionClickListener.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return options.size
    }

    fun updateOptions(newOptions: List<String>) {
        options = newOptions
        notifyDataSetChanged()
    }
}
