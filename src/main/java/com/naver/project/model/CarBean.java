package com.naver.project.model;

import org.springframework.web.multipart.MultipartFile;

public class CarBean {
	
	private String car_no;
	private int car_price;
	private String car_class;
	private String car_model;
	private String car_engine;
	private String car_accident;
	private String car_old;
	private String car_distance;
	private String car_change;
	private String car_fault;
	private String car_fuel;
	private String car_cc;
	private String car_color;
	private String car_option;
	private int car_score;
	private String grade;
	
	private String dealer_id;
	private String car_condition;
	private String dealer_name;
	private String original_image;	
	
	//temp
	private String temp_car_no;
	private String temp_class;
	private String temp_model;
	private String temp_accident;
	private String temp_year;
	private String temp_distance;
	
	
	//입력받을 car_image는 멀티파일형태로 저장
	private MultipartFile image;
	private String car_image;
	public String getCar_no() {
		return car_no;
	}
	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}
	public int getCar_price() {
		return car_price;
	}
	public void setCar_price(int car_price) {
		this.car_price = car_price;
	}
	public String getCar_class() {
		return car_class;
	}
	public void setCar_class(String car_class) {
		this.car_class = car_class;
	}
	public String getCar_model() {
		return car_model;
	}
	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}
	public String getCar_engine() {
		return car_engine;
	}
	public void setCar_engine(String car_engine) {
		this.car_engine = car_engine;
	}
	public String getCar_accident() {
		return car_accident;
	}
	public void setCar_accident(String car_accident) {
		this.car_accident = car_accident;
	}
	public String getCar_old() {
		return car_old;
	}
	public void setCar_old(String car_old) {
		this.car_old = car_old;
	}
	public String getCar_distance() {
		return car_distance;
	}
	public void setCar_distance(String car_distance) {
		this.car_distance = car_distance;
	}
	public String getCar_change() {
		return car_change;
	}
	public void setCar_change(String car_change) {
		this.car_change = car_change;
	}
	public String getCar_fault() {
		return car_fault;
	}
	public void setCar_fault(String car_fault) {
		this.car_fault = car_fault;
	}
	public String getCar_fuel() {
		return car_fuel;
	}
	public void setCar_fuel(String car_fuel) {
		this.car_fuel = car_fuel;
	}
	public String getCar_cc() {
		return car_cc;
	}
	public void setCar_cc(String car_cc) {
		this.car_cc = car_cc;
	}
	public String getCar_color() {
		return car_color;
	}
	public void setCar_color(String car_color) {
		this.car_color = car_color;
	}
	public String getCar_option() {
		return car_option;
	}
	public void setCar_option(String car_option) {
		this.car_option = car_option;
	}
	public int getCar_score() {
		return car_score;
	}
	public void setCar_score(int car_score) {
		this.car_score = car_score;
	}
	public String getDealer_id() {
		return dealer_id;
	}
	public void setDealer_id(String dealer_id) {
		this.dealer_id = dealer_id;
	}
	public String getCar_condition() {
		return car_condition;
	}
	public void setCar_condition(String car_condition) {
		this.car_condition = car_condition;
	}
	public String getDealer_name() {
		return dealer_name;
	}
	public void setDealer_name(String dealer_name) {
		this.dealer_name = dealer_name;
	}
	public String getTemp_car_no() {
		return temp_car_no;
	}
	public void setTemp_car_no(String temp_car_no) {
		this.temp_car_no = temp_car_no;
	}
	public String getTemp_class() {
		return temp_class;
	}
	public void setTemp_class(String temp_class) {
		this.temp_class = temp_class;
	}
	public String getTemp_model() {
		return temp_model;
	}
	public void setTemp_model(String temp_model) {
		this.temp_model = temp_model;
	}
	public String getTemp_accident() {
		return temp_accident;
	}
	public void setTemp_accident(String temp_accident) {
		this.temp_accident = temp_accident;
	}
	public String getTemp_year() {
		return temp_year;
	}
	public void setTemp_year(String temp_year) {
		this.temp_year = temp_year;
	}
	public String getTemp_distance() {
		return temp_distance;
	}
	public void setTemp_distance(String temp_distance) {
		this.temp_distance = temp_distance;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getCar_image() {
		return car_image;
	}
	public void setCar_image(String car_image) {
		this.car_image = car_image;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getOriginal_image() {
		return original_image;
	}
	public void setOriginal_image(String original_image) {
		this.original_image = original_image;
	}
	
	
}

