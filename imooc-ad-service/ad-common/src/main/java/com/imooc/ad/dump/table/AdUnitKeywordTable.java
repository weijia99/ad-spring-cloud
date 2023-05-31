package com.imooc.ad.dump.table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdUnitKeywordTable {
    private Long unitId;
    private String keyword;
}
