package org.howard.edu.lspfinal.question4;

/**
 * Question 4 - Design Patterns and Trade-Offs
 * 
 * One time when using a design pattern might not be helpful is when it makes your code more
 * complicated than it needs to be. In Lecture 12, we talked about the trade-offs between 
 * using inheritance and interfaces. 
 * 
 * Inheritance helps with code reuse — like having one shared fly() or quack() method — which sounds 
 * good at first. But if the behavior in the root class doesn’t actually apply to every subclass, 
 * it can cause problems. You end up forcing behavior into classes that don’t need it.
 * 
 * Interfaces fix that by being more specific — only classes that need fly() get it — but then 
 * there’s no code reuse because interfaces don’t include actual method logic, just signatures.
 * 
 * So overall, using inheritance as a pattern isn’t always a good idea, especially if it assumes 
 * all subclasses should behave the same. That was something clearly pointed out in Lecture 12.
 */
public class Answer {
    // No code here
}
