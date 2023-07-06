package it.sevenbits.tool.buffer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SmartBufferTest {
    private SmartBuffer smartBuffer;

    @Before
    public void setUp() {
        this.smartBuffer = new SmartBuffer();
    }

    @Test
    public void testAddToBuffer() {
        this.smartBuffer.addToBuffer("test string");
        String stringFromBuffer = this.smartBuffer.getBuffer();
        assertEquals("test string", stringFromBuffer);
    }

    @Test
    public void testGetBuffer() {
        this.smartBuffer.addToBuffer("test string");
        String stringFromBuffer = this.smartBuffer.getBuffer();
        assertEquals("test string", stringFromBuffer);
    }

    @Test
    public void testClearAllBuffer() {
        this.smartBuffer.addToBuffer("test string");
        this.smartBuffer.clearBuffer();
        assertEquals("", this.smartBuffer.getBuffer());
    }

    @Test
    public void testAddToBufferWithMarkingPositionOfFirstCharOfAddedString() {
        this.smartBuffer.addToBuffer("test");
        this.smartBuffer.addToBufferWithMarkingPositionOfFirstCharOfAddedString("123");
        assertEquals(4, this.smartBuffer.getMarkPosition());
        assertEquals("test123", this.smartBuffer.getBuffer());
    }

    @Test
    public void testDeleteAllFromCurrentPositionToMarkedPosition() {
        this.smartBuffer.addToBuffer("test");
        this.smartBuffer.addToBufferWithMarkingPositionOfFirstCharOfAddedString("123");
        this.smartBuffer.deleteAllCharsFromCurrentPositionToMarkPosition();
        assertEquals("test", this.smartBuffer.getBuffer());
    }

    @Test
    public void testDeleteCharactersFromMarkToTheRight() {
        this.smartBuffer.addToBuffer("1234");
        this.smartBuffer.setMarkToTheNextPositionToAdd();
        this.smartBuffer.addToBuffer("5678");
        this.smartBuffer.deleteCharactersFromTheMarkToTheRight(2);
        assertEquals("123478", this.smartBuffer.getBuffer());
        this.smartBuffer.addToBuffer("90");
        this.smartBuffer.deleteCharactersFromTheMarkToTheRight(1);
        assertEquals("1234890", this.smartBuffer.getBuffer());
    }

    @Test
    public void testDeleteCharactersFromMarkToTheLeft() {
        this.smartBuffer.addToBuffer("12345678");
        this.smartBuffer.setMarkToTheNextPositionToAdd();
        this.smartBuffer.addToBuffer("90");
        this.smartBuffer.deleteCharactersFromTheMarkToTheLeft(2);
        assertEquals("12345690", this.smartBuffer.getBuffer());
        this.smartBuffer.deleteCharactersFromTheMarkToTheLeft(3);
        assertEquals("12390", this.smartBuffer.getBuffer());
        this.smartBuffer.addToBuffer("123");
        this.smartBuffer.deleteCharactersFromTheMarkToTheLeft(3);
        assertEquals("90123", this.smartBuffer.getBuffer());
        this.smartBuffer.deleteCharactersFromTheMarkToTheLeft(3);
        assertEquals("90123", this.smartBuffer.getBuffer());
    }

    @Test
    public void testSetMarkToGivenPosition() {
        this.smartBuffer.addToBuffer("0123456789");
        this.smartBuffer.setMarkToGivenPosition(4);
        assertEquals(4, this.smartBuffer.getMarkPosition());
        this.smartBuffer.deleteCharactersFromTheMarkToTheLeft(2);
        assertEquals(2, this.smartBuffer.getMarkPosition());
        assertEquals("01456789", this.smartBuffer.getBuffer());
        this.smartBuffer.deleteCharactersFromTheMarkToTheRight(3);
        assertEquals(2, this.smartBuffer.getMarkPosition());
        assertEquals("01789", this.smartBuffer.getBuffer());
        this.smartBuffer.setMarkToGivenPosition(3);
        assertEquals(3, this.smartBuffer.getMarkPosition());
        this.smartBuffer.deleteCharactersFromTheMarkToTheRight(99);
    }
}
