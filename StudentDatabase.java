import java.util.Scanner;

/*
 * Author: Dakota Kallas
 * Date: 4/21/2021
 * 
 * This is a program that implements a student database that
 * allows for administrators to keep track of a certain amount
 * of students and their respective data.
 */

public class StudentDatabase {

	public static void main(String[] args) {
		// Ask how many new students the user wants to add
		Scanner in = new Scanner(System.in);
		int num_students = 0;
		boolean valid = false;
		// Ask for an amount of students until a valid value is given
		while(!valid) {
			System.out.print("Enter the number of new students to enroll: ");
			if(in.hasNextInt()) {
				num_students = in.nextInt();
				valid = true;
	        } 
			else {
				in.nextLine();
	            System.out.println("Invalid Integer value\n");
	        }
		}

		Student[] students = new Student[num_students];
		
		// Create n number of new students
		for(int n = 0; n < num_students; n++) {
			students[n] = new Student();
			students[n].enroll();
			students[n].view_balance();
			students[n].pay_tuition();
			System.out.println(students[n].view_status() + "\n");
		}
		in.close();

	}

}
