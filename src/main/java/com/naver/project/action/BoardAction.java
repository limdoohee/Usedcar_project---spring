package com.naver.project.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.naver.project.dao.BoardService;
import com.naver.project.model.BoardBean;
import com.naver.project.model.CarBean;
import com.naver.project.model.DealerBean;

@Controller
public class BoardAction {

	
	@Autowired
	private BoardService boardservice;
	
	private String saveFolder = "C:\\Users\\user1\\Documents\\workspace-sts-3.9.7.RELEASE\\Sping_FinalProject\\src\\main\\webapp\\resources\\upload";
	
	// �Խ��� ����Ʈ ��������
	@RequestMapping(value="/board_list.bo")
	@ResponseBody
	public Object board_list(
			  			@RequestParam(value="page", defaultValue="1", required=false) int page,
			  			HttpServletRequest request,
			  			HttpServletResponse response
			) throws Exception {
		  
		System.out.println("<-- board_list() -->");
		System.out.println("page = " +page);
		  
		  
		List<BoardBean> boardlist = new ArrayList<BoardBean>();
		  
		  int limit=6;
		  int listcount = boardservice.getListCount();
		  int maxpage = (listcount+limit-1)/limit;
		  int startpage = ((page-1)/6)*6+1;
		  int endpage = startpage+6-1;
		  if(endpage>maxpage) endpage=maxpage;
		  
		  boardlist = boardservice.getBoardList(page);
		  
		  ModelAndView mv = new ModelAndView();
		  
		  
		  if (request.getParameter("state") != null) {
			  mv = new ModelAndView("lee/board_list2");
			  System.out.println("�ڡ� ajax ���� ��");
		  } else {
			  mv = new ModelAndView("lee/board_list");
			  System.out.println("�ڡ�ajax ���� X");
		  }
		  mv.addObject("page",page);
		  mv.addObject("maxpage",maxpage);
		  mv.addObject("startpage",startpage);
		  mv.addObject("endpage",endpage);
		  mv.addObject("listcount",listcount);
		  mv.addObject("board",boardlist);
		  
		  System.out.println("�� �Խñ� �� : " + listcount);
		  System.out.println("boardlist.size() : " + boardlist.size());
		  
		  return mv;
	  }
	 
	  
	// �۾��� �������� �̵�
	@RequestMapping(value="/board_write.bo")
	public ModelAndView board_write(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("lee/board_write");
		
		return mv;
	}
	  
	
	// �� ���
	@RequestMapping(value="/board_write_ok.bo", method= {RequestMethod.POST,RequestMethod.GET})
	public String board_write_ok(
					BoardBean board,
					@RequestParam(value="page", defaultValue="1", required=false) String page,
					@RequestParam("state") String state,
					HttpServletResponse response
			) throws Exception {
		
			System.out.println("�ۼ��� : "+board.getBoard_name());
			System.out.println("��� : "+board.getBoard_pass());
			System.out.println("�ۼ��� ���̵� : "+board.getDealer_id());
		System.out.println("���� : "+board.getBoard_subject());
		System.out.println("���� : "+board.getBoard_content());
		System.out.println("������ȣ : "+board.getCar_no());
		System.out.println("state : "+state);
		
		//�亯 ��� ��,
		if(state.equals("reply")) {
			//�亯�� ���� ����
			this.boardservice.refEdit(board);
			System.out.println("-- �亯�� ���� ����");
			//���� ���̵�� ���� �̸�,��й�ȣ ��������
			DealerBean dealer = this.boardservice.getDealerCont(board.getDealer_id());
			board.setBoard_name("����� "+dealer.getDealer_name());
			board.setBoard_pass(dealer.getDealer_pass());
		}
		
		BoardBean b = null;
		// �Խñ� ���� ��,
		if(state.equals("modify") || state.equals("dlr_modify")) {
			// �Խñ� ���� ��, ���� �Խñ� ������ �� �� ���� �ϱ����� �Խñ������� DB���� �� �����´�.
			b = boardservice.getBoardCont(board.getBoard_num());
			
			//��й�ȣ�� Ʋ����
			if(!b.getBoard_pass().equals(board.getBoard_pass())) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('��й�ȣ�� Ʋ���ϴ�.');");
				out.println("history.go(-1);");
				out.println("</script>");
				return null;
			}
		}
		
