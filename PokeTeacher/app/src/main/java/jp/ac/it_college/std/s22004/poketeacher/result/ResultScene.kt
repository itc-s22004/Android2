package jp.ac.it_college.std.s22004.poketeacher.result

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.ac.it_college.std.s22004.poketeacher.R
import jp.ac.it_college.std.s22004.poketeacher.ui.theme.PokeTeacherTheme


@Composable
fun ResultScene(
    result: Int,
    modifier: Modifier = Modifier,
    onClickGenerationButton: () -> Unit = {},
    onClickTitleButton: () -> Unit = {},
) {
    Surface(modifier) {
        Column {
            // 見出し用のラベル
            Text(text = stringResource(id = R.string.score))
            // 実際の点数
            Text(
                text = stringResource(id = R.string.point, result),
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth(0.7f)
            )
            Spacer(modifier = Modifier.padding(vertical = 16.dp))

            Button(
                onClick = onClickGenerationButton,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = stringResource(id = R.string.to_generation))
            }
            Button(
                onClick = onClickTitleButton,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = stringResource(id = R.string.to_title))
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun ResultScenePreview() {
    PokeTeacherTheme {
        ResultScene(
            result = 0,
            modifier = Modifier.fillMaxSize()
        )
    }
}