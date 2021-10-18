import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.Color;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


class Divide0 extends Exception
{
    Divide0(String t)
    {
        super(t);
    }
}

public class Calculator implements ActionListener {
    JFrame f;
    JTextField tf;
    JButton button;
    String exp;

    //for operators and numbers 
    Stack<Float> numbers=new Stack<>();
    Stack<Character> operation=new Stack<>();
    
    //Constructor for window layout
    Calculator()
    {
        f=new JFrame("Calc");
        tf=new JTextField();
        tf.setBounds(10,5,190,30);
        tf.setBackground(Color.gray);
        String[] num={"1","2","3","4","5","6","7","8","9","0","C","+","-","*","/",".","(",")","=","AC"};
        int row=0,y=100,col=0;
        for(int i=0;i<20;i++)
        {
            button=new JButton(num[i]);
            button.addActionListener(this);
            if(i==19)
            {
                button.setBounds(125,50,70,40);
            }
            else if(i==18)
            {
                button.setBounds(10,50,70,40);
            }
            else{if(row==3)
            {
                row=0;
                col++;
            }
            if(row!=3)
            {
                button.setBounds(10+(65*row),y+(55*col),55,45);
                row++;
                }
            }
            button.setBackground(Color.gray);
            f.add(button);
        }
        f.add(tf);
        f.setSize(220,480);
        f.getContentPane().setBackground(Color.black);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //function for arthimetic operations
    public float performOperation() throws Divide0
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
    public boolean isOperator(char c){
        return (c=='+'||c=='-'||c=='/'||c=='*'||c=='^');
    }

    //function to check the precedence of the operator
    static int precedence(char ch)
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
    public Float evaluate() throws Divide0
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

    //overriding the actionPerformed function
    public void actionPerformed(ActionEvent e)
    {
        String s=e.getActionCommand();
        if(s.equals("0"))
        {
            tf.setText(tf.getText()+"0");
        }
        if(s.equals("1"))
        {
            tf.setText(tf.getText()+"1");
        }
        if(s.equals("2"))
        {
            tf.setText(tf.getText()+"2");
        }
        if(s.equals("3"))
        {
            tf.setText(tf.getText()+"3");
        }
        if(s.equals("4"))
        {
            tf.setText(tf.getText()+"4");
        }
        if(s.equals("5"))
        {
            tf.setText(tf.getText()+"5");
        }
        if(s.equals("6"))
        {
            tf.setText(tf.getText()+"6");
        }
        if(s.equals("7"))
        {
            tf.setText(tf.getText()+"7");
        }
        if(s.equals("8"))
        {
            tf.setText(tf.getText()+"8");
        }
        if(s.equals("9"))
        {
            tf.setText(tf.getText()+"9");
        }
        if(s.equals("("))
        {
            tf.setText(tf.getText()+"(");
        }
        if(s.equals(")"))
        {
            tf.setText(tf.getText()+")");
        }
        if(s.equals("+"))
        {
            tf.setText(tf.getText()+"+");
        }
        if(s.equals("-"))
        {
            tf.setText(tf.getText()+"-");
        }
        if(s.equals("*"))
        {
            tf.setText(tf.getText()+"*");
        }
        if(s.equals("/"))
        {
            tf.setText(tf.getText()+"/");
        }
        if(s.equals("."))
        {
            tf.setText(tf.getText()+".");
        }
        if(s.equals("C"))
        {
            String ch=tf.getText();
            int n=ch.length();
            String subString=ch.substring(0,n-1);
            tf.setText(subString);
        }
        if(s.equals("AC"))
        {
            tf.setText("");
        }
        if(s.equals("="))
        {
            exp=tf.getText();
            float ans;
            try {
                ans = evaluate();
                String ans1=String.valueOf(ans);
                tf.setText(ans1);
            } catch (Divide0 e1) {
                tf.setText("Not possible");
            }
            
        }
    }

    //Main function
    public static void main(String args[])
    {
        new Calculator();
    }
}