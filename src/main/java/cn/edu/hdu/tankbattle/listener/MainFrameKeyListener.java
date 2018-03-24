/*
 * Copyright (c) 2011-2025 PiChen.
 */

package cn.edu.hdu.tankbattle.listener;

import cn.edu.hdu.tankbattle.context.GameContext;
import cn.edu.hdu.tankbattle.enums.DirectionEnum;
import cn.edu.hdu.tankbattle.service.GameEventService;
import cn.edu.hdu.tankbattle.dto.RealTimeGameData;
import cn.edu.hdu.tankbattle.dto.GameResource;
import cn.edu.hdu.tankbattle.model.Tank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class Description...
 *
 * @author chenpi
 * @since 2018/3/19 20:13
 */
@Component
public class MainFrameKeyListener implements KeyListener {
    @Autowired
    private GameEventService control;

    @Autowired
    private GameContext context;

    @Override
    public void keyPressed(KeyEvent e) {
        RealTimeGameData data = context.getGameData();
        GameResource resource = data.getGameResource();
        if (e.getKeyCode() == KeyEvent.VK_P) { // 暂停
            control.gameEventStop(resource);
        }

        resource.getMyTanks().forEach(myTank -> {
            if (!myTank.isLive()) {
                data.keyPressedDirect(false, false, false, false);
            } else {
                if ((e.getKeyCode() == KeyEvent.VK_UP)) {
                    myTank.setDirect(DirectionEnum.NORTH);
                    data.keyPressedDirect(true, false, false, false);

                } else if ((e.getKeyCode() == KeyEvent.VK_DOWN) && myTank.getY() <= 580) {
                    myTank.setDirect(DirectionEnum.SOUTH);
                    data.keyPressedDirect(false, true, false, false);

                } else if ((e.getKeyCode() == KeyEvent.VK_LEFT) && myTank.getY() <= 580) {
                    myTank.setDirect(DirectionEnum.WEST);
                    data.keyPressedDirect(false, false, true, false);

                } else if ((e.getKeyCode() == KeyEvent.VK_RIGHT) && myTank.getY() <= 580) {
                    myTank.setDirect(DirectionEnum.EAST);
                    data.keyPressedDirect(false, false, false, true);

                }
                if (e.getKeyCode() == KeyEvent.VK_X && myTank.getY() <= 580) {
                    if (myTank.getBullets().size() <= 1 && data.getMyBulletNum() > 0) {
                        data.setMyBulletNum(data.getMyBulletNum() - 1);
                        control.shot(myTank);
                    }
                }
            }
        });

    }

    @Override
    public void keyReleased(KeyEvent e) {
        RealTimeGameData data = context.getGameData();
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            data.setUp(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            data.setDown(false);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            data.setLeft(false);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            data.setRight(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
