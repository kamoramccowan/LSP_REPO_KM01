package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    private ShoppingCart cart;

    // Set up a new cart before each test
    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }

    // 1. Test adding a valid item to the cart
    @Test
    @DisplayName("Test adding valid item to cart")
    public void testAddValidItem() {
        cart.addItem("Laptop", 999.99);
        assertEquals(999.99, cart.getTotalCost());
    }

    // 2. Test adding an item with price = 0 (should be allowed)
    @Test
    @DisplayName("Test adding item with 0 price (should be allowed)")
    public void testAddZeroPriceItem() {
        cart.addItem("Free Pen", 0.0);
        assertEquals(0.0, cart.getTotalCost());
    }

    // 3. Test adding an item with a negative price (should throw exception)
    @Test
    @DisplayName("Test adding item with negative price (should throw exception)")
    public void testAddNegativePriceItem() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Headphones", -50.0);
        });
    }

    // 4. Apply the SAVE10 discount and check total + discount %
    @Test
    @DisplayName("Test applying 'SAVE10' discount code")
    public void testApplySave10() {
        cart.addItem("Tablet", 200.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(180.0, cart.getTotalCost(), 0.001); // 10% off
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    // 5. Apply the SAVE20 discount and check total + discount %
    @Test
    @DisplayName("Test applying 'SAVE20' discount code")
    public void testApplySave20() {
        cart.addItem("Monitor", 300.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(240.0, cart.getTotalCost(), 0.001); // 20% off
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    // 6. Try an invalid discount code (should throw exception)
    @Test
    @DisplayName("Test applying invalid discount code")
    public void testApplyInvalidDiscount() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
    }

    // 7. Total cost without any discounts applied
    @Test
    @DisplayName("Test total cost without any discount")
    public void testTotalCostNoDiscount() {
        cart.addItem("Mouse", 50.0);
        cart.addItem("Keyboard", 70.0);
        assertEquals(120.0, cart.getTotalCost());
    }

    // 8. Total cost with SAVE20 discount applied
    @Test
    @DisplayName("Test total cost with discount applied")
    public void testTotalCostWithDiscount() {
        cart.addItem("Desk", 100.0);
        cart.addItem("Chair", 100.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(160.0, cart.getTotalCost(), 0.001); // 200 - 20%
    }

    // 9. Total cost with empty cart (should be 0)
    @Test
    @DisplayName("Test total cost with empty cart")
    public void testTotalCostEmptyCart() {
        assertEquals(0.0, cart.getTotalCost());
    }

    // 10. Simulate removal by overwriting an item with 0.0 price
    @Test
    @DisplayName("Test cart total reflects item addition and simulated removal")
    public void testCartSizeUpdates() {
        cart.addItem("Item1", 100.0);
        cart.addItem("Item2", 50.0);
        assertEquals(150.0, cart.getTotalCost());

        // Overwrite Item1 with a price of 0.0 to simulate removal
        cart.addItem("Item1", 0.0);
        assertEquals(50.0, cart.getTotalCost());
    }

    // 11. Remove an actual existing item
    @Test
    @DisplayName("Test removing an existing item from the cart")
    public void testRemoveExistingItem() {
        cart.addItem("Book", 25.0);
        cart.addItem("Notebook", 10.0);
        cart.removeItem("Book");
        assertEquals(10.0, cart.getTotalCost());
    }

    // 12. Try to remove an item that doesn't exist (should throw exception)
    @Test
    @DisplayName("Test removing a non-existent item (expect exception)")
    public void testRemoveNonExistentItem() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.removeItem("Ghost Item");
        });
    }
}
