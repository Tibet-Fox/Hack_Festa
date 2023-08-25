package com.example.flatload;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\'JH\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u00072$\b\u0001\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\rH\'J>\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00102$\b\u0001\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0012`\rH\'J0\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u001a\b\u0001\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00150\u0004H\'J<\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u00072\b\b\u0001\u0010\u001b\u001a\u00020\u00072\b\b\u0001\u0010\u001c\u001a\u00020\u00072\b\b\u0001\u0010\u001d\u001a\u00020\u0007H\'J8\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00180\u00032\b\b\u0001\u0010\u001f\u001a\u00020\u00072\b\b\u0001\u0010 \u001a\u00020\u00072\b\b\u0001\u0010!\u001a\u00020\u0007H\'\u00a8\u0006\""}, d2 = {"Lcom/example/flatload/FlatAPI;", "", "getJson", "Lretrofit2/Call;", "", "Lcom/example/flatload/ResultGet;", "getResult", "", "getSearchRocal", "id", "pw", "query", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "postImage", "photo", "Lokhttp3/MultipartBody$Part;", "data", "Lokhttp3/RequestBody;", "postJson", "locations", "Lkotlin/Pair;", "", "postMapCoord", "", "Lcom/google/gson/JsonObject;", "one", "two", "three", "four", "postPoint", "start", "destination", "routeOption", "app_debug"})
public abstract interface FlatAPI {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/android/get")
    public abstract retrofit2.Call<java.util.List<com.example.flatload.ResultGet>> getJson();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/android/post")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<java.util.List<com.example.flatload.ResultGet>> postJson(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "locations")
    java.util.List<kotlin.Pair<java.lang.Double, java.lang.Double>> locations);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/android/post/point")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.google.gson.JsonObject[][]> postPoint(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "start")
    java.lang.String start, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "destination")
    java.lang.String destination, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "option")
    java.lang.String routeOption);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/android/post/upload")
    @retrofit2.http.Multipart()
    public abstract retrofit2.Call<java.lang.String> postImage(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    okhttp3.MultipartBody.Part photo, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.PartMap()
    java.util.HashMap<java.lang.String, okhttp3.RequestBody> data);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/android/result")
    public abstract retrofit2.Call<java.lang.String> getResult();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/v1/search/local.json")
    public abstract retrofit2.Call<java.lang.String> getSearchRocal(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "X-Naver-Client-Id")
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "X-Naver-Client-Secret")
    java.lang.String pw, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap()
    java.util.HashMap<java.lang.String, java.lang.String> query);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/android/post/map/coordinate")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.google.gson.JsonObject[]> postMapCoord(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "one")
    java.lang.String one, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "two")
    java.lang.String two, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "three")
    java.lang.String three, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "four")
    java.lang.String four);
}