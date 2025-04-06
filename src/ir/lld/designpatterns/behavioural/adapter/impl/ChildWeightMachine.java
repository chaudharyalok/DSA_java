package ir.lld.designpatterns.behavioural.adapter.impl;

import ir.lld.designpatterns.behavioural.adapter.WeightMachine;

public class ChildWeightMachine implements WeightMachine {
    @Override
    public double getWeightInPounds() {
        return 28;
    }
}
