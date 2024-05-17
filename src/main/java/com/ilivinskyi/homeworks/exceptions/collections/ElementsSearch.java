package com.ilivinskyi.homeworks.exceptions.collections;

import java.util.List;
import java.util.NoSuchElementException;

public class ElementsSearch {

    public static int findElementIndex(List<String> list, String target)
        throws NoSuchElementException {
        int index = list.indexOf(target);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        return index;
    }
}
