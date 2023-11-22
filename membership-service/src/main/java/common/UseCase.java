package common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface UseCase {


  /* 사용이 되는 예시(case) => 인터페이스가 될 것
  * 실제로 이것을 사용해서 멤버십 등록/조회 함*/
  @AliasFor(annotation = Component.class)
  String value() default "";
}
