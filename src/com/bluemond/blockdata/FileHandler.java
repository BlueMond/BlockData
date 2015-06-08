package com.bluemond.blockdata;

import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Map;

public class FileHandler {
    File folder = new File("mods" + File.separator + "BlockData");
    File data = new File(this.folder + File.separator + "data.yml");

    public FileHandler() {
        try {
            if (!this.folder.exists()) {
                this.folder.mkdir();
            }
            if (!this.data.exists()) {
                this.data.createNewFile();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map getData() {
        System.out.println("Didn't get there..");
        Map map = null;
        System.out.println("Didn't get there..2");
        try {
            YamlReader reader = new YamlReader(new FileReader(this.data));
            map = (Map)reader.read();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}