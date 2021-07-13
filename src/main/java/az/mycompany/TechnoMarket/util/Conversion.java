package az.mycompany.TechnoMarket.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

public class Conversion{
    private static String encodeFileToBase64Binary(File file){
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = Base64.getMimeEncoder().encodeToString(bytes);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return encodedfile;
    }

    public String convertImageToString(File file){

        byte[] fileContent = new byte[0];
        String encodedString =new String();
        try {
            fileContent = FileUtils.readFileToByteArray(file);
          encodedString = Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedString;
    }

    public File convertStringToImage(String encodedString){

        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        File file=new File("test.jpg");
        try {
            FileUtils.writeByteArrayToFile(file, decodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

//    public static void main(String[] args) {
//        File file=new File("src/main/webapp/background.jpg");
//        Conversion conversion=new Conversion();
//        String  convertjpg=conversion.convertImageToString(file);
//        System.out.println(convertjpg);
//        file=conversion.convertStringToImage(convertjpg);
//    }
}
