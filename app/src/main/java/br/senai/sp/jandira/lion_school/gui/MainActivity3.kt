package br.senai.sp.jandira.lion_school.gui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lion_school.R
import br.senai.sp.jandira.lion_school.gui.ui.theme.ui.theme.Lion_schoolTheme

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lion_schoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting3("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            shape = RectangleShape, backgroundColor = Color.Black

        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_lion),
                contentDescription = "logo",
                modifier = Modifier,
                contentScale = ContentScale.Crop,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 140.dp, top = 15.dp)
        ) {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Card(
                    modifier = Modifier.size(100.dp),
                    shape = CircleShape,
                    backgroundColor = Color(32, 32, 32)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.imagem_homem),
                        contentDescription = null
                    )
                }

            }
        }
        Column(modifier = Modifier.fillMaxWidth().padding(start = 80.dp)) {
            Text(
                text = stringResource(id = R.string.name),
                color = Color(0,140,14),
                fontSize = 18.sp,
                fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center

            )


        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview3() {
    Lion_schoolTheme {
        Greeting3("Android")
    }
}