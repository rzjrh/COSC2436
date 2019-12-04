/*
 COSC 436
 Project Two- HashMap
 Professor Meng
 Reza Akhlaqi 
 12-2-2019
 */
package Model;
public class ElementModel {
    private String name;
    private int atomicNumber;
    private double atomicWeight;

    //Constructor
    public ElementModel(String name, int atomicNumber, double atomicWeight) {
        this.name = name;
        this.atomicNumber = atomicNumber;
        this.atomicWeight = atomicWeight;
    }
    
    public ElementModel(){
        name ="";
        atomicNumber =0;
        atomicWeight =0;
    }
    
        //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public double getAtomicWeight() {
        return atomicWeight;
    }

    public void setAtomicWeight(double atomicWeight) {
        this.atomicWeight = atomicWeight;
    }

    
    @Override
    public boolean equals(Object obj) {
        ElementModel e = (ElementModel)obj;
        return (e.atomicWeight==this.atomicWeight
        && e.atomicNumber == this.atomicNumber
        && e.name.equalsIgnoreCase(this.name));
    }

    @Override
    public String toString() {
        return String.format("%18s %10s %10s",name,atomicNumber,atomicWeight);
    }
}