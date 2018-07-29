package Exercise21_14;

import com.deitel.datastructures.StackComposition;

public class PostfixEvaluator 
{
	public static void main (String[] args)
	{
		//postfixEvaluator(infixToPostfixConverter(new StringBuffer("6 + (4 / 2) ^ 2 * 8")));
		
		StringBuffer infix = new StringBuffer("( 60 + 20 ) * 50 - 80 / 40");
		postfixEvaluator(infixToPostfixConverter(infix));
	}
	
	public static void postfixEvaluator(StringBuffer postfix)
	{
		postfix.append(")");
		String[] postfixArray = postfix.toString().split(" ");
		
		StackComposition<Integer> expressionStack = new StackComposition<>();
		
		int e = 0; // array element
		
		while(!postfixArray[e].equals(")"))
		{
			if(!isOperator(postfixArray[e]))
			{
				expressionStack.push(Integer.parseInt(postfixArray[e]));
				e ++;
			}
			else
			{
				int x = expressionStack.pop();
				int y = expressionStack.pop();
				
				expressionStack.push(calculate (y, postfixArray[e], x));
				e ++;
				
			}
		}
		
		System.out.println(expressionStack.pop());
	}
	
	public static Integer calculate(int y, String c, int x)
	{
		switch (c)
		{
			case "+":
				return (Integer) y + x;
			
			case "-":
				return (Integer) y - x;
				
			case "*":
				return (Integer) y * x;
				
			case "/":
				return (Integer) y / x;

			case "%":
				return (Integer) y % x;
			
			case "^":
				int temp = 1;
				for (int i = 0; i < x ; i++)
					temp *= y;
				
				return (Integer) temp;
		}
		
		return (Integer) 0;
	}

	public static StringBuffer infixToPostfixConverter(StringBuffer infix)
	{
		StackComposition<String> expressionStack = new StackComposition<>();
		StringBuffer postfix = new StringBuffer();
		
		expressionStack.push("(");
		infix.append(' ');
		infix.append(')');
		
		String[] infixArray = infix.toString().split(" ");
		
		int e = 0; // array element index
		
		while (!expressionStack.isEmpty())
		{
								
			while (e < infixArray.length)
			{ 
				//System.out.println(infixArray[e]);												
				// if element is digit
				if(infixArray[e].matches("[0-9]+"))
				{
					postfix.append(infixArray[e]); // append it to postfix
					postfix.append(" ");
					e++;
					continue;
				}

				// if element is left parenthesis
				if(infixArray[e].equals("("))
				{
					expressionStack.push(infixArray[e]); // push it to stack
					// delete element
					e++;
					continue;
				}
				
				// if element is operand
				if(isOperator(infixArray[e]))
				{
					
					// look for other operand at stack top
					if(isOperator(expressionStack.peek()))
					{
						// pop operators from stack as long as they have higher or equal precedence
						while(precedence(infixArray[e],expressionStack.peek()))
						{
							postfix.append(expressionStack.pop());
							postfix.append(" ");
						}
						
						expressionStack.push(infixArray[e]);
						
					}
					
					else // if not found push current operand to stack 
						expressionStack.push(infixArray[e]);
					
					
					// delete element
					e++;
					continue;
				}
				
				// if element is right parenthesis
				if(infixArray[e].equals(")"))
				{
					while(isOperator(expressionStack.peek()))
					{
						postfix.append(expressionStack.pop());
						postfix.append(" ");
					}
					
					if(expressionStack.peek().equals("("))
						expressionStack.pop();
					
					// delete element
					e++;
					continue;
				}
				
				
			}
						
		}
		
		return postfix;
	}
	
		
	// method to check if current element is an Operator
	public static boolean isOperator(String c)
	{
		
		
		if (c.matches("\\+|-|\\*|/|\\^|%"))
			return true;
		
		return false;
	}
	
	// method to check the precedence of two operators - returns true if operator1 is of lower precedence
	public static boolean precedence (String operator1, String operator2)
	{
		if(operatorLevel(operator1) < operatorLevel(operator2))
			return true;
		
		return false;
	}
	
	public static int operatorLevel(String c)
	{
		switch(c)
		{
			case "+":
				return 1;
							
			case "-":
				return 1;
								
			case "*":
				return 2;
							
			case "/":
				return 2;
							
			case "%":
				return 2;
								
			case "^":
				return 3;
				
			default:
				return 0;
		}
		
	}
}
