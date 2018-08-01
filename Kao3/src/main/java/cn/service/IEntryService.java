package cn.service;

import cn.entity.Category;
import cn.entity.Entry;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 18221 on 2018/7/24.
 */
public interface IEntryService {
    public PageInfo<Entry> getEntrys(int pageNum, int pageSize, int cateid);
    public List<Category> getCates();
    public int removeEntry(int id);
    public int updateEntry(Entry entry);
    public int insertEntry(Entry entry);
    public Entry getone(int id);
}
