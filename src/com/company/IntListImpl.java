package com.company;

import java.util.Arrays;

public class IntListImpl implements IntList {
    private static final int DEFAULT_CAPACITY = 10;

    private Integer[] data;
    private int size;

    public IntListImpl(){this(DEFAULT_CAPACITY);}

    public IntListImpl(int capacity){this.data = new Integer[capacity];}


    private void sortMyArray(Integer[] array) {
        int[]arr = new int[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
           arr[j] = temp;
        }
    }

    private boolean search(Integer[] array, int value) {
        int[]arr = new int[0];
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (value == arr[mid]) {
                return true;
            }

            if (value < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int value){
        Integer[] array = Arrays.copyOf(data,data.length);
        sortMyArray(array);
        search(array,value);
        return value >= 0;
    }

    @Override
    public int add(int value){
        checkNotNull(value);
        checkCapacity();
        data[size++] = value;
        return value;
    }

    @Override
    public int add(int index, int value){
        checkNotNull(value);
        checkCapacity();
        System.arraycopy(data, index,data, index + 1, data.length - index);
        data[size++] = value;
        return value;
    }
    @Override
    public int set(int index, int value){
        checkNotNull(value);
        checkCapacity();
        data[index] = value;
        return value;
    }
    @Override
    public int remove(int value){
        checkNotNull(value);
        checkValueExists(value);
        int index = indexOf(value);
        removeValue(index);
        return value;
    }
    @Override
    public void removeValue(int index){
        if(size - 1 > index) {
            System.arraycopy(data, index + 1, data, index, data.length - index);
        }
        data[--size] = null;
        }

        @Override
    public int removeByIndex(int index){
        checkIndex(index);
        int value = get(index);
        removeValue(index);
        return value;
    }

    @Override
    public int indexOf(int value){
        checkNotNull(value);
        for(int i = 0;i < size ; i++){
            if(value == data[i]){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        checkNotNull(value);
        for (int i = size - 1; i >= 0; i--) {
            if (value == data[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear(){
        data = new Integer[DEFAULT_CAPACITY];
    }

    @Override
    public Integer[] toArray(){
        return Arrays.copyOf(data, data.length);
    }

    @Override
    public Integer[]grow(){
        return Arrays.copyOf(data, size * 2);
    }
    @Override
    public void checkCapacity(){
        if(size == data.length){
            data = grow();
        }
    }
    @Override
    public void checkNotNull(Integer value){
        if(value == null){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void checkIndex(int index){
        if(index < 0 || index >= size){
            throw  new IndexOutOfBoundsException();
        }
    }
    @Override
    public void checkValueExists(int value){
        if(indexOf(value) == -1){
            throw new IllegalArgumentException();
        }
    }
    @Override
    public boolean equals(IntListImpl otherList){
        if(otherList == null){
            return false;
        }
        if(size != otherList.size()){
            return false;
        }
        for(int i = 0; i < size; i++){
            if(get(i) != (otherList.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public int get(int index){
        checkIndex(index);
        return data[index];
    }



}

