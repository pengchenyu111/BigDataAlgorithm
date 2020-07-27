package com.pcy.bigdataalgorithm.math.problem1th;

/**
 * 染色体依次两两配对，随机在一对染色体上选取一点分成两段，然后互换重组为新的两条染色体。
 *
 * （在交叉这一步，有更好的策略是只选取选择得到的适应度高的个体进行交叉，并且可以选择交叉后保留原个体）
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: BigDataAlgorithm
 * @Package: com.pcy.bigdataalgorithm.math.problem1th
 * @Description: note
 * @Author: pengcy31624
 * @CreateDate: 2020-07-27 10:16
 * @UpdateUser: pengcy31624
 * @UpdateDate: 2020-07-27 10:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 *
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/

//交叉
public class ClsCross {
    ClsFitness fitness = new ClsFitness();

    //group群体
    //GENE基因数
    //mFitNum最大适应度染色体序号
    public String[] cross(String[] group, int GENE, double crossRate) {
        String temp1, temp2;
        int pos = 0;

        double[] fit = fitness.fitAll(group, GENE);
        int mFitNum = fitness.mFitNum(fit);    //计算适应度最大的染色体序号
        String max = group[mFitNum];

        for (int i = 0; i < group.length; i++) {
            if (Math.random() < crossRate) {
                pos = (int) (Math.random() * GENE) + 1;    //交叉点
                temp1 = group[i].substring(0, pos) + group[(i + 1) % group.length].substring(pos);    //%用来防止数组越界
                temp2 = group[(i + 1) % group.length].substring(0, pos) + group[i].substring(pos);
                group[i] = temp1;
                group[(i + 1) % group.length] = temp2;
            }
        }
        group[0] = max;
        return group;
    }
}
