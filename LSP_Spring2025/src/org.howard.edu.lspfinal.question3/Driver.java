package org.howard.edu.lspfinal.question3;

/**
 * Driver class to demonstrate the report generation system.
 */
public class Driver {
    public static void main(String[] args) {
        Report salesReport = new SalesReport();
        Report inventoryReport = new InventoryReport();

        salesReport.generateReport();
        inventoryReport.generateReport();
    }
}
