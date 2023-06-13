# job4j_garbage_collection

Тестовый проект в котором тестируются различные сборщики мусора:

- Serial => -XX:+UseSerialGC

- Parallel => -XX:+UseParallelGC

- CMS => -XX:+UseConcMarkSweepGC (доступен до JDK 14)

- G1 => -XX:+UseG1GC

- ZGC => -XX:+UseZGC


