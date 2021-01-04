package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data

public class Restaurant {
	@Setter(onMethod_ = @Autowired)//이거 onMethod 오류날시 lombok 문제
	private Chef chef;
}
/*
 Component없으면 Restaurant 객체에 넣어줄 수 없다.(관리대상 아니어서 @Autowired 있어도..)
 
 onMethod : setter메서드에 추가할 어노테이션 지정
 */
