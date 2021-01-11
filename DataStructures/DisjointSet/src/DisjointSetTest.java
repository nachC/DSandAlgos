import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class DisjointSetTest {
    DisjointSet ds = new DisjointSet();
    @Test
    public void findParentTest() {
        ds.connect(0, 1);
        ds.connect(5, 1);
        int input = 5;
        int expected = 0;
        int actual = ds.findParent(input);
        assertEquals(expected, actual);
    }

}