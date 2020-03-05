<%@ page language="java" contentType="text/html; charset=UTF-8"

            pageEncoding="UTF-8"%>

<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>



<html>

<head>

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title>Login Ajax</title>



  <!-- jQuery -->

  <script src="http://code.jquery.com/jquery-1.12.0.js"></script>

  <script>

    $(document).ready(function() {

      $('#btnLogin').click(function() {

        var action = $('#frmLogin').attr("action");

        var form_data = {

                          user_id: $('#user_id').val(),

                          user_pw: $('#user_pw').val()

        };

        $.ajax({

                  type: "POST",

                  url: action,

                  data: form_data,

                  success: function(response) {

                    if(response.trim() == "success") {

                      sessionStorage.setItem("user_id", form_data.user_id);

                      $('#msg').html("<p style='color:green; font-weight:bold'>

                                          로그인 성공!</p>");

                    } else {

                      $('#msg').html("<p style='color:red'>아이디 또는 비밀번호가

                                          잘못되었습니다.</p>");

                    }

                  },

                  error: function() {

                    $('#msg').html("<h2>Error</h2>");

                  }

        });

      });

    });

  </script>

</head>

<body>

  <h2>Login Ajax(jQuery)</h2><hr/>

  <form id="frmLogin" name="frmLogin" action="login_ok.jsp" method="post">

    <input type="text" id="user_id" name="user_id" placeholder="아이디" /><br/>

    <input type="password" id="user_pw" name="user_pw"

                placeholder="패스워드" /><br/>

    <input type="button" id="btnLogin" value="로그인" />

  </form>

  <div id="msg"></div>

</body>

</html>
