@if "%DEBUG%" == "" @echo off

@rem Slurp the command line arguments.
set CMD_LINE_ARGS=%*

java -jar target/emmissionCalculator-jar-with-dependencies.jar  %CMD_LINE_ARGS%