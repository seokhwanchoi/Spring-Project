package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {

	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant;
	
	@Test
	public void testExists() {
		
		assertNotNull(restaurant);//restaurant변수가 null이 아니어야 테스트가 성공한다는 뜻
	
		log.info(restaurant);
		log.info("---------------------------------------");
		log.info(restaurant.getChef());
	
	}
	
}
/*
 @RunWith : 현재 테스트 코드가 스프링을 실행하는 역할을 할 것이라는 것 표시
 @ContextConfiguration : 지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록
 (스프링의 빈으로 등록된다고 표현)
  @ContextConfiguration에 사용하는 문자열은 'classpath:'나 'file:'을 이용할 수 있다.
  따라서 이클립스에서 자동생서된 root-context.xml의 경로를 지정할 수 있다.
  
  @Log4j는 자바 기반의 로깅 유틸리티로 Lombok을 이용해 로그를 기록하는 Logger를 변수로 생성
  
  로그에 대한 설정은 srt/main/resources와 src/test/resources에 별도로 존재
  
  @Autowired : 해당 인스턴스 변수가 스프링으로부터 자동으로 주입해달라는 표시
  
 
 */
