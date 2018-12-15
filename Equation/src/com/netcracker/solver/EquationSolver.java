package com.netcracker.solver;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class EquationSolver extends HttpServlet {
    private String stra = null;
    private String strb = null;
    private String strc = null;

    private double a = 0;
    private double b = 0;
    private double c = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/xml");
        StringBuffer jb = getString(req);
        parseString(jb);

        checkCoeffs();

        Equation equation = new Equation(this.a,this.b,this.c);
        equation.solve();


        out.write(equation.toJSONstring());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void checkCoeffs() {
        if(this.stra.isEmpty()) {
            this.a = 0;
        }
        else {
            this.a = Double.parseDouble(this.stra);
        }
        if(this.strb.isEmpty()) {
            this.b = 0;
        }
        else {
            this.b =  Double.parseDouble(this.strb);
        }
        if(this.strc.isEmpty()) {
            this.c = 0;
        }
        else {
            this.c = Double.parseDouble(this.strc);
        }
    }

    private StringBuffer getString(HttpServletRequest req) {
        StringBuffer result = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                result.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private void parseString(StringBuffer str) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(str.toString());

            JSONObject input = (JSONObject)obj;
            this.stra = input.get("a").toString();
            this.strb = input.get("b").toString();
            this.strc = input.get("c").toString();

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
