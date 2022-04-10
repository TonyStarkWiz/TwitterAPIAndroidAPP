package com.android.twitterapiandroidapp.rest

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TwitterApi {
    @GET("$RANDOM_PATH{number}")
    suspend fun getRandomTweet(
        @Path("users") userName : String,
        @Query("ids") userNameID : String? = null,
        @Query("tweet.field") tweet : String? = null,
    ) : Response<TwitterApi>

    abstract fun getRandomTweet(userNameID: String, tweet: String): Response<TwitterApi>

    companion object {
        // https://api.twitter.com/2/users?ids=2244994945,6253282&tweet.fields=text
        const val BASE_URL = "https://api.twitter.com/2/"
        const val RANDOM_PATH = "users"
    }
}
