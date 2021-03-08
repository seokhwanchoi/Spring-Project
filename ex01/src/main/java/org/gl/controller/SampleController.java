package org.gl.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.gl.domain.SampleDTO;
import org.gl.domain.SampleDTOList;
import org.gl.domain.TodoDTO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j// log 객체를 생성하여 로그를 출력할 수 있게 하는 어노테이션
public class SampleController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, 
				new CustomDateEditor(dateFormat, false));
		//binder에 커스텀에디터를 등록한다. 'yyyy-MM-dd'과 같이
		//문자열로 전달된 데이터를 java.util.Date 타입으로 변환

		//출처: https://kunner.com/entry/toby의스프링-13장-스프링-MVC-2 [쉼, 그리고 망설임 없는 마침표.]
	}
	
	@RequestMapping("")
	public void basic() {
		log.info("basic...................");
	}
	
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get...............");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get.......");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(""+dto);
		System.out.println("실행");
		System.out.println(dto.getName());
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name")String name, @RequestParam("age") int age ) {
		log.info("name: " +name);
		log.info("age: "+age);
		
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ida") ArrayList<String> ids) {
		//파라미터로 사용된 변수이 이름 : ida
		//전달되는 파라미터의 이름 : ids   ---> 달라도 사용가능 -->@RequestParam이 그래서 유용
		log.info("ids: "+ids);
		
		return "ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ida") String[] ids) {
		//파라미터로 사용된 변수이 이름 : ida
		//전달되는 파라미터의 이름 : ids   ---> 달라도 사용가능 -->@RequestParam이 그래서 유용
		log.info("array ids: "+ Arrays.toString(ids));
		
		return "ex02Array";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos: "+ list);
		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo: " + todo);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto: "+dto);
		log.info("page: "+page);
		
		return "/sample/ex04";
	}
	

	
}
