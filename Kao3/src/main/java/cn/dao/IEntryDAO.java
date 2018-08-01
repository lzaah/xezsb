package cn.dao;

import cn.entity.Category;
import cn.entity.Entry;

import java.util.List;

/**
 * Created by 18221 on 2018/7/24.
 */
public interface IEntryDAO {
    public List<Entry> getEntrys(Category cateid);
    public List<Category> getCates();
    public int removeEntry(int id);
    public int updateEntry(Entry entry);
    public int insertEntry(Entry entry);
    public Entry getone(int id);
}
