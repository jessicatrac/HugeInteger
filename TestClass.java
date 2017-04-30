/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hugeinteger;

/**
 *
 * @author Jessica
 */
public class TestClass {
    
    public static void main(String[] args) {
    String pos_num = "15385";
    String neg_num = "-499";
    String pos_num_tocompare = "59";
    
    // first constructor
    HugeInteger first = new HugeInteger(pos_num);
    System.out.println("A positive array implementation:" + first.toString());   
    
    HugeInteger second = new HugeInteger(neg_num);
    System.out.println("A negative array implementation is:" + second.toString());
    
    // second constructor
    HugeInteger third = new HugeInteger(5);
    System.out.println("A random array implementation is:" + third.toString());    
    
    // addition
    System.out.println("\nTESTING ADD() WITH A LARGER FIRST NUMBER: \n");
    
    String add1A = "700";
    String add1AA = "315";
    HugeInteger numadd1A = new HugeInteger(add1A);
    HugeInteger numadd1AA = new HugeInteger(add1AA);
    System.out.println("Test Number for below:" + numadd1A.toString()); 
    System.out.println("Test Number for below:" + numadd1AA.toString());
    System.out.println("1A: BIG POSITIVE + SMALL POSITIVE:" + (numadd1A.add(numadd1AA)).toString());
    
    String add1B = "700";
    String add1BB = "-15";
    HugeInteger numadd1B = new HugeInteger(add1B);
    HugeInteger numadd1BB = new HugeInteger(add1BB);
    System.out.println("Test Number for below:" + numadd1B.toString()); 
    System.out.println("Test Number for below:" + numadd1BB.toString());
    System.out.println("BIG POSITIVE + SMALL NEGATIVE:" + (numadd1B.add(numadd1BB)));
    
    
    String add1C = "-574";
    String add1CC = "10";
    HugeInteger numadd1C = new HugeInteger(add1C);
    HugeInteger numadd1CC = new HugeInteger(add1CC);
    System.out.println("Test Number for below:" + numadd1C.toString()); 
    System.out.println("Test Number for below:" + numadd1CC.toString());
    System.out.println("BIG NEGATIVE + SMALL POSITIVE:" + numadd1C.add(numadd1CC));
    
    String add1D = "-1052";
    String add1DD = "-105";
    HugeInteger numadd1D = new HugeInteger(add1D);
    HugeInteger numadd1DD = new HugeInteger(add1DD);
    System.out.println("Test:" + numadd1D.toString()); 
    System.out.println("Test:" + numadd1DD.toString()); 
    System.out.println("BIG NEGATIVE + SMALL NEGATIVE:" + numadd1D.add(numadd1DD));
    
    System.out.println("\nTESTING ADD() WITH A LARGER SECOND NUMBER: \n");
    
    String add2A = "52";
    String add2AA = "105";
    HugeInteger numadd2A = new HugeInteger(add2A);
    HugeInteger numadd2AA = new HugeInteger(add2AA);
    System.out.println("Test:" + numadd2A.toString()); 
    System.out.println("Test:" + numadd2AA.toString()); 
    System.out.println("SMALL POSITIVE + BIG POSITIVE:" + (numadd2A.add(numadd2AA)).toString());
    
    String add2B = "52";
    String add2BB = "-1200";
    HugeInteger numadd2B = new HugeInteger(add2B);
    HugeInteger numadd2BB = new HugeInteger(add2BB);
    System.out.println("Test:" + numadd2B.toString()); 
    System.out.println("Test:" + numadd2BB.toString()); 
    System.out.println("SMALL POSITIVE + BIG NEGATIVE:" + numadd2B.add(numadd2BB));
    
    String add2C = "-100";
    String add2CC = "56900";
    HugeInteger numadd2C = new HugeInteger(add2C);
    HugeInteger numadd2CC = new HugeInteger(add2CC);
    System.out.println("Test:" + numadd2C.toString()); 
    System.out.println("Test:" + numadd2CC.toString()); 
    System.out.println("SMALL NEGATIVE + BIG POSITIVE:" + numadd2C.add(numadd2CC));
    
    String add2D = "-2";
    String add2DD = "-126";
    HugeInteger numadd2D = new HugeInteger(add2D);
    HugeInteger numadd2DD = new HugeInteger(add2DD);
    System.out.println("Test:" + numadd2D.toString()); 
    System.out.println("Test:" + numadd2DD.toString()); 
    System.out.println("SMALL NEGATIVE + BIG NEGATIVE:" + numadd2D.add(numadd2DD));
    
    // compareTo
    System.out.println("\nCOMPARETO TESTING: \n");
    
    System.out.println("Test:" + first.toString()); 
    System.out.println("Test:" + second.toString()); 
    System.out.println("Checks which is bigger (obvious + / -):" + first.compareTo(second));
    
    String compareB = "-127";
    String compareBB = "127";
    HugeInteger numcompareB = new HugeInteger(compareB);
    HugeInteger numcompareBB = new HugeInteger(compareBB);
    System.out.println("Test:" + numcompareB.toString()); 
    System.out.println("Test:" + numcompareBB.toString()); 
    System.out.println("Checks which is bigger (same # of digits, both -):" + numcompareB.compareTo(numcompareBB));
    
    HugeInteger seventh = new HugeInteger(pos_num_tocompare);
    System.out.println("Test:" + seventh.toString()); 
    System.out.println("Test:" + seventh.toString()); 
    System.out.println("Checks which is bigger (same number):" + seventh.compareTo(seventh));
    
    // subtraction
    System.out.println("\nSUBTRACTION TESTING: \n");
    
    System.out.println("\nTESTING SUBTRACT() WITH A LARGER FIRST NUMBER: \n");

    String sub3A = "256";
    String sub3AA = "9";
    HugeInteger numsub3A = new HugeInteger(sub3A);
    HugeInteger numsub3AA = new HugeInteger(sub3AA);
    System.out.println("Test:" + numsub3A.toString()); 
    System.out.println("Test:" + numsub3AA.toString()); 
    System.out.println("BIG POSITIVE - SMALL POSITIVE:" + (numsub3A.subtract(numsub3AA)));
    
    
    String sub3B = "980";
    String sub3BB = "-15";
    HugeInteger numsub3B = new HugeInteger(sub3B);
    HugeInteger numsub3BB = new HugeInteger(sub3BB);
    System.out.println("Test:" + numsub3B.toString()); 
    System.out.println("Test:" + numsub3BB.toString()); 
    System.out.println("BIG POSITIVE - SMALL NEGATIVE:" + numsub3B.subtract(numsub3BB));
    
    String sub3C = "-250";
    String sub3CC = "60";
    HugeInteger numsub3C = new HugeInteger(sub3C);
    HugeInteger numsub3CC = new HugeInteger(sub3CC);
    System.out.println("Test:" + numsub3C.toString()); 
    System.out.println("Test:" + numsub3CC.toString()); 
    System.out.println("BIG NEGATIVE - SMALL POSITIVE:" + numsub3C.subtract(numsub3CC));
    
    String sub3D = "-2540";
    String sub3DD = "-65";
    HugeInteger numsub3D = new HugeInteger(sub3D);
    HugeInteger numsub3DD = new HugeInteger(sub3DD);
    System.out.println("Test:" + numsub3D.toString()); 
    System.out.println("Test:" + numsub3D.toString()); 
    System.out.println("BIG NEGATIVE - SMALL NEGATIVE:" + numsub3D.subtract(numsub3DD));
    
    System.out.println("\nTESTING SUBTRACT() WITH A LARGER SECOND NUMBER: \n");
            
    String sub4A = "6";
    String sub4AA = "985";
    HugeInteger numsub4A = new HugeInteger(sub4A);
    HugeInteger numsub4AA = new HugeInteger(sub4AA);
    System.out.println("Test:" + numsub4A.toString()); 
    System.out.println("Test:" + numsub4AA.toString()); 
    System.out.println("SMALL POSITIVE - BIG POSITIVE:" + (numsub4A.subtract(numsub4AA)));
    
    String sub4B = "60";
    String sub4BB = "-565";
    HugeInteger numsub4B = new HugeInteger(sub4B);
    HugeInteger numsub4BB = new HugeInteger(sub4BB);
    System.out.println("Test:" + numsub4B.toString()); 
    System.out.println("Test:" + numsub4BB.toString()); 
    System.out.println("SMALL POSITIVE - BIG NEGATIVE:" + numsub4B.subtract(numsub4BB));
    
    
    String sub4C = "-10";
    String sub4CC = "7001";
    HugeInteger numsub4C = new HugeInteger(sub4C);
    HugeInteger numsub4CC = new HugeInteger(sub4CC);
    System.out.println("Test:" + numsub4C.toString()); 
    System.out.println("Test:" + numsub4CC.toString());
    System.out.println("SMALL NEGATIVE - BIG POSITIVE:" + numsub4C.subtract(numsub4CC));
    
    String sub4D = "-780";
    String sub4DD = "-17430";
    HugeInteger numsub4D = new HugeInteger(sub4D);
    HugeInteger numsub4DD = new HugeInteger(sub4DD);
    System.out.println("Test:" + numsub4D.toString()); 
    System.out.println("Test:" + numsub4DD.toString()); 
    System.out.println("SMALL NEGATIVE - BIG NEGATIVE:" + numsub4D.subtract(numsub4DD));
    
    
    // mutiply
    System.out.println("\nTESTING MULTIPLY(): \n");
            
    String mult1A = "650";
    String mult1AA = "15";
    HugeInteger nummult1A = new HugeInteger(mult1A);
    HugeInteger nummult1AA = new HugeInteger(mult1AA);
    System.out.println("Test:" + nummult1A.toString()); 
    System.out.println("Test:" + nummult1AA.toString()); 
    System.out.println("PRODUCT:" + (nummult1A.multiply(nummult1AA)));
    
    String mult1B = "10";
    String mult1BB = "3515";
    HugeInteger nummult1B = new HugeInteger(mult1B);
    HugeInteger nummult1BB = new HugeInteger(mult1BB);
    System.out.println("Test:" + nummult1B.toString()); 
    System.out.println("Test:" + nummult1BB.toString()); 
    System.out.println("PRODUCT (smaller @ front):" + (nummult1B.multiply(nummult1BB)));
    
    String mult1C = "-210";
    String mult1CC = "-29";
    HugeInteger nummult1C = new HugeInteger(mult1C);
    HugeInteger nummult1CC = new HugeInteger(mult1CC);
    System.out.println("Test:" + nummult1C.toString()); 
    System.out.println("Test:" + nummult1CC.toString()); 
    System.out.println("PRODUCT (smaller @ front):" + (nummult1C.multiply(nummult1CC)));
    
    }
}
