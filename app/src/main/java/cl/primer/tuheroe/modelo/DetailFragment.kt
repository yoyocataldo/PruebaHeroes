package cl.primer.tuheroe.modelo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.primer.tuheroe.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment:Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModel:HeroeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        viewModel.selected().observe(viewLifecycleOwner, {
            binding.textView2.text = it.name
            binding.textView3.text = it.slug
            binding.textView4.text = it.biography.firstAppearance
            Picasso.get().load(it.images.lg).into(binding.imageView2)
        }
        )
        return binding.root
    }
}