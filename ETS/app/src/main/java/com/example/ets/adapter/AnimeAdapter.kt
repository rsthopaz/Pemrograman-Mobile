import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ets.Anime
import com.example.ets.R

class `AnimeAdapter.kt`(
    private val list: List<Anime>,
    private val onClick: (Anime) -> Unit
) : RecyclerView.Adapter<`AnimeAdapter.kt`.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.findViewById<ImageView>(R.id.imgAnime)
        val title = view.findViewById<TextView>(R.id.txtTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_anime, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val anime = list[position]
        holder.title.text = anime.title

        // pakai Glide untuk load gambar dari URL
        Glide.with(holder.itemView.context)
            .load(anime.imageUrl)
            .into(holder.img)

        holder.itemView.setOnClickListener {
            onClick(anime)
        }
    }
}