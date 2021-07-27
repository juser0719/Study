// ##DELETE_FILE:
package com.ssafy.day3.poly;

import com.ssafy.day3.extend.person.Person;
import com.ssafy.day3.extend.person.SpiderMan;

public class PolyTest1 {

    public static void main(String[] args) {
        SpiderMan onlyOne = new SpiderMan();
        
        SpiderMan sman = onlyOne;
       
        Person person = onlyOne;
        
        Object obj = onlyOne;
        
        // Venom venom = onlyOne;
    }
}

class Venom extends SpiderMan{}