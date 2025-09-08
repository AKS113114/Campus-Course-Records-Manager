package edu.ccrm.io;

import java.nio.file.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BackupUtil {
    public static Path backupFolder(Path srcRoot, Path destRoot) throws IOException{
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        Path dest = destRoot.resolve("backup_" + ts);
        Files.walk(srcRoot).forEach(source -> {
            try {
                Path rel = srcRoot.relativize(source);
                Path target = dest.resolve(rel);
                if(Files.isDirectory(source)){
                    Files.createDirectories(target);
                } else {
                    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch(IOException ex){
                throw new RuntimeException(ex);
            }
        });
        return dest;
    }
}
