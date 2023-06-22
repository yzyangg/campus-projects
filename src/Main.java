import com.yzy.dao.StudentDao;
import com.yzy.entity.Student;
import com.yzy.service.StudentDaoImpl;
import com.yzy.util.JDBCUtil;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Connection connection = JDBCUtil.getConnection();
        System.out.println(connection);
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.selectAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}