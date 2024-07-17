package ar.com.globallogic.workshop.service.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import ar.com.globallogic.workshop.service.OperationsCollection;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SetConcurrentTest {
    private OperationsCollection operationsCollection = new OperationsCollection();

    @Test
    public void create() throws InterruptedException {
        log.info("------------------------------------------------------------------create");
        Double value = Math.pow(10, 4);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 4, size);
        Set<Integer> hashSetInteger = new HashSet<>();
        Set<Integer> treeSetInteger = new TreeSet<>();
        Set<Integer> linkedHashSetInteger = new LinkedHashSet<>();
        log.info("addCollection------------------------------------------------------------------");

        Thread thread1 = new Thread(() -> {
            operationsCollection.addCollection(hashSetInteger, size);
            operationsCollection.addCollection(treeSetInteger, size);
            operationsCollection.addCollection(linkedHashSetInteger, size);
        });
        Thread thread2 = new Thread(() -> {
            operationsCollection.addCollection(hashSetInteger, size);
            operationsCollection.addCollection(treeSetInteger, size);
            operationsCollection.addCollection(linkedHashSetInteger, size);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.info("Tamaños:{},{},{}", hashSetInteger.size(), treeSetInteger.size(), linkedHashSetInteger.size());
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
        Integer offSet = size;
        log.info("Potencia:{}, cantidad:{}", 4, size);
        Set<Integer> hashSetInteger = new HashSet<>();
        Set<Integer> treeSetInteger = new TreeSet<>();
        Set<Integer> linkedHashSetInteger = new LinkedHashSet<>();
        log.info("addCollection------------------------------------------------------------------");

        Thread thread1 = new Thread(() -> {
            operationsCollection.addCollectionSynchronized(hashSetInteger, size);
            operationsCollection.addCollectionSynchronized(treeSetInteger, size);
            operationsCollection.addCollectionSynchronized(linkedHashSetInteger, size);
        });
        Thread thread2 = new Thread(() -> {
            operationsCollection.addCollectionSynchronized(hashSetInteger, size);
            operationsCollection.addCollectionSynchronized(treeSetInteger, size);
            operationsCollection.addCollectionSynchronized(linkedHashSetInteger, size);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.info("Tamaños:{},{},{}", hashSetInteger.size(), treeSetInteger.size(), linkedHashSetInteger.size());
    }

    @Test
    public void createSynchronizedN() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            createSynchronized();
        }
    }

    @Test
    public void createSynchronizedSet() throws InterruptedException {
        log.info("------------------------------------------------------------------create");
        Double value = Math.pow(10, 4);
        Integer size = value.intValue();
        Integer offSet = size;
        log.info("Potencia:{}, cantidad:{}", 4, size);
        Set<Integer> hashSetInteger = Collections.synchronizedSet(new HashSet<>());
        Set<Integer> treeSetInteger = Collections.synchronizedSet(new TreeSet<>());
        Set<Integer> linkedHashSetInteger = Collections.synchronizedSet(new LinkedHashSet<>());
        log.info("addCollection------------------------------------------------------------------");

        Thread thread1 = new Thread(() -> {
            operationsCollection.addCollection(hashSetInteger, size);
            operationsCollection.addCollection(treeSetInteger, size);
            operationsCollection.addCollection(linkedHashSetInteger, size);
        });
        Thread thread2 = new Thread(() -> {
            operationsCollection.addCollection(hashSetInteger, size, offSet);
            operationsCollection.addCollection(treeSetInteger, size, offSet);
            operationsCollection.addCollection(linkedHashSetInteger, size, offSet);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.info("Tamaños:{},{},{}", hashSetInteger.size(), treeSetInteger.size(), linkedHashSetInteger.size());
    }

    @Test
    public void createSynchronizedSetN() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            createSynchronizedSet();
        }
    }
}
