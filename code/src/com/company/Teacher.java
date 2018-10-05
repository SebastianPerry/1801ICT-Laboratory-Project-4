package com.company;

import java.io.Serializable;

class Teacher extends Contact implements Serializable {
    // variables

    // methods
    public Teacher(int num) {
        setNumber(num);
    }
}