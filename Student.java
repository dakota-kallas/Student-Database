import java.util.Scanner;

/*
 * Author: Dakota Kallas
 * Date: 4/21/2021
 * 
 * This is a class that represents a student.
 * It holds data such for the student such as
 * an ID number and the courses the student
 * is enrolled in.
 */

public class Student {
	private String first_name;
	private String last_name;
	private int grade_year;
	private String student_ID;
	private String courses = "";
	private int tuition_balance;
	private static int course_cost = 600;
	private static int id = 1000;
	
	
	/** 
	 * Constructor: This method will prompt the user to enter a student's name and year
	 */
	@SuppressWarnings("resource")
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter student's first name: ");
		this.first_name = in.nextLine();
		
		System.out.print("Enter student's last name: ");
		this.last_name = in.nextLine();
		
		System.out.println("\n1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior");
		
		boolean valid = false;
		// Ask for a grade level until a valid value is given
		while(!valid) {
			System.out.print("\nEnter student's grade level: ");
			if(in.hasNextInt()) {
				this.grade_year = in.nextInt();
				if(grade_year < 1 || grade_year > 4) {
					in.nextLine();
		            System.out.println("Invalid Integer value");
					continue;
				}
				valid = true;
	        } 
			else {
				in.nextLine();
	            System.out.println("Invalid Integer value");
	        }
		}

		set_student_ID();
	}
	
	/**
	 *  Method used to generate an ID number
	 */
	private void set_student_ID() {
		id++;	// Increase the ID number for the next student
		this.student_ID = grade_year + "" + id;
	}
	
	/** 
	 * Method used to enroll in courses
	 */
	@SuppressWarnings("resource")
	public void enroll() {
		// Loop until user quits
		while (1 != 0) {
			Scanner in = new Scanner(System.in);
			System.out.print("Enter course to enroll (Q to quit): ");
			String course = in.nextLine();
			if(course.equals("Q")) {
				break;
			}
			else {
				this.courses = this.courses + "\n " + course;
				tuition_balance += course_cost;
			}
		}
	}
	
	/**
	 *  Method used to view balance
	 */
	public void view_balance() {
		System.out.println("Your balance is: $" + tuition_balance);
	}
	
	/**
	 *  Method used to pay tuition
	 */
	@SuppressWarnings("resource")
	public void pay_tuition() {
		Scanner in = new Scanner(System.in);
		int payment = 0;
		boolean valid = false;
		// Ask for a payment amount until a valid value is given
		while(!valid) {
			System.out.print("Enter your payment: $");
			if(in.hasNextInt()) {
				payment = in.nextInt();
				valid = true;
	        } 
			else {
				in.nextLine();
	            System.out.println("Invalid payment value\n");
	        }
		}
		
		tuition_balance -= payment;
	}
	
	/**
	 *  Method used to show a student's status
	 *  @return A string representation of the student's status
	 */
	public String view_status() {
		return "\nName: " + first_name + " " + last_name
				+ "\nGrade Level: " + grade_year 
				+ "\nStudent ID: " + student_ID
				+ "\nCourses Enrolled:" + courses
				+ "\nBalance: $" + tuition_balance;
	}
	
}