		if(b != null) {
			System.out.println("-- DB���� �Խñ� ��ȣ�� �� �������� ����");
		} else {
			System.out.println("-- DB���� �Խñ� ��ȣ�� �� �������� ����");
		}
		
		MultipartFile upFile = board.getUploadfile();
		
		// ÷���� ������ ������ (���� ��, ÷�������� �������� ���)
		if(!upFile.isEmpty()) {
			System.out.println("case[1]");
			//DB�� ������ ��ϵǾ� �ִ� ���
			if(b.getBoard_file() != null) {
				File delFile = new File(saveFolder + board.getBoard_file());
				if(delFile.exists()) {
					delFile.delete(); //���� ���� ����
				}
			}
			
			//�����̸� ����
			String fileName = upFile.getOriginalFilename();
			board.setBoard_original(fileName);
			
			//DB�� ������ ���� �� ��������
			String fileDBName = getFileDBName(fileName);
			if(fileDBName.equals("fail")) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('÷���� �� ���� �����Դϴ�.');");
				out.println("history.go(-1);");
				out.println("</script>");
				return null;
			}
			
			//���� ���� ��ġ
			upFile.transferTo(new File(saveFolder + fileDBName));
			
			//����� ���� ������ ����
			board.setBoard_file(fileDBName);
		
