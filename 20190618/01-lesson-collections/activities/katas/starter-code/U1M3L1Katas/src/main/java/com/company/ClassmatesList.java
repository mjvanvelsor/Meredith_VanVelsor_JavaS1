package com.company;

import java.util.ArrayList;
import java.util.List;

public class ClassmatesList {

    private List<Classmate> classmateList = new ArrayList<>();

    public void add(Classmate classmate){
        classmateList.add(classmate);
    }

    public Classmate get(int classIndex){
        return classmateList.get(classIndex);
    }

    public List<Classmate> getAll() {
        return classmateList;
    }
}
