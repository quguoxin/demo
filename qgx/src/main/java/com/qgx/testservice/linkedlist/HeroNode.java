package com.qgx.testservice.linkedlist;

/**
 * Description:
 * Created by qgx on 2020/12/3 23:33
 */
public class HeroNode {
    // 使用public方便使用，不用谢GET、SET方法了
    public int no;
    public String name;
    public String nickname;
    // 指向下一个节点
    public HeroNode next;

    // 构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
