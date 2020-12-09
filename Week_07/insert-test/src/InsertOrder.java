import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertOrder {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("开始插入数据");
        //  10w 执行时间： 239770
//        insertBatch();


        // 100w 执行时间：448193
        insert();
        System.out.println("执行结束");

    }

    private static void insertBatch() throws ClassNotFoundException, SQLException {
        long start = System.currentTimeMillis();
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //定义连接信息
        String url = "jdbc:mysql://127.0.0.1:3306/mail";
        String user = "root";
        String password = "";

        Connection connection = null;
        Statement statement = null;
        try {
            //获取数据库连接对象
            connection = DriverManager.getConnection(url, user, password);
            //通过connection获取操作类
            statement = connection.createStatement();
            //使用 Statement批处理
            String beginTime = "2020-01-01 00:00:00";
            String endTime = "2020-12-31 23:59:59";
            for (int i = 1; i <= 100000; i++) {
                Date date = randomDate(beginTime, endTime);
                Timestamp timeStamp = new Timestamp(date.getTime());
                String sql = "insert into t_order (order_id,user_id,`state`,create_time) " +
                        "values(" + i + "," + "'" + random(1, 1000) + "',1,'" + timeStamp.toString() + "'" +
                        ")";
                statement.addBatch(sql);
            }
            statement.executeBatch();
            statement.clearBatch();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭连接资源
            statement.close();
            connection.close();
        }
        System.out.println("执行时间：" + (System.currentTimeMillis() - start));
    }

    private static void insert() throws ClassNotFoundException, SQLException {
        long start = System.currentTimeMillis();
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //定义连接信息
        String url = "jdbc:mysql://127.0.0.1:3306/mail";
        String user = "root";
        String password = "";

        Connection connection = null;
        Statement statement = null;
        try {
            //获取数据库连接对象
            connection = DriverManager.getConnection(url, user, password);
            //通过connection获取操作类
            statement = connection.createStatement();

            String beginTime = "2020-01-01 00:00:00";
            String endTime = "2020-12-31 23:59:59";
            for (int i = 1; i <= 100000; i++) {
                Date date = randomDate(beginTime, endTime);
                Timestamp timeStamp = new Timestamp(date.getTime());
                String sql = "insert into t_order (order_id,user_id,`state`,create_time) " +
                        "values(" + i + "," + "'" + random(1, 1000) + "',1,'" + timeStamp.toString() + "'" +
                        ")";
                statement.execute(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭连接资源
            statement.close();
            connection.close();
        }
        System.out.println("执行时间：" + (System.currentTimeMillis() - start));
    }

    private static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    private static BigDecimal makeRandomF(float max, float min, int scale) {
        BigDecimal cha = new BigDecimal(Math.random() * (max - min) + min);
        return cha.setScale(scale, BigDecimal.ROUND_HALF_UP);//保留 scale 位小数，并四舍五入
    }

}