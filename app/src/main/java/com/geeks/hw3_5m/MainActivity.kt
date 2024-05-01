package com.geeks.hw3_5m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.geeks.hw3_5m.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CharactersView {


    private lateinit var binding: ActivityMainBinding
    private val presenter by lazy {
        CharacterPresenter(
            CharactersDataSourceFactory()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        presenter.getCharacters()
    }

    override fun getCharacters(data: LiveData<PagedList<Character>>) {
        data.observe(this){

        }
    }
}