package com.example;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.leavesmc.leaves.bytebuf.Bytebuf;
import org.leavesmc.leaves.bytebuf.packet.Packet;
import org.leavesmc.leaves.bytebuf.packet.PacketListener;
import org.leavesmc.leaves.bytebuf.packet.PacketType;

import java.util.Objects;

public class ExamplePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("clienttime")).setExecutor(this);
        Bukkit.getBytebufManager().registerListener(this, new PacketListener() {
            @Override
            public Packet onPacketIn(Player player, Packet packet) {
                return packet;
            }
            @Override
            public Packet onPacketOut(Player player, Packet packet) {
                if (packet.type() == PacketType.ClientboundSystemChat) {
                    getLogger().info("Player " + player.getName() + " received a message");
                }
                return packet;
            }
        });
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
        Bytebuf buf = Bytebuf.buf(512).writeLong(gameTime).writeLong(gameTime % 24000); // gameTime, dayTime
        player.sendPacket(buf, PacketType.ClientboundSetTime);
        /* Alternatively:
        Packet packet = new Packet(PacketType.ClientboundSetTime, buf);
        player.sendPacket(packet);
         */
        return true;
    }
}
