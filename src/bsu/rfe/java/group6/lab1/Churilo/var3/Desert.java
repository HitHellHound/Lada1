package bsu.rfe.java.group6.lab1.Churilo.var3;

public class Desert extends Food{
    String component1;
    String component2;

    public Desert(String component_1, String component_2){
        super("Десертъ");
        this.component1 = component_1;
        this.component2 = component_2;
        numberOfComponents = 2;
    }

    public void consume() {
        System.out.println(this + "съеден");
    }

    public int calculateCalories(){
        int cal = 0;

        if (component1.equals("булочка"))
            cal += 200;
        else if (component1.equals("печенье"))
            cal += 100;
        else if (component1.equals("конверт"))
            cal += 50;
        else cal += 25;

        if (component2.equals("булочка"))
            cal += 200;
        else if (component2.equals("печенье"))
            cal += 100;
        else if (component2.equals("конверт"))
            cal += 50;
        else cal += 25;

        return cal;
    }

    public String getFirstComponent(){
        return component1;
    }

    public void setFirstComponent(String component_1){
        this.component1 = component_1;
    }

    public String getSecondComponent(){
        return component2;
    }

    public void setSecondComponent(String component_2){
        this.component2 = component_2;
    }

    public boolean equals(Object arg){
        if (super.equals(arg)){
            if (!(arg instanceof Desert))
                return false;
            return component1.equals(((Desert)arg).component1) && component2.equals((((Desert) arg).component2)) ||
                    component1.equals(((Desert)arg).component2) && component2.equals((((Desert) arg).component1));
        } else
            return false;
    }

    public String toString(){
        return super.toString() + " состоящий из " + component1 + " и " + component2;
    }
}
