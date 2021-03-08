package org.gl.domain;

import lombok.Data;

@Data//@Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode을 한꺼번에 설정해주는 매우 유용한 어노테이션
public class SampleDTO {
	private String name;
	private int age;
}
