package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    public MyPredicate pr;

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        this.pr = pr;
    }

    public Object[] filerArray(Object[] array)
    {
        ArrayList<Object> newArray = new ArrayList<>();
        for (Object o: array)
        {
            if (pr.test(o))
            {
                newArray.add(o);
            }
        }
        return newArray.toArray();
    }

    @Override
    public Object[] toArray() {
        return filerArray(smartArray.toArray());
    }

    @Override
    public String operationDescription() {
        return "Result is a new array with objects, for which MyPredicate object returned true";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
