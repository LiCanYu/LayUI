package com.practis.controller;

import com.practis.utils.CodeHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.RenderedImage;
import java.io.*;
import java.util.Map;
import java.util.UUID;

@Controller
public class VerityCode {

    @RequestMapping(value = "/getcode")
    @ResponseBody
    public String verityCode(HttpServletRequest request,HttpServletResponse response){
        String imageName=UUID.randomUUID().toString()+".jpg";
        String filePath=request.getServletContext().getRealPath("/")+"images/code/"+imageName;
        OutputStream os=null;
        File file=new File(request.getServletContext().getRealPath("/")+"images/code");
        file.mkdirs();
        try {
            os=new FileOutputStream(filePath);
            CodeHelper ch=new CodeHelper();
            Map<String,Object> map=ch.createCodeAndPic();
            ImageIO.write((RenderedImage) map.get("image"),"jpg",os);
            System.out.println("验证码为"+map.get("verify"));
            os.close();
            request.getSession().setAttribute("verify",map.get("verify"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return imageName;
    }
}
