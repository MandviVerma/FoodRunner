package com.foodrunner.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00101\u001a\u000202H\u0016J\u0012\u00103\u001a\u0002022\b\u00104\u001a\u0004\u0018\u000105H\u0014J\u0010\u00106\u001a\u0002072\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000202H\u0002J\u0010\u0010<\u001a\u0002022\u0006\u0010=\u001a\u000207H\u0002J\"\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010?2\u0006\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020CR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u0006D"}, d2 = {"Lcom/foodrunner/ui/activities/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "dao", "Lcom/foodrunner/db/RoomDao;", "getDao", "()Lcom/foodrunner/db/RoomDao;", "setDao", "(Lcom/foodrunner/db/RoomDao;)V", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "getDrawerLayout", "()Landroidx/drawerlayout/widget/DrawerLayout;", "setDrawerLayout", "(Landroidx/drawerlayout/widget/DrawerLayout;)V", "fragment", "Lcom/foodrunner/ui/fragments/MainFragment;", "getFragment", "()Lcom/foodrunner/ui/fragments/MainFragment;", "frameLayout", "Landroid/widget/FrameLayout;", "getFrameLayout", "()Landroid/widget/FrameLayout;", "setFrameLayout", "(Landroid/widget/FrameLayout;)V", "menu", "Landroid/view/Menu;", "getMenu", "()Landroid/view/Menu;", "setMenu", "(Landroid/view/Menu;)V", "navigationView", "Lcom/google/android/material/navigation/NavigationView;", "getNavigationView", "()Lcom/google/android/material/navigation/NavigationView;", "setNavigationView", "(Lcom/google/android/material/navigation/NavigationView;)V", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "setPrefs", "(Landroid/content/SharedPreferences;)V", "searchView", "Landroidx/appcompat/widget/SearchView;", "getSearchView", "()Landroidx/appcompat/widget/SearchView;", "setSearchView", "(Landroidx/appcompat/widget/SearchView;)V", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "openMainFragment", "showOptionMenu", "visible", "showSortFilter", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "popupWindow", "activity", "layout", "", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public androidx.appcompat.widget.SearchView searchView;
    @org.jetbrains.annotations.NotNull()
    public androidx.drawerlayout.widget.DrawerLayout drawerLayout;
    @org.jetbrains.annotations.NotNull()
    public android.widget.FrameLayout frameLayout;
    @org.jetbrains.annotations.NotNull()
    public com.google.android.material.navigation.NavigationView navigationView;
    @org.jetbrains.annotations.NotNull()
    private final com.foodrunner.ui.fragments.MainFragment fragment = null;
    @org.jetbrains.annotations.Nullable()
    private android.view.Menu menu;
    @org.jetbrains.annotations.NotNull()
    public com.foodrunner.db.RoomDao dao;
    @org.jetbrains.annotations.NotNull()
    public android.content.SharedPreferences prefs;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.SearchView getSearchView() {
        return null;
    }
    
    public final void setSearchView(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.SearchView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.drawerlayout.widget.DrawerLayout getDrawerLayout() {
        return null;
    }
    
    public final void setDrawerLayout(@org.jetbrains.annotations.NotNull()
    androidx.drawerlayout.widget.DrawerLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.FrameLayout getFrameLayout() {
        return null;
    }
    
    public final void setFrameLayout(@org.jetbrains.annotations.NotNull()
    android.widget.FrameLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.material.navigation.NavigationView getNavigationView() {
        return null;
    }
    
    public final void setNavigationView(@org.jetbrains.annotations.NotNull()
    com.google.android.material.navigation.NavigationView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.foodrunner.ui.fragments.MainFragment getFragment() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.Menu getMenu() {
        return null;
    }
    
    public final void setMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu p0) {
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
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void openMainFragment() {
    }
    
    private final void showOptionMenu(boolean visible) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.material.bottomsheet.BottomSheetDialog showSortFilter(@org.jetbrains.annotations.Nullable()
    com.google.android.material.bottomsheet.BottomSheetDialog popupWindow, @org.jetbrains.annotations.NotNull()
    com.foodrunner.ui.activities.MainActivity activity, int layout) {
        return null;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public MainActivity() {
        super();
    }
}