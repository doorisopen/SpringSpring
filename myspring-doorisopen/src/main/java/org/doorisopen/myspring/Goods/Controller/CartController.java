package org.doorisopen.myspring.Goods.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.doorisopen.myspring.Board.Controller.BoardController;
import org.doorisopen.myspring.Goods.Domain.CartVO;
import org.doorisopen.myspring.Goods.Domain.GoodsVO;
import org.doorisopen.myspring.Goods.Service.CartService;
import org.doorisopen.myspring.common.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/Cart")
public class CartController {
	
private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private CartService service;

	
	// https://doublesprogramming.tistory.com/137 ���� ��
	/* ��ٱ��� �߰�
	 * 
	 *
	 */
	@RequestMapping(value = "/cartAdd", method = RequestMethod.POST)
	public String cartAdd(Model model, HttpServletRequest request,
			@ModelAttribute CartVO vo) throws Exception {
	
		int isGoodsExist = service.isGoodsExist(vo);
		System.out.println("isGoodsExist : "+ isGoodsExist);
		System.out.println("Writer : "+ vo.getWriter());
		System.out.println("GoodsIdx : "+ vo.getGoodsIdx());
		System.out.println("GoodsAmount : "+ vo.getGoodsAmount());
		try {
			if(isGoodsExist == 0) {
				System.out.println("CartAdd success");
				service.CartAdd(vo);
			} else {
				System.out.println("CartUpdate success");
				service.CartUpdate(vo);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/Cart/cartRead";
	}
	
	/* ��ٱ��� ����Ʈ
	 * 
	 *
	 */
	@RequestMapping(value = "/cartRead", method = RequestMethod.GET)
	public String CartRead(Model model, CartVO vo
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			) throws Exception {

		// ��ü �Խñ� ����
		int listCnt = service.getCartListCnt();
		
		// Pagination ��ü ����
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, range, listCnt);
		model.addAttribute("pagination", pagination);
		
		List<CartVO> cartRead = service.CartRead(pagination);
		model.addAttribute("cartRead", cartRead);
		
		
		return "/Cart/cartRead";
	}
	
	/* ��ٱ��� ����
	 * 
	 *
	 */
	@RequestMapping(value = "/cartUpdate", method = RequestMethod.POST)
	public String CartUpdate(HttpServletRequest request,
			@ModelAttribute CartVO vo,
			@ModelAttribute("goodsIdx") int goodsIdx) throws Exception {
		
    	
		service.CartUpdate(vo);
		
		return "redirect:/Cart/cartRead";
	}
	
	/* ��ٱ��� ����
	 * 
	 *
	 */
	@RequestMapping(value = "/cartDelete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> CartDelete(@RequestBody CartVO vo) throws Exception {
		Map<String, Object> result = new HashMap<>();
		try {
			service.CartDelete(vo);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");

		}
		
		return result;
	}
}
