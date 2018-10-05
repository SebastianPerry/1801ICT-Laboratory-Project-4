package com.company;

import javax.swing.*;
import java.io.*;

public class Main extends Screens {
    // main start of code
    public static void main(String[] args) {
        try {
			load();
		} catch(Exception e) {
			System.out.println("the has been an issue with file loading");
		}
        mainMenu();
    }

    // methods
    // loads serialised objects
    public static void load() throws IOException, ClassNotFoundException {
		File teacherFile = new File(TFILE_NAME), studentFile = new File(SFILE_NAME);
		FileInputStream te = new FileInputStream(teacherFile), st = new FileInputStream(studentFile);
		ObjectInputStream teacher = new ObjectInputStream(te), student = new ObjectInputStream(st);
		
		// teacher objects
		try {
            int y = 0;
		    while (true) {

				Teacher a = (Teacher)teacher.readObject();
				teacherArray[y] = a;
				y++;
			}
		}catch (EOFException ex) {}

		// student objects
		try {
            int x = 0;
		    while(true) {

				Student a = (Student)student.readObject();
				studentArray[x] = a;
				x++;
			}
		} catch (EOFException ex) {}
    }
}