package it.sevenbits;

import it.sevenbits.directory.analyzer.DirectoryAnalyzer;
import it.sevenbits.directory.analyzer.IDirectoryAnalyzer;

/**
 * The type Main.
 */
public final class Main {

    private Main() {
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(final String[] args) {
        IDirectoryAnalyzer analyzer = new DirectoryAnalyzer(args[0], args[1], Integer.parseInt(args[2]));
        analyzer.analyzeDirectoryAndWriteResultToFile();
    }




}