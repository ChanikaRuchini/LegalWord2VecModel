import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CorpusTrainer {

    private static Logger log = LoggerFactory.getLogger(CorpusTrainer.class);
    private static DBConnection dbconnection = null;

    public static void main(String[] args) throws Exception {

        try {
            dbconnection =DBConnection.getDBConnection();
        } catch (ClassNotFoundException ex) {
            log.error(ex.getMessage());
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        PrintWriter writer = new PrintWriter("C:\\Users\\User\\Desktop\\textCorpus.txt", "UTF-8");
        getCases(writer);
        writer.close();
    }

    public static String getCases(PrintWriter writer) {
        ResultSet rs = null;
        String str="SELECT content FROM cases";
        try {
            rs = DBAccess.getData(dbconnection.getConnectionToDB(),str);
            while (rs.next()){
                try {
                    String content =rs.getString("content");

                    WriteToFile(content, writer);
                } catch (SQLException ex) {
                    log.error(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }

    public static void WriteToFile(String text, PrintWriter writer){
        writer.append(text);
    }

}
