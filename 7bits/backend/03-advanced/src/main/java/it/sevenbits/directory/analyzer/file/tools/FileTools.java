package it.sevenbits.directory.analyzer.file.tools;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;


/**
 * The type File tools.
 */
public final class FileTools {

    private FileTools() {
    }

    /**
     * Create buffered writer buffered writer.
     *
     * @param file the file
     * @return the buffered writer
     */
    public static BufferedWriter createBufferedWriter(final File file) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return bufferedWriter;
    }

    /**
     * Create file file.
     *
     * @param fileName the file name
     * @return the file
     */
    public static File createFile(final String fileName) {
        File newFile = new File(fileName);
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return newFile;
    }
}
