package com.mymavenexperiments.serializationsimpleread;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class SimpleRead {

    public static void main(String[] args) {
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(System.getProperty("user.home") + File.separator + "simplestring.dat"));
            String[] arrayRecuperata = (String[]) reader.readObject();
            //controllo che sia corretta
            for(String each : arrayRecuperata){
                System.out.println(each);
            }
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        } catch (ClassCastException e) {

        }
    }

}
