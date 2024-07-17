package ar.com.globallogic.workshop.service;

import java.util.ArrayDeque;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperationsStackQueue {

    public long addStack(Stack<Integer> stack, Integer n) {
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            stack.add(i);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido addStack: {}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long removeStack(Stack<Integer> stack) {
        long timeStart = System.currentTimeMillis();
        while (!stack.isEmpty()) {
            stack.pop();
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido removeStack:{}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long addQueue(ArrayDeque<Integer> arrayDeque, Integer n) {
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            arrayDeque.add(i);
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido addQueue: {}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long removeQueue(ArrayDeque<Integer> arrayDeque) {
        long timeStart = System.currentTimeMillis();
        while (!arrayDeque.isEmpty()) {
            arrayDeque.poll();
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido removeQueue:{}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }

    public long removeLastQueue(ArrayDeque<Integer> arrayDeque) {
        long timeStart = System.currentTimeMillis();
        while (!arrayDeque.isEmpty()) {
            arrayDeque.pollLast();
        }
        long timeEnd = System.currentTimeMillis();
        log.info("Tiempo transcurrido removeLastQueue:{}", timeEnd - timeStart);
        return timeEnd - timeStart;
    }
}
