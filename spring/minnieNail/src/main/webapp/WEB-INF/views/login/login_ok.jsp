<%@ page language="java" contentType="text/html; charset=UTF-8"

            pageEncoding="UTF-8"%>

<%

  String user_id = request.getParameter("user_id");

  String user_pw = request.getParameter("user_pw");

  if(user_id.equals("test") && user_pw.equals("123")) {

    out.print("success");

  }

%>
