package com.android.testingresponsive.model.rest

import com.android.twitterapiandroidapp.rest.TwitterApi
import retrofit2.Response

interface TwitterApiRepository {
    suspend fun getRandomTweet(userNameID: String, tweet: String): Response<TwitterApi>

}

class TwitterApiRepositoryImpl( private val twitterAPI: TwitterApi ): TwitterApiRepository{
    override suspend fun getRandomTweet(userNameID: String, tweet: String): Response<TwitterApi> {
        return twitterAPI.getRandomTweet(userNameID = userNameID, tweet = tweet)
    }
}











