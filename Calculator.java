import java.awt.event.*;
import java.util.EmptyStackException;
import java.util.Stack;
import javax.swing.*;


class Divide0 extends Exception
{
    Divide0(String t)
    {
        super(t);
    }
}


public class Calculator implements ActionListener
{
    JFrame f;
    JTextField tf;
    JButton button;
    String exp;
    JCheckBox degree,radian,shift;
    JLabel l1;
    String[] num;
    ImageIcon icon;

    //for operators and numbers 
    Stack<Float> numbers=new Stack<>();
    Stack<Character> operation=new Stack<>();
    
    //Constructor for window layout
    Calculator()
    {  
        f=new JFrame("Calc");
        tf=new JTextField();
	icon=new ImageIcon("calc.png");
	f.setIconImage(icon.getImage());
        degree = new JCheckBox("Degree");
        radian=new JCheckBox("Radian",true);
        shift=new JCheckBox("Shift");
        tf.setBounds(10,5,490,30);
        String[] num={"1","2","3","x^2","x^3","x^n","4","5","6","1/x","n!","sqrt","7","8","9","sin","cos","tan","0","C","+","cosec","sec","cot","-","*","/","log","ln","e^x",".","(",")","pi","x10^X","=","AC"};
        int row=0,y=150,col=0;
        for(int i=0;i<37;i++)
        {
            if(num[i].equals("sin"))
            {
                button=new JButton("<html>sin<br>sin^-1</html>");
            }
            else if(num[i].equals("cos"))
            {
                button=new JButton("<html>cos<br>cos^-1</html>");
            }
            else if(num[i].equals("tan"))
            {
                button=new JButton("<html>tan<br>tan^-1</html>");
            }
            else if(num[i].equals("cosec"))
            {
                button=new JButton("<html>cosec<br>cosec^-1</html>");
            }
            else if(num[i].equals("cot"))
            {
                button=new JButton("<html>cot<br>cot^-1</html>");
            }
            else if(num[i].equals("sec"))
            {
                button=new JButton("<html>sec<br>sec^-1</html>");
            }
            else
            {
                button=new JButton(num[i]);
            }
            button.addActionListener(this);
            if(i==36)
            {
                button.setBounds(260,100,245,40);
            }
            else if(i==35)
            {
                button.setBounds(10,100,245,40);
            }
            else{if(row==6)
            {
                row=0;
                col++;
            }
            if(row!=6)
            {
                button.setBounds(10+(85*row),y+(55*col),75,45);
                row++;
                }
            }

            f.add(button);
        }
        degree.setBounds(40,40,70,50);
        radian.setBounds(150,40,70,50);
        shift.setBounds(260,40,250,50);
        f.add(radian);
        f.add(degree);
        f.add(shift);
        f.add(tf);
        f.setSize(535,520);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
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
    public float evaluate() throws Divide0
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
	    double a,b;
        float an;
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
	    if(s.equals("x^n"))
	    {
	        tf.setText(tf.getText()+"^");
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
	    if (s.equals("log")) 
	    {
	        if (tf.getText().equals("")) 
	        {
		    tf.setText("");
	        } 
	        else 
	        {
		        a = Math.log(Double.parseDouble(tf.getText()))/Math.log(10);
		        tf.setText("");
		        tf.setText(tf.getText() + a);
	        }
	    }
        if(s.equals("ln"))
        {
            if(tf.getText().equals(""))
            {
                tf.setText("");
            }
            else
            {
                a=Math.log(Double.parseDouble(tf.getText()))/Math.log(2);
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
        }
        if(s.equals("e^x"))
        {
            if(tf.getText().equals(""))
            {
                tf.setText("");
            }
            else
            {
                a=Double.parseDouble(tf.getText());
                b=Math.exp(a);
                tf.setText("");
                tf.setText(tf.getText()+b);
            }
        }
        if(s.equals("x10^X"))
        {
            if(tf.getText().equals(""))
            {
                tf.setText("10^");
            }
            else
            {
                tf.setText(tf.getText()+"*10^");
            }
        }
	    if (s.equals("1/x")) 
	    {
	        if (tf.getText().equals("")) 
	        {
		        tf.setText("");
	        } 
	        else 
	        {
		        a = 1 / Double.parseDouble(tf.getText());
		        tf.setText("");
		        tf.setText(tf.getText() + a);
	        }
	    }
        if(s.equals("pi"))
        {    
            tf.setText(tf.getText()+Math.PI);
        }
	    if (s.equals("x^2")) 
	    {
		    if (tf.getText().equals("")) 
		    {
			    tf.setText("");
		    } 
		    else 
            {
			    a = Math.pow(Double.parseDouble(tf.getText()), 2);
			    tf.setText("");
			    tf.setText(tf.getText() + a);
		    }
	    }
        if(s.equals("sqrt"))
        {
            if(tf.getText().equals(""))
            {
                tf.setText("");
            }
            else
            {
                tf.setText(tf.getText()+"^(1/2)");
            }
        }
	    if (s.equals("x^3")) 
	    {
		    if (tf.getText().equals("")) 
		    {
			    tf.setText("");
		    } 
		    else 
		    {
			    a = Math.pow(Double.parseDouble(tf.getText()), 3);
			    tf.setText("");
			    tf.setText(tf.getText() + a);
		    }
	    }
	    if (s.equals("<html>sin<br>sin^-1</html>")) 
	    {
		    if (tf.getText().equals("")) 
		    {
			    tf.setText("");
		    } 
            else if(radian.isSelected()&&shift.isSelected())
            {
                a=Math.asin(Double.parseDouble(tf.getText()));
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else if(degree.isSelected()&&shift.isSelected())
            {
                a=Math.asin(Double.parseDouble(tf.getText()))*(180/Math.PI);
                tf.setText("");
                tf.setText(tf.getText()+(float)a);
            }
		    else if(radian.isSelected())
		    {
                a = Math.sin(Double.parseDouble(tf.getText()));
                tf.setText("");
                tf.setText(tf.getText() + a);
            }
            else if(degree.isSelected())
            {
                b=Math.toRadians(Double.parseDouble(tf.getText()));
                a=Math.sin(b);
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
	    }
        if (s.equals("<html>cos<br>cos^-1</html>")) 
        {
            if (tf.getText().equals("")) 
            {
                tf.setText("");
            } 
            else if(radian.isSelected()&&shift.isSelected())
            {
                a=Math.acos(Double.parseDouble(tf.getText()));
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else if(degree.isSelected()&&shift.isSelected())
            {
                a=Math.acos(Double.parseDouble(tf.getText()))*(180/Math.PI);
                tf.setText("");
                tf.setText(tf.getText()+(float)a);
            }
            else if(radian.isSelected()) 
            {
                a = Math.cos(Double.parseDouble(tf.getText()));
                tf.setText("");
                tf.setText(tf.getText() +(float) a);
            }
            else if(degree.isSelected())
            {
                b=Math.toRadians(Double.parseDouble(tf.getText()));
                a=Math.cos(b);
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
        }
        if (s.equals("<html>tan<br>tan^-1</html>")) 
        {
            if (tf.getText().equals("")) 
            {
                tf.setText("");
            } 
            else if(radian.isSelected()&&shift.isSelected())
            {
                a=Math.atan(Double.parseDouble(tf.getText()));
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else if(degree.isSelected()&&shift.isSelected())
            {
                a=Math.atan(Double.parseDouble(tf.getText()))*(180/Math.PI);
                tf.setText("");
                tf.setText(tf.getText()+(float)a);
            }
            else if(radian.isSelected())
            {
                a = Math.tan(Double.parseDouble(tf.getText()));
                tf.setText("");
                tf.setText(tf.getText() + a);
            }
            else if(degree.isSelected())
            {
                b=Math.toRadians(Double.parseDouble(tf.getText()));
                an=(float) Math.tan(b);
                tf.setText("");
                tf.setText(tf.getText()+an);
            }

        }
        if (s.equals("<html>cosec<br>cosec^-1</html>")) 
        {
            if (tf.getText().equals("")) 
            {
                tf.setText("");
            } 
            else if(radian.isSelected()&&shift.isSelected())
            {
                a=Math.asin(1/(Double.parseDouble(tf.getText())));
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else if(degree.isSelected()&&shift.isSelected())
            {
                a=Math.asin(1/(Double.parseDouble(tf.getText())))*(180/Math.PI);
                tf.setText("");
                tf.setText(tf.getText()+(float)a);
            }
            else if(radian.isSelected())
            {
                a = 1/Math.sin(Double.parseDouble(tf.getText()));
                tf.setText("");
                tf.setText(tf.getText() + a);
            }
            else if(degree.isSelected())
            {
                b=Math.toRadians(Double.parseDouble(tf.getText()));
                a=1/Math.sin(b);
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
        }
        if (s.equals("<html>cot<br>cot^-1</html>")) 
        {
            if (tf.getText().equals("")) 
            {
                tf.setText("");
            } 
            else if(radian.isSelected()&&shift.isSelected())
            {
                a=Math.atan(1/(Double.parseDouble(tf.getText())));
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else if(degree.isSelected()&&shift.isSelected())
            {
                a=Math.atan(1/(Double.parseDouble(tf.getText())))*(180/Math.PI);
                tf.setText("");
                tf.setText(tf.getText()+(float)a);
            }
            else if(radian.isSelected()) 
            {
                a = 1/Math.tan(Double.parseDouble(tf.getText()));
                tf.setText("");
                tf.setText(tf.getText() + a);
            }
            else if(degree.isSelected())
            {
                b=Math.toRadians(Double.parseDouble(tf.getText()));
                an=(float) (1/Math.tan(b));
                tf.setText("");
                tf.setText(tf.getText()+an);
            }
        }
        if (s.equals("<html>sec<br>sec^-1</html>")) 
        {
            if (tf.getText().equals("")) 
            {
                tf.setText("");
            } 
            else if(radian.isSelected()&&shift.isSelected())
            {
                a=1/(Double.parseDouble(tf.getText()));
                b=Math.acos(a);
                tf.setText("");
                tf.setText(tf.getText()+b);
            }
            else if(degree.isSelected()&&shift.isSelected())
            {
                a=Math.acos(1/(Double.parseDouble(tf.getText())))*(180/Math.PI);
                tf.setText("");
                tf.setText(tf.getText()+(float)a);
            }
            else if(radian.isSelected())
            {
                a = 1/Math.cos(Double.parseDouble(tf.getText()));
                tf.setText("");
                tf.setText(tf.getText() +a);
            }
            else if(degree.isSelected())
            {
                b=Math.toRadians(Double.parseDouble(tf.getText()));
                a=1/Math.cos(b);
                tf.setText("");
                tf.setText(tf.getText()+(float)a);
            }
        }
        if(s.equals("n!"))
        {
            if(tf.getText().equals(""))
            {
                tf.setText("");
            }
            else
            {
                int num;
                double ans=1;
                String n=tf.getText();
                num=Integer.parseInt(n);
                for(int i=1;i<=num;i++)
                {
                    ans*=i;
                }
                String ans1=String.valueOf(ans);
                tf.setText(ans1);
            }
        }
        if(s.equals("="))
        {
            if(tf.getText().equals(" "))
            {
                tf.setText(" ");
            }
            else
            {
                exp=tf.getText();
                float ans;
                try 
                {
                    ans = evaluate();
                    String ans1=String.valueOf(ans);
                    tf.setText(ans1);
                } 
                catch (Divide0 e1) 
                {
                    tf.setText("Not possible");
                }
                catch(EmptyStackException d)
                {
                    tf.setText("");
                }
            }
        }
    }
    //Main function
    public static void main(String args[])
    {
        new Calculator();
    }
}