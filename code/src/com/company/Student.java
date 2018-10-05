package com.company;

import java.io.Serializable;

class Student extends Contact implements Serializable {
    // variables
    private int[] grades = new int[4];
    private int courseCount = 0;
    
    // methods
    public Student(int num) {
        setNumber(num);
    }
    // setters
	public void decrease() {
    	this.setNumber((this.getNumber() - 1));
	}
	
    public boolean setGrades(int ter1, int ter2, int ter3, int ter4) {
        int[] terms = {ter1, ter2, ter3, ter4};
        for (int x = 0; x <= 3; x++) {
            this.grades[x] = terms[x];
        }
        return(true);
    }

    // getters
    public int getGrades(int ter) {
        return(this.grades[ter]);
    }

}