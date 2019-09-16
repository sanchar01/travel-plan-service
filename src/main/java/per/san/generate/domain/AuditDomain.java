package per.san.generate.domain;

import java.util.Date;

/**
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 8/1/2019 14:13
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 8/1/2019
 */
public class AuditDomain {
    private Date creationDate;
    private Date lastUpdateDate;
    private Long objectVersionNumber;
    private Boolean isDeleted;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
