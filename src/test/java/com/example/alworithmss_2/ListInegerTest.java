package com.example.alworithmss_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListInegerTest {
    private final ListInteger actual = new ListInteger(10);
    private final ListInteger expected = new ListInteger(10);

    @BeforeEach
    public void setUp() throws IntegerListException {
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
    }

    @Test
    public void addCheckingReturnValueTest() throws IntegerListException {
        Integer expectedInt = 4;
        Integer actualInt = actual.add(expectedInt);
        assertEquals(actualInt, expectedInt);
    }

    @Test
    public void addResultTest() throws IntegerListException {
        Integer value = 124;
        actual.add(value);
        Integer[] actualArray = actual.toArray();
        Integer[] expectedArray = {1, 2, 3, 4, 124};
        assertEquals(actualArray, expectedArray);
    }

    @Test
    public void addFullListLengthTest() throws IntegerListException {
        Integer value1 = 1;
        Integer value2 = 2;
        Integer value3 = 3;
        Integer value4 = 4;
        Integer value5 = 5;
        Integer value6 = 6;
        Integer value7 = 7;
        actual.add(value1);
        actual.add(value2);
        actual.add(value3);
        actual.add(value4);
        actual.add(value5);
        actual.add(value6);
        actual.add(value7);
        Integer expectedSize = 15;
        Integer actualSize = actual.toArray().length;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addFullListResultTest() throws IntegerListException {
        Integer value1 = 1;
        Integer value2 = 2;
        Integer value3 = 3;
        Integer value4 = 4;
        Integer value5 = 5;
        Integer value6 = 6;
        Integer value7 = 7;
        actual.add(value1);
        actual.add(value2);
        actual.add(value3);
        actual.add(value4);
        actual.add(value5);
        actual.add(value6);
        actual.add(value7);
        expected.add(value1);
        expected.add(value2);
        expected.add(value3);
        expected.add(value4);
        expected.add(value5);
        expected.add(value6);
        expected.add(value7);
        assertEquals(expected, actual);
    }

    @Test
    public void addWithIndexCheckingReturnValueTest() throws IntegerListException {
        Integer expectedInt = 12;
        Integer actualInt = actual.add(2, expectedInt);;
        assertEquals(actualInt, expectedInt);
    }

    @Test
    public void addWithIndexResultTest() throws IntegerListException {
        Integer value = 232;
        actual.add(2,value);
        Integer[] actualArray = actual.toArray();
        Integer[] expectedArray = {1, 2, 232, 3, 4};
        assertEquals(actualArray, expectedArray);
        assertEquals(actual, expected);
    }

    @Test
    public void addWithIndexFullListExceptionTest() throws IntegerListException {
        Integer value1 = 1;
        Integer value2 = 2;
        Integer value3 = 3;
        Integer value4 = 4;
        Integer value5 = 5;
        Integer value6 = 6;
        Integer value7 = 7;
        actual.add(3,value1);
        actual.add(3,value2);
        actual.add(3, value3);
        actual.add(4, value4);
        actual.add(4, value5);
        actual.add(6, value6);
        actual.add(7, value7);
        Integer[] actualArray = actual.toArray();
        Integer[] expectedArray = {1, 2, 3, 3, 5, 4, 6, 7, 2, 1, 4};
        assertEquals(actualArray, expectedArray);
    }

    @Test
    public void addWithIndexBigIndexExceptionTest(){
        Integer value = 43;
        IntegerListException thrown = assertThrows(IntegerListException.class, () -> actual.add(4,value), "Expected doThing() to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contentEquals("Индекс элемента превышевышает количество элементов!"));
    }

    @Test
    public void setCheckingReturnValueTest() throws IntegerListException {
        Integer expectedInt = 234;
        Integer actualInt = actual.set(2, expectedInt);
        assertEquals(actualInt, expectedInt);
    }

    @Test
    public void setResultTest() throws IntegerListException {
        Integer value = 43;
        actual.set(2,value);
        Integer[] actualArray = actual.toArray();
        Integer[] expectedArray = {1, 2, 43, 4};
        assertEquals(actualArray, expectedArray);
    }

    @Test
    public void setBigIndexExceptionTest(){
        Integer value = 43;
        IntegerListException thrown = assertThrows(IntegerListException.class, () -> actual.set(4,value), "Expected doThing() to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contentEquals("Индекс элемента превышевышает количество элементов!"));
    }

    @Test
    public void removeByItemCheckingReturnValueTest() throws IntegerListException {
        Integer expectedInt = 3;
        Integer actualInt= actual.remove(expectedInt);
        assertEquals(actualInt, expectedInt);
    }

    @Test
    public void removeByItemResultTest() throws IntegerListException {
        Integer value = 2;
        actual.remove(value);
        Integer[] actualArray = actual.toArray();
        Integer[] expectedArray = {1, 3, 4};
        assertEquals(actualArray, expectedArray);
    }

    @Test
    public void removeNoSuchElemntExceptionTest(){
        Integer value = 43;
        IntegerListException thrown = assertThrows(IntegerListException.class, () -> actual.remove(value), "Expected doThing() to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contentEquals("Такого элемента нет!"));
    }

    @Test
    public void removeByIndexCheckingReturnValueTest() throws IntegerListException {
        Integer expectedInt = 3;
        Integer actualInt = actual.remove(2);
        assertEquals(actualInt, expectedInt);
    }

    @Test
    public void removeByIndexResultTest() throws IntegerListException {
        actual.remove(2);
        Integer[] actualArray = actual.toArray();
        Integer[] expectedArray = {1, 2, 4};
        assertEquals(actualArray, expectedArray);
    }

    @Test
    public void removeByIndexBigIndexExceptionTest(){
        IntegerListException thrown = assertThrows(IntegerListException.class, () -> actual.remove(4), "Expected doThing() to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contentEquals("Индекс элемента превышевышает количество элементов!"));
    }

    @Test
    public void containsTrueTest() throws IntegerListException {
        boolean expectedBool = true;
        boolean actualBool = actual.contains(3);
        assertEquals(expectedBool, actualBool);
    }

    @Test
    public void containsFalseTest() throws IntegerListException {
        boolean expectedBool = false;
        boolean actualBool = actual.contains(1222);
        assertEquals(expectedBool, actualBool);
    }

    @Test
    public void indexOfTest(){
        int expectedIndex = 3;
        int actualIndex = actual.indexOf(4);
        assertEquals(actualIndex, expectedIndex);
    }

    @Test
    public void indexOfWithoutElementTest(){
        int expectedIndex = -1;
        int actualIndex = actual.indexOf(0);
        assertEquals(actualIndex, expectedIndex);
    }

    @Test
    public void lastIndexOfTest(){
        int expectedIndex = 7;
        int actualIndex = actual.lastIndexOf(4);
        assertEquals(actualIndex, expectedIndex);
    }

    @Test
    public void lastIndexOfWithoutElementTest(){
        int expectedIndex = -1;
        int actualIndex = actual.lastIndexOf(0);
        assertEquals(actualIndex, expectedIndex);
    }

    @Test
    public void getTest() throws IntegerListException {
        Integer expectedInt = 4;
        Integer actualInt = actual.get(3);
        assertEquals(actualInt, expectedInt);
    }

    @Test
    public void getNoSuchElemntExceptionTest(){
        IntegerListException thrown = assertThrows(IntegerListException.class, () -> actual.get(6), "Expected doThing() to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contentEquals("Индекс элемента превышевышает количество элементов!"));
    }


    @Test
    public void equalsTrueTest(){
        Boolean expectedBool = true;
        Boolean actualBool = actual.equals(expected);
        assertEquals(actualBool, expectedBool);
    }

    @Test
    public void equalsFalseTest() throws IntegerListException {
        Boolean expectedBool = false;
        expected.add(123);
        Boolean actualBool = actual.equals(expected);
        assertEquals(actualBool, expectedBool);
    }

    @Test
    public void equalsNullExceptionTest(){
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> actual.equals(null), "Expected doThing() to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contentEquals("Передан null!"));
    }

    @Test
    public void sizeWithFullListTest() throws IntegerListException {
        int expectedSize = 10;
        Integer value1 = 1;
        Integer value2 = 2;
        Integer value3 = 3;
        Integer value4 = 4;
        Integer value5 = 5;
        Integer value6 = 6;
        actual.add(value1);
        actual.add(value2);
        actual.add(value3);
        actual.add(value4);
        actual.add(value5);
        actual.add(value6);
        assertEquals(expectedSize, actual.size());
    }

    @Test
    public void sizeTest() throws IntegerListException {
        int expectedSize = 4;
        assertEquals(expectedSize, actual.size());
    }

    @Test
    public void isEmptyTrueTest(){
        assertFalse(actual.isEmpty());
    }

    @Test
    public void isEmptyFalseTest(){
        ListInteger actual1 = new ListInteger(5);
        assertTrue(actual1.isEmpty());
    }

    @Test
    public void ClearTest(){
        ListInteger expected1 = new ListInteger(10);
        actual.clear();
        assertEquals(expected1, actual);
    }

    @Test
    public void sortListWithSortInsertionTest() throws IntegerListException {
        actual.add(9);
        actual.add(5);
        actual.add(12);
        actual.add(1);
        actual.add(7);
        actual.add(122);
        actual.add(15);
        expected.add(1, 1);
        expected.add(5);
        expected.add(7);
        expected.add(9);
        expected.add(12);
        expected.add(15);
        expected.add(122);
        actual.sortListWithSortInsertion();
        assertEquals(actual, expected);
    }

    @Test
    public void sortListWithMergeTest() throws IntegerListException {
        actual.add(9);
        actual.add(5);
        actual.add(12);
        actual.add(1);
        actual.add(7);
        actual.add(122);
        actual.add(15);
        expected.add(1, 1);
        expected.add(5);
        expected.add(7);
        expected.add(9);
        expected.add(12);
        expected.add(15);
        expected.add(122);
        actual.sortListWithMerge();
        assertEquals(actual, expected);
    }
}
