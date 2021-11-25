package com.example.testapp.ui

import com.example.testapp.model.Beer

interface MainContract {
    interface View {
        fun onError(message: String)
        fun onGetBeers(beers: List<Beer>)
    }

    interface Presenter {
        fun getBeers(page: Int)
    }
}