package it.sevenbits.directory.analyzer.file.visitor;

import it.sevenbits.directory.analyzer.file.tools.IWriterToFile;
import it.sevenbits.directory.analyzer.file.tools.WriterToFile;
import it.sevenbits.directory.analyzer.file.tools.indent.IIndent;
import it.sevenbits.directory.analyzer.file.tools.indent.Indent;

import java.io.IOException;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFilePermission;

import java.util.Set;

/**
 * The type File visitor.
 */
public class FileVisitor implements java.nio.file.FileVisitor<Path> {
    private final StringBuilder sb;
    private int sizeOfIntend;
    private final IIndent indent;
    private final String NEW_LINE = "\n";
    private final IWriterToFile writerToFile;

    /**
     * Instantiates a new File visitor.
     *
     * @param fileName   the file name
     * @param bufferSize the buffer size
     */
    public FileVisitor(final String fileName, final int bufferSize) {
        this.sb = new StringBuilder();
        this.sizeOfIntend = 0;
        this.indent = new Indent();
        this.writerToFile = new WriterToFile(fileName, bufferSize);
    }

    @Override
    public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs) {
        this.sb.append(indent.getIndent(sizeOfIntend));
        this.sb.append(dir.getFileName());
        this.sb.append(NEW_LINE);
        this.writerToFile.writeToFile(this.sb.toString());
        this.sb.setLength(0);
        this.sizeOfIntend++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) {
        this.sb.append(indent.getIndent(sizeOfIntend));
        this.sb.append(file.getFileName());
        this.sb.append(" ");
        getFilePermissionsAndWriteTo(file, sb);
        this.sb.append(NEW_LINE);
        this.writerToFile.writeToFile(this.sb.toString());
        this.sb.setLength(0);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(final Path file, final IOException exc) {
        System.out.println("Error: visiting file failed: " + file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(final Path dir, final IOException exc) {
        this.sizeOfIntend--;
        return FileVisitResult.CONTINUE;
    }

    private void getFilePermissionsAndWriteTo(final Path pathToFile, final StringBuilder stringBuilder) {
        Set<PosixFilePermission> permissions;
        try {
            permissions = Files.getPosixFilePermissions(pathToFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getOwnerPermissions(permissions, stringBuilder);
        getGroupPermissions(permissions, stringBuilder);
        getOthersPermissions(permissions, stringBuilder);
    }

    private void getOwnerPermissions(final Set<PosixFilePermission> permissions, final StringBuilder stringBuilder) {
        if (permissions.contains(PosixFilePermission.OWNER_READ)) {
            stringBuilder.append("r");
        } else {
            stringBuilder.append("-");
        }

        if (permissions.contains(PosixFilePermission.OWNER_WRITE)) {
            stringBuilder.append("w");
        } else {
            stringBuilder.append("-");
        }

        if (permissions.contains(PosixFilePermission.OWNER_EXECUTE)) {
            stringBuilder.append("x");
        } else {
            stringBuilder.append("-");
        }
    }

    private void getGroupPermissions(final Set<PosixFilePermission> permissions, final StringBuilder stringBuilder) {
        if (permissions.contains(PosixFilePermission.GROUP_READ)) {
            stringBuilder.append("r");
        } else {
            stringBuilder.append("-");
        }

        if (permissions.contains(PosixFilePermission.GROUP_WRITE)) {
            stringBuilder.append("w");
        } else {
            stringBuilder.append("-");
        }

        if (permissions.contains(PosixFilePermission.GROUP_EXECUTE)) {
            stringBuilder.append("x");
        } else {
            stringBuilder.append("-");
        }
    }

    private void getOthersPermissions(final Set<PosixFilePermission> permissions, final StringBuilder stringBuilder) {
        if (permissions.contains(PosixFilePermission.OTHERS_READ)) {
            stringBuilder.append("r");
        } else {
            stringBuilder.append("-");
        }

        if (permissions.contains(PosixFilePermission.OTHERS_WRITE)) {
            stringBuilder.append("w");
        } else {
            stringBuilder.append("-");
        }

        if (permissions.contains(PosixFilePermission.OTHERS_EXECUTE)) {
            stringBuilder.append("x");
        } else {
            stringBuilder.append("-");
        }
    }

    /**
     * Close.
     */
    public void close() {
        writerToFile.closeWriter();
    }
}
