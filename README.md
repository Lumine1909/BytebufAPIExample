Example plugin for bytebuf api of leaves server<br>

```
    Bytebuf buf = Bukkit.newByteBuf().writeLong(gameTime).writeLong(gameTime % 24000); // gameTime, dayTime
    player.sendPacket(buf, PacketType.ClientboundSetTime);
```
