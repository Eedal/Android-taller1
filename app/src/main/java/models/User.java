package models;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String sexo;

    public User(String name, String password, String lastname, String email, String sexo) {
        this.name = name;
        this.lastname=lastname;
        this.email=email;
        this.password = password;
        this.sexo= sexo;
    }



    public User(){
        this.name = "";
        this.lastname="";
        this.email="";
        this.password = "";
        this.sexo= "";
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
