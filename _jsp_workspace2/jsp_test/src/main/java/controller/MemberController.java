package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;


@WebServlet("/memb/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MemberController.class); 
    
    private RequestDispatcher rdp;
    private String destPage;
    
    private int isOk;
    
    private MemberService msv;
    
    public MemberController() {
        // TODO Auto-generated constructor stub
    	msv = new MemberServiceImpl();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("필요한 로그 띄우기");
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		
		switch (path) {
		case "join" :
			destPage = "/member/register.jsp";
			break;
		case "register" :
			try {
				log.info(">>> register check 1");
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				int age = Integer.parseInt(request.getParameter("age"));
				
				MemberVO mvo = new MemberVO(id, pwd, email, age);
				
				isOk = msv.register(mvo);
				
				log.info(">>> register >>> {} ", (isOk > 0) ? "OK" : "Fail");
				destPage = "/index.jsp";
				
			} catch (Exception e) {
				// TODO: handle exception
				log.info("register error");
			}
			break;
		case "login":
			try {
				log.info(">>> login check 1");
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				
				MemberVO mvo = new MemberVO(id, pwd);
				
				MemberVO loginStatus = msv.login(mvo);
				System.out.println(loginStatus);
				if(loginStatus != null) {
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", loginStatus);
					ses.setMaxInactiveInterval(10*10);
					request.setAttribute("msg_login", 1);
				}else {
					request.setAttribute("msg_login", -1);
				}
				destPage = "/index.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				log.info("login error");
			}
			break;
		case "logout" : 
			try {
				log.info(">>> logout check 1");
				
				HttpSession ses = request.getSession();
				MemberVO mvo = (MemberVO) ses.getAttribute("ses");
				
				isOk = msv.logout(mvo);
				
				log.info(">>> logout >>> {} ", (isOk > 0) ? "OK" : "Fail");
				
				if(isOk > 0) {
					request.setAttribute("msg_logout", 1);
				}
				ses.invalidate();
				
				destPage = "/index.jsp";
				
			} catch (Exception e) {
				// TODO: handle exception
				log.info("logout error");
			}
			break;
		case "detail" : 
			destPage = "/member/detail.jsp";
			break;
		case "modify" : 
			try {
				log.info(">>> modify check 1");
				HttpSession ses = request.getSession();
				
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				int age = Integer.parseInt(request.getParameter("age"));
				
				MemberVO mvo = new MemberVO(id, pwd, email, age);
				
				System.out.println(mvo);
				isOk = msv.modify(mvo);
				log.info(">>> modify >>> {} ", (isOk > 0) ? "OK" : "Fail");
				
				ses.invalidate();
				
				if(isOk > 0) {
					request.setAttribute("modifySuccess", isOk);					
				}
				
				destPage = "/index.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				log.info("modify error");
			}
			break;
		case "list" : 
			try {
				log.info(">>> list check 1");
				
				List<MemberVO> list = msv.getList();
				request.setAttribute("list", list);
				
				destPage = "/member/list.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				log.info("list error");
			}
			break;
		case "remove" :
			try {
				log.info(">>> remove check 1");
				
				HttpSession ses = request.getSession();
				MemberVO mvo = (MemberVO) ses.getAttribute("ses");
				
				isOk = msv.remove(mvo);
				log.info(">>> remove >>> {} ", (isOk > 0) ? "OK" : "Fail");
				
				ses.invalidate();
				
				if(isOk > 0) {
					request.setAttribute("removeSuccess", isOk);					
				}
				destPage = "/index.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				log.info("remove error");
			}
			break;
		default:
			break;
		}
		
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
	}


	private MemberVO MemberVO(String id, String pwd, String email, int age) {
		// TODO Auto-generated method stub
		return null;
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

}
