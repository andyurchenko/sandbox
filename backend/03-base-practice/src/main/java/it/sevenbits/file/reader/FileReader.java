package it.sevenbits.file.reader;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

/**
 * The type File reader.
 */
public class FileReader {

    private Scanner scanner = null;
    private String fileName;
    private long lineNumber = 0;
    private StringBuilder sb;

    /**
     * Instantiates a new File reader.
     *
     * @param fileToReadFrom the file to read from
     */
    public FileReader(final File fileToReadFrom) {
        try {
            scanner = new Scanner(fileToReadFrom);
            fileName = fileToReadFrom.getName();
            sb = new StringBuilder();
        } catch (FileNotFoundException e) {
            System.out.println("I/O error occurred while trying to find and open the file :" + e.getMessage());
        }
    }

    /**
     * Has more lines boolean.
     *
     * @return the boolean
     */
    public boolean hasMoreLines() {
        return scanner.hasNext();
    }

    /**
     * Read line string.
     *
     * @return the string
     */
    public String readLine() {
        if (scanner.hasNext()) {
            sb.setLength(0);
            sb.append(this.fileName).append(" line ").append(++lineNumber).append(": ").append(scanner.nextLine());
            return sb.toString();
        } else {
            scanner.close();
            return null;
        }
    }

    /**
     * Close file reader.
     */
    public void closeFileReader() {
        this.scanner.close();
    }


}
