package org.doorisopen.myspring.Goods.Service;

import java.util.List;

import org.doorisopen.myspring.Goods.Domain.GoodsVO;
import org.doorisopen.myspring.Goods.Domain.ReviewVO;
import org.doorisopen.myspring.Goods.Persistence.GoodsDAO;
import org.doorisopen.myspring.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDAO dao;

	
	/* ��ǰ ���
	 * 
	 * 
	 */
	@Override
	public int GoodsCreate(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.GoodsCreate(vo);
	}

	/* ��ǰ ����Ʈ
	 * 
	 * 
	 */
	@Override
	public List<GoodsVO> GoodsRead(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		return dao.GoodsRead(pagination);
	}

	/* ��ü ��ǰ ���� Ȯ��
	 * 
	 * 
	 */
	@Override
	public int getGoodsListCnt() throws Exception {
		// TODO Auto-generated method stub
		return dao.getGoodsListCnt();
	}

	/* ��ǰ ��
	 * 
	 * 
	 */
	@Override
	public GoodsVO GoodsDetail(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		// ��ǰ ��ȸ�� ������Ʈ
		dao.GoodsViewCntUpdate(goodsIdx);
		
		return dao.GoodsDetail(goodsIdx);
	}
	
	/* ��ǰ ����
	 * 
	 * 
	 */
	@Override
	public int GoodsUpdate(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.GoodsUpdate(vo);
	}
	
	/* ��ǰ ����
	 * 
	 * 
	 */
	@Override
	public int GoodsDelete(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		return dao.GoodsDelete(goodsIdx);
	}

	
	/* *****************************
	 *           REVIEW
	 *          
	 *******************************/
	/* ��ǰ ���� ����Ʈ
	 * 
	 * 
	 */
	@Override
	public List<ReviewVO> ReviewRead(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* ��ǰ ���� �ۼ�
	 * 
	 * 
	 */
	@Override
	public int ReviewCreate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* ��ǰ ���� ����
	 * 
	 * 
	 */
	@Override
	public int ReviewUpdate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* ��ǰ ���� ����
	 * 
	 * 
	 */
	@Override
	public int ReviewDelete(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* ��ǰ ���� ���� TEST
	 * 
	 * 
	 */
	@Override
	public List<ReviewVO> reviewToReviewRead(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* ��ǰ ���� ���� ���
	 * 
	 * 
	 */
	@Override
	public int reviewToReviewCreate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
