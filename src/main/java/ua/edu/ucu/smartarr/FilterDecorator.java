package ua.edu.ucu.smartarr;

import lombok.Getter;
import lombok.Setter;
import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    @Getter @Setter
    private MyPredicate pr;

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        setPr(pr);
    }

    public Object[] filerArray(Object[] array)
    {
        ArrayList<Object> newArray = new ArrayList<>();
        for (Object o: array)
        {
            if (getPr().test(o))
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
        return "Returns a new array with objects, " +
                "for which MyPredicate object returned true";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
