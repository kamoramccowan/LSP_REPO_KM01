package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;


public class IntegerSet {
    private List<Integer> set = new ArrayList<>();

    // Default Constructor
    public IntegerSet() {}

    // Constructor with initial values
    public IntegerSet(ArrayList<Integer> set) {
        this.set = new ArrayList<>(set);
    }

    /** Clears the set */
    public void clear() {
        set.clear();
    }

    /** Returns the size of the set */
    public int length() {
        return set.size();
    }

    /** 
     * Checks if two sets are equal (contain the same elements in any order)
     * @param o The object to compare
     * @return true if sets are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IntegerSet)) return false;
        IntegerSet otherSet = (IntegerSet) o;
        return set.containsAll(otherSet.set) && otherSet.set.containsAll(set);
    }

    /** Checks if the set contains a value */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /** Returns the largest element */
    public int largest() {
        if (set.isEmpty()) throw new IllegalStateException("Set is empty");
        return set.stream().max(Integer::compareTo).orElseThrow();
    }

    /** Returns the smallest element */
    public int smallest() {
        if (set.isEmpty()) throw new IllegalStateException("Set is empty");
        return set.stream().min(Integer::compareTo).orElseThrow();
    }

    /** Adds an element if it's not already in the set */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /** Removes an element if it exists */
    public void remove(int item) {
        set.remove((Integer) item);
    }

    /** Performs a union with another set */
    public void union(IntegerSet intSetb) {
        for (int num : intSetb.set) {
            this.add(num);
        }
    }

    /** Performs an intersection with another set */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /** Performs a difference (this set - another set) */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /** Performs a complement operation (all elements not in this set) */
    public void complement(IntegerSet intSetb) {
        List<Integer> complementSet = new ArrayList<>(intSetb.set);
        complementSet.removeAll(set);
        set = complementSet;
    }

    /** Checks if the set is empty */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /** Returns the string representation of the set */
    @Override
    public String toString() {
        return set.toString();
    }
}
