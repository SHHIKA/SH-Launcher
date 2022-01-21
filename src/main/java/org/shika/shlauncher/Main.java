package org.shika.shlauncher;

import org.jnativehook.GlobalScreen;
import org.progcoa.pbjavautils.Console.Console;
import org.progcoa.pbjavautils.KeyHook.KeyHook;
import org.shika.shlauncher.Lib.Key;
import org.shika.shlauncher.Lib.Resource;
import org.shika.shlauncher.Lib.setting.setProperty;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        Console.WriteLine("SH-Launcher");

        if(args.length != 0 && args[0].equals("setting")){
            setProperty.Main();
            return;
        }

        GlobalScreen.addNativeKeyListener(new KeyHook(new Key()));
    }
}
