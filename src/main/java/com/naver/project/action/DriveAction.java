package com.naver.project.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.naver.project.dao.DriveService;
import com.naver.project.model.CarBean;
import com.naver.project.model.DealerBean;
import com.naver.project.model.DriveBean;
import com.naver.project.model.DriveListResultBean;
import com.naver.project.model.StoreBean;
import com.naver.project.model.Test_dateBean;

@Controller
public class DriveAction {

	@Autowired
	private DriveService driveservice;

	@RequestMapping(value = "/drive.drv")
	public ModelAndView drive_main() {
		ModelAndView m = new ModelAndView();
		m.setViewName("ha/drive");
		m.addObject("listcount", 0);
		return m;
	}

	@RequestMapping(value = "/selectCarclass.drv")
	@ResponseBody
	public List<CarBean> class_list() throws Exception {

		List<CarBean> carclass = driveservice.searchCarClass();
		return carclass;
	}
	
	@RequestMapping(value = "/selectCarmodel.drv")
	@ResponseBody
	public List<CarBean> model_list(
			@RequestParam("carclass") String car_class) throws Exception {
		List<CarBean> carmodel = driveservice.searchCarModel(car_class);
		return carmodel;
	}
	
	@RequestMapping(value = "/selectStoreLoc1.drv")
	@ResponseBody
	public List<StoreBean> storeloc1_list(
			@RequestParam("cclass") String car_class,
			@RequestParam("cmodel") String car_model) throws Exception {
		
		Map m = new HashMap();
		m.put("car_class", car_class);
		m.put("car_model", car_model);
		
		List<StoreBean> storeloc1 = driveservice.searchStoreLoc1(m);
		return storeloc1;
	}
	
	@RequestMapping(value = "/selectStoreLoc2.drv")
	@ResponseBody
	public List<StoreBean> storeloc2_list(
			@RequestParam("cclass") String car_class,
			@RequestParam("cmodel") String car_model,
			@RequestParam("stloc1") String stloc1) throws Exception {
		
		Map m = new HashMap();
		m.put("car_class", car_class);
		m.put("car_model", car_model);
		m.put("store_loc1", stloc1 + "%");
		
		List<StoreBean> storeloc2 = driveservice.searchStoreLoc2(m);
		return storeloc2;
	}
	
	@RequestMapping(value = "/driveCarlist.drv")
	public ModelAndView driveCar_list(
			@RequestParam("cclass") String car_class,
			@RequestParam("cmodel") String car_model,
			@RequestParam("stloc1") String stloc1,
			@RequestParam("stloc2") String stloc2,
			@RequestParam("state") String state,
			@RequestParam(value="page", defaultValue="1") int page ) throws Exception {
		
		Map m = new HashMap();
		m.put("car_class", car_class);
		m.put("car_model", car_model);
		m.put("store_loc1", stloc1 + "%");
		m.put("store_loc2", "%" + stloc2 + "%");
		m.put("page", page);
		
		int listcount = driveservice.getDriveListCount(m);
		
		int limit = 6;
		int maxpage = (listcount + limit - 1) / limit;
		int startpage = ((page-1) / 6) * 6 + 1;
		int endpage = startpage + 6 - 1;
		if(endpage > maxpage) endpage = maxpage;
		
		List<DriveListResultBean> drivelist = driveservice.searchDrivelist(m);
		
		ModelAndView model = null;
		if(state != null) {
			model = new ModelAndView("ha/drive2");
		} else {
			model = new ModelAndView("ha/drive");
		}
		model.addObject("page", page);
		model.addObject("maxpage", maxpage);
		model.addObject("startpage", startpage);
		model.addObject("endpage", endpage);
		model.addObject("listcount", listcount);
		model.addObject("drivelist", drivelist);
		
		return model;
	}
	
	@RequestMapping(value = "/getDealerInfo.drv")
	@ResponseBody
	public DriveListResultBean getDealerInfo(
			@RequestParam("dealerid") String dealerid) throws Exception {
		
		DriveListResultBean dealerinfo = driveservice.getDealerInfo(dealerid);
		return dealerinfo;
	}
	
	@RequestMapping(value = "/getDrivedate.drv")
	@ResponseBody
	public List<Test_dateBean> getDrivedate(
			@RequestParam("car_no") String car_no) throws Exception {
		List<Test_dateBean> testdate = driveservice.getDrivedate(car_no);
		return testdate;
	}
	
	@RequestMapping(value = "/insertDriveInfo.drv", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public DriveListResultBean insertDriveInfo(
			@RequestParam("car_no") String car_no,
			@RequestParam("dealer_id") String dealer_id,
			@RequestParam("drive_date") String drive_date,
			@RequestParam("drive_ampm") String drive_ampm,
			@RequestParam("drive_name") String drive_name,
			@RequestParam("drive_phone") String drive_phone) throws Exception {
		
		Map m = new HashMap();
		
		CarBean carbean = driveservice.getCarInfo(car_no);
		DealerBean dealerbean = driveservice.getStoreNo(dealer_id);
		
		m.put("car_no", car_no);
		m.put("car_class", carbean.getCar_class());
		m.put("car_model", carbean.getCar_model());
		m.put("dealer_id", dealer_id);
		m.put("drive_date", drive_date);
		m.put("drive_ampm", drive_ampm);
		m.put("drive_name", drive_name);
		m.put("drive_phone", drive_phone);
		
		driveservice.insertDriveInfo(m);
		
		m.put("store_no", dealerbean.getStore_no());
		driveservice.insertTestDate(m);
		
		DriveListResultBean driveresultbean = driveservice.getDriveSuccessInfo(m);
		
		return driveresultbean;
	}
	
	@RequestMapping(value = "/drive_suc.drv")
	public String drive_suc() {
		return "ha/drive_suc";
	}

	@RequestMapping(value = "/dealer_drive_manage.drv")
	public ModelAndView dealer_drive_manage(
			@RequestParam(value="cclass", defaultValue="") String car_class,
			@RequestParam(value="cmodel", defaultValue="") String car_model,
			@RequestParam(value="carno", defaultValue="") String car_no,
			@RequestParam(value="state", defaultValue="") String state,
			@RequestParam(value="page", defaultValue="1") int page) throws Exception {

		Map m = new HashMap();
		m.put("car_class", car_class);
		m.put("car_model", car_model);
		m.put("car_no", "%" + car_no + "%");
		m.put("page", page);
		
		int listcount = driveservice.getDealerDriveListCount(m);

		int limit = 7;
		int maxpage = (listcount + limit - 1) / limit;
		int startpage = ((page-1) / 7) * 7 + 1;
		int endpage = startpage + 7 - 1;
		if(endpage > maxpage) endpage = maxpage;
		
		List<DriveBean> drivelist = driveservice.selectDealerDrivelist(m);
		
		ModelAndView model = null;
		if(state.equals("ajax")) {
			model = new ModelAndView("ha/dealer_drive2");	
		} else {
			model = new ModelAndView("ha/dealer_drive");
		}
		
		model.addObject("page", page);
		model.addObject("maxpage", maxpage);
		model.addObject("startpage", startpage);
		model.addObject("endpage", endpage);
		model.addObject("listcount", listcount);
		model.addObject("drivelist", drivelist);
		model.addObject("cclass", car_class);
		model.addObject("cmodel", car_model);
		model.addObject("carno", car_no);
		return model;
	}
	
	@RequestMapping(value = "/updateDriveComplete.drv", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public void updateDriveConfirm(
			@RequestParam("drive_no") int drive_no) throws Exception {
		
		driveservice.updateDriveComplete(drive_no);
	}
	
}
