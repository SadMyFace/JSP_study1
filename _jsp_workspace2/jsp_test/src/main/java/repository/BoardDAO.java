package repository;

import java.util.List;

import domain.BoardVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> getList();

	int countUp(int bno);

	BoardVO findBoard(int bno);

	int edit(BoardVO bvo);

	int remove(int bno);

	List<BoardVO> myList(String writer);


}
