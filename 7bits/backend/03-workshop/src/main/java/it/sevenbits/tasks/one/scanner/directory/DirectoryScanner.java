package it.sevenbits.tasks.one.scanner.directory;

import it.sevenbits.tasks.one.scanner.tools.file.analyzer.IFileAnalyzer;
import it.sevenbits.tasks.one.scanner.tools.IMyFileTools;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * The type Directory scanner.
 */
public class DirectoryScanner implements IDirectoryScanner {
    private  final String INDENT_SIZE = "     ";
    private  final String NEW_LINE = "\n";
    private  final int BUFFER_SIZE_FOR_RECORDS = 5;
    private final IMyFileTools fileTools;
    private BufferedWriter bufferedWriter;
    private final IFileAnalyzer fileHelper;
    private String pathToDirectory;
    private String fileNameToWriteOutTo;
    private File fileToWriteOutTo;
    private int currentCountOfRecords;

    /**
     * Instantiates a new Directory scanner.
     *
     * @param fileHelper the file helper
     * @param fileTools  the file tools
     */
    public DirectoryScanner(final IFileAnalyzer fileHelper, final IMyFileTools fileTools) {
        this.pathToDirectory = null;
        this.fileNameToWriteOutTo = null;
        this.fileToWriteOutTo = null;
        this.fileTools = fileTools;
        this.fileHelper = fileHelper;
        this.currentCountOfRecords = 0;
    }

    /**
     * Write content of directory to file.
     */
    @Override
    public void writeContentOfDirectoryToFile() {
        if (this.pathToDirectory != null && this.fileNameToWriteOutTo != null) {
            File path = new File(this.pathToDirectory);
            this.fileToWriteOutTo = fileTools.createNewFile(this.fileNameToWriteOutTo);
            this.bufferedWriter = this.createBufferedWriter(fileToWriteOutTo);
            if (path.isDirectory()) {
                scan(this.pathToDirectory, "");
            }
        }
    }

    private BufferedWriter createBufferedWriter(final File file) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return bw;
    }

    /**
     * Sets path to directory to scan.
     *
     * @param inPathToDirectory the in path to directory
     */
    @Override
    public void setPathToDirectoryToScan(final String inPathToDirectory) {
        this.pathToDirectory = inPathToDirectory;
    }

    /**
     * Sets file name to write out to.
     *
     * @param inFileName the in file name
     */
    @Override
    public void setFileNameToWriteOutTo(final String inFileName) {
        this.fileNameToWriteOutTo = inFileName;
    }

    private void scan(final String inPath, final String indent) {
        File path = new File(inPath);
        String[] fileObjectsInDirectory = path.list();
        for (String fileName : fileObjectsInDirectory) {
            File fileObject = new File(path.getAbsolutePath(), fileName);
            if (fileObject.isDirectory()) {
                fileHelper.setPath(fileObject.getAbsolutePath());
                this.writeToFile(createNewRecord(indent));
                this.scan(fileObject.getAbsolutePath(), indent + INDENT_SIZE);
            } else {
                fileHelper.setPath(fileObject.getAbsolutePath());
                this.writeToFile(createNewRecord(indent));
            }
        }
    }

    private String createNewRecord(final String indent) {
        return indent + getFileInfo() + NEW_LINE;
    }

    private String getFileInfo() {
        return fileHelper.getFileName() +
                " " +
                fileHelper.getFileType() +
                " " +
                fileHelper.getFileAttributes() +
                " " +
                fileHelper.getFileFullPath() +
                " ";
    }

    private void writeToFile(final String recordToWrite) {
        try {
            this.bufferedWriter.write(recordToWrite);
            this.currentCountOfRecords++;
            if (this.currentCountOfRecords == BUFFER_SIZE_FOR_RECORDS) {
                this.bufferedWriter.flush();
                this.currentCountOfRecords = 0;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
