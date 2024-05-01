package com.geeks.hw3_5m

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.geeks.hw3_5m.Character

class CharacterPresenter(
    private val dataSourceFactory: CharactersDataSourceFactory

) {
    private var view: CharactersView? = null

    fun getCharacters() {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20)
            .build()

        val pagedList = LivePagedListBuilder(dataSourceFactory,config).build()
        view?.getCharacters(pagedList)
    }
    fun attachView (view: CharactersView){
        this.view = view
    }

    fun detachView(){
        this.view = null
    }
}