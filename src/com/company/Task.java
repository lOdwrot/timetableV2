package com.company;

/**
 * Created by lodwr on 29.10.2015.
 */
public class Task {
    int id;
    public String taskName;
    public Priority priority;
    public boolean checked=false;
    Task(int id, String name, Priority priority)
    {
        this.id=id;
        this.taskName=name;
        this.priority=priority;
    }
    public void check()
    {
        checked=true;
    }
}
