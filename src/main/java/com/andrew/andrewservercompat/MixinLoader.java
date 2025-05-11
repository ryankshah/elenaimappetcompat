package com.andrew.andrewservercompat;

import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MixinLoader implements ILateMixinLoader {
    @Override
    public List<String> getMixinConfigs() {
        ArrayList<String> configs = new ArrayList<>();
        configs.add("mixins.andrewservercompat.json");
        return configs;
    }
}
