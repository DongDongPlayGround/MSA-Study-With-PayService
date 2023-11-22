package common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface PersistenceAdapter {

  /* hexagonal architecture 에서 영속성 관련 어댑터 라는 것을 명시
  * 별도로 다른 기능은 없다*/
  @AliasFor(annotation = Component.class)
  String value() default "";
}
