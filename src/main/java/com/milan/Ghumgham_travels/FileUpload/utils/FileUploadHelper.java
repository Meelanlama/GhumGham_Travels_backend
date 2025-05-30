package com.milan.Ghumgham_travels.FileUpload.utils;


import com.milan.Ghumgham_travels.utils.Constants;
import com.milan.Ghumgham_travels.utils.exceptions.SendErrorMessageCustom;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class FileUploadHelper {

    public String uploadFiles(MultipartFile multipartFile){
        boolean check = false;
        try{
            Files.copy(multipartFile.getInputStream(), Paths.get(Constants.realPath+File.separator+multipartFile.getOriginalFilename()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return multipartFile.getOriginalFilename();
    }

    public String randomImageName() {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    public String compressImage(String imageDirectory, String imageName) throws IOException, Exception {

        String realPath = Constants.realPath;
        // String realPath = context.getRealPath("/");
        File input = new File(
                realPath + File.separator + "images" + File.separator + imageDirectory + File.separator + imageName);
        double size = input.length() / 1024;
        if(size > 300) {
            BufferedImage image = ImageIO.read(input);
            File compressedImageFile = new File(realPath + File.separator + "images" + File.separator + imageDirectory
                    + File.separator + imageName);

            OutputStream os = new FileOutputStream(compressedImageFile);

            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
            ImageWriter writer = (ImageWriter) writers.next();

            ImageOutputStream ios = ImageIO.createImageOutputStream(os);
            writer.setOutput(ios);

            ImageWriteParam param = writer.getDefaultWriteParam();

            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality((float) (300f / size));
            writer.write(null, new IIOImage(image, null, null), param);

            os.close();
            ios.close();
            writer.dispose();
            return "";

        } else {
            return "";
        }

    }

    public String imageValidation(MultipartFile multipartFile){
        String fileExtension = multipartFile.getContentType();
        System.out.println(multipartFile.getOriginalFilename());
        System.out.println(fileExtension);

        if (fileExtension.equals("image/png") || fileExtension.equals("image/jpeg") || fileExtension.equals("image/jpg") || fileExtension.equals("image/webp")){
            System.out.println("Image in correct format");
        }else {
            throw new SendErrorMessageCustom("Image not in correct format. Should Be:png,jpeg,jpg,webp");
        }

        if (multipartFile.getSize() > 1000000) { // check if file size is greater than 1 MB
            throw new SendErrorMessageCustom("File Size Exceeds More Than 1 MB.");
        }

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9_ .]");
        Matcher matcher = pattern.matcher(multipartFile.getOriginalFilename());
        return matcher.replaceAll("_");


    }

    public String uploadImage(MultipartFile multipartFile) throws IOException, Exception {
        String realPath = Constants.realPath;
        // String realPath = context.getRealPath("/");
        // System.out.println("-------------------------Initial Path : " + initialPath);

        int count = 0;
        String randomNumber = "";
        String uploadTempPath = realPath + File.separator + File.separator + "images" + File.separator; //+ File.separator + "temp" + File.separator;

        String fileName = new Date().getTime() + "_" + multipartFile.getOriginalFilename();
        String fileExtension = fileName.substring(fileName.indexOf(".") + 1);
        System.out.println("Success ---------");
        File dir = new File(uploadTempPath);
        if (!dir.exists()) {
            System.out.println("realPath => " + uploadTempPath);
            dir.mkdirs();
        }

        do {

            randomNumber = randomImageName();

            String uploadTempPaths = uploadTempPath + fileName;
            File uploadTempDir = new File(uploadTempPaths);
            if (!uploadTempDir.exists()) {
                break;
            }

            if (count++ > 1000) {
                throw new Exception("Too large number of image exists in the Directory.");
            }

        } while (true);

        // convert to jpg start
        if (fileExtension.equals("png")) {
            InputStream in = new ByteArrayInputStream(multipartFile.getBytes());
            BufferedImage bufferedImage = ImageIO.read(in);

            // create a blank, RGB, same width and height, and a white background
            BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(),
                    BufferedImage.TYPE_INT_RGB);
            newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);

            // write to jpeg file
            ImageIO.write(newBufferedImage, fileExtension,
                    new File(uploadTempPath + fileName));
            // convert to jpg end
        } else {
            // Now do something with file...
            FileCopyUtils.copy(multipartFile.getBytes(), new File(uploadTempPath + fileName));
        }

        return fileName;
    }
}
