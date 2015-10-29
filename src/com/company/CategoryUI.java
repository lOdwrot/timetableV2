package com.company;

import java.util.Scanner;

/**
 * Created by lodwr on 29.10.2015.
 */
public class CategoryUI {
    public static Category startDialog(Category c)
    {
        CategoryOperator mOperator=new CategoryOperator(c);
        Scanner s = new Scanner(System.in);
        String arg1, arg2;
        int choice=0;
        do {
            System.out.println("Modyfikator kategorii "+mOperator.getCategoryName());
            System.out.println("0 - Opusc aktualna kategorie");
            System.out.println("1 - Pokaz liste zadan wedlug waznosci");
            System.out.println("2 - Dodaj zadanie");
            System.out.println("3 - Usun zadanie");
            System.out.println("4 - Oznacz zadanie jako wykonana");
            System.out.println("5 - Pokaz zadania do zrobienia");

            choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1:
                    mOperator.showTasksByPriority();
                    break;
                case 2:
                    System.out.println("Nazwa zadania");
                    arg1=s.nextLine();
                    do {
                        System.out.println("Wazne? y/n" );
                        choice=s.next().charAt(0);
                    }while(!(choice=='y'||choice=='n'));
                    if(choice=='n')
                        mOperator.addTask(arg1, Priority.LOW);
                    if(choice=='y')
                        mOperator.addTask(arg1, Priority.HIGH);
                    break;
                case 3:
                        System.out.println("Ktore zadanie chcesz usunac");
                        arg1=s.nextLine();
                        mOperator.deleteTask(arg1);
                    break;
                case 4:
                    System.out.println("Ktore zadanie wykonano");
                    arg1=s.nextLine();
                    mOperator.checkTask(arg1);
                    break;
                case 5:
                    mOperator.showUncheckedTasks();
                    break;
            }
        } while (choice != 0);

        return mOperator.getModifiedCategory();
    }
}
