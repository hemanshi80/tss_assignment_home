package com.tss.structural.composite.test;

import com.tss.structural.composite.model.File;
import com.tss.structural.composite.model.Folder;
import com.tss.structural.composite.model.IFileSystem;

public class CompositeTest {

	public static void main(String[] args) {
        IFileSystem file1 = new File("resume.pdf");
        IFileSystem file2 = new File("coverletter.docx");

        Folder folder1 = new Folder("Documents");
        folder1.add(file1);
        folder1.add(file2);

        IFileSystem file3 = new File("photo.jpg");
        Folder folder2 = new Folder("Pictures");
        folder2.add(file3);

        Folder rootFolder = new Folder("My Drive");
        rootFolder.add(folder1);
        rootFolder.add(folder2);

        rootFolder.showDetails();
    }
}
