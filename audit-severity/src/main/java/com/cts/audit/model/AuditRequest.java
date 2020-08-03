package com.cts.audit.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Component
@NoArgsConstructor
@Data
@ToString
@AllArgsConstructor
public class AuditRequest {


private String projectName;
private String projectManagerName;
private String applicationOwnerName;
private AuditDetail auditDetail;



}
