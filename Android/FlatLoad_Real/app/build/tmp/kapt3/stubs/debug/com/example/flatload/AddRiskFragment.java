package com.example.flatload;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [AddRiskFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\n\u0018\u0000 q2\u00020\u0001:\u0003qrsB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010<\u001a\u00020=H\u0002J!\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040?2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040,H\u0002\u00a2\u0006\u0002\u0010AJ\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040?2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00040?H\u0002J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0004H\u0002J\b\u0010G\u001a\u00020$H\u0002J\b\u0010H\u001a\u00020=H\u0003J\u0012\u0010I\u001a\u0004\u0018\u00010J2\u0006\u00103\u001a\u000204H\u0002J\u0018\u0010K\u001a\u00020=2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u000204H\u0002J\b\u0010N\u001a\u00020=H\u0002J\'\u0010O\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020E0P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00040,H\u0002\u00a2\u0006\u0002\u0010RJ\u0010\u0010S\u001a\u00020=2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u001a\u0010T\u001a\u0004\u0018\u00010\u00042\u0006\u0010U\u001a\u00020\u00042\u0006\u0010V\u001a\u00020WH\u0002J\b\u0010X\u001a\u00020\u0004H\u0002J\b\u0010Y\u001a\u00020=H\u0002J\"\u0010Z\u001a\u00020=2\u0006\u0010[\u001a\u00020\f2\u0006\u0010\\\u001a\u00020\f2\b\u0010]\u001a\u0004\u0018\u00010^H\u0017J\u0012\u0010_\u001a\u00020=2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J&\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020e2\b\u0010f\u001a\u0004\u0018\u00010g2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J-\u0010h\u001a\u00020=2\u0006\u0010[\u001a\u00020\f2\u000e\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040,2\u0006\u0010i\u001a\u00020jH\u0016\u00a2\u0006\u0002\u0010kJ\u001a\u0010l\u001a\u00020=2\u0006\u0010m\u001a\u00020c2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u000e\u0010n\u001a\u00020=2\u0006\u0010M\u001a\u000204J\u001e\u0010o\u001a\u0010\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020E\u0018\u00010P2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010p\u001a\u00020=2\u0006\u0010L\u001a\u00020$H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040,X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00102\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000204X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u000204X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u00106\"\u0004\b;\u00108\u00a8\u0006t"}, d2 = {"Lcom/example/flatload/AddRiskFragment;", "Landroidx/fragment/app/Fragment;", "()V", "BASE_URL_FLAT_API", "", "getBASE_URL_FLAT_API", "()Ljava/lang/String;", "absolutepath", "getAbsolutepath", "setAbsolutepath", "(Ljava/lang/String;)V", "compressQuality", "", "getCompressQuality", "()I", "setCompressQuality", "(I)V", "finalData", "Lcom/example/flatload/AddRiskFragment$photo;", "getFinalData", "()Lcom/example/flatload/AddRiskFragment$photo;", "setFinalData", "(Lcom/example/flatload/AddRiskFragment$photo;)V", "locFinal", "Lcom/google/android/gms/maps/model/LatLng;", "getLocFinal", "()Lcom/google/android/gms/maps/model/LatLng;", "setLocFinal", "(Lcom/google/android/gms/maps/model/LatLng;)V", "mediaimage", "Lcom/example/flatload/AddRiskFragment$mediaImage;", "getMediaimage", "()Lcom/example/flatload/AddRiskFragment$mediaImage;", "setMediaimage", "(Lcom/example/flatload/AddRiskFragment$mediaImage;)V", "newFile", "Ljava/io/File;", "getNewFile", "()Ljava/io/File;", "setNewFile", "(Ljava/io/File;)V", "param1", "param2", "permissions", "", "getPermissions", "()[Ljava/lang/String;", "setPermissions", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "photoFile", "photoUri", "Landroid/net/Uri;", "getPhotoUri", "()Landroid/net/Uri;", "setPhotoUri", "(Landroid/net/Uri;)V", "providerUri", "getProviderUri", "setProviderUri", "captureCamera", "", "checkPermision", "Ljava/util/ArrayList;", "permissionForCheck", "([Ljava/lang/String;)Ljava/util/ArrayList;", "checkRequest", "tmpPermission", "convertToDegree", "", "stringDMS", "createImageFile", "getAbsolutePath", "getBitmapImage", "Landroid/graphics/Bitmap;", "getFileResize", "file", "uri", "getImage", "getLatLng", "Lkotlin/Pair;", "gpsValue", "([Ljava/lang/String;)Lkotlin/Pair;", "getMetaData", "getTagString", "tag", "exif", "Landroid/media/ExifInterface;", "getType", "initCamera", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onRequestPermissionsResult", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", "view", "setImageView", "showExif", "testRetrofit", "Companion", "mediaImage", "photo", "app_debug"})
public final class AddRiskFragment extends androidx.fragment.app.Fragment {
    private java.lang.String param1;
    private java.lang.String param2;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String BASE_URL_FLAT_API = "http://13.125.210.178:8080";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String[] permissions = {"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    private int compressQuality = 100;
    private java.io.File photoFile;
    public android.net.Uri providerUri;
    public android.net.Uri photoUri;
    public com.example.flatload.AddRiskFragment.photo finalData;
    public com.example.flatload.AddRiskFragment.mediaImage mediaimage;
    public java.io.File newFile;
    public java.lang.String absolutepath;
    public com.google.android.gms.maps.model.LatLng locFinal;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.flatload.AddRiskFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public AddRiskFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBASE_URL_FLAT_API() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getPermissions() {
        return null;
    }
    
    public final void setPermissions(@org.jetbrains.annotations.NotNull()
    java.lang.String[] p0) {
    }
    
    public final int getCompressQuality() {
        return 0;
    }
    
    public final void setCompressQuality(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.Uri getProviderUri() {
        return null;
    }
    
    public final void setProviderUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.Uri getPhotoUri() {
        return null;
    }
    
    public final void setPhotoUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.flatload.AddRiskFragment.photo getFinalData() {
        return null;
    }
    
    public final void setFinalData(@org.jetbrains.annotations.NotNull()
    com.example.flatload.AddRiskFragment.photo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.flatload.AddRiskFragment.mediaImage getMediaimage() {
        return null;
    }
    
    public final void setMediaimage(@org.jetbrains.annotations.NotNull()
    com.example.flatload.AddRiskFragment.mediaImage p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File getNewFile() {
        return null;
    }
    
    public final void setNewFile(@org.jetbrains.annotations.NotNull()
    java.io.File p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAbsolutepath() {
        return null;
    }
    
    public final void setAbsolutepath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.maps.model.LatLng getLocFinal() {
        return null;
    }
    
    public final void setLocFinal(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.LatLng p0) {
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
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.example.flatload.AddRiskFragment newInstance(@org.jetbrains.annotations.NotNull()
    java.lang.String param1, @org.jetbrains.annotations.NotNull()
    java.lang.String param2) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final java.lang.String getType() {
        return null;
    }
    
    public final void setImageView(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
    }
    
    private final void getImage() {
    }
    
    private final java.io.File createImageFile() {
        return null;
    }
    
    private final void testRetrofit(java.io.File file) {
    }
    
    private final void captureCamera() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.Q)
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.Q)
    private final void getAbsolutePath() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.Q)
    public final void getMetaData(@org.jetbrains.annotations.NotNull()
    java.lang.String absolutepath) {
    }
    
    private final java.lang.String getTagString(java.lang.String tag, android.media.ExifInterface exif) {
        return null;
    }
    
    private final kotlin.Pair<java.lang.Float, java.lang.Float> showExif(android.media.ExifInterface exif) {
        return null;
    }
    
    private final kotlin.Pair<java.lang.Float, java.lang.Float> getLatLng(java.lang.String[] gpsValue) {
        return null;
    }
    
    private final float convertToDegree(java.lang.String stringDMS) {
        return 0.0F;
    }
    
    private final android.graphics.Bitmap getBitmapImage(android.net.Uri photoUri) {
        return null;
    }
    
    private final void getFileResize(java.io.File file, android.net.Uri uri) {
    }
    
    private final void initCamera() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final java.util.ArrayList<java.lang.String> checkPermision(java.lang.String[] permissionForCheck) {
        return null;
    }
    
    private final java.util.ArrayList<java.lang.String> checkRequest(java.util.ArrayList<java.lang.String> tmpPermission) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/example/flatload/AddRiskFragment$photo;", "", "uri", "Landroid/net/Uri;", "type", "", "location", "feature", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFeature", "()Ljava/lang/String;", "getLocation", "getType", "getUri", "()Landroid/net/Uri;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class photo {
        @org.jetbrains.annotations.NotNull()
        private final android.net.Uri uri = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String type = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String location = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String feature = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.flatload.AddRiskFragment.photo copy(@org.jetbrains.annotations.NotNull()
        android.net.Uri uri, @org.jetbrains.annotations.NotNull()
        java.lang.String type, @org.jetbrains.annotations.NotNull()
        java.lang.String location, @org.jetbrains.annotations.NotNull()
        java.lang.String feature) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public photo(@org.jetbrains.annotations.NotNull()
        android.net.Uri uri, @org.jetbrains.annotations.NotNull()
        java.lang.String type, @org.jetbrains.annotations.NotNull()
        java.lang.String location, @org.jetbrains.annotations.NotNull()
        java.lang.String feature) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.net.Uri component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.net.Uri getUri() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLocation() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFeature() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/example/flatload/AddRiskFragment$mediaImage;", "", "id", "", "displayName", "", "relativePath", "(JLjava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getId", "()J", "getRelativePath", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class mediaImage {
        private final long id = 0L;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String displayName = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String relativePath = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.flatload.AddRiskFragment.mediaImage copy(long id, @org.jetbrains.annotations.NotNull()
        java.lang.String displayName, @org.jetbrains.annotations.NotNull()
        java.lang.String relativePath) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public mediaImage(long id, @org.jetbrains.annotations.NotNull()
        java.lang.String displayName, @org.jetbrains.annotations.NotNull()
        java.lang.String relativePath) {
            super();
        }
        
        public final long component1() {
            return 0L;
        }
        
        public final long getId() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDisplayName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getRelativePath() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/flatload/AddRiskFragment$Companion;", "", "()V", "newInstance", "Lcom/example/flatload/AddRiskFragment;", "param1", "", "param2", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.example.flatload.AddRiskFragment newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String param1, @org.jetbrains.annotations.NotNull()
        java.lang.String param2) {
            return null;
        }
    }
}