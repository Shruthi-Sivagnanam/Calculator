package Calc_package;

import java.util.Stack;

class Divide0 extends Exception
{
    Divide0(String t)
    {
        super(t);
    }
}

public class Normal_calculation 
{
    Stack<Float> numbers=new Stack<>();
    Stack<Character> operation=new Stack<>();

    private float performOperation() throws Divide0
    {
        float a=numbers.pop();
        float b=numbers.pop();
        float c=-1;
        char op=operation.pop();
        switch(op)
        {
            case '+':
                c=a+b;
                break;
            case '-':
                c=b-a;
                break;
            case'*':
                c=a*b;
                break;
            case'/':
                if(a==0)
                throw new Divide0("Not possible");
                else
                c=b/a;
                break;
            case'^':
                double a1=a;
                double b1=b;
                double c1;
                c1=Math.pow(b1,a1);
                c=(float) c1;
            
        }
        return(c);
    }
    
    //function to check whether it is a operator
    private boolean isOperator(char c){
        return (c=='+'||c=='-'||c=='/'||c=='*'||c=='^');
    }

    //function to check the precedence of the operator
    private static int precedence(char ch)
    {
        if(ch=='+'||ch=='-')
            return(1);
        if(ch=='*'||ch=='/')
            return(2);
        if(ch=='^')
            return(3);
        return(-1);
    }

    //function to evalute the expression
    public float evaluate(String exp) throws Divide0
    {
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);
            if(Character.isDigit(c))
            {
                float num=0;
                String a=new String();
                while(Character.isDigit(c)||c=='.')
                {
                    a=a+c;
                    i++;
                    if(i < exp.length())
                        c = exp.charAt(i);
                    else
                        break;
                }
                i--;
                
                num=Float.parseFloat(a);
                numbers.push(num);
            }
            else if(c=='(')
            {
                operation.push(c);
            }
            else if(c==')')
            {
                while(operation.peek()!='(')
                {
                    float output=performOperation();
                    numbers.push(output);
                }
                operation.pop();
            }
            else if(isOperator(c))
            {
                while(!operation.isEmpty() && precedence(c)<=precedence(operation.peek()))
                {
                    float output=performOperation();
                    numbers.push(output);
                }
                operation.push(c);
            }
        }
        while(!operation.isEmpty())
        {
            float output=performOperation();
            numbers.push(output);
        }
        return(numbers.pop());
    }
    public double fact(String s)
    {
        double ans=1;
        int num=Integer.parseInt(s);
        for(int i=1;i<=num;i++)
        {
            ans*=i;
        }
        return(ans);
    }
}
