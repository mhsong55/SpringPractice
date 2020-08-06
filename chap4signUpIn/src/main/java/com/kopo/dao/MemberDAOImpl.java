package com.kopo.dao;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.kopo.dto.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String Namespace = "com.kopo.mapper.memberMapper";
	
	@Override
	public int insertMember (MemberVO member) throws Exception {
		/* FROM :memberMapper.xml
		 * Query: 
		 * 
		 * INSERT INTO test1 VALUES
		 * (BINARY(#{id}), BINARY(#{pw}), BINARY(#{name}), BINARY(#{email}), #{phone}) 
		 * 
		 * input id, pw, name and email are case sensitive. */
		return sqlSession.insert (Namespace + ".insert", member);
	}

	@Override
	public int selectCountById(String id) throws Exception {
		/* FROM : memberMapper.xml
		 * Query:
		 * 
		 * SELECT COUNT(id) 
		 *   FROM test1 
		 *  WHERE id = BINARY(#{id})
		 * 
		 * input id is case sensitive. */
		return sqlSession.selectOne (Namespace + ".selectCountById", id);
	}

	@Override
	public int selectCountByIdAndPw(MemberVO user) throws Exception {
		/* FROM : memberMapper.xml
		 * Query:
		 * 
		 * SELECT COUNT(id) 
		 *   FROM test1
		 *  WHERE 
		 * 	      id = BINARY(#{id})
		 *    AND pw = BINARY(#{pw})
		 *    
		 * input id and pw are case sensitive. */
		return sqlSession.selectOne(Namespace + ".selectCountByIdAndPw", user);
	}

	@Override
	public MemberVO selectUserInform(String id) throws Exception {
		/* FROM : memberMapper.xml
		 * Query:
		 * 
		 * SELECT id, name, email. phone
		 *   FROM test1
		 *  WHERE id = BINARY(#{id})
		 *  
		 * input id is case sensitive. */
		return sqlSession.selectOne(Namespace + ".selectUserInform", id);
	}
	
	
}
