package ar.com.globallogic.workshop.service.array;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperationsArrays {
    public void printArrayInt(int[] array) {
        log.info("-------------------Imprimiendo arreglo int-----------------");
        for (int i = 0; i < array.length; i++) {
            log.info("Indice: {}, Valor: {}", i, array[i]);
        }
    }

    public void updateArrayInt(int[] array, int indice, int valor) {
        log.info("-------------------Modificando arreglo int-----------------");
        if (array.length > indice)
            array[indice] = valor;
    }

    public void printArrayObject(Object[] array) {
        log.info("-------------------Imprimiendo arreglo Object-----------------");
        for (int i = 0; i < array.length; i++) {
            log.info("Indice: {}, Valor: {}", i, array[i]);
        }
    }

    public void updateArrayObject(Object[] array, int indice, Object valor) {
        log.info("-------------------Modificando arreglo Object-----------------");
        if (array.length > indice)
            array[indice] = valor;
    }
}
