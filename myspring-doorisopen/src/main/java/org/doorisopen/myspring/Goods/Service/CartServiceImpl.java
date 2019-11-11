package org.doorisopen.myspring.Goods.Service;

import java.util.List;

import org.doorisopen.myspring.Goods.Domain.CartVO;
import org.doorisopen.myspring.Goods.Persistence.CartDAO;
import org.doorisopen.myspring.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDAO dao;

	
	/* ��ٱ��� �߰�
	 * 
	 * 
	 */
	@Override
	public int CartAdd(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.CartAdd(vo);
	}

	/* ��ٱ��� ����Ʈ
	 * 
	 * 
	 */
	@Override
	public List<CartVO> CartRead(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		return dao.CartRead(pagination);
	}

	/* ��ü ��ٱ��� ���� Ȯ��
	 * 
	 * 
	 */
	@Override
	public int getCartListCnt() throws Exception {
		// TODO Auto-generated method stub
		return dao.getCartListCnt();
	}
	
	/* ��ٱ��� ����
	 * 
	 * 
	 */
	@Override
	public int CartUpdate(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.CartUpdate(vo);
	}
	
	/* ��ٱ��� ����
	 * 
	 * 
	 */
	@Override
	public int CartDelete(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		return dao.CartDelete(goodsIdx);
	}

	
}
