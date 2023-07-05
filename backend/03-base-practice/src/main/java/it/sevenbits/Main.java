package it.sevenbits;

import it.sevenbits.file.example.Example;
import it.sevenbits.file.reader.FileReader;
import it.sevenbits.file.tools.IMyFileTools;
import it.sevenbits.file.tools.MyFileTools;
import java.io.File;

/**
 * The type it.sevenbits.Main.
 */
public final class Main {
    private Main() {
    }

    /**
     * it.sevenbits.Main.
     *
     * @param args the args
     */

    public static void main(final String[] args) {
        IMyFileTools fileTools = new MyFileTools();
        File fileWriteTo = fileTools.createNewFileIfNotExists("MyHomework.txt");
        File fileReadFrom = new File("Homework3.txt");
        fileTools.copyFromOneFileToAnother(fileReadFrom, fileWriteTo);
        fileTools.addAutographToFile("Юрченко Андрей", fileWriteTo);

        fileReadFrom = new File("Homework3.txt");
        FileReader fileReader = new FileReader(fileReadFrom);
        while (fileReader.hasMoreLines()) {
            System.out.println(fileReader.readLine());
        }

        fileReader = new FileReader(fileReadFrom);
        Example example = new Example();
        System.out.println("The longest line in the file has " + example.getLongestLineCharsCount(fileReader) + " symbol(s).");
    }
}
