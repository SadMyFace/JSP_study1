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

import domain.BoardVO;
import domain.MemberVO;
import service.BoardService;
import service.BoardServiceImpl;


@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	private RequestDispatcher rdp;
	private String destPage;
	
	private int isOk;
	
	private BoardService bsv;
   
    public BoardController() {
        // TODO Auto-generated constructor stub
    	bsv = new BoardServiceImpl();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("필요한 로그 띄우기");
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();
		log.info("URI 경로 >> " + uri);
		System.out.println("sysout을 통한 로그 >> " + uri);
		
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info("path 경로 >> " + path);
		
		
		switch (path) {
		case "register":
			destPage = "/board/insert.jsp";
			break;
		case "insert":
			try {
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				
				BoardVO bvo = new BoardVO(title, writer, content);
				
				log.info(">>> insert check 1");
				
				isOk = bsv.insert(bvo);
				
				log.info(">>> insert >>> {} ", (isOk > 0) ? "OK" : "Fail");
				
				log.info(">>> isOk {}", (isOk > 0) ? "OK" : "Fail");
			} catch (Exception e) {
				// TODO: handle exception
				log.info("insert error!!");
			}
			
			destPage = "/index.jsp";
			break;
		case "list" : 
			try {
				log.info(">>> list check 1");
				List<BoardVO> list = bsv.getList();
				
				request.setAttribute("bvoList", list);
				
				destPage = "/board/list.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				log.info("insert error!!");
			}
			break;
		case "moveBoard" : 
			try {
				log.info(">>> modify check 1");
				int bno = Integer.parseInt(request.getParameter("bno"));
				System.out.println(bno);
				isOk = bsv.countUp(bno);
				
				log.info(">>> countUp >>> {} ", (isOk > 0) ? "OK" : "Fail");
				
				System.out.println(isOk);
				BoardVO bvo = bsv.findBoard(bno);	
				System.out.println(bvo);
				request.setAttribute("bvo", bvo);
				
				destPage = "/board/board.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				log.info("modify error!!");
			}
			break;
		case "edit" : 
			try {
				log.info(">>> edit check 1");
				int bno = Integer.parseInt(request.getParameter("bno"));
				BoardVO bvo = bsv.findBoard(bno);
				
				request.setAttribute("bvo", bvo);
				
				destPage = "/board/edit.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				log.info("insert error!!");
			}
			break;
		case "modify" :
			try {
				log.info(">>> modify check 1");
				int bno = Integer.parseInt(request.getParameter("bno"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				
				BoardVO bvo = new BoardVO(bno, title, content);
				
				isOk = bsv.edit(bvo);
				
				log.info(">>> edit >>> {} ", (isOk > 0) ? "OK" : "Fail");
				
				destPage = "/index.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				log.info("modify error!!");
			}
			break;
		case "remove" : 
			try {
				log.info(">>> remove check 1");
				int bno = Integer.parseInt(request.getParameter("bno"));
				
				isOk = bsv.remove(bno);
				
				log.info(">>> remove >>> {} ", (isOk > 0) ? "OK" : "Fail");
				
				destPage = "/index.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				log.info("remove error!!");
			}
			break;
		case "myBoard" :
			try {
				log.info(">>> myList check 1");
				HttpSession ses = request.getSession();
				MemberVO mvo = (MemberVO) ses.getAttribute("ses");
				String writer = mvo.getId();
				
				List<BoardVO> list = bsv.myList(writer);
				
				if(list != null) {
					request.setAttribute("list", list);
				}
				
				destPage = "/board/myBoard.jsp";
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		default:
			break;
		}
		
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
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
