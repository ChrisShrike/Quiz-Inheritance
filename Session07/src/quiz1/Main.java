package quiz1;
import java.util.*;
import java.text.*;

class Person{
	public String name;
	public String bornDate;
	public int focus;
	
	public Person(String name, String bornDate) {
		this.name = name;
		this.bornDate = bornDate;
		this.focus = focus;
	}
	
	public void Sleep(int increment) {
		focus += increment;	
		System.out.println("focus stats: " + focus + "\n");
	}
}

class Mahasiswa extends Person{
	public String studId;
	public int point;
	
	public Mahasiswa(String name, String bornDate, String studId, int point) {
		super(name, bornDate);
		this.studId = studId;
		this.point = point;
	}
	
	public void helpingDosen(int newValue) {
		point += 10 * newValue;
	}
	
	@Override
	public String toString() {
		return(super.toString() + "\nStudent point: " + point);
	}
}

class Dosen extends Person{
	public String codeDosen;
	public int pointDos = 100;
	
	public Dosen(String name, String bornDate, String codeDosen, int pointDos){
		super(name, bornDate);
		this.codeDosen = codeDosen;
		this.pointDos = pointDos;
	}
	
	public void selfDev(int newValue) {
		pointDos -= 1 * newValue;
	}
	public void teach(int newValue) {
		pointDos -= 2 * newValue;
	}
	public void p2m(int newValue) {
		pointDos -= 4 * newValue;
	}
	public void research(int newValue) {
		pointDos -= 8 * newValue;
	}
	public void otherWorks(int newValue) {
		pointDos -= 16 * newValue;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner getNew = new Scanner(System.in);
		
		System.out.print("Enter name: ");
		String name = getNew.nextLine();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        
        System.out.print("Enter a date (dd/MM/yyyy): ");
        String date = getNew.nextLine();
        while(true) {
        	try {
        		Date dateVal = dateFormat.parse(date);
                break;
            }catch(Exception e) {
                System.out.print("Please enter a valid date of birth (dd/MM/yyyy): ");
                date = getNew.nextLine();
            }
        }
		
        System.out.println("1) Student");
        System.out.println("2) Lecturer");
        System.out.print("Enter role (1 or 2): ");
        int choice = getNew.nextInt();
        
        while(choice != 1 && choice != 2) {
        	System.out.println("1) Student");
            System.out.println("2) Lecturer");
        	System.out.print("Please enter valid role (1 or 2): ");
        	choice = getNew.nextInt();
        }
        
        if(choice == 1) {
			System.out.println("Please enter student id: ");
			String id = getNew.nextLine();
			
			System.out.println("Please enter current focus stat: ");
			int foc = getNew.nextInt();
			
			Mahasiswa newMahasiswa = new Mahasiswa(name, date, id, foc);
			
			System.out.println("How many times have you help lecturer? (if none, enter 0): ");
			int help = getNew.nextInt();
			
			System.out.println("Your data:");
			System.out.println("Name : " + newMahasiswa.name);
			System.out.println("Birth Date : " + newMahasiswa.bornDate);
			System.out.println("Point : " + newMahasiswa.point);
			System.out.println("Current Focus Stat : " + newMahasiswa.focus);
			System.out.println("Student ID : " + newMahasiswa.studId);
			newMahasiswa.helpingDosen(help);
			
        }else if(choice == 2){
        	System.out.println("Please enter lecturer id: ");
        	String id = getNew.nextLine();
        	
        	System.out.println("Please enter current focus stat: ");
        	int foc = getNew.nextInt();
			Dosen newDosen = new Dosen(name, date, id, foc);
			
			int choice2 = getNew.nextInt();
		    
			System.out.println("Your data:");
			System.out.println("Name : "+newDosen.name);
			System.out.println("Birth Date : "+newDosen.bornDate);
			System.out.println("Point : "+newDosen.pointDos);
			System.out.println("Dosen ID : "+newDosen.codeDosen);
			newDosen.selfDev(1);
			newDosen.p2m(1);
			newDosen.research(1);
			newDosen.teach(1);
			newDosen.otherWorks(1);
        }
	}
}
