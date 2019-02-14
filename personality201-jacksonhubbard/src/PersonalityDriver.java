
public class PersonalityDriver {
	public static void main(String[] args) {
		Personality p = new Personality();
		Personality q = new Personality("Sam");
		
		System.out.println(p.getName());
		System.out.println(q.getName());
		System.out.println(p.getDescription());
		System.out.println(q.getDescription());
	}
}
