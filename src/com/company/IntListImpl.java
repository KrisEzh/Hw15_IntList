package com.company;

import java.util.Arrays;

import static com.company.Main.generateRandomArray;

public class IntListImpl implements IntList {
    private static final int DEFAULT_CAPACITY = 10;

    private int[] data;
    private int size;

    public IntListImpl(){this(DEFAULT_CAPACITY);}

    public IntListImpl(int capacity){this.data =  new int[capacity];}

    private static void swapElements(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    private  int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

        private boolean search(int[] arr, int value) {
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
        int[] array = Arrays.copyOf(generateRandomArray(),generateRandomArray().length);
        quickSort(array, 0, array.length-1);
        search(array,value);
        return search(data,value);
    }

    @Override
    public int add(int value){
        checkNotNull(value);
        checkCapacity();
        data[size++] = value;
        return value;
    }
    private int[] grow(){
        return Arrays.copyOf(data, size * 2);
    }

    @Override
    public void checkCapacity(){
        if(size == data.length){
            data = grow();
        }
    }
    @Override
    public Integer add(int index, int value){
        checkNotNull(value);
        checkCapacity();
        System.arraycopy(data, index,data, index + 1, data.length - index);
        data[size++] = value;
        return value;
    }
    @Override
    public Integer set(int index, int value){
        checkNotNull(value);
        checkCapacity();
        data[index] = value;
        return value;
    }
    @Override
    public Integer remove(int value){
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
        data[--size] = Integer.parseInt(null);
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
        data = new int[DEFAULT_CAPACITY];
    }

    @Override
    public int[] toArray(){
        return Arrays.copyOf(data, data.length);
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

