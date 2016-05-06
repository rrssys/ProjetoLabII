/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author rrsantos
 */
public class Convercoes {


public static String convertToString(int a) {

    int c;
    char m;
    StringBuilder ans = new StringBuilder();
    // convert the String to int
    while (a > 0) {
        c = a % 10;
        a = a / 10;
        m = (char) ('0' + c);
        ans.append(m);
    }
    return ans.reverse().toString();
}



    
}
