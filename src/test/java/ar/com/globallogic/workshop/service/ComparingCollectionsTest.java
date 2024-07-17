package ar.com.globallogic.workshop.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import ar.com.globallogic.workshop.service.list.OperationsList;
import ar.com.globallogic.workshop.service.queue.OperationsQueue;
import ar.com.globallogic.workshop.service.set.OperationsSet;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComparingCollectionsTest {
    private OperationsCollection operationsCollection = new OperationsCollection();
    private OperationsList operationsList = new OperationsList();
    private OperationsSet operationsSet = new OperationsSet();
    private OperationsQueue operationsQueue = new OperationsQueue();

    @Test
    public void addCollection() {
        List<Integer> listIntegerArrayList = new ArrayList<>();
        List<Integer> listIntegerLinkedList = new LinkedList<>();
        List<Integer> listIntegerVector = new Vector<>();
        List<Integer> listIntegerStatck = new Stack<>();
        Set<Integer> hashSetInteger = new HashSet<>();
        Set<Integer> treeSetInteger = new TreeSet<>();
        Set<Integer> linkedHashSetInteger = new LinkedHashSet<>();
        Queue<Integer> queuePriorityQueue = new PriorityQueue<>();
        Queue<Integer> queueLinkedList = new LinkedList<>();
        Queue<Integer> queueArrayDeque = new ArrayDeque<>();
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        log.info("Interacion:{}, cantidad:{}", 7, size);
        log.info("Agregando valores");
        log.info("-------------------------------------------------List");
        operationsCollection.addCollectionReverce(listIntegerArrayList, size);
        operationsCollection.addCollectionReverce(listIntegerLinkedList, size);
        operationsCollection.addCollectionReverce(listIntegerVector, size);
        operationsCollection.addCollectionReverce(listIntegerStatck, size);
        log.info("-------------------------------------------------Set");
        operationsCollection.addCollectionReverce(hashSetInteger, size);
        operationsCollection.addCollectionReverce(treeSetInteger, size);
        operationsCollection.addCollectionReverce(linkedHashSetInteger, size);
        log.info("-------------------------------------------------Queue");
        operationsCollection.addCollectionReverce(queuePriorityQueue, size);
        operationsCollection.addCollectionReverce(queueLinkedList, size);
        operationsCollection.addCollectionReverce(queueArrayDeque, size);
    }

    @Test
    public void removeCollections() {
        log.info("--------------------------------------------------------------removeCollections");
        List<Integer> listIntegerArrayList = new ArrayList<>();
        List<Integer> listIntegerLinkedList = new LinkedList<>();
        List<Integer> listIntegerVector = new Vector<>();
        List<Integer> listIntegerStatck = new Stack<>();
        Set<Integer> hashSetInteger = new HashSet<>();
        Set<Integer> treeSetInteger = new TreeSet<>();
        Set<Integer> linkedHashSetInteger = new LinkedHashSet<>();
        Queue<Integer> queuePriorityQueue = new PriorityQueue<>();
        Queue<Integer> queueLinkedList = new LinkedList<>();
        Queue<Integer> queueArrayDeque = new ArrayDeque<>();
        Double value = Math.pow(10, 5);
        Integer size = value.intValue();
        log.info("Interacion:{}, cantidad:{}", 5, size);
        log.info("Agregando valores");
        log.info("-------------------------------------------------List");
        operationsCollection.addCollectionReverce(listIntegerArrayList, size);
        operationsCollection.addCollectionReverce(listIntegerLinkedList, size);
        operationsCollection.addCollectionReverce(listIntegerVector, size);
        operationsCollection.addCollectionReverce(listIntegerStatck, size);
        log.info("-------------------------------------------------Set");
        operationsCollection.addCollectionReverce(hashSetInteger, size);
        operationsCollection.addCollectionReverce(treeSetInteger, size);
        operationsCollection.addCollectionReverce(linkedHashSetInteger, size);
        log.info("-------------------------------------------------Queue");
        operationsCollection.addCollectionReverce(queuePriorityQueue, size);
        operationsCollection.addCollectionReverce(queueLinkedList, size);
        operationsCollection.addCollectionReverce(queueArrayDeque, size);

        log.info("Eliminando valores desde el primer elemento de la lista");
        operationsCollection.removeCollectionAllFirstInteger(listIntegerArrayList);
        operationsCollection.removeCollectionAllFirstInteger(listIntegerLinkedList);
        operationsCollection.removeCollectionAllFirstInteger(listIntegerVector);
        operationsCollection.removeCollectionAllFirstInteger(listIntegerStatck);
        log.info("Eliminando valores desde el primer elemento del set");
        operationsCollection.removeCollectionAllFirstInteger(hashSetInteger);
        operationsCollection.removeCollectionAllFirstInteger(treeSetInteger);
        operationsCollection.removeCollectionAllFirstInteger(linkedHashSetInteger);
        log.info("Eliminando valores desde el primer elemento de la queue");
        operationsCollection.removeCollectionAllFirstInteger(queuePriorityQueue);
        operationsCollection.removeCollectionAllFirstInteger(queueLinkedList);
        operationsCollection.removeCollectionAllFirstInteger(queueArrayDeque);
    }

    @Test
    public void removeCollectionsAndListAndQueue() {
        log.info("--------------------------------------------------------------removeCollectionsAndListAndQueue");
        List<Integer> listIntegerArrayList = new ArrayList<>();
        List<Integer> listIntegerLinkedList = new LinkedList<>();
        List<Integer> listIntegerVector = new Vector<>();
        List<Integer> listIntegerStatck = new Stack<>();
        List<Integer> listIntegerArrayList2 = new ArrayList<>();
        List<Integer> listIntegerLinkedList2 = new LinkedList<>();
        List<Integer> listIntegerVector2 = new Vector<>();
        List<Integer> listIntegerStatck2 = new Stack<>();
        Set<Integer> hashSetInteger = new HashSet<>();
        Set<Integer> treeSetInteger = new TreeSet<>();
        Set<Integer> linkedHashSetInteger = new LinkedHashSet<>();
        Queue<Integer> queuePriorityQueue = new PriorityQueue<>();
        Queue<Integer> queueLinkedList = new LinkedList<>();
        Queue<Integer> queueArrayDeque = new ArrayDeque<>();
        Double value = Math.pow(10, 5);
        Integer size = 3 * value.intValue();
        log.info("Interacion:{}, cantidad:{}", 5, size);
        log.info("Agregando valores");
        log.info("-------------------------------------------------List");
        operationsCollection.addCollectionReverce(listIntegerArrayList, size);
        operationsCollection.addCollectionReverce(listIntegerLinkedList, size);
        operationsCollection.addCollectionReverce(listIntegerVector, size);
        operationsCollection.addCollectionReverce(listIntegerStatck, size);
        operationsCollection.addCollectionReverce(listIntegerArrayList2, size);
        operationsCollection.addCollectionReverce(listIntegerLinkedList2, size);
        operationsCollection.addCollectionReverce(listIntegerVector2, size);
        operationsCollection.addCollectionReverce(listIntegerStatck2, size);
        log.info("-------------------------------------------------Set");
        operationsCollection.addCollectionReverce(hashSetInteger, size);
        operationsCollection.addCollectionReverce(treeSetInteger, size);
        operationsCollection.addCollectionReverce(linkedHashSetInteger, size);
        log.info("-------------------------------------------------Queue");
        operationsCollection.addCollectionReverce(queuePriorityQueue, size);
        operationsCollection.addCollectionReverce(queueLinkedList, size);
        operationsCollection.addCollectionReverce(queueArrayDeque, size);

        log.info("Eliminando valores desde el primer elemento de la lista");
        operationsList.removeAllFirstListInteger(listIntegerArrayList);
        operationsList.removeAllFirstListInteger(listIntegerLinkedList);
        operationsList.removeAllFirstListInteger(listIntegerVector);
        operationsList.removeAllFirstListInteger(listIntegerStatck);
        log.info("Eliminando valores desde el ultimo elemento de la lista");
        operationsList.removeAllLastListInteger(listIntegerArrayList2);
        operationsList.removeAllLastListInteger(listIntegerLinkedList2);
        operationsList.removeAllLastListInteger(listIntegerVector2);
        operationsList.removeAllLastListInteger(listIntegerStatck2);
        log.info("Eliminando valores desde el ultimo elemento del set");
        operationsCollection.removeCollectionAllLastInteger(hashSetInteger);
        operationsCollection.removeCollectionAllLastInteger(treeSetInteger);
        operationsCollection.removeCollectionAllLastInteger(linkedHashSetInteger);
        log.info("Eliminando valores de la queue");
        operationsQueue.removeAllQueue(queuePriorityQueue);
        operationsQueue.removeAllQueue(queueLinkedList);
        operationsQueue.removeAllQueue(queueArrayDeque);
    }

    @Test
    public void removeCollectionsAndremoveCollectionsAndListAndQueue() {
        removeCollections();
        removeCollectionsAndListAndQueue();
    }

}