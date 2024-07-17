package ar.com.globallogic.workshop.service.set;

import java.util.Set;
import java.util.TreeSet;

import ar.com.globallogic.workshop.domain.Domain;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperationsSet {
    public void printValuesSet(Set<Domain> set, int n) {
        log.info("-------------------Imprimiendo objetos Set -----------------");
        set.forEach(value -> log.info("Valor: {}", value.toString()));
    }

    public long sortTreeSetDescendingIterator(TreeSet<Integer> treeSet) {
        long timeStart = System.currentTimeMillis();
        treeSet.descendingIterator();
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long sortTreeSetDescendingSet(TreeSet<Integer> treeSet) {
        long timeStart = System.currentTimeMillis();
        treeSet.descendingSet();
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }
}
