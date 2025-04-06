package ir.lld.designpatterns.behavioural.composite.impl;

import ir.lld.designpatterns.behavioural.composite.FileSystem;

public class File implements FileSystem {

    String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void ls() {
        System.out.println("File name is: "+ name);
    }
}
