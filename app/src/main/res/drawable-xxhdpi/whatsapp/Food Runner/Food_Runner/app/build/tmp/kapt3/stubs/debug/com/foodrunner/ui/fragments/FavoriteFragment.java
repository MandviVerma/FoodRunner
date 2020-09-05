package com.foodrunner.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00029:B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018H\u0002J\u0012\u0010$\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018H\u0002J\u001e\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0018J*\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001042\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\u0006\u00102\u001a\u00020\u0018R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006;"}, d2 = {"Lcom/foodrunner/ui/fragments/FavoriteFragment;", "Landroidx/fragment/app/Fragment;", "()V", "dao", "Lcom/foodrunner/db/RoomDao;", "getDao", "()Lcom/foodrunner/db/RoomDao;", "setDao", "(Lcom/foodrunner/db/RoomDao;)V", "favoriteList", "", "Lcom/foodrunner/model/FavoriteModel;", "getFavoriteList", "()Ljava/util/List;", "setFavoriteList", "(Ljava/util/List;)V", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "setPrefs", "(Landroid/content/SharedPreferences;)V", "restaurantList", "Ljava/util/ArrayList;", "Lcom/foodrunner/api/FetchRestaurantDetailResponse$Data$InternalData;", "getRestaurantList", "()Ljava/util/ArrayList;", "restaurantsAdapter", "Lcom/foodrunner/ui/adapter/RestaurantsAdapter;", "getRestaurantsAdapter", "()Lcom/foodrunner/ui/adapter/RestaurantsAdapter;", "setRestaurantsAdapter", "(Lcom/foodrunner/ui/adapter/RestaurantsAdapter;)V", "addToDb", "", "restaurantDetail", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "removeFromDb", "sendMessage", "view", "platform", "", "restaurantDetails", "showShareChooser", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "popupWindow", "fragment", "layout", "", "AddFavoriteAsyncTask", "GetFavoriteList", "app_debug"})
public final class FavoriteFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.foodrunner.model.FavoriteModel> favoriteList;
    @org.jetbrains.annotations.NotNull()
    public com.foodrunner.ui.adapter.RestaurantsAdapter restaurantsAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.foodrunner.api.FetchRestaurantDetailResponse.Data.InternalData> restaurantList = null;
    @org.jetbrains.annotations.NotNull()
    public com.foodrunner.db.RoomDao dao;
    @org.jetbrains.annotations.NotNull()
    public android.content.SharedPreferences prefs;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.foodrunner.model.FavoriteModel> getFavoriteList() {
        return null;
    }
    
    public final void setFavoriteList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.foodrunner.model.FavoriteModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.foodrunner.ui.adapter.RestaurantsAdapter getRestaurantsAdapter() {
        return null;
    }
    
    public final void setRestaurantsAdapter(@org.jetbrains.annotations.NotNull()
    com.foodrunner.ui.adapter.RestaurantsAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.foodrunner.api.FetchRestaurantDetailResponse.Data.InternalData> getRestaurantList() {
        return null;
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
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void addToDb(com.foodrunner.api.FetchRestaurantDetailResponse.Data.InternalData restaurantDetail) {
    }
    
    private final void removeFromDb(com.foodrunner.api.FetchRestaurantDetailResponse.Data.InternalData restaurantDetail) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.material.bottomsheet.BottomSheetDialog showShareChooser(@org.jetbrains.annotations.Nullable()
    com.google.android.material.bottomsheet.BottomSheetDialog popupWindow, @org.jetbrains.annotations.NotNull()
    com.foodrunner.ui.fragments.FavoriteFragment fragment, int layout, @org.jetbrains.annotations.NotNull()
    com.foodrunner.api.FetchRestaurantDetailResponse.Data.InternalData restaurantDetails) {
        return null;
    }
    
    public final void sendMessage(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    java.lang.String platform, @org.jetbrains.annotations.NotNull()
    com.foodrunner.api.FetchRestaurantDetailResponse.Data.InternalData restaurantDetails) {
    }
    
    public FavoriteFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ!\u0010\n\u001a\u00020\u00032\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\f\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/foodrunner/ui/fragments/FavoriteFragment$AddFavoriteAsyncTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "Lcom/foodrunner/model/FavoriteModel;", "context", "Landroid/content/Context;", "favoriteModel", "param", "", "(Lcom/foodrunner/ui/fragments/FavoriteFragment;Landroid/content/Context;Lcom/foodrunner/model/FavoriteModel;Ljava/lang/String;)V", "doInBackground", "url", "", "([Ljava/lang/Void;)Lcom/foodrunner/model/FavoriteModel;", "onPostExecute", "", "result", "app_debug"})
    public final class AddFavoriteAsyncTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, com.foodrunner.model.FavoriteModel> {
        private android.content.Context context;
        private com.foodrunner.model.FavoriteModel favoriteModel;
        private java.lang.String param;
        
        @java.lang.Override()
        protected void onPostExecute(@org.jetbrains.annotations.Nullable()
        com.foodrunner.model.FavoriteModel result) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        protected com.foodrunner.model.FavoriteModel doInBackground(@org.jetbrains.annotations.NotNull()
        java.lang.Void... url) {
            return null;
        }
        
        public AddFavoriteAsyncTask(@org.jetbrains.annotations.Nullable()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.foodrunner.model.FavoriteModel favoriteModel, @org.jetbrains.annotations.NotNull()
        java.lang.String param) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\n\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/foodrunner/ui/fragments/FavoriteFragment$GetFavoriteList;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "Lcom/foodrunner/model/FavoriteModel;", "context", "Landroid/content/Context;", "(Lcom/foodrunner/ui/fragments/FavoriteFragment;Landroid/content/Context;)V", "doInBackground", "url", "", "([Ljava/lang/Void;)Ljava/util/List;", "onPostExecute", "", "result", "app_debug"})
    public final class GetFavoriteList extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<? extends com.foodrunner.model.FavoriteModel>> {
        private android.content.Context context;
        
        @java.lang.Override()
        protected void onPostExecute(@org.jetbrains.annotations.NotNull()
        java.util.List<com.foodrunner.model.FavoriteModel> result) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        protected java.util.List<com.foodrunner.model.FavoriteModel> doInBackground(@org.jetbrains.annotations.NotNull()
        java.lang.Void... url) {
            return null;
        }
        
        public GetFavoriteList(@org.jetbrains.annotations.Nullable()
        android.content.Context context) {
            super();
        }
    }
}