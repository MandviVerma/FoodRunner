package com.foodrunner.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002\u001a\u001bB/\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/foodrunner/ui/adapter/RestaurantsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/foodrunner/ui/adapter/RestaurantsAdapter$ViewHolder;", "Landroid/widget/Filterable;", "mContext", "Landroid/content/Context;", "restaurants", "Ljava/util/ArrayList;", "Lcom/foodrunner/api/FetchRestaurantDetailResponse$Data$InternalData;", "Lkotlin/collections/ArrayList;", "mListener", "Lcom/foodrunner/ui/adapter/RestaurantsAdapter$OnItemClickListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/foodrunner/ui/adapter/RestaurantsAdapter$OnItemClickListener;)V", "filteredRestaurants", "getFilter", "Landroid/widget/Filter;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnItemClickListener", "ViewHolder", "app_debug"})
public final class RestaurantsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.foodrunner.ui.adapter.RestaurantsAdapter.ViewHolder> implements android.widget.Filterable {
    private java.util.ArrayList<com.foodrunner.api.FetchRestaurantDetailResponse.Data.InternalData> filteredRestaurants;
    private android.content.Context mContext;
    private java.util.ArrayList<com.foodrunner.api.FetchRestaurantDetailResponse.Data.InternalData> restaurants;
    private com.foodrunner.ui.adapter.RestaurantsAdapter.OnItemClickListener mListener;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.foodrunner.ui.adapter.RestaurantsAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.foodrunner.ui.adapter.RestaurantsAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.widget.Filter getFilter() {
        return null;
    }
    
    public RestaurantsAdapter(@org.jetbrains.annotations.Nullable()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.foodrunner.api.FetchRestaurantDetailResponse.Data.InternalData> restaurants, @org.jetbrains.annotations.NotNull()
    com.foodrunner.ui.adapter.RestaurantsAdapter.OnItemClickListener mListener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/foodrunner/ui/adapter/RestaurantsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/foodrunner/ui/adapter/RestaurantsAdapter;Landroid/view/View;)V", "ivFav", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "ivRestaurantImg", "ivShare", "tvName", "Landroid/widget/TextView;", "tvRate", "tvRating", "setData", "", "details", "Lcom/foodrunner/api/FetchRestaurantDetailResponse$Data$InternalData;", "position", "", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView tvName = null;
        private final android.widget.TextView tvRate = null;
        private final android.widget.TextView tvRating = null;
        private final android.widget.ImageView ivRestaurantImg = null;
        private final android.widget.ImageView ivFav = null;
        private final android.widget.ImageView ivShare = null;
        
        public final void setData(@org.jetbrains.annotations.NotNull()
        com.foodrunner.api.FetchRestaurantDetailResponse.Data.InternalData details, int position) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/foodrunner/ui/adapter/RestaurantsAdapter$OnItemClickListener;", "", "onFavClick", "", "position", "", "view", "Landroid/view/View;", "onItemClick", "onShareClick", "app_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onItemClick(int position, @org.jetbrains.annotations.NotNull()
        android.view.View view);
        
        public abstract void onFavClick(int position, @org.jetbrains.annotations.NotNull()
        android.view.View view);
        
        public abstract void onShareClick(int position, @org.jetbrains.annotations.NotNull()
        android.view.View view);
    }
}