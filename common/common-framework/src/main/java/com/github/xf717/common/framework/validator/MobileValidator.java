package com.github.xf717.common.framework.validator;

import com.github.xf717.common.framework.util.StringUtils;
import com.github.xf717.common.framework.util.ValidationUtil;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 手机号码校验
 *
 * @author xiaofeng
 */
public class MobileValidator implements ConstraintValidator<Mobile, String> {

  @Override
  public void initialize(Mobile annotation) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // 如果手机号为空，默认不校验，即校验通过
    if (!StringUtils.hasText(value)) {
      return true;
    }
    // 校验手机
    return ValidationUtil.isMobile(value);
  }

}
