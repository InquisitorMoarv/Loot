package com.example.loot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;
import io.realm.RealmResults;

public class UserCreation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_creation);

        //final EditText userId = findViewById(R.id.userId);
        final EditText userName = findViewById(R.id.userName);
        final EditText userGold = findViewById(R.id.userGold);
        Button saveUser = findViewById(R.id.saveUser);

        saveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get a Realm instance for this thread
                Realm realm = Realm.getDefaultInstance();
                // Persist your data in a transaction
                realm.beginTransaction();


                RealmResults<User> realmResults = realm.where(User.class).findAll();


                User newUser = new  User();
                newUser.setUserId(realmResults.size());
                newUser.setUserName(userName.getText().toString());
                newUser.setGold(Integer.parseInt(userGold.getText().toString()));

                //Push to the database
                realm.insertOrUpdate(newUser);
                realm.commitTransaction();
                //Start UserActitty to see new user
                Intent intent = new Intent(view.getContext(), UserActivity.class);
                startActivity(intent);
            }
        });

    }
}
