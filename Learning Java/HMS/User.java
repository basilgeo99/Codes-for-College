/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMS;


/**
 *
 * @author slimjim
 */
public class User extends Meds {
    private int ID;
    private String name;
    private int YOB;   //Year of birth
    private String bloodType;
    private String address;
    private int insNo;  //insurance number
    private long phNo;  //phone number
    private String diagnosis;

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public int n;

    //Meds M = new Meds();
    
    //Scanner read = new Scanner(System.in);
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getInsNo() {
        return insNo;
    }

    public void setInsNo(int insNo) {
        this.insNo = insNo;
    }

    public long getPhNo() {
        return phNo;
    }

    public void setPhNo(long phNo) {
        this.phNo = phNo;
    }
    
    
   public void ReadData(){
       
        System.out.print("Patient Name : ");
        String name = read.nextLine();
        setName(name);
        System.out.print("Patient ID : ");
        int ID = read.nextInt();
        setID(ID);
        System.out.print("Year of Birth : ");
        int YOB = read.nextInt();
        setYOB(YOB);
        System.out.print("Phone Number : ");
        long phNo = read.nextLong();
        setPhNo(phNo);
        System.out.print("Blood Type : ");
        String bloodType = read.next();
        setBloodType(bloodType);
        read.nextLine();    //Blank fire
        System.out.print("Address : ");
        String address  = read.nextLine();
        setAddress(address);
        System.out.print("Insurance Number : ");
        int insNo = read.nextInt();
        setInsNo(insNo);
        read.nextLine();    //Blank fire
        System.out.println("Enter Diagnosis now? (y/n) : ");
        String m = read.next();
        read.nextLine();    //Blank fire
        String diagnosis;
        if(m.equalsIgnoreCase("y")){
            System.out.println("Diagnosis : ");
            diagnosis = read.nextLine();   
        }
        else{
            diagnosis = "To Be Done. ";
        }
        setDiagnosis(diagnosis);
        
        if(!diagnosis.equalsIgnoreCase("To Be Done. ")){
        System.out.print("Enter Number of drugs : ");
        n = read.nextInt();
        read.nextLine();
        System.out.print("RX -  \n");
        MedList(n); 
        }
        
    }
   
   public void GetData(){
        System.out.println("Patient Name : " + getName());
     
        System.out.println("Patient ID : " + getID());
     
        System.out.println("Year of Birth : " + getYOB());
    
        System.out.println("Phone Number : " + getPhNo());
      
        System.out.println("Blood Type : " + getBloodType());
      
        System.out.println("Address : " + getAddress());
       
        System.out.println("Insurance Number : " + getInsNo());
        
        System.out.println("Diagnosis : " +  getDiagnosis());
        
        if(!getDiagnosis().equalsIgnoreCase("To Be Done. ")){
        PrintMedList(n);
        System.out.println("Total Bill : " + getTotalBill());
        }
         
   }
}
