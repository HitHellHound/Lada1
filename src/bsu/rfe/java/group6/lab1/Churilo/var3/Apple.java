package bsu.rfe.java.group6.lab1.Churilo.var3;

public class Apple extends Food {
    private String size;

    public Apple(String size){
        super("Яблоко");
        this.size = size;
        numberOfComponents = 1;
    }

    public void consume() {
        System.out.println(this + " съедено");
    }

    public int calculateCalories() {
        if (size.equals("большое"))
            return 150;
        else if(size.equals("малое"))
            return 50;
        return 100;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) { // Шаг 1
            if (!(arg0 instanceof Apple)) return false; // Шаг 2
            return size.equals(((Apple)arg0).size); // Шаг 3
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }
}
