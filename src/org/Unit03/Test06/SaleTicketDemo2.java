package org.Unit03.Test06;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/10 14:43
 */
public class SaleTicketDemo2 {
    public static void main(String[] args) {
        SaleTicket2 st1 = new SaleTicket2();
        SaleTicket2 st2 = new SaleTicket2();
        SaleTicket2 st3 = new SaleTicket2();

        st1.setName("窗口一");
        st2.setName("窗口二");
        st3.setName("窗口三");

        st1.start();
        st2.start();
        st3.start();
    }
}
