package  com.uel.integracaosql.model;

@SuppressWarnings("unused") // silencia  o aviso da IDE de métodos que não estão sendo aplicados. É puramente estético.

// Todos os atributos são privados por questão de segurança
// All atributes are privates for safety

public class Users {

    private int id_users;

    private String name;

    private String email;

    private String password;

    // Getters e Setters

    public void setId_users(Integer user){
        id_users= user;
    }

    public Integer getId_users(){
        return id_users;
    }

    public void setName(String name){
        this.name = name;
    }


    public String getName(){
        return name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

