# roh-cli
java command line tool for making my life a a bit easier. 1. can try port, 2. can create project skeleton, 3. can create markdown syntax for folder structure (come with web interface)

# project structure

- dist/: for compiled .exe and whole jre 1.8_202
- roh-cli: command line interface wrapping around roh-core

# examples

```bash
# first arg: `ping` use check port open util
# second arg: domain name or ip
# third arg: port number
roh.bat ping rohim.cc 80

# first arg: `spf`, `splitfile` use splitfile util
# second arg: file path
# third arg: lines per file
roh.bat spf "D:\abc.sql" 50000
```