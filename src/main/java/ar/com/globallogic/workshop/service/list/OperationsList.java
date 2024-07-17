package ar.com.globallogic.workshop.service.list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperationsList {

    public long removeAllLastListInteger(List<Integer> list) {
        int sizeStart = list.size();
        long timeStart = System.currentTimeMillis();
        for (int i = sizeStart - 1; i >= 0; i--) {
            list.remove(i);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido removeAllLastListInteger:{}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long removeAllFirstListInteger(List<Integer> list) {
        int sizeStart = list.size();
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < sizeStart; i++) {
            list.remove(0);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido removeAllFirstListInteger:{}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long sortLargestSmallest(List<Integer> list) {
        long timeStart = System.currentTimeMillis();
        Comparator<Integer> comparator = (a, b) -> b.compareTo(a);
        list.sort(comparator);
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long sortSmallestLargest(List<Integer> list) {
        long timeStart = System.currentTimeMillis();
        Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
        list.sort(comparator);
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long removeAllLastLinkedListInteger(LinkedList<Integer> linkedList) {
        long timeStart = System.currentTimeMillis();
        while (linkedList.size() > 0) {
            linkedList.removeLast();
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido removeAllLastLinkedListInteger:{}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long removeAllFirstLinkedListInteger(LinkedList<Integer> linkedList) {
        long timeStart = System.currentTimeMillis();
        while (linkedList.size() > 0) {
            linkedList.removeFirst();
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido removeAllFirstLinkedListInteger:{}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long addArraysToListReverce(List<Integer> list, Integer n) {
        long timeStart = System.currentTimeMillis();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        list.addAll(Arrays.asList(array));
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido addArraysToListReverce: {}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }
}
