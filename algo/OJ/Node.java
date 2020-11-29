/*
 * @Author: your name
 * @Date: 2020-04-11 14:52:56
 * @LastEditTime: 2020-04-11 14:52:57
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /java/OJ/Node.java
 */

class Node {
    int x, y;
    int step;
    int preX, preY;
    String direction;

    Node(int x, int y, int preX, int preY, int step, String direction) {
        this.x = x;
        this.y = y;
        this.preX = preX;
        this.preY = preY;
        this.step = step;
        this.direction = direction;
    }
}
