package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String result = get(key);
        Path path = Path.of(cachingDir + key);
        StringBuilder text = new StringBuilder();
        if (result == null) {
            try (BufferedReader read = new BufferedReader(new FileReader(String.valueOf(path)))) {
                for (String line = read.readLine(); line != null; line = read.readLine()) {
                    text.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = text.toString();
            put(key, result);
        }
        return result;
    }

}