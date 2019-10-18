package com.mymavenexperiments.serializationsimplesave;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class SimpleSave {

    public static void main(String[] args) throws IOException {
        int numero = 1000;
        String[] parole = new String[numero];
        for (int i = 0; i < numero; i++) {
            parole[i] = "aaa " + i;
        }
        String path = System.getProperty("user.home");
        File file = new File(path + File.separator + "simplestring.dat");
        ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(file));
        save.writeObject(parole);
        save.close();
    }

}
