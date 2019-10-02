package org.doorisopen.myspring.Board.Service;

import java.util.List;

import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Board.Persistence.BoardDAO;
import org.doorisopen.myspring.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;

	
	/* �Խñ� �ۼ�
	 * 
	 * 
	 */
	@Override
	public int BoardCreate(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.BoardCreate(vo);
	}

	/* �Խñ� ����Ʈ
	 * 
	 * 
	 */
	@Override
	public List<BoardVO> BoardRead(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		return dao.BoardRead(pagination);
	}
	
	/* ��ü �Խñ� ���� Ȯ��
	 * 
	 * 
	 */
	@Override
	public int getBoardListCnt() throws Exception {
		// TODO Auto-generated method stub
		return dao.getBoardListCnt();
	}
	
	/* �Խñ� ��
	 * 
	 * 
	 */
	@Override
	public BoardVO BoardDetail(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		
		// �Խñ� ��ȸ�� ������Ʈ
		dao.BoardViewCntUpdate(boardIdx);
		
		return dao.BoardDetail(boardIdx);
	}

	/* �Խñ� ����
	 * 
	 * 
	 */
	@Override
	public int BoardUpdate(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.BoardUpdate(vo);
	}

	/* �Խñ� ����
	 * 
	 * 
	 */
	@Override
	public int BoardDelete(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		return dao.BoardDelete(boardIdx);
	}

	
}
