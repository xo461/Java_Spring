package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

//자동생성해주는 어노테이션: @Component, @Service, @Repository, @RestController
//클래스앞에붙음
@Component //해당 클래스가 스프링관리대상임을 알려줌
@Data //lombok.. getter,setter,toString 자동생성시켜줌
public class Chef {

}
