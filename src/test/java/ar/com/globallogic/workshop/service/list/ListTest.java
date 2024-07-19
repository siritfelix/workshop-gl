package ar.com.globallogic.workshop.service.list;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import ar.com.globallogic.workshop.service.OperationsCollection;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListTest {
    private OperationsCollection operationsCollection = new OperationsCollection();
    private OperationsList operationsList = new OperationsList();

    @Test
    public void create() {
        log.info("------------------------------------------------------------------create");
        int size = 10;
        ArrayList<Integer> listIntegerArrayList = new ArrayList<>();
        LinkedList<Integer> listIntegerLinkedList = new LinkedList<>();
        Vector<Integer> listIntegerVector = new Vector<>();
        Stack<Integer> listIntegerStack = new Stack<>();

        operationsCollection.addCollection(listIntegerArrayList, size);
        operationsCollection.addCollection(listIntegerLinkedList, size);
        operationsCollection.addCollection(listIntegerVector, size);
        operationsCollection.addCollection(listIntegerStack, size);

        operationsCollection.printValuesCollectionInteger(listIntegerArrayList);
        operationsCollection.printValuesCollectionInteger(listIntegerLinkedList);
        operationsCollection.printValuesCollectionInteger(listIntegerVector);
        operationsCollection.printValuesCollectionInteger(listIntegerStack);

        assertEquals(size, listIntegerArrayList.size());
        assertEquals(size, listIntegerLinkedList.size());
        assertEquals(size, listIntegerVector.size());
        assertEquals(size, listIntegerStack.size());

    }

    @Test
    public void addCollection() {
        log.info("------------------------------------------------------------------addCollection");
        ArrayList<Integer> listIntegerArrayList = new ArrayList<>();
        LinkedList<Integer> listIntegerLinkedList = new LinkedList<>();
        Vector<Integer> listIntegerVector = new Vector<>();
        Stack<Integer> listIntegerStack = new Stack<>();
        for (int i = 0; i < 8; i++) {
            Double value = Math.pow(10, i);
            Integer size = value.intValue();
            log.info("Potencia:{}, cantidad:{}", i, size);
            listIntegerArrayList = new ArrayList<>();
            listIntegerLinkedList = new LinkedList<>();
            listIntegerVector = new Vector<>();
            listIntegerStack = new Stack<>();
            operationsCollection.addCollection(listIntegerArrayList, size);
            operationsCollection.addCollection(listIntegerLinkedList, size);
            operationsCollection.addCollection(listIntegerVector, size);
            operationsCollection.addCollection(listIntegerStack, size);
        }
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        assertEquals(size, listIntegerArrayList.size());
        assertEquals(size, listIntegerLinkedList.size());
        assertEquals(size, listIntegerVector.size());
        assertEquals(size, listIntegerStack.size());

    }

    @Test
    public void removeCollectionAllLastInteger() {
        log.info("------------------------------------------------------------------removeCollectionAllLastInteger");
        List<Integer> listIntegerArrayList = new ArrayList<>();
        List<Integer> listIntegerLinkedList = new LinkedList<>();
        List<Integer> listIntegerVector = new Vector<>();
        List<Integer> listIntegerStack = new Stack<>();
        Double value = Math.pow(10, 5);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 5, size);
        log.info("Agregando valores");
        operationsCollection.addCollection(listIntegerArrayList, size);
        operationsCollection.addCollection(listIntegerLinkedList, size);
        operationsCollection.addCollection(listIntegerVector, size);
        operationsCollection.addCollection(listIntegerStack, size);
        log.info("Eliminando valores desde el ultimo elemento collections");
        operationsCollection.removeCollectionAllLastInteger(listIntegerArrayList);
        operationsCollection.removeCollectionAllLastInteger(listIntegerLinkedList);
        operationsCollection.removeCollectionAllLastInteger(listIntegerVector);
        operationsCollection.removeCollectionAllLastInteger(listIntegerStack);
        log.info("Tamaños:{},{},{},{}", listIntegerArrayList.size(), listIntegerLinkedList.size(),
                listIntegerVector.size(), listIntegerStack.size());
        assertEquals(0, listIntegerArrayList.size());
        assertEquals(0, listIntegerLinkedList.size());
        assertEquals(0, listIntegerVector.size());
        assertEquals(0, listIntegerStack.size());

    }

    @Test
    public void removeCollectionAllFirstInteger() {
        log.info("------------------------------------------------------------------removeCollectionAllFirstInteger");
        List<Integer> listIntegerArrayList = new ArrayList<>();
        List<Integer> listIntegerLinkedList = new LinkedList<>();
        List<Integer> listIntegerVector = new Vector<>();
        List<Integer> listIntegerStack = new Stack<>();
        Double value = Math.pow(10, 5);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 5, size);
        log.info("Agregando valores");
        operationsCollection.addCollection(listIntegerArrayList, size);
        operationsCollection.addCollection(listIntegerLinkedList, size);
        operationsCollection.addCollection(listIntegerVector, size);
        operationsCollection.addCollection(listIntegerStack, size);
        log.info("Eliminando valores desde el primer elemento collections");
        operationsCollection.removeCollectionAllFirstInteger(listIntegerArrayList);
        operationsCollection.removeCollectionAllFirstInteger(listIntegerLinkedList);
        operationsCollection.removeCollectionAllFirstInteger(listIntegerVector);
        operationsCollection.removeCollectionAllFirstInteger(listIntegerStack);
        log.info("Tamaños:{},{},{},{}", listIntegerArrayList.size(), listIntegerLinkedList.size(),
                listIntegerVector.size(), listIntegerStack.size());
        assertEquals(0, listIntegerArrayList.size());
        assertEquals(0, listIntegerLinkedList.size());
        assertEquals(0, listIntegerVector.size());
        assertEquals(0, listIntegerStack.size());
    }

    @Test
    public void compareRemoveCollections() {
        log.info("------------------------------------------------------------------compareRemoveCollections");
        removeCollectionAllLastInteger();
        removeCollectionAllFirstInteger();
    }

    @Test
    public void removeAllLastListInteger() {
        log.info("------------------------------------------------------------------removeAllLastListInteger");
        List<Integer> listIntegerArrayList = new ArrayList<>();
        List<Integer> listIntegerLinkedList = new LinkedList<>();
        List<Integer> listIntegerVector = new Vector<>();
        List<Integer> listIntegerStack = new Stack<>();
        Double value = Math.pow(10, 5);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 5, size);
        log.info("Agregando valores");
        operationsCollection.addCollection(listIntegerArrayList, size);
        operationsCollection.addCollection(listIntegerLinkedList, size);
        operationsCollection.addCollection(listIntegerVector, size);
        operationsCollection.addCollection(listIntegerStack, size);
        log.info("Eliminando valores desde el ultimo elemento de la lista");
        operationsList.removeAllLastListInteger(listIntegerArrayList);
        operationsList.removeAllLastListInteger(listIntegerLinkedList);
        operationsList.removeAllLastListInteger(listIntegerVector);
        operationsList.removeAllLastListInteger(listIntegerStack);
        log.info("Tamaños:{},{},{},{}", listIntegerArrayList.size(), listIntegerLinkedList.size(),
                listIntegerVector.size(), listIntegerStack.size());
        assertEquals(0, listIntegerArrayList.size());
        assertEquals(0, listIntegerLinkedList.size());
        assertEquals(0, listIntegerVector.size());
        assertEquals(0, listIntegerStack.size());

    }

    @Test
    public void removeAllFirstListInteger() {
        log.info("------------------------------------------------------------------removeAllFirstListInteger");
        List<Integer> listIntegerArrayList = new ArrayList<>();
        List<Integer> listIntegerLinkedList = new LinkedList<>();
        List<Integer> listIntegerVector = new Vector<>();
        List<Integer> listIntegerStack = new Stack<>();
        Double value = Math.pow(10, 5);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 5, size);
        log.info("Agregando valores");
        operationsCollection.addCollection(listIntegerArrayList, size);
        operationsCollection.addCollection(listIntegerLinkedList, size);
        operationsCollection.addCollection(listIntegerVector, size);
        operationsCollection.addCollection(listIntegerStack, size);
        log.info("Eliminando valores desde el primer elemento de la lista");
        operationsList.removeAllFirstListInteger(listIntegerArrayList);
        operationsList.removeAllFirstListInteger(listIntegerLinkedList);
        operationsList.removeAllFirstListInteger(listIntegerVector);
        operationsList.removeAllFirstListInteger(listIntegerStack);
        log.info("Tamaños:{},{},{},{}", listIntegerArrayList.size(), listIntegerLinkedList.size(),
                listIntegerVector.size(), listIntegerStack.size());
        assertEquals(0, listIntegerArrayList.size());
        assertEquals(0, listIntegerLinkedList.size());
        assertEquals(0, listIntegerVector.size());
        assertEquals(0, listIntegerStack.size());
    }

    @Test
    public void compareRemoveList() {
        log.info("------------------------------------------------------------------compareRemoveList");
        removeAllLastListInteger();
        removeAllFirstListInteger();
    }

    @Test
    public void compareRemoveListAndCollectins() {
        log.info("------------------------------------------------------------------compareRemoveListAndCollectins");
        removeCollectionAllLastInteger();
        removeCollectionAllFirstInteger();
        removeAllLastListInteger();
        removeAllFirstListInteger();
    }

    @Test
    public void removeListAndALinkedListFirt() {
        log.info("------------------------------------------------------------------removeListAndALinkedListFirt");
        ArrayList<Integer> listIntegerArrayList = new ArrayList<>();
        LinkedList<Integer> listIntegerLinkedList = new LinkedList<>();
        Double value = Math.pow(10, 5);
        Integer size = value.intValue();
        operationsCollection.addCollection(listIntegerArrayList, size);
        operationsCollection.addCollection(listIntegerLinkedList, size);
        log.info("Eliminando valores desde el primer elemento de la lista");
        operationsList.removeAllFirstListInteger(listIntegerArrayList);
        operationsList.removeAllFirstLinkedListInteger(listIntegerLinkedList);
        assertEquals(0, listIntegerArrayList.size());
        assertEquals(0, listIntegerLinkedList.size());
    }

    @Test
    public void removeListAndALinkedListLast() {
        log.info("------------------------------------------------------------------removeListAndALinkedListLast");
        ArrayList<Integer> listIntegerArrayList = new ArrayList<>();
        LinkedList<Integer> listIntegerLinkedList = new LinkedList<>();
        Double value = Math.pow(10, 5);
        Integer size = value.intValue();
        operationsCollection.addCollection(listIntegerArrayList, size);
        operationsCollection.addCollection(listIntegerLinkedList, size);
        log.info("Eliminando valores desde el ultimo elemento de la lista");
        operationsList.removeAllLastListInteger(listIntegerArrayList);
        operationsList.removeAllLastLinkedListInteger(listIntegerLinkedList);
        assertEquals(0, listIntegerArrayList.size());
        assertEquals(0, listIntegerLinkedList.size());
    }

    @Test
    public void compareRemoveListAndALinkedListLast() {
        log.info(
                "------------------------------------------------------------------compareRemoveListAndALinkedListLast");
        compareRemoveList();
        removeListAndALinkedListLast();
        removeListAndALinkedListFirt();
    }

    @Test
    public void sortLargestSmallest() {
        log.info("------------------------------------------------------------------sortLargestSmallest");
        List<Integer> listIntegerArrayList = new ArrayList<>();
        List<Integer> listIntegerLinkedList = new LinkedList<>();
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 5, size);
        operationsCollection.addCollection(listIntegerArrayList, size);
        operationsCollection.addCollection(listIntegerLinkedList, size);
        log.info("operationsCollection.sortLargestSmallest(listIntegerArrayList):{}",
                operationsList.sortLargestSmallest(listIntegerArrayList));
        log.info("operationsCollection.sortLargestSmallest(listIntegerLinkedList)):{}",
                operationsList.sortLargestSmallest(listIntegerLinkedList));
        assertEquals(size - 1, listIntegerArrayList.get(0));
        assertEquals(size - 1, listIntegerLinkedList.get(0));
        assertEquals(0, listIntegerArrayList.get(size - 1));
        assertEquals(0, listIntegerLinkedList.get(size - 1));
    }

    @Test
    public void sortSmallestLargest() {
        log.info("------------------------------------------------------------------sortLargestSmallest");
        List<Integer> listIntegerArrayList = new ArrayList<>();
        List<Integer> listIntegerLinkedList = new LinkedList<>();
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 5, size);
        operationsCollection.addCollection(listIntegerArrayList, size);
        operationsCollection.addCollection(listIntegerLinkedList, size);
        log.info("operationsCollection.sortSmallestLargest(listIntegerArrayList):{}",
                operationsList.sortSmallestLargest(listIntegerArrayList));
        log.info("operationsCollection.sortSmallestLargest(listIntegerLinkedList)):{}",
                operationsList.sortSmallestLargest(listIntegerLinkedList));
        assertEquals(0, listIntegerArrayList.get(0));
        assertEquals(0, listIntegerLinkedList.get(0));
        assertEquals(size - 1, listIntegerArrayList.get(size - 1));
        assertEquals(size - 1, listIntegerLinkedList.get(size - 1));
    }

    @Test
    public void iterableVsForeach() {
        log.info("------------------------------------------------------------------iterableVsForeach");
        List<Integer> listIntegerArrayList = new ArrayList<>();
        List<Integer> listIntegerLinkedList = new LinkedList<>();
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 7, size);
        log.info("Agregando valores");
        operationsCollection.addCollection(listIntegerArrayList, size);
        operationsCollection.addCollection(listIntegerLinkedList, size);
        log.info("operationsCollection.useIterableCollection(listIntegerArrayList)):{}",
                operationsCollection.useIterableCollection(listIntegerArrayList));
        log.info("operationsCollection.useIterableCollection(listIntegerLinkedList):{}",
                operationsCollection.useIterableCollection(listIntegerLinkedList));

        log.info("operationsCollection.useForEachCollection(listIntegerArrayList):{}",
                operationsCollection.useForEachCollection(listIntegerArrayList));
        log.info("operationsCollection.useForEachCollection(listIntegerLinkedList):{}",
                operationsCollection.useForEachCollection(listIntegerLinkedList));
    }

}