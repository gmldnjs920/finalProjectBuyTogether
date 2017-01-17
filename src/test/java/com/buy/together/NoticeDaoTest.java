package com.buy.together;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.buy.together.dao.NoticeDao;
import com.buy.together.domain.Board;
import com.buy.together.domain.MyCriteria;
import com.buy.together.dto.BoardDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class NoticeDaoTest {

   @Inject
   NoticeDao noticeDao;
   
   @Test
   public void testNoticeInsert() throws Exception {
      
      Board board = new Board();
      
      board.setBoard_number(3);
      board.setBoard_title("제목입니다");
      board.setBoard_content("내용입니다");
      board.setAdmin_number(1);
      String from = "2016-12-25 10:10:10";
       SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date to = transFormat.parse(from);
      board.setBoard_writeDate(to);

      noticeDao.noticeInsert(board);
      
   }
   
   @Test
   public void noticeListAll() throws Exception {
      
      MyCriteria myCriteria = new MyCriteria();
      
      List<BoardDTO> list = noticeDao.noticeListAll(myCriteria);

      if (list == null) {
         
         System.out.println("없다");
         
      }

      for (BoardDTO board : list) {
         
         System.out.println(board.getBoard_number() + "\t" + board.getBoard_title() + "\t" + board.getAdmin_nickname() + "\t"
               + board.getBoard_writeDate());
         
      }
      
   }
   
   @Test
   public void testDelete() throws Exception {
      
      int bno = 3;
      noticeDao.noticeDelete(bno);

   }
   
   @Test
   public void noticeListOne() throws Exception{
      
      int bno = 1;
      
      BoardDTO board = noticeDao.noticeListOne(bno);
      
      System.out.print(board.getBoard_number() + "\t");
      System.out.print(board.getBoard_title() + "\t");
      System.out.print(board.getBoard_content() + "\t");
      System.out.print(board.getAdmin_nickname() + "\t");
      System.out.print(board.getBoard_writeDate() + "\t");

   }
   
}