package per.san.plan.domain;

import per.san.generate.domain.AuditDomain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * description: 
 *
 * @author sanchar
 * @date 2019-09-13 08:21
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2019-09-13 08:21
 */
@Table(name="plan")
public class Plan extends AuditDomain {

    /**
    *主键ID
    */
    @Id
    private Long id;

    /**
    *计划名称
    */
    private String planName;

    /**
    *计划天数
    */
    private Long planDays;

    /**
    *开始日期
    */
    private Date startDate;

    /**
    *权限（公开/私有）
    */
    private String permission;

    /**
    *状态（新建/进行中/已结束）
    */
    private String status;

    /**
    *用户ID
    */
    private Long userId;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanName() {
        return this.planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Long getPlanDays() {
        return this.planDays;
    }

    public void setPlanDays(Long planDays) {
        this.planDays = planDays;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
