package file.reader;

import it.sevenbits.file.reader.FileReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileReaderTest {
    private FileReader reader;
    private File testFile;


    @Before
    public void setUp() throws IOException {
        this.testFile = new File("testFile1.txt");
        Writer writer = new FileWriter(testFile);
        writer.write("test line1\n");
        writer.write("test line2\n");
        writer.write("test line3\n");
        writer.flush();
        this.reader = new FileReader(this.testFile);
    }

    @After
    public void cleanUp() {
        reader.closeFileReader();
    }

    @Test
    public void readLineTest() {
        assertEquals("testFile1.txt line 1: test line1", reader.readLine());
        assertEquals("testFile1.txt line 2: test line2", reader.readLine());
        assertEquals("testFile1.txt line 3: test line3", reader.readLine());
    }
}
