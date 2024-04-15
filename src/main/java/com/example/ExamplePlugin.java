package com.example;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import top.leavesmc.leaves.packet.Packet;
import top.leavesmc.leaves.packet.PacketType;
import top.leavesmc.leaves.packet.bytebuf.Bytebuf;

import java.util.Objects;

public class ExamplePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("clienttime")).setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            return true;
        }
        if (args.length < 1) {
            return true;
        }
        long gameTime;
        try {
            gameTime = Long.parseLong(args[0]);
        } catch (Exception e) {
            return true;
        }
        Bytebuf buf = new Bytebuf(256).writeLong(gameTime).writeLong(gameTime % 24000); // gameTime, dayTime
        player.sendPacket(buf, PacketType.ClientboundSetTime);
        /* Alternatively:
        Packet packet = new Packet(PacketType.ClientboundSetTime, buf);
        player.sendPacket(packet);
         */
        return true;
    }
}
