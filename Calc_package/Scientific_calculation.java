package Calc_package;

public class Scientific_calculation 
{
    private double a;
    public double log(String s)
    {
        a=Double.parseDouble(s);
        return(Math.log(a)/Math.log(10));
    }
    public double ln(String s)
    {
        a=Double.parseDouble(s);
        return(Math.log(a)/Math.log(2));
    }
    public double exp(String s)
    {
        a=Double.parseDouble(s);
        return(Math.exp(a));
    }
    public double onebyx(String s)
    {
        a=Double.parseDouble(s);
        return(1/a);
    }
    public double asin_deg(String s)
    {
        a=Double.parseDouble(s);
        return ((Math.asin(a))*(180/Math.PI));
    }
    public double asin_rad(String s)
    {
        a=Double.parseDouble(s);
        return (Math.asin(a));
    }
    public double sin_deg(String s)
    {
        a=Double.parseDouble(s);
        return (Math.sin(Math.toRadians(a)));
    }
    public double sin_rad(String s)
    {
        a=Double.parseDouble(s);
        return (Math.sin(a));
    }
    public double acos_deg(String s)
    {
        a=Double.parseDouble(s);
        return (Math.acos(a)*(180/Math.PI));
    }
    public double acos_rad(String s)
    {
        a=Double.parseDouble(s);
        return(Math.acos(a));
    }
    public double cos_deg(String s)
    {
        a=Double.parseDouble(s);
        return(Math.cos(Math.toRadians(a)));
    }
    public double cos_rad(String s)
    {
        a=Double.parseDouble(s);
        return(Math.cos(a));
    }
    public double atan_rad(String s)
    {
        a=Double.parseDouble(s);
        return(Math.atan(a));
    }
    public double atan_deg(String s)
    {
        a=Double.parseDouble(s);
        return(Math.atan(a)*(180/Math.PI));
    }
    public double tan_rad(String s)
    {
        a=Double.parseDouble(s);
        return(Math.tan(a));
    }
    public double tan_deg(String s)
    {
        a=Double.parseDouble(s);
        return(Math.tan(Math.toRadians(a)));
    }
    public double acosec_rad(String s)
    {
        a=Double.parseDouble(s);
        return(Math.asin(1/a));
    }
    public double acosec_deg(String s)
    {
        a=Double.parseDouble(s);
        return(Math.asin(1/a)*(180/Math.PI));
    }
    public double cosec_rad(String s)
    {
        a=Double.parseDouble(s);
        return(1/Math.sin(a));
    }
    public double cosec_deg(String s)
    {
        a=Double.parseDouble(s);
        return(1/Math.sin(Math.toRadians(a)));
    }
    public double asec_rad(String s)
    {
        a=Double.parseDouble(s);
        return(Math.acos(1/a));
    }
    public double asec_deg(String s)
    {
        a=Double.parseDouble(s);
        return(Math.acos(1/a)*(180/Math.PI));
    }
    public double sec_rad(String s)
    {
        a=Double.parseDouble(s);
        return(1/Math.cos(a));
    }
    public double sec_deg(String s)
    {
        a=Double.parseDouble(s);
        return(1/Math.cos(Math.toRadians(a)));
    }
    public double acot_rad(String s)
    {
        a=Double.parseDouble(s);
        return(Math.atan(1/a));
    }
    public double acot_deg(String s)
    {
        a=Double.parseDouble(s);
        return(Math.atan(1/a)*(180/Math.PI));
    }
    public double cot_rad(String s)
    {
        a=Double.parseDouble(s);
        return(1/Math.tan(a));
    }
    public double cot_deg(String s)
    {
        a=Double.parseDouble(s);
        return(1/Math.tan(Math.toRadians(a)));
    }
}