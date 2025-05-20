package com.milan.Ghumgham_travels.FileUpload.controller;

import com.milan.Ghumgham_travels.FileUpload.utils.FileUploadHelper;
import com.milan.Ghumgham_travels.gallery.model.Gallery;
import com.milan.Ghumgham_travels.gallery.service.GalleryInterface;
import com.milan.Ghumgham_travels.utils.Constants;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//import org.apache.commons.io.IOUtils;;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FileUploadController {

    @Autowired
    FileUploadHelper fileUploadHelper;

    @Autowired
    GalleryInterface service;

    @RequestMapping(value = "images/save", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveImage(@RequestParam("file") MultipartFile files) throws IOException {

//        files.transferTo(new File("abc/abc"));
        System.out.println(" File Size : " + files.getSize());
        String imageName = "";
        try {
            imageName = fileUploadHelper.uploadImage(files);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseMessage.success(imageName);
    }

    @RequestMapping(value = "images/save/database", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveImageToDatabase(@RequestParam("file") MultipartFile files) throws IOException {

//        files.transferTo(new File("abc/abc"));
        System.out.println(" File Size : " + files.getSize());
        String imageName = "";
        try {
            imageName = fileUploadHelper.uploadImage(files);
            Gallery gallery = new Gallery();
            gallery.setFilename(imageName);
            service.saveGallery(gallery);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseMessage.success(imageName);
    }

    @RequestMapping(value = "/images/savelist", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveImageList(@RequestParam("file") List<MultipartFile> files) {
        //System.out.println(" File Size : " + files.getSize());
        List<String> imageName = new ArrayList<>();
        try {
            List<String> list = new ArrayList<>();
            for (MultipartFile file : files) {
                String s = fileUploadHelper.uploadImage(file);
                list.add(s);
            }
            imageName = list;//fileUploadHelper.uploadImage(files);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseMessage.success(imageName);
    }

    @GetMapping(value = "images/{fileName}.{ext}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody
    ResponseEntity<ByteArrayResource> getImage(@PathVariable("fileName") String fileName,
                                               @PathVariable("ext") String ext) throws IOException {
//        InputStream in = new FileInputStream(
        InputStream in = new FileInputStream(new File(Constants.realPath+File.separator+ "images" + File.separator+ fileName+"."+ext));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len;
        byte[] buffer = new byte[4096];
        while ((len = in.read(buffer, 0, buffer.length)) != -1) {
            baos.write(buffer, 0, len);
        }
        byte[] bytes = baos.toByteArray();
        ByteArrayResource resource = new ByteArrayResource(bytes);
        return ResponseEntity.ok().body(resource);
        //return IOUtils.toByteArray(in);
    }


    @GetMapping(value = "/images/pdf/{fileName}.{ext}",produces = "application/pdf")
    public ResponseEntity<Resource> checkGetPdf(@PathVariable("fileName") String fileName, @PathVariable("ext") String ext) throws IOException {
        String file2Upload = String.format("%s/%s.%s", Constants.realPath, fileName, ext);
        File file = new File(file2Upload);
        InputStream in = new FileInputStream(
                new File(file2Upload));
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename="+fileName+".pdf");
//        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
//        header.add("Pragma", "no-cache");
//        header.add("Expires", "0");

        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(resource);
    }

}
