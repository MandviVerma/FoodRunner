package com.foodrunner.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001RB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020@H\u0002J\b\u0010B\u001a\u00020@H\u0002J\"\u0010C\u001a\u00020@2\u0006\u0010D\u001a\u0002082\u0006\u0010E\u001a\u0002082\b\u0010F\u001a\u0004\u0018\u00010GH\u0014J\u0012\u0010H\u001a\u00020@2\b\u0010I\u001a\u0004\u0018\u00010JH\u0014J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020@2\u0006\u0010P\u001a\u00020QH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00150\rj\b\u0012\u0004\u0012\u00020\u0015`\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u001a\u0010+\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001a\u0010.\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001a\u00101\u001a\u000202X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000208X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\b\u00a8\u0006S"}, d2 = {"Lcom/foodrunner/ui/activities/CartActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "BASE_URL", "", "getBASE_URL", "()Ljava/lang/String;", "setBASE_URL", "(Ljava/lang/String;)V", "address", "getAddress", "setAddress", "cart", "Ljava/util/ArrayList;", "Lcom/foodrunner/model/MenuModelResponse$Data$MenuData;", "Lkotlin/collections/ArrayList;", "getCart", "()Ljava/util/ArrayList;", "setCart", "(Ljava/util/ArrayList;)V", "foodList", "Lcom/foodrunner/model/Food;", "getFoodList", "setFoodList", "httpClient", "Lokhttp3/OkHttpClient$Builder;", "getHttpClient", "()Lokhttp3/OkHttpClient$Builder;", "setHttpClient", "(Lokhttp3/OkHttpClient$Builder;)V", "placeOrderAdapter", "Lcom/foodrunner/ui/adapter/PlaceOrderAdapter;", "getPlaceOrderAdapter", "()Lcom/foodrunner/ui/adapter/PlaceOrderAdapter;", "setPlaceOrderAdapter", "(Lcom/foodrunner/ui/adapter/PlaceOrderAdapter;)V", "price", "", "getPrice", "()Ljava/lang/Double;", "setPrice", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "restaurantId", "getRestaurantId", "setRestaurantId", "restaurantName", "getRestaurantName", "setRestaurantName", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "setRetrofit", "(Lretrofit2/Retrofit;)V", "totalCost", "", "getTotalCost", "()I", "setTotalCost", "(I)V", "userId", "getUserId", "setUserId", "", "initClicks", "initRecyclerView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "placeOrder", "placeOrderModel", "Lcom/foodrunner/model/PlaceOrderModel;", "GetCartAsynTask", "app_debug"})
public final class CartActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String restaurantId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String restaurantName;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String userId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String address;
    @org.jetbrains.annotations.NotNull()
    public com.foodrunner.ui.adapter.PlaceOrderAdapter placeOrderAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.foodrunner.model.MenuModelResponse.Data.MenuData> cart;
    private int totalCost;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Double price;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.foodrunner.model.Food> foodList;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String BASE_URL;
    @org.jetbrains.annotations.NotNull()
    public okhttp3.OkHttpClient.Builder httpClient;
    @org.jetbrains.annotations.NotNull()
    public retrofit2.Retrofit retrofit;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRestaurantId() {
        return null;
    }
    
    public final void setRestaurantId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRestaurantName() {
        return null;
    }
    
    public final void setRestaurantName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserId() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAddress() {
        return null;
    }
    
    public final void setAddress(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.foodrunner.ui.adapter.PlaceOrderAdapter getPlaceOrderAdapter() {
        return null;
    }
    
    public final void setPlaceOrderAdapter(@org.jetbrains.annotations.NotNull()
    com.foodrunner.ui.adapter.PlaceOrderAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.foodrunner.model.MenuModelResponse.Data.MenuData> getCart() {
        return null;
    }
    
    public final void setCart(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.foodrunner.model.MenuModelResponse.Data.MenuData> p0) {
    }
    
    public final int getTotalCost() {
        return 0;
    }
    
    public final void setTotalCost(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getPrice() {
        return null;
    }
    
    public final void setPrice(@org.jetbrains.annotations.Nullable()
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.foodrunner.model.Food> getFoodList() {
        return null;
    }
    
    public final void setFoodList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.foodrunner.model.Food> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBASE_URL() {
        return null;
    }
    
    public final void setBASE_URL(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient.Builder getHttpClient() {
        return null;
    }
    
    public final void setHttpClient(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient.Builder p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    public final void setRetrofit(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void initClicks() {
    }
    
    private final void initRecyclerView() {
    }
    
    private final void getCart() {
    }
    
    private final void placeOrder(com.foodrunner.model.PlaceOrderModel placeOrderModel) {
    }
    
    public CartActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\'\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0010\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/foodrunner/ui/activities/CartActivity$GetCartAsynTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "Lcom/foodrunner/model/MenuModelResponse$Data$MenuData;", "context", "Landroid/content/Context;", "(Lcom/foodrunner/ui/activities/CartActivity;Landroid/content/Context;)V", "dao", "Lcom/foodrunner/db/RoomDao;", "getDao", "()Lcom/foodrunner/db/RoomDao;", "setDao", "(Lcom/foodrunner/db/RoomDao;)V", "doInBackground", "url", "", "([Ljava/lang/Void;)Ljava/util/List;", "onPostExecute", "", "result", "app_debug"})
    public final class GetCartAsynTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<? extends com.foodrunner.model.MenuModelResponse.Data.MenuData>> {
        @org.jetbrains.annotations.NotNull()
        private com.foodrunner.db.RoomDao dao;
        private android.content.Context context;
        
        @org.jetbrains.annotations.NotNull()
        public final com.foodrunner.db.RoomDao getDao() {
            return null;
        }
        
        public final void setDao(@org.jetbrains.annotations.NotNull()
        com.foodrunner.db.RoomDao p0) {
        }
        
        @java.lang.Override()
        protected void onPostExecute(@org.jetbrains.annotations.NotNull()
        java.util.List<com.foodrunner.model.MenuModelResponse.Data.MenuData> result) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        protected java.util.List<com.foodrunner.model.MenuModelResponse.Data.MenuData> doInBackground(@org.jetbrains.annotations.NotNull()
        java.lang.Void... url) {
            return null;
        }
        
        public GetCartAsynTask(@org.jetbrains.annotations.Nullable()
        android.content.Context context) {
            super();
        }
    }
}