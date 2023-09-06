package pro.sky.hwbaseofalgoritmspart2.integerlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.hwbaseofalgoritmspart2.exception.ItemNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    IntegerList out;

    @BeforeEach
    public void beforeEach() {
        out = new IntegerListImpl(11, 12, 1, 3, 5, 14, 10, 15, 1);
    }

    @Test
    void shouldReturnArray() {
        Integer[] expected = {11, 12, 1, 3, 5, 14, 10, 15, 1};

        assertArrayEquals(expected, out.toArray());
    }

    @Test
    void shouldReturnTrueWhenListEmpty() {
        out.clear();

        assertTrue(out.isEmpty());
    }

    @Test
    void shouldReturnFalseWhenListNotEmpty() {
        assertFalse(out.isEmpty());
    }

    @Test
    void shouldReturnSize() {
        assertEquals(9, out.size());
    }

    @Test
    void shouldReturnTrueWhenListsEqual() {
        IntegerList integerList = new IntegerListImpl(11, 12, 1, 3, 5, 14, 10, 15, 1);

        assertEquals(integerList, out);
    }

    @Test
    void shouldReturnFalseWhenListsNotEqual() {
        IntegerList integerList = new IntegerListImpl(11, 12, 1, 3, 5, 14, 10, 15, 2);

        assertNotEquals(integerList, out);
    }

    @Test
    void shouldReturnIntegerValueWhenIndexIsCorrect() {
        assertEquals(11, out.get(0));
        assertEquals(1, out.get(8));
        assertEquals(5, out.get(4));
    }

    @Test
    void shouldReturnIndexWhenItemInList() {
        assertEquals(0, out.indexOf(11));
        assertEquals(2, out.indexOf(1));
        assertEquals(4, out.indexOf(5));

        assertEquals(0, out.lastIndexOf(11));
        assertEquals(8, out.lastIndexOf(1));
        assertEquals(4, out.lastIndexOf(5));
    }

    @Test
    void shouldReturnNegativeWhenItemNotInList() {
        assertEquals(-1, out.indexOf(80));
        assertEquals(-1, out.indexOf(9));

        assertEquals(-1, out.lastIndexOf(80));
        assertEquals(-1, out.lastIndexOf(9));
    }

    @Test
    void shouldReturnTrueWhenValueContainsInList() {
        assertTrue(out.contains(1));
        assertTrue(out.contains(5));
        assertTrue(out.contains(14));
    }

    @Test
    void shouldReturnFalseWhenValueNotContainsInList() {
        assertFalse(out.contains(2));
        assertFalse(out.contains(6));
        assertFalse(out.contains(80));
    }

    @Test
    void shouldReturnIntegerValueAfterRemoveByIndexPlusCorrectSizeAndArray() {
        assertEquals(11, out.remove(0));
        assertEquals(8, out.size());
        Integer[] expected = {12, 1, 3, 5, 14, 10, 15, 1};
        assertArrayEquals(expected, out.toArray());

        assertEquals(1, out.remove(1));
        assertEquals(7, out.size());
        expected = new Integer[]{12, 3, 5, 14, 10, 15, 1};
        assertArrayEquals(expected, out.toArray());
    }


    @Test
    void shouldReturnIntegerValueAfterRemoveByValuePlusCorrectSizeAndArray() {
        assertEquals(11, out.remove((Integer) 11));
        assertEquals(8, out.size());
        Integer[] expected = {12, 1, 3, 5, 14, 10, 15, 1};
        assertArrayEquals(expected, out.toArray());

        assertEquals(1, out.remove((Integer) 1));
        assertEquals(6, out.size());
        expected = new Integer[]{12, 3, 5, 14, 10, 15};
        assertArrayEquals(expected, out.toArray());
    }

    @Test
    void shouldReturnExceptionIfValueNotFound() {
        assertThrows(ItemNotFoundException.class, () -> out.remove((Integer) 99));
    }

    @Test
    void shouldReturnIntegerValueAfterAddByItemPlusCorrectSizeAndArray() {
        assertEquals(55, out.add(55));
        assertEquals(10, out.size());
        Integer[] expected = {11, 12, 1, 3, 5, 14, 10, 15, 1, 55};
        assertArrayEquals(expected, out.toArray());

        assertEquals(56, out.add(56));
        assertEquals(11, out.size());
        expected = new Integer[]{11, 12, 1, 3, 5, 14, 10, 15, 1, 55, 56};
        assertArrayEquals(expected, out.toArray());
    }

    @Test
    void shouldReturnIntegerValueAfterAddByItemAndIndexPlusCorrectSizeAndArray() {
        assertEquals(25, out.add(9, 25));
        assertEquals(10, out.size());
        Integer[] expected = {11, 12, 1, 3, 5, 14, 10, 15, 1, 25};
        assertArrayEquals(expected, out.toArray());

        assertEquals(26, out.add(5, 26));
        assertEquals(11, out.size());
        expected = new Integer[]{11, 12, 1, 3, 5, 26, 14, 10, 15, 1, 25};
        assertArrayEquals(expected, out.toArray());

        assertEquals(27, out.add(0, 27));
        assertEquals(12, out.size());
        expected = new Integer[]{27, 11, 12, 1, 3, 5, 26, 14, 10, 15, 1, 25};
        assertArrayEquals(expected, out.toArray());
    }

    @Test
    void shouldReturnIntegerValueAfterSetPlusCorrectSizeAndArray() {
        assertEquals(3, out.set(0, 3));
        assertEquals(9, out.size());
        Integer[] expected = {3, 12, 1, 3, 5, 14, 10, 15, 1};
        assertArrayEquals(expected, out.toArray());

        assertEquals(80, out.set(8, 80));
        assertEquals(9, out.size());
        expected = new Integer[]{3, 12, 1, 3, 5, 14, 10, 15, 80};
        assertArrayEquals(expected, out.toArray());

        assertEquals(0, out.set(9, 0));
        assertEquals(10, out.size());
        expected = new Integer[]{3, 12, 1, 3, 5, 14, 10, 15, 80, 0};
        assertArrayEquals(expected, out.toArray());

        assertEquals(6, out.set(4, 6));
        assertEquals(10, out.size());
        expected = new Integer[]{3, 12, 1, 3, 6, 14, 10, 15, 80, 0};
        assertArrayEquals(expected, out.toArray());
    }

    @Test
    void shouldReturnExceptionWhenIndexOutOfBound() {

    }

    @Test
    void shouldReturnExceptionWhenItemIsNull() {

    }
}