package org.shika.shrancher;

import org.jnativehook.GlobalScreen;
import org.progcoa.pbjavautils.Console.Console;
import org.progcoa.pbjavautils.KeyHook.KeyHook;
import org.shika.shrancher.Lib.Key;

public class Main {
    public static void main(String[] args) {
        Console.WriteLine("hello world");

        GlobalScreen.addNativeKeyListener(new KeyHook(new Key()));
    }
}
