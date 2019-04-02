package com.naver.project.action;

import java.util.*;
import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.naver.project.dao.CarService;
import com.naver.project.model.CarBean;
import com.naver.project.model.Car_tempBean;
import com.naver.project.model.DealerBean;

@Controller
public class CarAction {
	
	@Autowired
	private CarService carservice;
	
	//이미지 저장 파일경로
		private String saveFolder ="C:\\Users\\user1\\git\\repository\\Sping_FinalProject\\src\\main\\webapp\\resources\\upload\\car";

	
		
	// 두희
	// 메인 - 차량 검색 페이지
	@RequestMapping(value="/search")
	public ModelAndView search() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("lim/search");
		return mv;
	}
	
	// 차량 조건검색 리스트 페이지
	@RequestMapping(value="/search.list", method=RequestMethod.POST)
	public ModelAndView search_car_list(CarBean bean) throws Exception{
		List<CarBean> list = carservice.searchCarList(bean);
		int size = list.size();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.addObject("listsize",size);
		mv.setViewName("lim/search_list");
		return mv;
	}
		
	// 차량 전체검색 리스트 페이지
	@RequestMapping(value="/search.alllist")
	public ModelAndView search_alllist() throws Exception{
		List<CarBean> list = carservice.search_alllist();
		int size = list.size();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.addObject("listsize",size);
		mv.setViewName("lim/search_list");
		return mv;
	}
	
	// 차량 상세보기 페이지
	@RequestMapping(value="/SearchCarDetail.list")
	public ModelAndView searchcar_detail(@RequestParam String car_no, HttpServletRequest request) throws Exception {
		// 차정보 뽑아오기
		CarBean list = this.carservice.search_detail(car_no);
		
		String dealer_id = list.getDealer_id();
		// 딜러정보 뽑아오기
		DealerBean dealer = carservice.dealer_info(dealer_id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.addObject("dealer",dealer);
		mv.setViewName("lim/search_detail_list");
		return mv;
	}
	
	@RequestMapping(value="/test")
	public ModelAndView test() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("lim/test");
		return mv;
	}
	
	@RequestMapping(value="/select.test")
	public String select_test(HttpServletRequest request) {
		String engine  = request.getParameter("img_category");
		String accident  = request.getParameter("img_category");
//		System.out.println(engine);
//		System.out.println(accident);
		return null;
	}
	//두희
	
	//지은
	// 실구매가격계산기 - 차량 리스트 가져오기
		@RequestMapping(value="/car_list.cal")
		@ResponseBody
		public Object car_list(
						@RequestParam("car_class") String car_class,
						HttpServletRequest request,
						HttpServletResponse response
				) throws Exception {
//			System.out.println("car_class 는  "+ car_class);
			List<CarBean> clist = new ArrayList<CarBean>();
			
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("car_class", car_class);
			clist = carservice.getCarList(m);
			
//			System.out.println("car list size : "+clist.size());
			
			return clist;
		}
		
		
		//허위매물 차량 검색 - class 리스트 뽑아오기
			@RequestMapping(value="/car_find_class.bo")
			@ResponseBody
			public Object car_find_class() throws Exception {
				List<CarBean> list = new ArrayList<CarBean>();
				list = carservice.getCarClassAll();
//				System.out.println("차량 class size : " + list.size());
				return list;
		}
			
		//허위매물 차량 검색 - class에 해당하는 model 리스트 뽑아오기
		@RequestMapping(value="car_find_model.bo")
		@ResponseBody
		public Object car_find_model(
						@RequestParam("car_class") String car_class
				) throws Exception {
			List<CarBean> list = new ArrayList<CarBean>();
			list = carservice.getCarModelAll(car_class);
//			System.out.println("넘겨받은 car_class : " + car_class);
//			System.out.println("차량 model size : " + list.size());
			return list;
		}
		
		@RequestMapping(value="car_list_filter.cal")
		@ResponseBody
		public Object car_find_filter(
						@RequestParam("filter1") double filter1,
						@RequestParam("filter2") double filter2,
						@RequestParam("filter3") double filter3
				) throws Exception {
//			System.out.println("넘겨받은 선납금% : " + filter1);
//			System.out.println("넘겨받은 계약기간 : " + filter2);
//			System.out.println("넘겨받은 월납입금 : " + filter3);
			double filter1_1 = Math.round(filter1*0.01);
//			System.out.println("넘겨받은 선납금% 계산 : " + filter1_1);
			
			Map<String, Double> m = new HashMap<String, Double>();
			m.put("filter1", filter1_1);
			m.put("filter2", filter2);
			m.put("filter3", filter3);
			
			List<CarBean> list = new ArrayList<CarBean>();
			list = carservice.getCarModelList_filter(m);
//			System.out.println("차량 model size : " + list.size());
			return list;
		}
		
		
		//실구매가격계산기 - car_no에 해당하는 차량 정보
		@RequestMapping(value="car_detail.cal")
		@ResponseBody
		public Object car_detail(
						@RequestParam("car_no") String car_no
				) throws Exception {
			CarBean car = carservice.car_select(car_no);
//			System.out.println("넘겨받은 car_no : " + car_no);
			return car;
		}
		//지은
		
		
		//인보
				//메인페이지에서 중고차량 등록 링크
				@RequestMapping(value="/register.car")
				public String register() {

					return "sim/register";
				}
				
				
				
				
				//차량 등록 버튼 클릭 시 넘어온 차량번호를 db에서 조회하여 값이 있을경우(중복) 이미 등록된 차량이므로 return null;
				//등록되지 않은 차량일 경우 db에 값을 입력해주고 확인페이지로 redirect
				@RequestMapping(value="/car_temp_register.car",method=RequestMethod.POST)
				public ModelAndView car_temp_register(Car_tempBean Car_tempBean,
						HttpServletRequest request,HttpServletResponse response) throws Exception {
					
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					String temp_car_no = request.getParameter("temp_car_no");
					
					//주소+상세주소 설정
					String temp_location = request.getParameter("temp_location");
					String temp_location2 = request.getParameter("temp_location2");
					
					
					Car_tempBean c = this.carservice.checkTemp_car_no(temp_car_no);
				
					//사용가능한 딜러id와 스토어no를 location값을 받아 리스트로 뽑음
					List<String> l = this.carservice.checkTemp_location(Car_tempBean);
					int length = l.size();
					
					//랜덤생성
					Random random = new Random();
					
					//객체의 밸류값을 랜덤으로 가져옴
					l.get(random.nextInt(length));
					
					String dealer_id= l.get(random.nextInt(length));
					
					Car_tempBean.setDealer_id(dealer_id);
					
					if(c!=null) {//값이 들어올경우
							 out.println("<script>");
							 out.println("alert('이미 등록된 차량입니다.')");
							 out.println("history.back()");
							 out.println("</script>");
							 
						
					}else {
						ModelAndView mv = new ModelAndView("main");
						Car_tempBean.setTemp_location(temp_location+" "+temp_location2);
						this.carservice.insertCarTemp(Car_tempBean);
						
						if(true) {
					
						
						}
						
						List<Car_tempBean> confirmList= carservice.getConfirmList(temp_car_no);
						
						
						mv.addObject("confirmList",confirmList);
						
						//return "redirect:confirm.car";
						return mv;
					}

					return null;
				
				}
					 
				/*
				 * //차량 등록 확인리스트(딜러_name포함)
				 * 
				 * @RequestMapping(value="confirm.car") public ModelAndView
				 * register_confirm(Car_tempBean Car_tempBean) throws Exception {
				 * 
				 * String temp_car_no = Car_tempBean.getTemp_car_no();
				 * 
				 * System.out.println("등록한차량 차량번호 조회:"+temp_car_no);
				 * 
				 * List<Car_tempBean> confirmList= carservice.getConfirmList(temp_car_no);
				 * 
				 * ModelAndView model=new ModelAndView("sim/confirmList");
				 * 
				 * model.addObject("confirmList",confirmList);
				 * 
				 * return model; }
				 */
				  
				  
				//등록차량 추가사항 입력(딜러)페이지 이동
				  @RequestMapping(value="/car_temp_list.car")
					public String car_temp_list() {

						return "sim/car_temp_list";
					}
				

				//temp list(dealer)
				  @RequestMapping(value="car_temp_list",method=RequestMethod.GET)
				  public ModelAndView getCar_temp_list(
						  @RequestParam("dealer_id") String dealer_id,Car_tempBean Car_tempBean) throws Exception {
				  
				  List<Car_tempBean> car_temp_list= this.carservice.getTemp_list(dealer_id);
				  
				  ModelAndView model=new ModelAndView("sim/car_temp_list");
				  
				  
				  model.addObject("car_temp_list",car_temp_list);
				  
				  System.out.println(dealer_id);
				  
				  return model; 
				  
				  }
				  
				//temp list 값을 받아서  추가 입력 가능한 창
				  //list 받아올 때 해당하는 차량 no로 끌어와서 보여주기
				  //cont 보는것 처럼 하면 됨
				  @RequestMapping(value="car_insert.car",method=RequestMethod.GET)
				  public ModelAndView car_insert(Car_tempBean Car_tempBean,
						 @RequestParam("temp_car_no") String temp_car_no
					)  throws Exception { 
					  
					  
					  List<Car_tempBean> car_temp_one = this.carservice.getCar_temp_one(temp_car_no);
					  
					  ModelAndView model=new ModelAndView("sim/register2");
					  
					  model.addObject("car_temp_one",car_temp_one);
					  
					  return model;
				  }
				
				  //carbean insert

				 
					
				  	//carbean insert
					@RequestMapping(value="/car_complete.car",method=RequestMethod.POST)
					public String car_complete(CarBean CarBean,
							HttpServletRequest request,HttpServletResponse response
							) throws Exception {
					int year=Integer.parseInt((String)request.getParameter("temp_year"));
					int distance=Integer.parseInt((String)request.getParameter("temp_distance"));
					String color = request.getParameter("car_color");
					String accident=request.getParameter("temp_accident");
					String engine=request.getParameter("car_engine");
					String condition=request.getParameter("car_condition");
					String change=request.getParameter("car_change");
					String fault=request.getParameter("car_fault");
					String fuel=request.getParameter("car_fuel");
					String[] option=request.getParameterValues("car_option");
	
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					int score=100;
					
					int cyear = Calendar.getInstance().get(Calendar.YEAR);
					
					/*점수계산기*/
					
					//연식
					 if((cyear-year)<6 && (cyear-year)>=3) {
					  score = score -5;
					  }else if(
						  (cyear-year)>=6) {
					  score = score -8;
					  
					  }
					 
					 //주행거리
					 if(distance>=100000) {
						 score = score -7;
					 }else if(distance>=50000 && distance<100000) {
						 score = score -5;
					 }else if(distance>=30000 && distance<50000) {
						 score = score -3;
					 }
					 
					 
					 //사고이력
					 if(accident.equals("무사고")) {
						
					 }else {
						 score = score -7;
					 }
					 
					 
					 //색상
					 if(color.equals("검은색") ||color.equals("흰색")||color.equals("쥐색")) {
						 
					 }else {
						 score = score -3;
					 }
					 
					 //엔진상태
					 if(engine.equals("점검필요")){
						 score = score -3;
						 
					 }
					 
					 //주행조건
					 if(condition.equals("산악")) {
						 score = score - 5;
					 }else if(condition.equals("시내")) {
						 score = score - 2;
					 }
					 
					 
					 //교체필요여부
					 if(change.equals("필터 교체요망")) {
						 score = score -1;
					 }else if(change.equals("타이어 교체요망")) {
						 score = score - 3;
					 }
					 
					 //결함여부
					 if(fault.equals("제동계 결함")) {
						 score = score -5;
					 }else if(fault.equals("미션 결함")) {
						 score = score - 4;
					 }else if(fault.equals("냉각계통 결함")) {
						 score = score - 3;
					 }else if(fault.equals("베터리 결함")) {
						 score = score - 2;
					 }
					 
					 
					 if(fuel.equals("휘발유")) {
						 score = score -2;
					 }else if(fuel.equals("경유")) {
						 score = score - 1;
					 }
					 
					 int op = option.length;
					 
					 if(op<4) {
						 score = score -3;
					 }
					 	CarBean.setCar_color(color);
					 	CarBean.setCar_score(score);
					 	
					 	MultipartFile UpFile = CarBean.getImage();
					
					 	//업로딩 된 파일이 있으면
					 	if(!UpFile.isEmpty()) {

							String homedir = saveFolder;

							File[] files= new File(saveFolder).listFiles();
							ArrayList<String> fileName = new ArrayList<String>();
							for (File file : files) {
							    if (file.isFile()) {
							    	String name=file.getName();
							    	fileName.add(name);
							    }
							}
							String max = Collections.max(fileName);

							File path1 = new File(homedir);

							if(!path1.isFile()) 
								System.out.println("파일1없음");

							if (!(path1.exists())) 
								System.out.println("경로폴더1 생성");
								path1.mkdir();//path1의 이름을 가진 경로를 만듭니다*폴더생성

							int index = max.lastIndexOf(".");

							String fileExtension =max.substring(index +1);

							int index1=max.indexOf("_");
							int indexEnd = max.indexOf(".");
							
							System.out.println("index1="+index1+"indexEnd="+indexEnd);
						
							int num=Integer.parseInt(max.substring(index1+1,indexEnd));

							String refileName="img_"+(num+1)+"."+fileExtension;
	
							String fileDBName = "/"+ refileName;

					 
					 		UpFile.transferTo(new File(saveFolder+fileDBName));

					 		CarBean.setCar_image(fileDBName);
							}
 	
						this.carservice.insertCar(CarBean);
						
						String car_no =request.getParameter("temp_car_no");

						this.carservice.deleteCar_temp(car_no);
						
					
						
						return "redirect:dealer_car_manage.dlr";
						
						

					}
					

					//차량 등록 확인리스트(딜러_name포함)
					  @RequestMapping(value="confirm2.car")
					  public ModelAndView register_confirm2() throws Exception {
					  
					  List<CarBean> confirmList2= carservice.getConfirmList2();
					  
					  
					  ModelAndView model=new ModelAndView("sim/confirmList2");
					  
					  model.addObject("confirmList2",confirmList2);
					  
					  return model; 
					  }
					  
					
					  
				  //등록완료 차량 내용 상세보기
					  @RequestMapping(value="confirm_cont.car")
					  public ModelAndView cont(@RequestParam("car_no")String car_no,
							  					@RequestParam("state")String state)
					  throws Exception{
						  
						  List<CarBean> confirmList3 = this.carservice.getCont(car_no);
						  //List<Car_tempBean> temp_edit= this.carservice.getCont2(car_no);
						  	
						  ModelAndView cont=new ModelAndView();
							if(state.equals("cont")){
								cont.setViewName("sim/confirmList3");
							}else if(state.equals("edit")) {
								cont.setViewName("sim/edit");
							}
							

						  	cont.addObject("confirmList3",confirmList3);
						  	//cont.addObject("temp_edit",temp_edit);
						  	return cont;
						  	
					  }
