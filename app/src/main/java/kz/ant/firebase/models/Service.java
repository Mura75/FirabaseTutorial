package kz.ant.firebase.models;

import java.util.List;

/**
 * Created by Murager on 01.09.2016.
 */
public class Service {

    private String name;

    private int id;

    private List<Master> masterList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Master> getMasterList() {
        return masterList;
    }

    public void setMasterList(List<Master> masterList) {
        this.masterList = masterList;
    }
}
