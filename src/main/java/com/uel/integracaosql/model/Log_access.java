package com.uel.integracaosql.model;

import java.time.LocalDateTime;

@SuppressWarnings("unused")

 public class Log_access{

    private int id_log_access;

    private int id_user;

    private int id_current_version;

    private String type_access;

    private LocalDateTime date_access;

    public void setId_log_access(int id_log_access){
        this.id_log_access = id_log_access;
    }

    public Integer getId_log_access(){
        return id_log_access;
    }

    public void setId_user(int id_user){
        this.id_user = id_user;
    }

    public Integer getId_user(){
        return id_user;
    }

    public void setId_current_version(int id_current_version){
        this.id_current_version = id_current_version;
    }

    public Integer getId_current_version(){
        return id_current_version;
    }

    public void setType_access(String type_access){

        if(!"DOWNLOAD".equals(type_access) &&  !"VIEW".equals(type_access)){

            System.out.println("ERROR!! Type of access not supported");

        } else {
            this.type_access = type_access;
        }
    }

    public String getType_access(){
        return type_access;
    }

    public void setDate_access(LocalDateTime date_access){
        this.date_access = date_access;
    }

    public LocalDateTime getDate_access(){
        return date_access;
    }
}