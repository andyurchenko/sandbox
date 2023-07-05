package test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class Test {

    @org.junit.Test
    public void test() {
        //вот он - mock-объект (заметьте: List.class - это интерфейс)
        List mockedList = mock(List.class);

        //используем его
        mockedList.add("one");
        mockedList.clear();

        //проверяем, были ли вызваны методы add с параметром "one" и clear
        verify(mockedList).add("one");
        verify(mockedList).clear();


        //Вы можете создавать mock для конкретного класса, не только для интерфейса
        LinkedList mockedList2 = mock(LinkedList.class);

        //stub'инг
        when(mockedList2.get(0)).thenReturn("first");
        when(mockedList2.get(1)).thenThrow(new RuntimeException());

        //получим "first"
        System.out.println(mockedList2.get(0));

        //получим RuntimeException
//        System.out.println(mockedList.get(1));

        //получим "null" ибо get(999) не был определен
        System.out.println(mockedList2.get(999));



    }
}
