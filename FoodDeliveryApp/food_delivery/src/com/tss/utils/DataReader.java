package com.tss.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

	public static <T> List<T> readFromFile(String filename, Class<T> clazz) {
	    File file = new File(filename);
	    if (!file.exists()) {
	        return new ArrayList<>();
	    }

	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
	        Object obj = ois.readObject();
	        if (obj instanceof List<?>) {
	            List<?> rawList = (List<?>) obj;
	            List<T> typedList = new ArrayList<>();
	            for (Object item : rawList) {
	                if (clazz.isInstance(item)) {
	                    typedList.add(clazz.cast(item));
	                }
	            }
	            return typedList;
	        }
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Failed to read data: " + e.getMessage());
	    }

	    return new ArrayList<>();
	}
}
