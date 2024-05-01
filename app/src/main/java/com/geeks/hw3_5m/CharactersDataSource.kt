package com.geeks.hw3_5m

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val INITIAL_INDEX = 1

class CharactersDataSource() :
    PageKeyedDataSource<Int, Character>() {

    val loadState = MutableLiveData<Int>()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Character>
    ) {
        RetrofitService.api.getCharacters(
            INITIAL_INDEX
        ).enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    callback.onResult(response.body()!!.results, null, INITIAL_INDEX + 1)
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e("tag","onFailure${t.localizedMessage}")
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {

        var currentIndex = params.key

        RetrofitService.api.getCharacters(
            INITIAL_INDEX
        ).enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    callback.onResult(response.body()!!.results,  currentIndex + 1)
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e("tag","onFailure${t.localizedMessage}")
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {

    }
}