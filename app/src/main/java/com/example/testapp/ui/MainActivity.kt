package com.example.testapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.model.Beer

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: BeerAdapter
    private lateinit var mPresenter: MainContract.Presenter

    private var beerList = mutableListOf<Beer>()
    private var page = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPresenter = MainPresenter(this)

        initView()
        mPresenter.getBeers(page)
    }

    fun initView() {
        mAdapter = BeerAdapter(this, beerList, {})

        binding.rvBeer.layoutManager = LinearLayoutManager(this)
        binding.rvBeer.adapter = mAdapter

        binding.rvBeer.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1)) {
                    page++
                    mPresenter.getBeers(page)
                }
            }
        })
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onGetBeers(beers: List<Beer>) {

    }
}