package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentId;
	private String courses=null;
	private int tuitionbalance=0;
	private static int costOfCourse= 600;
	private static int id= 1000;
	
	//constructor prompts user to enter student's name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter student's first name: ");
		this.firstName= in.nextLine();
		
		System.out.println("Enter student's last name: ");
		this.lastName= in.nextLine();
		
		System.out.println("Enter student's grade level (1,2,3,4): ");
		this.gradeYear= in.nextInt();
		
		setStudentId();
		enroll();
		payTuition();
		
		System.out.println(firstName + " "+lastName+" "+gradeYear+" "+studentId);
		
		
	}

	//generate id
	private String setStudentId() {
		
		id++;
		
		//Gradelevel + static id		
		this.studentId= gradeYear+""+id;
		return studentId;
	}
	
	//enroll in courses
	public void enroll() {
		//get inside a loop, user hits 0
		do {
		System.out.println("Enter course to enroll(Q to quit): ");
		Scanner in= new Scanner (System.in);
		String course= in.nextLine();
		
		if(!course.equals("Q")) {
			courses=courses+"\n"+course;
			tuitionbalance= tuitionbalance+costOfCourse;
		}
		else {
			System.out.println("Break encountered");
			break;
		}
		
		} while (1!=0);
		
		System.out.println("Enrolled in: "+courses);
	}
	
	//view balance
	public void viewBalance() {
		System.out.println("Your balance is " +tuitionbalance);
	}
	
	//pay tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment: $");
		Scanner in= new Scanner(System.in);
		int payment= in.nextInt();
		tuitionbalance= tuitionbalance-payment;
		System.out.println("Thank you for your payment of $ "+payment);
		viewBalance();
	}
	
	//show status
	public String showInfo() {
		return "Name: "+firstName +" "+ lastName+"\nCourses Enrolled: " +courses + "\nBalance: $"+tuitionbalance;
		
	}
	

}
