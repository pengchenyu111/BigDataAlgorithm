package com.pcy.bigdataalgorithm.math.problem1th;

import java.lang.Math;

/**
 * 达到的效果是是输入群体数组，然后返回对应的适应度数组。
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

//适应度
public class ClsFitness {
    //计算个体的适应度
    public double fitSingle(String str, int GENE) {
        ClsDecode decode = new ClsDecode();
        double[] x = decode.decode(str, GENE);

        //适应度计算公式
        //问题：如果计算出来有负有正该怎么处理？
        //sin+sin越大，3-sin-sin越小，即得到的值越小个体的适应度就越大
        double fitness = Math.sin(2 * x[0]) * Math.sin(2 * x[0]) + Math.sin(2 * x[1]) * Math.sin(2 * x[1]);
        return fitness;
    }

    //批量计算数组的适应度
    public double[] fitAll(String str[], int GENE) {
        double[] fit = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            fit[i] = fitSingle(str[i], GENE);
        }
        return fit;
    }

    //适应度最值（返回序号）
    public int mFitNum(double fit[]) {
        double m = fit[0];
        int n = 0;
        for (int i = 0; i < fit.length; i++) {
            if (fit[i] > m) {
                //最大值
                m = fit[i];
                n = i;
            }
        }
        return n;
    }


    //适应度最值（返回适应度）
    public double mFitVal(double fit[]) {
        double m = fit[0];
        for (int i = 0; i < fit.length; i++) {
            if (fit[i] > m) {
                //最大值
                m = fit[i];
            }
        }
        return m;
    }
}
