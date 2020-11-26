package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    MyComparator cmp;

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.cmp = cmp;
    }

    public Object[] sortArray(Object[] array)
    {
        Object[] newArray = array.clone();
        Arrays.sort(newArray, cmp);
        return newArray;
    }

    @Override
    public Object[] toArray() {
        return sortArray(smartArray.toArray());
    }

    @Override
    public String operationDescription() {
        return "Sorts the array";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
