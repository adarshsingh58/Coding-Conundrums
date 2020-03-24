package com.questions.OtherPrograms;

import java.util.Iterator;

class Main {
    public Main() {
        String a = "Adarsh";
//		ImplementIterator i=
    }
}

public class ImplementIterator implements Iterable<String> {

    @Override
    public Iterator<String> iterator() {
        return new CustomIterator(this);
    }

}

class CustomIterator implements Iterator<String> {

    char[] c;
    int i = 0;

    public CustomIterator(ImplementIterator obj) {
        c = obj.toString().toCharArray();
    }

    @Override
    public boolean hasNext() {
        if (i < c.length) {
            return true;
        }
        return false;
    }

    @Override
    public String next() {
        return "";
    }

}
