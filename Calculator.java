import java.awt.event.*;
import javax.swing.*;

import Calc_package.Normal_calculation;
import Calc_package.Scientific_calculation;

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

    Normal_calculation nc;
    Scientific_calculation sc;

    
    //Constructor for window layout
    Calculator()
    { 
        nc=new Normal_calculation();
        sc=new Scientific_calculation(); 
        f=new JFrame("Calc");
        tf=new JTextField();
	    icon=new ImageIcon(getClass().getClassLoader().getResource("calc.png"));
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


    //overriding the actionPerformed function
    public void actionPerformed(ActionEvent e)
    {
        String s=e.getActionCommand();
	    double a;
        if(s.equals("0"))
            tf.setText(tf.getText()+"0");
        if(s.equals("1"))
            tf.setText(tf.getText()+"1");
        if(s.equals("2"))
            tf.setText(tf.getText()+"2");
        if(s.equals("3"))
            tf.setText(tf.getText()+"3");
        if(s.equals("4"))
            tf.setText(tf.getText()+"4");
        if(s.equals("5"))
            tf.setText(tf.getText()+"5");
        if(s.equals("6"))
            tf.setText(tf.getText()+"6");
        if(s.equals("7"))
            tf.setText(tf.getText()+"7");
        if(s.equals("8"))
            tf.setText(tf.getText()+"8");
        if(s.equals("9"))
            tf.setText(tf.getText()+"9");
        if(s.equals("("))
            tf.setText(tf.getText()+"(");
        if(s.equals(")"))
            tf.setText(tf.getText()+")");
        if(s.equals("+"))
            tf.setText(tf.getText()+"+");
        if(s.equals("-"))
            tf.setText(tf.getText()+"-");
        if(s.equals("*"))
            tf.setText(tf.getText()+"*");
        if(s.equals("/"))
            tf.setText(tf.getText()+"/");
        if(s.equals("."))
            tf.setText(tf.getText()+".");
	    if(s.equals("x^n"))
	        tf.setText(tf.getText()+"^");
        if(s.equals("C"))
        {
            String ch=tf.getText();
            int n=ch.length();
            String subString=ch.substring(0,n-1);
            tf.setText(subString);
        }
        if(s.equals("AC"))
            tf.setText("");
	    if (s.equals("log")) 
	    {
	        if (tf.getText().equals("")) 
		        tf.setText("");
	        else 
	        {
		        a = sc.log(tf.getText());
		        tf.setText("");
		        tf.setText(tf.getText() + a);
	        }
	    }
        if(s.equals("ln"))
        {
            if(tf.getText().equals(""))
                tf.setText("");
            else
            {
                a=sc.ln(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
        }
        if(s.equals("e^x"))
        {
            if(tf.getText().equals(""))
                tf.setText("");
            else
            {
                a=sc.exp(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
        }
        if(s.equals("x10^X"))
        {
            if(tf.getText().equals(""))
                tf.setText("10^");
            else
            {
                tf.setText(tf.getText()+"*10^");
            }
        }
	    if (s.equals("1/x")) 
	    {
	        if (tf.getText().equals("")) 
		        tf.setText(""); 
	        else 
	        {
		        a =sc.onebyx(tf.getText());
		        tf.setText("");
		        tf.setText(tf.getText() + a);
	        }
	    }
        if(s.equals("pi"))
            tf.setText(tf.getText()+Math.PI);
	    if (s.equals("x^2")) 
	    {
		    if (tf.getText().equals("")) 
			    tf.setText("");
		    else 
			    tf.setText(tf.getText() +"^2");
	    }
        if (s.equals("x^3")) 
	    {
		    if (tf.getText().equals("")) 
			    tf.setText(""); 
		    else 
			    tf.setText(tf.getText() + "^3");
	    }
        if(s.equals("sqrt"))
        {
            if(tf.getText().equals(""))
                tf.setText("");
            else
                tf.setText(tf.getText()+"^(1/2)");
        }
	    
	    if (s.equals("<html>sin<br>sin^-1</html>")) 
	    {
		    if (tf.getText().equals("")) 
			    tf.setText("");
            else if(radian.isSelected()&&degree.isSelected())
                tf.setText("Please select any one!!"); 
            else if(radian.isSelected()&&shift.isSelected())
            {
                a=sc.asin_rad(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else if(degree.isSelected()&&shift.isSelected())
            {
                a=sc.asin_deg(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+(float)a);
            }
		    else if(radian.isSelected())
		    {
                a = sc.sin_rad(tf.getText());
                tf.setText("");
                tf.setText(tf.getText() + a);
            }
            else if(degree.isSelected())
            {
                a=sc.sin_deg(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else
                tf.setText("Select appropitate option!!");
	    }
        if (s.equals("<html>cos<br>cos^-1</html>")) 
        {
            if (tf.getText().equals("")) 
                tf.setText("");
            else if(radian.isSelected()&&degree.isSelected())
                tf.setText("Please select any one!!"); 
            else if(radian.isSelected()&&shift.isSelected())
            {
                a=sc.acos_rad(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else if(degree.isSelected()&&shift.isSelected())
            {
                a=sc.acos_deg(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+(float)a);
            }
            else if(radian.isSelected()) 
            {
                a =sc.cos_rad(tf.getText());
                tf.setText("");
                tf.setText(tf.getText() +a);
            }
            else if(degree.isSelected())
            {
                a=sc.cos_deg(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else
                tf.setText("Select appropitate option!!");
        }
        if (s.equals("<html>tan<br>tan^-1</html>")) 
        {
            if (tf.getText().equals("")) 
                tf.setText("");
            else if(radian.isSelected()&&degree.isSelected())
                tf.setText("Please select any one!!"); 
            else if(radian.isSelected()&&shift.isSelected())
            {
                a=sc.atan_rad(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else if(degree.isSelected()&&shift.isSelected())
            {
                a=sc.atan_deg(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+(float)a);
            }
            else if(radian.isSelected())
            {
                a = sc.tan_rad(tf.getText());
                tf.setText("");
                tf.setText(tf.getText() + a);
            }
            else if(degree.isSelected())
            {
                a=sc.tan_deg(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+(float)a);
            }
            else
                tf.setText("Select appropitate option!!");
        }
        if (s.equals("<html>cosec<br>cosec^-1</html>")) 
        {
            if (tf.getText().equals("")) 
                tf.setText("");
            else if(radian.isSelected()&&degree.isSelected())
                tf.setText("Please select any one!!"); 
            else if(radian.isSelected()&&shift.isSelected())
            {
                a=sc.acosec_rad(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else if(degree.isSelected()&&shift.isSelected())
            {
                a=sc.acosec_deg(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+(float)a);
            }
            else if(radian.isSelected())
            {
                a = sc.cosec_rad(tf.getText());
                tf.setText("");
                tf.setText(tf.getText() + a);
            }
            else if(degree.isSelected())
            {
                a= sc.cosec_deg(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else
                tf.setText("Select appropitate option!!");
        }
        if (s.equals("<html>sec<br>sec^-1</html>")) 
        {
            if (tf.getText().equals("")) 
                tf.setText("");
            else if(radian.isSelected()&&degree.isSelected())
                tf.setText("Please select any one!!"); 
            else if(radian.isSelected()&&shift.isSelected())
            {
                a=sc.asec_rad(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else if(degree.isSelected()&&shift.isSelected())
            {
                a=sc.asec_deg(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+(float)a);
            }
            else if(radian.isSelected())
            {
                a = sc.sec_rad(tf.getText());
                tf.setText("");
                tf.setText(tf.getText() +a);
            }
            else if(degree.isSelected())
            {
                a=sc.sec_deg(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else
                tf.setText("Select appropitate option!!");
        }
        if (s.equals("<html>cot<br>cot^-1</html>")) 
        {
            if (tf.getText().equals("")) 
                tf.setText("");
            else if(radian.isSelected()&&degree.isSelected())
                tf.setText("Please select any one!!"); 
            else if(radian.isSelected()&&shift.isSelected())
            {
                a=sc.acot_rad(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else if(degree.isSelected()&&shift.isSelected())
            {
                a=sc.acot_deg(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+(float)a);
            }
            else if(radian.isSelected()) 
            {
                a =sc.cot_rad(tf.getText());
                tf.setText("");
                tf.setText(tf.getText() + a);
            }
            else if(degree.isSelected())
            {
                a=sc.cot_deg(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
            else
                tf.setText("Select appropitate option!!");
        }
        if(s.equals("n!"))
        {
            if(tf.getText().equals(""))
                tf.setText("");
            else
            {
                a=nc.fact(tf.getText());
                tf.setText("");
                tf.setText(tf.getText()+a);
            }
        }
        if(s.equals("="))
        {
            if(tf.getText().equals(" "))
                tf.setText(" ");
            else
            {
                exp=tf.getText();
                float ans;
                try 
                {
                    ans = nc.evaluate(exp);
                    String ans1=String.valueOf(ans);
                    tf.setText(ans1);
                } 
                catch(Exception e1) 
                {
                    tf.setText("Not possible");
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