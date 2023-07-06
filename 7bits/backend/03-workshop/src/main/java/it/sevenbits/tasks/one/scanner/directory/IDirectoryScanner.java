package it.sevenbits.tasks.one.scanner.directory;

/**
 * The interface Directory scanner.
 */
public interface IDirectoryScanner {
    /**
     * Write content of directory to file.
     */
    void writeContentOfDirectoryToFile();

    /**
     * Sets path to directory to scan.
     *
     * @param inPathToDirectory the in path to directory
     */
    void setPathToDirectoryToScan(String inPathToDirectory);

    /**
     * Sets file name to write out to.
     *
     * @param inFileName the in file name
     */
    void setFileNameToWriteOutTo(String inFileName);
}
