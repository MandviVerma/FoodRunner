package com.foodrunner.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001LB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020)H\u0002J\b\u0010D\u001a\u00020BH\u0002J\u0010\u0010E\u001a\u00020B2\u0006\u00102\u001a\u00020\u0004H\u0002J\b\u0010F\u001a\u00020BH\u0002J\b\u0010G\u001a\u00020\u001eH\u0002J\u0012\u0010H\u001a\u00020B2\b\u0010I\u001a\u0004\u0018\u00010JH\u0014J\u0010\u0010K\u001a\u00020B2\u0006\u0010C\u001a\u00020)H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R*\u0010(\u001a\u0012\u0012\u0004\u0012\u00020)0\u0010j\b\u0012\u0004\u0012\u00020)`\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\u00020-X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\u001a\u00105\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR\u001a\u00108\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\u001a\u0010;\u001a\u00020<X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@\u00a8\u0006M"}, d2 = {"Lcom/foodrunner/ui/activities/RestaurantDetailsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "BASE_URL", "", "getBASE_URL", "()Ljava/lang/String;", "setBASE_URL", "(Ljava/lang/String;)V", "dao", "Lcom/foodrunner/db/RoomDao;", "getDao", "()Lcom/foodrunner/db/RoomDao;", "setDao", "(Lcom/foodrunner/db/RoomDao;)V", "foodList", "Ljava/util/ArrayList;", "Lcom/foodrunner/model/Food;", "Lkotlin/collections/ArrayList;", "getFoodList", "()Ljava/util/ArrayList;", "setFoodList", "(Ljava/util/ArrayList;)V", "httpClient", "Lokhttp3/OkHttpClient$Builder;", "getHttpClient", "()Lokhttp3/OkHttpClient$Builder;", "setHttpClient", "(Lokhttp3/OkHttpClient$Builder;)V", "isFav", "", "()Z", "setFav", "(Z)V", "menuAdapter", "Lcom/foodrunner/ui/adapter/MenuAdapter;", "getMenuAdapter", "()Lcom/foodrunner/ui/adapter/MenuAdapter;", "setMenuAdapter", "(Lcom/foodrunner/ui/adapter/MenuAdapter;)V", "menuList", "Lcom/foodrunner/model/MenuModelResponse$Data$MenuData;", "getMenuList", "setMenuList", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "setPrefs", "(Landroid/content/SharedPreferences;)V", "restaurantId", "getRestaurantId", "setRestaurantId", "restaurantImage", "getRestaurantImage", "setRestaurantImage", "restaurantName", "getRestaurantName", "setRestaurantName", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "setRetrofit", "(Lretrofit2/Retrofit;)V", "addToDb", "", "food", "clearCart", "getMenu", "initRecyclerView", "isInternetAvailable", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "removeFromDb", "AddRemoveToCart", "app_debug"})
public final class RestaurantDetailsActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String restaurantId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String restaurantName;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String restaurantImage;
    private boolean isFav;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.foodrunner.model.MenuModelResponse.Data.MenuData> menuList;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.foodrunner.model.Food> foodList;
    @org.jetbrains.annotations.NotNull()
    public com.foodrunner.db.RoomDao dao;
    @org.jetbrains.annotations.NotNull()
    public android.content.SharedPreferences prefs;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String BASE_URL;
    @org.jetbrains.annotations.NotNull()
    public okhttp3.OkHttpClient.Builder httpClient;
    @org.jetbrains.annotations.NotNull()
    public retrofit2.Retrofit retrofit;
    @org.jetbrains.annotations.NotNull()
    public com.foodrunner.ui.adapter.MenuAdapter menuAdapter;
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
    public final java.lang.String getRestaurantImage() {
        return null;
    }
    
    public final void setRestaurantImage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isFav() {
        return false;
    }
    
    public final void setFav(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.foodrunner.model.MenuModelResponse.Data.MenuData> getMenuList() {
        return null;
    }
    
    public final void setMenuList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.foodrunner.model.MenuModelResponse.Data.MenuData> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.foodrunner.model.Food> getFoodList() {
        return null;
    }
    
    public final void setFoodList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.foodrunner.model.Food> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.foodrunner.db.RoomDao getDao() {
        return null;
    }
    
    public final void setDao(@org.jetbrains.annotations.NotNull()
    com.foodrunner.db.RoomDao p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getPrefs() {
        return null;
    }
    
    public final void setPrefs(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final com.foodrunner.ui.adapter.MenuAdapter getMenuAdapter() {
        return null;
    }
    
    public final void setMenuAdapter(@org.jetbrains.annotations.NotNull()
    com.foodrunner.ui.adapter.MenuAdapter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean isInternetAvailable() {
        return false;
    }
    
    private final void clearCart() {
    }
    
    private final void initRecyclerView() {
    }
    
    private final void addToDb(com.foodrunner.model.MenuModelResponse.Data.MenuData food) {
    }
    
    private final void removeFromDb(com.foodrunner.model.MenuModelResponse.Data.MenuData food) {
    }
    
    private final void getMenu(java.lang.String restaurantId) {
    }
    
    public RestaurantDetailsActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ!\u0010\u0010\u001a\u00020\u00032\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0012\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/foodrunner/ui/activities/RestaurantDetailsActivity$AddRemoveToCart;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "Lcom/foodrunner/model/MenuModelResponse$Data$MenuData;", "context", "Landroid/content/Context;", "menuData", "param", "", "(Landroid/content/Context;Lcom/foodrunner/model/MenuModelResponse$Data$MenuData;Ljava/lang/String;)V", "dao", "Lcom/foodrunner/db/RoomDao;", "getDao", "()Lcom/foodrunner/db/RoomDao;", "setDao", "(Lcom/foodrunner/db/RoomDao;)V", "doInBackground", "url", "", "([Ljava/lang/Void;)Lcom/foodrunner/model/MenuModelResponse$Data$MenuData;", "onPostExecute", "", "result", "app_debug"})
    static final class AddRemoveToCart extends android.os.AsyncTask<java.lang.Void, java.lang.Void, com.foodrunner.model.MenuModelResponse.Data.MenuData> {
        @org.jetbrains.annotations.NotNull()
        private com.foodrunner.db.RoomDao dao;
        private android.content.Context context;
        private com.foodrunner.model.MenuModelResponse.Data.MenuData menuData;
        private java.lang.String param;
        
        @org.jetbrains.annotations.NotNull()
        public final com.foodrunner.db.RoomDao getDao() {
            return null;
        }
        
        public final void setDao(@org.jetbrains.annotations.NotNull()
        com.foodrunner.db.RoomDao p0) {
        }
        
        @java.lang.Override()
        protected void onPostExecute(@org.jetbrains.annotations.Nullable()
        com.foodrunner.model.MenuModelResponse.Data.MenuData result) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        protected com.foodrunner.model.MenuModelResponse.Data.MenuData doInBackground(@org.jetbrains.annotations.NotNull()
        java.lang.Void... url) {
            return null;
        }
        
        public AddRemoveToCart(@org.jetbrains.annotations.Nullable()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.foodrunner.model.MenuModelResponse.Data.MenuData menuData, @org.jetbrains.annotations.NotNull()
        java.lang.String param) {
            super();
        }
    }
}