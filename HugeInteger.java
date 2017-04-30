/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hugeinteger;
import java.util.Random; //not sure if allowed... 

/**
 *
 * @author Jessica
 */
public class HugeInteger {
    private int size; // size of array
    private boolean negative; // to detect negatives, value of 1
    private int[] array; //implementation with arrays
    
    public HugeInteger(String val) throws IllegalArgumentException { //remember exceptions
            int i, d, k = 0;
            char c = val.charAt(0);
            size = val.length();
            
            if(c == '-' || (48 <= c && c <= 57)){ // valid string input
            
                if(c == '-') // checks if negative - if it is, 'negative' field set to 1
                    {negative = true;
                    size--;} //skips the negative sign
                else
                    {negative = false;}
            
                array = new int[size];
                
                if(negative == true) // copy string input into an int array implementation
                    {for(i=1;i<=size;i++){
                        c = val.charAt(i);
                        d = c - 48;
                        array[k] = d;
                        k++;}
                    }
                
                else
                {
                    for(i=0;i<size;i++){
                        c = val.charAt(i);
                        d = c - 48;
                        array[k] = d;
                        k++;
                    }
                }
            }
            else //occurs when there is no beginning minus sign or characters that aren't 0-9 decimals
                throw new IllegalArgumentException("Argument does not meet specifications of constructor");
        
    }
    
    public HugeInteger(int n) throws IllegalArgumentException {
        int i, random;
        size = n;
        if(n >= 1){
            array = new int[size];
            for(i = 0;i < n; i++) { // generates n random ints and stores into array 
                Random rand = new Random();
                random = rand.nextInt(9)+1;  
                array[i] = random;}
            }
        else
            throw new IllegalArgumentException("Argument does not meet specifications of constructor");
        }
    
    
    public HugeInteger add(HugeInteger h) {
        int add = 0, i, j=0;
        String val_sum = "0"; // inputted into constructor
        HugeInteger sum = new HugeInteger(val_sum);
        
        if(size >= h.size){
        if(this.negative != true && h.negative != true) //CASE 1A - both positive
            {val_sum = ""; // add partial sum to this string
            j = h.size-1;
            for(i=(size-1);i>=0;i--)
                {if(i>=(size-h.size)) // will add the digits
                    {add = this.array[i] + h.array[j];
                    j--;
                    if(add >= 10) // checks for a carry - adjusts partial sum
                        {if((i-1) != -1)
                            {array[i-1] += 1; //adds the carry to next term
                            add = add%10;}} //updates the added term
                    val_sum = Integer.toString(add) + val_sum;} // adds the partial sum to string
                else
                    val_sum = Integer.toString(this.array[i]) + val_sum; //adds remaining digits from this
                }
            sum = new HugeInteger(val_sum); // input string to create HugeInt object
            val_sum = ""; // reset string
            return sum;
            }
            
        if(negative != true && h.negative == true) // case 1B - first is bigger + positive, second smaller + negative
            { // ie. 700 + -15 = 685 so 700 - 15, change to +15 then use subtruct
            h.negative = false; 
            sum = subtract(h);
            h.negative = true;
            sum.negative = false;
            return sum;
            }
        
        if(negative == true && h.negative != true) // case 1C - first is bigger + negative, second smaller + positive
            { // ie. - 450 + 50 = - 400 so subtract 450 - 50 then add (negative sign)
            this.negative = false; 
            sum = subtract(h);
            this.negative = true;
            sum.negative = true;
            return sum;
            }
        
        if(negative == true && h.negative == true) // case 1D - both are negative
            { // ie. - 450 - 50 = -500 so add 450 + 50 then add (negative sign)
            this.negative = false;
            h.negative = false;
            sum = this.add(h);
            this.negative = true;
            h.negative = true;
            sum.negative = true;
            }
        }
        
        else{ // first number is smaller
            if(negative != true && h.negative != true) //case 2A - both positive
                {val_sum = "";
                j = size-1;
                for(i=(h.size-1);i>=0;i--)
                    {if(i>=(h.size-size)) // will add the digits
                        {add = h.array[i] + array[j];
                        j--;
                        if(add >= 10) // checks for a carry
                            {if((i-1) != -1){
                            h.array[i-1] += 1; //adds the carry to next this term
                            add = add%10;}} //updates the added term
                        val_sum = Integer.toString(add) + val_sum;
                        }
                    else
                        val_sum = Integer.toString(h.array[i]) + val_sum; //adds remaining digits from this
                    }
                sum = new HugeInteger(val_sum);
                val_sum = "";
                return sum;
                }
         
        if(negative != true && h.negative == true) // case 2B - first is smaller + positive, second bigger + negative
            { // ie. 50 - 500 = - 450 so 50 - (+500) = - 450
            h.negative = false; // input it as a positive arguement to subtract()
            sum = h.subtract(this);
            h.negative = true;
            sum.negative = true;}
        
        if(negative == true && h.negative != true) // case 2C - first is smaller + negative, second bigger + positive
            { // ie. - 50 + 450 = 400 so subtract 450 - 50
            this.negative = false; 
            sum = h.subtract(this);
            this.negative = true;
            }
        
        if(negative == true && h.negative == true) // case 1D - both are negative
            { // ie. - 450 - 50 = -500 so add 450 + 50 then add (negative sign)
            this.negative = false;
            h.negative = false;
            sum = add(h);
            this.negative = true;
            h.negative = true;
            sum.negative = true;
            }
        }
        return sum;
    }
    
