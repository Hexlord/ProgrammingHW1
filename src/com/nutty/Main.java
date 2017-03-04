package com.nutty;

//
// @author Sasha Knorre
// 23501/3
//
// all rights reserved (c)
//

public class Main {
    
    public static void main(String[] args) {
        
        Integer Price[] = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94};
        
        // Print input array
        
        System.out.print("Input price array: ");
        for (int iPrice = 0;
             iPrice < Price.length;
             ++iPrice) {
            
            System.out.print(Price[iPrice].toString());
            if (iPrice + 1 < Price.length) {
                System.out.print(", ");
            }
        }
        System.out.print("\n\n");
        
        //
        
        // Calculate delta array
        
        Integer Delta[] = new Integer[Price.length - 1];
        for (int iDelta = 0;
             iDelta < Price.length - 1;
             ++iDelta) {
            
            Delta[iDelta] = Price[iDelta + 1] - Price[iDelta];
        }
        
        //
        
        // Algorithm "recurrent"
        
        Integer bestStart = 0;
        Integer bestEnd = 0;
        Integer bestSumm = 0;
        
        Integer newStart = -1;
        Integer newEnd = 0; // not including end element
        Integer newSumm = 0;
        
        for (int iDelta = 0;
             iDelta < Price.length - 1;
             ++iDelta) {
            Integer delta = Delta[iDelta];
            
            if (newStart == -1) {
                newStart = iDelta;
                newEnd = iDelta + 1;
                newSumm = delta;
            } else {
                ++newEnd;
                newSumm += delta;
            }
            
            if (newSumm <= 0) {
                // Degenerate
                newStart = -1;
                newEnd = 0;
                newSumm = 0;
            } else if (newSumm > bestSumm) {
                bestStart = newStart;
                bestEnd = newEnd;
                bestSumm = newSumm;
            }
            
        }
        
        //
        
        
        // Print results
        
        if (bestSumm == 0) {
            System.out.print("It is better not to buy anything :-(\n\n");
        } else {
            System.out.print("Purchase at day #" + bestStart.toString() +
                    " ($" + Price[bestStart].toString() + ")" +
                    " and sell at day #" + bestEnd.toString() +
                    " ($" + Price[bestEnd].toString() + ")" + "\n");
            System.out.print("You will earn $" + bestSumm.toString() + "!!!\n");
        }
        
        //
        
        // Test output
        
        // Input price array: 100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94
        //
        // Purchase at day #7 ($63) and sell at day #11 ($106)
        // You will earn $43!!!
        
        //
    }
}
