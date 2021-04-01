package controllers;
import models.User;
public class UserController {


    public static  User store(String name, String password, String lastname, String email, String sexo){
        return new User(name, password, lastname,email, sexo);
    }






}
