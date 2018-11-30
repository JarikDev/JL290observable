package com;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        Observer observer=new Observer("one");
        Observer observer2=new Observer("two");
        observer.setState("New state");
        observer2.setState("Hello state");
    }
}
interface Observable{
    void update();
}
class Observer implements Observable{
    static List<Observer> observers=new ArrayList<>();
    String name;
    String state;

    public Observer(String name) {
        this.name = name;
        observers.add(this);
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }
    void notifyAllObservers(){
        for (Observer observer:observers) {
            observer.update();
        }
    }

    @Override
    public void update() {
        System.out.println(name+" change status: "+state);
    }
}