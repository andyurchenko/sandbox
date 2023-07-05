package it.sevenbits.tasks.one.scanner.tools.file.analyzer;

import java.io.File;
import java.io.IOException;

/**
 * The type File helper.
 */
public class FileAnalyzer implements IFileAnalyzer {
    private final String DIR_TYPE = "dir";
    private final String FILE_TYPE = "file";
    private File fileSystemObject = null;

    @Override
    public void setPath(final String path) {
        this.fileSystemObject = new File(path);
        if (!checkIfPathExists()) {
           System.out.println("Error: there is no such file.");
        }
    }

    private boolean checkIfPathExists() {
        return this.fileSystemObject.exists();
    }

    @Override
    public String getFileName() {
        if (checkIfPathExists()) {
            return fileSystemObject.getName();
        } else {
            return null;
        }
    }

    @Override
    public String getFileType() {
        if (checkIfPathExists()) {
            return this.fileOrDir();
        } else {
            return null;
        }
    }

    private String fileOrDir() {
        if (this.fileSystemObject.isDirectory()) {
            return DIR_TYPE;
        } else {
            return FILE_TYPE;
        }
    }

    @Override
    public String getFileAttributes() {
        StringBuilder sb = new StringBuilder();
        if (checkIfPathExists() && isFile()) {
            if (this.fileSystemObject.canRead()) {
                sb.append("r+");
            } else {
                sb.append("r-");
            }

            if (this.fileSystemObject.canWrite()) {
                sb.append("w+");
            } else {
                sb.append("w-");
            }

            if (this.fileSystemObject.canExecute()) {
                sb.append("x+");
            } else {
                sb.append("x-");
            }

            return sb.toString();
        } else {
            return null;
        }
    }

    private boolean isFile() {
        return this.fileSystemObject.isFile();
    }

    @Override
    public String getFileFullPath() {
        if (checkIfPathExists()) {
            try {
                return fileSystemObject.getCanonicalPath();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }
}
