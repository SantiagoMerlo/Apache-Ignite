package com.blu.imdg;

class Employee {
    private Integer id;
    private String name;

    Employee(Integer id, String name ){
        this.id = id;
        this.name = name;
    }
    public String get(){
        return "ID: "+this.id+" name: "+this.name;
    }
}