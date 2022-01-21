package org.shika.shlauncher.Lib;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.progcoa.pbjavautils.Console.Console;
import org.progcoa.pbjavautils.Data.configs.DatObject;
import org.progcoa.pbjavautils.KeyHook.KeyBoardEvent;
import org.progcoa.pbjavautils.SystemCall;
import org.shika.shlauncher.Lib.setting.Data;

import java.awt.event.KeyEvent;
import java.util.Map;

public class Key implements KeyBoardEvent {

    Map<String, Object> map = new DatObject("config.dat").getMap();

    @Override
    public void onPressed(NativeKeyEvent e) {
        Console.WriteLine(e.paramString());
        String str = NativeKeyEvent.getKeyText(e.getKeyCode());
        Console.WriteLine(str);

        if(e.getModifiers() != KeyEvent.ALT_MASK + KeyEvent.CTRL_MASK) return;

        if(map.get(str) != null){
            Data data = (Data) map.get(str);
            new SystemCall(data.getCommand()).Run();
        }
    }

    @Override
    public void onReleased(NativeKeyEvent e) {

    }

    @Override
    public void onTyped(NativeKeyEvent e) {

    }
}
