package com.educode.applaudocodechallengeandroid.presentation.home.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.educode.applaudocodechallengeandroid.databinding.ItemShowBinding
import com.educode.applaudocodechallengeandroid.domain.entities.Show
import kotlin.properties.Delegates

class HomeAdapter(private var listenerShowItem: (Show) -> Unit): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    var shows: List<Show> by Delegates.observable(emptyList()){ _, old, new ->
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(
            HomeItemDiffCallback(old,new)
        )
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val show = shows[position]
        holder.setDataCard(show)
        holder.itemView.setOnClickListener {
            listenerShowItem(show)
        }
    }

    override fun getItemCount(): Int {
        return shows.size
    }

    class HomeViewHolder(private val binding: ItemShowBinding): RecyclerView.ViewHolder(binding.root){
        fun setDataCard(show: Show){

            val circularProgressDrawable = CircularProgressDrawable(binding.root.context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()

            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w500${show.posterPath}")
                .centerCrop()
                .placeholder(circularProgressDrawable)
                .into(binding.imageShow)
            binding.showName.text = show.name
            binding.average.text = show.voteAverage.toString()
        }
    }

    class HomeItemDiffCallback(
        var oldProductList: List<Show>,
        var newProductList: List<Show>
    ): DiffUtil.Callback(){
        override fun getOldListSize(): Int {
            return oldProductList.size
        }

        override fun getNewListSize(): Int {
            return newProductList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return (oldProductList[oldItemPosition].id == newProductList[newItemPosition].id)
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldProductList[oldItemPosition].equals(newProductList[newItemPosition])
        }

    }
}