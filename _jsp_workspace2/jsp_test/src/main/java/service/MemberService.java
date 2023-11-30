package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO mvo);

	int register(MemberVO mvo);

	int logout(MemberVO mvo);

	int modify(MemberVO mvo);

	List<MemberVO> getList();

	int remove(MemberVO mvo);

}
