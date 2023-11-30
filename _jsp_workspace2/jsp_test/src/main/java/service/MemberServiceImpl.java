package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	
	private static final Logger log = LoggerFactory.getLogger(MemberService.class);
	
	private MemberDAO mdao;
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		// TODO Auto-generated method stub
		log.info(">>> login check 2");
		return mdao.login(mvo);
	}

	@Override
	public int register(MemberVO mvo) {
		// TODO Auto-generated method stub
		log.info(">>> register check 2");
		return mdao.register(mvo);
	}

	@Override
	public int logout(MemberVO mvo) {
		// TODO Auto-generated method stub
		log.info(">>> logout check 2");
		return mdao.logout(mvo);
	}

	@Override
	public int modify(MemberVO mvo) {
		// TODO Auto-generated method stub
		log.info(">>> modify check 2");
		return mdao.modify(mvo);
	}

	@Override
	public List<MemberVO> getList() {
		// TODO Auto-generated method stub
		log.info(">>> list check 2");
		return mdao.getList();
	}

	@Override
	public int remove(MemberVO mvo) {
		// TODO Auto-generated method stub
		log.info(">>> remove check 2");
		return mdao.remove(mvo);
	}

}
