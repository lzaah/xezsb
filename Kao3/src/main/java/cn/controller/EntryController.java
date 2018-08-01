package cn.controller;

import cn.dao.IEntryDAO;
import cn.entity.Category;
import cn.entity.Entry;
import cn.service.IEntryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 18221 on 2018/7/24.
 */
@Controller
public class EntryController {
    @Resource(name = "entryservice")
    IEntryService entryService;
    @RequestMapping("/getEntrys")
    @ResponseBody
    public Object getEntrys(int cateid, @RequestParam(required = false,defaultValue = "1")int pageNum, @RequestParam(required = false,defaultValue = "1")int pageSize){
        return entryService.getEntrys((pageNum+1),pageSize,cateid);
    }
    @RequestMapping("/toIndex")
    public String toIndex(Model model){
        System.out.println(11);
        List<Category> cates = entryService.getCates();
        model.addAttribute("cates",cates);
        return "index";
    }
    @RequestMapping("/removeEntry")
    @ResponseBody
    public int removeEntry(int id){
         return entryService.removeEntry(id);
    }
    @RequestMapping("/toUpdate")
    public String toUpdate(int id,Model model){
           model.addAttribute("update",entryService.getone(id));
        List<Category> cates = entryService.getCates();
        model.addAttribute("cates",cates);
        return "updateentrys";
    }
    @RequestMapping("/toInsert")
    public String toInsert(Model model){
        List<Category> cates = entryService.getCates();
        model.addAttribute("cates",cates);
        return "updateentrys";
    }
    @RequestMapping("/update")
    public String update(Entry entry){
        System.out.println(entry);
         if(entry.getId()==null){
              entryService.insertEntry(entry);
         }else {
                entryService.updateEntry(entry);
         }
         return "redirect:/toIndex";
    }
    @InitBinder
    public void initBinder(WebDataBinder ubirthday){
        DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        ubirthday.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
    }
}
