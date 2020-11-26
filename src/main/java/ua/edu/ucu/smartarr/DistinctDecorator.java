package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.HashSet;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    public Object[] removeDuplivates(Object[] array)
    {
        ArrayList<Object> newArray = new ArrayList<>();
        boolean repeat;
        for (int i = 0; i < array.length; i++)
        {
            repeat = false;
            for (int j = i+1; j < array.length; j++)
            {
                if (array[i].equals(array[j])) {
                    repeat = true;
                    break;
                }
            }
            if (!repeat)
                newArray.add(array[i]);
        }
        return newArray.toArray();
    }

    @Override
    public Object[] toArray() {
        return removeDuplivates(smartArray.toArray());
    }

    @Override
    public String operationDescription() {
        return "Remove duplicates from array";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
