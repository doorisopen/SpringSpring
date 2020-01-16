package org.doorisopen.myspring.Goods.Persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.doorisopen.myspring.Goods.Domain.CartVO;
import org.doorisopen.myspring.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartDAOImpl implements CartDAO{

	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace ="org.doorisopen.myspring.Cart.CartMapper";
	
	
	/* ��ٱ��� �߰�
	 * 
	 * 
	 */
	@Override
	public int CartAdd(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + ".CartAdd", vo);
	}
	
	/* ��ٱ��� ����Ʈ
	 * 
	 * 
	 */
	@Override
	public List<CartVO> CartRead(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		List<CartVO> CartRead = new ArrayList<CartVO>();
		// CartRead = sqlSession.selectList(namespace + ".CartRead", pagination);
		Map<String, Object> map = new HashMap<String, Object>();
		String writer = "admin";
		map.put("writer", writer);
		CartRead = sqlSession.selectList(namespace + ".CartRead", map);
		return CartRead;
	}
	
	/* ��ü ��ٱ��� ���� Ȯ��
	 * 
	 * 
	 */
	@Override
	public int getCartListCnt() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getCartListCnt");
	}
	
	
	/* ��ٱ��� ����
	 * 
	 * 
	 */
	@Override
	public int CartUpdate(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + ".CartUpdate", vo);
	}
	
	/* ��ٱ��� ����
	 * 
	 * 
	 */
	@Override
	public int CartDelete(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + ".CartDelete", vo);
	}

	
	/* ��ٱ��� ��ǰ Ȯ��
	 * 
	 * 
	 */
	@Override
	public int isGoodsExist(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("writer", vo.getWriter());
		map.put("goodsIdx", vo.getGoodsIdx());
		return sqlSession.selectOne(namespace + ".isGoodsExist",map);
	}
	

}
