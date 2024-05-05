package com.geeks.hw3_5m

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.geeks.hw3_5m.databinding.ItemCharacterBinding


class CharacterAdapter() :
    PagedListAdapter<Character, CharacterAdapter.CharacterViewHolder>(DIFF_CALLBACK) {

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character: Character? = getItem(position)
        if (character != null) {
            holder.bindTo(character)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindTo(character: Character) {
            binding.imgCharacter.text = character.image
            binding.tvName.text = character.name
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character) =
                oldItem.id == newItem.id

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Character, newItem: Character) =
                oldItem == newItem
        }
    }
}