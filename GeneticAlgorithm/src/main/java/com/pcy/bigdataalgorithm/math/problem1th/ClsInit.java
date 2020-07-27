package com.pcy.bigdataalgorithm.math.problem1th;

/**
 * 编码：初始化，将染色体的每一位都随机置为0或1
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: BigDataAlgorithm
 * @Package: com.pcy.bigdataalgorithm.math.problem1th
 * @Description: note
 * @Author: pengcy31624
 * @CreateDate: 2020-07-27 10:05
 * @UpdateUser: pengcy31624
 * @UpdateDate: 2020-07-27 10:05
 * @UpdateRemark: The modified content
 * @Version: 1.0
 *
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/

//初始化群体（编码）
public class ClsInit {

    //初始化一条染色体
    public String initSingle(int GENE) {
        String res = "";
        for (int i = 0; i < GENE; i++) {
            if (Math.random() < 0.5) {
                res += 0;
            } else {
                res += 1;
            }
        }
        return res;
    }

    //初始化一组染色体
    public String[] initAll(int GENE, int groupsize) {
        String[] iAll = new String[groupsize];
        for (int i = 0; i < groupsize; i++) {
            iAll[i] = initSingle(GENE);
        }
        return iAll;
    }
}
