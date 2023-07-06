package it.sevenbits.file.example;

import it.sevenbits.file.reader.FileReader;

/**
 * The type Example.
 */
public class Example {

    /**
     * Gets longest line chars count.
     *
     * @param fileReader the file reader
     * @return the longest line chars count
     */
    public int getLongestLineCharsCount(final FileReader fileReader) {
        int maxLength = 0;
        int lengthOfCurrentLine;
        while (fileReader.hasMoreLines()) {
            lengthOfCurrentLine = fileReader.readLine().length();
            if (maxLength < lengthOfCurrentLine) {
                maxLength = lengthOfCurrentLine;
            }
        }
        return maxLength;
    }
}
