package com.kopo.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.kopo.dao.MemberDAO;
import com.kopo.dto.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	@Override
	public int insertMember(MemberVO member) throws Exception {
		String digestTargetString = member.getPw();
		member.setPw(digest(digestTargetString));
		
		return dao.insertMember(member);
	}
	
	
	/* ID duplication check method
	 * count the input id from DB
	 * @param: (String) id
	 * @return: (boolean) true if count number > 0
	 * 		   else (boolean) false
	 * */
	@Override
	public boolean isDuplicatedID(String id) throws Exception {
		int selectCountById = dao.selectCountById(id);
		if (selectCountById > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/* Method to encrypt password
	 * @param: (String) password
	 * @return: (String) Encrypted password
	 * */
	@Override
	public String digest(String target) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		messageDigest.update(target.getBytes());
		return String.format("%064x", new BigInteger(1, messageDigest.digest()));
	}
}
