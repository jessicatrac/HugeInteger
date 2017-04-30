/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hugeinteger;
import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Jessica
 */
public class setTiming {

    
    public static void main(String[] args) {
    HugeInteger huge1, huge2, huge3; // for addition
    long startTime, endTime;
    double runTime = 0.0;
    int[] array_of_n = {500,1000,5000,10000}; 
    int numInts, i;
   /* for(i=0;i<array_of_n.length;i++){
        for(numInts=0; numInts < 100; numInts++) {
            huge1 = new HugeInteger(array_of_n[i]);        //creates a random integer of n digits
            huge2 = new HugeInteger(array_of_n[i]);        //creates a random integer of n digits
            startTime = System.currentTimeMillis();
            for(int numRun=0; numRun < 2000; numRun++)
                { huge3 = huge1.add(huge2); }
            endTime = System.currentTimeMillis();
            runTime +=(double) (endTime - startTime)/((double) 200);
        }
        runTime = runTime/((double)100);
        System.out.println("Runtime for add() with HugeInteger of " + array_of_n[i] + " digits is " + runTime);
        runTime = 0.0; 
        }*/
    
    int[] array_of_n_mult = {10,20,30,40};     
       /* for(i=0;i<array_of_n_mult.length;i++){ // subtract huge int
        for(numInts=0; numInts < 100; numInts++) {
            huge1 = new HugeInteger(array_of_n_mult[i]);        //creates a random integer of n digits
            huge2 = new HugeInteger(array_of_n_mult[i]);        //creates a random integer of n digits
            startTime = System.currentTimeMillis();
            for(int numRun=0; numRun < 2000; numRun++)
                { huge3 = huge1.multiply(huge2); }
            endTime = System.currentTimeMillis();
            runTime +=(double) (endTime - startTime)/((double) 200);
        }
        runTime = runTime/((double)100);
        System.out.println("Runtime for multiply() with HugeInteger of " + array_of_n_mult[i] + " digits is " + runTime);
        runTime = 0.0; 
        }*/
        
        int hello;
        for(i=0;i<array_of_n.length;i++){ // subtract huge int
        for(numInts=0; numInts < 100; numInts++) {
            huge1 = new HugeInteger(array_of_n[i]);        //creates a random integer of n digits
            huge2 = new HugeInteger(array_of_n[i]);        //creates a random integer of n digits
            startTime = System.currentTimeMillis();
            for(int numRun=0; numRun < 2000; numRun++)
                { hello = huge1.compareTo(huge2); }
            endTime = System.currentTimeMillis();
            runTime +=(double) (endTime - startTime)/((double) 200);
        }
        runTime = runTime/((double)100);
        System.out.println("Runtime for compareTo() with HugeInteger of " + array_of_n[i] + " digits is " + runTime);
        runTime = 0.0; 
        }
    
        
        Random rnd = new Random();   
        int me;
    BigInteger big1, big2, big3; // for addition
    for(i=0;i<array_of_n.length;i++){
        for(numInts=0; numInts < 100; numInts++) {
            runTime = 0.00; // reset
            big1 = new BigInteger(array_of_n[i], rnd);        //creates a random integer of n digits
            big2 = new BigInteger(array_of_n[i], rnd);        //creates a random integer of n digits
            startTime = System.currentTimeMillis();
            for(int numRun=0; numRun < 500; numRun++)
                { me = big1.compareTo(big2); }
            endTime = System.currentTimeMillis();
            runTime +=(double) (endTime - startTime)/((double) 500);
        }
        runTime = runTime/((double)100);
        System.out.println("Runtime for add() with BigInteger of " + array_of_n[i] + " digits is " + runTime);
        }   
    
}
