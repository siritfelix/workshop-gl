package ar.com.globallogic.workshop.service.array;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ArrayTest {
    private OperationsArrays operationsArrays = new OperationsArrays();

    @Test
    public void test1() {

        int[] arrayInt = new int[] { 1, 2 };
        int[][] array2dInt = new int[][] { { 1, 2 }, { 1, 2 } };
        int[][][] array3dInt = new int[][][] { { { 1, 2 }, { 1, 2 } }, { { 1, 2 }, { 1, 2 } } };
        int[][][][] array4dInt = new int[][][][] { { { { 1, 2 }, { 1, 2 } }, { { 1, 2 }, { 1, 2 } } },
                { { { 1, 2 }, { 1, 2 } }, { { 1, 2 }, { 1, 2 } } } };
        Object[] arrayObject = { new int[] { 1, 2 }, new String[] { "string 1", "string 1" },
                new float[] { 1, 2, 3 } };

        assertEquals(2, arrayInt.length);
        assertEquals(2, array2dInt.length);
        assertEquals(2, array3dInt.length);
        assertEquals(2, array4dInt.length);
        assertEquals(3, arrayObject.length);

        operationsArrays.printArrayInt(arrayInt);
        operationsArrays.printArrayObject(array2dInt);
        operationsArrays.printArrayObject(array3dInt);
        operationsArrays.printArrayObject(array4dInt);
        operationsArrays.printArrayObject(arrayObject);
    }

    @Test
    public void test2() {
        int[] arrayInt = new int[] { 1, 2 };
        operationsArrays.printArrayInt(arrayInt);
        operationsArrays.updateArrayInt(arrayInt, 0, 10);
        operationsArrays.printArrayInt(arrayInt);
    }

}