		// �������� �ʾ����� ���� ���� �״�� �Խñ� �������� ���
		} else if (board.getBoard_original() != null) {
			System.out.println("case[2]");
			board.setBoard_file(b.getBoard_file());
		// ���� ���� �� �Խñ� ������ ��� & ���� ���� �� �ø� ���
		} else if (board.getBoard_original() == null) {
			System.out.println("case[3]");
			if(b != null) {
				File delFile = new File(saveFolder + b.getBoard_file());
				if(delFile.exists()) {
					delFile.delete();
				}
			}
		} else {
			System.out.println("case[4]");
		}
		
		if(state.equals("reply")) {
			this.boardservice.BoardReplyOk(board);
		} else if (state.equals("modify") || state.equals("dlr_modify")) {
			this.boardservice.editBoard(board);
		} else {
			this.boardservice.insertBoard(board);
		}
		
		if(state.equals("dlr_modify"))
			return "redirect:board_list.deal?page="+page;
		else if(state.equals("reply"))
			return "redirect:board_list.deal?page="+page;
		else
			return "redirect:main#lastPage";
	}
	
	
	//���� ���ε�
	private String getFileDBName(String fileName) throws Exception {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int date = c.get(Calendar.DATE);
		String homedir = saveFolder+"/"+year+"-"+month+"-"+date;
		File path1 = new File(homedir);
		
		if(!path1.isFile()) {
			System.out.println("������ �������� ����");
		}
		if(!(path1.exists())) {
			System.out.println("���� ����");
			path1.mkdir();
		}
		
		//���� ����
		Random r = new Random();
		int random = r.nextInt(100000000);
		
		//Ȯ���� ���ϱ�
		int index = fileName.lastIndexOf(".");
		String fileExtension = fileName.substring(index+1);
		
		//Ȯ���� �ҹ��ڷ� ����
		String file_type=fileExtension.toLowerCase();
		//÷�������� jpg, jepg, gif, png�� �ƴѰ�� üũ
		if( !file_type.equals("jpg") && !file_type.equals("jepg") && !file_type.equals("gif") && !file_type.equals("png")) {
			System.out.println("������ �ƴմϴ� ! ÷��  ���� Ÿ���� = "+file_type);
			return "fail";
		}
		
		//���ο� ���ϸ� ����
		String refileName = "board"+year+month+date+random+"."+fileExtension;
		
		//����Ŭ ��� ����� ��
		String fileDBName = "/"+year+"-"+month+"-"+date+"/"+refileName;

		return fileDBName;
	}
	
	
	// �Խñ� �˻�
	@RequestMapping(value="/board_search.bo", method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView board_search(
					@RequestParam(value="page", defaultValue="1") int page,
					@RequestParam("search_option") String search_option,
					@RequestParam("search_keyword") String search_keyword
			) throws Exception {
		System.out.println("<-- board_search() -->");
		
		System.out.println("page = "+page);
		System.out.println("search_option = "+search_option);
		System.out.println("search_keyword = "+search_keyword);
		
		int limit = 6;
		
		Map m = new HashMap();
		m.put("page", page);
		m.put("search_option",search_option);
		m.put("search_keyword","%"+search_keyword+"%");
		
		int listcount = this.boardservice.getListCount2(m);
		
		int maxpage = (listcount+limit-1)/limit;
		int startpage = ((page-1)/6) * 6 +1;
		int endpage = startpage + 6 - 1;
		if(endpage > maxpage) endpage=maxpage;
		
		List<BoardBean> boardlist = boardservice.getBoardList2(m);
		
		System.out.println("listcount = "+listcount);
		System.out.println("boardlist.size() = "+boardlist.size());
		
		
		ModelAndView mv = new ModelAndView("lee/board_search");
		
		mv.addObject("search_option",search_option);
		mv.addObject("search_keyword",search_keyword);
		mv.addObject("page",page);
		mv.addObject("maxpage",maxpage);
		mv.addObject("startpage",startpage);
		mv.addObject("endpage",endpage);
		mv.addObject("listcount",listcount);
		mv.addObject("board",boardlist);
		
		return mv;
	}
	
	
	//�Խñ� �󼼺���
	@RequestMapping(value="/board_detail.bo")
	@ResponseBody
	public ModelAndView board_detail(
						@RequestParam("num") int num,
						@RequestParam( value="page", defaultValue="1", required=false) int page,
						@RequestParam("state") String state,
						HttpServletRequest request, HttpServletResponse response
			) throws Exception {
		
		
		System.out.println("�Խñ� �󼼺���");
		System.out.println("num="+num);
		System.out.println("page="+page);
		System.out.println("state="+state);
		//��ȣ�� �������� DB���� ���� ��������
		BoardBean board = this.boardservice.getBoardCont(num);
		//������ �Խñۿ� ���ִ� ���� ��ȣ�� ���� ������ ��������
		CarBean car = this.boardservice.getCarCont(board.getCar_no());
		
		
		ModelAndView mv = new ModelAndView();
		

		if(state.equals("cont")|| state.equals("dlr_cont") || state.equals("admin_cont")) {
			
			if(state.equals("cont")) {
				this.boardservice.BoardHit(num);
				mv.setViewName("lee/board_detail");
			} else if (state.equals("admin_cont")) {
				mv.setViewName("lee/admin_board_detail");
			} else {
				this.boardservice.BoardHit(num);
				mv.setViewName("lee/dealer_board_detail");
			}
			
			String board_cont = board.getBoard_content().replace("\n","<br>");
			mv.addObject("board_cont",board_cont);
			
			List<BoardBean> boardlist = new ArrayList<BoardBean>();
			boardlist = boardservice.getReplyList(board.getBoard_re_ref());
			System.out.println("boardlist.size() = "+boardlist.size());
			mv.addObject("relist",boardlist);
		} else if(state.equals("modify")) {
			mv.setViewName("lee/board_modify");
		} else if(state.equals("dlr_modify")) {
			mv.setViewName("lee/dealer_board_modify");
		} else if(state.equals("del") || state.equals("dlr_delete")) {
			mv.addObject("state",state);
			mv.setViewName("lee/board_delete");
		} else if(state.equals("reply")) {
			HttpSession session = request.getSession();
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			//�α��� ���� üũ
			if(session.getAttribute("id") == null) {
				out.println("<script>");
				out.println("alert('�亯�� �����ڸ� ��� �����մϴ�.');");
				out.println("history.go(-1);");
				out.println("</script>");
				mv.setViewName("main");
				return mv;
			}
			mv.setViewName("lee/dealer_board_reply");
		}
		
		mv.addObject("board",board);
		mv.addObject("page",page);
		mv.addObject("car",car);
		
		return mv;
	}
	
	
	//�����Ź� ���� �˻�  - ���
	@RequestMapping(value="/car_find_result.bo")
	public ModelAndView car_find_result(
					@RequestParam("car_class") String car_class,
					@RequestParam("car_model") String car_model,
					@RequestParam("car_no") String car_no
			) throws Exception {
		List<CarBean> list = new ArrayList<CarBean>();
		
		Map m = new HashMap();
		m.put("car_class", car_class);
		m.put("car_model",car_model);
		m.put("car_no","%"+car_no+"%");
		
		list = boardservice.getCarSearchResult(m);
		
		System.out.println("�˻� ��� size : " + list.size());
		
		ModelAndView mv = new ModelAndView("lee/car_find");
		
		mv.addObject("carlist",list);
		mv.addObject("search_class",car_class);
		mv.addObject("search_model",car_model);
		mv.addObject("search_no",car_no);
		
		return mv;
	}
	
	
	
	//�Խñ� ����
	@RequestMapping(value="/board_delete_ok.bo")
	public void board_delete_ok(
						@RequestParam("page") String page,
						@RequestParam("pwd") String pwd,
						@RequestParam("num") int num,
						@RequestParam("state") String state,
						HttpServletRequest request, HttpServletResponse response
			)
	throws Exception {
		
		System.out.println("page = "+ page);
		System.out.println("pwd = "+ pwd);
		System.out.println("num = "+ num);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		BoardBean board = boardservice.getBoardCont(num);
		
		if(pwd.equals("admin")) {
			//�Խñ� ����
			boardservice.deleteBoard(num);
			File DelFile = new File(saveFolder+board.getBoard_file());
			if(DelFile.exists()) { // �������� ���� ��
				DelFile.delete(); // ���� ����
			}
			out.println("<script>");
			out.println("alert('�Խñ��� �����Ǿ����ϴ�.');");
			if (state.equals("dlr_delete"))
				out.println("location.href='board_list.deal';");
			else
				out.println("location.href='admin_board.bo';");
			out.println("</script>");
		} else if(!board.getBoard_pass().equals(pwd)) {
			out.println("<script>");
			out.println("alert('��й�ȣ�� Ʋ���ϴ�.');");
			out.println("history.go(-1);");
			out.println("</script>");
		} else {
			//�Խñ� ����
			boardservice.deleteBoard(num);
			File DelFile = new File(saveFolder+board.getBoard_file());
			if(DelFile.exists()) { // �������� ���� ��
				DelFile.delete(); // ���� ����
			}
			out.println("<script>");
			out.println("alert('�Խñ��� �����Ǿ����ϴ�.');");
			out.println("window.opener.location.href='main#lastPage';");
			out.println("window.close();");
			out.println("</script>");
		}
	}
	
	
	// ������- �Խ��� ����Ʈ ��������
	@RequestMapping(value="/admin_board.bo",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Object admin_board(
			  			@RequestParam(value="page", defaultValue="1", required=false) int page,
			  			HttpServletRequest request,
			  			HttpServletResponse response
			) throws Exception {
		
		System.out.println("<-- ������ board_list() -->");
		String type=request.getParameter("type");
		List<BoardBean> boardlist = new ArrayList<BoardBean>();
		  
		int limit=7;
		int listcount = boardservice.getListCount();
		int maxpage = (listcount+limit-1)/limit;
		int startpage = ((page-1)/10)*10+1;
		int endpage = startpage+10-1;
		if(endpage>maxpage) endpage=maxpage;
		
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("type",type);
		m.put("page",page);
		
		System.out.println("type = "+ type);
		if(type!=null)
		 System.out.println(type.equals("q"));
		
		
		boardlist = boardservice.getBoardList_admin(m);
		  
		ModelAndView mv = new ModelAndView();
		if (request.getParameter("state") != null) {
			mv = new ModelAndView("lee/admin_board_list_ajax");
			System.out.println("�ڡ� ajax ���� ��");
		} else {
			mv = new ModelAndView("lee/admin_board_list");
			System.out.println("�ڡ�ajax ���� X");
		}
		mv.addObject("page",page);
		mv.addObject("maxpage",maxpage);
		mv.addObject("startpage",startpage);
		mv.addObject("endpage",endpage);
		mv.addObject("listcount",listcount);
		mv.addObject("board",boardlist);
		
		mv.addObject("type",type);
		  
		System.out.println("�� �Խñ� �� : " + listcount);
		System.out.println("boardlist.size() : " + boardlist.size());
		  
		return mv;
	}
}
