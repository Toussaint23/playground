package com.tdd.practice.myqueuetest;

import com.tdd.practice.myqueue.MyQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MyQueueTest {

    @Mock
    MyQueue myQueue;

    @Test
    public void add_when_value_is_null_size_equals_zero(){
        Mockito.when(myQueue.size()).thenReturn(0);
        myQueue.add(null);
        assertEquals("The return should be zero", 0, myQueue.size());
    }

    @Test
    public void add_when_value_is_ok_size_equals_one(){
        Mockito.when(myQueue.size()).thenReturn(1);
        myQueue.add(1);
        assertEquals("The return should be one", 1, myQueue.size());
    }

    @Test
    public void remove_when_queue_is_empty_return_null(){
        Mockito.when(myQueue.remove()).thenReturn(null);
        assertEquals("The return should be null", null, myQueue.remove());
    }

    @Test
    public void remove_when_queue_is_not_empty_return_one(){
        Mockito.when(myQueue.remove()).thenReturn(1);
        myQueue.add(1);
        assertEquals("The return should be one", Integer.valueOf(1), myQueue.remove());
    }
}
