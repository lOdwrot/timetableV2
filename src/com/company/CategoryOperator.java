package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lodwr on 29.10.2015.
 */
public class CategoryOperator {
    Category category;
    public CategoryOperator(Category c){
        System.out.println("Category selected: "+c.getCategoryName());
        this.category=c;
    }
    public void showTasksByPriority()
    {
        ArrayList<Task> lowPriorityTasks = new ArrayList<Task>();
        System.out.println("High priority tasks:");
        for(Task t:category.getTasks()){
            if(t.priority==Priority.LOW)
                lowPriorityTasks.add(t);
            else System.out.println(t.taskName);
        }
        System.out.println("Low priority tasks:");
        for(Task t:lowPriorityTasks){
            System.out.println(t.taskName);
        }
    }
    public boolean deleteTask(String name) {
        if(category.deleteTask(name))
        {
            System.out.println("Zadanie usuniête z listy");
        }else System.out.println("W aktualnej kategorii nie ma takiego zadania");
        return false;
    }
    public void addTask(String tName, Priority priority)
    {
        try {
            category.addTask(tName, priority);
        } catch (TaskDuplicateException e) {
            System.out.println("Zadanie o tej nazwie ju¿ istnieje w zadanej kategorii");
        }
    }
    public void showUncheckedTasks() {
        for (Task t : category.getTasks()) {
            if (!t.checked)
                System.out.println(t.taskName);
        }
    }
    public boolean checkTask(String name) {
            if(category.checkTask(name))
                System.out.println("Zadanie zrobione");
            else System.out.println("Nie odnaleziono takiego zadania w podanej kategorii");
        return false;
    }
    public Category getModifiedCategory(){
        return this.category;
    }
    public String getCategoryName(){return category.getCategoryName();}
}
