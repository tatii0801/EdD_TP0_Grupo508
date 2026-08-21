@echo off

if "%~1"=="" (
    echo Uso: run.bat ^<Nombre de la Clase^>
    echo Ejemplo: run.bat tp1.Reserva
    exit /b 1
)

set TARGET_CLASS=%1

shift
set EXEC_ARGS=
:loop
if "%~1"=="" goto done
set EXEC_ARGS=%EXEC_ARGS% %1
shift
goto loop
:done

mvn compile exec:java@run -DtargetClass="%TARGET_CLASS%" -Dexec.args="%EXEC_ARGS%"
