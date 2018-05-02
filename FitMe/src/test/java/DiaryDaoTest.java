/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fitme.dao.DataDiaryDao;
import fitme.dao.DataUserDao;
import fitme.dao.Database;
import fitme.domain.Diary;
import fitme.domain.DiaryService;
import fitme.domain.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author svsv
 */
public class DiaryDaoTest {

    Database database;
    DataUserDao userDao;
    DataDiaryDao diaryDao;
    DiaryService diaryService;
    User testUser;
    Diary testDiary;

    public DiaryDaoTest() throws FileNotFoundException, IOException, ClassNotFoundException, Exception {
//        Properties properties = new Properties();
//        properties.load(new FileInputStream("config.properties"));
//        String usedDatabase = properties.getProperty("usedDatabase");
//          database = new Database(usedDatabase);

        database = new Database("jdbc:sqlite:fitme.db");
     
        userDao = new DataUserDao(database);
        diaryDao = new DataDiaryDao(database); 
        diaryService=new DiaryService(diaryDao, userDao);
        
    
        testUser = new User("testJokke", "testJorma"); 
        userDao.saveOrUpdate(testUser);
        testDiary = new Diary(1,"27.04.2018", "Moi", 200, testUser);
//        diaryDao.saveOrUpdate(testDiary);
        diaryDao.delete("100");
        diaryService.delete("100");
        diaryService.delete("99");
        diaryService.delete("98");
        diaryService.delete("97");
        diaryService.delete("96");
//        userDao.delete("testJokke");
        
//       diary2 = new Diary(2, "Heippa", 400);
    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
    @After
    public void tearDown() {


    }

    @Test
    public void saveOrUpdateReturnsNullIf() throws SQLException {
       
//                        Connection connection = database.getConnection();
//                
//                        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Diary"
//                                + " (user_username, day, content, kcal)" //id lisäys?
//                                + " VALUES (?, ?, ?, ?)");  //(?, CURRENT_TIMESTAMP. ?)
//                
//                        stmt.setObject(1, testDiary.getUser().getUsername());
//                        stmt.setString(2, testDiary.getday());
//                        stmt.setString(3, testDiary.getContent());
//                        stmt.setInt(4, testDiary.getKcal());
//                
//                        stmt.executeUpdate();

//            Connection connection = database.getConnection();
//            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Diary WHERE id = ?")) {
//            stmt.setString(1, "testJokke");
//
//            ResultSet rs = stmt.executeQuery();
////
////     
//
////           diaryDao.saveOrUpdate(testDiary);
//           
//            System.out.println("testaa" + testDiary.getContent());
//           
//            String content=rs.getString("content");
//            System.out.println("testaa2" + content);
//           
            assertEquals(null, diaryDao.saveOrUpdate(testDiary));
//            assertEquals(testDiary, diaryDao.saveOrUpdate(testDiary));
//            stmt.close();
//            connection.close();
        }
    
        @Test
    public void saveOrUpdateReturnsDiary() throws SQLException {
       
//           
            assertEquals(testDiary, diaryDao.saveOrUpdate(testDiary));
//     
        }
    
    
    
    
    
//        @Test
//    public void createdTodosAreListed() throws Exception {    
//        dao.create(new Todo("lue kokeeseen", new User("testertester", "")));
//        
//        List<Todo> todos = dao.getAll();
//        assertEquals(2, todos.size());
//        Todo todo = todos.get(1);
//        assertEquals("lue kokeeseen", todo.getContent());
//        assertFalse(todo.isDone());
//        assertNotEquals(1, todo.getId());
//        assertEquals("testertester", todo.getUser().getUsername());
//    }  
    
//        @Test
//    public void diarysCanBeSeDelete() throws Exception {
////        diaryDao.delete("1");
//        String today="27.04.2018";
//        Diary diary = diaryDao.findDiaryByDate(today).get(0);
//        assertTrue(diary.isDelete());
//    }       
    
    
//
    @Test
    public void findOneDiaryWithGivenUsername() throws SQLException {
        String key = "testJokke";
        diaryDao.saveOrUpdate(testDiary);
//        Connection connection = database.getConnection();
//        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Diary WHERE user_username = ?");
//        stmt.setString(1, key);
//
//        ResultSet rs = stmt.executeQuery();
//
//        Diary diary = new Diary(rs.getInt("id"), rs.getString("day"), rs.getString("content"), rs.getInt("kcal"),
//                testUser);

        assertEquals("testJokke", diaryDao.findOne(key).getUser().getUsername());
//        stmt.close();
//        rs.close();
//        connection.close();
    }
      }
    
////       @Test
//    public void deleteDeletesGivenDiary() throws SQLException {
//        String key = testDiary.getUser().getUsername();
//        Connection connection = database.getConnection();
//        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Diary WHERE user_username = ?");
//        stmt.setString(1, key);
//
//        ResultSet rs = stmt.executeQuery();
//
//        Diary diary = new Diary(rs.getInt("id"), rs.getString("day"), rs.getString("content"), rs.getInt("kcal"),
//                testUser);
//         String sid = Integer.toString(diary.getId());
////          String sid = Integer.toString(rs.getInt("id"));
//       
////        System.out.println("täää" + key);
////        Connection con = database.getConnection();
////        PreparedStatement stmt = con.prepareStatement("DELETE FROM Diary WHERE id = ?");
////
////        stmt.setString(1, key);
////       
////        stmt.executeUpdate();
//
//        stmt.executeUpdate();
//        System.out.println("dao deleye");
//
//        stmt.close();
//        connection.close();
//
//           assertEquals(true, diaryDao.delete(sid));
//
//    }

    
    
    
    

//  @Test
//    public void findDiaryByDate() throws SQLException {
//        List<Diary> diaries = new ArrayList<>();
//
//        Date todaysDate = new java.sql.Date(System.currentTimeMillis());
//        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
//        String day = df.format(todaysDate);
//
//        Connection connection = database.getConnection();
//    
//        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Diary WHERE user_username = ? AND day = ?"); //day = CURRENT_TIMESTAMP
//
//        stmt.setObject(1, key);
//        stmt.setObject(2, day);
//        ResultSet rs = stmt.executeQuery();
//
//        while (rs.next()) {
//            Diary diary = new Diary(rs.getInt("id"), day, rs.getString("content"), rs.getInt("kcal"));
//            diaries.add(diary);
//        }
////        for (Diary diary : diaries) {
////            System.out.println("test" + diary);
////
////        }
//
//    assertEquals(diary.getContent(), testDiary.getContent()
//        stmt.close();
//        rs.close();
//        connection.close();
//    }

 


    
    
    
    
//
//    @Test
//    public void deleteDeletesDiary() throws SQLException {   
//        assertEquals(true, diaryDao.delete("200"));
//
//    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
//    @Test
//    public void findAllByDateNow() throws SQLException {
//        List<Diary> diaries = new ArrayList<>();
//        Connection connection = database.getConnection();
//        PreparedStatement stmt = connection.prepareStatement("DELETE FROM User WHERE username='testJokke'");
//        stmt.executeUpdate();
//
////   
////        PreparedStatement
////                
//        stmt = connection.prepareStatement("INSERT INTO User(username, name) VALUES(?, ?)");
//
//        stmt.setString(1, testuser.getUsername());
//        stmt.setString(2, testuser.getName());
//
//        stmt.executeUpdate();
//
//        Date todaysDate = new java.sql.Date(System.currentTimeMillis());
//        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
//        String today = df.format(todaysDate);
//
//        testDiary = new Diary(5, today, "Moikka", 200, testuser);
//        //(int id, Date dSay, String content, int kcal, User user)
//
//        stmt = connection.prepareStatement("SELECT * FROM Diary WHERE day=CURRENT_TIMESTAMP AND user_username = 'testJokke'"); //ja pvm=sama..??..
//
//        ResultSet rs = stmt.executeQuery();
//        while (rs.next()) {
//            Diary diary = new Diary(rs.getInt("id"), rs.getString("content"), rs.getInt("kcal"));
//
//            diaries.add(diary);
//            //rs.getInt("id"),
//
//            // now diary markings on list
//            System.out.println(diaries);
//
//            assertEquals(diaries.get(rs.getInt("id")).getday(), testDiary.getday());
////        assertEquals("testLiisa", testuser.getName());
////        Connection connection = database.getConnection();
//            stmt = connection.prepareStatement("DELETE FROM User WHERE username='testJokke'");
//            stmt.executeUpdate();
//        }
//        stmt.close();
//        rs.close();
//        connection.close();
//
//    }
//
//    @Test
//    public void findAllFindsAllFromDatabase() throws SQLException {
//        List<Diary> diaries = new ArrayList<>();
//
//        Connection connection = database.getConnection();
//
//        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Diary WHERE user_username = 'testJokke'");
////        stmt.setObject(1, key);
//        ResultSet rs = stmt.executeQuery();
//        while (rs.next()) {
//            Diary diary = new Diary(rs.getInt("id"), rs.getString("content"), rs.getInt("kcal"));
//
//            diaries.add(diary);
//        } //rs.getInt("id"),
//
//        stmt.close();
//        rs.close();
//        connection.close();
//       
//         assertEquals(diaries.get(0), diaryDao.findAll().diaries.get(0));
//         
//        stmt.close();
//        rs.close();
//        connection.close(); 
//    }
//    @Test
//    public Diary findOne(String key) throws SQLException {  //on diary marking
//        System.out.println("key" + key);
//        Connection connection = database.getConnection();
//        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Diary WHERE id = ?");
//        stmt.setString(1, key);
//
//        ResultSet rs = stmt.executeQuery();
//        boolean hasOne = rs.next();
//        if (!hasOne) {
//            return null;
//        }
//        User user = userDao.findByUsername(rs.getString("user_username"));
//
//        Diary diary = new Diary(rs.getInt("id"), rs.getDate("day"), rs.getString("content"), rs.getInt("kcal"),
//                user); /////////////////////////////////////////DELETE??????????????
////      (int id, String content, Date Day, boolean delete, User user) {
////    }
//        //public Diary(int id, Date Day, String content, int kcal, User user) {
//        stmt.close();
//        rs.close();
//        connection.close();
//
//        return diary;
//    }

