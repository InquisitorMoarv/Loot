package com.example.loot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm realm = Realm.getDefaultInstance(); // opens "myrealm.realm"
        try {
            // ... Do something ...
        } finally {
            realm.close();
        }

        Button userButton = findViewById(R.id.userButton);
        Button masterButton = findViewById(R.id.masterButton);
        Button itemButton = findViewById(R.id.itemButton);

        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UserActivity.class);
                startActivity(intent);
            }
        });
    }
}
