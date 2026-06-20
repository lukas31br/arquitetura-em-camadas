package com.uel.integracaosql.model;

import java.time.LocalDateTime;

@SuppressWarnings("unused")

public class Version {

    private int id_version;

    private int id_dataset;

    private int id_creator;

    private int id_version_base;

    private LocalDateTime creation_date;

    private String archive_path;

    private String changes;

    public void setId_version(int id_version){
        this.id_version = id_version;
    }

    public Integer getId_version(){
        return id_version;
    }

    public void setId_dataset(int id_dataset){
        this.id_dataset = id_dataset;
    }

    public Integer getId_dataset(){
        return id_dataset;
    }

    public void setId_version_base(int id_version_base){
        this.id_version_base = id_version_base;
    }

    public Integer getId_version_base(){
        return id_version_base;
    }

    public void setId_creator(int id_creator){
        this.id_creator = id_creator;
    }

    public Integer getId_creator(){
        return id_creator;
    }

    public void setArchive_path(String archive_path){
        this.archive_path = archive_path;
    }

    public String getArchive_path(){
        return archive_path;
    }

    public void setChanges(String changes){
        this.changes = changes;
    }

    public String getChanges(){
        return changes;
    }

    public LocalDateTime getCreation_date(){
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date){
        this.creation_date = creation_date;
    }
}