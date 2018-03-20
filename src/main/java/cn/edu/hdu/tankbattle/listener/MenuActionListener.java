/*
 * Copyright (c) 2011-2025 PiChen.
 */

package cn.edu.hdu.tankbattle.listener;

import cn.edu.hdu.tankbattle.context.GameContext;
import cn.edu.hdu.tankbattle.control.Control;
import cn.edu.hdu.tankbattle.dto.RealTimeGameData;
import cn.edu.hdu.tankbattle.model.GameResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class Description...
 *
 * @author chenpi
 * @since 2018/3/19 20:18
 */
@Component
public class MenuActionListener implements ActionListener {
    @Autowired
    private Control commond;
    @Autowired
    private GameContext context;
    @Override
    public void actionPerformed(ActionEvent e) {
        RealTimeGameData control = context.getGameData();
        GameResource resource = context.getResource();
        if ("stop".equals(e.getActionCommand())) {
            commond.gameEventStop(resource);
        } else if ("start".equals(e.getActionCommand())) { // 当点了开始游戏
            if (!control.isStart()) { // 还没开始
                context.startGame();// 已经开始了
                //this.setVisible(true);
            } else if (!control.isStop()
                    && control.getMyTankNum() != 0) {
                // 暂停
                commond.gameEventStop(resource);
                JOptionPane.showMessageDialog(null, "游戏已经开始", "提示",
                        JOptionPane.INFORMATION_MESSAGE);
                // 恢复游戏
                commond.gameEventStop(resource);
            } else if (control.isStop()) {
                JOptionPane.showMessageDialog(null, "游戏已经开始", "提示",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (!control.isStop()
                    && (control.getMyTankNum() == 0)) {
                context.startGame();
            }
        } else if ("exit".equals(e.getActionCommand())) { // 退出按钮
            // 暂停游戏
            commond.gameEventStop(resource);
            int select = JOptionPane.showConfirmDialog(null, "退出游戏吗？", "退出确认",
                    JOptionPane.YES_NO_OPTION);
            if (select == JOptionPane.OK_OPTION) {
                // 退出游戏
                System.exit(0);
            } else {
                // 恢复游戏
                commond.gameEventStop(resource);
            }
        } else if ("again".equals(e.getActionCommand())) { // 重来
            if (control.isStart()) {
                if (control.isStop()) {
                    // 先恢复
                    commond.gameEventStop(resource);
                } else {
                }
            }
        } else if ("first".equals(e.getActionCommand())) {
            if (control.isStart()) {
                if (!control.isStop()) {// 暂停游戏
                    commond.gameEventStop(resource);
                }
                int select = JOptionPane.showConfirmDialog(null,
                        "您选择的是第一关，点击确定开始游戏", "选择确认",
                        JOptionPane.OK_CANCEL_OPTION);
                if (select == JOptionPane.OK_OPTION) {
                    if (control.isStart()) {
                        // 恢复游戏
                        commond.gameEventStop(resource);
                    }
                    context.startGame();
                    control.setLevel(1);
                    //this.setVisible(true);
                } else {
                    if (control.isStart()) {
                        // 恢复游戏
                        commond.gameEventStop(resource);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "请先点击游戏Game菜单下的开始游戏", "提示",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if ("second".equals(e.getActionCommand())) {
            if (control.isStart()) {
                if (!control.isStop()) {// 暂停游戏
                    commond.gameEventStop(resource);
                }
                int select = JOptionPane.showConfirmDialog(null,
                        "您选择的是第二关，点击确定开始游戏", "选择确认",
                        JOptionPane.OK_CANCEL_OPTION);
                if (select == JOptionPane.OK_OPTION) {
                    if (control.isStart()) {
                        // 恢复游戏
                        commond.gameEventStop(resource);
                    }
                    context.startGame();
                    control.setLevel(2);
                    //this.setVisible(true);
                } else {
                    if (control.isStart()) {
                        // 恢复游戏
                        commond.gameEventStop(resource);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "请先点击游戏Game菜单下的开始游戏", "提示",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if ("third".equals(e.getActionCommand())) {
            if (control.isStart()) {
                if (!control.isStop()) {// 暂停游戏
                    commond.gameEventStop(resource);
                }
                int select = JOptionPane.showConfirmDialog(null,
                        "您选择的是第三关，点击确定开始游戏", "选择确认",
                        JOptionPane.OK_CANCEL_OPTION);
                if (select == JOptionPane.OK_OPTION) {
                    if (control.isStart()) {
                        // 恢复游戏
                        commond.gameEventStop(resource);
                    }
                    context.startGame();
                    control.setLevel(3);
                    //this.setVisible(true);
                } else {
                    if (control.isStart()) {
                        // 恢复游戏
                        commond.gameEventStop(resource);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "请先点击游戏Game菜单下的开始游戏", "提示",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if ("fourth".equals(e.getActionCommand())) {
            if (control.isStart()) {
                if (!control.isStop()) {// 暂停游戏
                    commond.gameEventStop(resource);
                }
                int select = JOptionPane.showConfirmDialog(null,
                        "您选择的是第四关，点击确定开始游戏", "选择确认",
                        JOptionPane.OK_CANCEL_OPTION);
                if (select == JOptionPane.OK_OPTION) {
                    if (control.isStart()) {
                        // 恢复游戏
                        commond.gameEventStop(resource);
                    }
                    context.startGame();
                    control.setLevel(4);
                    //this.setVisible(true);
                } else {
                    if (control.isStart()) {
                        // 恢复游戏
                        commond.gameEventStop(resource);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "请先点击游戏Game菜单下的开始游戏", "提示",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if ("fifth".equals(e.getActionCommand())) {
            if (control.isStart()) {
                if (!control.isStop()) {// 暂停游戏
                    commond.gameEventStop(resource);
                }
                int select = JOptionPane.showConfirmDialog(null,
                        "您选择的是第五关，点击确定开始游戏", "选择确认",
                        JOptionPane.OK_CANCEL_OPTION);
                if (select == JOptionPane.OK_OPTION) {
                    if (control.isStart()) {
                        // 恢复游戏
                        commond.gameEventStop(resource);
                    }
                    context.startGame();
                    control.setLevel(5);
                    //this.setVisible(true);
                } else {
                    if (control.isStart()) {
                        // 恢复游戏
                        commond.gameEventStop(resource);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "请先点击游戏Game菜单下的开始游戏", "提示",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if ("gameHelp".equals(e.getActionCommand())) {
            JOptionPane
                    .showMessageDialog(
                            null,
                            "坦克移动:---方向键---\n坦克开炮:------X键------\n每关只要打掉敌人8辆坦克即可过关，\n第五关有5辆坦克同时在地图上",
                            "游戏帮助", JOptionPane.INFORMATION_MESSAGE);
        } else if ("aboutGame".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(null,
                    "JAVA坦克大战CP版1.0\n作者:hdu-chenpi\n", "关于游戏",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}