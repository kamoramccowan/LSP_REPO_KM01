package org.howard.edu.lsp.assignment5;

public class Driver {
    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        System.out.println("Set1: " + set1.toString());
        System.out.println("Smallest in Set1: " + set1.smallest());
        System.out.println("Largest in Set1: " + set1.largest());

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("Set2: " + set2.toString());

        System.out.println("\nPerforming Union:");
        set1.union(set2);
        System.out.println("Set1 after union: " + set1.toString());

        System.out.println("\nPerforming Intersection:");
        set1.intersect(set2);
        System.out.println("Set1 after intersection: " + set1.toString());

        System.out.println("\nPerforming Difference (Set1 - Set2):");
        set1.diff(set2);
        System.out.println("Set1 after difference: " + set1.toString());

        System.out.println("\nPerforming Complement:");
        set1.complement(set2);
        System.out.println("Set1 after complement: " + set1.toString());

        System.out.println("\nClearing Set1...");
        set1.clear();
        System.out.println("Is Set1 empty? " + set1.isEmpty());
    }
}
