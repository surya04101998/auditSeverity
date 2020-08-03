package com.cts.audit.model;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuditDetail {

private String auditType;
private Date auditDate;
private List<String> auditQuestions;

}
