package ar.com.globallogic.workshop.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StackQueueListTest {
    private OperationsCollection operationsCollection = new OperationsCollection();
    private OperationsStackQueue operationsStackQueue = new OperationsStackQueue();

    @Test
    public void addCollectionAndStack() {
        log.info("------------------------------------------------------------------addCollectionAndStack");
        ArrayList<Integer> listIntegerArrayList = new ArrayList<>();
        Stack<Integer> listIntegerStack = new Stack<>();
        ArrayDeque<Integer> queueArrayDeque = new ArrayDeque<>();

        for (int i = 0; i < 8; i++) {
            Double value = Math.pow(10, i);
            Integer size = value.intValue();
            log.info("Potencia:{}, cantidad:{}", i, size);

            listIntegerArrayList = new ArrayList<>();
            listIntegerStack = new Stack<>();
            queueArrayDeque = new ArrayDeque<>();

            operationsCollection.addCollection(listIntegerArrayList, size);
            operationsStackQueue.addStack(listIntegerStack, size);
            operationsStackQueue.addQueue(queueArrayDeque, size);
        }
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        assertEquals(size, listIntegerArrayList.size());
        assertEquals(size, listIntegerStack.size());
        assertEquals(size, queueArrayDeque.size());
    }

    @Test
    public void remove() {
        Double value = Math.pow(10, 1);
        Integer size = value.intValue();
        Stack<Integer> listIntegerStack = new Stack<>();
        ArrayDeque<Integer> queueArrayDeque = new ArrayDeque<>();
        operationsStackQueue.addStack(listIntegerStack, size);
        operationsStackQueue.addQueue(queueArrayDeque, size);
        operationsCollection.printValuesCollectionInteger(listIntegerStack);
        operationsCollection.printValuesCollectionInteger(queueArrayDeque);
        while (!listIntegerStack.isEmpty()) {
            log.info("Valor eliminado pila: {}, Valor eliminado cola: {}", listIntegerStack.pop(),
                    queueArrayDeque.poll());
            operationsCollection.printValuesCollectionInteger(listIntegerStack);
            operationsCollection.printValuesCollectionInteger(queueArrayDeque);
        }

        assertEquals(0, listIntegerStack.size());
        assertEquals(0, queueArrayDeque.size());
    }

    @Test
    public void removeCollectionAndStackAllLastInteger() {
        log.info(
                "------------------------------------------------------------------removeCollectionAndStackAllLastInteger");
        List<Integer> listIntegerArrayList = new ArrayList<>();
        Stack<Integer> listIntegerStack = new Stack<>();
        ArrayDeque<Integer> queueArrayDeque = new ArrayDeque<>();
        ArrayDeque<Integer> queueArrayDequeLifo = new ArrayDeque<>();
        Double value = Math.pow(10, 5);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 5, size);
        log.info("Agregando valores");
        operationsCollection.addCollection(listIntegerArrayList, size);
        operationsStackQueue.addStack(listIntegerStack, size);
        operationsStackQueue.addQueue(queueArrayDeque, size);
        operationsStackQueue.addQueue(queueArrayDequeLifo, size);
        log.info("Eliminando valores desde el ultimo elemento collections");
        operationsCollection.removeCollectionAllLastInteger(listIntegerArrayList);
        operationsStackQueue.removeStack(listIntegerStack);
        operationsStackQueue.removeQueue(queueArrayDeque);
        operationsStackQueue.removeLastQueue(queueArrayDequeLifo);
        log.info("Tamaños:{},{},{},{}", listIntegerArrayList.size(), listIntegerStack.size(),
                queueArrayDeque.size(), queueArrayDequeLifo.size());
        assertEquals(0, listIntegerArrayList.size());
        assertEquals(0, listIntegerStack.size());
        assertEquals(0, queueArrayDeque.size());

    }

}