//					  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
				/*
				 * @RequestMapping(value="confirm_edit.car") public ModelAndView
				 * carcont(@RequestParam("car_no")String car_no //, Car_tempBean Car_tempBean )
				 * throws Exception{
				 * 
				 * List<CarBean> confirmList3 = this.carservice.getCont(car_no);
				 * //List<Car_tempBean> temp_edit= this.carservice.getCont2(car_no);
				 * 
				 * ModelAndView cont=new ModelAndView("sim/edit");
				 * 
				 * 
				 * cont.addObject("confirmList3",confirmList3);
				 * //cont.addObject("temp_edit",temp_edit);
				 * 
				 * return cont;
				 * 
				 * }
				 */
//					  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
					  @RequestMapping(value="/delete.car")
					  public String car_delete(HttpServletRequest request,
							  				HttpServletResponse response,
							  				@RequestParam("car_no")String car_no)
							  						throws Exception{
						  
						  this.carservice.deleteCar(car_no);
						  
						  return "redirect:confirm2.car";  
					  }
					  
					  
					  	
					 	//carbean edit
						@RequestMapping(value="/edit.car",method=RequestMethod.POST)
						public String car_edit(CarBean CarBean,
								HttpServletRequest request,HttpServletResponse response
								) throws Exception {
							
							String car_no=request.getParameter("car_no");
							//CarBean.setCar_no(car_no);
							//System.out.println("수정하려는 차량 번호 : " + car_no);
							//System.out.println("옵션 : " + CarBean.getCar_option());

							CarBean c = this.carservice.car_select1(car_no);
							
							c.setCar_class(CarBean.getCar_class());
							c.setCar_model(CarBean.getCar_model());
							c.setCar_old(CarBean.getCar_old());
							c.setCar_distance(CarBean.getCar_distance());
							c.setCar_accident(CarBean.getCar_accident());
							c.setCar_color(CarBean.getCar_color());
							
							c.setCar_engine(CarBean.getCar_engine());
							c.setCar_condition(CarBean.getCar_condition());
							c.setCar_change(CarBean.getCar_change());
							c.setCar_fault(CarBean.getCar_fault());
							c.setCar_fuel(CarBean.getCar_fuel());
							c.setCar_option(CarBean.getCar_option());
							c.setCar_price(CarBean.getCar_price());
							c.setCar_cc(CarBean.getCar_cc());;
							c.setCar_image(CarBean.getCar_image());
							
							
			
				  int year=Integer.parseInt((String)c.getCar_old()); 
				  int distance=Integer.parseInt((String)c.getCar_distance());
				
							//int year=c.getCar_old();
							//int distance=c.getCar_distance();
							String accident=c.getCar_accident();
							String color=c.getCar_color();

						int score=100;
						System.out.println("현재스코어="+score);
						
					int cyear = Calendar.getInstance().get(Calendar.YEAR);
						System.out.println(cyear);
						/*점수계산기*/
						
						
						//연식
						 if((cyear-year)<6 && (cyear-year)>=3) {
						  score = score -5;
						  }else if(
							  (cyear-year)>=6) {
						  score = score -8;
						  
						  }
						 
						 //주행거리
						 if(distance>=100000) {
							 score = score -7;
						 }else if(distance>=50000 && distance<100000) {
							 score = score -5;
						 }else if(distance>=30000 && distance<50000) {
							 score = score -3;
						 }
						 
						 
						 //사고이력
						 if(accident.equals("무사고")) {
							
						 }else {
							 score = score -7;
						 }
						 
						 
						 //색상
						 if(color.equals("검은색") ||color.equals("흰색")||color.equals("쥐색")) {
							 
						 }else {
							 score = score -3;
						 }
						 
						 //엔진상태
						 if(c.getCar_engine().equals("점검필요")){
							 score = score -3;
							 
						 }
						 
						 //주행조건
						 if(c.getCar_condition().equals("산악")) {
							 score = score - 5;
						 }else if(c.getCar_condition().equals("시내")) {
							 score = score - 2;
						 }
						 
						 
						 //교체필요여부
						 if(c.getCar_change().equals("필터 교체요망")) {
							 score = score -1;
						 }else if(c.getCar_change().equals("타이어 교체요망")) {
							 score = score - 3;
						 }
						 
						 //결함여부
						 if(c.getCar_fault().equals("제동계 결함")) {
							 score = score -5;
						 }else if(c.getCar_fault().equals("미션 결함")) {
							 score = score - 4;
						 }else if(c.getCar_fault().equals("냉각계통 결함")) {
							 score = score - 3;
						 }else if(c.getCar_fault().equals("베터리 결함")) {
							 score = score - 2;
						 }
						 
						 
						 if(c.getCar_fuel().equals("휘발유")) {
							 score = score -2;
						 }else if(c.getCar_fuel().equals("경유")) {
							 score = score - 1;
						 }
						 
						 String[] optionArr = c.getCar_option().split(",");
						 System.out.println("배열 길이 : "+optionArr.length);
						 
						 if(optionArr.length<3) {
							 score = score -3;
						 }
						 
						 

						 	c.setCar_score(score);
						 	
						 	//carbean 저장형태변경 / 업로드파일을 multifile형식으로 저장
						 	MultipartFile UpFile = CarBean.getImage();
						 	
						 	File DelFile = new File(saveFolder+CarBean.getCar_image());
						 	
						 	//업로딩 된 파일이 있으면
						 	if(!UpFile.isEmpty()) {
						 		if(DelFile.exists()){
						 			DelFile.delete();
						 		}
						 		String homedir = saveFolder;

								File[] files= new File(saveFolder).listFiles();
								ArrayList<String> fileName = new ArrayList<String>();
								for (File file : files) {
								    if (file.isFile()) {
								    	String name=file.getName();
								    	fileName.add(name);
								    }
								}
								String max = Collections.max(fileName);
								System.out.println("result="+fileName);
								System.out.println("max="+max);
								//파일형태변수 path1은 homedir의 이름을가짐
								File path1 = new File(homedir);

								//path1에 파일이 없으면
								if(!path1.isFile()) 
									System.out.println("파일1없음");

									
								 
								
								//경로가 없으면
								if (!(path1.exists())) 
									System.out.println("경로폴더1 생성");
									path1.mkdir();//path1의 이름을 가진 경로를 만듭니다*폴더생성


								int index = max.lastIndexOf(".");
								System.out.println("index="+index);
								
								//확장자는 파일이름의 인덱스위치+1의 자리부터 뒤에 있는 글자들
								String fileExtension =max.substring(index +1);
								System.out.println("확장자:"+fileExtension);

								
								int index1=max.indexOf("_");
								int indexEnd = max.indexOf(".");
								
								System.out.println("index1="+index1+"indexEnd="+indexEnd);
							
								int num=Integer.parseInt(max.substring(index1+1,indexEnd));
								
								System.out.println(num);
				
								String refileName="img_"+(num+1)+"."+fileExtension;
					
								System.out.println("refileName = " + refileName);
								
								String fileDBName = "/"+ refileName;
								
								System.out.println("fileDBName = " + fileDBName);
				
								UpFile.transferTo(new File(saveFolder+fileDBName));
						 		
						 		//빈의 car_image객체에 db네임을 저장함.(db에 저장될 이름)
						 		c.setCar_image(fileDBName);
						 		}
						 	
							this.carservice.editCar(c);

							return "redirect:confirm2.car";

						}
				
				/*
				 * @RequestMapping(value="/temp_ajax")
				 * 
				 * public @ResponseBody List<CarBean> temp_ajax(CarBean CarBean,
				 * 
				 * @RequestBody String cla ) throws Exception{
				 * 
				 * 
				 * List<CarBean> c =carservice.searchModel(cla);
				 * 
				 * System.out.println("입력값:"+cla); return c;
				 * 
				 * }
				 */
			}
