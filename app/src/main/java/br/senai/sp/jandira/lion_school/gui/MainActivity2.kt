package br.senai.sp.jandira.lion_school.gui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lion_school.R
import br.senai.sp.jandira.lion_school.gui.ui.theme.Lion_schoolTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lion_schoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    val context = LocalContext.current
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
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.title),
                    color = Color(105, 105, 105),
                    fontSize = 30.sp,
                    fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center,
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 45.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.description_curse),
                    color = Color(0, 140, 14),
                    fontSize = 30.sp,
                    fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center

                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.description_manage),
                    color = Color(105, 105, 105),
                    fontSize = 30.sp,
                    fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center

                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.status),
                    color = Color(105, 105, 105),
                    fontSize = 20.sp,
                    fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center

                )
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 35.dp, top = 15.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.vector),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color(105,105,105))
                    )

                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, top = 0.dp, bottom = 20.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .width(105.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(Color(32, 32, 32)),
                    shape = RoundedCornerShape(16.dp),

                    ) {
                    Text(
                        text = stringResource(id = R.string.c),
                        color = Color(0, 140, 14)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .width(110.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(Color(32, 32, 32)),
                    shape = RoundedCornerShape(16.dp),

                    ) {
                    Text(
                        text = stringResource(id = R.string.f),
                        color = Color(0, 140, 14)
                    )
                }
            }

            Column(Modifier.fillMaxWidth()) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp).clickable {
                            val intent = Intent(context, MainActivity3::class.java)
                            context.startActivity(intent)
                        },
                    backgroundColor = Color(32,32,32),
                    shape = RoundedCornerShape(30.dp),
                    //border = BorderStroke(2.dp, Color.Blue)
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Card(
                            modifier = Modifier.size(100.dp),
                            shape = CircleShape,
                            backgroundColor = Color(32,32,32)
                        ){
                            Image(painter = painterResource(id = R.drawable.imagem_homem), contentDescription = null)
                        }

                    }
                    Row(Modifier.fillMaxWidth().padding(start = 110.dp, top = 5.dp)) {
                        Text(text = stringResource(id = R.string.name), color = Color.Black,  fontSize = 18.sp,
                            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                            fontStyle = FontStyle.Normal,
                            textAlign = TextAlign.Center)

                    }
                    Row(Modifier.fillMaxWidth().width(50.dp).padding(start = 192.dp, top = 80.dp)) {
                        Text(text = stringResource(id = R.string.c),   color = Color(0, 140, 14))

                    }
                }


                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp).clickable {
                            val intent = Intent(context, MainActivity3::class.java)
                            context.startActivity(intent)
                        },

                    backgroundColor = Color(32,32,32),
                    shape = RoundedCornerShape(30.dp)
                    //border = BorderStroke(2.dp, Color.Blue)
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Card(
                            modifier = Modifier.size(100.dp),
                            shape = CircleShape,
                            backgroundColor = Color(32,32,32)
                        ){
                            Image(painter = painterResource(id = R.drawable.imagem_mulher), contentDescription = null)
                        }

                    }
                    Row(Modifier.fillMaxWidth().padding(start = 115.dp, top = 5.dp)) {
                        Text(text = stringResource(id = R.string.name_woman), color = Color.Black,  fontSize = 18.sp,
                            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                            fontStyle = FontStyle.Normal,
                            textAlign = TextAlign.Center)

                    }
                    Row(Modifier.fillMaxWidth().width(50.dp).padding(start = 192.dp, top = 80.dp)) {
                        Text(text = stringResource(id = R.string.f),   color = Color(0, 140, 14))

                    }
                }
            }

        }

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    Lion_schoolTheme {
        Greeting2("Android")
    }
}