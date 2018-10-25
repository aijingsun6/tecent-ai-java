package org.alking.tecent.ai.util;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;

public class HttpUtil {

    private static final OkHttpClient.Builder builder = new OkHttpClient.Builder();

    public static String doGetString(final String url) throws IOException {
        OkHttpClient okHttpClient = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        if (response.isSuccessful()) {
            ResponseBody body = response.body();
            if (body != null) {
                return body.string();
            }
        }

        return null;
    }

    public static byte[] doGetBytes(String url) throws IOException {
        OkHttpClient okHttpClient = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        if (response.isSuccessful()) {
            ResponseBody body = response.body();
            if (body != null) {
                return body.bytes();
            }
        }

        return null;
    }

    public static String doPostFormString(String url, Map<String, String> form) throws IOException {

        FormBody.Builder formBuilder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : form.entrySet()) {
            formBuilder.add(entry.getKey(), entry.getValue());
        }
        OkHttpClient okHttpClient = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBuilder.build())
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        if (response.isSuccessful()) {
            ResponseBody body = response.body();
            if (body != null) {
                return body.string();
            }
        }
        return null;
    }
}
