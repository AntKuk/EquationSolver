package com.netcracker.solver;

public class Equation {
    private double a;
    private double b;
    private double c;
    private double x1 = Double.NaN;
    private double x2 = Double.NaN;

    public Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void solve() {
        double d = Math.pow(b,2) - 4.0*a*c;
        if(a!=0) {
            if(d > 0) {
                x1 = (-b + Math.sqrt(d))/(2.0*a);
                x2 = (-b - Math.sqrt(d))/(2.0*a);
            }
            else if(d == 0) {
                x1 = -b/(2.0*a);
            }
        }
        else {
            if(b!=0) {
                x1 = -c/b;
            }
        }
    }

    public String toJSONstring() {
        String result = "{\"a\":" + a + ","
                        + "\"b\":" + b + ","
                        + "\"c\":" + c + ","
                        + "\"x1\":\"" + x1 + "\","
                        + "\"x2\":\"" + x2 + "\"}";
        return result;
    }
}
