package com.example.tallerunimaguno;

import java.util.ArrayList;

import models.User;

public class GlobalData {
    public static ArrayList<User> Users = new ArrayList();

    public static ArrayList<User> getUsers() {
        return Users;
    }

    public static void setUsers(ArrayList<User> users) {
        Users = users;
    }
}
