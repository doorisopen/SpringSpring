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
	
	
	/* 장바구니 추가
	 * 
	 * 
	 */
	@Override
	public int CartAdd(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + ".CartAdd", vo);
	}
	
	/* 장바구니 리스트
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
	
	/* 전체 장바구니 개수 확인
	 * 
	 * 
	 */
	@Override
	public int getCartListCnt() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getCartListCnt");
	}
	
	
	/* 장바구니 수정
	 * 
	 * 
	 */
	@Override
	public int CartUpdate(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + ".CartUpdate", vo);
	}
	
	/* 장바구니 삭제
	 * 
	 * 
	 */
	@Override
	public int CartDelete(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + ".CartDelete", vo);
	}

	
	/* 장바구니 물품 확인
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
