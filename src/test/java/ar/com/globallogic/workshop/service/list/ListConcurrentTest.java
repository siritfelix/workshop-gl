package ar.com.globallogic.workshop.service.list;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import ar.com.globallogic.workshop.service.OperationsCollection;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListConcurrentTest {
    private OperationsCollection operationsCollection = new OperationsCollection();

    @Test
    public void create() throws InterruptedException {
        log.info("------------------------------------------------------------------create");
        Double value = Math.pow(10, 4);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 4, size);
        ArrayList<Integer> listIntegerArrayList = new ArrayList<>();
        LinkedList<Integer> listIntegerLinkedList = new LinkedList<>();
        Vector<Integer> listIntegerVector = new Vector<>();
        Stack<Integer> listIntegerStack = new Stack<>();
        log.info("addCollection------------------------------------------------------------------");

        Thread thread1 = new Thread(() -> {
            operationsCollection.addCollection(listIntegerArrayList, size);
            operationsCollection.addCollection(listIntegerLinkedList, size);
            operationsCollection.addCollection(listIntegerVector, size);
            operationsCollection.addCollection(listIntegerStack, size);

        });
        Thread thread2 = new Thread(() -> {
            operationsCollection.addCollection(listIntegerArrayList, size);
            operationsCollection.addCollection(listIntegerLinkedList, size);
            operationsCollection.addCollection(listIntegerVector, size);
            operationsCollection.addCollection(listIntegerStack, size);

        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.info("Tamaños:{},{},{},{}", listIntegerArrayList.size(), listIntegerLinkedList.size(),
                listIntegerVector.size(), listIntegerStack.size());
        assertEquals(2 * size, listIntegerArrayList.size());
        assertEquals(2 * size, listIntegerLinkedList.size());
        assertEquals(2 * size, listIntegerVector.size());
        assertEquals(2 * size, listIntegerStack.size());

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
        log.info("Potencia:{}, cantidad:{}", 4, size);
        ArrayList<Integer> listIntegerArrayList = new ArrayList<>();
        LinkedList<Integer> listIntegerLinkedList = new LinkedList<>();
        Vector<Integer> listIntegerVector = new Vector<>();
        Stack<Integer> listIntegerStack = new Stack<>();
        log.info("addCollection------------------------------------------------------------------");

        Thread thread1 = new Thread(() -> {
            operationsCollection.addCollectionSynchronized(listIntegerArrayList, size);
            operationsCollection.addCollectionSynchronized(listIntegerLinkedList, size);
            operationsCollection.addCollectionSynchronized(listIntegerVector, size);
            operationsCollection.addCollectionSynchronized(listIntegerStack, size);
        });
        Thread thread2 = new Thread(() -> {
            operationsCollection.addCollectionSynchronized(listIntegerArrayList, size);
            operationsCollection.addCollectionSynchronized(listIntegerLinkedList, size);
            operationsCollection.addCollectionSynchronized(listIntegerVector, size);
            operationsCollection.addCollectionSynchronized(listIntegerStack, size);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.info("Tamaños:{},{},{},{}", listIntegerArrayList.size(), listIntegerLinkedList.size(),
                listIntegerVector.size(), listIntegerStack.size());
        assertEquals(2 * size, listIntegerArrayList.size());
        assertEquals(2 * size, listIntegerLinkedList.size());
        assertEquals(2 * size, listIntegerVector.size());
        assertEquals(2 * size, listIntegerStack.size());
    }

    @Test
    public void createSynchronizedN() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            createSynchronized();
        }
    }

    @Test
    public void createSynchronizedList() throws InterruptedException {
        log.info("------------------------------------------------------------------createSynchronizedList");
        Double value = Math.pow(10, 4);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 4, size);
        List<Integer> listIntegerArrayList = Collections.synchronizedList(new ArrayList<>());
        List<Integer> listIntegerLinkedList = Collections.synchronizedList(new LinkedList<>());
        List<Integer> listIntegerVector = Collections.synchronizedList(new Vector<>());
        List<Integer> listIntegerStack = Collections.synchronizedList(new Stack<>());
        log.info("addCollection------------------------------------------------------------------");

        Thread thread1 = new Thread(() -> {
            operationsCollection.addCollection(listIntegerArrayList, size);
            operationsCollection.addCollection(listIntegerLinkedList, size);
            operationsCollection.addCollection(listIntegerVector, size);
            operationsCollection.addCollection(listIntegerStack, size);
        });
        Thread thread2 = new Thread(() -> {
            operationsCollection.addCollection(listIntegerArrayList, size);
            operationsCollection.addCollection(listIntegerLinkedList, size);
            operationsCollection.addCollection(listIntegerVector, size);
            operationsCollection.addCollection(listIntegerStack, size);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.info("Tamaños:{},{},{},{}", listIntegerArrayList.size(), listIntegerLinkedList.size(),
                listIntegerVector.size(), listIntegerStack.size());
        assertEquals(2 * size, listIntegerArrayList.size());
        assertEquals(2 * size, listIntegerLinkedList.size());
        assertEquals(2 * size, listIntegerVector.size());
        assertEquals(2 * size, listIntegerStack.size());
    }

    @Test
    public void createSynchronizedListN() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            createSynchronizedList();
        }
    }

}
