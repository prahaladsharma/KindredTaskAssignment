package com.kindred.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kindred.MainApplication
import com.kindred.R
import com.kindred.databinding.ActivityGameslistBinding
import com.kindred.model.Games
import com.kindred.model.WishesV94mg
import com.kindred.utils.InternetUtil
import com.kindred.utils.viewModelProvider
import javax.inject.Inject


class GamesListActivity : AppCompatActivity() {


    private val appComponents by lazy { MainApplication.appComponents }
    private lateinit var gamesListAdapter: GamesListAdapter
    private var list: List<WishesV94mg>?= null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private fun getViewModel(): GamesListViewModel {
        return viewModelProvider(viewModelFactory)
    }

    lateinit var binding: ActivityGameslistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponents.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_gameslist)

        setUpView()
        setupObserver()
    }

    private fun setUpView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        gamesListAdapter = GamesListAdapter()
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context, 0
                //(binding.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerView.adapter = gamesListAdapter
    }


    private fun setupObserver() {
        val isInternetOn = InternetUtil.isInternetOn()

        if (isInternetOn) {
            binding.progressBar.visibility = View.VISIBLE
            getViewModel().getListOfGames(
                "UK",
                "unibet",
                "mobilephone",
                "en_GB",
                "GBP",
                "casino,softgames",
                "casinoapp"
            )
        } else{
            Toast.makeText(this, R.string.no_internet, Toast.LENGTH_LONG).show()
        }

        getViewModel().resultHistory.observe(this, Observer { response ->
            binding.progressBar.visibility = View.GONE

            //Log.d("Data", response.games.toString())
            /*for ((key, value1) in response.games) {
                list = listOf(value1)
                Log.v("Data", list.toString());
            }*/

            renderList(response)

        })
    }

    private fun renderList(response: Games) {
        gamesListAdapter.addData(response)
        gamesListAdapter.notifyDataSetChanged()
    }
}