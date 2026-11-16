GAVAN INFINITY MOD - Forge 1.20.1 (47.x)
=========================================
วิธีใช้ (ง่ายสุด 4 ขั้น)
1. โหลด Forge MDK 1.20.1 จาก https://files.minecraftforge.net แล้วแตกไฟล์
2. คัดลอกโฟลเดอร์ "src" จาก zip นี้ ไปวางทับโฟลเดอร์ src ของ MDK (ลบ src/main/java/com/example ทิ้ง)
3. คัดลอก gradle.properties จาก zip นี้ไปวางทับของ MDK
4. เปิด terminal ในโฟลเดอร์ MDK แล้วรัน
     ./gradlew build        (Windows: gradlew.bat build)
   ได้ไฟล์ .jar ที่ build/libs/ -> วางใน mods ของ Minecraft Forge 1.20.1
   ทดสอบในเกมเลย: ./gradlew runClient

ต้องใช้ JDK 17

มีอะไรบ้าง
- Gavanium Ingot / Raw Gavanium / Gavanium Ore / Deepslate Ore / Block of Gavanium (เกิดในโลกชั้น y -64 ถึง 16)
- Laser Blade, Laser Zabeam (คลิกขวายิง)
- Gavan Armor 4 ชิ้น: ใส่ครบชุด = แปลงร่าง (Strength II, Speed II, Resistance, Jump II, กันไฟ, มองกลางคืน + เอฟเฟกต์แสง)
- Makuu Soldier (มอนสเตอร์ศัตรู, เกิดใน Overworld, ดรอป Gavanium) + Spawn Egg
- สูตรคราฟต์/เตาถลุงครบ, ภาษาอังกฤษ + ไทย

----- วิธีที่ง่ายกว่า: ให้ GitHub บิลด์ .jar ให้ (ไม่ต้องลง JDK/MDK) -----
1. สมัคร/ล็อกอิน github.com แล้วสร้าง Repository ใหม่ (Public หรือ Private ก็ได้)
2. กด "uploading an existing file" แล้วลากไฟล์/โฟลเดอร์ทั้งหมดในโฟลเดอร์นี้ขึ้นไป
   (ต้องมีโฟลเดอร์ .github, src และไฟล์ gradle.properties) แล้วกด Commit
3. ไปแท็บ Actions -> "Build Gavan Infinity jar" -> Run workflow (หรือรอให้รันเองหลัง commit)
4. รอ 3-5 นาทีจนขึ้นเครื่องหมายถูกสีเขียว กดเข้าไปแล้วโหลด "gavaninfinity-1.0.0" ที่หัวข้อ Artifacts
5. แตก zip ที่ได้ จะเจอ gavaninfinity-1.0.0.jar ให้วางในโฟลเดอร์ mods ของ CurseForge profile (Forge 1.20.1)
