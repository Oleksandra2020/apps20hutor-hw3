package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray{

    public Object[] array;
    public int initialCapacity = 0;

    public BaseArray()
    {
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
