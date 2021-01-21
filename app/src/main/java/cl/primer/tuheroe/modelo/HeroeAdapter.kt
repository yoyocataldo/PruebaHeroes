package cl.primer.tuheroe.modelo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.primer.tuheroe.Heroe
import cl.primer.tuheroe.databinding.HeroeItemListBinding
import com.squareup.picasso.Picasso

class HeroeAdapter:RecyclerView.Adapter<HeroeAdapter.HeroesVH>() {
    private var heroesList = listOf<Heroe>()
private val selectedItem = MutableLiveData<Heroe>()
fun selectedItem(): LiveData<Heroe> = selectedItem


    class HeroesVH(val binding: HeroeItemListBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(heroe: Heroe){
            binding.textView.text=heroe.name
            Picasso.get().load(heroe.images.md).into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesVH {
       val binding=HeroeItemListBinding.inflate(LayoutInflater.from(parent.context))
        return HeroesVH(binding)
    }

    override fun onBindViewHolder(holder: HeroesVH, position: Int) {
       val heroe= heroesList[position]
        holder.bind(heroe)
        holder.itemView.setOnClickListener{
selectedItem.value=heroe
    }
    }


    override fun getItemCount(): Int {
       return heroesList.size
    }
    fun update(pHeroesList: List<Heroe>) {
        heroesList = pHeroesList
        notifyDataSetChanged()
    }



}
