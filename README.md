<div align="center">

# SConsoleFix

### Una consola limpia. Solo lo que importa.

Silencia el spam de mensajes inútiles y quédate con los logs que de verdad lees.

[![build](https://github.com/JhonTova/SConsoleFix/actions/workflows/build.yml/badge.svg)](https://github.com/JhonTova/SConsoleFix/actions/workflows/build.yml) [![release](https://img.shields.io/github/v/release/JhonTova/SConsoleFix?label=release)](https://github.com/JhonTova/SConsoleFix/releases/latest) ![Minecraft](https://img.shields.io/badge/Minecraft-1.21.11%2B-62B47A) ![Java](https://img.shields.io/badge/Java-21-E76F00)

</div>

---

## Características

- **Filtra el spam de la consola** con reglas sobre Log4j.
- Oculta los mensajes repetitivos y molestos que no aportan nada.
- Ligerísimo — actúa a nivel de logging, sin coste apreciable.
- Filtros configurables: tú decides qué se calla.

## Requisitos

Requiere **[SiriusCore](https://github.com/JhonTova/SiriusCore)**.

## Instalación

`SiriusCore.jar` + `SConsoleFix.jar` en `plugins/`. Spigot / Paper / Purpur 1.21.11+.

## Descarga

El `.jar` de cada versión está en [Releases](https://github.com/JhonTova/SConsoleFix/releases/latest).

## Compilar desde el código

Requiere Java 21 y Maven. SiriusCore no está en un repositorio Maven público, así que
primero se instala en local la versión que declara el `pom.xml`:

```bash
git clone --branch v1.1.1 https://github.com/JhonTova/SiriusCore.git
mvn -f SiriusCore/pom.xml install -DskipTests
mvn package        # en este repositorio; el .jar queda en target/
```

Cada push y pull request se compila en GitHub Actions. Al subir una tag `v*`, el `.jar`
se adjunta solo a la release.
