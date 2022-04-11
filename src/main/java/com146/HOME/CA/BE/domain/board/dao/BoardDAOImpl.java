package com146.HOME.CA.BE.domain.board.dao;

import com146.HOME.CA.BE.domain.board.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {

    private final JdbcTemplate jdbcTemplate;

    /**
     * 게시글 작성 > 등록
     * @param board 게시글
     * @return 게시글 시퀀스(boardNum)
     */
    @Override
    public Long insertBoard(Board board) {

        StringBuffer sql = new StringBuffer();
        sql.append(" insert into board ( ");
        sql.append(" board_num, ");
        sql.append(" cate_num, ");
        sql.append(" board_title, ");
        sql.append(" member_num, ");
        sql.append(" nickname, ");
        sql.append(" board_content, ");
        sql.append(" from_recipe, ");
        sql.append(" board_map_address) ");
//        이미지 첨부 오류 나서 잠시 주석처리
//        sql.append(" board_picture) ");
        sql.append(" values(board_board_num_seq.nextval,?,?,?,?,?,?,?) ");

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(sql.toString(), new String[]{"board_num"});
                pstmt.setInt(1,board.getCateNum());
                pstmt.setString(2, board.getBoardTitle());
                pstmt.setLong(3, board.getMemberNum());
                pstmt.setString(4, board.getNickname());
                pstmt.setString(5, board.getBoardContent());
                pstmt.setString(6, board.getFromRecipe());
                pstmt.setString(7, board.getBoardMapAddress());
//                이미지가 다수 첨부될 수 있어 bytes 사용.
//                pstmt.setBytes(8, board.getBoardPicture());
                return pstmt;
            }
        },keyHolder);

        return Long.valueOf(keyHolder.getKeys().get("board_num").toString());
    }

    /**
     * 본문 상세 조회
     * @param boardNum 게시글 시퀀스
     * @return 게시글 상세페이지
     */
    @Override
    public Board selectByBoardNum(Long boardNum) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("  board_num, ");
        sql.append("  cate_num, ");
        sql.append("  board_title, ");
        sql.append("  member_num, ");
        sql.append("  nickname, ");
        sql.append("  board_date, ");
        sql.append("  board_hit, ");
        sql.append("  board_content, ");
        sql.append(" from_recipe, ");
        sql.append("  board_map_address ");
        sql.append(" FROM ");
        sql.append("  BOARD ");
        sql.append("where board_num = ?  ");

        Board boardItem = null;
        try {
            boardItem = jdbcTemplate.queryForObject(
                    sql.toString(),
                    new BeanPropertyRowMapper<>(Board.class),
                    boardNum);
        }catch (Exception e){ // 1건을 못찾으면
            boardItem = null;
        }

        return boardItem;
    }

    /** 게시글 수정
     *
     * @param boardNum 게시글 시퀀스
     * @param board 덮어 쓸(수정) 게시물 내용
     * @return 수정 성공 1
     */
    @Override
    public int updateByBoardNum(Long boardNum, Board board) {

        StringBuffer sql = new StringBuffer();
        sql.append(" update board ");
        sql.append("   SET cate_num = ?, ");
        sql.append("       board_title = ?, ");
        sql.append("       board_content = ?, ");
        sql.append("       from_recipe = ? , ");
        sql.append("       board_map_address = ?, ");
        sql.append("       board_date = systimestamp ");
        sql.append(" WHERE board_num = ? ");

        int updatedItemCount = jdbcTemplate.update(
                sql.toString(),
                board.getCateNum(),
                board.getBoardTitle(),
                board.getBoardContent(),
                board.getFromRecipe(),
                board.getBoardMapAddress(),
                boardNum
        );

        return updatedItemCount;
    }

    /**
     * 게시물 삭제
     * @param boardNum 게시물 시퀀스
     * @return 삭제 성공 횟수 1
     */
    @Override
    public int deleteByBoardNum(Long boardNum) {
        String sql = " delete from board where board_num = ? ";
        int deleteCnt = jdbcTemplate.update(sql, boardNum);

        return deleteCnt;
    }

    /**
     * 조회수 증가
     * @param boardNum 게시물 시퀀스
     * @return 해당 게시물 조회수 +1
     */
    @Override
    public int increaseHit(Long boardNum) {
        StringBuffer sql = new StringBuffer();
        sql.append(" UPDATE board ");
        sql.append(" SET board_hit = board_hit+1 ");
        sql.append(" WHERE board_num = ? ");

        int updateHit = jdbcTemplate.update(sql.toString(), boardNum);
        return updateHit;
    }

    /**
     * 페이징 적용한 카테고리별 게시판 목록
     * @param cateNum 게시판 분류
     * @param startRec 시작 레코드
     * @param endRec 마지막 레코드
     * @return 목록
     */
    @Override
    public List<Board> selectBoard(int cateNum, int startRec, int endRec) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select t1.* from( ");
        sql.append("     SELECT ROW_NUMBER() OVER (ORDER BY board_num desc) no, ");
        sql.append("     board_num, ");
        sql.append("     cate_num, ");
        sql.append("     board_title, ");
        sql.append("     member_num, ");
        sql.append("     nickname, ");
        sql.append("     board_hit, ");
        sql.append("     board_date ");
        sql.append("     FROM ");
        sql.append("     board ");
        sql.append("     where cate_num = ? ) t1 ");
        sql.append(" where t1.no between ? and ? ");

        List<Board> list = jdbcTemplate.query(
                sql.toString(),
                new BeanPropertyRowMapper<>(Board.class),
                cateNum, startRec, endRec
        );
        return list;
    }

    /**
     * 검색 전체건수
     * @param filterCondition
     * @return
     */
    @Override
    public int totalCount(BoardFilterCondition filterCondition) {
        StringBuffer sql = new StringBuffer();

        sql.append("select count(*) ");
        sql.append("  from board  ");
        sql.append(" where  ");

        return 0;
    }

    /**
     * 카테고리별 게시물 총 개수
     * @param cateNum 카테고리
     * @return 해당 게시판 총 게시물 수
     */
    @Override
    public int totalCount(int cateNum) {
        String sql = " select count(*) from board where cate_num = ? ";

        Integer itemCnt = 0;
        try {
            itemCnt = jdbcTemplate.queryForObject(sql, Integer.class, cateNum);
        }catch (Exception e){
            itemCnt = 0;
        }
        return itemCnt;
    }


    /**
     * 댓글 작성
     * @param board
     * @return 댓글 번호
     */
    @Override
    public Long insertReply(Board board) {
        StringBuffer sql = new StringBuffer();
        sql.append(" INSERT INTO reply ( ");
        sql.append("     reply_num, ");
        sql.append("     board_num, ");
        sql.append("     member_num, ");
        sql.append("     nickname, ");
        sql.append("     reply_date, ");
        sql.append("     reply_content, ");
        sql.append("     reply_group, ");
        sql.append("     reply_step, ");
        sql.append("     reply_indent, ");
        sql.append("     preply_num ");
        sql.append(" ) VALUES ( ");
        sql.append("     Reply_reply_num_SEQ.nextval, ");
        sql.append("     ?, ");
        sql.append("     ?, ");
        sql.append("     ?, ");
        sql.append("     ?, ");
        sql.append("     ?, ");
        sql.append("     ?, ");
        sql.append("     ?, ");
        sql.append("     ?, ");
        sql.append("     ? ) ");

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(sql.toString(), new String[]{"reply_num"});
                pstmt.setLong(1, board.getBoardNum());
                pstmt.setLong(2, board.getMemberNum());
                pstmt.setString(3, board.getNickname());
                pstmt.setDate(4, Date.valueOf(board.getReplyDate()));
                pstmt.setString(5, board.getReplyContent());
                pstmt.setInt(6, board.getReplyGroup());
                pstmt.setInt(7, board.getReplyStep());
                pstmt.setInt(8, board.getReplyIndent());
                pstmt.setInt(9, board.getPreplyNum());

                return pstmt;
            }
        }, keyHolder);

