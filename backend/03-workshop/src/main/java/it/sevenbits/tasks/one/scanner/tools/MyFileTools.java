package it.sevenbits.tasks.one.scanner.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The type My file tools.
 */
public class MyFileTools implements IMyFileTools {
    @Override
    public File createNewFile(final String filename) {
        File fileToCreate = new File(filename);
        try {
            tryToCreateNewFile(fileToCreate);
        } catch (IOException e) {
            System.out.println("I/O error occurred : Cannot create a file: " +  e.getMessage());
        }
        return fileToCreate;
    }

    private void tryToCreateNewFile(final File fileToCreate) throws IOException {
        if (fileToCreate.createNewFile()) {
            System.out.println("File is successfully created!");
        } else {
            System.out.println("File already exists!");
        }
    }

    @Override
    public void writeToFile(final String textToWrite, final File fileWriteTo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileWriteTo, true));
            writer.write(textToWrite);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


}
