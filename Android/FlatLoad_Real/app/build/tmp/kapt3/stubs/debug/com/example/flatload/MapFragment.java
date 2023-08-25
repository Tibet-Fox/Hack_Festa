package com.example.flatload;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [MapFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u0081\u00012\u00020\u00012\u00020\u0002:\u0002\u0081\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020NH\u0002J0\u0010P\u001a\u00020N2\u0006\u0010Q\u001a\u00020N2\u0006\u0010R\u001a\u00020N2\u0006\u0010S\u001a\u00020N2\u0006\u0010T\u001a\u00020N2\u0006\u0010U\u001a\u00020\u0005H\u0002J\u0012\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J&\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\b\u0010`\u001a\u00020WH\u0016J\b\u0010a\u001a\u00020WH\u0016J\u0010\u0010b\u001a\u00020W2\u0006\u0010c\u001a\u000204H\u0016J\b\u0010d\u001a\u00020WH\u0016J+\u0010e\u001a\u00020W2\u0006\u0010f\u001a\u00020\t2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00050h2\u0006\u0010i\u001a\u00020jH\u0016\u00a2\u0006\u0002\u0010kJ\b\u0010l\u001a\u00020WH\u0016J\u0010\u0010m\u001a\u00020W2\u0006\u0010n\u001a\u00020YH\u0016J\b\u0010o\u001a\u00020WH\u0016J\b\u0010p\u001a\u00020WH\u0016J\u001a\u0010q\u001a\u00020W2\u0006\u0010r\u001a\u00020[2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u001b\u0010s\u001a\u00020W2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020u0hH\u0002\u00a2\u0006\u0002\u0010vJ!\u0010w\u001a\u00020W2\u0012\u0010x\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020u0h0hH\u0002\u00a2\u0006\u0002\u0010yJ\u0010\u0010z\u001a\u00020N2\u0006\u0010{\u001a\u00020NH\u0002J)\u0010|\u001a\u00020W2\u0006\u0010}\u001a\u00020\u00142\u0006\u0010~\u001a\u00020\u00142\u0006\u0010\u007f\u001a\u00020\u00142\u0007\u0010\u0080\u0001\u001a\u00020\u0014H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R \u0010+\u001a\b\u0012\u0004\u0012\u00020,0%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R\u000e\u0010/\u001a\u000200X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082.\u00a2\u0006\u0002\n\u0000R\u0019\u00105\u001a\n \u001b*\u0004\u0018\u00010606\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0010\u00109\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010;\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010!\"\u0004\b=\u0010#R\u001b\u0010>\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\b@\u0010AR\u001a\u0010D\u001a\u00020EX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020EX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010G\"\u0004\bL\u0010I\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/example/flatload/MapFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/naver/maps/map/OnMapReadyCallback;", "()V", "BASE_URL_FLAT_API", "", "getBASE_URL_FLAT_API", "()Ljava/lang/String;", "DISTANCE_BETWEEN_LOCATION_OBSTACLE", "", "getDISTANCE_BETWEEN_LOCATION_OBSTACLE", "()I", "DISTANCE_BETWEEN_LOCATION_PLACE", "getDISTANCE_BETWEEN_LOCATION_PLACE", "LOCATION_PERMISSION_REQUEST_CODE", "ROADVIEWINFO_INDEX", "getROADVIEWINFO_INDEX", "setROADVIEWINFO_INDEX", "(I)V", "cameraLatLng", "Lcom/naver/maps/geometry/LatLng;", "circle", "Lcom/naver/maps/map/overlay/CircleOverlay;", "getCircle", "()Lcom/naver/maps/map/overlay/CircleOverlay;", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "latlngList", "", "getLatlngList", "()Ljava/util/List;", "setLatlngList", "(Ljava/util/List;)V", "list_DatabaseInfo", "Ljava/util/ArrayList;", "Lcom/example/flatload/DatabaseInfo;", "getList_DatabaseInfo", "()Ljava/util/ArrayList;", "setList_DatabaseInfo", "(Ljava/util/ArrayList;)V", "list_RoadviewInfo", "Lcom/example/flatload/RoadviewInfo;", "getList_RoadviewInfo", "setList_RoadviewInfo", "locationSource", "Lcom/naver/maps/map/util/FusedLocationSource;", "mapView", "Lcom/naver/maps/map/MapView;", "naverMap", "Lcom/naver/maps/map/NaverMap;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "param1", "param2", "pointList", "getPointList", "setPointList", "sharedViewModel", "Lcom/example/flatload/SharedViewModel;", "getSharedViewModel", "()Lcom/example/flatload/SharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "ttsDest", "", "getTtsDest", "()Z", "setTtsDest", "(Z)V", "ttsStart", "getTtsStart", "setTtsStart", "deg2rad", "", "deg", "distance", "lat1", "lon1", "lat2", "lon2", "unit", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onLowMemory", "onMapReady", "p0", "onPause", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onViewCreated", "view", "parseRouteJson", "route", "Lcom/google/gson/JsonObject;", "([Lcom/google/gson/JsonObject;)V", "parsingInfo", "result", "([[Lcom/google/gson/JsonObject;)V", "rad2deg", "rad", "sendToServerMapCoord", "oneLatLng", "twoLatLng", "threeLatLng", "fourLatLng", "Companion", "app_debug"})
public final class MapFragment extends androidx.fragment.app.Fragment implements com.naver.maps.map.OnMapReadyCallback {
    private java.lang.String param1;
    private java.lang.String param2;
    private com.naver.maps.map.NaverMap naverMap;
    private com.naver.maps.map.MapView mapView;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.naver.maps.geometry.LatLng> latlngList;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.naver.maps.geometry.LatLng> pointList;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.flatload.RoadviewInfo> list_RoadviewInfo;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.flatload.DatabaseInfo> list_DatabaseInfo;
    @org.jetbrains.annotations.NotNull()
    private final com.naver.maps.map.overlay.CircleOverlay circle = null;
    private int ROADVIEWINFO_INDEX = 0;
    private final int DISTANCE_BETWEEN_LOCATION_OBSTACLE = 3;
    private final int DISTANCE_BETWEEN_LOCATION_PLACE = 7;
    private boolean ttsStart = false;
    private boolean ttsDest = false;
    private final okhttp3.OkHttpClient okHttpClient = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String BASE_URL_FLAT_API = "http://13.125.253.43:8080/";
    private final com.google.gson.Gson gson = null;
    private final kotlin.Lazy sharedViewModel$delegate = null;
    private com.naver.maps.geometry.LatLng cameraLatLng;
    private final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private com.naver.maps.map.util.FusedLocationSource locationSource;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.flatload.MapFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public MapFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.naver.maps.geometry.LatLng> getLatlngList() {
        return null;
    }
    
    public final void setLatlngList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.naver.maps.geometry.LatLng> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.naver.maps.geometry.LatLng> getPointList() {
        return null;
    }
    
    public final void setPointList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.naver.maps.geometry.LatLng> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.flatload.RoadviewInfo> getList_RoadviewInfo() {
        return null;
    }
    
    public final void setList_RoadviewInfo(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.flatload.RoadviewInfo> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.flatload.DatabaseInfo> getList_DatabaseInfo() {
        return null;
    }
    
    public final void setList_DatabaseInfo(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.flatload.DatabaseInfo> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.naver.maps.map.overlay.CircleOverlay getCircle() {
        return null;
    }
    
    public final int getROADVIEWINFO_INDEX() {
        return 0;
    }
    
    public final void setROADVIEWINFO_INDEX(int p0) {
    }
    
    public final int getDISTANCE_BETWEEN_LOCATION_OBSTACLE() {
        return 0;
    }
    
    public final int getDISTANCE_BETWEEN_LOCATION_PLACE() {
        return 0;
    }
    
    public final boolean getTtsStart() {
        return false;
    }
    
    public final void setTtsStart(boolean p0) {
    }
    
    public final boolean getTtsDest() {
        return false;
    }
    
    public final void setTtsDest(boolean p0) {
    }
    
    public final okhttp3.OkHttpClient getOkHttpClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBASE_URL_FLAT_API() {
        return null;
    }
    
    public final com.google.gson.Gson getGson() {
        return null;
    }
    
    private final com.example.flatload.SharedViewModel getSharedViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.naver.maps.map.NaverMap p0) {
    }
    
    private final double distance(double lat1, double lon1, double lat2, double lon2, java.lang.String unit) {
        return 0.0;
    }
    
    private final double deg2rad(double deg) {
        return 0.0;
    }
    
    private final double rad2deg(double rad) {
        return 0.0;
    }
    
    private final void sendToServerMapCoord(com.naver.maps.geometry.LatLng oneLatLng, com.naver.maps.geometry.LatLng twoLatLng, com.naver.maps.geometry.LatLng threeLatLng, com.naver.maps.geometry.LatLng fourLatLng) {
    }
    
    private final void parsingInfo(com.google.gson.JsonObject[][] result) {
    }
    
    private final void parseRouteJson(com.google.gson.JsonObject[] route) {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void onLowMemory() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.naver.maps.map.MapFragment newInstance(@org.jetbrains.annotations.NotNull()
    java.lang.String param1, @org.jetbrains.annotations.NotNull()
    java.lang.String param2) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/flatload/MapFragment$Companion;", "", "()V", "newInstance", "Lcom/naver/maps/map/MapFragment;", "param1", "", "param2", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.naver.maps.map.MapFragment newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String param1, @org.jetbrains.annotations.NotNull()
        java.lang.String param2) {
            return null;
        }
    }
}