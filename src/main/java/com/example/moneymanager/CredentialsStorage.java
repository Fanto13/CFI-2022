package com.example.moneymanager;

import java.util.HashMap;
import java.util.Map;

public class CredentialsStorage {

    public void connect() {};
    public boolean checkCredential(String username, String password) {
        Map<String, Integer> db = new HashMap<>();
        db.put("admin", "admin".hashCode());
        db.put("user", "user".hashCode());

        if (!db.containsKey(username)) return false;
        if (db.get(username) != password.hashCode()) return false;
        return true;
    }
}
