@echo off

REM optional:
REM     set JAVA_HOME=D:\Installations\Java\jdk-17.0.8
REM     set PATH=%JAVA_HOME%\bin;%PATH%\


REM check if at least one parameter was provided
if "%~1"=="" (
    echo Usage: roh.bat arg1 arg2 ...
    exit /b 1
)

REM capture the first parameter
set "args=%~1"
REM shift the parameters to the left, discarding %1 and moving %2 to %1, and so on.
shift

REM Combine the rest of the parameters into a single variable
:loop
if "%~1"=="" goto endloop
REM %~1 alone removes surrounding quotes,
REM you should ensure the double quotes by using "%~1"
set "args=%args% "%~1""
shift
goto loop
:endloop

java -jar roh-cli.jar %args%
