package zijinfeihong.bbs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import zijinfeihong.bbs.demo.service.FileService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author sherman
 * @create 2020--08--07 15:33
 */

@RestController
public class FileController {

    @Autowired
    FileService fileService;

    //单文件上传
    @PostMapping("/upload")
    public String upload(MultipartFile file){
        if (file.isEmpty()) {
            return "file is empty";
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "E:\\request\\";
        String path = filePath + fileName;
        File dest = new File(path);
        if (!dest.getParentFile().exists())
            dest.getParentFile().mkdirs();
        try {
            file.transferTo(dest);
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fail";
    }


    //多文件上传
    @PostMapping("/batch")
    public String batch(HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); i++) {
            file = files.get(i);
            String filePath = "E:\\uploads\\";
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    File file1 = new File(filePath + file.getOriginalFilename());
                    if (!file1.getParentFile().exists())
                        file1.getParentFile().mkdirs();
                    stream = new BufferedOutputStream(new FileOutputStream(file1));
                    stream.write(bytes);
                    stream.close();

                } catch (IOException e) {
                    stream = null;
                    return "the" + i + "file upload failure";
                }
            } else {
                return "the" + i + "file is empty";
            }
        }
        return "upload success";
    }

    @PostMapping("/download")
    public String download(HttpServletRequest request, HttpServletResponse response){
        String fileName = "ass.md";
        if (fileName != null) {
            File file = new File("E:\\asshole.md");
            if (file.exists()) {
                response.setContentType("application/force-download");
                response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        os.flush();
                        i = bis.read(buffer);
                    }
                    return "download";
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
        return "failure";
    }

    @PostMapping("/headUpload")
    public String headUpload(MultipartFile file,String username){
        List<String> imageType = Arrays.asList(".jpg", ".jpeg", ".png", ".bmp", ".gif");
        if(file.isEmpty()){
            return "empty";
        }
        String originalFilename = file.getOriginalFilename();
        String suffixName = "";
        int index=originalFilename.lastIndexOf(".");
        if(index!=-1){
            suffixName = originalFilename.substring(index).toLowerCase();
        }
        if(imageType.contains(suffixName)){
            String fileName = UUID.randomUUID().toString()+suffixName;
            String filePath = "E:\\request\\";
            String path = filePath + fileName;
            File dest = new File(path);
            if (!dest.getParentFile().exists())
                dest.getParentFile().mkdirs();
            try {
                file.transferTo(dest);
                fileService.headUpload(username,path);
                return "success";
            } catch (IOException e) {
                return "error";
            }
        }
        return "fail";
    }
}
