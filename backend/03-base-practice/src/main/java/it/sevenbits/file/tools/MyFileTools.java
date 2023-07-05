package it.sevenbits.file.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.nio.charset.StandardCharsets;

/**
 * The type My file tools.
 */
public class MyFileTools implements IMyFileTools {
    @Override
    public File createNewFileIfNotExists(final String filename) {
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
            System.out.println("MyHomework.txt is successfully created!");
        } else {
            System.out.println("MyHomework.txt already exists!");
        }
    }

    @Override
    public void copyFromOneFileToAnother(final File copyFrom, final File copyTo) {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(copyFrom));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(copyTo))) {
            this.copyFromInputStreamToOutputStream(bufferedInputStream, bufferedOutputStream);
        } catch (IOException e) {
            System.out.println("I/O error occurred while trying to copy the file : " +  e.getMessage());
        }
    }

    private void copyFromInputStreamToOutputStream(final BufferedInputStream bufferedInputStream,
                                                   final BufferedOutputStream bufferedOutputStream) throws IOException {
        int symbol;
        do {
            symbol = bufferedInputStream.read();
            if (symbol != -1) {
                bufferedOutputStream.write(symbol);
            }
        } while (symbol != -1);
        bufferedOutputStream.flush();
    }

    @Override
    public void addAutographToFile(final String autographToWrite, final File fileToWriteTo) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileToWriteTo, true))) {
            this.addAutograph(autographToWrite, bos);
        } catch (IOException e) {
            System.out.println("I/O error occurred while trying to write to the file: " +  e.getMessage());
        }
    }

    private void addAutograph(final String autographToWrite, final BufferedOutputStream bos) throws IOException {
        bos.write(autographToWrite.getBytes(StandardCharsets.UTF_8));
    }
}
