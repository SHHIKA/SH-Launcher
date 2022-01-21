package org.shika.shlauncher.Lib.setting;

import java.io.Serializable;

public class Data implements Serializable {
    private String name;
    private String command;

    private String KeyName;
    private int Modifier;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setKeyName(String keyName) {
        KeyName = keyName;
    }

    public String getKeyName() {
        return KeyName;
    }

    public void setModifier(int modifier) {
        Modifier = modifier;
    }

    public int getModifier() {
        return Modifier;
    }
}
