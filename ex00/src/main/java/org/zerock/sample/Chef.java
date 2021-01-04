package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;


/*
@Data는 @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor을
 한번에 사용하는 강력한 어노테이션 입니다. 강력한 어노테이션인 만큼 그에 따른 부작용도 많아 사용을 지양해야.
 
 https://cheese10yun.github.io/lombok/
 
 참고
 */

@Component//스프링에게 해당 클래스가 관리해야할 대상임을 표시
@Data
public class Chef {

}
