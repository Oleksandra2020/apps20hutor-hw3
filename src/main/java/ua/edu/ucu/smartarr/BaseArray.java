package ua.edu.ucu.smartarr;

import lombok.Getter;
import lombok.Setter;

// Base array for decorators
public class BaseArray implements SmartArray {

    @Getter @Setter
    private Object[] array;

    public BaseArray()
    {
        int initialCapacity = 0;
        this.array = new Object[initialCapacity];
    }

    public BaseArray(Object[] array)
    {
        this.array = array;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public String operationDescription() {
        return "Base array";
    }

    @Override
    public int size() {
        return array.length;
    }
}
