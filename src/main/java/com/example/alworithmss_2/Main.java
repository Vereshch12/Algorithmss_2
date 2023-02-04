package com.example.alworithmss_2;


public class Main {
    private static void swap (ListInteger listInteger, int i, int j) throws IntegerListException {
        int tmp = listInteger.get(i);
        listInteger.set(i, listInteger.get(j));
        listInteger.set(j, tmp);
    }
    public static void main(String[] args) throws IntegerListException {
        ListInteger listIntegerForSortBubble = new ListInteger(10000);
        for (int i = 0; i < listIntegerForSortBubble.toArray().length; i++) {
            listIntegerForSortBubble.add((int) (Math.random()*10000));
        }
        System.out.println(listIntegerForSortBubble);
        long start = System.currentTimeMillis();
        for (int i = 0; i < listIntegerForSortBubble.size(); i++) {
            for (int j = 0; j < listIntegerForSortBubble.size() - 1 - i; j++) {
                if (listIntegerForSortBubble.get(j) > listIntegerForSortBubble.get(j+1)) {
                    swap(listIntegerForSortBubble, j, j+1);
                }
            }
        }
        long time = System.currentTimeMillis() - start;
        System.out.println(listIntegerForSortBubble);
        System.out.println("Сортировка пузырьком: " + (time));
        ListInteger listIntegerForSortSelection = new ListInteger(10000);
        for (int i = 0; i < listIntegerForSortSelection.toArray().length; i++) {
            listIntegerForSortSelection.add((int) (Math.random()*10000));
        }
        System.out.println(listIntegerForSortSelection);
        start = System.currentTimeMillis();
        for (int i = 0; i < listIntegerForSortSelection.toArray().length; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < listIntegerForSortSelection.toArray().length; j++) {
                if (listIntegerForSortSelection.get(j) < listIntegerForSortSelection.get(minElementIndex)) {
                    minElementIndex = j;
                }
            }
            swap(listIntegerForSortSelection, i, minElementIndex);
        }
        time = System.currentTimeMillis() - start;
        System.out.println(listIntegerForSortSelection);
        System.out.println("Сортировка выбором: " + (time));
        ListInteger listIntegerForSortInsertion = new ListInteger(10000);
        for (int i = 0; i < listIntegerForSortInsertion.toArray().length; i++) {
            listIntegerForSortInsertion.add((int) (Math.random()*10000));
        }
        System.out.println(listIntegerForSortInsertion);
        start = System.currentTimeMillis();
        for (int i = 1; i < listIntegerForSortInsertion.toArray().length; i++) {
            int temp = listIntegerForSortSelection.get(i);
            int j = i;
            while (j > 0 && listIntegerForSortInsertion.get(j-1) >= temp) {
                listIntegerForSortInsertion.set(j, listIntegerForSortInsertion.get(j-1));
                j--;
            }
            listIntegerForSortInsertion.set(j, temp);
        }
        time = System.currentTimeMillis() - start;
        System.out.println(listIntegerForSortInsertion);
        System.out.println("Сортировка вставкой: " + (time));
    }


}
