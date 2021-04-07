package libSearchProgram;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
 
public class EncordTest {
    public static void main(String[] args) {
        String item1 = null;
        try {
            item1 = URLEncoder.encode("한글 인코딩 이라네~", "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
 
        System.out.println(item1);
    }
}