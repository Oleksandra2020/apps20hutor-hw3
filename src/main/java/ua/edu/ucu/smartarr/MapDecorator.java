package ua.edu.ucu.smartarr;

import lombok.Getter;
import lombok.Setter;
import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    @Getter @Setter
    private MyFunction func;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        setFunc(func);
    }

    public Object[] mapArray(Object[] array)
    {
        Object[] newArray = new Object[array.length];
        int i = 0;
        for (Object o: array)
        {
            newArray[i] = getFunc().apply(array[i]);
            i++;
        }
        return newArray;
    }

    @Override
    public Object[] toArray() {
        return mapArray(smartArray.toArray());
    }

    @Override
    public String operationDescription() {
        return "Maps function to every element of smartArray";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
