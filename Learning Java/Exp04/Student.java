/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BASIL.LOE.Exp04;

import java.util.Scanner;

/**
 *
 * @author 1761002
 */
public class Student implements Internal , External{
    
    private double cia1,cia3,internal,midsem,endsem,external;

    
    
    
    @Override
    public void calculateFinalInternalMarks() {
        internal = (cia1*20/50) + (midsem*50/100) + (cia3*20/50);
    }

    @Override
    public void calculateFinalExternalMarks() {
        external = (endsem*50/100);
    }

    
    
    
    
    public void setCia1(double cia1) {
        this.cia1 = cia1;
    }

    public void setCia3(double cia3) {
        this.cia3 = cia3;
    }

    public void setEndsem(double endsem) {
        this.endsem = endsem;
    }

    public void setMidsem(double midsem) {
        this.midsem = midsem;
    }

    public double getExternal() {
        return external;
    }

    public double getInternal() {
        return internal;
    }

       
    
    
    public void setDetails(){
         Scanner read = new Scanner(System.in);
        
        System.out.println("\nEnter CIA 1 marks : ");
        double cia1 = read.nextDouble();
        setCia1(cia1);
        System.out.println("\nEnter MidSem marks : ");
        double midsem = read.nextDouble();
        setMidsem(midsem);
        System.out.println("\nEnter CIA 3 marks : ");
        double cia3 = read.nextDouble();
        setCia3(cia3);
        System.out.println("\nEnter EndSem marks : ");
        double endsem  = read.nextDouble();
        setEndsem(endsem);
        
        calculateFinalInternalMarks();
        calculateFinalExternalMarks();
    
    }
    
    public void getDetails(){
        
        System.out.println("\nInternal marks : " + getInternal());
        System.out.println("\nExternal marks : " + getExternal());
    }
    
    
}
