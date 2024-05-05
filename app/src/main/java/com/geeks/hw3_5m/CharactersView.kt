package com.geeks.hw3_5m

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

interface CharactersView {

    fun getCharacters(data:LiveData<PagedList<Character>>)

}