package org.howard.edu.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerSet {
    private List<Integer> set = new ArrayList<>();

    public void clear() {
        set.clear();
    }

    public int length() {
        return set.size();
    }

    public boolean contains(int value) {
        return set.contains(value);
    }

    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
            Collections.sort(set);  // Sorting the set after adding
        }
    }

    public void remove(int item) {
        set.remove((Integer) item);
    }

    public boolean equals(IntegerSet otherSet) {
        if (this.set.size() != otherSet.set.size()) {
            return false;  // Early exit if sizes are different
        }
        List<Integer> copyThis = new ArrayList<>(this.set);
        List<Integer> copyOther = new ArrayList<>(otherSet.set);
        Collections.sort(copyThis);
        Collections.sort(copyOther);
        return copyThis.equals(copyOther);
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public int largest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty. No largest element.");
        }
        return Collections.max(set);
    }

    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty. No smallest element.");
        }
        return Collections.min(set);
    }

    public void union(IntegerSet intSet) {
        for (int item : intSet.set) {
            if (!set.contains(item)) {
                set.add(item);
            }
        }
        Collections.sort(set);  // Optional: Ensure set remains sorted after union
    }

    public void intersect(IntegerSet intSet) {
        set.retainAll(intSet.set);
    }

    public void diff(IntegerSet intSet) {
        set.removeAll(intSet.set);
    }

    public void complement(IntegerSet intSet) {
        List<Integer> temp = new ArrayList<>(set);
        temp.removeAll(intSet.set);  // Remove all elements in intSet from temp
        set.clear();  // Clear the current set
        set.addAll(temp);  // Add the remaining elements to the set
    }

    public String toString() {
        return set.isEmpty() ? "{}" : set.toString();
    }
}
