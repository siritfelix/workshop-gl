package ar.com.globallogic.workshop.service.queue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.PriorityBlockingQueue;

import org.junit.jupiter.api.Test;

import ar.com.globallogic.workshop.service.OperationsCollection;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueueConcurrentTest {
    private OperationsCollection operationsCollection = new OperationsCollection();

    @Test
    public void create() throws InterruptedException {
        log.info("------------------------------------------------------------------create");
        Double value = Math.pow(10, 4);
        Integer size = value.intValue();
        PriorityQueue<Integer> queuePriorityQueue = new PriorityQueue<>();
        LinkedList<Integer> queueLinkedList = new LinkedList<>();
        ArrayDeque<Integer> queueArrayDeque = new ArrayDeque<>();
        log.info("addCollection------------------------------------------------------------------");
        Thread thread1 = new Thread(() -> {
            operationsCollection.addCollectionReverce(queuePriorityQueue, size);
            operationsCollection.addCollectionReverce(queueLinkedList, size);
            operationsCollection.addCollectionReverce(queueArrayDeque, size);
        });
        Thread thread2 = new Thread(() -> {
            operationsCollection.addCollectionReverce(queuePriorityQueue, size);
            operationsCollection.addCollectionReverce(queueLinkedList, size);
            operationsCollection.addCollectionReverce(queueArrayDeque, size);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.info("Tamaños:{},{},{}", queuePriorityQueue.size(), queueLinkedList.size(),
                queueArrayDeque.size());
        assertEquals(2 * size, queuePriorityQueue.size());
        assertEquals(2 * size, queueLinkedList.size());
        assertEquals(2 * size, queueArrayDeque.size());
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
        PriorityQueue<Integer> queuePriorityQueue = new PriorityQueue<>();
        LinkedList<Integer> queueLinkedList = new LinkedList<>();
        ArrayDeque<Integer> queueArrayDeque = new ArrayDeque<>();
        log.info("addCollection------------------------------------------------------------------");
        Thread thread1 = new Thread(() -> {
            operationsCollection.addCollectionSynchronized(queuePriorityQueue, size);
            operationsCollection.addCollectionSynchronized(queueLinkedList, size);
            operationsCollection.addCollectionSynchronized(queueArrayDeque, size);
        });
        Thread thread2 = new Thread(() -> {
            operationsCollection.addCollectionSynchronized(queuePriorityQueue, size);
            operationsCollection.addCollectionSynchronized(queueLinkedList, size);
            operationsCollection.addCollectionSynchronized(queueArrayDeque, size);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.info("Tamaños:{},{},{}", queuePriorityQueue.size(), queueLinkedList.size(),
                queueArrayDeque.size());
        assertEquals(2 * size, queuePriorityQueue.size());
        assertEquals(2 * size, queueLinkedList.size());
        assertEquals(2 * size, queueArrayDeque.size());
    }

    @Test
    public void createSynchronizedN() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            createSynchronized();
        }
    }

    @Test
    public void createSynchronizedQueue() throws InterruptedException {
        log.info("------------------------------------------------------------------create");
        Double value = Math.pow(10, 4);
        Integer size = value.intValue();
        PriorityBlockingQueue<Integer> queuePriorityQueue = new PriorityBlockingQueue<>();
        List<Integer> queueLinkedList = Collections.synchronizedList(new LinkedList<>());
        ConcurrentLinkedDeque<Integer> queueArrayDeque = new ConcurrentLinkedDeque<>();

        log.info("addCollection------------------------------------------------------------------");
        Thread thread1 = new Thread(() -> {
            operationsCollection.addCollectionReverce(queuePriorityQueue, size);
            operationsCollection.addCollectionReverce(queueLinkedList, size);
            operationsCollection.addCollectionReverce(queueArrayDeque, size);
        });
        Thread thread2 = new Thread(() -> {
            operationsCollection.addCollectionReverce(queuePriorityQueue, size);
            operationsCollection.addCollectionReverce(queueLinkedList, size);
            operationsCollection.addCollectionReverce(queueArrayDeque, size);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.info("Tamaños:{},{},{}", queuePriorityQueue.size(), queueLinkedList.size(),
                queueArrayDeque.size());
        assertEquals(2 * size, queuePriorityQueue.size());
        assertEquals(2 * size, queueLinkedList.size());
        assertEquals(2 * size, queueArrayDeque.size());
    }

    @Test
    public void createSynchronizedQueueN() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            createSynchronizedQueue();
        }
    }
}
