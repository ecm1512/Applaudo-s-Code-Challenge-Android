package com.educode.applaudocodechallengeandroid.presentation.home.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.educode.applaudocodechallengeandroid.databinding.ItemSeasonBinding
import com.educode.applaudocodechallengeandroid.domain.entities.Season
import com.educode.applaudocodechallengeandroid.domain.entities.Show
import kotlin.properties.Delegates

class DetailAdapter: RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    var seasons: List<Season> by Delegates.observable(emptyList()){ _, old, new ->
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(
            DetailItemDiffCallback(old, new)
        )
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val binding = ItemSeasonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val season = seasons[position]
        holder.setDataCard(season)
        /*holder.itemView.setOnClickListener {
            listenerShowItem(show)
        }*/
    }

    override fun getItemCount(): Int {
        return seasons.size
    }

    class DetailViewHolder(private val binding: ItemSeasonBinding): RecyclerView.ViewHolder(binding.root){
        fun setDataCard(season: Season){

            val circularProgressDrawable = CircularProgressDrawable(binding.root.context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()

            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w500${season.posterPath}")
                .centerCrop()
                .placeholder(circularProgressDrawable)
                .into(binding.imageSeason)
            binding.tvNumberEpisodes.text = season.number.toString()
            binding.tvSeasonOverview.text = season.overview
            binding.tvSeasonName.text = season.name
        }
    }

    class DetailItemDiffCallback(
        var oldProductList: List<Season>,
        var newProductList: List<Season>
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