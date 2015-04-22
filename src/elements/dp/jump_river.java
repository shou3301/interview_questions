package com.test;

public class JumpRiver {

	public static void main(String[] args) {

	}
	
	/**
	 * Return -1 if cannot jump over the river.
	 */
	public static int jumpRiver(int[] river) {
		int[] minJumps = new int[river.length];
		minJumps[0] = 0;
		// max speed is always current jumps + 1
		for (int i = 1; i < river.length; i++) {
            if (river[i] == 1) {
                minJumps[i] = Integer.MAX_VALUE;
                for (int j = i - 1; j >= 0; j--) {
                    if (river[j] == 1 && minJumps[j] != Integer.MAX_VALUE && j + minJumps[j] + 1 >= i) {
                        minJumps[i] = Math.min(minJumps[i], minJumps[j] + 1);
                    }
                }
            }
		}
		
        int min = Integer.MAX_VALUE;
		for (int i = 0; i < river.length; i++) {
            if (river[i] == 1 && minJumps[i] != Integer.MAX_VALUE && minJumps[i] + 1 + i >= river.length) {
                min = Math.min(min, minJumps[i] + 1);
            }
        }
        
        if (min == Integer.MAX_VALUE) return -1;
        
        return min;
	}

}