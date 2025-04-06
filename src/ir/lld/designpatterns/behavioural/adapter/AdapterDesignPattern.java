package ir.lld.designpatterns.behavioural.adapter;

import ir.lld.designpatterns.behavioural.adapter.impl.ChildWeightMachine;
import ir.lld.designpatterns.behavioural.adapter.impl.ChildWeightMachineKg;

public class AdapterDesignPattern {
    public static void main(String arr[]){
        WeightMachine weightMachine = new ChildWeightMachine();

        WeightMachineInKg weightMachineInKg = new ChildWeightMachineKg(weightMachine);

        System.out.println("child weight in kgs: " + weightMachineInKg.getWeightInKg());
    }
}
