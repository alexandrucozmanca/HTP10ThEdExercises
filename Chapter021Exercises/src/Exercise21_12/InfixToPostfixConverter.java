package Exercise21_12;

import com.deitel.datastructures.StackComposition;

public class InfixToPostfixConverter 
{
	
	public static void main (String[] args)
	{
		StringBuffer infix = new StringBuffer("6 + (4 / 2) ^ 2 * 8");
		printPostfix(infixToPostfixConverter(infix));
	}

	public static StringBuffer infixToPostfixConverter(StringBuffer infix)
	{
		StackComposition<Character> expressionStack = new StackComposition<>();
		StringBuffer postfix = new StringBuffer();
		
		expressionStack.push('(');
		infix.append(')');
		
		
		while (!expressionStack.isEmpty())
		{
					
			while (infix.length() > 0)
			{ 
				//System.out.println(infix.charAt(0));
				// if character is "space"
				if(infix.charAt(0) == ' ')
				{
					// delete character
					infix.deleteCharAt(0); 
					infix.trimToSize();
					continue;
				}
				
				// if character is digit
				if(String.format("%c", infix.charAt(0)).matches("[0-9]"))
				{
					postfix.append(infix.charAt(0)); // append it to postfix
					// delete character
					infix.deleteCharAt(0);
					infix.trimToSize();
					continue;
				}

				// if character is left parenthesis
				if(infix.charAt(0) == '(')
				{
					expressionStack.push(infix.charAt(0)); // push it to stack
					// delete character
					infix.deleteCharAt(0); 
					infix.trimToSize();
					continue;
				}
				
				// if character is operand
				if(isOperator(infix.charAt(0)))
				{
					
					// look for other operand at stack top
					if(isOperator(expressionStack.peek()))
					{
						// pop operators from stack as long as they have higher or equal precedence
						
						while(precedence(infix.charAt(0),expressionStack.peek()))
						{
							postfix.append(expressionStack.pop());
						}
						
						expressionStack.push(infix.charAt(0));
						
					}
					
					else // if not found push current operand to stack 
						expressionStack.push(infix.charAt(0));
					
					
					// delete character
					infix.deleteCharAt(0); 
					infix.trimToSize();
					continue;
				}
				
				// if character is right parenthesis
				if(infix.charAt(0) == ')')
				{
					while(isOperator(expressionStack.peek()))
					{
						postfix.append(expressionStack.pop());
					}
					
					if(expressionStack.peek() == '(')
						expressionStack.pop();
					
					// delete character
					infix.deleteCharAt(0); 
					infix.trimToSize();
					continue;
				}
				
				
			}
						
		}
		
		return postfix;
	}
		
	// method to display postfix in a more readable way
	public static void printPostfix(StringBuffer postfix)
	{
		
		for (int i = postfix.length() - 1; i >= 1; i --)
			postfix.insert(i, ' ');
		System.out.println(postfix.toString());
	}
	
	// method to check if current character is an Operator
	public static boolean isOperator(char c)
	{
		
		String temp = String.format("%c", c);
		if (temp.matches("\\+|-|\\*|/|\\^|%"))
			return true;
		
		return false;
	}
	
	// method to check the precedence of two operators - returns true if operator1 is of lower precedence
	public static boolean precedence (char operator1, char operator2)
	{
		if(operatorLevel(operator1) < operatorLevel(operator2))
			return true;
		
		return false;
	}
	
	public static int operatorLevel(char c)
	{
		switch(c)
		{
			case '+':
				return 1;
							
			case '-':
				return 1;
								
			case '*':
				return 2;
							
			case '/':
				return 2;
							
			case '%':
				return 2;
								
			case '^':
				return 3;
				
			default:
				return 0;
		}
		
	}
}
