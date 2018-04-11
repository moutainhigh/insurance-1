package com.yundian.file.service;

import javax.servlet.http.HttpServletRequest;

public interface UploadService {
	public String uploadfile(HttpServletRequest request);

	public String uploadFileForBase64(String filecontent, String fileBasePath, String newdir, String extname);
}
