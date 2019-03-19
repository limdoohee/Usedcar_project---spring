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

import com.naver.project.dao.StoreService;
import com.naver.project.model.StoreBean;

@Controller
public class StoreAction {
	
	@Autowired
	private StoreService storeService;
	
	// 전시장 리스트
	@RequestMapping(value = "/store_show.str")
	public ModelAndView store_show(
			@RequestParam(value = "page", defaultValue="1") int page,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception{
		
		List<StoreBean> storelist = new ArrayList<StoreBean>();
		
		int limit = 5;
		
		int listcount = storeService.storeListCount();
		
		int maxpage = (listcount + limit-1)/limit;
		
		int startpage = ((page-1) / 5) * 5 + 1;
		
		int endpage = startpage + 5 - 1;
		
		if (endpage > maxpage) endpage = maxpage;
		
		storelist = storeService.getStoreList(page);
		
		if (request.getParameter("state") != null) {
			
			ModelAndView mv = new ModelAndView("yang/store_show2");
			mv.addObject("page", page);
			mv.addObject("maxpage", maxpage);
			mv.addObject("startpage", startpage);
			mv.addObject("endpage", endpage);
			mv.addObject("listcount",  listcount);
			mv.addObject("storelist", storelist);
			return mv;
		}
		else {
			
			ModelAndView mv = new ModelAndView("yang/store_show");
			mv.addObject("page", page);
			mv.addObject("maxpage", maxpage);
			mv.addObject("startpage", startpage);
			mv.addObject("endpage", endpage);
			mv.addObject("listcount",  listcount);
			mv.addObject("storelist", storelist);
			return mv;
		}
		
	}
	
	//희망 지역, 전시장명 리스트
	@RequestMapping(value = "/store_search.str")
	public ModelAndView store_search(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam("searchCity") String searchCity, //희망지역 선택한 경우
			@RequestParam("search_text") String search_text, //전시장값 
			@RequestParam("searchType") int searchType //희망지역이나 전시장 선택 경우1:희망지역, 2:전시장
			) throws Exception{
		
		int limit = 5;
		
		Map m = new HashMap();
		m.put("page", page);
		
		m.put("searchType", searchType);
		
		
		
		int listcount=0;
		List<StoreBean> storelist=null;
	if(searchType==1) { //희망지역 선택한 경우
		m.put("searchCity", "%"+searchCity+"%");
		listcount = this.storeService.storeSearchCount(m);
		storelist = storeService.getStoreSearchList(m);
		
	}else { //전시장 명
		m.put("search_text", "%"+search_text+"%");
		listcount = this.storeService.storeSearchCount(m);
		storelist = storeService.getStoreSearchList(m);
	}
		
		int maxpage = (listcount + limit-1)/limit;
		
		int startpage = ((page-1) / 5) * 5 + 1;
		
		int endpage = startpage + 5 - 1;
		
		if (endpage > maxpage) endpage = maxpage;
		
		if (request.getParameter("state") != null) {
			
			ModelAndView mv = new ModelAndView("yang/store_search2");
			mv.addObject("searchCity", searchCity);
			mv.addObject("search_text", search_text);
			mv.addObject("searchType", searchType);
			mv.addObject("page", page);
			mv.addObject("maxpage", maxpage);
			mv.addObject("startpage", startpage);
			mv.addObject("endpage", endpage);
			mv.addObject("listcount",  listcount);
			mv.addObject("storelist", storelist);
			
			return mv;
		}
		else {
			ModelAndView mv = new ModelAndView("yang/store_search");
			mv.addObject("searchCity", searchCity);
			mv.addObject("search_text", search_text);
			mv.addObject("searchType", searchType);
			mv.addObject("page", page);
			mv.addObject("maxpage", maxpage);
			mv.addObject("startpage", startpage);
			mv.addObject("endpage", endpage);
			mv.addObject("listcount",  listcount);
			mv.addObject("storelist", storelist);
			
			return mv;
		}
	}
	
	/* 관리자 페이지 - 전시장 리스트 */
	@RequestMapping(value = "/admin_store.str")
	public ModelAndView admin_store(
			@RequestParam(value = "page", defaultValue="1") int page) throws Exception {
		
		List<StoreBean> storelist = new ArrayList<StoreBean>();
		
		int limit = 7;
		
		int listcount = storeService.storeListCount();
		
		int maxpage = (listcount + limit-1)/limit;
		
		int startpage = ((page-1) / 10) * 10 + 1;
		
		int endpage = startpage + 10 - 1;
		
		if (endpage > maxpage) endpage = maxpage;
		
		storelist = storeService.adminStoreList(page);
		
		ModelAndView mv = new ModelAndView("yang/admin_store");
		mv.addObject("page", page);
		mv.addObject("maxpage", maxpage);
		mv.addObject("startpage", startpage);
		mv.addObject("endpage", endpage);
		mv.addObject("listcount",  listcount);
		mv.addObject("storelist", storelist);
		
		return mv;
	}
	
	/* 관리자 페이지 - 전시장 등록(이동) */	
	@RequestMapping(value = "/admin_store_reg.str")
	public String admin_store_reg() {
		
		return "yang/admin_store_reg";
	}
	
	/* 관리자 페이지 - 전시장 등록 */
	@RequestMapping(value = "/admin_store_reg_ok.str", method = RequestMethod.POST)
	public String admin_store_reg_ok(StoreBean store,
			HttpServletResponse response
			) throws Exception{
			
			this.storeService.insertStore(store);
			
			response.sendRedirect("admin_store.str");
			
		return null;
	}
	
	/* 관리자 페이지 - 전시장 수정(이동) */
	@RequestMapping(value = "/admin_store_edit.str")
	public ModelAndView admin_store_edit(
			@RequestParam(value ="page", defaultValue = "1", required=false) int page,
			@RequestParam("num") int num) throws Exception{
		
		StoreBean store = this.storeService.storecheck(num);
		
		ModelAndView editM = new ModelAndView("yang/admin_store_edit");
		editM.addObject("page", page);
		editM.addObject("store", store);
		
		return editM;
	}
	
	/* 관리자 페이지 - 전시장 수정 */
	@RequestMapping(value = "/admin_store_edit_ok.str")
	public String admin_store_edit_ok(
			StoreBean store,
			@RequestParam("page") int page,
			HttpServletResponse response) throws Exception{
		
		response.setContentType("text/html;charset=utf-8");
		
		this.storeService.editStore(store);
		
		return "redirect:/admin_store.str?&page="+page;
	}
	
	/* 관리자 페이지 - 전시장 삭제 */
	@RequestMapping(value = "/admin_store_del.str")
	public String admin_store_del(
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam("num") int num,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if (num == 0) {
			
			out.println("<script>");
			out.println("alert('관리자는 삭제 할 수 없습니다.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		} else {
			this.storeService.delStore(num);
			
			response.sendRedirect("admin_store.str?&page="+page);
		}
		
		return null;
	}
}
