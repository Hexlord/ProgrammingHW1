package com.test;

import com.main.MoneyManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by SashaBoss on 06.03.2017.
 */
public class MoneyManagerTest {
    
    
    @Test
    public void testHowToMakeMoney() {
        MoneyManager manager = new MoneyManager();
        
        int test1PriceArray[] = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94};
        int test1BuyDay = 7;
        int test1SellDay = 11;
        int test1Revenue = 43;
        
        MoneyManager.MoneyManagerSolution solution1 =
                manager.HowToMakeMoney(test1PriceArray);
        
        assertEquals(test1BuyDay, solution1.getBuyDay());
        assertEquals(test1SellDay, solution1.getSellDay());
        assertEquals(test1Revenue, solution1.getRevenue());
        
        int test2PriceArray[] = {5, 50, 105, 100, 100, 22, 3};
        int test2BuyDay = 0;
        int test2SellDay = 2;
        int test2Revenue = 100;
        
        
        MoneyManager.MoneyManagerSolution solution2 =
                manager.HowToMakeMoney(test2PriceArray);
        
        assertEquals(test2BuyDay, solution2.getBuyDay());
        assertEquals(test2SellDay, solution2.getSellDay());
        assertEquals(test2Revenue, solution2.getRevenue());
        
        int test3PriceArray[] = {123012401, 12120, 2131, 120, 31, 14, 1};
        boolean test3IsDoNothing = true;
        
        
        MoneyManager.MoneyManagerSolution solution3 =
                manager.HowToMakeMoney(test3PriceArray);
        
            
        assertEquals(test3IsDoNothing, solution3.isDoNothing());
        
        
    }
    
}