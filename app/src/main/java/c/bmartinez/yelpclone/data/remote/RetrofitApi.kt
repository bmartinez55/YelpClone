package c.bmartinez.yelpclone.data.remote

import c.bmartinez.yelpclone.data.remote.dto.business_details.BusinessDetailsDto
import c.bmartinez.yelpclone.data.remote.dto.business_search.BusinessSearchDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/*
    Interface that holds all endpoint calls
 */
interface RetrofitApi {

    //Gets data from selected business via business ID
    @GET("businesses/{id}")
    suspend fun getBusinessDetails(
        @Path("id") id: String
    ): BusinessDetailsDto

    //Gets data from businesses that correlates to the search term and near the device's location
    @GET("businesses/search")
    suspend fun getSearchResults(
        @Query("term") searchTerm: String,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("radius") searchRadius: Int,
        @Query("sort_by") sortBy: String,
        @Query("limit") maxLimit: Int
    ): BusinessSearchDto

    //Gets data from popular businesses near the device's location
    @GET("businesses/search")
    suspend fun getPopularLocations(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("radius") searchRadius: Int,
        @Query("categories") category: String,
        @Query("sort_by") sortBy: String,
        @Query("limit") maxLimit: Int
    ): BusinessSearchDto

//    companion object {
//        var retrofitApi: RetrofitApi? = null
//        fun getInstance(context: Context): RetrofitApi {
//            val logging = HttpLoggingInterceptor()
//            logging.level = HttpLoggingInterceptor.Level.BODY
//
//            val cacheSize: Long = (5 * 1024 * 1024).toLong()
//            val myCache = Cache(context.cacheDir, cacheSize)
//
//            val httpClient = OkHttpClient.Builder()
//
//            httpClient.cache(myCache)
//
//            httpClient.addNetworkInterceptor(CacheInterceptor())
//            httpClient.addInterceptor(ForceCacheInterceptor(context = context))
//            httpClient.addInterceptor(OfflineCacheInterceptor(context = context))
//            httpClient.addInterceptor(ApiKeyAuthInterceptor())
//            httpClient.addInterceptor(logging)
//
//            httpClient.connectTimeout(30, TimeUnit.SECONDS)
//            httpClient.readTimeout(30, TimeUnit.SECONDS)
//
//            val okHttpClient = httpClient.build()
//
//            if(retrofitApi == null){
//                val retrofit = Retrofit.Builder()
//                    .baseUrl(baseURL)
//                    .client(okHttpClient)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                retrofitApi = retrofit.create(RetrofitApi::class.java)
//            }
//            return retrofitApi!!
//        }
//    }
}