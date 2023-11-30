package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}

	@Override
	public int insert(BoardVO bvo) {
		// TODO Auto-generated method stub
		log.info(">>> insert check 2");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		log.info(">>> list check 2");
		return bdao.getList();
	}

	@Override
	public int countUp(int bno) {
		// TODO Auto-generated method stub
		log.info(">>> count check 2");
		return bdao.countUp(bno);
	}

	@Override
	public BoardVO findBoard(int bno) {
		// TODO Auto-generated method stub
		log.info(">>> find check 2");
		return bdao.findBoard(bno);
	}

	@Override
	public int edit(BoardVO bvo) {
		// TODO Auto-generated method stub
		log.info(">>> edit check 2");
		return bdao.edit(bvo);
	}

	@Override
	public int remove(int bno) {
		// TODO Auto-generated method stub
		log.info(">>> remove check 2");
		return bdao.remove(bno);
	}

	@Override
	public List<BoardVO> myList(String writer) {
		// TODO Auto-generated method stub
		log.info(">>> myList check 2");
		return bdao.myList(writer);
	}


	
}
