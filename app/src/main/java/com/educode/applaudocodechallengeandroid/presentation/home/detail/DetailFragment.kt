package com.educode.applaudocodechallengeandroid.presentation.home.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.educode.applaudocodechallengeandroid.databinding.FragmentDetailBinding
import com.educode.applaudocodechallengeandroid.domain.entities.Show
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : ScopeFragment() {

    private val viewModel: DetailViewModel by viewModel()
    lateinit var binding: FragmentDetailBinding
    lateinit var detailAdapter: DetailAdapter
    lateinit var show: Show

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)

        show = arguments?.getParcelable("show")!!

        binding.toolbar4.setTitleTextColor(Color.WHITE)
        binding.toolbar4.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        setHasOptionsMenu(true)

        viewModel.loadSeasons(show.id)
        detailAdapter = DetailAdapter()

        listenData()


        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.toolbar4)
        (activity as AppCompatActivity?)!!.supportActionBar?.title = show.name

        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.tvSummary.text = show.overview
        binding.tvName.text = show.name
        binding.tvOriginalName.text = show.originalName ?: ""
        binding.tvAverage.text = show.voteAverage.toString()

        Glide.with(binding.root.context)
            .load("https://image.tmdb.org/t/p/w500${show.backdropPath ?: show.posterPath}")
            .centerCrop()
            .into(binding.imageDetailFragment)

        return binding.root
    }

    private fun listenData() {
        viewModel.isLoading.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressBar2.visibility = View.VISIBLE
            } else {
                binding.progressBar2.visibility = View.GONE
            }
        }

        viewModel.dataSeason.observe(viewLifecycleOwner){
            detailAdapter.seasons = it
        }

        binding.rvSeasons.adapter = detailAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            else -> true
        }
    }
}