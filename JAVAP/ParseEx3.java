package JAVAP;
import java.io.InputStream;
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
	
	String isbn = "", title = "", author = "",pub = "";
	List<String> isbn1 = new ArrayList<>();
	List<String> title1 = new ArrayList<>();
	List<String> author1 = new ArrayList<>();
	List<String> pub1 = new ArrayList<>();
	String TITLE_encoding;
	String ISBN;
	String AUTHOR_encoding;
	
	public ParseEx3() {};            //����Ʈ ������
	
	public ParseEx3(String TITLE,String AUTHOR,String ISBN) {           //�������� �˻��ϱ�
	        try{
	        	TITLE_encoding= URLEncoder.encode(TITLE, "UTF-8");     //�Է¹��� �Ű������� UTF-8�� ���ڵ� �ϱ�
	        	AUTHOR_encoding= URLEncoder.encode(AUTHOR, "UTF-8");     //�Է¹��� �Ű������� UTF-8�� ���ڵ� �ϱ�
	        	
	            // XML �����͸� �о��
	        	URL url= new URL("https://www.nl.go.kr/NL/search/openApi/search.do?"
	     	           +"key=7523f3fb30bc248452fd33d9d66c72ab188d9394ba612470ca200a6cbaffceb3"
	     	           +"&detailSearch=true&page_size=30&f1=title&v1="+TITLE_encoding            //�ּ�â�� Ÿ��Ʋ �Է�
	     	           + "&f2=author&v2="+AUTHOR_encoding                                    //�ּ�â�� �����Է�
	     	           +"&f3=isbn&v3="+ISBN+"");                                                         //�ּ�â�� ISBN �Է� 
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
	                    if(subNode.getNodeName().equals("isbn"))
	                        isbn = subNode.getTextContent();
	                    if(subNode.getNodeName().equals("title_info"))
	                        title = subNode.getTextContent();
	                    if(subNode.getNodeName().equals("author_info"))
	                        author = subNode.getTextContent();
	                    if(subNode.getNodeName().equals("pub_info"))
	                        pub = subNode.getTextContent();
	                }
	                
	                isbn1.add(isbn);
	                title1.add(title);
	                author1.add(author);
	                pub1.add(pub);
	                
	          
	                isbn = "";
	                title = "";
	                author = "";
	                pub = "";
	                
	            }
	            
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	}

public static void main(String[] args) {
	new ParseEx3();
}
    
}