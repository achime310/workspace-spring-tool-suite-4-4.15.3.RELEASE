package com.itwill.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/upload1", method = RequestMethod.GET)
	public String upload1(Locale locale, Model model) {

		return "upload1";
	}

	@RequestMapping(value = "/upload2", method = RequestMethod.GET)
	public String upload2(Locale locale, Model model) {

		return "upload2";
	}
	
	@RequestMapping(value = "/upload_dragndrop", method = RequestMethod.GET)
	public String upload_dragndrop(Locale locale, Model model) {
		
		return "upload_dragndrop";
	}

	@RequestMapping(value = "requestupload1")
	public String requestupload1( MultipartHttpServletRequest mtfRequest) {
		
		System.out.println();
		String src = mtfRequest.getParameter("src");
		System.out.println("src value : " + src);
		MultipartFile mf = mtfRequest.getFile("file");

		String path = "C:\\2022-05-JAVA-DEVELOPER\\git-repositories\\workspace-spring-tool-suite-4-4.15.3.RELEASE\\spring_web_application_boot_template-1\\src\\main\\webapp\\img\\user_profile\\";

		String originFileName = mf.getOriginalFilename(); // 원본 파일 명
		long fileSize = mf.getSize(); // 파일 사이즈

		System.out.println("originFileName : " + originFileName);
		System.out.println("fileSize : " + fileSize);

		String safeFile = path + System.currentTimeMillis() + originFileName;

		try {
			mf.transferTo(new File(safeFile));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/upload1";
	}
	
	@RequestMapping("/requestupload1_json")
	@ResponseBody
	public Map requestupload1_json(@ModelAttribute MultipartHttpServletRequest mtfRequest) throws Exception{
		Map resultMap=new HashMap();
		
		int code=1;
		String url="upload1";
		String msg="실패";
		
		System.out.println("requestupload1_json 호출");
		
		//String src = mtfRequest.getParameter("src");
		//System.out.println("src value : " + src);
		MultipartFile mf = mtfRequest.getFile("file");
		
		String path = "C:\\2022-05-JAVA-DEVELOPER\\git-repositories\\workspace-spring-tool-suite-4-4.15.3.RELEASE\\spring_web_application_boot_template-1\\src\\main\\webapp\\img\\user_profile\\";
		
		String originFileName = mf.getOriginalFilename(); // 원본 파일 명
		long fileSize = mf.getSize(); // 파일 사이즈
		
		System.out.println("originFileName : " + originFileName);
		System.out.println("fileSize : " + fileSize);
		
		String safeFile = path + System.currentTimeMillis() + originFileName;
		
		try {
			mf.transferTo(new File(safeFile));	//파일저장
			code=2;
			msg="성공";
		} catch (IllegalStateException e) {
			e.printStackTrace();
			msg="IllegalStateException";
		} catch (IOException e) {
			e.printStackTrace();
			msg="IOException";
		}
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",mf);
		return resultMap;
	}
	
	@RequestMapping(value = "requestupload2")
	public String requestupload2(MultipartHttpServletRequest mtfRequest) {
		List<MultipartFile> fileList = mtfRequest.getFiles("file");
		String src = mtfRequest.getParameter("src");
		System.out.println("src value : " + src);

		String path = "C:/2022-05-JAVA-DEVELOPER/git-repositories/workspace-spring-tool-suite-4-4.15.3.RELEASE/spring_web_application_boot_template-1/src/main/webapp/img/user_profile/";

		for (MultipartFile mf : fileList) {
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명
			long fileSize = mf.getSize(); // 파일 사이즈

			System.out.println("originFileName : " + originFileName);
			System.out.println("fileSize : " + fileSize);

			String safeFile = path + System.currentTimeMillis() + originFileName;
			try {
				mf.transferTo(new File(safeFile));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "redirect:/";
	}
	
	/*//살패
	@ResponseBody
	@RequestMapping(value = { "upload_dragndrop_action" }, method = RequestMethod.POST, produces = "json/plain;charset=UTF-8")
	public Map upload_dragndrop_action(MultipartHttpServletRequest mtfRequest, 
			final HttpServletRequest request, 
			final HttpServletResponse response) {
		
		Map resultMap=new HashMap();
		
		int code=1;
		String url="upload1";
		String msg="실패";
		
		int res = 1;
		System.out.println("제목 > " + request.getParameter("title"));
		System.out.println("내용 > " + request.getParameter("contents"));
		if(mtfRequest != null) {
			List<MultipartFile> fileList = mtfRequest.getFiles("fileList");
			for(int i=0; i<fileList.size(); i++) {
				MultipartFile multi = fileList.get(i);
				if(multi == null) {
					res = 0;
					//return 0;
				}else if(multi.getSize() == 0) {
					res = 0;
					//return 0;
				}else {
					code=2;
					msg = "성공";
					System.out.println("파일명 : " + multi.getOriginalFilename() + " / 파일 사이즈 : " + multi.getSize());
				}
			}
		}
			
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",res);
		return resultMap;
	}
	*/
	
	
	@RequestMapping("/upload_dragndrop_action")
	@ResponseBody
	public Map upload_dragndrop_action(MultipartHttpServletRequest mtfRequest,HttpServletRequest request) throws Exception{
		Map resultMap=new HashMap();
		
		int code=1;
		String url="upload1";
		String msg="실패";
		
		System.out.println("requestupload1_json 호출");
		System.out.println("제목 > " + request.getParameter("title"));
		System.out.println("내용 > " + request.getParameter("contents"));
		
		String src = mtfRequest.getParameter("src");
		System.out.println("src value : " + src);
		MultipartFile mf = mtfRequest.getFile("file");
		
		String path = "C:\\2022-05-JAVA-DEVELOPER\\git-repositories\\workspace-spring-tool-suite-4-4.15.3.RELEASE\\spring_web_application_boot_template-1\\src\\main\\webapp\\img\\user_profile\\";
		
		String originFileName = mf.getOriginalFilename(); // 원본 파일 명
		long fileSize = mf.getSize(); // 파일 사이즈
		
		System.out.println("originFileName : " + originFileName);
		System.out.println("fileSize : " + fileSize);
		
		String safeFile = path + System.currentTimeMillis() + originFileName;
		
		try {
			mf.transferTo(new File(safeFile));	//파일저장
			code=2;
			msg="성공";
		} catch (IllegalStateException e) {
			e.printStackTrace();
			msg="IllegalStateException";
		} catch (IOException e) {
			e.printStackTrace();
			msg="IOException";
		}
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",mf);
		return resultMap;
	}

}
