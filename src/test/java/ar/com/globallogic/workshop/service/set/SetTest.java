package ar.com.globallogic.workshop.service.set;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import ar.com.globallogic.workshop.domain.Domain;
import ar.com.globallogic.workshop.service.OperationsCollection;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SetTest {
    private OperationsCollection operationsCollection = new OperationsCollection();
    private OperationsSet operationsSet = new OperationsSet();

    @Test
    public void create() {
        log.info("------------------------------------------------------------------create");
        Double value = Math.pow(10, 1);
        Integer size = value.intValue();
        Set<Integer> hashSetInteger = new HashSet<>();
        Set<Integer> treeSetInteger = new TreeSet<>();
        Set<Integer> linkedHashSetInteger = new LinkedHashSet<>();
        operationsCollection.addCollectionReverce(hashSetInteger, size);
        operationsCollection.addCollectionReverce(treeSetInteger, size);
        operationsCollection.addCollectionReverce(linkedHashSetInteger, size);
        operationsCollection.printValuesCollectionInteger(linkedHashSetInteger);
        operationsCollection.printValuesCollectionInteger(treeSetInteger);
        operationsCollection.printValuesCollectionInteger(linkedHashSetInteger);
        assertEquals(size, hashSetInteger.size());
        assertEquals(size, treeSetInteger.size());
        assertEquals(size, linkedHashSetInteger.size());
    }

    @Test
    public void createReverseOrder() {
        log.info("------------------------------------------------------------------create");
        Double value = Math.pow(10, 1);
        Integer size = value.intValue();
        Set<Integer> hashSetInteger = new HashSet<>();
        Set<Integer> treeSetInteger = new TreeSet<>(Comparator.reverseOrder());
        Set<Integer> linkedHashSetInteger = new LinkedHashSet<>();
        operationsCollection.addCollectionReverce(hashSetInteger, size);
        operationsCollection.addCollectionReverce(treeSetInteger, size);
        operationsCollection.addCollectionReverce(linkedHashSetInteger, size);
        operationsCollection.printValuesCollectionInteger(linkedHashSetInteger);
        operationsCollection.printValuesCollectionInteger(treeSetInteger);
        operationsCollection.printValuesCollectionInteger(linkedHashSetInteger);
        assertEquals(size, hashSetInteger.size());
        assertEquals(size, treeSetInteger.size());
        assertEquals(size, linkedHashSetInteger.size());
    }

    @Test
    public void addCollection() {
        log.info("------------------------------------------------------------------addCollection");
        Set<Integer> hashSetInteger = new HashSet<>();
        Set<Integer> treeSetInteger = new TreeSet<>();
        Set<Integer> linkedHashSetInteger = new LinkedHashSet<>();
        for (int i = 0; i < 8; i++) {
            Double value = Math.pow(10, i);
            Integer size = value.intValue();
            log.info("Potencia:{}, cantidad:{}", i, size);
            hashSetInteger = new HashSet<>();
            treeSetInteger = new TreeSet<>();
            linkedHashSetInteger = new LinkedHashSet<>();
            operationsCollection.addCollectionReverce(hashSetInteger, size);
            operationsCollection.addCollectionReverce(treeSetInteger, size);
            operationsCollection.addCollectionReverce(linkedHashSetInteger, size);
        }
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        assertEquals(size, hashSetInteger.size());
        assertEquals(size, treeSetInteger.size());
        assertEquals(size, linkedHashSetInteger.size());

    }

    @Test
    public void addValues() {
        log.info("------------------------------------------------------------------addValues");
        Double value = Math.pow(10, 1);
        Integer size = value.intValue();
        size = 3;

        Set<Domain> hashSetDomain = new HashSet<>();
        Set<Domain> treeSetDomain = new TreeSet<>();
        Set<Domain> linkedHashSetDomain = new LinkedHashSet<>();
        operationsCollection.addDomainCollectionReverce(hashSetDomain, size);
        operationsCollection.addDomainCollectionReverce(treeSetDomain, size);
        operationsCollection.addDomainCollectionReverce(linkedHashSetDomain, size);
        log.info("-----------------Imprimiendo set creados-----------------------------");
        operationsCollection.printValuesCollectionDomain(hashSetDomain);
        operationsCollection.printValuesCollectionDomain(treeSetDomain);
        operationsCollection.printValuesCollectionDomain(linkedHashSetDomain);

        hashSetDomain.add(new Domain(1, "message-" + 1, "field"));
        treeSetDomain.add(new Domain(1, "message-" + 1, "field"));
        linkedHashSetDomain.add(new Domain(1, "message-" + 1, "field"));
        log.info("-----------------Imprimiendo set agregando elemento repetido----------");
        operationsCollection.printValuesCollectionDomain(linkedHashSetDomain);
        operationsCollection.printValuesCollectionDomain(treeSetDomain);
        operationsCollection.printValuesCollectionDomain(linkedHashSetDomain);

        Domain domain = new Domain(-1, "mensaje-1", "field");
        hashSetDomain.add(domain);
        treeSetDomain.add(domain);
        linkedHashSetDomain.add(domain);
        log.info("-----------------Imprimiendo set agregando elemento nuevo-----------");
        operationsCollection.printValuesCollectionDomain(linkedHashSetDomain);
        operationsCollection.printValuesCollectionDomain(treeSetDomain);
        operationsCollection.printValuesCollectionDomain(linkedHashSetDomain);
        domain.setId(1);
        log.info("-----------------Imprimiendo set modificando a elemento repetido-----");
        operationsCollection.printValuesCollectionDomain(linkedHashSetDomain);
        operationsCollection.printValuesCollectionDomain(treeSetDomain);
        operationsCollection.printValuesCollectionDomain(linkedHashSetDomain);
        assertEquals(size + 1, hashSetDomain.size());
        assertEquals(size + 1, treeSetDomain.size());
        assertEquals(size + 1, linkedHashSetDomain.size());
    }

    @Test
    public void comparingListAndSet() {
        log.info("------------------------------------------------------------------comparingListAndSet");
        List<Integer> listIntegerArrayList = new ArrayList<>();
        Set<Integer> hashSetInteger = new HashSet<>();
        Double value = Math.pow(10, 8);
        Integer size = value.intValue();
        operationsCollection.addCollection(listIntegerArrayList, size);
        operationsCollection.addCollectionReverce(hashSetInteger, size);
        assertEquals(size, listIntegerArrayList.size());
        assertEquals(size, hashSetInteger.size());
    }

    @Test
    public void removeCollectionAllLastInteger() {
        log.info("------------------------------------------------------------------removeCollectionAllLastInteger");
        Set<Integer> hashSetInteger = new HashSet<>();
        Set<Integer> treeSetInteger = new TreeSet<>();
        Set<Integer> linkedHashSetInteger = new LinkedHashSet<>();
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 7, size);
        log.info("Agregando valores");
        operationsCollection.addCollectionReverce(hashSetInteger, size);
        operationsCollection.addCollectionReverce(treeSetInteger, size);
        operationsCollection.addCollectionReverce(linkedHashSetInteger, size);
        log.info("Eliminando valores desde el ultimo elemento collections");
        operationsCollection.removeCollectionAllLastInteger(hashSetInteger);
        operationsCollection.removeCollectionAllLastInteger(treeSetInteger);
        operationsCollection.removeCollectionAllLastInteger(linkedHashSetInteger);
        log.info("Tamaños:{},{},{}", hashSetInteger.size(), treeSetInteger.size(), linkedHashSetInteger.size());
        assertEquals(0, hashSetInteger.size());
        assertEquals(0, treeSetInteger.size());
        assertEquals(0, linkedHashSetInteger.size());
    }

    @Test
    public void removeCollectionAllFirstInteger() {
        log.info("------------------------------------------------------------------removeCollectionAllFirstInteger");
        Set<Integer> hashSetInteger = new HashSet<>();
        Set<Integer> treeSetInteger = new TreeSet<>();
        Set<Integer> linkedHashSetInteger = new LinkedHashSet<>();
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 7, size);
        log.info("Agregando valores");
        operationsCollection.addCollectionReverce(hashSetInteger, size);
        operationsCollection.addCollectionReverce(treeSetInteger, size);
        operationsCollection.addCollectionReverce(linkedHashSetInteger, size);
        log.info("Eliminando valores desde el primer elemento del set");
        operationsCollection.removeCollectionAllFirstInteger(hashSetInteger);
        operationsCollection.removeCollectionAllFirstInteger(treeSetInteger);
        operationsCollection.removeCollectionAllFirstInteger(linkedHashSetInteger);
        log.info("Tamaños:{},{},{}", hashSetInteger.size(), treeSetInteger.size(), linkedHashSetInteger.size());
        assertEquals(0, hashSetInteger.size());
        assertEquals(0, treeSetInteger.size());
        assertEquals(0, linkedHashSetInteger.size());
    }

    @Test
    public void compareRemoveSet() {
        removeCollectionAllLastInteger();
        removeCollectionAllFirstInteger();
    }

    @Test
    public void sortTreeSet() {
        log.info("------------------------------------------------------------------sortTreeSet");
        TreeSet<Integer> treeSetInteger = new TreeSet<>();
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        operationsCollection.addCollectionReverce(treeSetInteger, size);
        log.info("operationsSet.sortTreeSetDescendingIterator(treeSetInteger)):{}",
                operationsSet.sortTreeSetDescendingIterator(treeSetInteger));
        log.info("operationsSet.sortTreeSetDescendingSet(treeSetInteger)):{}",
                operationsSet.sortTreeSetDescendingSet(treeSetInteger));
        assertEquals(size, treeSetInteger.size());
    }

    @Test
    public void iterableVsForeach() {
        log.info("------------------------------------------------------------------iterableVsForeach");
        Set<Integer> hashSetInteger = new HashSet<>();
        Set<Integer> treeSetInteger = new TreeSet<>();
        Set<Integer> linkedHashSetInteger = new LinkedHashSet<>();
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 7, size);
        log.info("Agregando valores");
        operationsCollection.addCollectionReverce(hashSetInteger, size);
        operationsCollection.addCollectionReverce(treeSetInteger, size);
        operationsCollection.addCollectionReverce(linkedHashSetInteger, size);
        log.info("operationsCollection.useIterableCollection(hashSetInteger)):{}",
                operationsCollection.useIterableCollection(hashSetInteger));
        log.info("operationsCollection.useIterableCollection(treeSetInteger):{}",
                operationsCollection.useIterableCollection(treeSetInteger));
        log.info("operationsCollection.useIterableCollection(linkedHashSetInteger):{}",
                operationsCollection.useIterableCollection(linkedHashSetInteger));

        log.info("operationsCollection.useForEachCollection(hashSetInteger):{}",
                operationsCollection.useForEachCollection(hashSetInteger));
        log.info("operationsCollection.useForEachCollection(treeSetInteger):{}",
                operationsCollection.useForEachCollection(treeSetInteger));
        log.info("operationsCollection.useForEachCollection(linkedHashSetInteger):{}",
                operationsCollection.useForEachCollection(linkedHashSetInteger));
        assertEquals(size, hashSetInteger.size());
        assertEquals(size, treeSetInteger.size());
        assertEquals(size, linkedHashSetInteger.size());
    }
}
