package com.example.loot;


import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {
    @PrimaryKey @Index
    private long id;

    public String userName;
    public int gold;
    public RealmList<Item> items; // Declare one-to-many relationships

    public User() {
    }

    public User(String userName, int gold, RealmList<Item> items) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<User> realmResults = realm.where(User.class).findAll();

        //this.id = realmResults.size();
        this.userName = userName;
        this.gold = gold;
        this.items = items;
    }

    public long getUserId() {
        return id;
    }

    public void setUserId(int userId) {
        this.id = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public RealmList<Item> getItems() {
        return items;
    }

    public void setItems(RealmList<Item> items) {
        this.items = items;
    }
}
