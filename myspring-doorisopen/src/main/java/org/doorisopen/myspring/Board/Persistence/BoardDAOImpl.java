package org.doorisopen.myspring.Board.Persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Board.Domain.ReplyVO;
import org.doorisopen.myspring.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace ="org.doorisopen.myspring.Board.BoardMapper";
	private static final String reply_namespace ="org.doorisopen.myspring.Board.ReplyMapper";
	
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
	
	/* �Խñ� ��� �� ����
	 * 
	 * 
	 */
	@Override
	public void BoardReplyCntUpdate(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".BoardReplyCntUpdate", vo);
	}

	
	/* *****************************
	 *           REPLY
	 *          
	 *******************************/
	
	/* ��� ����Ʈ
	 * 
	 * 
	 */
	@Override
	public List<ReplyVO> ReplyRead(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(reply_namespace + ".ReplyRead", boardIdx);
	}
	
	/* ��� ���
	 * 
	 * 
	 */
	@Override
	public int ReplyCreate(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(reply_namespace + ".ReplyCreate", vo);
	}
	
	/* ��� ����
	 * 
	 * 
	 */
	@Override
	public int ReplyUpdate(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(reply_namespace + ".ReplyUpdate", vo);
	}
	
	/* ��� ����
	 * 
	 * 
	 */
	@Override
	public int ReplyDelete(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(reply_namespace + ".ReplyDelete", vo);
	}

	
	/* *****************************
	 *        REPLY TO REPLY
	 *          
	 *******************************/
	
	/* ���� ����Ʈ
	 * 
	 * 
	 */
	@Override
	public List<ReplyVO> replyToReplyRead(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(reply_namespace + ".replyToReplyRead", boardIdx);
	}
	
	
	/* ���� ���
	 * 
	 * 
	 */
	@Override
	public int replyToReplyCreate(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(reply_namespace + ".replyToReplyCreate", vo);
	}
	
	
	/* ���� ����
	 * 
	 * 
	 */
	@Override
	public int replyToReplyUpdate(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(reply_namespace + ".replyToReplyUpdate", vo);
	}
	

	/* ���� ����
	 * 
	 * 
	 */
	@Override
	public int replyToReplyDelete(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(reply_namespace + ".replyToReplyDelete", vo);
	}
}
