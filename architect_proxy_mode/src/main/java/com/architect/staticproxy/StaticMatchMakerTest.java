package com.architect.staticproxy;

public class StaticMatchMakerTest {
    public static void main(String[] args) {
        StaticMatchmaker matchmaker = new StaticMatchmaker(new ZhangSan());
        matchmaker.findLove();
    }
}
