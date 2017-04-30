/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hugeinteger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Calvin
 */
public class BigIntegerTest {
    //Creates .txt files containing run time data
    //Each row corresponds to a different value of n in sequential order based on it's placement in the array.
    public static void main(String[] args) {
        BigInteger huge1;
        BigInteger huge2;
        BigInteger huge3;
        
        long startTime;
        long endTime;
        int numInts;
        int numRun;
        double runTime = 0.0;
        
        int MAXRUN = 5000;
        int MAXNUMINTS = 500;
        
        int[] integerSizes = {10,50,100,250,300,400,500,600,700,750,1000,2500,5000,10000}; // Adjust sizes of n as you want
                
        int add;
        int subtract;
        int multiply;
        int compare;
        
        double compareAverage = 0;
        Random generator = new Random();
        
        try{
            BufferedWriter addWriter = new BufferedWriter(new FileWriter("addData.txt")); // This is the file name with the data
            for(add=0;add<integerSizes.length;add++){
                for(numInts = 0; numInts < MAXNUMINTS; numInts++){
                    huge1 = new BigInteger(integerSizes[add],generator);
                    huge2 = new BigInteger(integerSizes[add],generator);
                    startTime = System.currentTimeMillis();
                    for(numRun =0; numRun<MAXRUN; numRun++){
                    huge3 = huge1.add(huge2);
                    }
                    endTime = System.currentTimeMillis();
                    runTime +=(double) (endTime - startTime)/((double) MAXRUN);
                }
                runTime = runTime/((double)MAXNUMINTS);
                addWriter.write(String.valueOf(runTime));
                addWriter.newLine();
            }
            addWriter.close();        
        }
        catch(IOException e){
        }
        
        try{
            BufferedWriter subtractWriter = new BufferedWriter(new FileWriter("subtractData.txt"));// This is the file name with the data
            for(subtract=0;subtract<integerSizes.length;subtract++){
                for(numInts = 0; numInts < MAXNUMINTS; numInts++){
                    huge1 = new BigInteger(integerSizes[subtract],generator);
                    huge2 = new BigInteger(integerSizes[subtract],generator);
                    startTime = System.currentTimeMillis();
                    for(numRun =0; numRun<MAXRUN; numRun++){
                    huge3 = huge1.subtract(huge2);
                    }
                    endTime = System.currentTimeMillis();
                    runTime +=(double) (endTime - startTime)/((double) MAXRUN);
                }
                runTime = runTime/((double)MAXNUMINTS);
                subtractWriter.write(String.valueOf(runTime));
                subtractWriter.newLine();
                
            }
            subtractWriter.close();        
        }
        catch(IOException e){
        }
        
        try{
            BufferedWriter compareWriter = new BufferedWriter(new FileWriter("compareData.txt"));// This is the file name with the data
            for(compare=0;compare<integerSizes.length;compare++){
                for(int i=0;i<100;i++){
                    for(numInts = 0; numInts < MAXNUMINTS; numInts++){
                        huge1 = new BigInteger(integerSizes[compare],generator);
                        huge2 = new BigInteger(integerSizes[compare],generator);
                        startTime = System.currentTimeMillis();
                        for(numRun =0; numRun<MAXRUN; numRun++){
                            int compareValue = huge1.compareTo(huge2);
                        }
                    endTime = System.currentTimeMillis();
                    runTime +=(double) (endTime - startTime)/((double) MAXRUN);
                    }
                runTime = runTime/((double)MAXNUMINTS);
                compareAverage = compareAverage + runTime;
                }
                compareAverage = compareAverage/(double)100;
                compareWriter.write(String.valueOf(compareAverage));
                compareWriter.newLine();
            }
            compareWriter.close();        
        }
        catch(IOException e){
        }
        
        try{
            BufferedWriter multiplyWriter = new BufferedWriter(new FileWriter("multiplyData.txt"));// This is the file name with the data
            for(multiply=0;multiply<integerSizes.length;multiply++){ // Adjust the integer value subtracted from the length accordingly to get a reasonable run time
                for(numInts = 0; numInts < MAXNUMINTS; numInts++){
                    huge1 = new BigInteger(integerSizes[multiply],generator);
                    huge2 = new BigInteger(integerSizes[multiply],generator);
                    startTime = System.currentTimeMillis();
                    for(numRun =0; numRun<MAXRUN; numRun++){
                    huge3 = huge1.multiply(huge2);
                    }
                    endTime = System.currentTimeMillis();
                    runTime +=(double) (endTime - startTime)/((double) MAXRUN);
                }
                runTime = runTime/((double)MAXNUMINTS);
                multiplyWriter.write(String.valueOf(runTime));
                multiplyWriter.newLine();
            }
            multiplyWriter.close();        
        }
        catch(IOException e){
        }
    }
}

