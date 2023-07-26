package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.google.firebase.messaging.FirebaseMessaging;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText=findViewById(R.id.edit);

        // Get the FCM token
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        String token = task.getResult();
                        // Now you can send this token to your server to target this device for notifications
                        Log.d("FCM_TOKEN", token);
                        editText.setText(token);
                    } else {
                        Log.e("FCM_TOKEN", "Failed to get FCM token");
                    }
                });
    }
}
