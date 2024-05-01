package com.geeks.hw3_5m

import androidx.paging.DataSource

class CharactersDataSourceFactory : DataSource.Factory<Int, Character>() {
    override fun create(): DataSource<Int, Character> = CharactersDataSource()
}