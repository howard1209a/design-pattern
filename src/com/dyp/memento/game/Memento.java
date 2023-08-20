package com.dyp.memento.game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 */
public class Memento implements Serializable {
    int money;
    ArrayList<String> fruits;

    public int getMoney() {
        return money;
    }

    Memento(int money) {
        this.money = money;
        fruits = new ArrayList<>();
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    List<String> getFruits() {
        return (List<String>) fruits.clone();
    }

    public void save(String path) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(this);
        oos.close();
    }

    public static Memento load(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (Memento) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }
}
