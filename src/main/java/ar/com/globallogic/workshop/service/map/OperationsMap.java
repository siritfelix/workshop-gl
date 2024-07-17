package ar.com.globallogic.workshop.service.map;

import java.util.Map;

import ar.com.globallogic.workshop.domain.Domain;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperationsMap {

    public long addIntegerMapReverce(Map<Integer, Integer> map, int n) {
        long timeStart = System.currentTimeMillis();
        for (int i = n - 1; i >= 0; i--) {
            map.put(i, i);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido addIntegerMap: {}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long addIntegerMapReverceOffSet(Map<Integer, Integer> map, int n, int offSet) {
        long timeStart = System.currentTimeMillis();
        for (int i = n - 1; i >= 0; i--) {
            map.put(offSet + i, i);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido addIntegerMap: {}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long addDomainMapReverce(Map<Domain, Integer> map, int n) {
        long timeStart = System.currentTimeMillis();
        for (int i = n - 1; i >= 0; i--) {
            map.put(new Domain(i, "message-" + i, "field"), i);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido addIntegerMap: {}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public void printIntegerMap(Map<Integer, Integer> map) {
        log.info("-------------------Imprimiendo Map -----------------");
        log.info(map.toString());
    }

    public void printDomainMap(Map<Domain, Integer> map) {
        log.info("-------------------Imprimiendo Map -----------------");
        log.info(map.toString());
    }

    public long removeMapAllFirstInteger(Map<Integer, Integer> map) {
        long timeStart = System.currentTimeMillis();
        int sizeStart = map.size();
        for (int i = 0; i < sizeStart; i++) {
            map.remove(i);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido removeMapAllFirstInteger: {}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long removeMapAllLastInteger(Map<Integer, Integer> map) {
        long timeStart = System.currentTimeMillis();
        int sizeStart = map.size();
        for (int i = sizeStart - 1; i >= 0; i--) {
            map.remove(i);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido removeMapAllLastInteger: {}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public synchronized long addIntegerMapReverceSynchronized(Map<Integer, Integer> map, int n) {
        long timeStart = System.currentTimeMillis();
        for (int i = n - 1; i >= 0; i--) {
            map.put(i, i);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido addIntegerMap: {}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }
}
