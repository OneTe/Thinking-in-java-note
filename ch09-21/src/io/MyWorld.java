package io;
//只要将任何对象序列化到单一的流中，就可以恢复出与我们写出时一样的对象网
//并且没有意外重复复制出的对象。
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangcheng  on 2017/12/11.
 */
class House implements Serializable{}
class Animal implements Serializable{
    private String name;
    private House preferredHouse;
    Animal(String am,House h){
        name = am;
        preferredHouse = h;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", preferredHouse=" + preferredHouse +
                '}';
    }
}
public class MyWorld {
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        House house = new House();
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("Bosco the dog", house));
        animals.add(new Animal("Ralph the hamster", house));
        animals.add(new Animal("Molly the cat", house));
        System.out.println("animals: " + animals);
        ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
        ObjectOutputStream o1 = new ObjectOutputStream(buf1);
        o1.writeObject(animals);
        o1.writeObject(animals);//Write a 2nd set
        //write to a different stream:
        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        ObjectOutputStream o2 = new ObjectOutputStream(buf2);
        o2.writeObject(animals);
        //now get it back;
        ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
        List
                animals1 = (List)in1.readObject(),
                animals2 = (List)in1.readObject(),
                animals3 = (List)in2.readObject();
        System.out.println("animals1: " + animals1);
        System.out.println("animals2: " + animals2);
        System.out.println("animals3: " + animals3);
    }
}
