package com.mashup.zuzu.data.source.remote

import com.mashup.zuzu.data.request.UpdateUsersRequest
import com.mashup.zuzu.data.response.GetUserProfileImagesResponse
import com.mashup.zuzu.data.response.GetUsersResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT

/**
 * @Created by 김현국 2022/08/08
 */
interface UserRemoteDataSource {

    // 유저 데이터 가져오기
    @GET("/users")
    suspend fun getUser(): Response<GetUsersResponse>

    // 유저 데이터 업데이트
    @PUT("/users")
    suspend fun updateUser(@Body updateUsersReq: UpdateUsersRequest): Response<Nothing>

    // 유저 탈퇴
    @DELETE("/users")
    suspend fun deleteUser(): Response<Nothing>

    @GET("/users-profile")
    suspend fun getUserProfileImages(): Response<List<GetUserProfileImagesResponse>>
}
