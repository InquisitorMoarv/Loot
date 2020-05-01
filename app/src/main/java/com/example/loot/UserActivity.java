package com.example.loot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //ReclycerView Code

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(new MyAdapter(new Database().getCities()));
        Realm realm = Realm.getDefaultInstance();

        RealmResults<User> realmResults = realm.where(User.class).findAll();

        List<User> convertusers = new ArrayList<>(); ;
        convertusers.addAll(realmResults);

        recyclerView.setAdapter(new MyAdapter(convertusers));

        FloatingActionButton addButton = findViewById(R.id.fab);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UserCreation.class);
                startActivity(intent);
            }
        });


    }
    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private final List<User> users;

        /*
        private final View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UserDetail.class);
                intent.putExtra("position", (Integer) view.getTag());
                startActivity(intent);
            }
        };
        */

        public MyAdapter(List<User> users) {
            this.users = users;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.name.setText(users.get(position).getUserName());
           // holder.itemView.setTag(position);
           // holder.itemView.setOnClickListener(onClickListener);
        }

        @Override
        public int getItemCount() {
            return users.size();
        }

        class MyViewHolder extends  RecyclerView.ViewHolder{

            private TextView name;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);
            }
        }

    }


}
