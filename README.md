<div align="center">

# SConsoleFix

### Una consola limpia. Solo lo que importa.

Silencia el spam de mensajes inútiles y quédate con los logs que de verdad lees.

[![build](https://github.com/JhonTova/SConsoleFix/actions/workflows/build.yml/badge.svg)](https://github.com/JhonTova/SConsoleFix/actions/workflows/build.yml) [![release](https://img.shields.io/github/v/release/JhonTova/SConsoleFix?label=release)](https://github.com/JhonTova/SConsoleFix/releases/latest) ![Minecraft](https://img.shields.io/badge/Minecraft-1.21.11%2B-62B47A) ![Java](https://img.shields.io/badge/Java-21-E76F00)

</div>

---

## Características

- **Silencia el spam del servidor de sesiones de Mojang**: cuando falla o limita las
  peticiones, el servidor imprime errores repetidos (`Status: 429`,
  `Couldn't look up profile properties`, páginas de error en HTML, `Service unavailable`…).
  SConsoleFix los corta.
- Actúa como **filtro de Log4j**: esas líneas no llegan ni a la consola ni al archivo de log.
- **Sin configuración** y sin coste apreciable. El resto de mensajes no se toca.

## Requisitos

Requiere **[SiriusCore](https://github.com/JhonTova/SiriusCore)**.

## Instalación

`SiriusCore.jar` + `SConsoleFix.jar` en `plugins/`. Paper / Purpur 1.21.11+.

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

## Licencia

[MIT](LICENSE): puedes usarlo, modificarlo y redistribuirlo manteniendo el aviso de copyright.
Requiere SiriusCore, que tiene su propia licencia.
