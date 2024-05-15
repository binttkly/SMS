package org.qf.dto;

import lombok.Data;

/**
 * 接收批量删除对象的DTO
 */
@Data
public class DeleteBatchDTO {
    private Integer [] idList;
}
