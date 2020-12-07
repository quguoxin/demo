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

    // 获取长度
    public int length() {
        // 空链表
        if (this.next == null) {
            return 0;
        }
        int length = 1;
        HeroNode temp = this.next;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // 补齐链表到指定长度
    public HeroNode getNewNode(int length) {
        // 需要补充的节点个数
        int num = length - this.length();
        HeroNode temp = this.next;
        HeroNode result = new HeroNode(0, "", "");
        for (int i = 0; i < num; i++) {
//            HeroNode result1 = new HeroNode(0,"","");
//            result1.next = temp;
//            result = result1;
            result.next = temp;
            result.next = result;
        }
        return result.next;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
