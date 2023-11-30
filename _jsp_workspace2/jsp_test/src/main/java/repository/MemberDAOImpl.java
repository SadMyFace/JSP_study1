package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private SqlSession sql;
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		// TODO Auto-generated method stub
		log.info(">>> login check 3");
		return sql.selectOne("MemberMapper.login", mvo);
	}

	@Override
	public int register(MemberVO mvo) {
		// TODO Auto-generated method stub
		log.info(">>> register check 3");
		
		int isOk = sql.insert("MemberMapper.register", mvo);
		
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int logout(MemberVO mvo) {
		// TODO Auto-generated method stub
		log.info(">>> logout check 3");
		
		int isOk = sql.update("MemberMapper.logout", mvo);
		
		if(isOk > 0) {
			sql.commit();
		}
		
		return isOk;
	}

	@Override
	public int modify(MemberVO mvo) {
		// TODO Auto-generated method stub
		log.info(">>> modify check 3");
		
		int isOk = sql.update("MemberMapper.modify", mvo);
		
		if(isOk > 0) {
			sql.commit();
		}
		
		return isOk;
	}

	@Override
	public List<MemberVO> getList() {
		// TODO Auto-generated method stub
		log.info(">>> list check 3");
		return sql.selectList("MemberMapper.getList");
	}

	@Override
	public int remove(MemberVO mvo) {
		// TODO Auto-generated method stub
		log.info(">>> remove check 3");
		
		int isOk = sql.delete("MemberMapper.remove", mvo);
		
		if(isOk > 0) {
			sql.commit();
		}
		
		return isOk;
	}
	
}
