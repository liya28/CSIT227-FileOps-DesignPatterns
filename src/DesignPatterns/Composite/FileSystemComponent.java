package DesignPatterns.Composite;

import java.util.ArrayList;
import java.util.List;

public interface FileSystemComponent {
    void showDetails();
}

class File implements FileSystemComponent {
    String file_name;
    int size;

    public File(String file_name, int size) {
        this.file_name = file_name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + file_name + " Size: " + size);
    }
}

class Directory implements FileSystemComponent {
    private List<FileSystemComponent> components;
    String directory_name;

    public Directory(String directory_name) {
        this.directory_name = directory_name;
        components = new ArrayList<>();
    }

    @Override
    public void showDetails() {
        System.out.println("Directory Name: " + directory_name);
        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }
}

class FileManager {
    public static void main(String[] args) {
        File document = new File("Document.txt", 1);
        File image = new File("Image.png", 2048);
        File notes = new File("Notes.txt", 5);
        File resume = new File("Resume.doc", 200);

        Directory rootDirectory = new Directory("Root");
        Directory subFolder = new Directory("SubFolder");

        rootDirectory.addComponent(document);
        rootDirectory.addComponent(image);

        subFolder.addComponent(notes);
        subFolder.addComponent(resume);

        rootDirectory.addComponent(subFolder);
        rootDirectory.showDetails();
    }
}
