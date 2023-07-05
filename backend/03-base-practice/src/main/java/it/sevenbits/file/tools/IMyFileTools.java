package it.sevenbits.file.tools;

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
    File createNewFileIfNotExists(String filename);

    /**
     * Copy from one file to another.
     *
     * @param copyFrom the copy from
     * @param copyTo   the copy to
     */
    void copyFromOneFileToAnother(File copyFrom, File copyTo);

    /**
     * Add autograph to file.
     *
     * @param autographToWrite the autograph to write
     * @param fileToWriteTo    the file to write to
     */
    void addAutographToFile(String autographToWrite, File fileToWriteTo);
}
