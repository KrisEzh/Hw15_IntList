package com.company;

public interface IntList {
    boolean containsV(int[] myArray, int value);

    int add(int value);

    int add(int index, int value);

    int set(int index, int value);

    int remove(int value);

    void removeValue(int index);

    int removeByIndex(int index);

    int indexOf(int value);

    int lastIndexOf(int value);

    boolean isEmpty();

    void clear();

    Integer[] toArray();

    Integer[]grow();

    void checkCapacity();

    void checkNotNull(int value);

    void checkIndex(int index);

    void checkValueExists(int value);

    boolean equals(IntListImpl otherList);

    int size();

    int get(int index);
}
