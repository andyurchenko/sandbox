package it.sevenbits.tasks.one.scanner.tools.file.analyzer;

/**
 * The interface File helper.
 */
public interface IFileAnalyzer {
    /**
     * Gets file name.
     *
     * @return the file name
     */
    String getFileName();

    /**
     * Gets file type.
     *
     * @return the file type
     */
    String getFileType();

    /**
     * Gets file attributes.
     *
     * @return the file attributes
     */
    String getFileAttributes();

    /**
     * Gets file full path.
     *
     * @return the file full path
     */
    String getFileFullPath();

    /**
     * Sets path.
     *
     * @param path the path
     */
    void setPath(String path);
}
