package com.test.apod

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.test.apod.databinding.ActivityMainBinding
import com.test.apod.utils.NetworkUtils
import com.test.apod.utils.Util
import com.test.apod.viewmodels.MainViewModel
import com.test.apod.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = (application as ApodApplication).apodRepository

        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(repository)
        )[MainViewModel::class.java]

        mainViewModel.data.observe(this) { data->
            binding.apply {
                data?.let {
                    it.url?.let { url ->
                        Glide.with(this@MainActivity)
                            .load(url)
                            .placeholder(R.drawable.ic_launcher_background)
                            .error(R.drawable.ic_launcher_foreground)
                            .into(iv)
                    }
                    tvTitle.text = it.title ?: ""
                    tvExp.text = it.explanation ?: ""

                    val date = Util.checkTodayDate()
                    if (!it.date.equals(date) && !NetworkUtils.isInternetAvailable(this@MainActivity)) {
                        Util.showError(this@MainActivity)
                    }
                }

            }
        }


    }
}