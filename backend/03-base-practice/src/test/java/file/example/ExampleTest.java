package file.example;

import it.sevenbits.file.example.Example;
import it.sevenbits.file.reader.FileReader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ExampleTest {
    @Mock
    private FileReader fileReader;

    @InjectMocks
    private Example example;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetLongestLineCharsCount() {
        when(fileReader.readLine()).thenReturn("12", "123", "1234");
        when(fileReader.hasMoreLines()).thenReturn(true, true, true, false);
        assertEquals(4, example.getLongestLineCharsCount(fileReader));
    }

    @Test
    public void testGetLongestLineCharsCountWithNoLines() {
        when(fileReader.readLine()).thenReturn("");
        when(fileReader.hasMoreLines()).thenReturn(false);
        assertEquals(0, example.getLongestLineCharsCount(fileReader));
    }
}
