package org.doorisopen.myspring.Board.Persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace ="org.doorisopen.myspring.Board.BoardMapper";
	
	/* �Խñ� �ۼ�
	 * 
	 * 
	 */
	@Override
	public int BoardCreate(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + ".BoardCreate", vo);
	}

	/* �Խñ� ����Ʈ
	 * 
	 * 
	 */
	@Override
	public List<BoardVO> BoardRead(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		List<BoardVO> BoardRead = new ArrayList<BoardVO>();
		BoardRead = sqlSession.selectList(namespace + ".BoardRead", pagination);
		return BoardRead;
	}
	
	/* ��ü �Խñ� ���� Ȯ��
	 * 
	 * 
	 */
	@Override
	public int getBoardListCnt() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getBoardListCnt");
	}
	
	/* �Խñ� ��
	 * 
	 * 
	 */
	@Override
	public BoardVO BoardDetail(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		BoardVO vo = sqlSession.selectOne(namespace + ".BoardDetail", boardIdx);
		
		return vo;
	}

	/* �Խñ� ����
	 * 
	 * 
	 */
	@Override
	public int BoardUpdate(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + ".BoardUpdate", vo);
	}

	/* �Խñ� ����
	 * 
	 * 
	 */
	@Override
	public int BoardDelete(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + ".BoardDelete", boardIdx);
	}

	/* �Խñ� ��ȸ�� ����
	 * 
	 * 
	 */
	@Override
	public void BoardViewCntUpdate(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".BoardViewCntUpdate", boardIdx);
	}


}
