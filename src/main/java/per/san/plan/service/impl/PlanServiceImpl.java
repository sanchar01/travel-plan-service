package per.san.plan.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.san.common.utils.page.PageHelper;
import per.san.common.utils.page.PageRequest;
import per.san.plan.domain.Plan;
import per.san.plan.mapper.PlanMapper;
import per.san.plan.service.IPlanService;

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
public class PlanServiceImpl implements IPlanService {

    @Autowired
    PlanMapper planMapper;

    @Override
    public Integer add(Plan plan) {
        return planMapper.insertSelective(plan);
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {
        return planMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatch(List<Long> ids) {
        return planMapper.deleteBatch(ids);
    }

    @Override
    public Integer update(Plan plan) {
        return planMapper.updateByPrimaryKeySelective(plan);
    }

    @Override
    public PageInfo<Plan> pageQuery(PageRequest pageRequest, Plan plan) {
        return PageHelper.doPage(pageRequest, () -> planMapper.select(plan));
    }

    @Override
    public List<Plan> queryList(Plan plan) {
        return planMapper.select(plan);
    }

    @Override
    public Plan queryById(Long id) {
    return planMapper.selectByPrimaryKey(id);
    }
}
