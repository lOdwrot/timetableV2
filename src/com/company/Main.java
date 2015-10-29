package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Timetable tt = new Timetable();
        Scanner s = new Scanner(System.in);

        String arg1,arg2;
        int c;

        do {
            System.out.println("Co chcesz zrobic");
            System.out.println("0 - EXIT");
            System.out.println("1 - Zobacz dostepne kategorie");
            System.out.println("2 - Dodaj kategorie");
            System.out.println("3 - Otwórz kategorie");

            c = s.nextInt();
            s.nextLine();
            switch (c) {
                case 1:
                    tt.showCategories();
                    break;
                case 2:
                    System.out.println("Podaj nazwe nowej kategorii");
                    arg1=s.nextLine();
                    try {
                        tt.addCategory(arg1);
                    } catch (NotAllowedValueException e) {
                        System.out.println("Kategoria juz istnieje!");
                    }
                    break;
                case 3:
                    System.out.println("Podaj nazwe kategorii:");
                    //Category c = tt.getCattegory(s.nextLine());
                    String openC = s.nextLine();
                    try {
                        tt.syncCategory(CategoryUI.startDialog( tt.getCattegory(openC)));
                    } catch (NoExistingCategoryException e) {
                        do {
                            System.out.println("Taka kategoria nie istnieje, chcesz ja utworzyc? y/n" );
                            c=s.next().charAt(0);
                            if(c=='y')
                                try {
                                    tt.addCategory(openC);
                                } catch (NotAllowedValueException e1) {
                                }
                        }while(!(c=='y'||c=='n'));
                    }
                    break;
            }
        } while (c != 0);
    }

}
