package cn.levana.at.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import cn.levana.at.vo.LoginFields;

/**
 * Servlet implementation class PersonServlet
 */
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<LoginFields> lfList = new ArrayList<LoginFields>();
		lfList.add(new LoginFields("Username", "true"));
		lfList.add(new LoginFields("Password", "true"));
		lfList.add(new LoginFields("Email (optional)", "false"));
        response.setContentType("text/html;charset=gb2312");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Max-Age", "60");
        PrintWriter out = response.getWriter();  
        JSONArray LoginFieldsList = JSONArray.fromObject(lfList);
        System.out.println(LoginFieldsList.toString());
        out.println(LoginFieldsList);  
        out.flush();  
        out.close();  
	}

}
