package programming2018.Algorithms;

import java.util.Scanner;
import java.util.Stack;

public class ArithmeticExpressionEvaluation {
	
	//Dijkstra’s Two-Stack Algorithm for Expression Evaluation
	
	/*
	 * This Stack client uses two stacks to evaluate arithmetic expressions,
	 * illustrating an essential computational process: interpreting a string
	 * as a program and executing that program to compute the desired result.
	 * With generic, we can use the code in a single Stack implementation to 
	 * implement one stack of programming2018.String values and another stack of Double
	 * values. For simplicity, this code assumes that the expression is fully parenthesized,
	 * with numbers and characters separated by whitespace.
	 */
	
	
	public static void main(String[] args) {

		/*
		Precisely how can we convert an arithmetic expression— a string of characters—to the value that it represents?
		A remarkably simple algorithm that was developed by E. W. Dijkstra in the 1960s uses two stacks
		(one for operands and one for operators) to do this job. An expression consists of parentheses, operators, and operands (numbers).
		Proceeding from left to right and taking these entities one at a time, we manipulate the stacks according to four possible cases, as follows:
			■ Push operands onto the operand stack.
			■ Push operators onto the operator stack.
			■ Ignore left parentheses.
			■ On encountering a right parenthesis, pop an operator, pop the requisite number
			of operands, and push onto the operand stack the result of applying that operator to those operands.
		*/
		
		Stack<String> ops = new Stack<String>();
		
		Stack<Double> vals = new  Stack<Double>();
		
		Scanner scan = new Scanner(System.in);    
		
		while (!scan.hasNext())
			
        {  // Read token, push if operator.		
			
			String s = scan.nextLine();
			
			if(s.equals("(")) ;
			
			else if(s.equals("+"))
				ops.push("+");
			
			else if(s.equals("-"))
				ops.push("-");
			
			else if(s.equals("*"))
				ops.push("*");
			
			else if(s.equals("/"))
				ops.push("/");
			
			else if(s.equalsIgnoreCase("sqrt"))
				ops.push("sqrt");
			
			else if(s.equals(")"))
			{
				Double v = vals.pop();
				String op = ops.pop();
				
				if(s.equals("+"))
					v =vals.pop() + v;
				
				else if(s.equals("-"))
					v =vals.pop() - v;
				
				else if(s.equals("*"))
					v =vals.pop() * v;
				
				else if(s.equals("/"))
					v =vals.pop() / v;
				
				else if(s.equalsIgnoreCase("sqrt"))
					v = Math.sqrt(v);
				
				vals.push(v);
			}
			
			else {
			vals.push(Double.parseDouble(s));	
			}
        }
	System.out.println("");
	}
}
