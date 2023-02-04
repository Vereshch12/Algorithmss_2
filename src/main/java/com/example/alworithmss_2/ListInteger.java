package com.example.alworithmss_2;
import java.util.Arrays;
import java.util.Objects;

public class ListInteger implements ListIntegerInteface {
    private Integer[] intList;

    private Integer size;

    public ListInteger(Integer size) {
        this.size = size;
        this.intList = new Integer[size];
    }

    @Override
    public Integer add(Integer number) throws IntegerListException {
        if (intList[size-1] != null) {
            grow();
        }
        for (int i = 0; i < intList.length; i++) {
            if (intList[i] == null) {
                intList[i] = number;
                return number;
            }
        }
        return number;
    }

    @Override
    public Integer add(int index, Integer number) throws IntegerListException {
        if (intList[size-1] != null) {
            grow();
        }
        if (index >= size()){
            throw new IntegerListException("Индекс элемента превышевышает количество элементов!");
        }
        Integer helpStr = intList[index];
        intList[index] = number;
        number = helpStr;
        for (int i = index + 1; i < intList.length; i++){
            helpStr = intList[i];
            intList[i] = number;
            number = helpStr;
        }
        return intList[index];
    }

    @Override
    public Integer set(int index, Integer number) throws IntegerListException {
        if (index >= size()){
            throw new IntegerListException("Индекс элемента превышевышает количество элементов!");
        }
        intList[index] = number;
        return intList[index];
    }

    @Override
    public Integer remove(Integer number) throws IntegerListException {
        for (int i = 0; i < intList.length; i++) {
            if (intList[i] == number) {
                int j;
                for (j = i; j < intList.length - 1; j++) {
                    intList[j] = intList[j + 1];
                }
                intList[j] = null;
                return number;
            }
        }
        throw new IntegerListException("Такого элемента нет!");
    }

    @Override
    public Integer remove(int index) throws IntegerListException {
        int realSize = 0;
        while (intList[realSize] != null){
            realSize++;
        }
        if (index >= realSize){
            throw new IntegerListException("Индекс элемента превышевышает количество элементов!");
        }
        int j;
        Integer num = intList[index];
        for (j = index; j < intList.length - 1; j++) {
            intList[j] = intList[j + 1];
        }
        intList[j] = null;
        return num;
    }

    @Override
    public boolean contains(Integer number) throws IntegerListException {
        return containsWithBinarySearch(number);
//        for (Integer n : intList) {
//            if (Objects.equals(n, number)) return true;
//        }
//        return false;
    }

    @Override
    public int indexOf(Integer number) {
        for (int i = 0; i < intList.length; i++) {
            if (intList[i] == number)
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer number) {
        for (int i = intList.length - 1; i >= 0; i--) {
            if (intList[i] == number)
                return intList.length - i;
        }
        return -1;
    }


    @Override
    public Integer get(int index) throws IntegerListException {
        if (index >= size()){
            throw new IntegerListException("Индекс элемента превышевышает количество элементов!");
        }
        return intList[index];
    }

    @Override
    public int size() throws IntegerListException {
        int i = 0;
        if (intList[size-1] != null){
            return intList.length;
        }
        while (intList[i] != null){
            i++;
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        for (Integer n : intList) {
            if (n != null)
                return false;
        }
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(intList, null);
    }

    @Override
    public Integer[] toArray() {
        Integer[] intArray = new Integer[intList.length];
        System.arraycopy(intList, 0, intArray, 0, intList.length);
        return intArray;
    }

    @Override
    public String toString() {
        return
                "{intList=" + Arrays.toString(intList) +
                        ", size=" + size +
                        '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) throw new RuntimeException("Передан null!");
        ListInteger that = (ListInteger) o;
        return (Arrays.equals(intList, that.intList) && size.equals(that.size));
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(intList);
        return result;
    }

    public void sortListWithSortInsertion() throws IntegerListException {
        for (int i = 1; i < size(); i++) {
            int temp = get(i);
            int j = i;
            while (j > 0 && get(j - 1) >= temp) {
                set(j, get(j-1));
                j--;
            }
            set(j, temp);
        }
    }

    public void sortListWithMerge() throws IntegerListException {
        if (size < 2) {
            return;
        }
        Integer mid = size / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[size - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = get(i);
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = get(mid+ 1);
        }
        merge(left);
        merge(right);
        merge(left, right);
    }

    private void merge(Integer[] arr) throws IntegerListException {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[arr.length - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[i+1];
        }
    }

    private void merge(Integer[] left, Integer[] right) throws IntegerListException {
        Integer mainP = 0;
        Integer leftP = 0;
        Integer rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                set(mainP++, left[leftP++]);
            } else {
                set(mainP++, left[rightP++]);
            }
            if (mainP >= size()) break;
        }
        if (mainP >= size()) return;
        while (leftP < left.length) {
            set(mainP++, left[leftP++]);
        }
        while (rightP < right.length) {
            set(mainP++, left[rightP++]);
        }
    }

    private boolean containsWithBinarySearch(Integer element) throws IntegerListException {
        int min = 0;
        int max = size() - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == intList[mid]) {
                return true;
            }

            if (element < intList[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void grow(){
        this.size =(int) (size* 1.5);
        this.intList = Arrays.copyOf(intList, size);
    }
}

