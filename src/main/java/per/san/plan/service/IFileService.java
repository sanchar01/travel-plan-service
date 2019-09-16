package per.san.plan.service;

import com.github.pagehelper.PageInfo;
import per.san.common.utils.page.PageRequest;
import per.san.plan.domain.File;

import java.util.List;

/**
 * description: 
 *
 * @author sanchar
 * @date 2019-09-13 08:21
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2019-09-13 08:21
 */
public interface IFileService {

    /**
     * description: 新增
     * @param file 新增的信息
     * @return 新增成功的条数
     */
    Integer add(File file);

    /**
     * description: 根据主键id删除
     * @param id 删除数据的id
     * @return 删除成功的条数
     */
    Integer deleteByPrimaryKey(Long id);

    /**
     * description: 批量删除
     * @param ids 删除数据的id数组
     * @return 删除成功的条数
     */
    Integer deleteBatch(List<Long> ids);

    /**
    * description: 更新
    * @param file 更新的信息
    * @return 更新成功的条数
    */
    Integer update(File file);

    /**
    * description: 分页查询
    * @param pageRequest 分页查询参数
    * @param file 分页查询条件
    * @return 分页数据
    */
    PageInfo<File> pageQuery(PageRequest pageRequest, File file);

    /**
    * description: 查询List
    * @param file 查询条件
    * @return 数据List
    */
    List<File> queryList(File file);

    /**
    * description: 根据ID查询
    * @param id 查询数据的ID
    * @return 数据对象
    */
    File queryById(Long id);

}
