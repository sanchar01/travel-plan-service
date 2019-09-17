package per.san.plan.mapper;

import org.apache.ibatis.annotations.Param;
import per.san.plan.domain.ShareInfo;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * description: 
 *
 * @author sanchar
 * @date 2019-09-13 08:21
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2019-09-13 08:21
 */
public interface ShareInfoMapper extends BaseMapper<ShareInfo> {

    /**
     * description: 批量删除
     * @param ids 删除数据的id数组
     * @return 删除成功的条数
     */
    Integer deleteBatch(@Param("ids") List<Long> ids);

    List<ShareInfo> queryList(ShareInfo shareInfo);

}
