Example plugin for bytebuf api of leaves server<br>

Usageg:
```
    Bytebuf buf = Bukkit.newByteBuf().writeLong(gameTime).writeLong(gameTime % 24000); // gameTime, dayTime
    player.sendPacket(buf, PacketType.ClientboundSetTime);

    /* Alternatively:
    Bytebuf buf = Bukkit.newByteBuf();
    buf.writeLong(gameTime).writeLong(gameTime % 24000);
    Packet packet = buf.toPacket(PacketType.ClientboundSetTime);
    player.sendPacket(packet);
    */

```