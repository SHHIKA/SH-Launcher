package org.shika.shrancher.Lib;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.progcoa.pbjavautils.Console.Console;
import org.progcoa.pbjavautils.KeyHook.KeyBoardEvent;

import java.awt.event.KeyEvent;

public class Key implements KeyBoardEvent {

    @Override
    public void onPressed(NativeKeyEvent e) {
        Console.WriteLine(e.paramString());
    }

    @Override
    public void onReleased(NativeKeyEvent e) {

    }

    @Override
    public void onTyped(NativeKeyEvent e) {

    }
}
