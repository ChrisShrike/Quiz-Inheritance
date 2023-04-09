package quiz1;
import java.util.*;
import java.text.*;

class Person{
	public String name;
	public String bornDate;
	public int focus;
	
	public Person(String name, String bornDate, int focus) {
		this.name = name;
		this.bornDate = bornDate;
		this.focus = focus;
	}
	
	public void Sleep(int newValue) {
		focus += focus * newValue;
	}
}

class Mahasiswa extends Person{
	public String studId;
	public int point = 0;
	
	public Mahasiswa(String name, String bornDate, String studId, int focus, int point) {
		super(name, bornDate, focus);
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
	
	public Dosen(String name, String bornDate, String codeDosen, int focus, int pointDos){
		super(name, bornDate, focus);
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
        
        switch(choice) {
        case 1:
			String test = getNew.nextLine(); //long story short, this is used so that next input can be read by the program
			//if the above input is working well, just erase it bacause mine is not working
			System.out.print("Please enter student id: ");
			String id = getNew.nextLine();
			System.out.print("Please enter current focus stat: ");
			int foc = getNew.nextInt();
			
			Person newPerson = new Person(name, date, foc);
			Mahasiswa newMahasiswa = new Mahasiswa(name, date, id, foc, 0);
			
			System.out.println("How many times have you help lecturer? (if none, enter 0): ");
			int help = getNew.nextInt();
			newMahasiswa.helpingDosen(help);
			
			System.out.println("Enter your sleep rating yesterday (0 - 100): ");
			int sle = getNew.nextInt();
			newPerson.Sleep(sle);
			
			System.out.println("Your data:");
			System.out.println("Name : " + newMahasiswa.name);
			System.out.println("Birth Date : " + newMahasiswa.bornDate);
			System.out.println("Point : " + newMahasiswa.point);
			System.out.println("Current Focus Stat : " + newPerson.focus);
			System.out.println("Student ID : " + newMahasiswa.studId);
			
			break;
		
        case 2:
        	System.out.print("Please enter lecturer id: ");
			String id2 = getNew.nextLine();
			
			Dosen dosen1 = new Dosen(name, date, id2, 100, 100);
        	
			dosen1.selfDev(1);
			dosen1.p2m(1);
			dosen1.research(1);
			dosen1.teach(1);
			dosen1.otherWorks(1);
        	
			System.out.println("Your data:");
			System.out.println("Name : " + dosen1.name);
			System.out.println("Birth Date : " + dosen1.bornDate);
			System.out.println("Point : " + dosen1.pointDos);
			System.out.println("Current Focus Stat : " + dosen1.focus);
			System.out.println("Lecturer ID : " + dosen1.codeDosen);
			
			
        default:
        	System.out.println("1) Student");
            System.out.println("2) Lecturer");
        	System.out.print("Please enter valid role (1 or 2): ");
        	choice = getNew.nextInt();
        }
        
        getNew.close();
	}
}
