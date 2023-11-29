package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	private SqlSession sql;
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(BoardVO bvo) {
		// TODO Auto-generated method stub
		log.info(">>> insert check 3");
		
		int isOk = sql.insert("BoardMapper.write", bvo);
		
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		log.info(">>> list check 3");
		return sql.selectList("BoardMapper.list");
	}

	@Override
	public int countUp(int bno) {
		// TODO Auto-generated method stub
		log.info(">>> count check 3");
		int isOk = sql.insert("BoardMapper.readCountUp", bno);
		
		if(isOk > 0) {
			sql.commit();
		}	
		
		return isOk;
	}

	@Override
	public BoardVO findBoard(int bno) {
		// TODO Auto-generated method stub
		log.info(">>> find check 3");
		return sql.selectOne("BoardMapper.find", bno);
	}

	@Override
	public int edit(BoardVO bvo) {
		// TODO Auto-generated method stub
		log.info(">>> edit check 3");
		
		int isOk = sql.update("BoardMapper.edit", bvo);
		
		return isOk;
	}

	@Override
	public int remove(int bno) {
		// TODO Auto-generated method stub
		log.info(">>> remove check 3");
		
		int isOk = sql.delete("BoardMapper.remove", bno);
		
		if(isOk > 0) {
			sql.commit();
		}
		
		return isOk;
	}

	
}
