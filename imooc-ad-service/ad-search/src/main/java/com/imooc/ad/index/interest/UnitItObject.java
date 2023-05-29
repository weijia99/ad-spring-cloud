package com.imooc.ad.index.interest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitItObject {

    // 推广单元关联id
    private Long unitId;

    // 兴趣标签
    private String itTag;
}
