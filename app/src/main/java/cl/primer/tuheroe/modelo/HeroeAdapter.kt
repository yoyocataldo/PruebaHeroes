package cl.primer.tuheroe.modelo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.primer.tuheroe.Heroe
import cl.primer.tuheroe.databinding.HeroeItemListBinding

class HeroeAdapter:RecyclerView.Adapter<HeroeAdapter.HeroesVH>() {
    private var heroesList = listOf<Heroe>()


    class HeroesVH(val binding: HeroeItemListBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(heroe: Heroe){
            binding.textView.text=heroe.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesVH {
       val binding=HeroeItemListBinding.inflate(LayoutInflater.from(parent.context))
        return HeroesVH(binding)
    }

    override fun onBindViewHolder(holder: HeroesVH, position: Int) {
       val heroe= heroesList[position]
        holder.bind(heroe)

    }


    override fun getItemCount(): Int {
       return heroesList.size
    }
    fun update(pHeroesList: List<Heroe>) {
        heroesList = pHeroesList
        notifyDataSetChanged()
    }



}
