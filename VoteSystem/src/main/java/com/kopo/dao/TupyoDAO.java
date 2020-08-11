package com.kopo.dao;

import com.kopo.dto.TupyoDTO;

public interface TupyoDAO {
	
	public int insertTupyo(TupyoDTO Tupyo) throws Exception;
	
	public int selectOneCountTupyoById(int id) throws Exception;
	
	public int selectAllCountTupyo() throws Exception;
}
