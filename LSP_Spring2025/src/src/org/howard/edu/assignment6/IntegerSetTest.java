package org.howard.edu.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class IntegerSetTest {
    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    @DisplayName("Test case for add and contains")
    public void testAddContains() {
        set1.add(5);
        assertTrue(set1.contains(5), "Set should contain 5");
        set1.add(10);
        assertTrue(set1.contains(10), "Set should contain 10");
        set1.add(5); // Duplicate add
        assertTrue(set1.contains(5), "Set should still contain 5");
    }

    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
        set1.add(5);
        set1.remove(5);
        assertFalse(set1.contains(5), "Set should not contain 5 after removal");
        set1.remove(10); // Removing non-existent element
        assertFalse(set1.contains(10), "Set should still not contain 10");
    }

    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        assertEquals(0, set1.length(), "Length should be 0 for an empty set");
        set1.add(5);
        assertEquals(1, set1.length(), "Length should be 1 after adding an element");
        set1.add(10);
        assertEquals(2, set1.length(), "Length should be 2 after adding another element");
        set1.remove(5);
        assertEquals(1, set1.length(), "Length should be 1 after removal");
    }

    @Test
    @DisplayName("Test case for isEmpty")
    public void testIsEmpty() {
        assertTrue(set1.isEmpty(), "Set should be empty initially");
        set1.add(5);
        assertFalse(set1.isEmpty(), "Set should not be empty after adding an element");
        set1.remove(5);
        assertTrue(set1.isEmpty(), "Set should be empty after removing the element");
    }

    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        set1.add(5);
        set1.add(10);
        set2.add(10);
        set2.add(5);
        assertTrue(set1.equals(set2), "Sets should be equal with the same elements");
        set2.add(15);
        assertFalse(set1.equals(set2), "Sets should not be equal with different elements");
    }

    @Test
    @DisplayName("Test case for largest and smallest")
    public void testLargestSmallest() {
        set1.add(5);
        set1.add(10);
        set1.add(1);
        assertEquals(10, set1.largest(), "Largest should be 10");
        assertEquals(1, set1.smallest(), "Smallest should be 1");
        set1.remove(10);
        assertEquals(5, set1.largest(), "Largest should be 5 after removing 10");
        assertEquals(1, set1.smallest(), "Smallest should still be 1");
        set1.remove(1);
        assertEquals(5, set1.largest(), "Largest should still be 5");
        assertEquals(5, set1.smallest(), "Smallest should still be 5");
    }

    @Test
    @DisplayName("Test case for largest and smallest exceptions")
    public void testLargestSmallestExceptions() {
        assertThrows(IntegerSetException.class, () -> set1.largest(), "Expected IntegerSetException for largest when set is empty");
        assertThrows(IntegerSetException.class, () -> set1.smallest(), "Expected IntegerSetException for smallest when set is empty");
    }

    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        set1.add(5);
        set1.add(10);
        set2.add(10);
        set2.add(15);
        set1.union(set2);
        assertTrue(set1.contains(5), "Set should contain 5 after union");
        assertTrue(set1.contains(10), "Set should contain 10 after union");
        assertTrue(set1.contains(15), "Set should contain 15 after union");
    }

    @Test
    @DisplayName("Test case for intersect")
    public void testIntersect() {
        set1.add(5);
        set1.add(10);
        set2.add(10);
        set2.add(15);
        set1.intersect(set2);
        assertFalse(set1.contains(5), "Set should not contain 5 after intersection");
        assertTrue(set1.contains(10), "Set should contain 10 after intersection");
        assertFalse(set1.contains(15), "Set should not contain 15 after intersection");
    }

    @Test
    @DisplayName("Test case for diff")
    public void testDiff() {
        set1.add(5);
        set1.add(10);
        set2.add(10);
        set2.add(15);
        set1.diff(set2);
        assertTrue(set1.contains(5), "Set should contain 5 after difference");
        assertFalse(set1.contains(10), "Set should not contain 10 after difference");
        assertFalse(set1.contains(15), "Set should not contain 15 after difference");
    }

    @Test
    @DisplayName("Test case for complement")
    public void testComplement() {
        set1.add(5);
        set1.add(10);
        set2.add(10);
        set2.add(15);
        set1.complement(set2);
        assertTrue(set1.contains(5), "Set should contain 5 after complement");
        assertFalse(set1.contains(10), "Set should not contain 10 after complement");
        assertTrue(set1.contains(15), "Set should contain 15 after complement");
    }

    @Test
    @DisplayName("Test case for toString")
    public void testToString() {
        set1.add(5);
        set1.add(10);
        assertEquals("{5, 10}", set1.toString(), "toString should return correct string representation");
    }
}
