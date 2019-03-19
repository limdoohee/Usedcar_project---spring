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
	
	// 게시판 리스트 가져오기
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
			  System.out.println("★★ ajax 실행 중");
		  } else {
			  mv = new ModelAndView("lee/board_list");
			  System.out.println("★★ajax 실행 X");
		  }
		  mv.addObject("page",page);
		  mv.addObject("maxpage",maxpage);
		  mv.addObject("startpage",startpage);
		  mv.addObject("endpage",endpage);
		  mv.addObject("listcount",listcount);
		  mv.addObject("board",boardlist);
		  
		  System.out.println("총 게시글 수 : " + listcount);
		  System.out.println("boardlist.size() : " + boardlist.size());
		  
		  return mv;
	  }
	 
	  
	// 글쓰기 페이지로 이동
	@RequestMapping(value="/board_write.bo")
	public ModelAndView board_write(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("lee/board_write");
		
		return mv;
	}
	  
	
	// 글 등록
	@RequestMapping(value="/board_write_ok.bo", method= {RequestMethod.POST,RequestMethod.GET})
	public String board_write_ok(
					BoardBean board,
					@RequestParam(value="page", defaultValue="1", required=false) String page,
					@RequestParam("state") String state,
					HttpServletResponse response
			) throws Exception {
		
			System.out.println("작성자 : "+board.getBoard_name());
			System.out.println("비번 : "+board.getBoard_pass());
			System.out.println("작성자 아이디 : "+board.getDealer_id());
		System.out.println("제목 : "+board.getBoard_subject());
		System.out.println("내용 : "+board.getBoard_content());
		System.out.println("차량번호 : "+board.getCar_no());
		System.out.println("state : "+state);
		
		//답변 등록 시,
		if(state.equals("reply")) {
			//답변글 레벨 증가
			this.boardservice.refEdit(board);
			System.out.println("-- 답변글 레벨 증가");
			//딜러 아이디로 딜러 이름,비밀번호 가져오기
			DealerBean dealer = this.boardservice.getDealerCont(board.getDealer_id());
			board.setBoard_name("담당자 "+dealer.getDealer_name());
			board.setBoard_pass(dealer.getDealer_pass());
		}
		
		BoardBean b = null;
		// 게시글 수정 시,
		if(state.equals("modify") || state.equals("dlr_modify")) {
			// 게시글 수정 시, 기존 게시글 정보와 비교 및 대입 하기위해 게시글정보로 DB에서 값 가져온다.
			b = boardservice.getBoardCont(board.getBoard_num());
			
			//비밀번호가 틀리면
			if(!b.getBoard_pass().equals(board.getBoard_pass())) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호가 틀립니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
				return null;
			}
		}
		
		if(b != null) {
			System.out.println("-- DB에서 게시글 번호로 값 가져오기 성공");
		} else {
			System.out.println("-- DB에서 게시글 번호로 값 가져오기 실패");
		}
		
		MultipartFile upFile = board.getUploadfile();
		
		// 첨부한 파일이 있으면 (수정 시, 첨부파일을 변경했을 경우)
		if(!upFile.isEmpty()) {
			System.out.println("case[1]");
			//DB에 파일이 등록되어 있는 경우
			if(b.getBoard_file() != null) {
				File delFile = new File(saveFolder + board.getBoard_file());
				if(delFile.exists()) {
					delFile.delete(); //기존 파일 삭제
				}
			}
			
			//원본이름 저장
			String fileName = upFile.getOriginalFilename();
			board.setBoard_original(fileName);
			
			//DB에 저장할 파일 명 가져오기
			String fileDBName = getFileDBName(fileName);
			if(fileDBName.equals("fail")) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('첨부할 수 없는 파일입니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
				return null;
			}
			
			//파일 저장 위치
			upFile.transferTo(new File(saveFolder + fileDBName));
			
			//변경될 파일 명으로 저장
			board.setBoard_file(fileDBName);
		
		// 변경하진 않았지만 이전 파일 그대로 게시글 수정했을 경우
		} else if (board.getBoard_original() != null) {
			System.out.println("case[2]");
			board.setBoard_file(b.getBoard_file());
		// 파일 제거 후 게시글 수정할 경우 & 파일 없이 글 올릴 경우
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
	
	
	//파일 업로드
	private String getFileDBName(String fileName) throws Exception {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int date = c.get(Calendar.DATE);
		String homedir = saveFolder+"/"+year+"-"+month+"-"+date;
		File path1 = new File(homedir);
		
		if(!path1.isFile()) {
			System.out.println("파일이 존재하지 않음");
		}
		if(!(path1.exists())) {
			System.out.println("폴더 생성");
			path1.mkdir();
		}
		
		//난수 생성
		Random r = new Random();
		int random = r.nextInt(100000000);
		
		//확장자 구하기
		int index = fileName.lastIndexOf(".");
		String fileExtension = fileName.substring(index+1);
		
		//확장자 소문자로 변경
		String file_type=fileExtension.toLowerCase();
		//첨부파일이 jpg, jepg, gif, png가 아닌경우 체크
		if( !file_type.equals("jpg") && !file_type.equals("jepg") && !file_type.equals("gif") && !file_type.equals("png")) {
			System.out.println("사진이 아닙니다 ! 첨부  파일 타입은 = "+file_type);
			return "fail";
		}
		
		//새로운 파일명 생성
		String refileName = "board"+year+month+date+random+"."+fileExtension;
		
		//오라클 디비에 저장될 값
		String fileDBName = "/"+year+"-"+month+"-"+date+"/"+refileName;

		return fileDBName;
	}
	
	
	// 게시글 검색
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
	
	
	//게시글 상세보기
	@RequestMapping(value="/board_detail.bo")
	@ResponseBody
	public ModelAndView board_detail(
						@RequestParam("num") int num,
						@RequestParam( value="page", defaultValue="1", required=false) int page,
						@RequestParam("state") String state,
						HttpServletRequest request, HttpServletResponse response
			) throws Exception {
		
		
		System.out.println("게시글 상세보기");
		System.out.println("num="+num);
		System.out.println("page="+page);
		System.out.println("state="+state);
		//번호를 기준으로 DB에서 정보 가져오기
		BoardBean board = this.boardservice.getBoardCont(num);
		//가져온 게시글에 들어가있는 차량 번호로 차량 상세정보 가져오기
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
			//로그인 여부 체크
			if(session.getAttribute("id") == null) {
				out.println("<script>");
				out.println("alert('답변은 관리자만 등록 가능합니다.');");
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
	
	
	//허위매물 차량 검색  - 결과
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
		
		System.out.println("검색 결과 size : " + list.size());
		
		ModelAndView mv = new ModelAndView("lee/car_find");
		
		mv.addObject("carlist",list);
		mv.addObject("search_class",car_class);
		mv.addObject("search_model",car_model);
		mv.addObject("search_no",car_no);
		
		return mv;
	}
	
	
	
	//게시글 삭제
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
			//게시글 삭제
			boardservice.deleteBoard(num);
			File DelFile = new File(saveFolder+board.getBoard_file());
			if(DelFile.exists()) { // 이진파일 존재 시
				DelFile.delete(); // 파일 삭제
			}
			out.println("<script>");
			out.println("alert('게시글이 삭제되었습니다.');");
			if (state.equals("dlr_delete"))
				out.println("location.href='board_list.deal';");
			else
				out.println("location.href='admin_board.bo';");
			out.println("</script>");
		} else if(!board.getBoard_pass().equals(pwd)) {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
		} else {
			//게시글 삭제
			boardservice.deleteBoard(num);
			File DelFile = new File(saveFolder+board.getBoard_file());
			if(DelFile.exists()) { // 이진파일 존재 시
				DelFile.delete(); // 파일 삭제
			}
			out.println("<script>");
			out.println("alert('게시글이 삭제되었습니다.');");
			out.println("window.opener.location.href='main#lastPage';");
			out.println("window.close();");
			out.println("</script>");
		}
	}
	
	
	// 관리자- 게시판 리스트 가져오기
	@RequestMapping(value="/admin_board.bo",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Object admin_board(
			  			@RequestParam(value="page", defaultValue="1", required=false) int page,
			  			HttpServletRequest request,
			  			HttpServletResponse response
			) throws Exception {
		
		System.out.println("<-- 관리자 board_list() -->");
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
			System.out.println("★★ ajax 실행 중");
		} else {
			mv = new ModelAndView("lee/admin_board_list");
			System.out.println("★★ajax 실행 X");
		}
		mv.addObject("page",page);
		mv.addObject("maxpage",maxpage);
		mv.addObject("startpage",startpage);
		mv.addObject("endpage",endpage);
		mv.addObject("listcount",listcount);
		mv.addObject("board",boardlist);
		
		mv.addObject("type",type);
		  
		System.out.println("총 게시글 수 : " + listcount);
		System.out.println("boardlist.size() : " + boardlist.size());
		  
		return mv;
	}
}
