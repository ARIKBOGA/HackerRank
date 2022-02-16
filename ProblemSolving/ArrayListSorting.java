
import java.util.*;

class Ogrenci{
	private int id;
	private String fname;
	private double cgpa;
	public Ogrenci(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

//Complete the code
public class ArrayListSorting{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Ogrenci> OgrenciList = new ArrayList<Ogrenci>();
		while(testCases>0){
            System.out.print("ID gir : ");
			int id = in.nextInt();
            System.out.print("İsim gir : ");
			String fname = in.next();
            System.out.print("Not gir : ");
			double cgpa = in.nextDouble();
			
			Ogrenci st = new Ogrenci(id, fname, cgpa);
			OgrenciList.add(st);
			
			testCases--;
		}
        in.close(); // Öğrenilmesi gereken kod alttadır.
        Collections.sort(OgrenciList,  Comparator.comparing(Ogrenci :: getCgpa).reversed().thenComparing(Ogrenci :: getFname).thenComparing(Ogrenci :: getId));
      
      	for(Ogrenci st: OgrenciList){
			System.out.println(st.getFname());
		}
	}
}



