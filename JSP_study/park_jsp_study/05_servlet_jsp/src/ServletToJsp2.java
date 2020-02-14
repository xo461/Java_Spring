import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletToJsp2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();

		String user = "미니";
		Vector vec = new Vector();
		vec.add("14k 볼드 링귀걸이 라지사이즈");
		vec.add("14k 웨이브 드롭귀걸이");
		vec.add("14k 진주 귀걸이 8mm");

		req.setAttribute("user", user);
		req.setAttribute("vec", vec);

		// Map, HashMap
		String user2 = "워니";
		HashMap map = new HashMap();
		map.put("pum1", "무신사 블랙 코트");
		map.put("pum2", "티볼리 화이트");
		map.put("pum3", "아이폰11");

		// 이걸 해야 jsp에 넘어감
		req.setAttribute("user2", user2);
		req.setAttribute("map", map);

		// servlet에서 jsp로 포워딩
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/jsp/target.jsp");
		rd.forward(req, res);
	}
}