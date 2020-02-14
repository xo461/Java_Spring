package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;


//자동생성해주는 어노테이션: 먼저 여기 패키지를 스캔할 수 있도록 지정해야 한다. 
//@Controller, @Component, @Service, @Repository, @RestController

@Component //해당 클래스가 스프링관리대상임을 알려줌
@Data //lombok.. getter,setter,toString 자동생성시켜줌
public class Restaurant {
	//저장변수 선언 - DI 적용해서 Chef 넣어주기 
	@Setter(onMethod_ = {@Autowired}) //setter따로 쓸 필요 없이 Chef.java가 들어옴. 오류시 재부팅하고,maven update.. 
	private Chef chef;

}
