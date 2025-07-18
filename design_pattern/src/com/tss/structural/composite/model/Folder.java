package com.tss.structural.composite.model;

import java.util.ArrayList;
import java.util.List;

public class Folder implements IFileSystem {
    private String name;
    private List<IFileSystem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(IFileSystem component) {
        children.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: " + name);
        for (IFileSystem component : children) {
            component.showDetails();
        }
    }
}