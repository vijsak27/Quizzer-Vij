//Main.java

public class Main{
	public static void main(String[] args){
		Quiz q1 = new Quiz();
		q1.readFile();
		//System.out.println(q1);
		//q1.menu();
		q1.quizzerMCQ();
		q1.quizzerDefinitions();
	}
}
