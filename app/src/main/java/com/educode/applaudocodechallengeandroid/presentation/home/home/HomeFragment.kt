package com.educode.applaudocodechallengeandroid.presentation.home.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.educode.applaudocodechallengeandroid.R
import com.educode.applaudocodechallengeandroid.databinding.FragmentHomeBinding
import com.educode.applaudocodechallengeandroid.domain.entities.Show
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class  HomeFragment : ScopeFragment() {

    private val viewModel: HomeViewModel by viewModel()
    lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapterTopRated: HomeAdapter
    private lateinit var homeAdapterPopular: HomeAdapter
    private lateinit var homeAdapterOnTv: HomeAdapter
    private lateinit var homeAdapterAiring: HomeAdapter
    var btn1 = 1
    var btn2 = 0
    var btn3 = 0
    var btn4 = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.toolbar.setTitleTextColor(Color.WHITE)

        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.toolbar)
        (activity as AppCompatActivity?)!!.supportActionBar?.title = resources.getString(R.string.toolbar_title)

        viewModel.loadAiringTodayShows()
        viewModel.loadOnTheAirShows()
        viewModel.loadTopRatedShows()
        viewModel.loadPopularShows()

        homeAdapterTopRated = HomeAdapter { show -> goToDetailFragment(show) }
        homeAdapterPopular = HomeAdapter { show -> goToDetailFragment(show) }
        homeAdapterOnTv = HomeAdapter { show -> goToDetailFragment(show) }
        homeAdapterAiring = HomeAdapter { show -> goToDetailFragment(show) }

        listenData()

        binding.btnTopRated.setOnClickListener {
            if(btn1 == 0){
                btn1 = 1
                btn2 = 0
                btn3 = 0
                btn4 = 0
                binding.btnTopRated.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.principal_color))
                binding.btnTopRated.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

                binding.btnPopular.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_inactive))
                binding.btnPopular.setTextColor(ContextCompat.getColor(requireContext(), R.color.login_text_color))

                binding.btnOnTv.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_inactive))
                binding.btnOnTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.login_text_color))

                binding.btnAiring.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_inactive))
                binding.btnAiring.setTextColor(ContextCompat.getColor(requireContext(), R.color.login_text_color))

                binding.rvShows.adapter = homeAdapterTopRated
            }
        }

        binding.btnPopular.setOnClickListener {
            if(btn2 == 0){
                btn1 = 0
                btn2 = 1
                btn3 = 0
                btn4 = 0
                binding.btnTopRated.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_inactive))
                binding.btnTopRated.setTextColor(ContextCompat.getColor(requireContext(), R.color.login_text_color))

                binding.btnPopular.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.principal_color))
                binding.btnPopular.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

                binding.btnOnTv.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_inactive))
                binding.btnOnTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.login_text_color))

                binding.btnAiring.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_inactive))
                binding.btnAiring.setTextColor(ContextCompat.getColor(requireContext(), R.color.login_text_color))

                binding.rvShows.adapter = homeAdapterPopular
            }
        }

        binding.btnOnTv.setOnClickListener {
            if(btn3 == 0){
                btn1 = 0
                btn2 = 0
                btn3 = 1
                btn4 = 0
                binding.btnTopRated.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_inactive))
                binding.btnTopRated.setTextColor(ContextCompat.getColor(requireContext(), R.color.login_text_color))

                binding.btnPopular.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_inactive))
                binding.btnPopular.setTextColor(ContextCompat.getColor(requireContext(), R.color.login_text_color))

                binding.btnOnTv.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.principal_color))
                binding.btnOnTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

                binding.btnAiring.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_inactive))
                binding.btnAiring.setTextColor(ContextCompat.getColor(requireContext(), R.color.login_text_color))

                binding.rvShows.adapter = homeAdapterOnTv
            }
        }

        binding.btnAiring.setOnClickListener {
            if(btn4 == 0){
                btn1 = 0
                btn2 = 0
                btn3 = 0
                btn4 = 1
                binding.btnTopRated.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_inactive))
                binding.btnTopRated.setTextColor(ContextCompat.getColor(requireContext(), R.color.login_text_color))

                binding.btnPopular.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_inactive))
                binding.btnPopular.setTextColor(ContextCompat.getColor(requireContext(), R.color.login_text_color))

                binding.btnOnTv.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_inactive))
                binding.btnOnTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.login_text_color))

                binding.btnAiring.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.principal_color))
                binding.btnAiring.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

                binding.rvShows.adapter = homeAdapterAiring
            }
        }

        setHasOptionsMenu(true);
        return binding.root
    }

    private fun goToDetailFragment(show: Show) {
        val bundle = bundleOf("show" to show)
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
    }

    private fun listenData() {
        viewModel.isLoading.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

        viewModel.dataPopularShows.observe(viewLifecycleOwner) {
            homeAdapterPopular.shows = it
        }

        viewModel.dataTopRatedShows.observe(viewLifecycleOwner) {
            homeAdapterTopRated.shows = it
        }

        viewModel.dataTvAiringTodayShows.observe(viewLifecycleOwner) {
            homeAdapterAiring.shows = it
        }

        viewModel.dataTvOnTheAirShows.observe(viewLifecycleOwner) {
            homeAdapterOnTv.shows = it
        }

        binding.rvShows.adapter = homeAdapterTopRated
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as AppCompatActivity?)!!.menuInflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_search -> {
                findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
                true
            }
            R.id.action_profile -> {
                findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
                true
            }
            else -> true
        }

    }

}