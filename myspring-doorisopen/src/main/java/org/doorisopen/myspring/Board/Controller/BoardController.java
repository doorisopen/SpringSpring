package org.doorisopen.myspring.Board.Controller;

import org.doorisopen.myspring.Board.Service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/Board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private BoardService service;
	
	/* �Խñ� �ۼ� ȭ��
	 * 
	 *
	 */
	@RequestMapping(value="/boardCreateView", method = RequestMethod.GET)
	public String BoardCreateView() {
		
		
		return "/Board/BoardCreate";
	}
	
	/* �Խñ� �ۼ�
	 * 
	 *
	 */
	@RequestMapping(value="/boardCreate", method = RequestMethod.POST)
	public String BoardCreate() {
	
		
		return "/Board/BoardCreate";
	}
	
	/* �Խñ� ����Ʈ
	 * 
	 *
	 */
	@RequestMapping(value = "/boardRead", method = RequestMethod.GET)
	public String BoardRead() {
		
		return "/Board/BoardRead";
	}
	
	
	/* �Խñ� ��
	 * 
	 *
	 */
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String BoardDetail() {
		
		return "/Board/BoardDetail";
	}
	
	
	/* �Խñ� ���� ȭ��
	 * 
	 *
	 */
	@RequestMapping(value = "/boardUpdateView", method = RequestMethod.GET)
	public String BoardUpdateView() {
		
		return "/Board/BoardUpdate";
	}
	
	/* �Խñ� ����
	 * 
	 *
	 */
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String BoardModify() {
		
		return "/Board/BoardUpdate";
	}
	
	/* �Խñ� ����
	 * 
	 *
	 */
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	public String BoardDelete() {
		
		return "/Board/Board";
	}

}
