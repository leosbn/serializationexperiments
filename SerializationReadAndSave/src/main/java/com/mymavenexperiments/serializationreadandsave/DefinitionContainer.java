package com.mymavenexperiments.serializationreadandsave;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class DefinitionContainer implements Serializable {

    private List<Definition> container;
    private final String FILENAME = "definition-package.dat";
    private final String PATH = System.getProperty("user.home");
    private File file = new File(PATH + File.separator + FILENAME);

    public DefinitionContainer() {
        this.container = new ArrayList<>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(this.file));
            List<Definition> list = (List<Definition>) input.readObject();
            this.container.addAll(list);
            input.close();
        } catch (IOException e) {
            System.out.println("Sorry, " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry, " + e);
        } catch (ClassCastException e) {
            System.out.println("Sorry, " + e);
        }
    }

    public void addToList(Definition def) {
        this.container.add(def);
    }

    public List<Definition> getList() {
        return this.container;
    }

    public void removeFromList(String titolo) {
        List<Definition> removing = new ArrayList<Definition>();
        for (Definition definiz : this.container) {
            if (definiz.getTitle().equalsIgnoreCase(titolo)) {
                removing.add(definiz);
            }
        }
        this.container.removeAll(removing);
    }

    public Definition getDefinizione(String defDaCercare) {
        for (Definition defin : this.container) {
            if (defin.getTitle().equalsIgnoreCase(defDaCercare)) {
                return defin;
            }
        }
        return null;
    }

    public void stopAndSave() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(this.file));
            output.writeObject(this.container);
            output.close();
        } catch (IOException e) {
            System.out.println("Sorry, " + e);
        }
    }
}
