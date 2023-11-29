package service;

import java.util.List;

import domain.BoardVO;

public interface BoardService {

	int insert(BoardVO bvo);

	List<BoardVO> getList();

	int countUp(int bno);

	BoardVO findBoard(int bno);

	int edit(BoardVO bvo);

	int remove(int bno);

	
}
