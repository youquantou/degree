package com.wsy.camera2demo;

import android.graphics.Point;

public class DegreeUtils {
    /**
     * @param vertexPointX -- 角度对应顶点X坐标值
     * @param vertexPointY -- 角度对应顶点Y坐标值
     * @param point0X
     * @param point0Y
     * @param point1X
     * @param point1Y
     * @return
     */
    public static int getDegree(int vertexPointX, int vertexPointY, int point0X, int point0Y, int point1X, int point1Y) {
        //向量的点乘
        int vector = (point0X - vertexPointX) * (point1X - vertexPointX) + (point0Y - vertexPointY) * (point1Y - vertexPointY);
        //向量的模乘
        double sqrt = Math.sqrt(
                (Math.abs((point0X - vertexPointX) * (point0X - vertexPointX)) + Math.abs((point0Y - vertexPointY) * (point0Y - vertexPointY)))
                        * (Math.abs((point1X - vertexPointX) * (point1X - vertexPointX)) + Math.abs((point1Y - vertexPointY) * (point1Y - vertexPointY)))
        );
        //反余弦计算弧度
        double radian = Math.acos(vector / sqrt);
        //弧度转角度制
        return (int) (180 * radian / Math.PI);
    }

    public static int getDegreeByPoins(Point pointOriginal, Point point_0, Point point_1) {
        int vertexPointX = pointOriginal.x;
        int vertexPointY = pointOriginal.y;
        int point0X = point_0.x;
        int point0Y = point_0.y;
        int point1X = point_1.x;
        int point1Y = point_1.y;
        //向量的点乘
        int vector = (point0X - vertexPointX) * (point1X - vertexPointX) + (point0Y - vertexPointY) * (point1Y - vertexPointY);
        //向量的模乘
        double sqrt = Math.sqrt(
                (Math.abs((point0X - vertexPointX) * (point0X - vertexPointX)) + Math.abs((point0Y - vertexPointY) * (point0Y - vertexPointY)))
                        * (Math.abs((point1X - vertexPointX) * (point1X - vertexPointX)) + Math.abs((point1Y - vertexPointY) * (point1Y - vertexPointY)))
        );
        //反余弦计算弧度
        double radian = Math.acos(vector / sqrt);
        //弧度转角度制
        return (int) (180 * radian / Math.PI);
    }

    //找出最大角度
    public static int getMaxDegree(int degree[]) {
        int max = degree[0];
        for (int i = 1; i < degree.length; i++) {
            if (max < degree[i]) {
                max = degree[i];
            }
        }
        return max;
    }

    public static int getMinDegree(int degree[]) {
        int min = degree[0];
        for (int i = 1; i < degree.length; i++) {
            if (min > degree[i]) {
                min = degree[i];
            }
        }
        return min;
    }

    public static boolean isAcuteAngle(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            int j = i;
            if (j + 1 == 4) {
                j = 0;
            }
            if (j + 2 == 4) {
                j = 0;
            }
            if (j + 2 == 5) {
                j = 1;
            }
            if (getDegreeByPoins(points[j], points[j + 1], points[j + 2]) < 30) {
                return true;
            }
        }
        return false;
    }
}
