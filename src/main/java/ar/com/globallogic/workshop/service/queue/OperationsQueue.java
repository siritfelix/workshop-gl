package ar.com.globallogic.workshop.service.queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import ar.com.globallogic.workshop.domain.Domain;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperationsQueue {

    public long removeAllQueue(Queue<Integer> queue) {
        long timeStart = System.currentTimeMillis();
        while (!queue.isEmpty()) {
            queue.remove();
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido removeAllQueue:{}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long sortLargestSmallest(LinkedList<Integer> list) {
        long timeStart = System.currentTimeMillis();
        Comparator<Integer> comparator = (a, b) -> b.compareTo(a);
        list.sort(comparator);
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long sortSmallestLargest(LinkedList<Integer> list) {
        long timeStart = System.currentTimeMillis();
        Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
        list.sort(comparator);
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public void printQueueInteger(Queue<Integer> queue) {
        log.info("-------------------Imprimiendo Queue -----------------");
        StringBuilder stringBuilder = new StringBuilder("[");
        while (!queue.isEmpty()) {
            stringBuilder.append(queue.poll());
            if (!queue.isEmpty())
                stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        log.info(stringBuilder.toString());
    }

    public void printValuesQueueDomain(Queue<Domain> queue) {
        log.info("-------------------Imprimiendo Queue Domain-----------------");
        while (!queue.isEmpty()) {
            log.info(queue.poll().toString());
        }
    }

}
