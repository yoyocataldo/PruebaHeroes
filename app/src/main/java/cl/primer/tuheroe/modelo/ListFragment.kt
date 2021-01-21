package cl.primer.tuheroe.modelo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.primer.tuheroe.R
import cl.primer.tuheroe.databinding.FragmentListBinding


class ListFragment:Fragment() {
    private lateinit var binding: FragmentListBinding
    private val viewmodel:HeroeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentListBinding.inflate(layoutInflater)
        binding.rvHeroes.layoutManager=LinearLayoutManager(context)
        val adapter=HeroeAdapter()
        binding.rvHeroes.adapter=adapter
        adapter.selectedItem().observe(viewLifecycleOwner,{
            viewmodel.selected(it)
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_container, DetailsFragment())?.addToBackStack("fragmentDetails")?.commit()
        })
        viewmodel.heroes.observe(viewLifecycleOwner,{
            adapter.update(it)
        })


return binding.root
    }

}