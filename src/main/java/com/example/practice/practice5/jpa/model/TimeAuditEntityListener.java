package com.example.practice.practice5.jpa.model;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.hibernate.resource.transaction.backend.jta.internal.DdlTransactionIsolatorJtaImpl;

import java.time.LocalDateTime;

public class TimeAuditEntityListener {
    @PrePersist
    public void prevInsert(Object o) {
        if(o instanceof TimeAuditable) {
            ((TimeAuditable) o).setCreateAt(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void prevUpdate(Object o) {
        if(o instanceof TimeAuditable) {
            ((TimeAuditable) o).setUpdateAt(LocalDateTime.now());
        }
    }

}
