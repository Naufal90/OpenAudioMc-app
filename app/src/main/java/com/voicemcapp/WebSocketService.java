package com.voicemcapp;

import okhttp3.*;
import android.util.Log;

public class WebSocketService {
    private static OkHttpClient client = new OkHttpClient();
    private static WebSocket webSocket;

    public static void connectToWebSocket(String url) {
        Request request = new Request.Builder().url(url).build();
        
        webSocket = client.newWebSocket(request, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                Log.d("WebSocket", "Connection opened.");
                // Kirim pesan untuk bergabung ke server atau melakukan autentikasi jika diperlukan
                webSocket.send("{\"type\":\"join\",\"room\":\"gameRoom\"}");
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                Log.d("WebSocket", "Message received: " + text);
                // Proses pesan dari server di sini
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                Log.e("WebSocket", "Error occurred: " + t.getMessage());
            }
        });
    }

    public static void sendMessage(String message) {
        if (webSocket != null && webSocket.send(message)) {
            Log.d("WebSocket", "Message sent: " + message);
        } else {
            Log.e("WebSocket", "Failed to send message.");
        }
    }
}
