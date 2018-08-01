package cn.service.impl;

import cn.dao.IEntryDAO;
import cn.entity.Category;
import cn.entity.Entry;
import cn.service.IEntryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 18221 on 2018/7/24.
 */
@Service("entryservice")
public class EntryServiceimpl implements IEntryService {
    @Resource(name = "IEntryDAO")
    IEntryDAO entryDAO;
    @Override
    public PageInfo<Entry> getEntrys(int pageNum, int pageSize, int cateid) {
        Page<Entry> page = PageHelper.startPage(pageNum, pageSize);
        Category category=new Category();
        category.setId(cateid);
        List<Entry> entrys = entryDAO.getEntrys(category);
        return page.toPageInfo();
    }

    @Override
    public List<Category> getCates() {
        return entryDAO.getCates();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public int removeEntry(int id) {
        return entryDAO.removeEntry(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public int updateEntry(Entry entry) {
        return entryDAO.updateEntry(entry);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public int insertEntry(Entry entry) {
        return entryDAO.insertEntry(entry);
    }

    @Override
    public Entry getone(int id) {
        return entryDAO.getone(id);
    }
}
