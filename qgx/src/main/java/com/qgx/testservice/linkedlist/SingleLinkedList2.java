package com.qgx.testservice.linkedlist;

/**
 * 使用带head头节点的单向链表实现——水浒英雄排行榜管理，完成对英雄人物的增删改查操作
 * Description:  此时为插入链表
 * Created by qgx on 2020/12/3 23:31
 *
 * @author Administrator
 */
public class SingleLinkedList2 {
    // 初始化一个头节点 不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    // 第二种添加方式，根据排名进行添加
    public void addByOrder(HeroNode heroNode) {
        // 头节点直接返回
        if (heroNode.no == 0) {
            System.out.println("不允许添加头节点");
            return;
        }
        HeroNode temp = head;
        while (true) {
            // 插入法即插入到当temp.no<heroNode.no<temp.next.no

            // 1.当前节点下一个为空了，那么直接添加末尾就号
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }
            //2.当前节点的下一个节点已为目标节点
            if (temp.next.no == heroNode.no) {
                System.out.println("已存在");
                break;
            }
            // 3.当前节点下一个节点刚好大于了目标节点的no，说明位置找到
            if (temp.next.no > heroNode.no) {
                // 将当前节点的下一个节点赋给目标节点
                heroNode.next = temp.next;
                // 将补齐链表的目标节点赋给当前节点
                temp.next = heroNode;
                break;
            }
            temp = temp.next;
        }
    }

    // 修改
    public void updateByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            //当前节点
            if (temp.no == heroNode.no) {
                temp.name = heroNode.name;
                temp.nickname = heroNode.nickname;
                break;
            }
            temp = temp.next;
        }
    }

    // 删除
    public void delByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.no == heroNode.no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    /*
     *显示链表
     */
    public void list() {
        // 判断链表是否为空
        if (null == head.next) {
            System.out.println("链表为空");
            return;
        }
        // 创建一个辅助节点,头节点不打印
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
        HeroNode hero0 = new HeroNode(0, "宋江", " 及时雨");
        HeroNode hero1 = new HeroNode(1, "宋江", " 及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建链表
        SingleLinkedList2 singleLinkedList = new SingleLinkedList2();
        // 加入链表

        singleLinkedList.addByOrder(hero0); // 头节点
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);// 重复节点
        singleLinkedList.addByOrder(hero2);

        // 显示链表
        singleLinkedList.list();
    }

}
