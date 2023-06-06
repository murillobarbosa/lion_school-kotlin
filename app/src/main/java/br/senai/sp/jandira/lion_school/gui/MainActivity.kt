package br.senai.sp.jandira.lion_school.gui

import android.content.Intent
import android.graphics.fonts.FontFamily
import android.os.Bundle
import android.text.Layout.Alignment
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import br.senai.sp.jandira.lion_school.model.CoursesList
import br.senai.sp.jandira.lion_school.ui.theme.Lion_schoolTheme
import br.senai.sp.jandira.lion_school.service.RetrofitFactory
import retrofit2.Response
import retrofit2.Callback
import retrofit2.Call


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lion_schoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var curso by remember {
        mutableStateOf(listOf<br.senai.sp.jandira.lion_school.model.Course>())
    }
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
                painter = painterResource(id = br.senai.sp.jandira.lion_school.R.drawable.logo_lion),
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = br.senai.sp.jandira.lion_school.R.string.title),
                color = Color(105, 105, 105),
                fontSize = 30.sp,
                fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,


                )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = br.senai.sp.jandira.lion_school.R.string.description_curse),
                color = Color(0, 140, 14),
                fontSize = 30.sp,
                fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center

            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = br.senai.sp.jandira.lion_school.R.string.description_manage),
                color = Color(105, 105, 105),
                fontSize = 30.sp,
                fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center

            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Chamada para a API

        val call = RetrofitFactory().getCourseService().getCourses()

        call.enqueue(object : Callback<CoursesList> {
            override fun onResponse(
                call: Call<CoursesList>, response: Response<CoursesList>

            ) {
                curso = response.body()!!.curso
            }

            override fun onFailure(call: Call<CoursesList>, t: Throwable) {
                Log.i("ds2m", "onFailure: ${t.message}")
            }


        })


        LazyRow(modifier = Modifier.fillMaxWidth().padding(start = 4.dp)) {
            items(curso) {
                Log.i("Cursos", "${curso}: ")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .align(alignment = CenterVertically)
                            .size(50.dp).padding(start = 4.dp)
                            .clickable {
                                val intent = Intent(context, MainActivity2::class.java)
                                intent.putExtra("siglaCurso", it.sigla)
                                intent.putExtra("nomeCurso", it.nome)
                                context.startActivity(intent)
                            },


                        shape = CircleShape,
                        backgroundColor = Color(35, 35, 35),
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 25.dp),
                            text = it.sigla,
                            color = Color.Black,
                            fontSize = 30.sp,
                            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                            fontStyle = FontStyle.Normal,
                            textAlign = TextAlign.Center,
                            )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),


            ) {
            Image(
                painter = painterResource(id = br.senai.sp.jandira.lion_school.R.drawable.img_hacker),
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }


    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Lion_schoolTheme {
        Greeting("Android")
    }
}