    public HugeInteger subtract(HugeInteger h) {
        int sub = 0, i, j = 0, k, p;
        String val_diff = "0"; // inputted into constructor
        HugeInteger difference = new HugeInteger(val_diff);

        if(size >= h.size){ // this is bigger than h
            
        if(this.negative != true && h.negative != true) // CASE 3A - bigger positive - smaller positive 
        {val_diff = "";
        j = h.size-1; // j will run through the second number
            k = 1;
            for(i=(size-1);i>=0;i--) // i will run through the first number
                {if(i>(size-h.size-1)) // will 'subtract' the digits
                    {if(this.array[i] >= h.array[j]) 
                        {sub = this.array[i] - h.array[j];
                        j--;}
                    else
                        {while(array[i-k] == 0) //finds digit to take away from
                            k++;
                        for(p=k;p>=1;p--)//updates current h element with added take away, carrying it down
                            {array[i-p]--;
                            array[i-p+1] += 10;} 
                        sub = this.array[i] - h.array[j];
                        j--;
                        k=1;}
                    val_diff = Integer.toString(sub) + val_diff;
                    }
                else
                    val_diff = Integer.toString(this.array[i]) + val_diff; //adds remaining digits from this, as no more h digits
                }
            difference = new HugeInteger(val_diff);
            val_diff = "";
            return difference; 
        }

            
        if(negative != true && h.negative == true) // case 3B - bigger positive - smaller negative
            { // ie. 500 - (-50) = 550 so 500 + (50) = 550
            h.negative = false; // input it as a positive arguement to add()
            difference = add(h);
            h.negative = true;
            difference.negative = false;}
        
        if(negative == true && h.negative != true) // case 3C - first is bigger + negative, second smaller + positive
            { // ie. - 450 - 50 = - 500 so add 450 + 50 then add (negative sign)
            this.negative = false; 
            difference = add(h);
            this.negative = true;
            difference.negative = true;
            }
        
        if(negative == true && h.negative == true) // case 3D - both are negative
            { // ie. - 450 - (-50) = -400 so subtract 450 - 50 then add (negative sign)
            this.negative = false;
            h.negative = false;
            difference = subtract(h);
            this.negative = true;
            h.negative = true;
            difference.negative = true;
            }
        }
        
        else{
        if(this.negative != true && h.negative != true) // CASE 4A - smaller positive - bigger positive 
        { // 50 - 450 = -400 by subtracting 450 - 50, then adding negative
            difference = h.subtract(this);
            difference.negative = true;
        }
        
        if(negative != true && h.negative == true) // case 4B - smaller positive - bigger negative
            { // ie. 50 - (-500) = 550 so 50 + (500) = 550
            h.negative = false; // input it as a positive arguement to add()
            difference = add(h);
            h.negative = true;
            difference.negative = false;}
        
        if(negative == true && h.negative != true) // case 4C - first is smaller + negative, second bigger + positive
            { // ie. - 50 - 500 = - 550 so add 50 + 500 then add (negative sign)
            this.negative = false; 
            difference = add(h);
            this.negative = true;
            difference.negative = true;
            }
        
        if(negative == true && h.negative == true) // case 4D - both are negative
            { // ie. - 450 - (-5000) = -400 so subtract 450 - 50 then add (negative sign)
            h.negative = false;
            this.negative = false;
            difference = h.subtract(this);
            h.negative = true;
            difference.negative = false;
            }
        
        }
        return difference;
    }
    
