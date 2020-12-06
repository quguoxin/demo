package com.qgx.testservice.linkedlist;

/**
 * 使用带head头节点的单向链表实现——水浒英雄排行榜管理，完成对英雄人物的增删改查操作
 * Description:  此时为顺序添加，只能在末尾添加
 * Created by qgx on 2020/12/3 23:31
 *
 * @author Administrator
 */
public class SingleLinkedList {
    // 初始化一个头节点 不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");


    // 添加节点到单向链表
    public void add(HeroNode heroNode) {
        // 当不考虑编号的顺序时:
        // 1、找到当前链表的最后节点
        // 2、将最后这个节点的next域指向新的节点即可

        // 因为head头节点不能动，因此我们需要一个辅助节点temp
        HeroNode temp = head;
        while (temp.next != null) {
            // 如果不是尾节点，将temp后移
            temp = temp.next;
        }

        // 循环结束后，temp指向的是尾节点
        temp.next = heroNode;// 将next域指向新节点
    }

    // 显示链表
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 创建一个辅助节点
        HeroNode temp = head.next;
        while (temp != null) {
            // 输出节点信息
            System.out.println(temp);
            // 将temp后移
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        // 创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", " 及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 加入链表
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        // 显示链表
        singleLinkedList.list();
    }

}
