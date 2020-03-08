package org.zerock.board.controller;

import javax.servlet.http.HttpServletRequest;

public class UploadPath {

	public static String attach_path = "resources/upload/";

	public static String path(HttpServletRequest request) {
		String uploadPath = "/";
		try {

			String root_path = request.getSession().getServletContext().getRealPath("/");

			uploadPath = root_path + attach_path.replace('/', '\'');

			return uploadPath;
		} catch (Exception e) {
			e.printStackTrace();

			return uploadPath;
		}
	}

}