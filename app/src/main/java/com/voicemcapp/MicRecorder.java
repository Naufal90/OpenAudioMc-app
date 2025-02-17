package com.voicemcapp;

import android.media.MediaRecorder;
import android.util.Log;

import java.io.IOException;

public class MicRecorder {
    private MediaRecorder recorder;

    public void startRecording() {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile("/dev/null");  // Hanya untuk contoh, ganti dengan penyimpanan yang diinginkan

        try {
            recorder.prepare();
            recorder.start();
            Log.d("MicRecorder", "Recording started.");
        } catch (IOException e) {
            Log.e("MicRecorder", "Recording failed: " + e.getMessage());
        }
    }

    public void stopRecording() {
        if (recorder != null) {
            recorder.stop();
            recorder.release();
            Log.d("MicRecorder", "Recording stopped.");
        }
    }
}
