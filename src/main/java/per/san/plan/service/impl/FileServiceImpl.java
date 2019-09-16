package per.san.plan.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.san.common.utils.page.PageHelper;
import per.san.common.utils.page.PageRequest;
import per.san.plan.domain.File;
import per.san.plan.mapper.FileMapper;
import per.san.plan.service.IFileService;

import java.util.List;

/**
 * description: 
 *
 * @author sanchar
 * @date 2019-09-13 08:21
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2019-09-13 08:21
 */
@Service
public class FileServiceImpl implements IFileService {

    @Autowired
    FileMapper fileMapper;

    @Override
    public Integer add(File file) {
        return fileMapper.insertSelective(file);
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {
        return fileMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatch(List<Long> ids) {
        return fileMapper.deleteBatch(ids);
    }

    @Override
    public Integer update(File file) {
        return fileMapper.updateByPrimaryKeySelective(file);
    }

    @Override
    public PageInfo<File> pageQuery(PageRequest pageRequest, File file) {
        return PageHelper.doPage(pageRequest, () -> fileMapper.select(file));
    }

    @Override
    public List<File> queryList(File file) {
        return fileMapper.select(file);
    }

    @Override
    public File queryById(Long id) {
    return fileMapper.selectByPrimaryKey(id);
    }
}
