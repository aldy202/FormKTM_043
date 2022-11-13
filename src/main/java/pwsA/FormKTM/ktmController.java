/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwsA.FormKTM;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author hp
 */
@Controller
public class ktmController {
    
    @RequestMapping("/formKTM")
    public String getDATAKTM(@RequestParam("name")String name,
            @RequestParam("nim")String nim,
            @RequestParam("jurusan") String jurusan,
            @RequestParam("image")MultipartFile img,
            @RequestParam("tanggal") @DateTimeFormat (pattern = "yyyy-MM-dd") Date date, Model model) throws IOException
    {
        SimpleDateFormat nwTgl = new SimpleDateFormat("EE-dd-MMM-yyyy");
        String tgl = nwTgl.format(date);
        
        String image = Base64.encodeBase64String(img.getBytes());
        String imge = "data:image/jpeg;base64,".concat(image);
        
        model.addAttribute("nama", name);
        model.addAttribute("NIM", nim);
        model.addAttribute("jrsn", jurusan);
        model.addAttribute("tgl", tgl);
        model.addAttribute("img", imge);
        
          
        return "data";
    }
    
}
