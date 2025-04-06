package ir.lld.designpatterns.behavioural.adapter.impl;

import ir.lld.designpatterns.behavioural.adapter.WeightMachine;
import ir.lld.designpatterns.behavioural.adapter.WeightMachineInKg;

import java.util.ArrayDeque;
import java.util.Collections;

public class ChildWeightMachineKg implements WeightMachineInKg {

    WeightMachine weightMachine;

    public ChildWeightMachineKg(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg() {
        return (weightMachine.getWeightInPounds() * .45);
    }
}