//      댓글 번호를 반환.
        return Long.valueOf(keyHolder.getKeys().get("reply_num").toString());
    }

    /**
     * 댓글 조회
     * @param boardNum
     * @param startRec
     * @param endRec
     * @return
     */
    @Override
    public List<Board> replyList(long boardNum, int startRec, int endRec) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select ");
        sql.append("     r.reply_num, ");
        sql.append("     r.board_num, ");
        sql.append("     r.reply_content, ");
        sql.append("     r.reply_group, ");
        sql.append("     r.reply_step, ");
        sql.append("     r.reply_indent, ");
        sql.append("     r.preply_num, ");
        sql.append("     m.nickname ");
        sql.append("   FROM reply r inner join member m ");
        sql.append("     on r.member_num = m.member_num ");
        sql.append("     where r.board_num = ?  ");

        List<Board> list = jdbcTemplate.query(
                sql.toString(),
                new BeanPropertyRowMapper<>(Board.class),
                boardNum, startRec, endRec
        );
        return list;
    }

    /**
     * 댓글 수정
     * @param replyNum
     * @param board
     * @return
     */
    @Override
    public int updateReply(Long replyNum, Board board) {
        StringBuffer sql = new StringBuffer();
        sql.append(" UPDATE reply ");
        sql.append(" SET ");
        sql.append("     reply_content = ? ");
        sql.append(" WHERE reply_num = ? ");

        int updateCnt = jdbcTemplate.update(sql.toString(),
                board.getReplyContent(),
                replyNum
        );
//    성공했으면 1 반환
        return updateCnt;
    }

    /**
     * 댓글 삭제
     * @param replyNum
     * @return
     */
    @Override
    public int deleteReply(Long replyNum) {
        String sql = " delete from reply where reply_num = ? ";
        int deleteCnt = jdbcTemplate.update(sql, replyNum);

        return deleteCnt;
    }

    /**
     * 검색
     * @param filterCondition
     * @return
     */
    @Override
    public List<Board> findAll(BoardFilterCondition filterCondition) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT t1.*");
        sql.append("from( ");
        sql.append("  SELECT ");
        sql.append("  ROW_NUMBER() OVER(Order by board_num desc) no, ");
        sql.append("  board_num, ");
        sql.append("  cate_code, ");
        sql.append("  board_title, ");
        sql.append("  member_num, ");
        sql.append("  nickname, ");
        sql.append("  board_date, ");
        sql.append("  board_hit, ");
        sql.append("  board_content, ");
        sql.append("  board_map_address ");
        sql.append(" FROM ");
        sql.append("  BOARD ");
        sql.append("     WHERE ");

        return null;
    }


}
