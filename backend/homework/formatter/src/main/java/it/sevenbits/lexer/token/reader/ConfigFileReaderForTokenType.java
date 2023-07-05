package it.sevenbits.lexer.token.reader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * The type Config file reader for token type.
 */
public class ConfigFileReaderForTokenType implements IConfigReaderForTokenType {

    private Map<Map<String, String>, String> mapTokenType;
    private String pathToConfigFile;
    private final Logger logger;

    /**
     * Instantiates a new Config file reader for token type.
     *
     * @param pathToConfigFile the path to config file
     */
    public ConfigFileReaderForTokenType(final String pathToConfigFile) {
        logger = LoggerFactory.getLogger(ConfigFileReaderForTokenType.class);
        this.pathToConfigFile = pathToConfigFile;
        this.loadConfigFile();
    }

    private void loadConfigFile() {
        try {
            this.load();
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    private void load() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(this.pathToConfigFile));
        StringBuilder jsonString = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            jsonString.append(line);
        }
        in.close();
        Type type = new TypeToken<Map<Map<String, String>, String>>() { }.getType();
        Gson gson = new Gson();
        gson.fromJson(jsonString.toString(), type);
        this.mapTokenType = gson.fromJson(jsonString.toString(), type);
    }

    @Override
    public Map<Map<String, String>, String> getTokenTypeTable() {
        return mapTokenType;
    }

    /**
     * Gets path to config file.
     *
     * @return the path to config file
     */
    public String getPathToConfigFile() {
        return pathToConfigFile;
    }

    /**
     * Sets path to config file.
     *
     * @param pathToConfigFile the path to config file
     */
    public void setPathToConfigFile(final String pathToConfigFile) {
        this.pathToConfigFile = pathToConfigFile;
    }
}
