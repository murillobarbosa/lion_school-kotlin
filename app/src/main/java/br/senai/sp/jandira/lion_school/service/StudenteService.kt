package br.senai.sp.jandira.lion_school.service

import br.senai.sp.jandira.lion_school.model.StudentList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StudenteService {
    @GET("alunos")
    fun getAlunos():Call<StudentList>

    @GET("alunos")
    fun getStatus(@Query("status") status: String): Call<StudentList>

    @GET("alunos/curso/")
    fun getCurso(@Query("sigla") curso: String):Call<StudentList>

    @GET("alunos")
    fun getConclusao(@Query("conclusao") conclusao: String):Call<StudentList>
}