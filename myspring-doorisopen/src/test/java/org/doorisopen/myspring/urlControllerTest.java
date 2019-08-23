package org.doorisopen.myspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class urlControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(urlControllerTest.class);
	
	// Method 1
	// URL ��� ���� ���� ���� @PathVariable ���� ������ ����: 
	// http://localhost:8080/myspring/try/Hello
	@RequestMapping(value="/try/{msg}", method = RequestMethod.GET)
	public String getUserTest( @PathVariable("msg") String msg) {
		logger.info(msg);
		logger.info(" /try URL called. then getUserTest method executed.");
		return "/urlControllerTest/result_a";
	}
	
	// Method 2
	// ��û �Ķ���� ���� @RequestParam ���� ������ ����
	// http://localhost:8080/myspring/tryA?msg=ThankYou
	// ��� : Result A: Hello
	// @RequestParam ���� ������ ���� ��� �ȵ�
	@RequestMapping(value="/tryA", method = RequestMethod.GET)
	public String getUserTest1( @RequestParam("msg") String msg ) {
		logger.info(msg);
		logger.info(" /tryA URL called. then getUserTest1 method executed.");
		return "/urlControllerTest/result_a";
	}
	
	// Method 3
	// ��û �Ķ���� ���� @ModelAttribute ���� ������ ����
	// http://localhost:8080/web/tryB?msg=thankyou
	// ��� : Result A: Hello thankyou
	// @ModelAttribute ���� ������ ���� ��� �ȴ�
	@RequestMapping(value="/tryB", method = RequestMethod.GET)
	public String getUserTest2( @ModelAttribute("msg") String msg ) {
		logger.info(msg);
		logger.info(" /tryB URL called. then getUserTest2 method executed.");
		return "/urlControllerTest/result_a";
	}
	
	// Method 3
	// http://localhost:8080/web/tryC?msg=thankyouHelloWow
	// ��û �Ķ���� ���� @ModelAttribute ���� ������ ����
	@RequestMapping(value={"/tryC", "/tryD"}, method = RequestMethod.GET)
	public String getUserTest3( @ModelAttribute("msg") String msg ) {
		logger.info(msg);
		logger.info(" /tryB URL called. then getUserTest3 method executed.");
		return "/urlControllerTest/result_a";
	}
	
	// Forward & Redirect TEST
	// Forward TEST
	@RequestMapping(value="/tryFwd", method = RequestMethod.GET)
	public String getUserTest4( @ModelAttribute("msg") String msg ) {
		logger.info(msg);
		logger.info(" /tryFwd URL called. then getUserTest4 method executed.");
		return "forward:/tryB";
	}
	
	// Redirect TEST
	@RequestMapping(value="/tryRdt", method = RequestMethod.GET)
	public String getUserTest5( @ModelAttribute("msg") String msg ) {
		logger.info(msg);
		logger.info(" /tryRdt URL called. then getUserTest5 method executed.");
		return "redirect:/tryB";
	}
	
}
