package com.pcy.bigdataalgorithm.math.problem1th;

/**
 * 适应度越大的个体，被选中保留到下一代的可能性越高。使用轮盘赌算法可以达到这个目的。
 *
 * 为了保持群体总数不变，被淘汰的个体由随机生成的新个体补充。
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: BigDataAlgorithm
 * @Package: com.pcy.bigdataalgorithm.math.problem1th
 * @Description: note
 * @Author: pengcy31624
 * @CreateDate: 2020-07-27 10:11
 * @UpdateUser: pengcy31624
 * @UpdateDate: 2020-07-27 10:11
 * @UpdateRemark: The modified content
 * @Version: 1.0
 *
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/

//轮盘赌选择
public class ClsRWS {

    ClsInit init = new ClsInit();
    ClsFitness fitness = new ClsFitness();

    /**
     *
     * @param group group[]群体数组
     * @param GENE 基因数
     * @return
     */
    public String[] RWS(String group[], int GENE) {
        double p[] = new double[group.length];    //染色体概率数组
        String[] newgroup = new String[group.length];
        double F = 0;    //适应度的和

        double[] fit = fitness.fitAll(group, GENE);    //计算适应度数组

        //求适应度的和F
        for (int i = 0; i < fit.length; i++) {
            F = F + fit[i];
        }

        //初始化p[]
        for (int i = 0; i < fit.length; i++) {
            p[i] = fit[i] / F;
        }

        //求出适应度最大的个体maxStr,它的序号是max
        int max = fitness.mFitNum(fit);
        String maxStr = group[max];

        //转动轮盘，适应度大的被选中的概率大
        for (int i = 0; i < fit.length; i++) {
            double r = Math.random();
            double q = 0;    //累计概率

            //适应度最大的个体直接继承
            if (i == max) {
                newgroup[i] = maxStr;
                p[i] = 0;    //将其概率置空
                //System.out.println("继承的最大适应度为"+fit[i]);
                continue;
            }

            //遍历轮盘，寻找轮盘指针指在哪个区域
            for (int j = 0; j < fit.length; j++) {
                q += p[j];
                if (r <= q) {
                    newgroup[i] = group[j];    //如果被选中，保留进下一代
                    p[j] = 0;    //将其概率置空
                    break;
                }
                newgroup[i] = init.initSingle(GENE);    //如果没被选中，被外来者取代
            }
        }
        return newgroup;
    }
}