package ru.maksonic.vimosmarket.data.cloud

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.maksonic.vimosmarket.data.CatalogRepositoryImpl
import ru.maksonic.vimosmarket.domain.CatalogRepository
import java.util.concurrent.TimeUnit

/**
 * @Author maksonic on 17.11.2023
 */
@Module
@InstallIn(SingletonComponent::class)
object CloudModule {
    private const val BASE_URL = "https://vimos.ru:1457/"
    private const val BASE_IMAGE_URL = "https://vimos.ru"

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .build()

    @Provides
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)


    @Provides
    fun provideCloudStore(apiService: ApiService) = CloudStore(apiService, BASE_IMAGE_URL)

    @Provides
    fun provideCloudMapper(): ProductCloudToModelMapper = ProductCloudToModelMapper.Mapper()

    @Provides
    fun provideRepository(
        cloudStore: CloudStore,
        mapper: ProductCloudToModelMapper
    ): CatalogRepository =
        CatalogRepositoryImpl(cloudStore, mapper)
}