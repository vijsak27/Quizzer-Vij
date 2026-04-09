//Quiz.java
import java.io.*;
import java.util.*;


public class Quiz{
	private ArrayList<String> terms = new ArrayList<String>();
	private ArrayList<String> definitions = new ArrayList<String>();
	
	public Quiz(){
		
	}
	
	public void quizzerDefinitions(){
		int score = 0;
		Scanner s2 = new Scanner(System.in);
		ArrayList<String> termsLeft = terms;
		ArrayList<String> definitionsLeft = definitions;
		//System.out.println(termsLeft.size());
		//System.out.println(definitionsLeft.size());
		
		System.out.println("Quizzer has started. Please type 'exit' to stop the quizzer\n\nPress enter to continue\n");
		while((!(s2.nextLine().toLowerCase()).equals("exit")) && termsLeft.size()>0){
			
			int rand = (int)(Math.random()*definitionsLeft.size());
			System.out.println("\n"+definitionsLeft.get(rand));
			System.out.println("Term: ");
			if((s2.nextLine().toLowerCase()).equals(termsLeft.get(rand).toLowerCase())){
				score ++;
				System.out.println("Correct, senor!\nPress enter for the next question");
			}
			else{
				System.out.println("Incorrecto mi amigo\nThe correct answer was \n\n"+termsLeft.get(rand)+"\n\nPress enter for the next question");
				
			}
			
			termsLeft.remove(rand);
			definitionsLeft.remove(rand);
			
		}
		
		System.out.println("All Terms Review\nFinal Score: "+score);
	}
	
	public void readFile(){
		String filename = "unit1terms.txt";
		File f1 = new File(filename);
		
		try(Scanner s1 = new Scanner(f1)){
			while(s1.hasNextLine()){
				String line = s1.nextLine();
				String[] splitLine = line.split("]");
				//System.out.println(splitLine.length);
				terms.add(splitLine[0]);
				definitions.add(splitLine[1]);
				
			}
		}
		
		catch(FileNotFoundException e){
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	
	public String toString(){
		String output= "Terms:\n\n";
		for(int i = 0 ; i<terms.size();i++){
			output+= terms.get(i)+"\n";
		}
		
		output+= "Definitions:\n\n";
		for(int i = 0 ; i<definitions.size();i++){
			output+= definitions.get(i)+"\n";
		}
		return output;
		
	}
}
