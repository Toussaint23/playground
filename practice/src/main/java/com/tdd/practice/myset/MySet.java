package com.tdd.practice.myset;

public class MySet {
    private Integer [] myarray;
    private int size;


    public MySet(){
        myarray = new Integer[5];
        size = 0;
    }

    public boolean contains(Integer value){
        for (Integer element : myarray) {
            if (element == value) return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public boolean add(Integer value){
        if (myarray.length == size) throw new IndexOutOfBoundsException();
        if((value == null) || contains(value)) {
            return false;
        }
        else {
            myarray[size++] = value;
            return true;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private int getIndex(Integer value){
        int index = 0;
        for(int i = 0; i < myarray.length; i++){
            if( myarray[i] == value){
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean remove(Integer value){
        if(isEmpty() || value == null || !contains(value)){
            return false;
        }else{
            int index = getIndex(value);
            for(int i = index; i < myarray.length-1; i++){
                myarray[i] = myarray[i+1];
            }
            size--;
            return true;
        }
    }

    public static void main(String[] arg){
        MySet mySet = new MySet();
        System.out.println(mySet.add(1));
        System.out.println(mySet.remove(null));
        System.out.println(mySet.remove(2));
        System.out.println(mySet.remove(1));
        System.out.println(mySet.remove(1));

    }


}
