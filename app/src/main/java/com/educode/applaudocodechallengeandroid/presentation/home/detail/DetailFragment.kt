package com.educode.applaudocodechallengeandroid.presentation.home.detail

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.educode.applaudocodechallengeandroid.R
import com.educode.applaudocodechallengeandroid.databinding.FragmentDetailBinding
import com.educode.applaudocodechallengeandroid.domain.entities.Show

class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var show: Show

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)

        show = arguments?.getParcelable<Show>("show")!!

        binding.toolbar4.setTitleTextColor(Color.WHITE)
        binding.toolbar4.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        setHasOptionsMenu(true)

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