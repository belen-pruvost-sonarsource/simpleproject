package com.sonarsource;

public class SimpleClass {
    public void get() {
        java.util.regex.Pattern.compile("(a+)+").matcher(
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
        "aaaaaaaaaaaaaaa!").matches(); // Sensitive
        
        
        
        


        java.util.regex.Pattern.compile("(a+)+").matcher(
        "bbbbbbbbbb"+
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
        "aaaaaaaaaaaaaaa!").matches(); // Sensitive
    }
}
