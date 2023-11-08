package jp.ac.it_college.std.s22004.poke3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import jp.ac.it_college.std.s22004.poke3.api.Games
import jp.ac.it_college.std.s22004.poke3.ui.theme.Poke3Theme
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Poke3Theme {
                MainScene(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MainScene(
    modifier: Modifier = Modifier,
) {
    val gen = mutableListOf("")
    var resultText by remember {
        mutableStateOf("結果表示")
    }
    // Composable な関数内でコルーチンを使用するためのコルーチンスコープ
    val scope = rememberCoroutineScope()
//    var num: Int = 1
    var num by remember {
        mutableStateOf(1)
    }


    Surface(modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedButton(
                modifier = Modifier.padding(vertical = 8.dp),
                onClick = {
//                    scope.launch {
                        val range = (10..20)
//                        println(range.random())
                        num = range.random()
//                        for (i in 0 .. 8) {
//                            gen.add(Games.getGenerations().results[i].url)
//                            resultText = "$gen"
//                        }
////                            resultText = Games.getGenerations().results[0].url

//                    }

                }
            ) {
                Text(text = "API Test")
            }
            Surface(
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                Text(text = resultText)
//                LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
//                }
                Image(
                    painter = rememberAsyncImagePainter("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$num.png"),
                    contentDescription = null,
                    modifier.size(128.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@Composable
fun Btn(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun MainScenePreview() {
    Poke3Theme {
        MainScene(Modifier.fillMaxSize())
    }
}