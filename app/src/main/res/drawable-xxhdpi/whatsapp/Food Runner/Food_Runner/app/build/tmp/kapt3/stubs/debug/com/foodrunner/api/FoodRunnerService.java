package com.foodrunner.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\nH\'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\nH\'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H\'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\'J\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\'J\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\'J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u001eH\'\u00a8\u0006\u001f"}, d2 = {"Lcom/foodrunner/api/FoodRunnerService;", "", "forgotPassword", "Lretrofit2/Call;", "Lcom/foodrunner/model/ForgotPasswordResponse;", "forgotPasswordModel", "Lcom/foodrunner/model/ForgotPasswordModel;", "getMenuList", "Lcom/foodrunner/model/MenuModelResponse;", "restaurantId", "", "getPastOrders", "Lcom/foodrunner/model/PastOrdersModelResponse;", "userId", "getRestaurantList", "Lcom/foodrunner/api/FetchRestaurantDetailResponse;", "loginUser", "Lcom/foodrunner/model/AuthModelResponse;", "loginModel", "Lcom/foodrunner/model/LoginModel;", "placeOrder", "Lcom/foodrunner/model/PlaceOrderResponse;", "placeOrderModel", "Lcom/foodrunner/model/PlaceOrderModel;", "registerUser", "authModel", "Lcom/foodrunner/model/AuthModel;", "resetPassword", "Lcom/foodrunner/model/ResetPasswordResponse;", "resetPasswordModel", "Lcom/foodrunner/model/ResetPasswordModel;", "app_debug"})
public abstract interface FoodRunnerService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "v2/register/fetch_result")
    @retrofit2.http.Headers(value = {"content-type:application/json", "token:ad314db5e5b1e2"})
    public abstract retrofit2.Call<com.foodrunner.model.AuthModelResponse> registerUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.foodrunner.model.AuthModel authModel);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "v2/login/fetch_result")
    @retrofit2.http.Headers(value = {"content-type:application/json", "token:ad314db5e5b1e2"})
    public abstract retrofit2.Call<com.foodrunner.model.AuthModelResponse> loginUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.foodrunner.model.LoginModel loginModel);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "v2/forgot_password/fetch_result")
    @retrofit2.http.Headers(value = {"content-type:application/json", "token:ad314db5e5b1e2"})
    public abstract retrofit2.Call<com.foodrunner.model.ForgotPasswordResponse> forgotPassword(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.foodrunner.model.ForgotPasswordModel forgotPasswordModel);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "v2/reset_password/fetch_result ")
    @retrofit2.http.Headers(value = {"content-type:application/json", "token:ad314db5e5b1e2"})
    public abstract retrofit2.Call<com.foodrunner.model.ResetPasswordResponse> resetPassword(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.foodrunner.model.ResetPasswordModel resetPasswordModel);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v2/restaurants/fetch_result/")
    @retrofit2.http.Headers(value = {"content-type:application/json", "token:ad314db5e5b1e2"})
    public abstract retrofit2.Call<com.foodrunner.api.FetchRestaurantDetailResponse> getRestaurantList();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v2/restaurants/fetch_result/{restaurant_id}")
    @retrofit2.http.Headers(value = {"content-type:application/json", "token:ad314db5e5b1e2"})
    public abstract retrofit2.Call<com.foodrunner.model.MenuModelResponse> getMenuList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "restaurant_id")
    java.lang.String restaurantId);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "v2/place_order/fetch_result")
    @retrofit2.http.Headers(value = {"content-type:application/json", "token:ad314db5e5b1e2"})
    public abstract retrofit2.Call<com.foodrunner.model.PlaceOrderResponse> placeOrder(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.foodrunner.model.PlaceOrderModel placeOrderModel);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v2/orders/fetch_result/{user_id}")
    @retrofit2.http.Headers(value = {"content-type:application/json", "token:ad314db5e5b1e2"})
    public abstract retrofit2.Call<com.foodrunner.model.PastOrdersModelResponse> getPastOrders(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "user_id")
    java.lang.String userId);
}