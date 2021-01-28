package com.cvdnn.net;

import android.log.Log;

import com.google.gson.Gson;

import java.io.File;

import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static java.util.concurrent.TimeUnit.MINUTES;
import static okhttp3.MultipartBody.FORM;

public class NetUtils {
    private static final String TAG = "NetUtils";

    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("application/x-bzip");

    private static final String URL_HTTP = "http://192.168.1.47:8067/api/albums";

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .connectionPool(new ConnectionPool(32, 5, MINUTES))
            .readTimeout(10, MINUTES)
            .writeTimeout(10, MINUTES)
            .callTimeout(20, MINUTES)
            .build();

    public static PanoEntity put(String name, File file) {
        PanoEntity entity = null;

        MultipartBody mpBody = new MultipartBody.Builder()
                .setType(FORM)
                .addFormDataPart("name", name)
                .addFormDataPart("file", file.getName(),
                        RequestBody.create(MEDIA_TYPE_PNG, file))
                .build();

        Request request = new Request.Builder()
                .header("token", "5fd32db69b64364395b96377")
                .url(URL_HTTP)
                .put(mpBody)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                entity = new Gson().fromJson(response.body().string(), PanoEntity.class);
            }
        } catch (Exception e) {
            Log.e(TAG, e);
        }

        return entity;
    }

    public static boolean success(Result rst) {
        return rst != null && rst.succee;
    }
}
