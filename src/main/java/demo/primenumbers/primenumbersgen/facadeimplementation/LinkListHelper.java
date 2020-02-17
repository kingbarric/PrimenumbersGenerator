/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.primenumbers.primenumbersgen.facadeimplementation;

import org.springframework.stereotype.Component;

/**
 *
 * @author mac
 */
 
public class LinkListHelper {
    ListNode head;
    private int size;
    
    public void insert(int data){
        ListNode node = new ListNode();
        node.data =data;
        node.next =null;
        size++;
        
        if(head==null){
            head = node;
        }else{
            ListNode n = head;
            while(n.next!=null){
                n = n.next;
            }
            n.next = node;
        }
    }
    
    public void show(){
        ListNode node = head;
        while(node.next !=null){
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }
    
    public ListNode getList(){
        return head;
    }
    
    public int getSize(){
        return size;
    }
}
