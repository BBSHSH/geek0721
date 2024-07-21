package com.example.geek_07_21;

/**
 * okhtttpclientを使用してhttpリクエストを作成し実行するクラス
 */
// ApiClient.java
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ApiClient {

    private OkHttpClient client;

    public ApiClient() {
        this.client = new OkHttpClient();
    }

    public void sendRequest(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
