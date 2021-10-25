package com.company;

import java.util.*;

public class LabClass implements Student, Comparable<LabClass> {
    int IDNumber = 0;
    String Name = "";
    @Override
    public void setName(String Name){
        this.Name = Name;
    }
    @Override
    public void setIDNumber(int IDNumber){
        this.IDNumber = IDNumber;
    }
    @Override
    public int getIDNumber(){
        return IDNumber;
    }
    @Override
    public String getName(){
        return Name;
    }
    @Override
    public int compareTo(LabClass o) {
        return this.getIDNumber() - o.getIDNumber();
    }
    public ArrayList<Student> addArray(ArrayList<Student> a, String Name){
        LabClass temp = new LabClass();
        Scanner field = new Scanner(System.in);
        int size;
        Random rand = new Random();
        //Name = field.next();
            temp.setIDNumber(rand.nextInt(255));
            temp.setName(Name);
            a.add(temp);
        return a;
    }
    public String readArray(ArrayList<Student> a){
        String message = "";
        for (Student student : a) {
            message += student.getIDNumber() + " " + student.getName() +"\n";
        }
        return message;
    }
    public void sortArray(ArrayList a){
        Collections.sort(a);
    }
    public String searchByID(ArrayList<Student> a, int key) throws SearchException{
        String message;
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i).getIDNumber() == key) {
                    message = "Найден покупатель " + a.get(i).getIDNumber() + " " + a.get(i).getName();
                    return message;
                }
            }
            throw new SearchException("Покупатель не был найден");
    }
    public String searchByName(ArrayList<Student> a, String keyName) throws SearchException, EmptyStringException{
        String message;
        if (keyName.equals("")) throw new EmptyStringException("Строка пустая");
        for (Student student : a) {
            if (student.getName().equals(keyName)) {
                message = "Найден покупатель: " + student.getIDNumber() + " " + student.getName();
                return message;
            }
        }
        throw new SearchException("Покупатель не был найден");
    }
}
