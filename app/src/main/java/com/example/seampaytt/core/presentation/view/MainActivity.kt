package com.example.seampaytt.core.presentation.view

import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.seampaytt.core.base.BaseActivity
import com.example.seampaytt.core.data.local.entity.ExhibitEntity
import com.example.seampaytt.core.data.remote.network.Resource
import com.example.seampaytt.core.domain.model.ExhibitModel
import com.example.seampaytt.core.presentation.adapters.ExhibitsAdapter
import com.example.seampaytt.core.presentation.viewModel.MainViewModel
import com.example.seampaytt.databinding.ActivityMainBinding
import com.example.seampaytt.utils.gone
import com.example.seampaytt.utils.hideLoading
import com.example.seampaytt.utils.visible
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), SwipeRefreshLayout.OnRefreshListener {

    private val viewModel: MainViewModel by viewModels()
    private var exhibits: List<ExhibitEntity> = listOf()
    private var exhibitAdapter: ExhibitsAdapter? = null

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun setup() {
        initView()
        subscribeViewModel()
        getExhibits()
    }

    override fun subscribeViewModel() {
        viewModel.exhibit().onLiveDataResult {
            when (it) {
                is Resource.Loading -> {
                    binding.progressBar.visible()
                }
                is Resource.Success -> {
                    binding.progressBar.gone()
                    exhibits = it.data!!
                    setLog(it.data.toString())
                    Timber.d("${it.data}")
                    setupRV()
                }
                is Resource.Error -> {
                    binding.progressBar.gone()
                }
            }
        }
    }

    private fun setupRV() {
        exhibitAdapter = ExhibitsAdapter(exhibits, this)
        binding.exhibitRv.apply {
            adapter = exhibitAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun initView() {
        binding.swipeRefresh.setOnRefreshListener(this)
    }

    private fun getExhibits() {
        viewModel.setExhibit(
            exhibit = listOf(
                ExhibitModel(
                    isSwipeRefreshed = binding.swipeRefresh.isRefreshing,
                    isNetworkAvailable = isNetworkAvailable()
                )
            )
        )
    }

    private fun setupUI(exhibits: ExhibitEntity) {

    }

    override fun onRefresh() {
        getExhibits()
        binding.swipeRefresh.hideLoading()
    }

    override fun onResume() {
        super.onResume()
        getExhibits()
    }
}