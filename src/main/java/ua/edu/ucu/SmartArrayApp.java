package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object firstObject, Object secondObject) {
                return ((Integer) firstObject) - ((Integer) secondObject);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                int minGPA = 4;
                int year = 2;
                return (((Student) t).getGPA() >= minGPA
                        && ((Student) t).getYear() == year);
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object firstObject, Object secondObject) {
                String firstStudent = ((Student) firstObject).getSurname();
                String secondStudent = ((Student) secondObject).getSurname();
                int diff;

                for (int i = 0; i < (firstStudent.length())
                        && i < (secondStudent.length()); i++)
                {
                    diff = firstStudent.charAt(i) - secondStudent.charAt(i);
                    if (diff > 0)
                    {
                        return diff;
                    } else if (diff < 0)
                    {
                        return diff;
                    }
                }
                diff = firstStudent.length() - secondStudent.length();
                return diff;
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student) t).getSurname()
                        + " " + ((Student) t).getName();
            }
        };

        SmartArray sa = new BaseArray(students);

        sa = new DistinctDecorator(sa);
        sa = new FilterDecorator(sa, pr);
        sa = new SortDecorator(sa, cmp);
        sa = new MapDecorator(sa, func);

        Object[] result =  sa.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
