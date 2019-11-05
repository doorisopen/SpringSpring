package org.doorisopen.myspring.Goods.Persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Goods.Domain.GoodsVO;
import org.doorisopen.myspring.Goods.Domain.ReviewVO;
import org.doorisopen.myspring.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoodsDAOImpl implements GoodsDAO{

	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace ="org.doorisopen.myspring.Goods.GoodsMapper";
	private static final String review_namespace ="org.doorisopen.myspring.Goods.ReviewMapper";
	
	
	/* ��ǰ �ۼ�
	 * 
	 * 
	 */
	@Override
	public int GoodsCreate(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + ".GoodsCreate", vo);
	}
	
	/* ��ǰ ����Ʈ
	 * 
	 * 
	 */
	@Override
	public List<GoodsVO> GoodsRead(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		List<GoodsVO> GoodsRead = new ArrayList<GoodsVO>();
		GoodsRead = sqlSession.selectList(namespace + ".GoodsRead", pagination);
		return GoodsRead;
	}
	
	/* ��ü ��ǰ ���� Ȯ��
	 * 
	 * 
	 */
	@Override
	public int getGoodsListCnt() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getGoodsListCnt");
	}
	
	/* ��ǰ ��
	 * 
	 * 
	 */
	@Override
	public GoodsVO GoodsDetail(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		GoodsVO vo = sqlSession.selectOne(namespace + ".GoodsDetail", goodsIdx);
		
		return vo;
	}
	
	/* ��ǰ ����
	 * 
	 * 
	 */
	@Override
	public int GoodsUpdate(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + ".GoodsUpdate", vo);
	}
	
	/* ��ǰ ����
	 * 
	 * 
	 */
	@Override
	public int GoodsDelete(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + ".GoodsDelete", goodsIdx);
	}
	
	/* ��ǰ ��ȸ�� ����
	 * 
	 * 
	 */
	@Override
	public void GoodsViewCntUpdate(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".GoodsViewCntUpdate", goodsIdx);
	}
	
	/* ��ǰ ��� �� ����
	 * 
	 * 
	 */
	@Override
	public void GoodsReplyCntUpdate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".GoodsReplyCntUpdate", vo);
	}
	
	/* *****************************
	 *           REVIEW
	 *          
	 *******************************/
	@Override
	public List<ReviewVO> ReviewRead(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int ReviewCreate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int ReviewUpdate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int ReviewDelete(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<ReviewVO> reviewToReviewRead(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int reviewToReviewCreate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
