package com.example.testapp.ui

import com.example.testapp.model.Beer
import com.example.testapp.network.ApiInterface
import com.example.testapp.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view: MainContract.View): MainContract.Presenter {
    override fun getBeers(page: Int) {
        ApiService.getService().create(ApiInterface::class.java).getBeers(page, 20)
            .enqueue(object : Callback<List<Beer>> {
                override fun onResponse(call: Call<List<Beer>>, response: Response<List<Beer>>) {
                    response.body()?.let { view.onGetBeers(it) }
                }

                override fun onFailure(call: Call<List<Beer>>, t: Throwable) {
                    t.message?.let { view.onError(it) }
                }

            })
    }
}