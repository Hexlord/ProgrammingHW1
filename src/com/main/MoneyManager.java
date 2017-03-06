package com.main;

//
// @author Sasha Knorre
// 23501/3
//
// all rights reserved (c)
//

public class MoneyManager {
    
    public class MoneyManagerSolution {
        
        MoneyManagerSolution(int buyDay, int sellDay, int revenue, boolean isDoNothing) {
            this.isDoNothing = isDoNothing;
            this.buyDay = buyDay;
            this.sellDay = sellDay;
            this.revenue = revenue;
        }
        
        private boolean isDoNothing;
        private int buyDay;
        private int sellDay;
        private int revenue;
        
        
        public boolean isDoNothing() {
            return isDoNothing;
        }
        
        public int getBuyDay() {
            return buyDay;
        }
        
        public int getSellDay() {
            return sellDay;
        }
        
        public int getRevenue() {
            return revenue;
        }
        
    }
    
    public MoneyManagerSolution HowToMakeMoney(int priceArray[]) {
        //
        
        // Calculate delta array
        
        int deltaArray[] = new int[priceArray.length - 1];
        for (int i = 0;
             i < priceArray.length - 1;
             ++i) {
            
            deltaArray[i] = priceArray[i + 1] - priceArray[i];
        }
        
        //
        
        // Algorithm "recurrent"
        
        int bestStart = 0;
        int bestEnd = 0; // not including end element
        int bestSumm = 0;
        
        int newStart = -1;
        int newEnd = 0; // not including end element
        int newSumm = 0;
        
        for (int i = 0;
             i < priceArray.length - 1;
             ++i) {
            Integer delta = deltaArray[i];
            
            if (newStart == -1) { // start building sub-array
                newStart = i;
                newEnd = i + 1;
                newSumm = delta;
            } else { // extend sub-array
                ++newEnd;
                newSumm += delta;
            }
            
            if (newSumm <= 0) { // bad solution sub-array
                // degenerate
                newStart = -1;
                newEnd = 0;
                newSumm = 0;
            } else if (newSumm > bestSumm) { // better solution sub-array
                bestStart = newStart;
                bestEnd = newEnd;
                bestSumm = newSumm;
            }
            
        }
        
        //
        
        
        // Print results
        
        if (bestSumm > 0) {
            return new MoneyManagerSolution(bestStart, bestEnd, bestSumm, false);
        } else {
            return new MoneyManagerSolution(0, 0, 0, true);
        }
        
    }
    
    public static void main(String[] args) {
        
        
    }
}
