package jp.ac.it_college.std.s22004.implicitlntentsample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import jp.ac.it_college.std.s22004.implicitlntentsample.databinding.ActivityMainBinding
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btMapSearch.setOnClickListener(::onMapSearchButton)
    }

    private fun onMapSearchButton(view: View) {
        val searchWord = URLEncoder.encode(
            binding.eaSearchWord.text.toString(), "UTF-8"
        )
        val uri = Uri.parse("geo:0,0?q=${searchWord}")
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }
}