package cn.levana.at.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.HandlerChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.levana.at.vo.LoginFields;
import cn.levana.at.vo.UserVO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
                'Accept': 'application/json',
                'Content-Type': 'application/x-www-form-urlencoded',
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("username: "+ username +"   \n password: "+password);
		
		Map<String, Object> result = new HashMap<String, Object>();
		UserVO user = new UserVO(username,password);
		result.put("user", user);
		result.put("success", true);
        response.setContentType("text/html;charset=gb2312");
        response.setHeader("Access-Control-Expose-Headers", "Content-Type,Cversion,test,test1,Test2");
        
        response.setHeader("Access-Control-Request-Headers", "Content-Type,Cversion,test,test1,Test2");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET");
        response.setHeader("Access-Control-Max-Age", "60");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Cversion", "cccc");
        response.setHeader("test", "test");
        response.setHeader("test1", "test1");
        response.setHeader("Test2", "test2");
        
        PrintWriter out = response.getWriter();  
        JSONObject LoginFieldsList = JSONObject.fromObject(result);
        System.out.println(LoginFieldsList.toString());
        out.println(LoginFieldsList);  
        out.flush();  
        out.close(); 
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doOptions(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doOptions(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(arg0, arg1);
		doPost(arg0, arg1);
		System.out.println("in here options .... ");
	}

}
