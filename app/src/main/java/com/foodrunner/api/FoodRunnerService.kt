package com.foodrunner.api


import com.foodrunner.model.*
import retrofit2.Call
import retrofit2.http.*


interface FoodRunnerService {

    @Headers("content-type:application/json", "token:ad314db5e5b1e2")
    @POST("v2/register/fetch_result")
    fun registerUser(@Body authModel: AuthModel) :Call<AuthModelResponse>

    @Headers("content-type:application/json", "token:ad314db5e5b1e2")
    @POST("v2/login/fetch_result")
    fun loginUser(@Body loginModel: LoginModel) :Call<AuthModelResponse>

    @Headers("content-type:application/json", "token:ad314db5e5b1e2")
    @POST("v2/forgot_password/fetch_result")
    fun forgotPassword(@Body forgotPasswordModel: ForgotPasswordModel) :Call<ForgotPasswordResponse>

    @Headers("content-type:application/json", "token:ad314db5e5b1e2")
    @POST("v2/reset_password/fetch_result ")
    fun resetPassword(@Body resetPasswordModel: ResetPasswordModel) :Call<ResetPasswordResponse>


    @Headers("content-type:application/json", "token:ad314db5e5b1e2")
    @GET("v2/restaurants/fetch_result/")
    fun getRestaurantList() :Call<FetchRestaurantDetailResponse>

    @Headers("content-type:application/json", "token:ad314db5e5b1e2")
    @GET("v2/restaurants/fetch_result/{restaurant_id}")
    fun getMenuList(@Path( "restaurant_id") restaurantId :String) :Call<RestaurantDetailsResponse>

    @Headers("content-type:application/json", "token:ad314db5e5b1e2")
    @POST("v2/place_order/fetch_result")
    fun placeOrder(@Body placeOrderModel: PlaceOrderModel) :Call<CartResponse>


    @Headers("content-type:application/json", "token:ad314db5e5b1e2")
    @GET("v2/orders/fetch_result/{user_id}")
    fun getPastOrders(@Path( "user_id") userId :String) :Call<OrderHistoryModelResponse>
}

