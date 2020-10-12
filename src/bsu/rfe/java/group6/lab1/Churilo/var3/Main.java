package bsu.rfe.java.group6.lab1.Churilo.var3;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Food[] Breakfast = new Food[20];
        int numberOfProducts = 0;

        for (String arg : args) {
            if (arg.equals("-calories")) {
                int cal = 0;
                for (Food item : Breakfast) {
                    if (item != null)
                        cal += item.calculateCalories();
                    else
                        break;
                }
                System.out.println("Калорийность завтрака: " + cal + " калорий");
            }
            else if (arg.equals("-sort")) {
                System.out.println("---------------------------------------------------------------");
                System.out.println("Изначальный порядок:");
                for (Food food: Breakfast) {
                    if (food != null)
                        System.out.println(food.toString());
                    else
                        break;
                }

                Arrays.sort(Breakfast, new Comparator() {
                    public int compare(Object f1, Object f2) {
                        if (f1 == null) return 1;
                        if (f2 == null) return -1;
                        if (((Food)f1).getNumberOfComponents() < ((Food)f2).getNumberOfComponents())
                            return 1;
                        if (((Food)f1).getNumberOfComponents() == ((Food)f2).getNumberOfComponents())
                            return  0;
                        return  -1;
                    }
                });

                System.out.println("Новый порядок:");
                for (Food food: Breakfast) {
                    if (food != null)
                        System.out.println(food.toString());
                    else
                        break;
                }
                System.out.println("---------------------------------------------------------------");
            }
            else {
                String[] parts = arg.split("/");
                try {
                    Class myClass = Class.forName("bsu.rfe.java.group6.lab1.Churilo.var3." + parts[0]);
                    if (parts.length == 1) {
                        Constructor constructor = myClass.getConstructor();
                        Breakfast[numberOfProducts] = (Food) constructor.newInstance();
                    } else if (parts.length == 2) {
                        Constructor constructor = myClass.getConstructor(String.class);
                        Breakfast[numberOfProducts] = (Food) constructor.newInstance(parts[1]);
                    } else if (parts.length == 3) {
                        Constructor constructor = myClass.getConstructor(String.class, String.class);
                        Breakfast[numberOfProducts] = (Food) constructor.newInstance(parts[1], parts[2]);
                    }
                    else{
                        System.out.println("Продукт " + arg + " не может быть включён в завтрак!");
                        continue;
                    }
                    numberOfProducts++;
                } catch (ClassNotFoundException e) {
                    System.out.println("Продукт " + arg + " не может быть включён в завтрак!");
                    continue;
                } catch (NoSuchMethodException e) {
                    System.out.println("Продукт " + arg + " не может быть включён в завтрак!");
                    continue;
                } catch (InstantiationException e) {
                    System.out.println("Продукт " + arg + " не может быть включён в завтрак!");
                    continue;
                } catch (IllegalAccessException e) {
                    System.out.println("Продукт " + arg + " не может быть включён в завтрак!");
                    continue;
                } catch (IllegalArgumentException e) {
                    System.out.println("Продукт " + arg + " не может быть включён в завтрак!");
                    continue;
                } catch (InvocationTargetException e) {
                    System.out.println("Продукт " + arg + " не может быть включён в завтрак!");
                    continue;
                }
            }
        }

        for (Food item: Breakfast){
            if (item != null)
                item.consume();
            else
                break;
        }

        Arrays.sort(Breakfast, new Comparator() {
            public int compare(Object f1, Object f2) {
                if (f1 == null) return 1;
                if (f2 == null) return -1;
                if (((Food)f1).getNumberOfComponents() < ((Food)f2).getNumberOfComponents())
                    return 1;
                if (((Food)f1).getNumberOfComponents() == ((Food)f2).getNumberOfComponents())
                    return  0;
                return  -1;
            }
        });
        System.out.println("В завтраке было: ");
        int numb = 1;
        for (int i = 1; i < numberOfProducts; i++){
            if(Breakfast[i].equals(Breakfast[i - 1]))
                numb++;
            else{
                System.out.println(numb + " - "+ Breakfast[i - 1].toString());
                numb = 1;
            }
        }
        System.out.println(numb + " - " + Breakfast[numberOfProducts - 1].toString());
    }

    public void MealCalories(Food[] food) {
        int cal = 0;
        for (Food item : food){
            if (item != null)
                cal += item.calculateCalories();
            else
                break;
        }
        System.out.println("Калорийность заврака" + cal);
    }

    public void SortFood(Food[] food){

    }

}
