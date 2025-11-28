package com.sist.dao;
// Mapper 구현
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	// 구현
	/*
	 * @Select("SELECT no, name, subject, TO_CHAR(regdate,'YYYY-MM-DD') as dbday, hit "
			+ "FROM springDataBoard ORDER BY no DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 10 ROWS ONLY")
	//         => mySql : limit #{start}, 10
	//         => TO_CHAR(regdate,'YYYY-MM-DD') : DATE_FORMAT('%y-%M-%d')
	public List<DataBoardVO> databoardListData(int start);	
	 */
	public List<DataBoardVO> databoardListData(int start){
		return mapper.databoardListData(start);
	}
	/*
	 * @Select("SELECT COUNT(*) FROM springDataBoard")
	public int databoardRowCount()
	 */
	public int databoardRowCount() {
		return mapper.databoardRowCount();
	}
	
	/*
	 * @Insert("INSERT INTO springDataBoard VALUES("
				+ "sdb_no_seq.nextval, #{name}, #{subject}, #{content}, #{pwd}, SYSDATE, 0, #{filename}, #{filesize}, #{filecount})")
		public void databoardInsert(DataBoardVO vo);
	 */
	public void databoardInsert(DataBoardVO vo) {
		mapper.databoardInsert(vo);
	}
	
	/*
	 * @Update("UPDATE springDataBoard SET "
				+ "hit=hit+1 "
				+ "WHERE no=#{no}")
		public void hitIncrement(int no);
		@Select("SELECT no, name, subject, content, hit, filename, filesize, filecount,"
				+ "To_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') as dbday "
				+ "FROM springDataBoard "
				+ "WHERE no=#{no}")
		public DataBoardVO databoardDetailData(int no);
	 */
	public DataBoardVO databoardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
	
	/*
	 * @Select("SELECT filename, filesize, filecount "
				+ "FROM springDataBoard "
				+ "WHERE no=#{no}")
		// 파일 정보
		public DataBoardVO databoardFileInfoData(int no);	
		@Select("SELECT pwd FROM springDataBoard "
				+ "WHERE no=#{no}")
		public String databoardGetPassword(int no);
		@Delete("DELETE FROM springDataBoard "
				+ "WHERE no=#{no}")
		public void databoardDelete(int no);
	 */
	public DataBoardVO databoardFileInfoData(int no) {
		return mapper.databoardFileInfoData(no);
	}
	public String databoardGetPassword(int no) {
		return mapper.databoardGetPassword(no);
	}
	public void databoardDelete(int no) {
		mapper.databoardDelete(no);
	}
	
	public DataBoardVO databoardUpdateData(int no) {
		return mapper.databoardDetailData(no);
	}
	
	/*
	 * @Update("UPDATE springDataBoard SET "
				+ "name=#{name}, subject=#{subject}, content=#{content} "
				+ "WHERE no=#{no}")
		public void databoardUpdate(DataBoardVO vo);
	 */
	public void databoardUpdate(DataBoardVO vo) {
		mapper.databoardUpdate(vo);
	}
}
