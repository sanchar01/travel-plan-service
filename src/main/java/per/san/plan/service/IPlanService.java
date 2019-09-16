package per.san.plan.service;

import com.github.pagehelper.PageInfo;
import per.san.common.utils.page.PageRequest;
import per.san.plan.domain.Plan;

import java.util.List;

/**
 * description: 
 *
 * @author sanchar
 * @date 2019-09-13 08:21
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2019-09-13 08:21
 */
public interface IPlanService {

    /**
     * description: 新增
     * @param plan 新增的信息
     * @return 新增成功的条数
     */
    Integer add(Plan plan);

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
    * @param plan 更新的信息
    * @return 更新成功的条数
    */
    Integer update(Plan plan);

    /**
    * description: 分页查询
    * @param pageRequest 分页查询参数
    * @param plan 分页查询条件
    * @return 分页数据
    */
    PageInfo<Plan> pageQuery(PageRequest pageRequest, Plan plan);

    /**
    * description: 查询List
    * @param plan 查询条件
    * @return 数据List
    */
    List<Plan> queryList(Plan plan);

    /**
    * description: 根据ID查询
    * @param id 查询数据的ID
    * @return 数据对象
    */
    Plan queryById(Long id);

}
