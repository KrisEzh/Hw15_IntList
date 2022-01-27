package com.company;

public interface IntList  {

    boolean contains(int value);

    int add(int value);

    void checkCapacity();

    Integer add(int index, int value);

    Integer set(int index, int value);

    Integer remove(int value);

    void removeValue(int index);

    int removeByIndex(int index);

    int indexOf(int value);

    int lastIndexOf(int value);

    boolean isEmpty();

    void clear();

    int[] toArray();

    void checkNotNull(Integer value);

    void checkIndex(int index);

    void checkValueExists(int value);

    boolean equals(IntListImpl otherList);

    int size();

    int get(int index);
}
