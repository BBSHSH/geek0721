package com.example.geek_07_21;

/**
 * apiの送受信をするためのクラスファイル
 * 使用するためにはbuild.grade(app)にimplementation(libs.okhttp)の依存関係を設定する
 * libs.versionsに以下の設定を追加する
 *[versions]
 * okhttp = "4.9.1"
 * [libraries]
 * okhttp = { group = "com.squareup.okhttp3", name = "okhttp", version.ref = "okhttp" }
 */
// ApiManager.java
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ApiManager {

    private ApiClient apiClient;

    public ApiManager() {
        this.apiClient = new ApiClient();
    }

    // POST リクエストを送信するメソッド
    public void sendPostRequest(String baseUrl, String endpoint, RequestBody requestBody, Callback callback) {
        String url = baseUrl + "/" + endpoint;
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        apiClient.sendRequest(url, callback);
    }

    // GET リクエストを送信するメソッド
    public void sendGetRequest(String baseUrl, String endpoint, HttpUrl.Builder urlBuilder, Callback callback) {
        String url = urlBuilder
                .scheme("http")
                .host(baseUrl)
                .addPathSegment(endpoint)
                .build()
                .toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        apiClient.sendRequest(url, callback);
    }
}



