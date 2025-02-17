package com.voicemcapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.View;
import android.widget.Button;

public class FloatingWindowService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Menggunakan LayoutInflater untuk menginflasi layout floating window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View floatingView = inflater.inflate(R.layout.floating_window_layout, null);

        // Menambahkan floating window ke window manager
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                android.graphics.PixelFormat.TRANSLUCENT);

        wm.addView(floatingView, params);

        // Tombol untuk menutup floating window
        Button closeButton = floatingView.findViewById(R.id.close_button);
        closeButton.setOnClickListener(v -> stopSelf());  // Stop service dan hapus window

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
