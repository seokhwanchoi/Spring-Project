package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	//Mapper 인터페이스와 XML을 같이 이용해 보는 것
	
	
	//getTime2는 어노테이션 존재x(실제 sql은 xml 이용해서 처리할 것이므로)
	public String getTime2();
}
