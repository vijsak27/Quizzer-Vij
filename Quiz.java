//Quiz.java
import java.io.*;
import java.util.*;


public class Quiz{
	private ArrayList<String> terms = new ArrayList<String>();
	private ArrayList<String> definitions = new ArrayList<String>();
	private ArrayList<String> questions = new ArrayList<String>();
	private ArrayList<String> answers = new ArrayList<String>();
	private ArrayList<String> correctMCQ = new ArrayList<String>();
	
	public Quiz(){
		
	}
	
	/*
	 Input form:
	 
	 (MCQ)Question]\na.answer1\nb.answer2\nc.answer3\nd.answer4]correctLetter
	 
	 EX.
	 
	 (MCQ)How many days in a week?]\na.1\nb.2\nc.3\nd.7]d
	 
	 */
	
	public void menu(){
		System.out.println("MCQ (Type 1) or Terms/Definitions(Type 2)");
		Scanner s4 = new Scanner(System.in);
		System.out.println("Type 'exit' to end quizzer");
		while(!(s4.nextLine().toLowerCase()).equals("equals")){
			if(s4.nextLine().equals("1")){
				quizzerMCQ();
			}
			else{
				quizzerDefinitions();
				
			}
		}
		
	}
	
	public void quizzerMCQ(){
		int score = 0;
		int totalQuestions = questions.size();
		Scanner s3 = new Scanner(System.in);
		ArrayList<String> questionsLeft = questions;
		ArrayList<String> answersLeft = answers;
		ArrayList<String> correctMCQLeft = correctMCQ;
		
		//System.out.println(questionsLeft.size());
		
		System.out.println("Quizzer (MCQ) has started. Please type 'exit' to stop the quizzer\n\nPress enter to continue\n");
		while((!(s3.nextLine().toLowerCase()).equals("exit")) && questionsLeft.size()>0){
			
			int rand = (int)(Math.random()*questionsLeft.size());
			System.out.println("Question: ");
			System.out.print(questionsLeft.get(rand));
			System.out.println("\nAnswer Choices: ");
			System.out.print(answers.get(rand)+"\n\n");
			String strInput = s3.nextLine();
			if(strInput.toLowerCase().equals(correctMCQLeft.get(rand).toLowerCase())){
				score ++;
				System.out.println("Correct!\nPress enter for the next question");
			}
			else if(strInput.toLowerCase().equals("exit")){
				break;
			}
			else{
				System.out.println("Incorrect\nThe correct answer was \n\n"+correctMCQ.get(rand)+"\n\nPress enter for the next question");
				
			}
			
			questionsLeft.remove(rand);
			answersLeft.remove(rand);
			correctMCQLeft.remove(rand);
		
		
		}
		System.out.println("\n\nMCQs Over\nFinal Score: "+score+"/"+totalQuestions);
	}
	
	public void quizzerDefinitions(){
		int score = 0;
		int totalTerms = terms.size();
		Scanner s2 = new Scanner(System.in);
		ArrayList<String> termsLeft = terms;
		ArrayList<String> definitionsLeft = definitions;
		//System.out.println(termsLeft.size());
		//System.out.println(definitionsLeft.size());
		
		System.out.println("Quizzer (definitions and terms) has started. Please type 'exit' to stop the quizzer\n\nPress enter to continue\n");
		while((!(s2.nextLine().toLowerCase()).equals("exit")) && termsLeft.size()>0){
			
			int rand = (int)(Math.random()*definitionsLeft.size());
			System.out.println("Definition: ");
			System.out.print(definitionsLeft.get(rand));
			System.out.println("\nTerm: ");
			String strInput = s2.nextLine();
			if(strInput.toLowerCase().equals(termsLeft.get(rand).toLowerCase())){
				score ++;
				System.out.println("Correct!\nPress enter for the next question");
			}
			else if(strInput.toLowerCase().equals("exit")){
				break;
			}
			else{
				System.out.println("Incorrect\nThe correct answer was \n\n"+termsLeft.get(rand)+"\n\nPress enter for the next question");
				
			}
			
			termsLeft.remove(rand);
			definitionsLeft.remove(rand);
			
		}
		
		System.out.println("\n\nReview Over\nFinal Score: "+score+"/"+totalTerms);
	}
	
	public void readFile(){
		String filename = "unit1terms.txt";
		File f1 = new File(filename);
		
		try(Scanner s1 = new Scanner(f1)){
			while(s1.hasNextLine()){
				String line = s1.nextLine();
				String[] splitLine = line.split("]");
				//System.out.println(splitLine.length);
				if(splitLine[0].toLowerCase().contains("mcq")){
					questions.add(splitLine[0]);
					answers.add(splitLine[1].replace(":","\n"));
					correctMCQ.add(splitLine[2]);
				}
					
				else{
					terms.add(splitLine[0]);
					definitions.add(splitLine[1]);
				}
				
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
