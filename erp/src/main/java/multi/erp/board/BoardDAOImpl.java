package multi.erp.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//mybatis의 핵심클래스를 이용해서 작성
@Repository("boardDao")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	SqlSession sqlSession;
	@Override
	public List<BoardVO> boardList() {
		//select문이 여러개의 결과를 반환할 때 사용
		return sqlSession.selectList("multi.erp.board.listall");//mapper에 등록한 sql문 id(namespace포함)
	}

	@Override
	public int insert(BoardVO board) {
		System.out.println("insert board:" + board);
		return sqlSession.insert("multi.erp.board.insert", board);
	}

	@Override
	public List<BoardVO> categorySearch(String category) {
		List<BoardVO> list = sqlSession.selectList("multi.erp.board.categorySearch", category);
		System.out.println(list);
		return list;
	}
	
	//검색어별로 조회 - 동적SQL활용
	@Override
	public List<BoardVO> searchList(String tag, String search) {
		System.out.println("searchList");
		Map<String, String> map = new HashMap<String, String>();
		map.put("tag", tag);
		map.put("search", search);
		return sqlSession.selectList("multi.erp.board.dynamicSearch", map);
	}

	@Override
	public List<BoardVO> pageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO read(String board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String board_no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
