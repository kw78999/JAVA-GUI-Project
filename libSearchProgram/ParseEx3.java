package libSearchProgram;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* Name of the class has to be "Main" only if the class is public. */
public class ParseEx3{
	ParseEx3(){};
	String isbn = "", title = "", author = "",pub = "";
	List<String> isbn1 = new ArrayList<>();
	List<String> title1 = new ArrayList<>();
	List<String> author1 = new ArrayList<>();
	List<String> pub1 = new ArrayList<>();
	
	public ParseEx3(String test) {//url�� ������ �˻��ϴ� ������
		
        String item1 = null;//test�Ű����� �����ڷ� ���ڸ� ���޹����� utf8�� ���ڵ����ִ� Ʈ����ĳġ 
        try {
            item1 = URLEncoder.encode(test, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
		
	        try{
	            // XML �����͸� �о��
	            URL url = new URL("https://www.nl.go.kr/NL/search/openApi/search.do?key=7523f3fb30bc248452fd33d9d66c72ab188d9394ba612470ca200a6cbaffceb3&detailSearch=true&page_size=30&f1=title&v1="
	            			+ item1+"");
	            //http://seoji.nl.go.kr/landingPage/SearchApi.do?cert_key=7523f3fb30bc248452fd33d9d66c72ab188d9394ba612470ca200a6cbaffceb3&result_style=xml&page_no=1&page_size=10&title=%EC%98%88%EC%96%B8%EC%9E%90
	            //
	            
	            
	            InputStream in = url.openStream();
	            
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = factory.newDocumentBuilder();
	            Document doc = db.parse(in);
	            
	            Element el = doc.getDocumentElement();
	            // <item> ~ </item>�� �ϳ��� ���� ��� ����Ʈ�� ����
	            NodeList itemList = el.getElementsByTagName("item");
	            
	            for(int i = 0 ; i < itemList.getLength() ; i++){
	                // <item> ~ </item> ��带 �ϳ��� �о��
	                Node itemNode = itemList.item(i);
	                // <item> ~ </item> ������ �±׵�� ��� ����Ʈ�� ����
	                NodeList subList = itemNode.getChildNodes();
	                
	                // <item> ~ </item> ������ �±׸� �ϳ��� �о�� �ش� �±׿� ��ġ�� ��� ������ ����
	                for(int j = 0 ; j < subList.getLength() ; j++){
	                    Node subNode = subList.item( j);
	                    if(subNode.getNodeName().equals("title_info"))
	                    	title = subNode.getTextContent();
	                    if(subNode.getNodeName().equals("author_info"))
	                    	author = subNode.getTextContent();
	                    if(subNode.getNodeName().equals("pub_info"))
	                    	pub = subNode.getTextContent();
	                    if(subNode.getNodeName().equals("isbn"))
	                        isbn = subNode.getTextContent();
	                }//--���� �ݺ���

	               /* System.out.println("item #" + i);
	                System.out.println("isbn : " + isbn);
	                System.out.println("������ : " + title);
	                System.out.println("���� : " + author);
	                System.out.println("���ǻ� : " + pub);
	                System.out.println("******************");*/
	                
	                isbn1.add(isbn);
	                title1.add(title);
	                author1.add(author);
	                pub1.add(pub);
	                
	                isbn = "";
	                title = "";
	                author = "";
	                pub = "";
	                
	            }//--for
	            
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        
	        
	        
	}
public static void main(String[] args) {
	new ParseEx3();
}
    
}