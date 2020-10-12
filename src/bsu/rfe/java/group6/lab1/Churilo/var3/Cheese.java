package bsu.rfe.java.group6.lab1.Churilo.var3;

public class Cheese  extends  Food{
    public Cheese(){
        super("Сыр");
        numberOfComponents = 0;
    }

    public void consume() {
        System.out.println(this + " съеден");
    }

    public int calculateCalories() {
        return 25;
    }
}
