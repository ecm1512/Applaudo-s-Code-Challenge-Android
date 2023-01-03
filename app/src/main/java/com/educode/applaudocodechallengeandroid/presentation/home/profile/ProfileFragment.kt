package com.educode.applaudocodechallengeandroid.presentation.home.profile

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ActivityNavigator
import androidx.navigation.fragment.findNavController
import com.educode.applaudocodechallengeandroid.R
import com.educode.applaudocodechallengeandroid.databinding.FragmentProfileBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        binding.toolbar2.setTitleTextColor(Color.WHITE)
        binding.toolbar2.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        setHasOptionsMenu(true)

        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.toolbar2)
        (activity as AppCompatActivity?)!!.supportActionBar?.title = resources.getString(R.string.profile_fragment_title)

        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.btnLogOut.setOnClickListener {
            val builder = MaterialAlertDialogBuilder(requireContext())
                .setMessage(getString(R.string.profile_fragment_dialog_text))
                .setPositiveButton(getString(R.string.profile_fragment_dialog_button1), null)
                .setNegativeButton(getString(R.string.profile_fragment_dialog_button2), null)
                .show()

            builder.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                builder.dismiss()
            }

            builder.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener {
                activity?.finish()
            }

        }
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