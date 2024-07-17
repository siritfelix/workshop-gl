package ar.com.globallogic.workshop.service;

import java.util.Collection;
import java.util.Iterator;

import ar.com.globallogic.workshop.domain.Domain;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperationsCollection {

    public long addCollection(Collection<Integer> collection, Integer n) {
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            collection.add(i);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido addCollection: {}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long addCollectionReverce(Collection<Integer> collection, Integer n) {
        long timeStart = System.currentTimeMillis();
        for (int i = n - 1; i >= 0; i--) {
            collection.add(i);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido addCollectionReverce: {}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long addDomainCollectionReverce(Collection<Domain> collection, Integer n) {
        long timeStart = System.currentTimeMillis();
        for (int i = n - 1; i >= 0; i--) {
            collection.add(new Domain(i, "message-" + i, "field"));
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido add: {}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public void printValuesCollectionInteger(Collection<Integer> collection) {
        log.info("-------------------Imprimiendo Collection -----------------");
        log.info(collection.toString());
    }

    public void printValuesCollectionDomain(Collection<Domain> collection) {
        log.info("-------------------Imprimiendo Collection -----------------");
        collection.forEach(value -> log.info("Valor: {}", value));
    }

    public long removeCollectionAllFirstInteger(Collection<Integer> collection) {
        int sizeStart = collection.size();
        long timeStart = System.currentTimeMillis();
        for (int i = sizeStart - 1; i >= 0; i--) {
            collection.remove(i);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido removeCollectionAllFirstInteger:{}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long removeCollectionAllLastInteger(Collection<Integer> collection) {
        int sizeStart = collection.size();
        long timeStart = System.currentTimeMillis();
        for (int i = sizeStart - 1; i >= 0; i--) {
            collection.remove(i);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido removeCollectionAllLastInteger:{}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long useIterableCollection(Collection<Integer> collection) {
        long timeStart = System.currentTimeMillis();
        Iterator<Integer> iterable = collection.iterator();
        while (iterable.hasNext()) {
            iterable.next();
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long useForEachCollection(Collection<Integer> collection) {
        long timeStart = System.currentTimeMillis();
        collection.forEach(value -> {
        });
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long addCollection(Collection<Integer> collection, Integer n, Integer offSet) {
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            collection.add(offSet + i);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido addCollection: {}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public synchronized long addCollectionSynchronized(Collection<Integer> collection, Integer n) {
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            collection.add(i);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido addCollectionSynchronized: {}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }
}
