package bsu.rfe.java.group6.lab1.Churilo.var3;

public abstract class Food implements Consumable, Nutritious{
    private String name = null;
    protected int numberOfComponents = 0;

    public Food(String name) {
        this.name = name;
    }

    public boolean equals(Object arg0) {
        if (!(arg0 instanceof Food)) return false; // Шаг 1
        if (name==null || ((Food)arg0).name==null) return false; // Шаг 2
        return name.equals(((Food)arg0).name); // Шаг 3
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfComponents(){
        return numberOfComponents;
    }

    public void setName(String name) {
        this.name = name;
    }
}
