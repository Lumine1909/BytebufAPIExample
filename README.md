Example plugin for bytebuf api of leaves server<br>

Usage:
```
    // Send Packet
    Bytebuf buf = Bytebuf.buf(512).writeLong(gameTime).writeLong(gameTime % 24000); // gameTime, dayTime
    player.sendPacket(buf, PacketType.ClientboundSetTime);
    
    /* Alternatively:
    Bytebuf buf = Bytebuf.buf();
    buf.writeLong(gameTime).writeLong(gameTime % 24000);
    Packet packet = new Packet(PacketType.ClientboundSetTime, buf);
    player.sendPacket(packet);
    */
    
    
    // Listen Packet
    Bukkit.getBytebufManager().registerListener(this, new PacketListener() {
        @Override
        public Packet onPacketIn(Player player, Packet packet) {
            @Override
            public Packet onPacketIn(Player player, Packet packet) {
                if (packet.type() == PacketType.ServerboundChatCommand) {
                    getLogger().info("Player " + player.getName() + " sent a command: " + packet.bytebuf().readUTFString());
                }
                return packet;
            }
        }
        @Override
        public Packet onPacketOut(Player player, Packet packet) {
            if (packet.type() == PacketType.ClientboundSystemChat) {
                getLogger().info("Player " + player.getName() + " received a message");
            }
            return packet;
        }
    });

```