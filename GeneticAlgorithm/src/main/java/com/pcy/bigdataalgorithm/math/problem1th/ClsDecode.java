package com.pcy.bigdataalgorithm.math.problem1th;

/**
 * 解码时，先将一条染色体中表示x的部分和表示y的部分拆分开来，再把二进制转换为10进制。
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: BigDataAlgorithm
 * @Package: com.pcy.bigdataalgorithm.math.problem1th
 * @Description: note
 * @Author: pengcy31624
 * @CreateDate: 2020-07-27 10:07
 * @UpdateUser: pengcy31624
 * @UpdateDate: 2020-07-27 10:07
 * @UpdateRemark: The modified content
 * @Version: 1.0
 *
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/

//解码
public class ClsDecode {
    //单个染色体解码
    public double[] decode(String single, int GENE) {
        //二进制数前GENE/2位为x的二进制字符串，后GENE/2位为y的二进制字符串
        int a = Integer.parseInt(single.substring(0, GENE / 2), 2);
        int b = Integer.parseInt(single.substring(GENE / 2, GENE), 2);
        double[] x = {-1, -1};//new double[2];
        x[0] = a * (6.0 - 0) / (Math.pow(2, GENE / 2) - 1);    //x的基因
        x[1] = b * (6.0 - 0) / (Math.pow(2, GENE / 2) - 1);    //y的基因

        return x;
    }
}
