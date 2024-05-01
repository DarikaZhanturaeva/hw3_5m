package com.geeks.hw3_5m

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

interface CharactersView {

    fun getCharacters(items:LiveData<PagedList<Character>>)

}