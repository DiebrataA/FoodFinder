package com.anggarad.dev.foodfinder.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anggarad.dev.foodfinder.core.data.Resource
import com.anggarad.dev.foodfinder.core.ui.RecipeAdapter
import com.anggarad.dev.foodfinder.databinding.FragmentHomeBinding
import com.anggarad.dev.foodfinder.detail.DetailRecipeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val recipeAdapter = RecipeAdapter()
            recipeAdapter.onItemClick = { selectedItem ->
                val intent = Intent(activity, DetailRecipeActivity::class.java)
                intent.putExtra(DetailRecipeActivity.EXTRA_DATA, selectedItem)
                startActivity(intent)
            }

            homeViewModel.popularRecipe.observe(viewLifecycleOwner, { popular ->
                if (popular != null) {
                    when (popular) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            recipeAdapter.setData(popular.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                        }
                    }
                }
            })


            with(binding.rvRecipe) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = recipeAdapter
            }

        }
    }

}