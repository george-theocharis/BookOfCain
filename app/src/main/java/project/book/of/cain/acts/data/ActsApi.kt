package project.book.of.cain.acts.data

import retrofit2.http.GET

interface ActsApi {

    @GET("/d3/data/act")
    suspend fun getActs(): List<ActRaw>

}
