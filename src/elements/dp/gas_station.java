/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int[] comb = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
        	totalCost += cost[i];
        	totalGas += gas[i];
        	comb[i] = gas[i] - cost[i];
        }

        if (totalGas - totalCost < 0) return -1;

        int max = comb[0];
        int maxStart = 0;
        int localMax = comb[0];
        int localMaxStart = 0;
        int min = comb[0];
        int minEnd = 0;
        int localMin = comb[0];
        for (int i = 1; i < comb.length; i++) {
        	if (comb[i] > comb[i] + localMax) {
        		localMax = comb[i];
        		localMaxStart = i;
        	} else {
        		localMax = comb[i] + localMax;
        	}

        	if (localMax > max) {
        		max = localMax;
        		maxStart = localMaxStart;
        	}

        	if (comb[i] > comb[i] + localMin) {
        		localMin = comb[i] + localMin;
        	} else {
        		localMin = comb[i];
        	}

        	if (localMin < min) {
        		min = localMin;
        		minEnd = i;
        	}
        }

        if (max >= (totalGas - totalCost - min)) {
        	return maxStart;
        } else {
        	return (minEnd + 1) % comb.length; 
        }
    }
}