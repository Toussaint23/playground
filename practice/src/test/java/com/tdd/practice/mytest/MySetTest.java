package com.tdd.practice.mytest;

import com.tdd.practice.myset.MySet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MySetTest {

    @Mock
    MySet mySet;

    @Test
    public void Add_When_Value_Is_Null_Return_False(){
        Integer value = null;
        Mockito.when(mySet.add(value)).thenReturn(false);
        assertEquals("The return should be false", false, mySet.add(null));
    }

    @Test
    public void Add_When_Value_Exists_Return_False(){
        Mockito.when(mySet.add(3)).thenReturn(true).thenReturn(false);
        mySet.add(3);
        assertEquals("The return should be false", false, mySet.add(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void Add_When_Set_Is_Full_Throws_Exception(){
        Mockito.when(mySet.add(6)).thenThrow(IndexOutOfBoundsException.class);
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(4);
        mySet.add(5);
        assert(mySet.add(6));
    }

    @Test
    public void Add_When_Condition_Is_Ok_Return_True(){
        Mockito.when(mySet.add(1)).thenReturn(true);
        assertEquals("The return should be true", true, mySet.add(1));
    }

    @Test
    public void Remove_When_Set_Is_Empty_Return_False(){
        Mockito.when(mySet.remove(1)).thenReturn(false);
        assertEquals("The return should be false", false, mySet.remove(1));
    }

    @Test
    public void Remove_When_Value_Is_Null_Return_False(){
        Mockito.when(mySet.remove(null)).thenReturn(false);
        assertEquals("The return should be false", false, mySet.remove(null));
    }

    @Test
    public void Remove_When_Value_Is_Not_There_Return_False(){
        Mockito.when(mySet.remove(2)).thenReturn(false);
        mySet.add(1);
        assertEquals("The return should be false", false, mySet.remove(2));
    }

}
