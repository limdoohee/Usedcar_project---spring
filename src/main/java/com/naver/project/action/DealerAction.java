package com.naver.project.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.naver.project.dao.BoardService;
import com.naver.project.dao.DealerService;
import com.naver.project.model.BoardBean;
import com.naver.project.model.CarBean;
import com.naver.project.model.DealerBean;
import com.naver.project.model.StoreBean;

@Controller
public class DealerAction {

	@Autowired
	private DealerService dealerService;
	//private CarService carservice;
	@Autowired
	private BoardService boardservice;

	/* 로그인 이동 */
	@RequestMapping(value = "/login.str")
	public String login(){
		return "yang/login";
	}
		
	// 딜러 로그인 체크
	@RequestMapping(value = "/dealer_admin_login.dlr", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView dealer_admin_login(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id").trim();
		String pwd = request.getParameter("pwd").trim();
		
		DealerBean dealer = this.dealerService.dealercheck(id);
		
		if (dealer == null) {
			out.println("<script>");
			out.println("alert('등록되지 않은 회원입니다!')");
			out.println("history.back()");
			out.println("</script>");
			return null;
		} else if (!dealer.getDealer_pass().equals(pwd)) {
			out.println("<script>");
			out.println("alert('비밀번호가 맞지 않습니다.')");
			out.println("history.go(-1)");
			out.println("</script>");
			return null;
		}
		
		String dealer_name = dealer.getDealer_name();
		String dealer_id = dealer.getDealer_id();
		
		// 딜러, 관리자 마이페이지 이동
		ModelAndView dealerM = new ModelAndView("yang/dealer_admin_login");
		dealerM.addObject("dealer_name", dealer_name);
		dealerM.addObject("id", id);
		dealerM.addObject("dealer_id", dealer_id);
		session.setAttribute("dealer_name", dealer_name);
		session.setAttribute("dealer_id", id);
		dealerM.addObject("dealer_id", dealer_id);
		return dealerM;
	}
	
	/* 관리자 페이지 - 딜러 관리 */
	@RequestMapping(value = "admin_dealer.dlr")
	public ModelAndView admin_store(
			@RequestParam(value="page", defaultValue="1", required=false) int page) throws Exception{
		                                     
		List<DealerBean> dealerlist = new ArrayList<DealerBean>();
		
		int limit = 7;
		
		int listcount = dealerService.getDealerCount();
		
		int maxpage = (listcount + limit-1)/limit;
		
		int startpage = ((page-1) / 10) *10 + 1;
		
		int endpage = startpage + 10 - 1;
		
		if (endpage > maxpage) endpage = maxpage;
		
		dealerlist = dealerService.getDealerList(page);
		
		ModelAndView model = new ModelAndView("yang/admin_dealer");
		model.addObject("page", page);
		model.addObject("maxpage", maxpage);
		model.addObject("startpage", startpage);
		model.addObject("endpage", endpage);
		model.addObject("listcount", listcount);
		model.addObject("dealerlist", dealerlist);
		
		return model;
	}
	
	/* 관리자 페이지 - 딜러 등록(이동) */
	@RequestMapping(value = "admin_dealer_reg.dlr")
	public  ModelAndView admin_dealer_reg() throws Exception {
		
		List<StoreBean> store = new ArrayList<StoreBean>();	
		
		store = this.dealerService.getNameList();
		
		ModelAndView model = new ModelAndView("yang/admin_dealer_reg");
		model.addObject("store", store);
		
		return model;
	}
	
	/* 관리자 페이지 - 딜러 등록 */
	@RequestMapping(value = "admin_dealer_reg_ok.dlr")
	public String admin_dealer_reg_ok(DealerBean dealer) throws Exception{
		
		this.dealerService.insertDealer(dealer);
		
		return "redirect:/admin_dealer.dlr";
	}
	
	/* 관리자 페이지 - 딜러 관리(수정) 이동 */
	@RequestMapping(value = "admin_dealer_edit.dlr")
	public ModelAndView admin_dealer_edit(
			@RequestParam(value = "page", defaultValue = "1", required=false) int page,
			@RequestParam("id") String id) throws Exception{
		
		DealerBean dealer = this.dealerService.dealercheck(id);
		
		List<StoreBean> store = new ArrayList<StoreBean>();	
		
		store = this.dealerService.getNameList();
		
		ModelAndView editM = new ModelAndView("yang/admin_dealer_edit");
		editM.addObject("page", page);
		editM.addObject("dealer", dealer);
		editM.addObject("store", store);
		return editM;
		
	}
	
	/* 관리자 페이지 - 딜러 수정 */
	@RequestMapping(value = "admin_dealer_edit_ok.dlr")
	public String admin_dealer_edit_ok(
			DealerBean dealer,
			@RequestParam("page") int page,
			HttpServletResponse response)  throws Exception{
		
		response.setContentType("text/html;charset=utf-8");
	
		this.dealerService.editDealer(dealer);
		
		return "redirect:/admin_dealer.dlr?&page="+page;
	}
	
	/* 관리자 페이지 - 딜러 삭제 */
	@RequestMapping(value = "admin_dealer_del.dlr")
	public String admin_dealer_del(
			@RequestParam("id") String id,
			@RequestParam("page") int page,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
//		System.out.println("넘어온 id값 = " + id);
		
		if(id.equals("admin")) {
			
			out.println("<script>");
			out.println("alert('관리자는 삭제 할 수 없습니다.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		} else {
			
			this.dealerService.delDealer(id);
			
			response.sendRedirect("admin_dealer.dlr?&page="+page);
		}
		
		return null;
	}
	
	/* 딜러 페이지 _ 등록차량 관리 */
	@RequestMapping(value = "dealer_car_manage.dlr")
	public ModelAndView dealer_car_manage(@RequestParam(value="page", defaultValue="1", required=false) int page,
																							HttpServletRequest request) throws Exception{
		//초기화
		int limit=7; //한 화면에 출력할 레코드 갯수
		
		int listcount=dealerService.getListCount();//총 게시물수 받아오기
		
		//총 목록 수
		int maxpage = (listcount + limit-1) / limit;
		
		//현재 목록에 보여줄 시작 페이지 수 (1, 11, 21 등등...)
		int startpage = ((page-1) / 7) *10 + 1;
		
		//현재 목록에 보여줄 마지막 페이지 수 (10,20,30 등등...)
		int endpage = startpage +10 -1;
		
		if (endpage > maxpage) endpage= maxpage;
		
		List<CarBean> list = dealerService.dealer_car_manage(page);
		ModelAndView mv = new ModelAndView("lim/dealer_car_list");
		mv.addObject("page" , page);
		mv.addObject("maxpage", maxpage);
		mv.addObject("startpage", startpage);
		mv.addObject("endpage", endpage);
		mv.addObject("listcount", listcount);
		mv.addObject("list",list);
		return mv;
	}
	
	/* 딜러 페이지 _ 등록차량 관리(상세보기) */
	@RequestMapping(value = "dealer_car_detail.dlr")
	public ModelAndView car_detail(@RequestParam(value="page", defaultValue="1" , required=false) int page,
																			@RequestParam String car_no, HttpServletRequest request) throws Exception{
		CarBean list = dealerService.dealer_car_detail(car_no);
		ModelAndView mv  = new ModelAndView();
		mv.addObject("list",list);
		mv.addObject("page",page);
		mv.setViewName("lim/dealer_car_detail");
		return mv;
	}
	
	/* 딜러 페이지 _ 등록차량 삭제*/
	@RequestMapping(value = "dealer_car_delete.dlr")
	public String dealer_car_delete(
			@RequestParam("car_no") String car_no,
			@RequestParam("page") int page,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		this.dealerService.delete_car(car_no);
		response.sendRedirect("dealer_car_manage.dlr?page="+page);
		return null;
	}
	
	/* 로그아웃 */
	@RequestMapping(value = "logout.str")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	
	
	/* 달러페이지 _ 허위매물 게시글 관리 */
	// 게시판 리스트 가져오기
	@RequestMapping(value="/board_list.deal")
	@ResponseBody
	public Object board_list(
			  			@RequestParam(value="page", defaultValue="1", required=false) int page,
			  			HttpServletRequest request,
			  			HttpServletResponse response
			) throws Exception {

		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("dealer_id");
		  
//		System.out.println("<-- 딜러 board_list() -->");
//		System.out.println("page = " +page);
		  
		  
		List<BoardBean> boardlist = new ArrayList<BoardBean>();
		  
		  int limit=7;
		  int listcount = boardservice.getListCount_dealer(id);
		  int maxpage = (listcount+limit-1)/limit;
		  int startpage = ((page-1)/10)*10+1;
		  int endpage = startpage+10-1;
		  if(endpage>maxpage) endpage=maxpage;
		  
		  Map<String, Object> m = new HashMap<String, Object>();
		  m.put("id",id);
		  m.put("page", page);
		  boardlist = boardservice.getBoardList_dealer(m);
		  
		  ModelAndView mv = new ModelAndView();
		  
		  if (request.getParameter("state") != null) {
			  mv = new ModelAndView("lee/board_list2");
//			  System.out.println("★★ ajax 실행 중");
		  } else {
			  mv = new ModelAndView("lee/dealer_board_list");
//			  System.out.println("★★ajax 실행 X");
		  }
		  mv.addObject("page",page);
		  mv.addObject("maxpage",maxpage);
		  mv.addObject("startpage",startpage);
		  mv.addObject("endpage",endpage);
		  mv.addObject("listcount",listcount);
		  mv.addObject("board",boardlist);
		  
//		  System.out.println("총 게시글 수 : " + listcount);
//		  System.out.println("boardlist.size() : " + boardlist.size());
		  
		  return mv;
	  }

}
