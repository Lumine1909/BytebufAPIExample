Example plugin for bytebuf api of leaves server<br>

Usage:
```
    Bytebuf buf = new ByteBuf().writeLong(gameTime).writeLong(gameTime % 24000); // gameTime, dayTime
    player.sendPacket(buf, PacketType.ClientboundSetTime);

    /* Alternatively:
    Bytebuf buf = new Bytebuf(256);
    buf.writeLong(gameTime).writeLong(gameTime % 24000);
    Packet packet = new Packet(PacketType.ClientboundSetTime, buf);
    player.sendPacket(packet);
    */

```