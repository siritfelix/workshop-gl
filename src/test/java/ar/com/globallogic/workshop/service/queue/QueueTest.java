package ar.com.globallogic.workshop.service.queue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import ar.com.globallogic.workshop.domain.Domain;
import ar.com.globallogic.workshop.service.OperationsCollection;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueueTest {
    private OperationsCollection operationsCollection = new OperationsCollection();
    private OperationsQueue operationsQueue = new OperationsQueue();

    @Test
    public void create() {
        log.info("------------------------------------------------------------------create");
        int size = 10;
        PriorityQueue<Integer> queuePriorityQueue = new PriorityQueue<>();
        LinkedList<Integer> queueLinkedList = new LinkedList<>();
        ArrayDeque<Integer> queueArrayDeque = new ArrayDeque<>();

        operationsCollection.addCollectionReverce(queuePriorityQueue, size);
        operationsCollection.addCollectionReverce(queueLinkedList, size);
        operationsCollection.addCollectionReverce(queueArrayDeque, size);

        operationsCollection.printValuesCollectionInteger(queuePriorityQueue);
        operationsCollection.printValuesCollectionInteger(queueLinkedList);
        operationsCollection.printValuesCollectionInteger(queueArrayDeque);

        operationsQueue.printQueueInteger(queuePriorityQueue);
        operationsQueue.printQueueInteger(queueLinkedList);
        operationsQueue.printQueueInteger(queueArrayDeque);

        assertEquals(0, queuePriorityQueue.size());
        assertEquals(0, queueLinkedList.size());
        assertEquals(0, queueArrayDeque.size());
    }

    @Test
    public void createReverseOrder() {
        log.info("------------------------------------------------------------------createReverseOrder");
        int cantidad = 10;
        PriorityQueue<Integer> queuePriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        LinkedList<Integer> queueLinkedList = new LinkedList<>();
        ArrayDeque<Integer> queueArrayDeque = new ArrayDeque<>();

        operationsCollection.addCollectionReverce(queuePriorityQueue, cantidad);
        operationsCollection.addCollectionReverce(queueLinkedList, cantidad);
        operationsCollection.addCollectionReverce(queueArrayDeque, cantidad);

        operationsCollection.printValuesCollectionInteger(queuePriorityQueue);
        operationsCollection.printValuesCollectionInteger(queueLinkedList);
        operationsCollection.printValuesCollectionInteger(queueArrayDeque);

        operationsQueue.printQueueInteger(queuePriorityQueue);
        operationsQueue.printQueueInteger(queueLinkedList);
        operationsQueue.printQueueInteger(queueArrayDeque);

        assertEquals(0, queuePriorityQueue.size());
        assertEquals(0, queueLinkedList.size());
        assertEquals(0, queueArrayDeque.size());
    }

    @Test
    public void createAndcreateReverseOrder() {
        create();
        createReverseOrder();
    }

    @Test
    public void createDomain() {
        log.info("------------------------------------------------------------------createDomain");
        int cantidad = 5;
        PriorityQueue<Domain> queuePriorityQueue = new PriorityQueue<>();
        LinkedList<Domain> queueLinkedList = new LinkedList<>();
        ArrayDeque<Domain> queueArrayDeque = new ArrayDeque<>();

        operationsCollection.addDomainCollectionReverce(queuePriorityQueue, cantidad);
        operationsCollection.addDomainCollectionReverce(queueLinkedList, cantidad);
        operationsCollection.addDomainCollectionReverce(queueArrayDeque, cantidad);

        operationsQueue.printValuesQueueDomain(queuePriorityQueue);
        operationsQueue.printValuesQueueDomain(queueLinkedList);
        operationsQueue.printValuesQueueDomain(queueArrayDeque);

        assertEquals(0, queuePriorityQueue.size());
        assertEquals(0, queueLinkedList.size());
        assertEquals(0, queueArrayDeque.size());
    }

    @Test
    public void createDomainReverseOrder() {
        log.info("------------------------------------------------------------------createDomainReverseOrder");
        int cantidad = 5;
        PriorityQueue<Domain> queuePriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        LinkedList<Domain> queueLinkedList = new LinkedList<>();
        ArrayDeque<Domain> queueArrayDeque = new ArrayDeque<>();

        operationsCollection.addDomainCollectionReverce(queuePriorityQueue, cantidad);
        operationsCollection.addDomainCollectionReverce(queueLinkedList, cantidad);
        operationsCollection.addDomainCollectionReverce(queueArrayDeque, cantidad);

        operationsQueue.printValuesQueueDomain(queuePriorityQueue);
        operationsQueue.printValuesQueueDomain(queueLinkedList);
        operationsQueue.printValuesQueueDomain(queueArrayDeque);

        assertEquals(0, queuePriorityQueue.size());
        assertEquals(0, queueLinkedList.size());
        assertEquals(0, queueArrayDeque.size());
    }

    @Test
    public void createDomainAndcreateDomainReverseOrder() {
        createDomain();
        createDomainReverseOrder();
    }

    @Test
    public void addCollection() {
        log.info("------------------------------------------------------------------addCollection");
        Queue<Integer> queuePriorityQueue = new PriorityQueue<>();
        Queue<Integer> queueLinkedList = new LinkedList<>();
        Queue<Integer> queueArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 8; i++) {
            Double value = Math.pow(10, i);
            Integer size = value.intValue();
            log.info("Interacion:{}, cantidad:{}", i, size);
            queuePriorityQueue = new PriorityQueue<>();
            queueLinkedList = new LinkedList<>();
            queueArrayDeque = new ArrayDeque<>();
            operationsCollection.addCollectionReverce(queuePriorityQueue, size);
            operationsCollection.addCollectionReverce(queueLinkedList, size);
            operationsCollection.addCollectionReverce(queueArrayDeque, size);
        }
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        assertEquals(size, queuePriorityQueue.size());
        assertEquals(size, queueLinkedList.size());
        assertEquals(size, queueArrayDeque.size());
    }

    @Test
    public void removeCollectionAllLastInteger() {
        log.info("------------------------------------------------------------------removeCollectionAllLastInteger");
        Queue<Integer> queuePriorityQueue = new PriorityQueue<>();
        Queue<Integer> queueLinkedList = new LinkedList<>();
        Queue<Integer> queueArrayDeque = new ArrayDeque<>();
        Double value = Math.pow(10, 5);
        Integer size = value.intValue();
        log.info("Interacion:{}, cantidad:{}", 5, size);
        log.info("Agregando valores");
        operationsCollection.addCollectionReverce(queuePriorityQueue, size);
        operationsCollection.addCollectionReverce(queueLinkedList, size);
        operationsCollection.addCollectionReverce(queueArrayDeque, size);
        log.info("Eliminando valores desde el ultimo elemento collections");
        operationsCollection.removeCollectionAllLastInteger(queuePriorityQueue);
        operationsCollection.removeCollectionAllLastInteger(queueLinkedList);
        operationsCollection.removeCollectionAllLastInteger(queueArrayDeque);
        log.info("Tamaños:{},{},{}", queuePriorityQueue.size(), queueLinkedList.size(), queueArrayDeque.size());
        assertEquals(0, queuePriorityQueue.size());
        assertEquals(0, queueLinkedList.size());
        assertEquals(0, queueArrayDeque.size());
    }

    @Test
    public void removeCollectionAllFirstInteger() {
        log.info("------------------------------------------------------------------removeCollectionAllFirstInteger");
        Queue<Integer> queuePriorityQueue = new PriorityQueue<>();
        Queue<Integer> queueLinkedList = new LinkedList<>();
        Queue<Integer> queueArrayDeque = new ArrayDeque<>();
        Double value = Math.pow(10, 5);
        Integer size = value.intValue();
        log.info("Interacion:{}, cantidad:{}", 5, size);
        log.info("Agregando valores");
        operationsCollection.addCollectionReverce(queuePriorityQueue, size);
        operationsCollection.addCollectionReverce(queueLinkedList, size);
        operationsCollection.addCollectionReverce(queueArrayDeque, size);
        log.info("Eliminando valores desde el primer elemento collections");
        operationsCollection.removeCollectionAllFirstInteger(queuePriorityQueue);
        operationsCollection.removeCollectionAllFirstInteger(queueLinkedList);
        operationsCollection.removeCollectionAllFirstInteger(queueArrayDeque);
        log.info("Tamaños:{},{},{}", queuePriorityQueue.size(), queueLinkedList.size(), queueArrayDeque.size());
        assertEquals(0, queuePriorityQueue.size());
        assertEquals(0, queueLinkedList.size());
        assertEquals(0, queueArrayDeque.size());
    }

    @Test
    public void removeAllQueue() {
        log.info("------------------------------------------------------------------removeAllQueue");
        Queue<Integer> queuePriorityQueue = new PriorityQueue<>();
        Queue<Integer> queueLinkedList = new LinkedList<>();
        Queue<Integer> queueArrayDeque = new ArrayDeque<>();
        Double value = Math.pow(10, 5);
        Integer size = value.intValue();
        log.info("Interacion:{}, cantidad:{}", 5, size);
        log.info("Agregando valores");
        operationsCollection.addCollectionReverce(queuePriorityQueue, size);
        operationsCollection.addCollectionReverce(queueLinkedList, size);
        operationsCollection.addCollectionReverce(queueArrayDeque, size);
        log.info("Eliminando valores desde el primer elemento queue");
        operationsQueue.removeAllQueue(queuePriorityQueue);
        operationsQueue.removeAllQueue(queueLinkedList);
        operationsQueue.removeAllQueue(queueArrayDeque);
        log.info("Tamaños:{},{},{}", queuePriorityQueue.size(), queueLinkedList.size(), queueArrayDeque.size());
        assertEquals(0, queuePriorityQueue.size());
        assertEquals(0, queueLinkedList.size());
        assertEquals(0, queueArrayDeque.size());
    }

    @Test
    public void compareRemoveCollectionsAndQueue() {
        log.info("------------------------------------------------------------------compareRemoveCollectionsAndQueue");
        removeCollectionAllLastInteger();
        removeCollectionAllFirstInteger();
        removeAllQueue();
    }

    @Test
    public void sortLargestSmallestAndsortSmallestLargest() {
        log.info("---------------------------------------------------------sortLargestSmallestAndsortSmallestLargest");

        LinkedList<Integer> queueLinkedList = new LinkedList<>();
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 5, size);
        operationsCollection.addCollection(queueLinkedList, size);
        log.info("operationsQueue.sortLargestSmallest(queueLinkedList):{}",
                operationsQueue.sortLargestSmallest(queueLinkedList));
        log.info(" operationsQueue.sortSmallestLargest(queueLinkedList):{}",
                operationsQueue.sortSmallestLargest(queueLinkedList));

    }

    @Test
    public void iterableVsForeach() {
        log.info("------------------------------------------------------------------iterableVsForeach");
        Queue<Integer> queuePriorityQueue = new PriorityQueue<>();
        Queue<Integer> queueLinkedList = new LinkedList<>();
        Queue<Integer> queueArrayDeque = new ArrayDeque<>();
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        log.info("Interacion:{}, cantidad:{}", 7, size);
        log.info("Agregando valores");
        operationsCollection.addCollectionReverce(queuePriorityQueue, size);
        operationsCollection.addCollectionReverce(queueLinkedList, size);
        operationsCollection.addCollectionReverce(queueArrayDeque, size);
        log.info("operationsCollection.useIterableCollection(queuePriorityQueue)):{}",
                operationsCollection.useIterableCollection(queuePriorityQueue));
        log.info("operationsCollection.useIterableCollection(queueLinkedList):{}",
                operationsCollection.useIterableCollection(queueLinkedList));
        log.info("operationsCollection.useIterableCollection(queueArrayDeque):{}",
                operationsCollection.useIterableCollection(queueArrayDeque));

        log.info("operationsCollection.useForEachCollection(queuePriorityQueue):{}",
                operationsCollection.useForEachCollection(queuePriorityQueue));
        log.info("operationsCollection.useForEachCollection(queueLinkedList):{}",
                operationsCollection.useForEachCollection(queueLinkedList));
        log.info("operationsCollection.useForEachCollection(queueArrayDeque):{}",
                operationsCollection.useForEachCollection(queueArrayDeque));
    }
}
