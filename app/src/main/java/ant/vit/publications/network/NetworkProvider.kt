package ant.vit.publications.network

import android.util.Log
import ant.vit.publications.BuildConfig
import ant.vit.publications.network.dto.issues.IssueResponse
import ant.vit.publications.network.dto.publications.PublicationsResponse
import io.reactivex.Single
import io.reactivex.plugins.RxJavaPlugins
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by Vitiello Antonio
 */
class NetworkProvider {
    init {
        RxJavaPlugins.setErrorHandler { t: Throwable -> Log.e(TAG, "RxJava plugin error", t) }
    }

    companion object {
        const val TAG = "NetworkProvider"
        const val ENDPOINT = "https://api-ne.paperlit.com"

        private fun buildHeadersList(): Map<String, String> {
            val bearerToken =
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwcm9qZWN0SWQiOiJwcmpfNWRmOGE4NGM4ZWY5YSIsInByb2plY3RQZXJtaXNzaW9uc0JpdG1hc2siOjF9.xNsGH_q3anUNhn64RZ-HX8chuqr5UkOuAFfUndleHK0"
            return mapOf(Pair("Authorization", "Bearer $bearerToken"))
        }

        private val httpClient = OkHttpClient.Builder().apply {
            writeTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            connectTimeout(60, TimeUnit.SECONDS)
            networkInterceptors().add(Interceptor { chain ->
                val request = chain.request().newBuilder().apply {
                    buildHeadersList().forEach {
                        header(it.key, it.value)
                    }
                }.build()
                chain.proceed(request)
            })
            if (BuildConfig.DEBUG) {
                addNetworkInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }
        }.build()

        private var apiService = Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(JacksonConverterFactory.create())
            .callbackExecutor(Executors.newCachedThreadPool())
            .client(httpClient)
            .build()
            .create(ApiService::class.java)
    }

    fun getPublicationsSingle(publicationsId: String): Single<PublicationsResponse> {
        return apiService.getPublicationsSingle(publicationsId)
    }

    fun getIssueSingle(publicationsId: String, issueId: String): Single<IssueResponse> {
        return apiService.getIssueSingle(publicationsId, issueId)
    }

}