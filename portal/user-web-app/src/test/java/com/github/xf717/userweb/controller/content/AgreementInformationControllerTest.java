package com.github.xf717.userweb.controller.content;

import com.github.xf717.userweb.manager.content.AgreementInformationManager;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class AgreementInformationControllerTest {
  @Autowired
  private AgreementInformationManager agreementInformationManager;
  @Test
  public void getAgreementInformationByCode() {
    System.out.println(agreementInformationManager.getAgreementInformationByCode("YSXY"));
  }
}
