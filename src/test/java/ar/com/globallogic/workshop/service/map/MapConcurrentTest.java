package ar.com.globallogic.workshop.service.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapConcurrentTest {
    private OperationsMap operationsMap = new OperationsMap();

    @Test
    public void create() throws InterruptedException {
        log.info("------------------------------------------------------------------create");
        Double value = Math.pow(10, 4);
        Integer size = value.intValue();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        log.info("addIntegerMapReverce------------------------------------------------------------------");

        Thread thread1 = new Thread(() -> {
            operationsMap.addIntegerMapReverce(hashMap, size);
            operationsMap.addIntegerMapReverce(linkedHashMap, size);
            operationsMap.addIntegerMapReverce(treeMap, size);

        });
        Thread thread2 = new Thread(() -> {
            operationsMap.addIntegerMapReverce(hashMap, size);
            operationsMap.addIntegerMapReverce(linkedHashMap, size);
            operationsMap.addIntegerMapReverce(treeMap, size);

        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.info("Tamaños:{},{},{}", hashMap.size(), linkedHashMap.size(),
                treeMap.size());
        assertEquals(size, hashMap.size());
        assertEquals(size, linkedHashMap.size());
        assertEquals(size, treeMap.size());
    }

    @Test
    public void createN() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            create();
        }
    }

    @Test
    public void createSynchronized() throws InterruptedException {
        log.info("------------------------------------------------------------------createSynchronized");
        Double value = Math.pow(10, 4);
        Integer size = value.intValue();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        log.info("addIntegerMapReverce------------------------------------------------------------------");

        Thread thread1 = new Thread(() -> {
            operationsMap.addIntegerMapReverceSynchronized(hashMap, size);
            operationsMap.addIntegerMapReverceSynchronized(linkedHashMap, size);
            operationsMap.addIntegerMapReverceSynchronized(treeMap, size);

        });
        Thread thread2 = new Thread(() -> {
            operationsMap.addIntegerMapReverceSynchronized(hashMap, size);
            operationsMap.addIntegerMapReverceSynchronized(linkedHashMap, size);
            operationsMap.addIntegerMapReverceSynchronized(treeMap, size);

        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.info("Tamaños:{},{},{}", hashMap.size(), linkedHashMap.size(),
                treeMap.size());
        assertEquals(size, hashMap.size());
        assertEquals(size, linkedHashMap.size());
        assertEquals(size, treeMap.size());
    }

    @Test
    public void createSynchronizedN() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            createSynchronized();
        }
    }

    @Test
    public void createSynchronizedMap() throws InterruptedException {
        log.info("------------------------------------------------------------------createSynchronizedMap");
        Double value = Math.pow(10, 4);
        Integer size = value.intValue();
        Map<Integer, Integer> hashMap = Collections.synchronizedMap(new HashMap<>());
        Map<Integer, Integer> linkedHashMap = Collections.synchronizedMap(new LinkedHashMap<>());
        SortedMap<Integer, Integer> treeMap = Collections.synchronizedSortedMap(new TreeMap<>());
        log.info("addIntegerMapReverce------------------------------------------------------------------");

        Thread thread1 = new Thread(() -> {
            operationsMap.addIntegerMapReverceOffSet(hashMap, size, 0);
            operationsMap.addIntegerMapReverceOffSet(linkedHashMap, size, 0);
            operationsMap.addIntegerMapReverceOffSet(treeMap, size, 0);

        });
        Thread thread2 = new Thread(() -> {
            operationsMap.addIntegerMapReverceOffSet(hashMap, size, size);
            operationsMap.addIntegerMapReverceOffSet(linkedHashMap, size, size);
            operationsMap.addIntegerMapReverceOffSet(treeMap, size, size);

        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.info("Tamaños:{},{},{}", hashMap.size(), linkedHashMap.size(),
                treeMap.size());
        assertEquals(2 * size, hashMap.size());
        assertEquals(2 * size, linkedHashMap.size());
        assertEquals(2 * size, treeMap.size());
    }

    @Test
    public void createSynchronizedMapN() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            createSynchronizedMap();
        }
    }

}