    public HugeInteger multiply(HugeInteger h) {
        int i, j, carry = 0;
        boolean sign = false; //used to indicate sign of product
        String to_add = "";
        int intermediate_add; // before finding carry
        HugeInteger product; // will be added to with 'to_add'
        int a[], b[]; // temporary arrays
        
        if(size > h.size) { // for multiplcation, order doesn't affect product; sign accounted for later
            a = array; // larger HugeInteger is assigned to A (the top)
            b = h.array;
            }
        
        else {
            a = h.array;
            b = array;
            }
        
        HugeInteger sum_array[] = new HugeInteger[b.length]; // will be an array of HugeInts to add up
        
        if(negative == h.negative) // product is + if both +/-, - if opposite
            sign = false;
        else
            sign = true;
        
        int m, count = 0;
        for(j=(b.length-1);j>=0;j--){ // distribute the j-digit to all i digits
            for(m=count;m>0;m--){ 
                    to_add = Integer.toString(0) + to_add;} // in long multiplication, the zeroes at the end
            for(i=(a.length-1);i>=0;i--){ // run through all i digits (top number)
                intermediate_add = a[i]*b[j] + carry;
                carry = 0; // after adding it, reset to 0
                if(intermediate_add >= 10)
                    {to_add = Integer.toString(intermediate_add%10) + to_add; // adding in front
                    carry = intermediate_add/10;} // ie. if 20, the carry is 2 and to_add is 0
                else
                    to_add = Integer.toString(intermediate_add) + to_add;
                }
            
            if(carry != 0)
                to_add = Integer.toString(carry) + to_add; // for the last carry case - now to_add has complete value
            carry = 0; // reset again
            sum_array[count] = new HugeInteger(to_add);
            count++;//System.out.println("string is:" + to_add.toString());
            to_add = ""; // reset for next 'summation'
            }
        
        product = sum_array[0]; // first 'sum' is initial product, use loop to add to it 
        for(i=1;i<b.length;i++){
            product = product.add(sum_array[i]); // product is the summation of sums from multiply loop above
            }
        
        product.negative = sign; // update the sign of product
        return product;
        }
    
    public int compareTo(HugeInteger h) {
        int start = 0, i;
        
        if(negative != true && h.negative == true) // this > h because it is + > -
            return 1;
        
        else if(negative == true && h.negative != true) // this < h because it is - < +
            return -1;
        
        else //both are positive or negative
            {
            if(size > h.size) // this and below checks by # of digits
                {if(negative == false)
                    return 1;
                else
                    return -1;}
            
            else if(size < h.size)
                {if(negative == false)
                    return -1;
                else
                    return 1;}
            
            else { // same # of digits, need to check for when digits no longer match ie. 123 vs 125
                if(negative == true && h.negative == true) // both are negative, jump the first array element
                    start = 1;
                
                i = start;
                while(i < size && (array[i] != h.array[i]))
                    i++; //exits loop where the digits no longer match
                
                if(i<(size-2)){
                    if(array[i] > h.array[i])
                        {if(start == 1) // reverse if both negative
                            return -1;
                        else
                            return 1;
                        }
                    else
                        {if(start == 1) // reverse if both negative
                            return 1;
                        else
                            return -1;
                        }
                    }
                else // numbers are equal as 'i' went through all digits w/o a match 
                    return 0;
                }    
            }
        }
    
    public String toString() {
        int i;
        String output = new String();
        if(size==0) //if list is empty, prints it out
            output="The list is empty";
        else   
            if(negative == true) //prints additional sign at front if negative
                {output += '-';
                }
        
        for(i=0;i<size;i++)
                output += array[i]; //prints each digit
       	return output;
        }
}
