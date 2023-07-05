package it.sevenbits.tasks.one.scanner.tools;

import java.io.File;

/**
 * The interface My file tools.
 */
public interface IMyFileTools {
    /**
     * Create new file if not exists file.
     *
     * @param filename the filename
     * @return the file
     */
    File createNewFile(String filename);

    /**
     * Add autograph to file.
     *
     * @param textToWrite   the autograph to write
     * @param fileToWriteTo the file to write to
     */
    void writeToFile(String textToWrite, File fileToWriteTo);


}
