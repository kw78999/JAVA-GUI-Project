package JAVAP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class TTTTFileService {

    public int makeDirAndDulpleChk(String basePath, String fileName){
     int cmd = 0;
        File dir = new File(basePath);
        // 디렉토리가 존재하지 않다면 디렉토리를 만든다.
        if(!dir.exists())
            dir.mkdirs();
       
        // 해당 디렉토리 안에 파일이 같은 이름의 파일이 있는지 검사한다.
        File[] file = dir.listFiles();
        for(int i=0; i<file.length; i++){
         if(file[i].getName().trim().equals(fileName)){
          cmd = -1;
         }
        }
        return cmd;
    }
   
    public String saveFile(File file, String basePath, String fileName)
            throws Exception{

        if(file == null || file.getName().equals("") || file.length() < 1)
            return null;

        String serverFullPath = basePath+System.getProperty("file.separator")+
                fileName;
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(serverFullPath);
        int readSize = 0;
       
        byte[] buf = new byte[1024];
       
        while((readSize = fis.read(buf)) != -1)
            fos.write(buf, 0, readSize);
       
        fos.close();
        fis.close();
        return serverFullPath; 
    }
}
