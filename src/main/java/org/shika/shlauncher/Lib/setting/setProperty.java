package org.shika.shlauncher.Lib.setting;

import org.progcoa.pbjavautils.Console.Color;
import org.progcoa.pbjavautils.Console.Console;
import org.progcoa.pbjavautils.Data.configs.DatObject;

import java.io.Serializable;
import java.util.Map;
import java.util.Scanner;

public class setProperty implements Serializable {
    private static final DatObject dat = new DatObject("config.dat");
    private static final DatObject names = new DatObject("names.dat");

    private static final Map<String, Object> name = names.getMap();
    private static final Map<String, Object> map = dat.getMap();
    private static Data data;

    public static void Main(){
        String input;
        do{
            input = Console.ReadLine();

            switch (input){
                case "help":
                    help();
                    break;

                case "set":
                    set();
                    break;

                case "list":
                    list();
                    break;

                case "save":
                    save();
                    break;

                case "delete":
                    delete();
                    break;

                default:
                    Console.WriteLine(Color.RED + "コマンドが存在しません : " + input);
                    break;
            }

        } while (!input.equals("!stop"));
    }

    private static void help(){
        Console.WriteLine(Color.GREEN + "コマンド");
        Console.WriteLine("set : ショートカットキーやコマンドを設定するコマンド");
        Console.WriteLine("list : 設定されているデータを表示するコマンド");
        Console.WriteLine("save : 設定したデータを保存するコマンド");
        Console.WriteLine("delete : 設定されているデータを削除するコマンド");
    }

    private static void set(){
        data = new Data();
        Console.WriteLine(Color.CYAN + "設定を始めます");
        Console.WriteLine("名前を入力してください(表示される名前)");
        String in = Console.ReadLine();
        data.setName(in);

        Console.WriteLine("コマンドを入力してください");
        String cmd = new Scanner(System.in).nextLine();
        data.setCommand(cmd);

        Console.WriteLine("ショートカットキーを設定します");
        Console.WriteLine("大文字のアルファベットまたは数字を入力してください");
        data.setKeyName(Console.ReadLine());
        Console.WriteLine("データを作成しました");

        map.put(data.getKeyName(), data);
        name.put(in, data.getKeyName());
    }

    private static void list(){
        for (Object d : map.values()){
            data = (Data) d;

            if(d != null){
                Console.WriteLine("[name: " + data.getName() + "] cmd: " + data.getCommand());
            }
        }
    }

    private static void save(){
        dat.setMap(map);
        names.setMap(name);

        dat.save();
        names.save();
    }

    private static void delete(){
        Console.WriteLine("削除するデータを選んでください");
        list();

        String input = Console.ReadLine();
        String Key = (String) name.get(input);
        name.put(input, null);
        map.put(Key, null);
    }
}
