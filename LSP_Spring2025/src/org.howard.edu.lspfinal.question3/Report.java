package org.howard.edu.lspfinal.question3;

/**
 * Abstract base class that defines the report generation workflow.
 * Uses the Template Method design pattern.
 */
public abstract class Report {

    /**
     * Template method that defines the steps for generating a report.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    /**
     * Loads the data required for the report.
     */
    protected abstract void loadData();

    /**
     * Formats the data for the report.
     */
    protected abstract void formatData();

    /**
     * Prints the report.
     */
    protected abstract void printReport();
}
