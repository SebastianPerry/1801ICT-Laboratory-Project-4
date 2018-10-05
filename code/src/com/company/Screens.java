package com.company;

import javax.imageio.IIOException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

abstract class Screens {
    // variables
    // name of file containing saved serialised objects
    public static String TFILE_NAME = "NerangHighInfoSysT.txt";
    public static String SFILE_NAME = "NerangHighInfoSysS.txt";
    public static int nextStudent = 0;

    // object arrays
    public static Teacher[] teacherArray = new Teacher[4];
    public static Student[] studentArray = new Student[80];

    // application name
    private static final String APP_NAME = "NerangHighInfoSys";

    // methods
    public Screens() {}

    // serialises and saves objects to files
    public static void save() {
        File teacherFile = new File(TFILE_NAME), studentFile = new File(SFILE_NAME);
        try {
            FileOutputStream te = new FileOutputStream(teacherFile), st = new FileOutputStream(studentFile);
            ObjectOutputStream teacher = new ObjectOutputStream(te), student = new ObjectOutputStream(st);
            // teacher objects
            for (Teacher x : teacherArray) {
                teacher.writeObject(x);
            }
            teacher.close();
            te.close();
            // student objects
            for (Student x : studentArray) {
                student.writeObject(x);
            }
            student.close();
            st.close();
        } catch (Exception e) {
            System.out.println("the has been an issue with file saving");
        }
    }

    public static void mainMenu() {
        // application frame
        JFrame frame = new JFrame(APP_NAME);

        // telling program to exit when gui closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // buttons:
        JButton StudentsBtn = new JButton("Students"), TeachersBtn = new JButton("Teachers");

        // layoutComponents
        JPanel box0 = new JPanel(), box1 = new JPanel(), box2 = new JPanel(), box3 = new JPanel();
        box0.setLayout(new BoxLayout(box0, BoxLayout.Y_AXIS));
        box1.setLayout(new BoxLayout(box1, BoxLayout.X_AXIS));
        box2.setLayout(new BoxLayout(box2, BoxLayout.X_AXIS));
        frame.add(box0);
        box0.add(box1);
        box0.add(box3);
        box0.add(box2);
        box1.setAlignmentX(Component.CENTER_ALIGNMENT);
        box2.setAlignmentX(Component.CENTER_ALIGNMENT);
        box1.setBorder(new EmptyBorder(5, 10, 10, 20));
        box2.setBorder(new EmptyBorder(5, 20, 20, 5));
        box3.setBorder(new EmptyBorder(5, 20, 20, 5));
        box1.add(new JLabel("Main Menu"));
        box3.add(new JLabel("welcome to Sebastian Perry's Nerang high info system, please select one the data array's to begin"));
        box2.add(StudentsBtn);
        box2.add(TeachersBtn);

        // addListeners to the components and the frame.

        StudentsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                studentMenu();
            }
        });

        TeachersBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        // save on exit
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                save();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public static void studentMenu() {
        // application frame
        JFrame frame = new JFrame(APP_NAME);

        // telling program to exit when gui closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // buttons:
        JButton addBtn = new JButton("Add");

        // layoutComponents
        JPanel box0 = new JPanel(), box1 = new JPanel(), box2 = new JPanel(), box3 = new JPanel();
        box0.setLayout(new BoxLayout(box0, BoxLayout.Y_AXIS));
        box1.setLayout(new BoxLayout(box1, BoxLayout.X_AXIS));
        box2.setLayout(new BoxLayout(box2, BoxLayout.X_AXIS));
        frame.add(box0);
        box0.add(box1);
        box0.add(box3);
        box0.add(box2);
        box1.setAlignmentX(Component.CENTER_ALIGNMENT);
        box2.setAlignmentX(Component.CENTER_ALIGNMENT);
        box1.setBorder(new EmptyBorder(5, 10, 10, 20));
        box2.setBorder(new EmptyBorder(5, 20, 20, 5));
        box3.setBorder(new EmptyBorder(5, 20, 20, 5));
        box1.add(new JLabel("Student database interface"));
        box3.add(new JLabel("welcome to the student data place, here information can be viewed and recorded"));
        box2.add(addBtn);

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentArray[nextStudent] = new Student(nextStudent);
                nextStudent++;
                save();
                frame.setVisible(false);
                frame.removeAll();
                studentMenu();
            }
        });


        // display student records
        for (Student s : studentArray) {
            if (s != null) {
                JPanel a = new JPanel();
                a.setLayout(new BoxLayout(a, BoxLayout.X_AXIS));
                box0.add(a);
                a.setAlignmentX(Component.CENTER_ALIGNMENT);
                a.setBorder(new EmptyBorder(5, 20, 20, 5));
                JButton b = new JButton("change"), c = new JButton("delete");
                // student info
                nextStudent = (s.getNumber()) + 1;
                a.add(new JLabel("Student Number : "));
                a.add(new JLabel(Integer.toString(s.getNumber())));
                a.add(new JLabel("      First Name : "));
                a.add(new JLabel(s.getFirstName()));
                a.add(new JLabel("      Last Name : "));
                a.add(new JLabel(s.getLastName()));
                a.add(new JLabel("      Year Of Birth : "));
                a.add(new JLabel(Integer.toString(s.getYOB())));
                a.add(new JLabel("      Address : "));
                a.add(new JLabel(s.getAddress()));
                a.add(new JLabel("      Grades : "));
                for (int i = 0; i <= 3; i++) {
                    a.add(new JLabel(" Term "));
                    a.add(new JLabel(Integer.toString(i + 1)));
                    a.add(new JLabel(" : "));
                    a.add(new JLabel(Integer.toString(s.getGrades(i))));
                }
                a.add(b);
                a.add(c);
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                    }
                });

                c.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                    }
                });
            }

            // save on exit
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    save();
                }
            });
            frame.pack();
            frame.setVisible(true);
        }
    }
}