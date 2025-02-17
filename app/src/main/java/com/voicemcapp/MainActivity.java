package com.voicemcapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText wsUrlInput;
    private Button connectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wsUrlInput = findViewById(R.id.ws_url_input);
        connectButton = findViewById(R.id.connect_button);

        connectButton.setOnClickListener(v -> {
            String serverUrl = wsUrlInput.getText().toString();
            WebSocketService.connectToWebSocket(serverUrl);
        });
    }
}
