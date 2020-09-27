package org.Unit01.Extend;

public class ArrayDemo {
    public static void main(String[] args) {

    }
}
class Array {
    private int temp[];
    private int foot;

    public Array() {
    }

    public Array(int len) {
        if (len > 0) {
            this.temp = new int[len];
        } else {
            this.temp = new int[1];
        }
    }

    public boolean add(int i) {
        if (this.foot < this.temp.length) {
            this.temp[foot] = i;
            this.foot++;
            return true;
        } else {
            return false;
        }
    }

    public int[] getArray() {
        return this.temp;
    }
}

class ReverseArray extends Array {

}