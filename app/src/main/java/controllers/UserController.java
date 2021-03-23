package controllers;
import models.User;
public class UserController {


    public static  User store(String name, String password){
        return new User(name, password);
    }






}
