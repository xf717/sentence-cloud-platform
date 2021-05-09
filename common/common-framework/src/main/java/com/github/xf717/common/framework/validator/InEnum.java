package com.github.xf717.common.framework.validator;

import com.github.xf717.common.framework.core.IntArrayValuable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({
    ElementType.METHOD,
    ElementType.FIELD,
    ElementType.ANNOTATION_TYPE,
    ElementType.CONSTRUCTOR,
    ElementType.PARAMETER,
    ElementType.TYPE_USE
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
    validatedBy = InEnumValidator.class
)
public @interface InEnum {

  /**
   * @return 实现 EnumValuable 接口的
   */
  Class<? extends IntArrayValuable> value();

  String message() default "必须在指定范围 {value}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
