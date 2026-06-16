package com.uel.integracaosql.model;

import java.time.LocalDateTime;

@SuppressWarnings("unused")

public class Dataset {


    private int id_datasets;

    private String description;

    private LocalDateTime date_hour;

    private String source;

    private int id_creator;

    public void setId_datasets(int id_datasets){
        this.id_datasets = id_datasets;
    }

    public Integer getId_datasets(){
        return id_datasets;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setDate_hour(LocalDateTime date_hour){
        this.date_hour = date_hour;
    }

    public LocalDateTime getDate_hour(){
        return date_hour;
    }

    public void setSource(String source){
        this.source = source;
    }

    public String getSource(){
        return source;
    }

    public void setId_creator(int id_creator){
        this.id_creator = id_creator;
    }

    public int getId_creator(){
        return id_creator;
    }

}