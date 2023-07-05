package it.sevenbits.directory.analyzer;

import it.sevenbits.directory.analyzer.file.visitor.FileVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The type Directory analyzer.
 */
public class DirectoryAnalyzer implements IDirectoryAnalyzer {
    private final FileVisitor fileVisitor;
    private final String nameOfDirToAnalyze;

    /**
     * Instantiates a new Directory analyzer.
     *
     * @param nameOfDirToAnalyze        the name of dir to analyze
     * @param nameOfFileToWriteResultTo the name of file to write result to
     * @param bufferSize                the buffer size
     */
    public DirectoryAnalyzer(final String nameOfDirToAnalyze, final String nameOfFileToWriteResultTo, final int bufferSize) {
        this.fileVisitor = new FileVisitor(nameOfFileToWriteResultTo, bufferSize);
        this.nameOfDirToAnalyze = nameOfDirToAnalyze;
    }

    /**
     * Analyze a given directory and write result of analysis to a file with a given name
     */
    public void analyzeDirectoryAndWriteResultToFile() {
        Path pathToDirToScan = Paths.get(this.nameOfDirToAnalyze);
        if (Files.exists(pathToDirToScan, LinkOption.NOFOLLOW_LINKS)) {
            try {
                Files.walkFileTree(pathToDirToScan.toAbsolutePath(), this.fileVisitor);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            fileVisitor.close();
        }
    }
}
