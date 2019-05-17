/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BASIL.LOE.Exp05;

import java.util.ArrayList;
//import java.util.List;

/**
 *
 * @author 1761002
 *
 */
public class GenericStack <T> {
    
    private ArrayList <T> stack = new ArrayList<T>();
    private int top = 0;
    
    public void Push(T newItem){
        stack.add(top++,newItem);
    }
    
    public T Pop(){
        return stack.remove(--top);
    }
    
    public int size(){
        return stack.size();
    }
}
