package com.celilcavus.bilimzamani.Entity;

import java.time.LocalDateTime;

public class BaseEntity {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private boolean IsActive;


    public BaseEntity()
    {
        createDate = LocalDateTime.now();
        updateDate = LocalDateTime.now();
        IsActive = false;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }
}
