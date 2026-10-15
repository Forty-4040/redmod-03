RedMod: красная кнопка (Fabric 1.20.1, GeckoLib 4.4.9)

ЗАПУСК
1. Установи JDK 17 (Temurin) и IntelliJ IDEA Community.
2. IntelliJ: File -> Open -> выбери эту папку (redmod-project) -> Trust Project.
3. Подожди, пока снизу закончится загрузка Gradle (первый раз 5-15 минут).
   Если IntelliJ спросит про Gradle JVM, выбери JDK 17.
4. Справа вкладка Gradle -> Tasks -> fabric -> runClient (или зелёная кнопка Run рядом с "Minecraft Client").
5. В игре: креатив, вкладка "Функциональные блоки" (там предмет), либо команда
   /give @s redmod:red_button_item
   /summon redmod:red_button

СБОРКА .JAR ДЛЯ ДРУГА
Вкладка Gradle -> Tasks -> build -> build. Готовый файл: build/libs/redmod-1.0.0.jar
(файл с "-sources" в названии не нужен).
Другу нужны: Minecraft 1.20.1, Fabric Loader, Fabric API. GeckoLib уже внутри .jar.

ГДЕ ЧТО ПОДГОНЯТЬ
- Хитбокс: ModEntities.java (HITBOX_WIDTH, HITBOX_HEIGHT)
- Прыжки, лечение, задержка нажатия: entity/RedButtonEntity.java (блок "Настройки" вверху)
- Положение и размер шлема: client/RedButtonRenderer.java (HELMET_SCALE, HELMET_OFFSET_*)
- Модель, анимации, текстура: src/main/resources/assets/redmod/...
