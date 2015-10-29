package com.company;

import java.util.ArrayList;

/**
 * Created by lodwr on 29.10.2015.
 */
public class Timetable {
    private ArrayList<Category> categories = new ArrayList<Category>();
    public Timetable(){
        loadDefaultCategories();
    }
    private void loadDefaultCategories()
    {
        try {
            addCategory("Dzis");
            addCategory("Jutro");
            addCategory("Pojutrze");
        } catch (NotAllowedValueException e) {
            System.out.println("Taka kategoria ju¿ istnieje");
        }
    }
    public void addCategory(String categoryName) throws NotAllowedValueException{
        for(Category c: categories)
        {
            if(c.getCategoryName().equals(categoryName))
                throw new NotAllowedValueException();
        }
        categories.add(new Category(categoryName));
    }
    public void showCategories() {
        for (Category c: categories)
            System.out.println(c.getCategoryName());
    }
    public Category getCattegory(String name) throws NoExistingCategoryException
    {
        for(Category c: categories)
        {
            if(c.getCategoryName().equals(name))
                return c;
        }
        throw new NoExistingCategoryException();
    }
    public boolean syncCategory(Category mCategory){
        int i=0;
        for(Category c:categories){
            if(c.getCategoryName().equals(mCategory.getCategoryName())) {
                categories.set(i, mCategory);
                return true;
            }
            i++;
        }
        return false;
    }


}
