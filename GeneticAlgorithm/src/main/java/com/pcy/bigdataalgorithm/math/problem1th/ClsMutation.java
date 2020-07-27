package com.pcy.bigdataalgorithm.math.problem1th;

/**
 * 在染色体上随机选取一位，翻转其二进制位
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: BigDataAlgorithm
 * @Package: com.pcy.bigdataalgorithm.math.problem1th
 * @Description: note
 * @Author: pengcy31624
 * @CreateDate: 2020-07-27 10:20
 * @UpdateUser: pengcy31624
 * @UpdateDate: 2020-07-27 10:20
 * @UpdateRemark: The modified content
 * @Version: 1.0
 *
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/

//变异
public class ClsMutation {
    //替换String中的指定位
    //str要改动的字符串
    //num要改动的位（从0开始数）
    //pos要把这一位改动成什么
    public String replacePos(String str, int num, String pos) {
        String temp;
        if (num == 0) {
            temp = pos + str.substring(1);
        } else if (num == str.length() - 1) {
            temp = str.substring(0, str.length() - 1) + pos;
        } else {
            String temp1 = str.substring(0, num);
            String temp2 = str.substring(num + 1);
            temp = temp1 + pos + temp2;
        }
        return temp;
    }

    //MP = Mutation probability变异概率
    public String[] mutation(String[] group, int GENE, double MP) {
        ClsFitness fitness = new ClsFitness();
        double[] fit = fitness.fitAll(group, GENE);
        int mFitNum = fitness.mFitNum(fit);    //计算适应度最大的染色体序号
        String max = group[mFitNum];

        for (int i = 0; i < group.length * MP; i++) {
            int n = (int) (Math.random() * GENE * group.length);    //从[0，GENE * group.length)区间取随机数
            int chrNum = (int) (n / GENE);    //取得的染色体数组下标
            int gNum = (int) (n % GENE);    //取得的基因下标
            String temp = "";

            if (group[chrNum].charAt(gNum) == '0') {
                temp = replacePos(group[chrNum], gNum, "1");
            } else {
                temp = replacePos(group[chrNum], gNum, "0");
            }
            group[chrNum] = temp;
        }
        group[0] = max;
        return group;
    }
}
