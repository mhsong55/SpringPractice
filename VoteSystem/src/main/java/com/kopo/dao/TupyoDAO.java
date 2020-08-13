package com.kopo.dao;

import com.kopo.dto.TupyoDTO;
import java.util.*;

public interface TupyoDAO {
	
	public int insertTupyo(TupyoDTO Tupyo) throws Exception;
	
	public int selectOneCountTupyoById(int id) throws Exception;
	
	public int selectAllCountTupyo() throws Exception;
	
	public List<Integer> selectAgeTupyoWhereIdGroupByAge(int id) throws Exception;
	
	public List<Integer> selectCountTupyoWhereIdGroupByAge(int id) throws Exception;

}
