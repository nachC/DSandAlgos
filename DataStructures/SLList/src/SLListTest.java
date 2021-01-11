import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class SLListTest {

    @Test
    public void sizeTest() {
        int actual = 0;
        int expected = 0;
        SLList<String> slList = new SLList<>();
        assertEquals(expected, actual);
    }

    @Test
    public void getTest() {
        int indexToGet = 2;
        int expected = 3;
        SLList<Integer> slList = new SLList<>();
        slList.addFirst(3);
        slList.addFirst(2);
        slList.addFirst(1);
        int actual = slList.get(indexToGet);
        assertEquals(expected, actual);
    }

    @Test
    public void removeTest() {
        int indexToDelete = 1;
        int expected = 2;
        SLList<Integer> slList = new SLList<>();
        slList.addFirst(3);
        slList.addFirst(2);
        slList.addFirst(1);
        int actual = slList.remove(indexToDelete);
        assertEquals(expected, actual);

    }
}