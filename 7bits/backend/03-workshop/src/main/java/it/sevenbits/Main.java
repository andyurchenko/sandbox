package it.sevenbits;

import it.sevenbits.tasks.one.scanner.directory.DirectoryScanner;
import it.sevenbits.tasks.one.scanner.directory.IDirectoryScanner;
import it.sevenbits.tasks.one.scanner.tools.file.analyzer.FileAnalyzer;
import it.sevenbits.tasks.one.scanner.tools.file.analyzer.IFileAnalyzer;
import it.sevenbits.tasks.one.scanner.tools.IMyFileTools;
import it.sevenbits.tasks.one.scanner.tools.MyFileTools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
     * @throws IOException the io exception
     */
    public static void main(final String[] args) throws IOException {
        IFileAnalyzer fileHelper = new FileAnalyzer();
        IMyFileTools fileTools = new MyFileTools();
        IDirectoryScanner ds = new DirectoryScanner(fileHelper, fileTools);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a directory to scan: ");
        ds.setPathToDirectoryToScan(reader.readLine());
        System.out.print("Enter a file name to write info to: ");
        ds.setFileNameToWriteOutTo(reader.readLine());
        reader.close();
        ds.writeContentOfDirectoryToFile();
    }
}
