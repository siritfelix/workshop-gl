package ar.com.globallogic.workshop.service.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import ar.com.globallogic.workshop.domain.Domain;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapTest {

    private OperationsMap operationsMap = new OperationsMap();

    @Test
    public void create() {
        Double value = Math.pow(10, 1);
        Integer size = value.intValue();
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();
        operationsMap.addIntegerMapReverce(hashMap, size);
        operationsMap.addIntegerMapReverce(linkedHashMap, size);
        operationsMap.addIntegerMapReverce(treeMap, size);
        operationsMap.printIntegerMap(hashMap);
        operationsMap.printIntegerMap(linkedHashMap);
        operationsMap.printIntegerMap(treeMap);

        assertEquals(size, hashMap.size());
        assertEquals(size, linkedHashMap.size());
        assertEquals(size, treeMap.size());
    }

    @Test
    public void createMap() {
        log.info("------------------------------------------------------------------createMap");
        Double value = Math.pow(10, 1);
        Integer size = value.intValue();
        Integer offSet;
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            offSet = i;
            log.info("------------------------------------------------------------------offset:{}", offSet);
            hashMap = new HashMap<>();
            linkedHashMap = new LinkedHashMap<>();
            treeMap = new TreeMap<>();
            operationsMap.addIntegerMapReverceOffSet(hashMap, size, offSet);
            operationsMap.addIntegerMapReverceOffSet(linkedHashMap, size, offSet);
            operationsMap.addIntegerMapReverceOffSet(treeMap, size, offSet);
            operationsMap.printIntegerMap(hashMap);
            operationsMap.printIntegerMap(linkedHashMap);
            operationsMap.printIntegerMap(treeMap);
        }
        assertEquals(size, hashMap.size());
        assertEquals(size, linkedHashMap.size());
        assertEquals(size, treeMap.size());
    }

    @Test
    public void createDomain() {
        Double value = Math.pow(10, 1);
        Integer size = value.intValue();
        Map<Domain, Integer> hashMap = new HashMap<>();
        Map<Domain, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<Domain, Integer> treeMap = new TreeMap<>();
        operationsMap.addDomainMapReverce(hashMap, size);
        operationsMap.addDomainMapReverce(linkedHashMap, size);
        operationsMap.addDomainMapReverce(treeMap, size);
        operationsMap.printDomainMap(hashMap);
        operationsMap.printDomainMap(linkedHashMap);
        operationsMap.printDomainMap(treeMap);
        assertEquals(size, hashMap.size());
        assertEquals(size, linkedHashMap.size());
        assertEquals(size, treeMap.size());
    }

    @Test
    public void addMap() {
        log.info("------------------------------------------------------------------addMap");
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < 8; i++) {
            Double value = Math.pow(10, i);
            Integer size = value.intValue();
            log.info("Potencia:{}, cantidad:{}", i, size);
            hashMap = new HashMap<>();
            linkedHashMap = new LinkedHashMap<>();
            treeMap = new TreeMap<>();
            operationsMap.addIntegerMapReverce(hashMap, size);
            operationsMap.addIntegerMapReverce(linkedHashMap, size);
            operationsMap.addIntegerMapReverce(treeMap, size);
        }
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        assertEquals(size, hashMap.size());
        assertEquals(size, linkedHashMap.size());
        assertEquals(size, treeMap.size());
    }

    @Test
    public void removeMapAllFirstInteger() {
        log.info("------------------------------------------------------------------removeMapAllFirstInteger");
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 7, size);
        operationsMap.addIntegerMapReverce(hashMap, size);
        operationsMap.addIntegerMapReverce(linkedHashMap, size);
        operationsMap.addIntegerMapReverce(treeMap, size);

        operationsMap.removeMapAllFirstInteger(hashMap);
        operationsMap.removeMapAllFirstInteger(linkedHashMap);
        operationsMap.removeMapAllFirstInteger(treeMap);
        log.info("Tamaños:{},{},{}", hashMap.size(), linkedHashMap.size(),
                treeMap.size());
        assertEquals(0, hashMap.size());
        assertEquals(0, linkedHashMap.size());
        assertEquals(0, treeMap.size());
    }

    @Test
    public void removeMapAllLastInteger() {
        log.info("------------------------------------------------------------------removeMapAllFirstInteger");
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();
        Double value = Math.pow(10, 7);
        Integer size = value.intValue();
        log.info("Potencia:{}, cantidad:{}", 7, size);
        operationsMap.addIntegerMapReverce(hashMap, size);
        operationsMap.addIntegerMapReverce(linkedHashMap, size);
        operationsMap.addIntegerMapReverce(treeMap, size);

        operationsMap.removeMapAllLastInteger(hashMap);
        operationsMap.removeMapAllLastInteger(linkedHashMap);
        operationsMap.removeMapAllLastInteger(treeMap);
        log.info("Tamaños:{},{},{}", hashMap.size(), linkedHashMap.size(),
                treeMap.size());
        assertEquals(0, hashMap.size());
        assertEquals(0, linkedHashMap.size());
        assertEquals(0, treeMap.size());
    }

    @Test
    public void compareRemoveMap() {
        removeMapAllFirstInteger();
        removeMapAllLastInteger();
    }

}
