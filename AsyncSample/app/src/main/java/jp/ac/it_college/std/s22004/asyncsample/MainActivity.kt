package jp.ac.it_college.std.s22004.asyncsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.UiThread
import androidx.annotation.WorkerThread
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import jp.ac.it_college.std.s22004.asyncsample.databinding.ActivityMainBinding
import java.util.concurrent.Callable
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    companion object {
        private const val DEBUG_TAG = "AsyncSample"
        private const val WEATHER_INFO_URL =
            "https://api.openweathermap.org/data/2.5/wweather?lang=ja"
        private const val APP_ID = BuildConfig.APP_ID
    }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCityList.apply {
            adapter = CityAdapter {
                receiveWeatherInfo(it.q)
            }
            layoutManager = LinearLayoutManager(context)
        }
    }

    @UiThread
    private fun receiveWeatherInfo(q: String) {
        val url = "$WEATHER_INFO_URL&q&appid=$APP_ID"
        val executorService = Executors.newSingleThreadExecutor()
        val backgroundReceiver = WeatherInfoBackgroundReceiver()
        val future = executorService.submit(backgroundReceiver)
        val result = future.get()
    }
    private class WeatherInfoBackgroundReceiver() : Callable<String> {
        @WorkerThread
        override fun call(): String {
            return "hoge"
        }
    }
}