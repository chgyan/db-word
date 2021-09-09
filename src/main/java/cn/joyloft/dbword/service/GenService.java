package cn.joyloft.dbword.service;

import cn.joyloft.dbword.entity.Tables;
import cn.joyloft.dbword.mapper.QueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;


@Service
public class GenService {

    @Resource
    QueryDao queryDao;

    @Autowired
    DataToWord dataToWord;

    /**
     * 获取数据
     */
    public void gen(String filePath) {
        String dataName = getDatabaseName();
        String fileName = filePath + "/" + dataName + ".doc";

        dataToWord.toWord(dataName, fileName);
    }

    private String getDatabaseName(){
        return queryDao.getDatabase();
    }
}
