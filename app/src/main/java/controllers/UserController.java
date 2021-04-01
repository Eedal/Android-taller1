package controllers;
import models.User;
public class UserController {


    public static  User store(String username,String name, String password, String lastname, String email, String sexo){
        return new User(username,name, password, lastname,email, sexo);
    }






}
